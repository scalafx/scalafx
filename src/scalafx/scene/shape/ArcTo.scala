/*
 * Copyright (c) 2011, ScalaFX Project
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
import scalafx.util.SFXDelegate

object ArcTo {
  implicit def sfxArcTo2jfx(v: ArcTo) = v.delegate

  def apply(radiusX: Double, radiusY: Double, xAxisRotation: Double, x: Double, y: Double, largeArcFlag: Boolean, sweepFlag: Boolean) = 
    new ArcTo(new jfxss.ArcTo(radiusX, radiusY, xAxisRotation, x, y , largeArcFlag, sweepFlag))
}

class ArcTo(override val delegate:jfxss.ArcTo = new jfxss.ArcTo()) extends PathElement(delegate) with SFXDelegate[jfxss.ArcTo] {
  def XAxisRotation = delegate.XAxisRotationProperty
  def XAxisRotation_=(v: Double) {
    XAxisRotation() = v
  }

  def sweepFlag = delegate.sweepFlagProperty
  def sweepFlag_=(v: Boolean) {
    sweepFlag() = v
  }

  def radiusY = delegate.radiusYProperty
  def radiusY_=(v: Double) {
    radiusY() = v
  }

  def radiusX = delegate.radiusXProperty
  def radiusX_=(v: Double) {
    radiusX() = v
  }

  def largeArcFlag = delegate.largeArcFlagProperty
  def largeArcFlag_=(v: Boolean) {
    largeArcFlag() = v
  }

  def x = delegate.xProperty
  def x_=(v: Double) {
    x() = v
  }

  def y = delegate.yProperty
  def y_=(v: Double) {
    y() = v
  }
}
