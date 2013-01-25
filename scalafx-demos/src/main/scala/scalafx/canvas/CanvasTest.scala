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
import scalafx.scene.effect.DropShadow
import scalafx.scene.paint.Color
import scalafx.scene.paint.CycleMethod
import scalafx.scene.paint.LinearGradient
import scalafx.scene.paint.RadialGradient
import scalafx.scene.paint.Stop
import scalafx.scene.paint.Stop.sfxStop2jfx

/**
 * Example adapted from code showed in [[http://docs.oracle.com/javafx/2/canvas/jfxpub-canvas.htm]].
 */
object CanvasTest extends JFXApp {

  val canvas = new Canvas(200, 200)
  val gc = canvas.graphicsContext2D

  /*
   * Moves the canvas to a new location within the Scene. This is accomplished
   * by performing a translation transformation on the Canvas object, passing
   * in the desired x and y coordinates. Passing in values of 0,0 will position
   * the Canvas in the upper left corner of the Scene.
   */
  //  moveCanvas(0, 0)-
  canvas.translateX = 0
  canvas.translateY = 0

  /*
   * Draws an area in the shape of a capital letter "D."
   * The user can try substituting numbers
   * of their own in the bezierCurveTo parameters to
   * warp the shape away from the letter "D."
   */
  //  drawDShape
  gc.beginPath
  gc.moveTo(50, 50)
  gc.bezierCurveTo(150, 20, 150, 150, 75, 150)
  gc.closePath

  /*
   * Draws a radial gradient on the Canvas object, which appears as a series of
   * circles radiating outward. This demo uses RED and YELLOW by default.
   */
  //  drawRadialGradient(Color.RED, Color.YELLOW)
  gc.fill = new RadialGradient(0, 0, 0.5, 0.5, 0.1, true, CycleMethod.REFLECT, List(Stop(0.0, Color.RED), Stop(1.0, Color.YELLOW)))
  gc.fillPath

  /*
   * Draws a radial gradient on the Canvas object, which appears as a series of
   * circles radiating outward. This demo uses RED and YELLOW by default.
   */
  //  drawLinearGradient(Color.BLUE, Color.GREEN)
  val lg = new LinearGradient(0, 0, 1, 1, true, CycleMethod.REFLECT, List(Stop(0.0, Color.BLUE), Stop(1.0, Color.GREEN)))
  gc.stroke = lg
  gc.lineWidth = 20
  gc.strokePath

  /**
   * Draws a radial gradient on the Canvas object, which appears as a series of
   * circles radiating outward. This demo uses RED and YELLOW by default.
   */
  //  drawDropShadow(Color.GRAY, Color.BLUE, Color.GREEN, Color.RED)
  gc.applyEffect(new DropShadow(20, 20, 0, Color.GRAY))
  gc.applyEffect(new DropShadow(20, 0, 20, Color.BLUE))
  gc.applyEffect(new DropShadow(20, -20, 0, Color.GREEN))
  gc.applyEffect(new DropShadow(20, 0, -20, Color.RED))

  stage = new PrimaryStage {
    title = "Canvas Test"
    scene = new Scene(400, 400) {
      content = canvas
    }
  }

}