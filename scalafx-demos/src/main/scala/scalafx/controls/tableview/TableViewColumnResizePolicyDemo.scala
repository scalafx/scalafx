/*
 * Copyright (c) 2011-2015, ScalaFX Project
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

import scala.language.implicitConversions
import scalafx.application.JFXApp3
import scalafx.application.JFXApp3.PrimaryStage
import scalafx.beans.property.StringProperty
import scalafx.collections.ObservableBuffer
import scalafx.scene.Scene
import scalafx.scene.control.{Label, TableColumn, TableView}
import scalafx.scene.layout.VBox

/**
 * Demonstrates difference between
 * [[scalafx.scene.control.TableView#UnconstrainedResizePolicyUnconstrainedResizePolicy]] and
 * [[scalafx.scene.control.TableView#ConstrainedResizePolicyConstrainedResizePolicy]] in
 * [[scalafx.scene.control.TableViewTableView]].
 *
 * Based on JavaFX example from [[https://gist.github.com/SaiPradeepDandem/1581600]].
 */
object TableViewColumnResizePolicyDemo extends JFXApp3 {
  override def start(): Unit = {
    val box = new VBox {
      spacing = 15
      autosize()
    }
    stage = new PrimaryStage {
      scene = new Scene(700, 400) {
        title = "TableView Column Resize Policy Demo"
        root = box
      }
    }
    configureTable(box)
    def configureTable(root: VBox): Unit = {
      val data = ObservableBuffer(new MyDomain("Apple", "This is a fruit.", "Red"), new MyDomain("Orange", "This is also a fruit.", "Orange"), new MyDomain("Potato", "This is a vegetable.", "Brown"))
      val table1 = createTableView(data)
      table1.columnResizePolicy = TableView.ConstrainedResizePolicy
      val table2 = createTableView(data)
      table2.columnResizePolicy = TableView.UnconstrainedResizePolicy
      root.children = Seq(new Label("Constrained Resize Policy") { style = "-fx-font-weight:bold;" }, table1, new Label("Unconstrained Resize Policy") { style = "-fx-font-weight:bold;" }, table2)
    }
    def createTableView(data: ObservableBuffer[MyDomain]): TableView[MyDomain] = {
      val table = new TableView[MyDomain] {
        columns ++= Seq(new TableColumn[MyDomain, String] {
          text = "Title"
          prefWidth = 100
          cellValueFactory = {
            _.value.name
          }
        }.delegate, new TableColumn[MyDomain, String] {
          text = "Description"
          prefWidth = 250
          cellValueFactory = {
            _.value.description
          }
        }.delegate, new TableColumn[MyDomain, String] {
          text = "Color"
          prefWidth = 100
          cellValueFactory = {
            _.value.color
          }
        }.delegate)
        items = data
      }
      table
    }
    class MyDomain(val nameValue: String, val descriptionValue: String, val colorValue: String) {
      val name = new StringProperty(nameValue)
      val description = new StringProperty(descriptionValue)
      val color = new StringProperty(colorValue)
    }
  }
}
