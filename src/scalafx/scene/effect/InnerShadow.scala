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

import scalafx.Includes._
import javafx.scene.{ effect => jfxse }
import scalafx.util.SFXDelegate
import scalafx.scene.paint.Color

object InnerShadow {
  implicit def sfxInnerShadow2jfx(ii: InnerShadow) = ii.delegate
}

class InnerShadow(override val delegate: jfxse.InnerShadow = new jfxse.InnerShadow) extends Effect(delegate) with InputedEffect with SFXDelegate[jfxse.InnerShadow] {

  def this(blurType: jfxse.BlurType, color: Color, radius: Double, choke: Double, offsetX: Double, offsetY: Double) = this(new jfxse.InnerShadow(blurType, color, radius, choke, offsetX, offsetY))

  def this(radius: Double, color: Color) = this(new jfxse.InnerShadow(radius, color))

  def inputed = delegate.asInstanceOf[jfxse.Effect with Inputed]

  /**
   * The algorithm used to blur the shadow.
   */
  def blurType = delegate.blurTypeProperty
  def blurType_=(v: jfxse.BlurType) {
    blurType() = v
  }

  /**
   * The choke of the shadow.
   */
  def choke = delegate.chokeProperty
  def choke_=(v: Double) {
    choke() = v
  }

  /**
   * The shadow Color.
   */
  def color = delegate.colorProperty
  def color_=(v: Color) {
    color() = v
  }

  /**
   * The vertical size of the shadow blur kernel.
   */
  def height = delegate.heightProperty
  def height_=(v: Double) {
    height() = v
  }

  /**
   * The shadow offset in the x direction, in pixels.
   */
  def offsetX = delegate.offsetXProperty
  def offsetX_=(v: Double) {
    offsetX() = v
  }

  /**
   * The shadow offset in the y direction, in pixels.
   */
  def offsetY = delegate.offsetYProperty
  def offsetY_=(v: Double) {
    offsetY() = v
  }

  /**
   * The radius of the shadow blur kernel.
   */
  def radius = delegate.radiusProperty
  def radius_=(v: Double) {
    radius() = v
  }

  /**
   * The horizontal size of the shadow blur kernel.
   */
  def width = delegate.widthProperty
  def width_=(v: Double) {
    width() = v
  }

}