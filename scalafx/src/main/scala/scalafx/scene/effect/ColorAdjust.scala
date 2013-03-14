/*
* Copyright (c) 2012-2013, ScalaFX Project
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

import javafx.scene.{effect => jfxse}
import scalafx.Includes._
import scalafx.beans.property.DoubleProperty
import scalafx.delegate.SFXDelegate

object ColorAdjust {
  implicit def sfxColorAdjust2jfx(ca: ColorAdjust) = ca.delegate
}

class ColorAdjust(override val delegate: jfxse.ColorAdjust = new jfxse.ColorAdjust)
  extends Effect(delegate)
  with InputDelegate[jfxse.ColorAdjust]
  with SFXDelegate[jfxse.ColorAdjust] {

  /**
   * Creates a new instance of ColorAdjust with the specified hue, saturation, brightness, and contrast.
   */
  def this(hue: Double, saturation: Double, brightness: Double, contrast: Double) = this(new jfxse.ColorAdjust(hue, saturation, brightness, contrast))

  /**
   * The brightness adjustment value.
   */
  def brightness: DoubleProperty = delegate.brightnessProperty
  def brightness_=(v: Double) {
    brightness() = v
  }

  /**
   * The contrast adjustment value.
   */
  def contrast: DoubleProperty = delegate.contrastProperty
  def contrast_=(v: Double) {
    contrast() = v
  }

  /**
   * The hue adjustment value.
   */
  def hue: DoubleProperty = delegate.hueProperty
  def hue_=(v: Double) {
    hue() = v
  }

  /**
   * The saturation adjustment value.
   */
  def saturation: DoubleProperty = delegate.saturationProperty
  def saturation_=(v: Double) {
    saturation() = v
  }

}