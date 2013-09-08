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
package scalafx.scene.chart

import javafx.scene.{chart => jfxsc}
import scalafx.Includes._
import scalafx.beans.property.BooleanProperty
import scalafx.beans.property.DoubleProperty
import scalafx.delegate.SFXDelegate
import scalafx.util.converter.StringConverterDelegate

object NumberAxis {
  implicit def sfxNumberAxis2jfx(v: NumberAxis) = v.delegate

  def apply(lowerBound: Double, upperBound: Double, tickUnit: Double) =
    new NumberAxis(new jfxsc.NumberAxis(lowerBound, upperBound, tickUnit))

  def apply(axisLabel: String, lowerBound: Double, upperBound: Double, tickUnit: Double) =
    new NumberAxis(new jfxsc.NumberAxis(axisLabel, lowerBound, upperBound, tickUnit))

  def apply(axisLabel: String) = new NumberAxis {label = axisLabel}

  object DefaultFormatter {
    implicit def sfxDefaultFormatter2jfx(v: DefaultFormatter) = v.delegate

    def apply(axis: NumberAxis) =
      new DefaultFormatter(new jfxsc.NumberAxis.DefaultFormatter(axis))

    def apply(axis: NumberAxis, prefix: String, suffix: String) =
      new DefaultFormatter(new jfxsc.NumberAxis.DefaultFormatter(axis, prefix, suffix))
  }

  class DefaultFormatter(override val delegate: jfxsc.NumberAxis.DefaultFormatter)
    extends StringConverterDelegate[java.lang.Number, Number, jfxsc.NumberAxis.DefaultFormatter](delegate)

}

class NumberAxis(override val delegate: jfxsc.NumberAxis = new jfxsc.NumberAxis)
  extends ValueAxis[Number](delegate)
  with SFXDelegate[jfxsc.NumberAxis] {

  def this(lowerBound: Double, upperBound: Double, tickUnit: Double) {
    this(new jfxsc.NumberAxis(lowerBound, upperBound, tickUnit))
  }

  def this(axisLabel: String, lowerBound: Double, upperBound: Double, tickUnit: Double) {
    this(new jfxsc.NumberAxis(axisLabel, lowerBound, upperBound, tickUnit))
  }


  /**
   * When `true` zero is always included in the visible range.
   */
  def forceZeroInRange: BooleanProperty = delegate.forceZeroInRangeProperty
  def forceZeroInRange_=(v: Boolean) {
    forceZeroInRange() = v
  }

  /**
   * The value between each major tick mark in data units.
   */
  def tickUnit: DoubleProperty = delegate.tickUnitProperty
  def tickUnit_=(v: Double) {
    tickUnit() = v
  }

}
