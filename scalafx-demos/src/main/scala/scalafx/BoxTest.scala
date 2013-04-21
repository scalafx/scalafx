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

package scalafx

import geometry.Insets
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.shape.Arc
import scalafx.scene.shape.Circle
import scalafx.scene.shape.Rectangle
import scene.layout.{VBox, HBox}
import scene.paint.Color

object BoxTest extends JFXApp {
  stage = new PrimaryStage {
    width = 600
    height = 450
    scene = new Scene {
      fill = Color.LIGHTGREEN
      content = new HBox {
        spacing = 10
        content = List(new Rectangle {
          width = 100
          height = 50
          fill = Color.RED
          stroke = Color.BLUE
          strokeWidth = 5
          margin = Insets(10)
        }, new VBox {
          spacing = 10
          content = for (i <- 0 until 3) yield new Circle {
            radius = 25
            fill = Color.BLUE
            stroke = Color.BLUE.brighter
            strokeWidth = 3
          }
        }, new Arc {
          radiusX = 25
          radiusY = 50
          startAngle = 135
          length = 45
          fill = Color.BLACK
          stroke = Color.YELLOW
          strokeWidth = 3
        })
      }
    }
  }
}
