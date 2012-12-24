/*
 * Copyright (c) 2012, ScalaFX Project
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
package scalafx.testutil

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers._

import scalafx.util.SFXDelegate

/**
 * Base class for SFXDelegate controls Spec tests. This spefic class tests if implicit conversion are working and if 
 * static methods are being implemented.
 *
 *
 * @tparam J JavaFX class to be wrapped by SFXDelegate class
 * @tparam S SFXDelegate subclass who will wrap JavaFX class
 *
 * @param javaClass JavaFX class
 * @param scalaClass SFXDelegate subclass related with JavaFX class
 *
 */
abstract class SFXDelegateSpec[J <: Object, S <: SFXDelegate[J]] protected (javaClass: Class[J], scalaClass: Class[S])
  extends FlatSpec 
  with AbstractComparator {
  
  /////////////////////////////
  // PROTECTED METHODS - BEGIN 
  /////////////////////////////

  /**
   * Returns a new SFXDelegate subclass instance. By default calls scalaClass constructor that uses delegated class 
   * instance. If it is not possible use this constructor, this method must be overrided.
   * {{{
   * override protected def getScalaClassInstance = new BoundingBox(0, 0, 0, 0)
   * }}}
   */
  protected def getScalaClassInstance: S =
    scalaClass.getConstructor(javaClass).newInstance(this.getJavaClassInstance)

  /**
   * Returns a SFXDelegate instance as JavaFX object
   * {{{
   * protected def convertScalaClassToJavaClass(sfxControl: Separator) = {
   *   val jfxSeparator: jfxsc.Separator = sfxControl
   *   jfxSeparator
   * }
   * }}}
   */
  protected def convertScalaClassToJavaClass(sfxObject: S): J

  /**
   * Returns a new JavaFX class instance. By default calls newInstance method from javaClass. If
   * this class has no default constructor, this method must be overrided:
   * {{{
   * override protected def getJavaClassInstance = new jfxg.BoundingBox(0, 0, 0, 0, 0, 0)
   * }}}
   */
  protected def getJavaClassInstance: J = javaClass.newInstance

  /**
   * Returns a JavaFX instance as a SFXDelegate object
   * {{{
   * protected def convertJavaClassToScalaClass(jfxControl: jfxsc.Separator) = {
   *   val sfxSeparator: Separator = jfxControl
   *   sfxSeparator
   * }
   * }}}
   */
  protected def convertJavaClassToScalaClass(jfxObject: J): S

  ///////////////////////////
  // PROTECTED METHODS - END 
  ///////////////////////////


  // Tests - Begin

  "A %s".format(scalaClass.getSimpleName) should "have an implicit conversion from SFX to JFX" in {
    val sfxObject = getScalaClassInstance
    val jfxObject: J = convertScalaClassToJavaClass(sfxObject)

    jfxObject should be(sfxObject.delegate)
  }

  it should "have an implicit conversion from JFX to SFX" in {
    val jfxObject = getJavaClassInstance
    val sfxObject: S = convertJavaClassToScalaClass(jfxObject)

    sfxObject.delegate should be(jfxObject)
  }

  it should "declare all public static methods of " + javaClass.getName in {
    compareStaticMethods(javaClass, scalaClass)
  }

  // Tests - End

}