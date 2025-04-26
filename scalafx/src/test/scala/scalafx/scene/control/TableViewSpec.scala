/*
 * Copyright (c) 2011-2025, ScalaFX Project
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
package scalafx.scene.control

import javafx.scene.control as jfxsc
import org.scalatest.matchers.should.Matchers.*
import scalafx.Includes.*
import scalafx.collections.ObservableBuffer
import scalafx.testutil.{RunOnApplicationThread, SimpleSFXDelegateSpec}

/**
 * TableViewSpec tests.
 */
class TableViewSpec[S]
    extends SimpleSFXDelegateSpec[jfxsc.TableView[S], TableView[S]](
      classOf[jfxsc.TableView[S]],
      classOf[TableView[S]]
    )
    with RunOnApplicationThread {

  it should "not drop assigned columns - Issue 41" in {
    val firstTC = new TableColumn[String, String]("First Name")
    val lastTC  = new TableColumn[String, String]("Last Name")

    val tableView = new TableView[String]()
    tableView.columns.size should (equal(0))

    tableView.columns ++= Seq(firstTC, lastTC)
    tableView.columns.size should (equal(2))
  }

  it should "not drop assigned sort order - Issue 43" in {
    val firstTC = new TableColumn[String, String]("First Name")
    val lastTC  = new TableColumn[String, String]("Last Name")

    val tableView = new TableView[String]()
    tableView.columns.size should (equal(0))

    tableView.columns ++= Seq(firstTC, lastTC)
    tableView.columns.size should (equal(2))

    tableView.sortOrder.size should (equal(0))
    tableView.sortOrder += lastTC
    tableView.sortOrder.size should (equal(1))
    tableView.sortOrder += firstTC
    tableView.sortOrder.size should (equal(2))
    tableView.sortOrder.clear()
    tableView.sortOrder.size should (equal(0))
  }

  it should "not alter the delegate state during implicit conversion - Issue 154" in {
    val rocky      = "Rocky"
    val characters = ObservableBuffer[String]("Peggy", "Sue", "555-6798", rocky, "Raccoon", "555-6798")

    val tableView = new TableView[String](characters) {
      columns += new TableColumn[String, String]("Name")
    }

    tableView.getSelectionModel.select(rocky)
    tableView.getSelectionModel.selectedItem.value should equal(rocky)

    // Clear selection
    // TODO Scala 3: Original line of code does not compile with Scala 3.0.0-RC2
    //   Workaround for Scala 3 bug https://github.com/lampepfl/dotty/issues/12091
    // tableView.selectionModel.value.clearSelection()
    val value = tableView.selectionModel.value
    value.clearSelection()
    tableView.getSelectionModel.selectedItem.value should equal(null)

    tableView.selectionModel().select(rocky)
    tableView.selectionModel().selectedItem() should equal(rocky)

    // Clear selection
    tableView.selectionModel().clearSelection()
    tableView.selectionModel().selectedItem() should equal(null)

  }
}
