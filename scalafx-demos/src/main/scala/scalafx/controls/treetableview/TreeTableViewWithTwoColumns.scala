/*
 * Copyright (c) 2011-2016, ScalaFX Project
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
import scalafx.beans.property.{ReadOnlyStringWrapper, StringProperty}
import scalafx.scene.Scene
import scalafx.scene.control.TreeTableColumn.sfxTreeTableColumn2jfx
import scalafx.scene.control.{TreeItem, TreeTableColumn, TreeTableView}
import scalafx.scene.image.ImageView
import scalafx.scene.paint.Color

/**
  * TreeTableView with One Column.
  * ScalaFX version of example 15-2 in JavaFX
  * [[https://docs.oracle.com/javase/8/javafx/user-interface-tutorial/tree-table-view.htm Tree Table View tutorial]].
  */
object TreeTableViewWithTwoColumns extends JFXApp {

  case class Employee(name: StringProperty, email: StringProperty) {
    def this(_name: String, _email: String) = this(StringProperty(_name), StringProperty(_email))
  }

  val employees = Seq(
    new Employee("Ethan Williams", "ethan.williams@example.com"),
    new Employee("Emma Jones", "emma.jones@example.com"),
    new Employee("Michael Brown", "michael.brown@example.com"),
    new Employee("Anna Black", "anna.black@example.com"),
    new Employee("Rodger York", "roger.york@example.com"),
    new Employee("Susan Collins", "susan.collins@example.com")
  )

  val depIcon = new ImageView(getClass.getResource("department.png").toExternalForm)

  assert(depIcon != null)

  val rootNode = new TreeItem(new Employee("Sales Department", ""), depIcon) {
    expanded = true
    children = employees.map(new TreeItem(_))
  }

  stage = new PrimaryStage {
    title = "TreeTableView with Two Columns"
    scene = new Scene(400, 400) {
      fill = Color.LightGray
      root = new TreeTableView[Employee](rootNode) {
        columns ++= Seq(
          new TreeTableColumn[Employee, String]("Employee") {
            prefWidth = 150
            cellValueFactory = { p =>
              ReadOnlyStringWrapper(p.value.value.value.name())
            }
          },
          new TreeTableColumn[Employee, String]("Email") {
            prefWidth = 190
            cellValueFactory = { p =>
              ReadOnlyStringWrapper(p.value.value.value.email())
            }
          }
        )
        tableMenuButtonVisible = true
      }
    }
  }

}
