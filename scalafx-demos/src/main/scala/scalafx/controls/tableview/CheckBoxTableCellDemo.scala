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

package scalafx.controls.tableview

import scalafx.application.JFXApp3
import scalafx.application.JFXApp3.PrimaryStage
import scalafx.beans.property.{BooleanProperty, StringProperty}
import scalafx.beans.value.ObservableValue
import scalafx.collections.ObservableBuffer
import scalafx.scene.Scene
import scalafx.scene.control.TableColumn._
import scalafx.scene.control.cell.CheckBoxTableCell
import scalafx.scene.control.{TableColumn, TableView}

import scala.language.implicitConversions

/**
 * Example of using `CheckBoxTableCell` in `TableView`.
 */
object CheckBoxTableCellDemo extends JFXApp3 {
  override def start(): Unit = {
    class Item(selected_ : Boolean, name_ : String) {
      val selected = new BooleanProperty(this, "selected", selected_)
      val name     = new StringProperty(this, "name", name_)
    }
    val data = ObservableBuffer.from[Item]((1 to 10).map { i =>
      new Item(i % 2 == 0, s"Item $i")
    })
    stage = new PrimaryStage {
      title = "Example of a Table View with Check Boxes"
      scene = new Scene {
        root = new TableView[Item](data) {
          columns ++= List(
            new TableColumn[Item, java.lang.Boolean] {
              text = "Selected"
              cellValueFactory = _.value.selected.asInstanceOf[ObservableValue[java.lang.Boolean, java.lang.Boolean]]
              cellFactory = CheckBoxTableCell.forTableColumn(this)
              editable = true
              prefWidth = 180
            },
            new TableColumn[Item, String] {
              text = "Name"
              cellValueFactory = {
                _.value.name
              }
              prefWidth = 180
            }
          )
          editable = true
        }
      }
    }
  }
}
