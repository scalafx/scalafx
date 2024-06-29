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
import scalafx.delegate.SFXDelegate

import scala.language.implicitConversions

object QuadCurve {
  implicit def sfxQuadCurve2jfx(v: QuadCurve): jfxss.QuadCurve = if (v != null) v.delegate else null

  def apply(startX: Double, startY: Double, controlX: Double, controlY: Double, endX: Double, endY: Double) =
    new QuadCurve(new jfxss.QuadCurve(startX, startY, controlX, controlY, endX, endY))
}

class QuadCurve(override val delegate: jfxss.QuadCurve = new jfxss.QuadCurve()) extends Shape(delegate)
    with SFXDelegate[jfxss.QuadCurve] {
  def controlX: DoubleProperty = delegate.controlXProperty

  def controlX_=(v: Double): Unit = {
    controlX() = v
  }

  def controlY: DoubleProperty = delegate.controlYProperty

  def controlY_=(v: Double): Unit = {
    controlY() = v
  }

  def endX: DoubleProperty = delegate.endXProperty

  def endX_=(v: Double): Unit = {
    endX() = v
  }

  def endY: DoubleProperty = delegate.endYProperty

  def endY_=(v: Double): Unit = {
    endY() = v
  }

  def startX: DoubleProperty = delegate.startXProperty

  def startX_=(v: Double): Unit = {
    startX() = v
  }

  def startY: DoubleProperty = delegate.startYProperty

  def startY_=(v: Double): Unit = {
    startY() = v
  }
}
