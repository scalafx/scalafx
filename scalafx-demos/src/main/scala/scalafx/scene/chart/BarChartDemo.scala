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
import scalafx.scene.Scene

object BarChartDemo extends JFXApp {

  val years = Seq("2007", "2008", "2009")

  stage = new JFXApp.PrimaryStage {
    title = "BarChartDemo"
    scene = new Scene {
      root = new BarChart(CategoryAxis(), NumberAxis("Y Values")) {
        title = "Bar Chart"
        data = ObservableBuffer(
          xySeries("Apples", Seq(567, 1292, 1290)),
          xySeries("Lemons", Seq(956, 1665, 2559)),
          xySeries("Oranges", Seq(1154, 1927, 2774))
        )
      }
    }
  }

  /** Create XYChart.Series from a sequence of numbers matching year strings. */
  def xySeries(name: String, data: Seq[Int]) = {
    val series = years zip data
    XYChart.Series[String, Number](
      name,
      ObservableBuffer(series.map {case (x, y) => XYChart.Data[String, Number](x, y)})
    )
  }
}
