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

object DropShadow {
  implicit def sfxDropShadow2jfx(ds: DropShadow): jfxse.DropShadow = if (ds != null) ds.delegate else null
}

class DropShadow(override val delegate: jfxse.DropShadow = new jfxse.DropShadow())
    extends Effect(delegate)
    with ColorDelegate[jfxse.DropShadow]
    with DimensionDelegate[jfxse.DropShadow]
    with InputDelegate[jfxse.DropShadow]
    with SFXDelegate[jfxse.DropShadow] {

  /**
   * Creates a new instance of DropShadow with the specified blurType, color, radius, spread, offsetX and offsetY.
   */
  def this(blurType: jfxse.BlurType, color: Color, radius: Double, spread: Double, offsetX: Double, offsetY: Double) =
    this(new jfxse.DropShadow(blurType, color, radius, spread, offsetX, offsetY))

  /**
   * Creates a new instance of DropShadow with specified radius and color.
   */
  def this(radius: Double, color: Color) = this(new jfxse.DropShadow(radius, color))

  /**
   * Creates a new instance of DropShadow with the specified radius, offsetX, offsetY and color.
   */
  def this(radius: Double, offsetX: Double, offsetY: Double, color: Color) =
    this(new jfxse.DropShadow(radius, offsetX, offsetY, color))

  def blurType: ObjectProperty[jfxse.BlurType] = delegate.blurTypeProperty

  def blurType_=(bt: BlurType): Unit = {
    blurType() = bt
  }

  def offsetX: DoubleProperty = delegate.offsetXProperty

  def offsetX_=(d: Double): Unit = {
    offsetX() = d
  }

  def offsetY: DoubleProperty = delegate.offsetYProperty

  def offsetY_=(d: Double): Unit = {
    offsetY() = d
  }

  def radius: DoubleProperty = delegate.radiusProperty

  def radius_=(d: Double): Unit = {
    radius() = d
  }

  def spread: DoubleProperty = delegate.spreadProperty

  def spread_=(d: Double): Unit = {
    spread() = d
  }

}
