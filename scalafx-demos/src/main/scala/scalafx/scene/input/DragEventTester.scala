
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

package scalafx.scene.input

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.control.Label
import scalafx.scene.layout.StackPane

/** Helper for manual testing of DragEvents.
  *
  * Drag files or other items on the application window, see events processed printed in the console.
  *
  * @author Jarek Sacha
  */
object DragEventTester extends JFXApp {

  val stackPane = new StackPane {
    padding = Insets(10)
    content = new Label("Drop things here...")
  }

  stage = new PrimaryStage {
    title = "DragEvent Tester"
    scene = new Scene(stackPane, 200, 200) {
      onDragOver = (event: DragEvent) => {
        println("onDragOver: " + event)
        event.consume()
      }

      onDragDone = (event: DragEvent) => {
        println("onDragDone: " + event)
        event.consume()
      }

      onDragDropped = (event: DragEvent) => {
        println("onDragDropped: " + event)
        event.consume()
      }

      onDragEntered = (event: DragEvent) => {
        println("onDragEntered: " + event)
        event.consume()
      }

      onDragExited = (event: DragEvent) => {
        println("onDragExited: " + event)
        event.consume()
      }

      onDragOver = (event: DragEvent) => {
        println("onDragOver: " + event)
        event.consume()
      }
    }
  }
}
