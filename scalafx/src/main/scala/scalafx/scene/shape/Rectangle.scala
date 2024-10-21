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
package scalafx.scene.shape

import javafx.scene.{shape => jfxss}
import scalafx.Includes._
import scalafx.beans.property.DoubleProperty
import scalafx.delegate.{DimensionDelegate, PositionDelegate, SFXDelegate}
import scalafx.scene.paint._

import scala.language.implicitConversions

object Rectangle {
  implicit def sfxRectangle2jfx(v: Rectangle): jfxss.Rectangle = if (v != null) v.delegate else null

  def apply(width: Double, height: Double) = new Rectangle(new jfxss.Rectangle(width, height))

  def apply(x: Double, y: Double, width: Double, height: Double) =
    new Rectangle(new jfxss.Rectangle(x, y, width, height))

  def apply(width: Double, height: Double, fill: Paint) =
    new Rectangle(new jfxss.Rectangle(width, height, fill))
}

/**
 * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/shape/Rectangle.html]]
 */
class Rectangle(override val delegate: jfxss.Rectangle = new jfxss.Rectangle())
    extends Shape(delegate)
    with PositionDelegate[jfxss.Rectangle]
    with DimensionDelegate[jfxss.Rectangle]
    with SFXDelegate[jfxss.Rectangle] {

  /**
   * Defines the vertical diameter of the arc at the four corners of the rectangle.
   */
  def arcWidth: DoubleProperty = delegate.arcWidthProperty

  def arcWidth_=(v: Double): Unit = {
    arcWidth() = v
  }

  /**
   * Defines the horizontal diameter of the arc at the four corners of the rectangle.
   */
  def arcHeight: DoubleProperty = delegate.arcHeightProperty

  def arcHeight_=(v: Double): Unit = {
    arcHeight() = v
  }

}
