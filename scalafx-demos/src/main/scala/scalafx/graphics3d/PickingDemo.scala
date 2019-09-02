/*
 * Copyright (c) 2011-2015, ScalaFX Project
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
import scalafx.beans.property.DoubleProperty
import scalafx.scene._
import scalafx.scene.input.MouseEvent
import scalafx.scene.paint.{Color, PhongMaterial}
import scalafx.scene.shape.{Box, Sphere}
import scalafx.scene.transform.Rotate

/** Illustrates picking of 3D objects.
  * When user picks (clocks) on an object in a 3D scene the object name is printed to console. */
object PickingDemo extends JFXApp {

  stage = new PrimaryStage {
    title = "Picking Demo"
    scene = new Scene(500, 500, true, SceneAntialiasing.Balanced) {

      val box = new Box(400, 400, 400) {
        material = new PhongMaterial {
          diffuseColor = Color.Red
          specularColor = Color.Pink
        }
        translateZ = 225
        id = "Box"
      }

      val sphere = new Sphere(200) {
        material = new PhongMaterial {
          diffuseColor = Color.Blue
          specularColor = Color.LightBlue
        }
        translateZ = -225
        id = "Sphere"
      }

      // Put shapes in a groups so they can be rotated together
      val shapes = new Group(box, sphere)

      val light = new PointLight {
        color = Color.AntiqueWhite
        translateX = -265
        translateY = -260
        translateZ = -625
      }

      root = new Group {
        // Put light outside of `shapes` group so it does not rotate
        children = new Group(shapes, light)
        translateX = 250
        translateY = 250
        translateZ = 825
        rotationAxis = Rotate.YAxis
      }

      camera = new PerspectiveCamera(false)

      addMouseInteraction(this, shapes)
    }
  }

  /** Add mouse interaction to a scene, rotating given node. */
  private def addMouseInteraction(scene: Scene, group: Group) {
    val angleY = DoubleProperty(-50)
    val yRotate = new Rotate {
      angle <== angleY
      axis = Rotate.YAxis
    }
    var anchorX: Double = 0
    var anchorAngleY: Double = 0

    group.transforms = Seq(yRotate)

    scene.onMousePressed = (event: MouseEvent) => {
      anchorAngleY = angleY()
      anchorX = event.sceneX

      // Retrieve information about a pick
      val pickResult = event.pickResult

      // If picked on a Node, place green marker at the location of the pick
      pickResult.intersectedNode match {
        case Some(n) =>
          println("Picked node: '" + n.id() + "'")
          val p = pickResult.intersectedPoint
          group.children += createMarker(x = p.x + n.translateX(), y = p.y + n.translateY(), z = p.z + n.translateZ())
        case None => println("Picked nothing.")
      }
    }

    scene.onMouseDragged = (event: MouseEvent) => {
      angleY() = anchorAngleY + anchorX - event.sceneX
    }

  }

  private def createMarker(x: Double, y: Double, z: Double): Sphere = new Sphere(35) {
    material = new PhongMaterial {
      diffuseColor = Color.Gold
      specularColor = Color.LightGreen
    }
    translateX = x
    translateY = y
    translateZ = z
  }
}
