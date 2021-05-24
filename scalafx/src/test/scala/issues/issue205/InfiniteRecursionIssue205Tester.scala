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
package issues.issue205

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.beans.property.StringProperty
import scalafx.collections.ObservableBuffer
import scalafx.event.ActionEvent
import scalafx.scene.control.TableColumn._
import scalafx.scene.control.{Button, TableColumn, TableView}
import scalafx.scene.layout.VBox
import scalafx.scene.{Scene, SnapshotResult}

/**
 * Helper app used to reproduce and then test fixes for issue #205 and related infinite recursions.
 */
object InfiniteRecursionIssue205Tester extends JFXApp {

  class Person(firstName_ : String, lastName_ : String) {

    val firstName = new StringProperty(this, "firstName", firstName_)
    val lastName  = new StringProperty(this, "lastName", lastName_)
  }

  val characters = ObservableBuffer[Person](
    new Person("Peggy", "Sue"),
    new Person("Rocky", "Raccoon")
  )

  characters += new Person("Rocky", "Raccoon")
  characters += new Person("Rocky", "Raccoon")
  characters += new Person("Rocky", "Raccoon")
  characters += new Person("Rocky", "Raccoon")
  characters += new Person("Rocky", "Raccoon")
  characters += new Person("Rocky", "Raccoon")
  characters += new Person("Rocky", "Raccoon")
  characters += new Person("Rocky", "Raccoon")
  characters += new Person("Rocky", "Raccoon")
  characters += new Person("Rocky", "Raccoon")
  characters += new Person("Rocky", "Raccoon")
  characters += new Person("Rocky", "Raccoon")
  characters += new Person("Rocky", "Raccoon")
  characters += new Person("Rocky", "Raccoon")
  characters += new Person("Rocky", "Raccoon")
  characters += new Person("Rocky", "Raccoon")
  characters += new Person("Rocky", "Raccoon")
  characters += new Person("Rocky", "Raccoon")

  val extraRow = new Person("Desmond", "Jones")
  characters += extraRow

  val tableView = new TableView[Person](characters) {
    columns ++= List(
      new TableColumn[Person, String] {
        text = "First Name"
        cellValueFactory = {
          _.value.firstName
        }
        prefWidth = 180
      },
      new TableColumn[Person, String]() {
        text = "Last Name"
        cellValueFactory = {
          _.value.lastName
        }
        prefWidth = 180
      }
    )
  }

  val scrollToButton = new Button {
    text = "scrollTo(item) - #205"
    onAction = (ae: ActionEvent) => {
      // This line would cause infinite recursion before fix
      tableView.scrollTo(extraRow)
    }

  }

  val snapshotButton = new Button {
    text = "snapshot  - #214"
    onAction = (ae: ActionEvent) => {
      def callback(result: SnapshotResult): Unit = {
        println("callback(" + result + ")")
      }
      // This line would cause infinite recursion before fix (also issue #214)
      tableView.snapshot(callback, null, null)
    }

  }

  stage = new PrimaryStage {
    title = "Simple Table View"
    scene = new Scene {
      root = new VBox {
        children = Seq(
          tableView,
          scrollToButton,
          snapshotButton
        )
      }
    }
  }
}
