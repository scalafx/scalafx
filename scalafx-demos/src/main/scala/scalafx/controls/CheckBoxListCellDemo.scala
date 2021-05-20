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

package scalafx.controls

import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.beans.property.BooleanProperty
import scalafx.collections.ObservableBuffer
import scalafx.scene.Scene
import scalafx.scene.control.cell.CheckBoxListCell
import scalafx.scene.control.{Button, ListView}
import scalafx.scene.layout.VBox

import scala.language.implicitConversions

/**
 * Example of using `CheckBoxListCell` in `ListView`.
 */
object CheckBoxListCellDemo extends JFXApp {

  class Item(initialSelection: Boolean, val name: String) {
    val selected = BooleanProperty(initialSelection)

    override def toString = name
  }

  val data = ObservableBuffer.from[Item](
    (1 to 10).map { i => new Item(i % 2 == 0, s"Item $i") }
  )

  stage = new PrimaryStage {
    scene = new Scene {
      title = "CheckBoxListCell Demo"
      root = new VBox {
        children = Seq(
          new ListView[Item] {
            prefHeight = 250
            items = data
            cellFactory = CheckBoxListCell.forListView((i: Item) => i.selected)
          },
          new Button("Print State ") {
            onAction = _ => {
              println("-------------")
              println(data.map(d => d.name + ": " + d.selected()).mkString("\n"))
            }
          }
        )
      }
    }
  }
}