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

package issues.issue137

import scalafx.Includes._
import scalafx.application.JFXApp3
import scalafx.application.JFXApp3.PrimaryStage
import scalafx.collections.ObservableBuffer
import scalafx.scene.Scene
import scalafx.scene.control.TreeTableColumn._
import scalafx.scene.control._
import scalafx.scene.layout._
import scalafx.scene.paint.Color

/**
 * Sample code from https://github.com/scalafx/scalafx/issues/137#issuecomment-345154588
 * This not likely related to actual issue 137, but included for completeness of issue 137 discussion.
 * The compilation is supposed to fail in line with `foo`
 */
object TreeTableTester extends JFXApp3 {

  val characters: ObservableBuffer[Person] = ObservableBuffer[Person](
    new Person("Peggy", "Sue", "123", Color.Violet),
    new Person("Rocky", "Raccoon", "456", Color.GreenYellow),
    new Person("Bungalow ", "Bill", "789", Color.DarkSalmon)
  )

  override def start(): Unit = {
    val table = new TreeTableView[Person](
      new TreeItem[Person](new Person("", "", "", Color.Red)) {
        expanded = true
        children = characters.map(new TreeItem[Person](_)).toSeq
      }
    ) {
      columns ++= List(
        new TreeTableColumn[Person, String] {
          text = "First Name"
          cellValueFactory = {
            _.value.value.value.firstName
          }
          prefWidth = 180
        },
        new TreeTableColumn[Person, String]() {
          text = "Last Name"
          cellValueFactory = {
            _.value.value.value.lastName
          }
          prefWidth = 180
        }
      )
    }

    stage = new PrimaryStage {
      title = "Simple Table View"
      scene = new Scene {
        content = new VBox() {
          children = List(
            new Button("Test it") {
              onAction = p => {
                val foo: ObservableBuffer[TreeItem[Person]] = table.root.value.children.map(p => {
                  val bar: TreeItem[Person] = p
                  p
                })
                table.root.value.children = foo.toSeq
              }
            },
            table
          )
        }
      }
    }
  }
}
