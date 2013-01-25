/*
 * Copyright (c) 2012, ScalaFX Project
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

import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.canvas.Canvas
import scalafx.scene.paint.Color
import scalafx.scene.shape.ArcType

/**
 * Example adapted from code showed in [[http://docs.oracle.com/javafx/2/canvas/jfxpub-canvas.htm]].
 */
object BasicOpsTest extends JFXApp {

  val canvas = new Canvas(300, 300)
  val gc = canvas.graphicsContext2D

  gc.fill = Color.GREEN
  gc.stroke = Color.BLUE
  gc.lineWidth = 5
  gc.strokeLine(40, 10, 10, 40)
  gc.fillOval(10, 60, 30, 30)
  gc.strokeOval(60, 60, 30, 30)
  gc.fillRoundRect(110, 60, 30, 30, 10, 10)
  gc.strokeRoundRect(160, 60, 30, 30, 10, 10)
  gc.fillArc(10, 110, 30, 30, 45, 240, ArcType.OPEN)
  gc.fillArc(60, 110, 30, 30, 45, 240, ArcType.CHORD)
  gc.fillArc(110, 110, 30, 30, 45, 240, ArcType.ROUND)
  gc.strokeArc(10, 160, 30, 30, 45, 240, ArcType.OPEN)
  gc.strokeArc(60, 160, 30, 30, 45, 240, ArcType.CHORD)
  gc.strokeArc(110, 160, 30, 30, 45, 240, ArcType.ROUND)
  gc.fillPolygon(Seq((10.0, 210), (40, 210), (10, 240), (40, 240)))
  gc.strokePolygon(Seq((60.0, 210), (90, 210), (60, 240), (90, 240)))
  gc.strokePolyline(Seq((110.0, 210), (140, 210), (110, 240), (140, 240)))

  stage = new PrimaryStage {
    title = "Drawing Operations Test"
    scene = new Scene {
      content = canvas
    }
  }
}