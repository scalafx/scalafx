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
package scalafx.graphics3d

import scalafx.Includes._
import scalafx.animation._
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.paint.Color
import scalafx.scene.shape.Rectangle
import scalafx.scene.transform.{Rotate, Translate}
import scalafx.scene.{Node, PerspectiveCamera, Scene, Group}

/**
 * A port of the JavaFX Ensemble CubeSampleDemo
 *
 * A sample that demonstrates an animated rotation of 3D cubes. When the
 * application runs in standalone mode, the scene must be constructed with
 * the depthBuffer argument set to true, and the root node must have depthTest
 * set to true.
 *
 * @author Peter Pilgrim (peter)
 * @author JavaFX SDK Team
 */

object CubeSampleDemo extends JFXApp {

    var animation: Timeline = _
    var root = new Group
    stage = new PrimaryStage {
//      width = 800
//      height = 600
      scene = new Scene( root, 400, 150, true )
      resizable = false
      title = "Graphics 3D Cubes Sample Demo in ScalaFX"
    }

    root.getTransforms.addAll( new Translate(400 / 2, 150 / 2), new Rotate(180, Rotate.XAxis) )

    stage.getScene.setCamera( new PerspectiveCamera() )

    root.children.add(create3dContent())


    def create3dContent():Node = {
      val c = new Cube(50,Color.RED,1)
      c.rx.setAngle(45)
      c.ry.setAngle(45)
      val c2 = new Cube(50,Color.GREEN,1)
      c2.setTranslateX(100)
      c2.rx.setAngle(45)
      c2.ry.setAngle(45)
      val c3 = new Cube(50,Color.ORANGE,1)
      c3.setTranslateX(-100)
      c3.rx.setAngle(45)
      c3.ry.setAngle(45)

      animation = new Timeline {
        cycleCount = Timeline.INDEFINITE
        keyFrames = Seq(
          at (0 s) { c.ry.angle -> 0d },
          at (0 s) { c2.rx.angle -> 0d },
          at (0 s) { c3.rz.angle -> 0d },
          at (1 s) { c.ry.angle -> 360d },
          at (1 s) { c2.rx.angle -> 360d },
          at (1 s) { c3.rz.angle -> 360d }
        )
      }

      new Group(c,c2,c3)
    }

    def play() {
      animation.play()
    }

    def stop() {
      animation.pause()
    }

    play()
}


class Cube( size: Double, color: Color, shade: Double) extends Group {
  val rx = new Rotate(0,Rotate.XAxis)
  val ry = new Rotate(0,Rotate.YAxis)
  val rz = new Rotate(0,Rotate.ZAxis)

  transforms = Seq(rz, ry, rx)

  children = Seq(
      new Rectangle { // back face
        width = size
        height = size
        fill = color.deriveColor(0.0, 1.0, (1 - 0.5*shade), 1.0)
        translateX = -0.5*size
        translateY = -0.5*size
        translateZ = 0.5*size
      },
      new Rectangle { // bottom face
        width = size ; height = size
        fill = color.deriveColor(0.0, 1.0, (1 - 0.4*shade), 1.0)
        translateX = -0.5*size
        translateY = 0
        rotationAxis = Rotate.XAxis
        rotate = 90
      },
      new Rectangle { // right face
        width = size ; height = size
        fill = color.deriveColor(0.0, 1.0, (1 - 0.3*shade), 1.0)
        translateX = -1*size
        translateY = -0.5*size
        rotationAxis = Rotate.YAxis
        rotate = 90
      },
      new Rectangle { // left face
        width = size; height = size
        fill = color.deriveColor(0.0, 1.0, (1 - 0.2*shade), 1.0)
        translateX = 0
        translateY = -0.5*size
        rotationAxis = Rotate.YAxis
        rotate = 90
      },
      new Rectangle { // top face
        width = size; height = size
        fill = color.deriveColor(0.0, 1.0, (1 - 0.1*shade), 1.0)
        translateX = -0.5*size
        translateY = -1*size
        rotationAxis = Rotate.XAxis
        rotate = 90
      },
      new Rectangle { // top face
        width = size; height = size
        fill = color
        translateX = -0.5*size
        translateY = -0.5*size
        translateZ = -0.5*size
      }
    )

}
