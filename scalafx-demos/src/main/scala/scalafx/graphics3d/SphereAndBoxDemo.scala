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
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene._
import scalafx.scene.paint.{Color, PhongMaterial}
import scalafx.scene.shape.{Sphere, Box}
import scalafx.scene.transform.Rotate
import scalafx.beans.property.DoubleProperty
import scalafx.scene.input.MouseEvent


/** ScalaFX version of the demo from projavafx8-scratchpad */
object SphereAndBoxDemo extends JFXApp {

  stage = new PrimaryStage {
    title = "Sphere and Box Demo"
    scene = new Scene(500, 500, true) {

      val box = new Box(400, 400, 400) {
        material = new PhongMaterial {
          diffuseColor = Color.RED
          specularColor = Color.ORANGE
        }
        translateZ = 225
      }

      val sphere = new Sphere(200) {
        material = new PhongMaterial {
          diffuseColor = Color.BLUE
          specularColor = Color.LIGHTBLUE
        }
        translateZ = -225
      }

      // Put shapes in a groups so they can be rotated together
      val shapes = new Group(box, sphere)

      val light = new PointLight {
        color = Color.ANTIQUEWHITE
        translateX = -265
        translateY = -260
        translateZ = -625
      }

      root = new Group {
        // Put light outside of `shapes` group so it does not rotate
        content = new Group(shapes, light)
        translateX = 250
        translateY = 250
        translateZ = 725
        rotationAxis = Rotate.YAxis
      }

      camera = new PerspectiveCamera(false)

      addMouseInteraction(this, shapes)
    }
  }

  /** Add mouse interaction to a scene, rotating given node. */
  private def addMouseInteraction(scene: Scene, node: Node) {
    val angleY = DoubleProperty(-50)
    val yRotate = new Rotate {
      angle <== angleY
      axis = Rotate.YAxis
    }
    var anchorY: Double = 0
    var anchorAngleY: Double = 0

    node.transforms = Seq(yRotate)

    scene.onMousePressed = (event: MouseEvent) => {
      anchorY = event.sceneY
      anchorAngleY = angleY.get()
    }
    scene.onMouseDragged = (event: MouseEvent) => {
      angleY() = anchorAngleY + event.sceneX
    }
  }
}
