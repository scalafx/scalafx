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
import javafx.{scene => jfxs}
import scalafx.Includes._
import scalafx.beans.property.BooleanProperty
import scalafx.beans.property.ObjectProperty
import scalafx.beans.property.ReadOnlyObjectProperty
import scalafx.beans.property.StringProperty
import scalafx.collections.ObservableBuffer
import scalafx.delegate.SFXDelegate
import scalafx.scene.Node

object XYChart {
  implicit def sfxXYChart2jfx[X, Y](v: XYChart[X, Y]) = v.delegate

  object Data {
    implicit def sfxXYChartData2jfx[X, Y](v: XYChart.Data[X, Y]) = v.delegate

    def apply[X, Y](x: X, y: Y) = new jfxsc.XYChart.Data[X, Y](x, y)

    def apply[X, Y](x: X, y: Y, extraValue: Any) = new jfxsc.XYChart.Data[X, Y](x, y, extraValue)
  }

  class Data[X, Y](override val delegate: jfxsc.XYChart.Data[X, Y] =
                   new jfxsc.XYChart.Data[X, Y]()) extends SFXDelegate[jfxsc.XYChart.Data[X, Y]] {

    def extraValue: ObjectProperty[AnyRef] = delegate.extraValueProperty
    def extraValue_=(v: AnyRef) {
      extraValue() = v
    }

    def node: ObjectProperty[jfxs.Node] = delegate.nodeProperty
    def node_=(v: Node) {
      node() = v
    }

    def XValue: ObjectProperty[X] = delegate.XValueProperty
    def XValue_=(v: X) {
      delegate.setXValue(v)
    }

    def YValue: ObjectProperty[Y] = delegate.YValueProperty
    def YValue_=(v: Y) {
      delegate.setYValue(v)
    }
  }

  object Series {
    implicit def sfxXYChartSeries2jfx[X, Y](v: XYChart.Series[X, Y]) = v.delegate

    def apply[X, Y](data: ObservableBuffer[jfxsc.XYChart.Data[X, Y]]) =
      new jfxsc.XYChart.Series[X, Y](data)

    def apply[X, Y](name: String, data: ObservableBuffer[jfxsc.XYChart.Data[X, Y]]) =
      new jfxsc.XYChart.Series[X, Y](name, data)
  }

  class Series[X, Y](override val delegate: jfxsc.XYChart.Series[X, Y] = new jfxsc.XYChart.Series[X, Y]())
    extends SFXDelegate[jfxsc.XYChart.Series[X, Y]] {

    def chart: ReadOnlyObjectProperty[jfxsc.XYChart[X, Y]] = delegate.chartProperty

    def data = delegate.dataProperty
    def data_=(v: ObservableBuffer[jfxsc.XYChart.Data[X, Y]]) {
      data() = v
    }

    def name: StringProperty = delegate.nameProperty
    def name_=(v: String) {
      name() = v
    }

    def node: ObjectProperty[jfxs.Node] = delegate.nodeProperty
    def node_=(v: Node) {
      node() = v
    }
  }

}

abstract class XYChart[X, Y](override val delegate: jfxsc.XYChart[X, Y])
  extends Chart(delegate)
  with SFXDelegate[jfxsc.XYChart[X, Y]] {

  def alternativeColumnFillVisible: BooleanProperty = delegate.alternativeColumnFillVisibleProperty
  def alternativeColumnFillVisible_=(v: Boolean) {
    alternativeColumnFillVisible() = v
  }

  def alternativeRowFillVisible: BooleanProperty = delegate.alternativeRowFillVisibleProperty
  def alternativeRowFillVisible_=(v: Boolean) {
    alternativeRowFillVisible() = v
  }

  def data = delegate.dataProperty
  def data_=(v: ObservableBuffer[jfxsc.XYChart.Series[X, Y]]) {
    data() = v
  }
  def data_=(v: XYChart.Series[X, Y]) {
    data() = ObservableBuffer[jfxsc.XYChart.Series[X, Y]](v)
  }

  def horizontalGridLinesVisible: BooleanProperty = delegate.horizontalGridLinesVisibleProperty
  def horizontalGridLinesVisible_=(v: Boolean) {
    horizontalGridLinesVisible() = v
  }

  def horizontalZeroLineVisible: BooleanProperty = delegate.horizontalZeroLineVisibleProperty
  def horizontalZeroLineVisible_=(v: Boolean) {
    horizontalZeroLineVisible() = v
  }

  def verticalGridLinesVisible: BooleanProperty = delegate.verticalGridLinesVisibleProperty
  def verticalGridLinesVisible_=(v: Boolean) {
    verticalGridLinesVisible() = v
  }

  def verticalZeroLineVisible: BooleanProperty = delegate.verticalZeroLineVisibleProperty
  def verticalZeroLineVisible_=(v: Boolean) {
    verticalZeroLineVisible() = v
  }

  def XAxis: Axis[X] = delegate.getXAxis

  def YAxis: Axis[Y] = delegate.getYAxis
}
