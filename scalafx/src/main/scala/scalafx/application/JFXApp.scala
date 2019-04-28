/*
 * Copyright (c) 2011-2019, ScalaFX Project
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

import javafx.application.Application
import javafx.{application => jfxa, stage => jfxs}
import scalafx.application.JFXApp.{Parameters, PrimaryStage}
import scalafx.delegate.SFXDelegate
import scalafx.stage.Stage

import scala.collection.JavaConverters._
import scala.collection.mutable.ListBuffer
import scala.collection.{Map, Seq, mutable}
import scala.language.implicitConversions

object JFXApp {

  var Stage: jfxs.Stage = _
  @deprecated("Prefer Scala naming convention over Java, use `Stage` instead.", "8.0.60-R10")
  def STAGE: jfxs.Stage = Stage
  @deprecated("Prefer Scala naming convention over Java, use `Stage` instead.", "8.0.60-R10")
  def STAGE_=(stage: jfxs.Stage): Unit = Stage = stage

  var ActiveApp: JFXApp = _
  @deprecated("Prefer Scala naming convention over Java, use `ActiveApp` instead.", "8.0.60-R10")
  def ACTIVE_APP: JFXApp = ActiveApp
  @deprecated("Prefer Scala naming convention over Java, use `ActiveApp` instead.", "8.0.60-R10")
  def ACTIVE_APP_=(app: JFXApp): Unit = ActiveApp = app

  private[application] var ActiveJFXApp: jfxa.Application = _

  var AutoShow: Boolean = true
  @deprecated("Prefer Scala naming convention over Java, use `AutoShow` instead.", "8.0.60-R10")
  def AUTO_SHOW: Boolean = true
  @deprecated("Prefer Scala naming convention over Java, use `AutoShow` instead.", "8.0.60-R10")
  def AUTO_SHOW_=(autoShow: Boolean): Unit = AutoShow = true

  /**
    * Regular expression for parsing name/value parameters.
    */
  private val keyValue =
    """^--([A-Za-z_][^=]*?)=(.*)$""".r

  object Parameters {
    implicit def sfxParameters2jfx(p: Parameters): Application.Parameters = if (p != null) p.delegate else null

    /**
      * Creates a new instance of Parameters
      */
    private[application] def apply(arguments: Seq[String]): Parameters =
      if (arguments.isEmpty) EmptyParameters else new ParametersImpl(arguments)

  }

  /**
    * Wraps
    * [[http://docs.oracle.com/javase/8/javafx/api/javafx/application/Application.Parameters.html Application.Parameters]]
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
    private var unnamedArguments = mutable.Buffer.empty[String]
    private var filled                                      = false

    private def parseArguments(): Unit = {
      if (!filled) {
        arguments.foreach(arg =>
          keyValue.findFirstMatchIn(arg) match {
            case None => unnamedArguments += arg
            case Some(matcher) => namedArguments(matcher.group(1)) = matcher.group(2)
          })
        filled = true
      }
    }

    def raw: Seq[String] = arguments

    def named: mutable.Map[String, String] = {
      parseArguments()
      namedArguments
    }

    def unnamed: mutable.Buffer[String] = {
      parseArguments()
      unnamedArguments
    }

    lazy val delegate: Application.Parameters = new jfxa.Application.Parameters {
      def getRaw: java.util.List[String] = raw.asJava

      def getNamed: java.util.Map[String, String] = named.asJava

      def getUnnamed: java.util.List[String] = unnamed.asJava
    }

  }

  /**
    * Get the user agent stylesheet used by the whole application.
    * This is used to provide default styling for all ui controls and other nodes.
    * A value of null means the platform default stylesheet is being used.
    *
    * NOTE: This method must be called on the JavaFX Application Thread.
    *
    * @return The URL to the stylesheet as a String.
    */
  def userAgentStylesheet: String = jfxa.Application.getUserAgentStylesheet

  /**
    * Set the user agent stylesheet used by the whole application.
    * This is used to provide default styling for all ui controls and other nodes.
    * Each release of JavaFX may have a new default value for this so if you need to guarantee consistency you will
    * need to call this method and choose what default you would like for your application.
    * A value of null will restore the platform default stylesheet.
    * This property can also be set on the command line with -Djavafx.userAgentStylesheetUrl=[URL]
    * Setting it on the command line overrides anything set using this method in code.
    *
    * NOTE: This method must be called on the JavaFX Application Thread.
    *
    * @param url  The URL to the stylesheet as a String.
    */
  def userAgentStylesheet_=(url: String): Unit = jfxa.Application.setUserAgentStylesheet(url)


  /**
    * Empty parameters for an application
    */
  private[application] object EmptyParameters extends Parameters {
    def raw = Seq.empty[String]
    def named = Map.empty[String, String]
    def unnamed = Seq.empty[String]

    lazy val delegate: Application.Parameters = new jfxa.Application.Parameters {
      def getRaw: java.util.List[String] = raw.asJava

      def getNamed: java.util.Map[String, String] = named.asJava

      def getUnnamed: java.util.List[String] = unnamed.asJava
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
  class PrimaryStage extends Stage(JFXApp.Stage)

}

/** ScalaFX applications can extend JFXApp to create properly initialized JavaFX applications.
  *
  * On the back end `JFXApp` first calls [[http://docs.oracle.com/javase/8/javafx/api/javafx/application/Application.html#launch javafx.application.Application.launch]] then executes body of its
  * constructor when
  * [[http://docs.oracle.com/javase/8/javafx/api/javafx/application/Application.html#start(javafx.stage.Stage) javafx.application.Application.start(primaryStage:Stage)]]
  * is called. Here is an example use:
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
trait JFXApp extends DelayedInit {

  // Since JFXApp is now a trait, it is immune from the behavior of the DelayedInit marker trait. All JFXApp
  // initialization code is executed immediately, rather than being passed to delayedInit() and executed when init() is
  // called during JavaFX application startup. Put non-essential initialization in main() prior to the application
  // startup.

  /** JFXApp stage must be an instance of [[scalafx.application.JFXApp.PrimaryStage]] to ensure that it
    * actually is a proper wrapper for the primary stage supplied by JavaFX. */
  var stage: PrimaryStage = _

  private var arguments: Seq[String] = _

  /** Buffer code (constructor/initialization code) for all classes & objects that implement JFXApp. This code is
    * passed in through compiler-generated calls to delayedInit. The resulting code is then executed - in the same
    * order - in main. (Note that traits inheriting or mixed in with JFXApp have their initialization performed
    * immediately. See [[scala.DelayedInit]] for more information.
    */
  private val subClassInitCode = new ListBuffer[() => Unit]

  /**
    * Set of parameters for an application
    */
  protected lazy val parameters: Parameters = Parameters(arguments)

  /** Add class/object construction/initialization code to the code execution buffer.
    *
    * This function is called multiple times (by the Scala compiler) with the initialization/construction code of each
    * class and object (but not trait!) that extends JFXApp. This code is buffered until it can be executed in main().
    *
    * @note You are strongly advised not to override this function.
    *
    * @param x Class/object construction code to be buffered for delayed execution.
    */
  def delayedInit(x: => Unit): Unit = {
    subClassInitCode += (() => x)
  }

  /** Perform app-related initialization, and execute initialization/construction code for all classes and objects that
    * extend this trait.
    *
    * @note You are strongly advised not to override this function.
    *
    * @param args Command line arguments.
    */
  def main(args: Array[String]): Unit = {
    JFXApp.ActiveApp = this
    arguments = args
    // Put any further non-essential initialization here.
    /* Launch the JFX application.
    */
    jfxa.Application.launch(classOf[AppHelper], args: _*)
  }

  /** Perform sub-class initialization when directed to duing application startup.
    *
    * Execute the construction/initialization code of all classes/objects that extend JFXApp, that was earlier passed
    * to delayedInit() by the compiler.
    */
  private[application] final def init(): Unit = for (initCode <- subClassInitCode) initCode()

  def hostServices: HostServices = ApplicationIncludes.jfxHostServices2sfx(JFXApp.ActiveJFXApp.getHostServices)

  /**
    * This method is called when the application should stop, and provides a convenient place to prepare
    * for application exit and destroy resources.
    *
    * It is called from javafx.Application.stop method.
    * The implementation of this method provided by the JFXApp class does nothing.
    *
    * NOTE: This method is called on the JavaFX Application Thread, the same as javafx.Application.stop method.
    */
  def stopApp(): Unit = {
  }
}
