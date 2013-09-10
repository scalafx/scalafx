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

import scalafx.application.JFXApp
import scalafx.collections.ObservableBuffer
import scalafx.geometry.Side
import scalafx.scene.Scene

object BubbleChartDemo extends JFXApp {

  stage = new JFXApp.PrimaryStage {
    title = "BubbleChartDemo"
    scene = new Scene {
      val xAxis = NumberAxis("X", lowerBound = 0, upperBound = 150, tickUnit = 20)
      val yAxis = NumberAxis("Y", lowerBound = 0, upperBound = 150, tickUnit = 20)
      root = new BubbleChart(xAxis, yAxis) {
        title = "Bubble Chart"
        legendSide = Side.RIGHT
        data = ObservableBuffer(
          xyrSeries("Series 1", Seq((30, 40, 10), (60, 20, 13), (10, 90, 7), (100, 40, 10), (50, 23, 5))),
          xyrSeries("Series 2", Seq((13, 100, 7), (20, 80, 13), (100, 60, 10), (30, 40, 6), (50, 20, 12)))
        )
      }
    }
  }

  /** Create XYChart.Series from a sequence of number triplets (x, y, radius). */
  def xyrSeries(name: String, data: Seq[(Int, Int, Int)]) =
    XYChart.Series[Number, Number](
      name,
      ObservableBuffer(data.map {case (x, y, r) => XYChart.Data[Number, Number](x, y, r)})
    )
}
