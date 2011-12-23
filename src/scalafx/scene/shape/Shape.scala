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

import collection.JavaConversions._
import javafx.scene.{paint => jfxsp}
import javafx.scene.{shape => jfxss}
import scalafx.Includes._
import scalafx.scene.Node
import scalafx.util.SFXDelegate

object Shape {
  implicit def sfxShape2jfx(v: Shape) = v.delegate
}

abstract class Shape(override val delegate: jfxss.Shape) extends Node(delegate) with SFXDelegate[jfxss.Shape] {
  def fill = delegate.fillProperty
  def fill_=(v: jfxsp.Paint) {
    fill() = v
  }

  def smooth = delegate.smoothProperty
  def smooth_=(v: Boolean) {
    smooth() = v
  }

  def strokeDashOffset = delegate.strokeDashOffsetProperty
  def strokeDashOffset_=(v: Double) {
    strokeDashOffset() = v
  }

  def strokeLineCap = delegate.strokeLineCapProperty
  def strokeLineCap_=(v: jfxss.StrokeLineCap) {
    strokeLineCap() = v
  }

  def strokeLineJoin = delegate.strokeLineJoinProperty
  def strokeLineJoin_=(v: jfxss.StrokeLineJoin) {
    strokeLineJoin() = v
  }

  def strokeMiterLimit = delegate.strokeMiterLimitProperty
  def strokeMiterLimit_=(v: Double) {
    strokeMiterLimit() = v
  }

  def stroke = delegate.strokeProperty
  def stroke_=(v: jfxsp.Paint) {
    stroke() = v
  }

  def strokeType = delegate.strokeTypeProperty
  def strokeType_=(v: jfxss.StrokeType) {
    strokeType() = v
  }

  def strokeWidth = delegate.strokeWidthProperty
  def strokeWidth_=(v: Double) {
    strokeWidth() = v
  }

  def strokeDashArray = delegate.getStrokeDashArray
  def strokeDashArray_=(c: Iterable[java.lang.Double]) {
    strokeDashArray.setAll(c)
  }
}
