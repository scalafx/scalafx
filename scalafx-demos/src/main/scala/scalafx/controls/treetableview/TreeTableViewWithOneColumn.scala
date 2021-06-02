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

import scalafx.application.JFXApp3
import scalafx.application.JFXApp3.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.control.TreeTableColumn.sfxTreeTableColumn2jfx
import scalafx.scene.control.{TreeItem, TreeTableColumn, TreeTableView}

/**
 * TreeTableView with One Column. ScalaFX version of example 15-1 in JavaFX
 * [[https://docs.oracle.com/javase/8/javafx/user-interface-tutorial/tree-table-view.htmTreeTable View tutorial]].
 */
object TreeTableViewWithOneColumn extends JFXApp3 {
  override def start(): Unit = {
    val rootNode = new TreeItem("Root node") {
      expanded = true
      children = Seq(new TreeItem("Child Node 1"), new TreeItem("Child Node 2"), new TreeItem("Child Node 3"))
    }
    stage = new PrimaryStage {
      scene = new Scene {
        title = "TreeTableView with One Column"
        root = new TreeTableView(rootNode) {
          columns += (new TreeTableColumn[String, String]("Column") {
            prefWidth = 150
            cellValueFactory = { p =>
              p.value.value
            }
          })
          prefWidth = 152
          showRoot = true
        }
      }
    }
  }
}
