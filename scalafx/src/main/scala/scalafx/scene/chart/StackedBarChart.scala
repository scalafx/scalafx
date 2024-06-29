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
package scalafx.scene.chart

import javafx.scene.{chart => jfxsc}
import scalafx.Includes._
import scalafx.beans.property.DoubleProperty
import scalafx.collections.ObservableBuffer
import scalafx.delegate.SFXDelegate

import scala.language.implicitConversions

object StackedBarChart {
  implicit def sfxStackedBarChart2jfx[X, Y](v: StackedBarChart[X, Y]): jfxsc.StackedBarChart[X, Y] =
    if (v != null) v.delegate else null

  def apply[X, Y](xAxis: Axis[X], yAxis: Axis[Y]) =
    new StackedBarChart[X, Y](new jfxsc.StackedBarChart[X, Y](xAxis, yAxis))

  def apply[X, Y](xAxis: Axis[X], yAxis: Axis[Y], data: ObservableBuffer[jfxsc.XYChart.Series[X, Y]]) =
    new StackedBarChart[X, Y](new jfxsc.StackedBarChart[X, Y](xAxis, yAxis, data))

  def apply[X, Y](
    xAxis: Axis[X],
    yAxis: Axis[Y],
    data: ObservableBuffer[jfxsc.XYChart.Series[X, Y]],
    categoryGap: Double
  ) =
    new StackedBarChart[X, Y](new jfxsc.StackedBarChart[X, Y](xAxis, yAxis, data, categoryGap))
}

class StackedBarChart[X, Y](override val delegate: jfxsc.StackedBarChart[X, Y])
    extends XYChart[X, Y](delegate)
    with SFXDelegate[jfxsc.StackedBarChart[X, Y]] {

  def this(xAxis: Axis[X], yAxis: Axis[Y]) = {
    this(new jfxsc.StackedBarChart[X, Y](xAxis, yAxis))
  }

  def this(xAxis: Axis[X], yAxis: Axis[Y], data: ObservableBuffer[jfxsc.XYChart.Series[X, Y]]) = {
    this(new jfxsc.StackedBarChart[X, Y](xAxis, yAxis, data))
  }

  def this(xAxis: Axis[X], yAxis: Axis[Y], data: ObservableBuffer[jfxsc.XYChart.Series[X, Y]], categoryGap: Double) = {
    this(new jfxsc.StackedBarChart[X, Y](xAxis, yAxis, data, categoryGap))
  }

  def categoryGap: DoubleProperty = delegate.categoryGapProperty

  def categoryGap_=(v: Double): Unit = {
    categoryGap() = v
  }
}
