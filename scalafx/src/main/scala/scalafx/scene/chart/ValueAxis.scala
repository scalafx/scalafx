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
package scalafx.scene.chart

import javafx.scene.chart as jfxsc
import javafx.util as jfxu
import scalafx.Includes.*
import scalafx.beans.property.*
import scalafx.delegate.SFXDelegate
import scalafx.util.StringConverter

import scala.language.implicitConversions

object ValueAxis {
  implicit def sfxValueAxis2jfx[T <: Number](v: ValueAxis[T]): jfxsc.ValueAxis[T] = if (v != null) v.delegate else null
}

abstract class ValueAxis[T <: Number](override val delegate: jfxsc.ValueAxis[T])
    extends Axis[T](delegate)
    with SFXDelegate[jfxsc.ValueAxis[T]] {

  def lowerBound: DoubleProperty = delegate.lowerBoundProperty

  def lowerBound_=(v: Double): Unit = {
    lowerBound() = v
  }

  def minorTickCount: IntegerProperty = delegate.minorTickCountProperty

  def minorTickCount_=(v: Int): Unit = {
    minorTickCount() = v
  }

  def minorTickLength: DoubleProperty = delegate.minorTickLengthProperty

  def minorTickLength_=(v: Double): Unit = {
    minorTickLength() = v
  }

  def minorTickVisible: BooleanProperty = delegate.minorTickVisibleProperty

  def minorTickVisible_=(v: Boolean): Unit = {
    minorTickVisible() = v
  }

  def scale: ReadOnlyDoubleProperty = delegate.scaleProperty

  def tickLabelFormatter: ObjectProperty[jfxu.StringConverter[T]] = delegate.tickLabelFormatterProperty

  def tickLabelFormatter_=(v: StringConverter[T]): Unit = {
    tickLabelFormatter() = v
  }

  def upperBound: DoubleProperty = delegate.upperBoundProperty

  def upperBound_=(v: Double): Unit = {
    upperBound() = v
  }
}
