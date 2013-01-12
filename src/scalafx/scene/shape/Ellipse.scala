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
import scalafx.delegate.SFXDelegate

object Ellipse {
  implicit def sfxEllipse2jfx(v: Ellipse) = v.delegate
  
  def apply(radiusX: Double, radiusY: Double) = new Ellipse(new jfxss.Ellipse(radiusX, radiusY))
  def apply(centerX: Double, centerY: Double, radiusX: Double, radiusY: Double) = 
    new Ellipse(new jfxss.Ellipse(centerX, centerY, radiusX, radiusY))
}

class Ellipse(override val delegate:jfxss.Ellipse = new jfxss.Ellipse()) extends Shape(delegate) with SFXDelegate[jfxss.Ellipse] {
  def centerX = delegate.centerXProperty
  def centerX_=(v: Double) {
    centerX() = v
  }

  def centerY = delegate.centerYProperty
  def centerY_=(v: Double) {
    centerY() = v
  }

  def radiusX = delegate.radiusXProperty
  def radiusX_=(v: Double) {
    radiusX() = v
  }

  def radiusY = delegate.radiusYProperty
  def radiusY_=(v: Double) {
    radiusY() = v
  }
}
