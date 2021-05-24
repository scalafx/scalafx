/*
 * Copyright (c) 2011-2019, ScalaFX Project
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

package scalafx.controls.treeview

import scalafx.Includes._
import scalafx.application.JFXApp3
import scalafx.application.JFXApp3.PrimaryStage
import scalafx.collections.ObservableBuffer
import scalafx.scene.Scene
import scalafx.scene.control._

/**
 * Improper implementation of cellFactory may lead to rendering artifacts. The JavaFX recommended way is to overwrite
 * `TreeCell`'s `updateItem` method. This requires implementing JavaFX rather ScalaFX version of
 */
object TreeViewCellFactoryDemo extends JFXApp3 {
  override def start(): Unit = {
    case class Person(firstName: String, lastName: String, children: List[Person] = Nil)
    val children1 = List(Person("Bungalow", "Bill"), Person("Dennis", "O\u2019Dell"), Person("Peggy", "Sue"), Person("Molly", "Jones"))
    val children2 = List(Person("Maxwell", "Edison"), Person("Desmond", "Jones"), Person("Loretta", "Martin"))
    val parents = ObservableBuffer[Person](Person("Eleanor", "Rigby", children1), Person("Rocky", "Raccoon", children2))
    def toTreeItem(p: Person): TreeItem[Person] = {
      if (p.children.isEmpty) new TreeItem(p) else new TreeItem(p) { children = p.children map toTreeItem }
    }
    stage = new PrimaryStage {
      title = "TreeView CellFactory Demo"
      scene = new Scene {
        content = new TreeView[Person] {
          prefWidth = 250
          prefHeight = 250
          showRoot = false
          root = new TreeItem[Person] {
            expanded = true
            children = parents.map(toTreeItem).toSeq
          }
          cellFactory = _ => new javafx.scene.control.TreeCell[Person] {
            val self: TreeCell[Person] = this
            override def updateItem(item: Person, empty: Boolean): Unit = {
              super.updateItem(item, empty)
              self.graphic = null
              self.text = item match {
                case p: Person =>
                  p.firstName + " " + p.lastName
                case null =>
                  null
              }
            }
          }
        }
      }
    }
  }
}
