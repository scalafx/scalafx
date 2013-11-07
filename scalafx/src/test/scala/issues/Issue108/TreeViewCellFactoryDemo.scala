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

package issues.issue108

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.collections.ObservableBuffer
import scalafx.scene.Scene
import scalafx.scene.control._

/** Illustrates Issue 108 : Compilation error when creating TreeView cellFactory. */
object TreeViewCellFactoryDemo extends JFXApp {

  case class Person(firstName: String, lastName: String)

  val characters = ObservableBuffer[Person](
    Person("Bungalow ", "Bill"),
    Person("Dennis", "O’Dell"),
    Person("Eleanor", "Rigby"),
    Person("Rocky", "Raccoon"),
    Person("Peggy", "Sue")
  )

  stage = new PrimaryStage {
    title = "TreeView CellFactory Demo"
    scene = new Scene {
      content = new TreeView[Person] {
        prefWidth = 200
        prefHeight = 150
        showRoot = false
        root = new TreeItem[Person] {
          expanded = true
          children = ObservableBuffer(characters.map { p => new TreeItem(p) })
        }
        // Following statement, if uncommented, fails during compilation with error:
        //   type mismatch;
        //     found   : scalafx.scene.control.TreeCell[issues.issue108.TreeViewCellFactoryDemo.Person]
        //     required: javafx.scene.control.TreeCell[issues.issue108.TreeViewCellFactoryDemo.Person]
        //         cellFactory = (v: TreeView[Person]) => new TreeCell[Person] {
        //                                  ^
        cellFactory = (v: TreeView[Person]) => new TreeCell[Person] {
          treeItem.onChange((_, _, p) =>
            text = if (p != null) p.value().firstName + " " + p.value().lastName else "?"
          )
        }
      }
    }
  }
}
