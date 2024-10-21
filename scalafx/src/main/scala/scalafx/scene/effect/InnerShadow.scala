/*
 * Copyright (c) 2011-2024, ScalaFX Project
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
import scalafx.beans.property.{DoubleProperty, ObjectProperty}
import scalafx.delegate.{DimensionDelegate, SFXDelegate}
import scalafx.scene.paint.Color

import scala.language.implicitConversions

object InnerShadow {
  implicit def sfxInnerShadow2jfx(ii: InnerShadow): jfxse.InnerShadow = if (ii != null) ii.delegate else null
}

/**
 * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/effect/InnerShadow.html]]
 */
class InnerShadow(override val delegate: jfxse.InnerShadow = new jfxse.InnerShadow)
    extends Effect(delegate)
    with ColorDelegate[jfxse.InnerShadow]
    with DimensionDelegate[jfxse.InnerShadow]
    with InputDelegate[jfxse.InnerShadow]
    with SFXDelegate[jfxse.InnerShadow] {

  /**
   * Creates a new instance of InnerShadow with the specified blurType, color, radius, spread, offsetX and offsetY.
   */
  def this(blurType: jfxse.BlurType, color: Color, radius: Double, choke: Double, offsetX: Double, offsetY: Double) =
    this(new jfxse.InnerShadow(blurType, color, radius, choke, offsetX, offsetY))

  /**
   * Creates a new instance of InnerShadow with specified radius and color.
   */
  def this(radius: Double, color: Color) = this(new jfxse.InnerShadow(radius, color))

  /**
   * Creates a new instance of InnerShadow with specified radius, offsetX, offsetY and color.
   */
  def this(radius: Double, offsetX: Double, offsetY: Double, color: Color) =
    this(new jfxse.InnerShadow(radius, offsetX, offsetY, color))

  /**
   * The algorithm used to blur the shadow.
   */
  def blurType: ObjectProperty[jfxse.BlurType] = delegate.blurTypeProperty

  def blurType_=(v: BlurType): Unit = {
    blurType() = v
  }

  /**
   * The choke of the shadow.
   */
  def choke: DoubleProperty = delegate.chokeProperty

  def choke_=(v: Double): Unit = {
    choke() = v
  }

  /**
   * The shadow offset in the x direction, in pixels.
   */
  def offsetX: DoubleProperty = delegate.offsetXProperty

  def offsetX_=(v: Double): Unit = {
    offsetX() = v
  }

  /**
   * The shadow offset in the y direction, in pixels.
   */
  def offsetY: DoubleProperty = delegate.offsetYProperty

  def offsetY_=(v: Double): Unit = {
    offsetY() = v
  }

  /**
   * The radius of the shadow blur kernel.
   */
  def radius: DoubleProperty = delegate.radiusProperty

  def radius_=(v: Double): Unit = {
    radius() = v
  }

}
