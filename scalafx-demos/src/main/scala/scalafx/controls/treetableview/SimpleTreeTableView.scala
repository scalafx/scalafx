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
package scalafx.controls.treetableview

import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.controls.tableview.Person
import scalafx.scene.Scene
import scalafx.scene.control.{TreeTableColumn, TreeTableView, TreeItem}
import scalafx.scene.control.TreeTableColumn._

object SimpleTreeTableView extends JFXApp {

  val treeRoot = new TreeItem[Person](new Person("Peggy", "Sue", "555-6798"))
  treeRoot.children.add(new TreeItem[Person](new Person("Rocky", "Raccoon", "555-6798")))


  stage = new PrimaryStage {
    title = "Simple Table View"
    scene = new Scene {
      content = new TreeTableView[Person](treeRoot) {
        columns ++= List(
          new TreeTableColumn[Person, String] {
            text = "First Name"
            cellValueFactory = {_.value.getValue.firstName}
            prefWidth = 180
          },
          new TreeTableColumn[Person, String]() {
            text = "Last Name"
            cellValueFactory = {_.value.getValue.lastName}
            prefWidth = 180
          }
        )
      }
    }
  }
}
