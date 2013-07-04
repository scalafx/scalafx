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

import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.collections.ObservableBuffer
import scalafx.scene.Scene
import scalafx.scene.control.{TableView, TableColumn}

object SimpleNestedTableView extends JFXApp {

  val characters = ObservableBuffer[Person](
    new Person("Peggy", "Sue", "555-6798"),
    new Person("Desmond", "Sue", "555-6798"),
    new Person("Rocky", "Raccoon", "555-8036"),
    new Person("Molly", "Raccoon", "555-0789")
  )

  stage = new PrimaryStage {
    title = "Simple Table View Sorted"
    scene = new Scene {
      val firstNameColumn = new TableColumn[Person, String] {
        text = "First"
        cellValueFactory = {_.value.firstName}
        prefWidth = 180
      }
      val lastNameColumn = new TableColumn[Person, String] {
        text = "Last"
        cellValueFactory = {_.value.lastName}
        prefWidth = 180
      }
      val nameColumn = new TableColumn[Person, String] {
        text = "Name"
        columns +=(firstNameColumn, lastNameColumn)
      }

      val phoneColumn = new TableColumn[Person, String] {
        text = "Phone"
        cellValueFactory = {_.value.phone}
        prefWidth = 180
      }

      content = new TableView[Person](characters) {
        columns +=(nameColumn, phoneColumn)
      }
    }
  }
}

