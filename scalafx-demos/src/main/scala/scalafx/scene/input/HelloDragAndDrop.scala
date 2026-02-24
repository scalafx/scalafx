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

package scalafx.scene.input

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

import scalafx.Includes.*
import scalafx.application.JFXApp3
import scalafx.application.JFXApp3.PrimaryStage
import scalafx.scene.paint.Color
import scalafx.scene.text.Text
import scalafx.scene.{Group, Scene}

/**
 * Demonstrates a drag-and-drop feature.
 *
 * Based on: [[https://docs.oracle.com/javafx/2/drag_drop/HelloDragAndDrop.java.html]]
 */
object HelloDragAndDrop extends JFXApp3 {

  override def start(): Unit = {

    val source = new Text(50, 100, "DRAG ME") {
      scaleX = 2.0
      scaleY = 2.0

      onDragDetected = event => {
        /* drag was detected, start drag-and-drop gesture*/
        println("onDragDetected")

        /* allow any transfer mode */
        val db = startDragAndDrop(TransferMode.Any: _*)

        /* put a string on dragboard */
        val content = new ClipboardContent() {
          putString(text())
        }

        db.setContent(content)

        event.consume()
      }

      onDragDone = event => {
        /* the drag-and-drop gesture ended */
        System.out.println("onDragDone")
        /* if the data was successfully moved, clear it */
        if (event.transferMode == TransferMode.Move) {
          text = ""
        }

        event.consume()
      }
    }

    val target = new Text(250, 100, "DROP HERE") {
      self =>
      scaleX = 2.0
      scaleY = 2.0

      onDragOver = event => {
        /* data is dragged over the target */
        println("onDragOver")

        /* accept it only if it is  not dragged from the same node
         * and if it has a string data */
        if (event.gestureSource != self && event.dragboard.hasString) {
          /* allow for both copying and moving, whatever user chooses */
          event.acceptTransferModes(TransferMode.CopyOrMove: _*)
        }

        event.consume()
      }

      onDragEntered = (event: DragEvent) => {
        /* the drag-and-drop gesture entered the target */
        println("onDragEntered")
        /* show to the user that it is an actual gesture target */
        if (event.gestureSource != self && event.dragboard.hasString) {
          fill = Color.Green
        }

        event.consume()
      }

      onDragExited = event => {
        /* mouse moved away, remove the graphical cues */
        fill = Color.Black

        event.consume()
      }

      onDragDropped = event => {
        /* data dropped */
        println("onDragDropped")
        /* if there is a string data on dragboard, read it and use it */
        val db      = event.dragboard
        var success = false
        if (db.hasString) {
          text = db.string
          success = true
        }
        /* let the source know whether the string was successfully
         * transferred and used */
        event.setDropCompleted(success)

        event.consume()
      }
    }

    stage = new PrimaryStage {
      title = "Hello Drag And Drop"
      scene = new Scene(400, 200) {
        fill = Color.LightGreen
        root = new Group {
          children ++= Seq(source, target)
        }
      }
    }
  }
}
