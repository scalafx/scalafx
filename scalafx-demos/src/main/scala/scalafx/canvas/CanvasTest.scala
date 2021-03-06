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
package scalafx.canvas

import scalafx.application.JFXApp3
import scalafx.application.JFXApp3.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.canvas.Canvas
import scalafx.scene.effect.DropShadow
import scalafx.scene.paint.Stop.sfxStop2jfx
import scalafx.scene.paint.{Color, CycleMethod, LinearGradient, RadialGradient, Stop}

/**
 * Example adapted from code showed in [[http://docs.oracle.com/javafx/2/canvas/jfxpub-canvas.htm]].
 */
object CanvasTest extends JFXApp3 {
  override def start(): Unit = {
    val canvas = new Canvas(200, 200)
    val gc     = canvas.graphicsContext2D
    canvas.translateX = 0
    canvas.translateY = 0
    gc.beginPath()
    gc.moveTo(50, 50)
    gc.bezierCurveTo(150, 20, 150, 150, 75, 150)
    gc.closePath()
    gc.fill = new RadialGradient(
      0,
      0,
      0.5d,
      0.5d,
      0.1d,
      true,
      CycleMethod.Reflect,
      List(Stop(0.0d, Color.Red), Stop(1.0d, Color.Yellow))
    )
    gc.fillPath()
    val lg =
      new LinearGradient(0, 0, 1, 1, true, CycleMethod.Reflect, List(Stop(0.0d, Color.Blue), Stop(1.0d, Color.Green)))
    gc.stroke = lg
    gc.lineWidth = 20
    gc.strokePath()
    gc.applyEffect(new DropShadow(20, 20, 0, Color.Gray))
    gc.applyEffect(new DropShadow(20, 0, 20, Color.Blue))
    gc.applyEffect(new DropShadow(20, -20, 0, Color.Green))
    gc.applyEffect(new DropShadow(20, 0, -20, Color.Red))
    stage = new PrimaryStage {
      title = "Canvas Test"
      scene = new Scene(400, 400) { content = canvas }
    }
  }
}
