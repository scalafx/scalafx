/*
 * Copyright (c) 2011-2013, ScalaFX Project
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

import scalafx.delegate.SFXDelegate

/**
 * Base class for SFXDelegate controls Spec tests. This specific class tests if implicit conversion are working and if
 * static methods are being implemented.
 *
 * IMPORTANT: the second order parameters jfx2sfx and sfx2jfx have to be left unassigned in the derived class.
 * If compiler finds implicit conversion between JavaFX and ScalaFx (and back) it will assign the corresponding
 * implicit functions to those parameters. Make use that you provide implicit conversion include, for instance,
 * `import scalafx.Includes._`
 *
 * @tparam J JavaFX class to be wrapped by SFXDelegate class
 * @tparam S SFXDelegate subclass who will wrap JavaFX class
 *
 * @param javaClass JavaFX class
 * @param scalaClass SFXDelegate subclass related with JavaFX class
 * @param jfx2sfx Implicit conversion from JavaFX to ScalaFX, it should not be assigned,
 *                it has to be resolved automatically by the compiler.
 * @param sfx2jfx Implicit conversion from ScalaFX to JavaFX, it should not be assigned,
 *                it has to be resolved automatically by the compiler.
 *
 */
abstract class SFXDelegateSpec[J <: Object, S <: SFXDelegate[J]] protected (javaClass: Class[J], scalaClass: Class[S])(implicit jfx2sfx: J => S = null, sfx2jfx: S => J = null)
  extends FlatSpec
  with AbstractComparator {

  /////////////////////////////
  // PROTECTED METHODS - BEGIN 
  /////////////////////////////

  /**
   * Returns a new SFXDelegate subclass instance. By default calls scalaClass constructor that uses delegated class
   * instance. If it is not possible use this constructor, this method must be overridden.
   * {{{
   * override protected def getScalaClassInstance = new BoundingBox(0, 0, 0, 0)
   * }}}
   */
  protected def getScalaClassInstance: S =
    scalaClass.getConstructor(javaClass).newInstance(this.getJavaClassInstance)

  /**
   * Returns a new JavaFX class instance. By default calls newInstance method from javaClass. If
   * this class has no default constructor, this method must be overridden:
   * {{{
   * override protected def getJavaClassInstance = new jfxg.BoundingBox(0, 0, 0, 0, 0, 0)
   * }}}
   */
  protected def getJavaClassInstance: J = javaClass.newInstance

  ///////////////////////////
  // PROTECTED METHODS - END 
  ///////////////////////////

  /////////////////
  // TESTS - BEGIN 
  /////////////////

  "A %s".format(scalaClass.getSimpleName) should "have an implicit conversion from SFX to JFX" in {
    // Test if the implicit conversion exists
    assert(sfx2jfx != null, "There is no implicit conversion from ScalaFX to JavaFX")

    // Test if conversion behaves correctly
    val sfxObject = getScalaClassInstance
    val jfxObject: J = sfxObject

    jfxObject should be(sfxObject.delegate)
  }

  it should "have an implicit conversion from JFX to SFX" in {
    // Test if the implicit conversion exists
    assert(jfx2sfx != null, "There is no implicit conversion from JavaFX to ScalaFX")

    // Test if conversion behaves correctly
    val jfxObject = getJavaClassInstance
    val sfxObject: S = jfxObject

    sfxObject.delegate should be(jfxObject)
  }

  it should "declare all public static methods of " + javaClass.getName in {
    compareStaticMethods(javaClass, scalaClass)
  }

  ///////////////
  // TESTS - END  
  ///////////////

}