/*
 * Copyright (c) 2011-2020, ScalaFX Project
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
package scalafx.css

import javafx.{css => jfxcss}
import scalafx.css.CssIncludes.jfxPseudoClass2sfx
import scalafx.delegate.SFXDelegate

import scala.language.implicitConversions

/**
 * Companion object for [[scalafx.css.PseudoClass]].
 */
object PseudoClass {

  /**
   * Converts a ScalaFX PseudoClass to its JavaFX counterpart.
   *
   * @param v
   *   ScalaFX PseudoClass
   * @return
   *   JavaFX PseudoClass
   */
  implicit def sfxPseudoClass2jfx(v: PseudoClass): jfxcss.PseudoClass = if (v != null) v.delegate else null

  /**
   * There is only one PseudoClass instance for a given pseudoClass.
   *
   * @param pseudoClass
   *   PseudoClass name
   * @return
   *   The PseudoClass for the given pseudoClass. Will not return null.
   */
  def apply(pseudoClass: String): PseudoClass =
    jfxcss.PseudoClass.getPseudoClass(pseudoClass)

}

/**
 * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/css/PseudoClass.htmlJavaFX PseudoClass]].
 *
 * @constructor
 *   Creates a new ScalaFX PseudoClass from its JavaFX counterpart.
 * @param delegate
 *   JavaFX PseudoClass.
 *
 * @since
 *   8.0
 */
abstract class PseudoClass(override val delegate: jfxcss.PseudoClass) extends SFXDelegate[jfxcss.PseudoClass] {

  /**
   * There is only one `PseudoClass` instance for a given pseudoClass.
   */
  def pseudoClassName: String = delegate.getPseudoClassName

}
