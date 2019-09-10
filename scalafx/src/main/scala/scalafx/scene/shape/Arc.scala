/*
 * Copyright (c) 2011-2019, ScalaFX Project
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
import scalafx.beans.property.{DoubleProperty, ObjectProperty}
import scalafx.delegate.SFXDelegate

import scala.language.implicitConversions

object Arc {
  implicit def sfxArc2jfx(v: Arc): jfxss.Arc = if (v != null) v.delegate else null

  def apply(centerX: Double, centerY: Double, radiusX: Double, radiusY: Double, startAngle: Double, length: Double) =
    new Arc(new jfxss.Arc(centerX, centerY, radiusX, radiusY, startAngle, length))
}

class Arc(override val delegate: jfxss.Arc = new jfxss.Arc()) extends Shape(delegate) with SFXDelegate[jfxss.Arc] {
  def centerX: DoubleProperty = delegate.centerXProperty

  def centerX_=(v: Double): Unit = {
    centerX() = v
  }

  def centerY: DoubleProperty = delegate.centerYProperty

  def centerY_=(v: Double): Unit = {
    centerY() = v
  }

  def length: DoubleProperty = delegate.lengthProperty

  def length_=(v: Double): Unit = {
    length() = v
  }

  def radiusX: DoubleProperty = delegate.radiusXProperty

  def radiusX_=(v: Double): Unit = {
    radiusX() = v
  }

  def radiusY: DoubleProperty = delegate.radiusYProperty

  def radiusY_=(v: Double): Unit = {
    radiusY() = v
  }

  def startAngle: DoubleProperty = delegate.startAngleProperty

  def startAngle_=(v: Double): Unit = {
    startAngle() = v
  }

  def `type`: ObjectProperty[jfxss.ArcType] = delegate.typeProperty

  def `type_=`(v: ArcType): Unit = {
    `type`() = v
  }
}
