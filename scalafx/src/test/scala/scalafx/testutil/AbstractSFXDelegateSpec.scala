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

import javafx.util.Builder
import scalafx.delegate.SFXDelegate

/**
 * Abstract class for SFXDelegate controls Spec tests with Builder subclasses tests.
 *
 * IMPORTANT: the second order parameters jfx2sfx and sfx2jfx have to be left unassigned in the derived class.
 * If compiler finds implicit conversion between JavaFX and ScalaFx (and back) it will assign the corresponding
 * implicit functions to those parameters. Make use that you provide implicit conversion include, for instance,
 * `import scalafx.Includes._`
 *
 * @tparam J JavaFX class
 * @tparam S SFXDelegate subclass related with JavaFX class
 * @tparam B JavaFX Builder subclass related with JavaFX class
 *
 * @param javaClass JavaFX class
 * @param scalaClass SFXDelegate subclass related with JavaFX class
 * @param javaBuilderClass Builder subclass related with JavaFX class
 * @param jfx2sfx Implicit conversion from JavaFX to ScalaFX, it should not be assigned,
 *                it has to be resolved automatically by the compiler.
 * @param sfx2jfx Implicit conversion from ScalaFX to JavaFX, it should not be assigned,
 *                it has to be resolved automatically by the compiler.
 *
 * @todo If B is made like a javafx.util.Builder (B &lt;: javafx.util.Builder[_]) scala compiler shows message: "type arguments
 * [javafx.scene.control.CheckBox,scalafx.scene.control.CheckBox,javafx.scene. control.CheckBoxBuilder[_] ] do not conform to class AbstractSFXDelegateSpec's
 * type parameter bounds [J &lt;: java.lang.Object,S &lt;: scalafx.util.SFXDelegate[J],B &lt;: javafx.util.Builder[_] ]". Only when remove B binding with Builder
 * compiler problems disappear. So it must be find a way to put bind between B and Builder without create problems with compiler.
 */
abstract class AbstractSFXDelegateSpec[J <: Object, S <: SFXDelegate[J], B](javaClass: Class[J], scalaClass: Class[S], javaBuilderClass: Class[B]) (implicit jfx2sfx: J => S = null, sfx2jfx: S => J = null)
  extends SimpleSFXDelegateSpec[J, S](javaClass, scalaClass) {

  it should "implement all the JavaFX builder properties" in {
    compareBuilderProperties(javaBuilderClass.asInstanceOf[Class[Builder[_]]], scalaClass)
  }

}