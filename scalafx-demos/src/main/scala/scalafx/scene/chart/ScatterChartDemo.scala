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


object ScatterChartDemo extends JFXApp {

  stage = new JFXApp.PrimaryStage {
    title = "ScatterChartDemo"
    scene = new Scene {
      root = new ScatterChart(NumberAxis("X", 0, 6, 1), NumberAxis("Y", 0, 6, 1)) {
        title = "Scatter Chart"
        legendSide = Side.RIGHT
        data = ObservableBuffer(
          xySeries("Series 1", Seq((0.1, 0.2), (1.1, 0.8), (1.9, 2.5), (3.2, 3.3), (3.9, 3.5), (5.1, 5.4))),
          xySeries("Series 2", Seq((0, 4), (1, 1), (2, 4.5), (3, 3.5), (4, 4.25), (5, 4.5))),
          xySeries("Series 3", Seq((0, 1), (1, 2.55), (2, 4), (3, 3), (4, 4.5), (5, 5.5))))
      }
    }
  }

  /** Create XYChart.Series from a sequence of number pairs. */
  def xySeries(name: String, data: Seq[(Double, Double)]) =
    XYChart.Series[Number, Number](
      name,
      ObservableBuffer(data.map {case (x, y) => XYChart.Data[Number, Number](x, y)})
    )
}
