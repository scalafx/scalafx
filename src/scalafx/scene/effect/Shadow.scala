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
import scalafx.scene.paint.Color
import scalafx.util.DimensionDelegate
import scalafx.util.SFXDelegate

object Shadow {
  implicit def sfxShadow2jfx(s: Shadow) = s.delegate
}

/**
 * Wraps [[http://docs.oracle.com/javafx/2/api/javafx/scene/effect/Shadow.html]].
 */
class Shadow(override val delegate: jfxse.Shadow = new jfxse.Shadow)
  extends Effect(delegate)
  with ColorDelegate[jfxse.Shadow]
  with InputDelegate[jfxse.Shadow]
  with DimensionDelegate[jfxse.Shadow]
  with SFXDelegate[jfxse.Shadow] {

  /**
   * Creates a new instance of Shadow with the specified blurType, color, radius.
   */
  def this(blurType: jfxse.BlurType, color: Color, radius: Double) = this(new jfxse.Shadow(blurType, color, radius))

  /**
   * Creates a new instance of Shadow with specified radius and color.
   */
  def this(radius: Double, color: Color) = this(new jfxse.Shadow(radius, color))

  /**
   * The algorithm used to blur the shadow.
   */
  def blurType = delegate.blurTypeProperty
  def blurType_=(v: jfxse.BlurType) {
    blurType() = v
  }

  /**
   * The radius of the shadow blur kernel.
   */
  def radius = delegate.radiusProperty
  def radius_=(v: Double) {
    radius() = v
  }

}