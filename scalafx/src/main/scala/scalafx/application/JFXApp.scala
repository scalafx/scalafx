/*
 * Copyright (c) 2011, ScalaFX Project
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of the ScalaFX Project nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE SCALAFX PROJECT OR ITS CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
 * AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package scalafx.application

import scala.collection.JavaConversions.mapAsJavaMap
import scala.collection.JavaConversions.seqAsJavaList
import scala.collection.mutable.Buffer
import scala.collection.Map
import scala.collection.Seq
import scala.collection.mutable

import javafx.{ application => jfxa }
import javafx.{ stage => jfxs }
import scalafx.application.JFXApp.{PrimaryStage, Parameters}
import scalafx.stage.Stage
import scalafx.delegate.SFXDelegate

object JFXApp {
  var STAGE: jfxs.Stage = null
  var ACTIVE_APP: JFXApp = null
  var AUTO_SHOW = true

  /**
   * Regular expression for parsing name/value parameters. 
   */
  private val keyValue = """^--([A-Za-z_][^=]*?)=(.*)$""".r

  object Parameters {
    implicit def sfxParameters2jfx(p: Parameters) = p.delegate

    /**
     * Creates a new instance of Parameters
     */
    private[application] def apply(arguments: Seq[String]): Parameters =
      if (arguments.isEmpty) EmptyParameters else new ParametersImpl(arguments)

  }

  /**
   * Wraps
   * [[http://docs.oracle.com/javafx/2/api/javafx/application/Application.Parameters.html Application.Parameters]]
   * class.
   */
  abstract class Parameters extends SFXDelegate[jfxa.Application.Parameters] {

    /**
     * Retrieves a read-only map of the named parameters.
     */
    def named: Map[String, String]

    /**
     * Retrieves a read-only list of the raw arguments.
     */
    def raw: Seq[String]

    /**
     * Retrieves a read-only list of the unnamed parameters.
     */
    def unnamed: Seq[String]

  }

  /**
   * Default implementation for Parameters class.
   */
  private[application] class ParametersImpl(arguments: Seq[String]) extends Parameters {

    private var namedArguments: mutable.Map[String, String] = mutable.Map.empty[String, String]
    private var unnamedArguments = Buffer.empty[String]
    private var filled = false

    private def parseArguments() {
      if (!filled) {
        arguments.foreach(arg =>
          keyValue.findFirstMatchIn(arg) match {
            case None          => unnamedArguments += arg
            case Some(matcher) => namedArguments(matcher.group(1)) = matcher.group(2)
          })
        filled = true
      }
    }

    def raw = arguments

    def named = {
      parseArguments()
      namedArguments
    }

    def unnamed = {
      parseArguments()
      unnamedArguments
    }

    lazy val delegate = new jfxa.Application.Parameters {
      def getRaw = raw
      def getNamed = named
      def getUnnamed = unnamed
    }

  }

  /**
   * Empty parameters for an application
   */
  private[application] object EmptyParameters extends Parameters {
    def raw = Seq.empty[String]
    def named = Map.empty[String, String]
    def unnamed = Seq.empty[String]
    lazy val delegate = new jfxa.Application.Parameters {
      def getRaw = raw
      def getNamed = named
      def getUnnamed = unnamed
    }
  }

  /** Simple helper class for construction of primary application stages.
    *
    * The primary stage has to wrap an instance of a JavaFX primary stage created by JavaFX when application
    * is initialized.
    *
    * {{{
    *   object SimpleScalaFXApp extends JFXApp {
    *      stage = new PrimaryStage {
    *        title = "Simple ScalaFX App"
    *        scene = new Scene {
    *          root = new StackPane {
    *            padding = Insets(20)
    *            content = new Rectangle {
    *              width = 200
    *              height = 200
    *              fill = Color.DEEPSKYBLUE
    *            }
    *          }
    *        }
    *      }
    *   }
    * }}}
    */
  class PrimaryStage extends Stage(JFXApp.STAGE)
}

/** ScalaFX applications can extend JFXApp to create properly initialized JavaFX applications.
  *
  * On the back end `JFXApp` first calls [[javafx.application.Application.launch]] then executes body of its
  * constructor when [[javafx.application.Application#start(primaryStage:Stage)]] is called. Here is an example use:
  *
  * {{{
  *   object SimpleScalaFXApp extends JFXApp {
  *      stage = new PrimaryStage {
  *        title = "Simple ScalaFX App"
  *        scene = new Scene {
  *          root = new StackPane {
  *            padding = Insets(20)
  *            content = new Rectangle {
  *              width = 200
  *              height = 200
  *              fill = Color.DEEPSKYBLUE
  *            }
  *          }
  *        }
  *      }
  *   }
  * }}}
  *
 */
class JFXApp extends DelayedInit {
  /** JFXApp stage must be an instance of [[scalafx.application.JFXApp.PrimaryStage]] to ensure that it
    * actually is a proper wrapper for the primary stage supplied by JavaFX. */
  var stage: PrimaryStage = null

  private var arguments: Seq[String] = _

  def main(args: Array[String]) {
    JFXApp.ACTIVE_APP = this
    arguments = args
    jfxa.Application.launch(classOf[AppHelper], args: _*)
  }

  /**
   *  Set of parameters for an application
   */
  protected lazy val parameters: Parameters = Parameters(arguments)

  var init: () => Unit = null

  def delayedInit(x: => Unit) {
    init = () => x
  }

  /**
   *  This method is called when the application should stop, and provides a convenient place to prepare
   *  for application exit and destroy resources.
   *
   *  It is called from javafx.Application.stop method.
   *  The implementation of this method provided by the JFXApp class does nothing.
   *
   *  NOTE: This method is called on the JavaFX Application Thread, the same as javafx.Application.stop method.
   */
  def stopApp() {
  }
}
