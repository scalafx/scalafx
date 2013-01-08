package scalafx.scene.chart
/*
 * Copyright (c) 2012, ScalaFX Project
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
import javafx.scene.{ chart => jfxsc }

object ChartIncludes extends ChartIncludes

trait ChartIncludes {
  implicit def jfxAreaChart2sfx[X, Y](b: jfxsc.AreaChart[X, Y]) = new AreaChart[X, Y](b)
  implicit def jfxAxis2sfx[X](a: jfxsc.Axis[X]) = new Axis[X](a) {}
  implicit def jfxBarChart2sfx[X, Y](b: jfxsc.BarChart[X, Y]) = new BarChart[X, Y](b)
  implicit def jfxBubbleChart2sfx[X, Y](b: jfxsc.BubbleChart[X, Y]) = new BubbleChart[X, Y](b)
  implicit def jfxChart2sfx(c: jfxsc.Chart) = new Chart(c) {}
  implicit def jfxLineChart2sfx[X, Y](b: jfxsc.LineChart[X, Y]) = new LineChart[X, Y](b)
  implicit def jfxPieChart2sfx(b: jfxsc.PieChart) = new PieChart(b)
  implicit def jfxPieChartData2sfx(b: jfxsc.PieChart.Data) = new PieChart.Data(b)
  implicit def jfxScatterChart2sfx[X, Y](b: jfxsc.ScatterChart[X, Y]) = new ScatterChart[X, Y](b)
  implicit def jfxStackedAreaChart2sfx[X, Y](b: jfxsc.StackedAreaChart[X, Y]) = new StackedAreaChart[X, Y](b)
  implicit def jfxStackedBarChart2sfx[X, Y](b: jfxsc.StackedBarChart[X, Y]) = new StackedBarChart[X, Y](b)
  implicit def jfxAxisTickMark2sfx[T](b: jfxsc.Axis.TickMark[T]) = new Axis.TickMark[T](b)
  implicit def jfxCategoryAxis2sfx(b: jfxsc.CategoryAxis) = new CategoryAxis(b)
  implicit def jfxNumberAxis2sfx(b: jfxsc.NumberAxis) = new NumberAxis(b)
  implicit def jfxNumberAxisDefaultFormatter2sfx(b: jfxsc.NumberAxis.DefaultFormatter) = new NumberAxis.DefaultFormatter(b)
  implicit def jfxValueAxis2sfx[X <: Number](a: jfxsc.ValueAxis[X]) = new ValueAxis[X](a) {}
  implicit def jfxXYChart2sfx[X, Y](c: jfxsc.XYChart[X, Y]) = new XYChart[X, Y](c) {}
  implicit def jfxXYChartData2sfx[X, Y](b: jfxsc.XYChart.Data[X, Y]) = new XYChart.Data[X, Y](b)
  implicit def jfxXYChartSeries2sfx[X, Y](b: jfxsc.XYChart.Series[X, Y]) = new XYChart.Series[X, Y](b)
}