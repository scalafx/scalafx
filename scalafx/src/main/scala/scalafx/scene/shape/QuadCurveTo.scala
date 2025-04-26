/*
 * Copyright (c) 2011-2025, ScalaFX Project
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

import javafx.scene.shape as jfxss
import scalafx.Includes.*
import scalafx.beans.property.DoubleProperty
import scalafx.delegate.{PositionDelegate, SFXDelegate}

import scala.language.implicitConversions

object QuadCurveTo {
  implicit def sfxQuadCurveTo2jfx(v: QuadCurveTo): jfxss.QuadCurveTo = if (v != null) v.delegate else null

  def apply(controlX: Double, controlY: Double, x: Double, y: Double) =
    new QuadCurveTo(new jfxss.QuadCurveTo(controlX, controlY, x, y))
}

class QuadCurveTo(override val delegate: jfxss.QuadCurveTo = new jfxss.QuadCurveTo())
    extends PathElement(delegate)
    with PositionDelegate[jfxss.QuadCurveTo]
    with SFXDelegate[jfxss.QuadCurveTo] {

  def controlX: DoubleProperty = delegate.controlXProperty

  def controlX_=(v: Double): Unit = {
    controlX() = v
  }

  def controlY: DoubleProperty = delegate.controlYProperty

  def controlY_=(v: Double): Unit = {
    controlY() = v
  }

}
