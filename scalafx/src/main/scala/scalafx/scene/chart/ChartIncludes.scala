/*
 * Copyright (c) 2011-2014, ScalaFX Project
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

import scala.language.implicitConversions
import scalafx.scene.chart.Axis.TickMark
import scalafx.scene.chart.NumberAxis.DefaultFormatter
import scalafx.scene.chart.XYChart.{Data, Series}

object ChartIncludes extends ChartIncludes

/**
 * Contains implicit methods to convert from
 * [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/chart/package-summary.html `javafx.scene.chart`]]
 * Classes/Traits to their $SFX counterparts.
 *
 * @define JFX JavaFX
 * @define SFX ScalaFX
 * @define START Converts a $JFX `[[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/chart/
 * @define END ]]` instance to its $SFX counterpart.
 *
 * @define ARCH AreaChart
 * @define AXIS Axis
 * @define BRCH BarChart
 * @define BBCH BubbleChart
 * @define CHAR Chart
 * @define LNCH LineChart
 * @define PICH PieChart
 * @define PIDT PieChart.Data
 * @define SCCH ScatterChart
 * @define STCH StackedAreaChart
 * @define SBCH StackedBarChart
 * @define TIMK Axis.TickMark
 * @define CAAX CategoryAxis
 * @define NMAX NumberAxis
 * @define NMDF NumberAxis.DefaultFormatter
 * @define VAAX ValueAxis
 * @define XYCH XYChart
 * @define XYDT XYChart.Data
 * @define XYSR XYChart.Series
 * @define XTYPE X Axis Type
 * @define YTYPE Y Axis Type
 */
trait ChartIncludes {

  /**
   * $START$ARCH.html $ARCH$END
   *
   * @tparam X $XTYPE
   * @tparam Y $YTYPE
   * @param b $JFX $ARCH
   * @return $SFX $ARCH
   */
  implicit def jfxAreaChart2sfx[X, Y](b: jfxsc.AreaChart[X, Y]): AreaChart[X, Y] = if (b != null) new AreaChart[X, Y](b) else null

  /**
   * $START$AXIS.html $AXIS$END
   *
   * @tparam X $XTYPE
   * @param a $JFX $AXIS
   * @return $SFX $AXIS
   */
  implicit def jfxAxis2sfx[X](a: jfxsc.Axis[X]): Axis[X] = if (a != null) new Axis[X](a) {} else null

  /**
   * $START$BRCH.html $BRCH$END
   *
   * @tparam X $XTYPE
   * @tparam Y $YTYPE
   * @param b $JFX $BRCH
   * @return $SFX $BRCH
   */
  implicit def jfxBarChart2sfx[X, Y](b: jfxsc.BarChart[X, Y]): BarChart[X, Y] = if (b != null) new BarChart[X, Y](b) else null

  /**
   * $START$BBCH.html $BBCH$END
   *
   * @tparam X $XTYPE
   * @tparam Y $YTYPE
   * @param b $JFX $BBCH
   * @return $SFX $BBCH
   */
  implicit def jfxBubbleChart2sfx[X, Y](b: jfxsc.BubbleChart[X, Y]): BubbleChart[X, Y] = if (b != null) new BubbleChart[X, Y](b) else null

  /**
   * $START$CHAR.html $CHAR$END
   *
   * @param c $JFX $CHAR
   * @return $SFX $CHAR
   */
  implicit def jfxChart2sfx(c: jfxsc.Chart): Chart = if (c != null) new Chart(c) {} else null

  /**
   * $START$LNCH.html $LNCH$END
   *
   * @tparam X $XTYPE
   * @tparam Y $YTYPE
   * @param b $JFX $LNCH
   * @return $SFX $LNCH
   */
  implicit def jfxLineChart2sfx[X, Y](b: jfxsc.LineChart[X, Y]): LineChart[X, Y] = if (b != null) new LineChart[X, Y](b) else null

  /**
   * $START$PICH.html $PICH$END
   *
   * @param b $JFX $PICH
   * @return $SFX $PICH
   */
  implicit def jfxPieChart2sfx(b: jfxsc.PieChart): PieChart = if (b != null) new PieChart(b) else null

  /**
   * $START$PIDT.html $PIDT$END
   *
   * @param b $JFX $PIDT
   * @return $SFX $PIDT
   */
  implicit def jfxPieChartData2sfx(b: jfxsc.PieChart.Data): PieChart.Data = if (b != null) new PieChart.Data(b) else null

