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
package scalafx.canvas

import scalafx.Includes._
import scalafx.application.JFXApp3
import scalafx.application.JFXApp3.PrimaryStage
import scalafx.beans.property.DoubleProperty.sfxDoubleProperty2jfx
import scalafx.scene.canvas.Canvas
import scalafx.scene.input.MouseEvent
import scalafx.scene.paint.Stop.sfxStop2jfx
import scalafx.scene.paint.{Color, CycleMethod, LinearGradient, Stop}
import scalafx.scene.shape.Rectangle
import scalafx.scene.{Group, Scene}

/**
 * Example adapted from code showed in [[http://docs.oracle.com/javafx/2/canvas/jfxpub-canvas.htm]].
 */
object CanvasDoodleTest extends JFXApp3 {
  override def start(): Unit = {
    val canvas = new Canvas(200, 200)
    val rect = new Rectangle {
      height = 400
      width = 400
      fill = new LinearGradient(0, 0, 1, 1, true, CycleMethod.Reflect, List(Stop(0, Color.Red), Stop(1, Color.Yellow)))
    }
    val rootPane = new Group
    rootPane.children = List(rect, canvas)
    stage = new PrimaryStage {
      title = "Canvas Doodle Test"
      scene = new Scene(400, 400) { root = rootPane }
    }
    canvas.translateX = 100
    canvas.translateY = 100
    val gc = canvas.graphicsContext2D
    reset(Color.Blue)
    canvas.onMouseDragged = (e: MouseEvent) => {
      gc.clearRect(e.x - 2, e.y - 2, 5, 5)
    }
    canvas.onMouseClicked = (e: MouseEvent) => {
      if (e.clickCount > 1) {
        reset(Color.Blue)
      }
    }
    def reset(color: Color): Unit = {
      gc.fill = color
      gc.fillRect(0, 0, canvas.width.get, canvas.height.get)
    }
  }
}
