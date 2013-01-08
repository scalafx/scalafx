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
package scalafx.scene.effect

import javafx.scene.{ effect => jfxse }
import scalafx.Includes._
import scalafx.delegate.SFXDelegate

object Reflection {
  implicit def sfxReflection2jfx(r: Reflection) = r.delegate
}

class Reflection(override val delegate: jfxse.Reflection = new jfxse.Reflection)
  extends Effect(delegate)
  with InputDelegate[jfxse.Reflection]
  with SFXDelegate[jfxse.Reflection] {

  /**
   * Creates a new instance of Reflection with the specified topOffset, fraction, topOpacity and bottomOpacity.
   */
  def this(topOffset: Double, fraction: Double, topOpacity: Double, bottomOpacity: Double) = this(new jfxse.Reflection(topOffset, fraction, topOpacity, bottomOpacity))

  /**
   * The bottom opacity value, which is the opacity of the reflection at its bottom extreme.
   */
  def bottomOpacity = delegate.bottomOpacityProperty
  def bottomOpacity_=(v: Double) {
    bottomOpacity() = v
  }

  /**
   * The fraction of the input that is visible in the reflection.
   */
  def fraction = delegate.fractionProperty
  def fraction_=(v: Double) {
    fraction() = v
  }

  /**
   * The top offset adjustment, which is the distance between the bottom of the input and the top of the reflection.
   */
  def topOffset = delegate.topOffsetProperty
  def topOffset_=(v: Double) {
    topOffset() = v
  }

  /**
   * The top opacity value, which is the opacity of the reflection at its top extreme.
   */
  def topOpacity = delegate.topOpacityProperty
  def topOpacity_=(v: Double) {
    topOpacity() = v
  }

}