  /**
   * $START$SCCH.html $SCCH$END
   *
   * @tparam X $XTYPE
   * @tparam Y $YTYPE
   * @param b $JFX $SCCH
   * @return $SFX $SCCH
   */
  implicit def jfxScatterChart2sfx[X, Y](b: jfxsc.ScatterChart[X, Y]): ScatterChart[X, Y] = if (b != null) new ScatterChart[X, Y](b) else null

  /**
   * $START$STCH.html $STCH$END
   *
   * @tparam X $XTYPE
   * @tparam Y $YTYPE
   * @param b $JFX $STCH
   * @return $SFX $STCH
   */
  implicit def jfxStackedAreaChart2sfx[X, Y](b: jfxsc.StackedAreaChart[X, Y]): StackedAreaChart[X, Y] = if (b != null) new StackedAreaChart[X, Y](b) else null

  /**
   * $START$SBCH.html $SBCH$END
   *
   * @tparam X $XTYPE
   * @tparam Y $YTYPE
   * @param b $JFX $SBCH
   * @return $SFX $SBCH
   */
  implicit def jfxStackedBarChart2sfx[X, Y](b: jfxsc.StackedBarChart[X, Y]): StackedBarChart[X, Y] = if (b != null) new StackedBarChart[X, Y](b) else null

  /**
   * $START$TIMK.html $TIMK$END
   *
   * @tparam T $TIMK Type.
   * @param b $JFX $TIMK
   * @return $SFX $TIMK
   */
  implicit def jfxAxisTickMark2sfx[T](b: jfxsc.Axis.TickMark[T]): TickMark[T] = if (b != null) new Axis.TickMark[T](b) else null

  /**
   * $START$CAAX.html $CAAX$END
   *
   * @param b $JFX $CAAX
   * @return $SFX $CAAX
   */
  implicit def jfxCategoryAxis2sfx(b: jfxsc.CategoryAxis): CategoryAxis = if (b != null) new CategoryAxis(b) else null

  /**
   * $START$NMAX.html $NMAX$END
   *
   * @param b $JFX $NMAX
   * @return $SFX $NMAX
   */
  implicit def jfxNumberAxis2sfx(b: jfxsc.NumberAxis): NumberAxis = if (b != null) new NumberAxis(b) else null

  /**
   * $START$NMDF.html $NMDF$END
   *
   * @param b $JFX $NMDF
   * @return $SFX $NMDF
   */
  implicit def jfxNumberAxisDefaultFormatter2sfx(b: jfxsc.NumberAxis.DefaultFormatter): DefaultFormatter = if (b != null) new NumberAxis.DefaultFormatter(b) else null

  /**
   * $START$VAAX.html $VAAX$END
   *
   * @tparam X $XTYPE, derivated from Number.
   * @param a $JFX $VAAX
   * @return $SFX $VAAX
   */
  implicit def jfxValueAxis2sfx[X <: Number](a: jfxsc.ValueAxis[X]): ValueAxis[X] = if (a != null) new ValueAxis[X](a) {} else null

  /**
   * $START$XYCH.html $XYCH$END
   *
   * @tparam X $XTYPE
   * @tparam Y $YTYPE
   * @param c $JFX $XYCH
   * @return $SFX $XYCH
   */
  implicit def jfxXYChart2sfx[X, Y](c: jfxsc.XYChart[X, Y]): XYChart[X, Y] = if (c != null) new XYChart[X, Y](c) {} else null

  /**
   * $START$XYDT.html $XYDT$END
   *
   * @tparam X $XTYPE
   * @tparam Y $YTYPE
   * @param b $JFX $XYDT
   * @return $SFX $XYDT
   */
  implicit def jfxXYChartData2sfx[X, Y](b: jfxsc.XYChart.Data[X, Y]): Data[X, Y] = if (b != null) new XYChart.Data[X, Y](b) else null

  /**
   * $START$XYSR.html $XYSR$END
   *
   * @tparam X $XTYPE
   * @tparam Y $YTYPE
   * @param b $JFX $XYSR
   * @return $SFX $XYSR
   */
  implicit def jfxXYChartSeries2sfx[X, Y](b: jfxsc.XYChart.Series[X, Y]): Series[X, Y] = if (b != null) new XYChart.Series[X, Y](b) else null

}