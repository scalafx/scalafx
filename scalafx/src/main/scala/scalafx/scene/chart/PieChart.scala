/*
 * Copyright (c) 2011-2021, ScalaFX Project
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
import javafx.{collections => jfxc, scene => jfxs}
import scalafx.Includes._
import scalafx.beans.property._
import scalafx.collections.ObservableBuffer
import scalafx.delegate.SFXDelegate

import scala.language.implicitConversions

object PieChart {
  implicit def sfxPieChart2jfx(v: PieChart): jfxsc.PieChart = if (v != null) v.delegate else null

  object Data {
    implicit def sfxPieChartData2jfx(v: PieChart.Data): jfxsc.PieChart.Data = if (v != null) v.delegate else null

    def apply(name: String, value: Double) = new jfxsc.PieChart.Data(name, value)
  }

  class Data(override val delegate: jfxsc.PieChart.Data) extends SFXDelegate[jfxsc.PieChart.Data] {
    def chart: ReadOnlyObjectProperty[jfxsc.PieChart] = delegate.chartProperty

    def name: StringProperty = delegate.nameProperty

    def name_=(v: String): Unit = {
      name() = v
    }

    def pieValue: DoubleProperty = delegate.pieValueProperty

    def pieValue_=(v: Double): Unit = {
      pieValue() = v
    }

    def node: ReadOnlyObjectProperty[jfxs.Node] = delegate.nodeProperty()
  }

  def apply(data: ObservableBuffer[jfxsc.PieChart.Data]) = new PieChart(new jfxsc.PieChart(data))
}

class PieChart(override val delegate: jfxsc.PieChart = new jfxsc.PieChart())
  extends Chart(delegate)
    with SFXDelegate[jfxsc.PieChart] {

  def this(data: ObservableBuffer[jfxsc.PieChart.Data]) = {
    this(new jfxsc.PieChart(data))
  }

  def clockwise: BooleanProperty = delegate.clockwiseProperty

  def clockwise_=(v: Boolean): Unit = {
    clockwise() = v
  }

  def data: ObjectProperty[jfxc.ObservableList[jfxsc.PieChart.Data]] = delegate.dataProperty

  def data_=(v: ObservableBuffer[jfxsc.PieChart.Data]): Unit = {
    data() = v
  }

  def data_=(v: Seq[jfxsc.PieChart.Data]): Unit = {
    data() = ObservableBuffer.from(v)
  }


  def labelLineLength: DoubleProperty = delegate.labelLineLengthProperty

  def labelLineLength_=(v: Double): Unit = {
    labelLineLength() = v
  }

  def labelsVisible: BooleanProperty = delegate.labelsVisibleProperty

  def labelsVisible_=(v: Boolean): Unit = {
    labelsVisible() = v
  }

  def startAngle: DoubleProperty = delegate.startAngleProperty

  def startAngle_=(v: Double): Unit = {
    startAngle() = v
  }
}
