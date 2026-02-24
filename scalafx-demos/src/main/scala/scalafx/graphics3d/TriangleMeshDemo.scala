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

package scalafx.graphics3d

import scalafx.Includes._
import scalafx.application.JFXApp3
import scalafx.application.JFXApp3.PrimaryStage
import scalafx.beans.property.DoubleProperty
import scalafx.scene.image.Image
import scalafx.scene.input.MouseEvent
import scalafx.scene.paint.{Color, PhongMaterial}
import scalafx.scene.shape.{MeshView, TriangleMesh}
import scalafx.scene.transform.Rotate
import scalafx.scene._

import scala.math.sqrt

/**
 * Demonstrates custom 3D shapes.
 *
 * @author
 *   Mike Allen (mike@hindsight-consulting.com).
 */
object TriangleMeshDemo extends JFXApp3 {
  override def start(): Unit = {
    stage = new PrimaryStage {
      title = "TriangleMesh Demo"
      scene = new Scene(500, 500, true, SceneAntialiasing.Balanced) {
        fill = Color.Beige
        val tetra: MeshView = new MeshView(tetrahedron(500.0d)) {
          val image = new Image(this, "images/TetrahedronMap.png")
          material = new PhongMaterial {
            specularColor = Color.White
            diffuseMap = image
          }
        }
        val shapes = new Group(tetra)
        val pointLight = new PointLight {
          color = Color.AntiqueWhite
          translateX = -300.0d
          translateY = -300.0d
          translateZ = -700.0d
        }
        val ambientLight = new AmbientLight { color = Color.White }
        root = new Group {
          children = new Group(shapes, pointLight, ambientLight)
          translateX = 250.0d
          translateY = 250.0d
          translateZ = 700.0d
          rotationAxis = Rotate.YAxis
        }
        camera = new PerspectiveCamera(false)
        addMouseInteraction(this, shapes)
      }
    }
    def tetrahedron(length: Double) = {
      require(length > 0.0d)
      val mesh = new TriangleMesh()
      mesh.points = Array(
        0.0f,
        -(length * sqrt(3.0d) / 3.0d).toFloat,
        0.0f,
        (length / 2.0d).toFloat,
        (length * sqrt(3.0d) / 6.0d).toFloat,
        0.0f,
        -(length / 2.0d).toFloat,
        (length * sqrt(3.0d) / 6.0d).toFloat,
        0.0f,
        0.0f,
        0.0f,
        -(length * sqrt(2.0d / 3.0d)).toFloat
      )
      mesh.texCoords = Array(
        0.5f,
        1.0f,
        0.75f,
        (1.0d - sqrt(3.0d) / 4.0d).toFloat,
        0.25f,
        (1.0d - sqrt(3.0d) / 4.0d).toFloat,
        1.0f,
        1.0f,
        0.5f,
        (1.0d - sqrt(3.0d) / 2.0d).toFloat,
        0.0f,
        1.0f
      )
      mesh.faces = Array(0, 0, 1, 1, 2, 2, 1, 1, 0, 0, 3, 3, 2, 2, 1, 1, 3, 4, 0, 0, 2, 2, 3, 5)
      mesh.faceSmoothingGroups = Array(1, 2, 4, 8)
      mesh
    }
    def addMouseInteraction(scene: Scene, node: Node): Unit = {
      val angleY = DoubleProperty(0)
      val yRotate = new Rotate {
        angle <== angleY
        axis = Rotate.YAxis
      }
      var anchorX: Double      = 0
      var anchorAngleY: Double = 0
      node.transforms = Seq(yRotate)
      scene.onMousePressed = (event: MouseEvent) => {
        anchorX = event.sceneX
        anchorAngleY = angleY()
      }
      scene.onMouseDragged = (event: MouseEvent) => {
        angleY() = anchorAngleY + anchorX - event.sceneX
      }
    }
  }
}
