/*
 * Copyright (c) 2011-2013, ScalaFX Project
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

import javafx.scene.{ shape => jfxss }
import scalafx.Includes._
import scalafx.beans.property.DoubleProperty
import scalafx.delegate.PositionDelegate
import scalafx.delegate.SFXDelegate

object CubicCurveTo {
  implicit def sfxCubicCurveTo2jfx(v: CubicCurveTo) = v.delegate

  def apply(controlX1: Double, controlY1: Double, controlX2: Double, controlY2: Double, x: Double, y: Double) =
    new CubicCurveTo(new jfxss.CubicCurveTo(controlX1, controlY1, controlX2, controlY2, x, y))
}

class CubicCurveTo(override val delegate: jfxss.CubicCurveTo = new jfxss.CubicCurveTo)
  extends PathElement(delegate)
  with PositionDelegate[jfxss.CubicCurveTo]
  with SFXDelegate[jfxss.CubicCurveTo] {

  def controlX1: DoubleProperty = delegate.controlX1Property
  def controlX1_=(v: Double) {
    controlX1() = v
  }

  def controlX2: DoubleProperty = delegate.controlX2Property
  def controlX2_=(v: Double) {
    controlX2() = v
  }

  def controlY1: DoubleProperty = delegate.controlY1Property
  def controlY1_=(v: Double) {
    controlY1() = v
  }

  def controlY2: DoubleProperty = delegate.controlY2Property
  def controlY2_=(v: Double) {
    controlY2() = v
  }

}