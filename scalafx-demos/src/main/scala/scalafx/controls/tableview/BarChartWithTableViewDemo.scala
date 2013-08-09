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
package scalafx.controls.tableview

import javafx.scene.{chart => jfxsc}
import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.beans.property.{ObjectProperty, StringProperty}
import scalafx.collections.ObservableBuffer
import scalafx.geometry.{Insets, Pos}
import scalafx.scene.Scene
import scalafx.scene.chart.{XYChart, BarChart, CategoryAxis, NumberAxis}
import scalafx.scene.control.TableColumn._
import scalafx.scene.control.{Label, TableColumn, TableView}
import scalafx.scene.layout.{BorderPane, HBox}
import scalafx.stage.{Modality, Stage}

/** This demo shows two bar charts, when you click on a chart its data is shown as a table. */
object BarChartWithTableViewDemo extends JFXApp {

  class Position(name_ : String, value_ : Int) {
    val name = new StringProperty(this, "name", name_)
    val value = new ObjectProperty[Int](this, "value", value_)
  }

  val data1 = ObservableBuffer[Position](
    new Position("A", 26),
    new Position("B", 35),
    new Position("C", 18)
  )

  val data2 = ObservableBuffer[Position](
    new Position("P", 61),
    new Position("Q", 56),
    new Position("R", 78)
  )

  stage = new PrimaryStage {
    title = "BarChart with TableView"
    scene = new Scene(600, 350) {
      root = new BorderPane {
        top = new Label {
          text = "Click on chart to see a table view of the data"
          alignmentInParent = Pos.CENTER
          margin = Insets(25)
        }
        center = new HBox {
          content = Seq(
            createBarChart("Speculations", data1),
            createBarChart("Predictions", data2)
          )
        }
      }
    }
  }


  def createBarChart(title: String, data: ObservableBuffer[Position]): BarChart[String, Number] = {
    val barChart = BarChart(new CategoryAxis(), new NumberAxis())
    barChart.title = title
    barChart.data = createChartData(data)
    barChart.legendVisible = false
    barChart.onMouseClicked = showAsTable(barChart.title(), data)
    barChart
  }


  private def showAsTable(name: String, data: ObservableBuffer[Position]) {

    val tableView = new TableView[Position](data) {
      columns ++= List(
        new TableColumn[Position, String] {
          text = "Position"
          cellValueFactory = {_.value.name}
          prefWidth = 180
        },
        new TableColumn[Position, Int] {
          text = "Value"
          cellValueFactory = {_.value.value}
          prefWidth = 180
        }
      )
    }

    // Show as modal dialog
    new Stage {
      title = name
      initModality(Modality.WINDOW_MODAL)
      initOwner(BarChartWithTableViewDemo.stage)
      scene = new Scene {
        root = new BorderPane {
          center = tableView
        }
      }
    }.showAndWait()
  }


  def createChartData(data: ObservableBuffer[Position]): ObservableBuffer[jfxsc.XYChart.Series[String, Number]] = {
    val series = new XYChart.Series[String, Number]
    for (d <- data) {
      series.data() += XYChart.Data[String, Number](d.name(), d.value())
    }
    val answer = new ObservableBuffer[jfxsc.XYChart.Series[String, Number]]()
    answer += series
    answer
  }
}


