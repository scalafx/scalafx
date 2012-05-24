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

package scalafx.scene.chart

import javafx.scene.{ chart => jfxsc }
import scalafx.Includes._
import scalafx.collections.ObservableBuffer
import scalafx.scene.Node
import scalafx.util.SFXDelegate

object XYChart {
  implicit def sfxXYChart2jfx[X, Y](v: XYChart[X, Y]) = v.delegate

  object Data {
    implicit def sfxXYChartData2jfx[X, Y](v: XYChart.Data[X, Y]) = v.delegate

    def apply[X, Y](x: X, y: Y) = new XYChart.Data[X, Y](new jfxsc.XYChart.Data[X, Y](x, y))

    def apply[X, Y](x: X, y: Y, extraValue: AnyRef) = new XYChart.Data[X, Y](new jfxsc.XYChart.Data[X, Y](x, y, extraValue))
  }

  class Data[X, Y](override val delegate: jfxsc.XYChart.Data[X, Y] = new jfxsc.XYChart.Data[X, Y]()) extends SFXDelegate[jfxsc.XYChart.Data[X, Y]] {
    def extraValue = delegate.extraValueProperty
    def extraValue_=(v: AnyRef) {
      extraValue() = v
    }

    def node = delegate.nodeProperty
    def node_=(v: Node) {
      node() = v
    }

    def XValue = delegate.XValueProperty
    def XValue_=(v: X) = delegate.setXValue(v)

    def YValue = delegate.YValueProperty
    def YValue_=(v: Y) = delegate.setYValue(v)
  }

  object Series {
    implicit def sfxXYChartSeries2jfx[X, Y](v: XYChart.Series[X, Y]) = v.delegate

    def apply[X, Y](data: ObservableBuffer[jfxsc.XYChart.Data[X, Y]]) = new XYChart.Series[X, Y](new jfxsc.XYChart.Series[X, Y](data))

    def apply[X, Y](name: String, data: ObservableBuffer[jfxsc.XYChart.Data[X, Y]]) = new XYChart.Series[X, Y](new jfxsc.XYChart.Series[X, Y](name, data))
  }

  class Series[X, Y](override val delegate: jfxsc.XYChart.Series[X, Y] = new jfxsc.XYChart.Series[X, Y]()) extends SFXDelegate[jfxsc.XYChart.Series[X, Y]] {
    def chart = delegate.chartProperty

    def data = delegate.dataProperty
    def data_=(v: ObservableBuffer[jfxsc.XYChart.Data[X, Y]]) {
      data() = v
    }

    def name = delegate.nameProperty
    def name_=(v: String) {
      name() = v
    }

    def node = delegate.nodeProperty
    def node_=(v: Node) {
      node() = v
    }
  }

}

abstract class XYChart[X, Y](override val delegate: jfxsc.XYChart[X, Y]) extends Chart(delegate) with SFXDelegate[jfxsc.XYChart[X, Y]] {
  def alternativeColumnFillVisible = delegate.alternativeColumnFillVisibleProperty
  def alternativeColumnFillVisible_=(v: Boolean) {
    alternativeColumnFillVisible() = v
  }

  def alternativeRowFillVisible = delegate.alternativeRowFillVisibleProperty
  def alternativeRowFillVisible_=(v: Boolean) {
    alternativeRowFillVisible() = v
  }

  def data = delegate.dataProperty
  def data_=(v: ObservableBuffer[jfxsc.XYChart.Series[X, Y]]) {
    data() = v
  }

  def horizontalGridLinesVisible = delegate.horizontalGridLinesVisibleProperty
  def horizontalGridLinesVisible_=(v: Boolean) {
    horizontalGridLinesVisible() = v
  }

  def horizontalZeroLineVisible = delegate.horizontalZeroLineVisibleProperty
  def horizontalZeroLineVisible_=(v: Boolean) {
    horizontalZeroLineVisible() = v
  }

  def verticalGridLinesVisible = delegate.verticalGridLinesVisibleProperty
  def verticalGridLinesVisible_=(v: Boolean) {
    verticalGridLinesVisible() = v
  }

  def verticalZeroLineVisible = delegate.verticalZeroLineVisibleProperty
  def verticalZeroLineVisible_=(v: Boolean) {
    verticalZeroLineVisible() = v
  }

  def XAxis: Axis[X] = delegate.getXAxis

  def YAxis: Axis[Y] = delegate.getYAxis

}
