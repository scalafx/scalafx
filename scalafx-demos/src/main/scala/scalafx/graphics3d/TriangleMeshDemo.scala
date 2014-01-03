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

import scala.math.sqrt
import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.beans.property.DoubleProperty
import scalafx.scene.AmbientLight
import scalafx.scene.Group
import scalafx.scene.Node
import scalafx.scene.PerspectiveCamera
import scalafx.scene.PointLight
import scalafx.scene.Scene
import scalafx.scene.SceneAntialiasing
import scalafx.scene.image.Image
import scalafx.scene.input.MouseEvent
import scalafx.scene.paint.Color
import scalafx.scene.paint.PhongMaterial
import scalafx.scene.shape.MeshView
import scalafx.scene.shape.TriangleMesh
import scalafx.scene.transform.Rotate

/**
 * Demonstrates custom 3D shapes.
 *
 * @author Mike Allen (mike@hindsight-consulting.com).
 */
object TriangleMeshDemo extends JFXApp {

  stage = new PrimaryStage {
    title = "TriangleMesh Demo"
    scene = new Scene(500, 500, true,  SceneAntialiasing.Balanced) {
      fill = Color.BEIGE

      // Create a tetrahedron and add to a mesh view. Configure it.
      val tetra = new MeshView(tetrahedron (500.0)) {
        val image = new Image(this, "images/TetrahedronMap.png")
        material = new PhongMaterial {
          specularColor = Color.WHITE
          diffuseMap = image
        }
      }

      // Put shapes in a group so they can be rotated together
      val shapes = new Group(tetra)

      val pointLight = new PointLight {
        color = Color.ANTIQUEWHITE
        translateX = -300.0
        translateY = -300.0
        translateZ = -700.0
      }

      val ambientLight = new AmbientLight {
        color = Color.WHITE
      }

      root = new Group {
        content = new Group(shapes, pointLight, ambientLight)
        translateX = 250.0
        translateY = 250.0
        translateZ = 700.0
        rotationAxis = Rotate.YAxis
      }

      camera = new PerspectiveCamera(false)

      addMouseInteraction(this, shapes)
    }
  }

  /**
   * Create a simple regular tetrahedron.
   *
   * The shape's origin is at the center of its base face.
   *
   * A regular tetrahedron has four faces, each made up of one triangular face.
   *
   * @param length Length of any side of the tetrahedron. This value must be greater than zero.
   *
   * @return TriangularMesh instance defining the resulting tetrahedron.
   *
   * @throws java.lang.IllegalArgumentException if `length` is not greater than zero.
   */
  private def tetrahedron (length: Double) = {
    require(length > 0.0)

    /*
     * Create a new TriangleMesh instance to hold the tetrahedron's definition.
     */
    val mesh = new TriangleMesh()

    /*
     * Set the mesh's vertex points array making up the tetrahedron in 3D space.
     *
     * There are four points altogether, each one defined by three floating point values that correspond to the X-, Y- and Z-axis
     * coordinates respectively.
     *
     * NOTE: JavaFX has adopted an unusual 3D coordinate system (compared to other 3D graphics systems), to put it mildly.  The X-axis
     * points East (if you've worked with 3D systems previously, this is the only axis that behaves the way you might expect); the Y-axis
     * points South (in AutoCAD and 3D Studio, the Y-axis points North, while in X3D/VRML it points Up); the Z-axis points Down (in AutoCAD
     * and 3D Studio, the Z-axis points Up, while in X3D/VRML it points North).
     */
    mesh.points = Array (
      0.0f, -(length * sqrt (3.0) / 3.0).toFloat, 0.0f,                       // Base rear point, point 0.
      (length / 2.0).toFloat, (length * sqrt (3.0) / 6.0).toFloat, 0.0f,      // Base front right point, point 1.
      -(length / 2.0).toFloat, (length * sqrt (3.0) / 6.0).toFloat, 0.0f,     // Base front left point, point 2.
      0.0f, 0.0f, -(length * sqrt (2.0 / 3.0)).toFloat                        // Top point, point 3.
    )

    /*
     * Set the mesh's texture coordinates array to define how the faces (defined by getFaces below) map to texture files.
     *
     * There are six texture co-ordinates altogether.
     *
     * Each texture co-ordinate is made up of two values, conventionally u (horizontal) and v (vertical), that are defined as floating
     * point values between 0 and 1.  The idea is that, given a square image (that is to be applied as a texture to this tetrahedron),
     * the texture co-ordinates define which parts of the image map to which face. (Note: The origin, (0, 0), is the top left corner of the
     * image).
     */
    mesh.texCoords = Array (
      0.5f, 1.0f,                                 // Base face, rear point (left face, right point; right face, left point), point 0.
      0.75f, (1.0 - sqrt (3.0) / 4.0).toFloat,    // Base face, right point (right face, right point; front face, right point), point 1.
      0.25f, (1.0 - sqrt (3.0) / 4.0).toFloat,    // Base face, left point (left face, left point; front face, left point), point 2.
      1.0f, 1.0f,                                 // Right face, top point, point 3.
      0.5f, (1.0 - sqrt (3.0) / 2.0).toFloat,     // Front face, top point, point 4.
      0.0f, 1.0f                                  // Left face, top point, point 5.
    )

    /*
     * Set the mesh's faces array to define which vertex points and texture coordinates make up each face.
     *
     * There are four faces, each defined by six points.  Values 0, 2, and 4 are the vertex point indices for the face, as defined in
     * getPoints above (points are referenced by index into the getPoints array as groups of 3, so point 0 corresponds to elements 0, 1 &
     * 2 of getPoints, point 1 to element 3, 4 & 5 of getPoints, etc.).  Value 1, 3 and 5 are the texture co-ordinates for the face, as
     * defined in getTexCoords above (points are referenced by index into the getTexCoords array as groups of 2, so tex-coord 0
     * corresponds to elements 0 & 1 of getTexCoords, tex-coord 1 to elements 2 & 3 of getTexCoords, etc.).
     *
     * NOTE: Faces have a single visible side only, which is determined by the order in which the points are supplied.  If looking at the
     * visible side of a face, the vertices must be numbered in clockwise order, but the starting vertex is arbitrary.  For example, if
     * looking at the base of this tetrahedron from below, the vertices can be numbered 0, 1, 2 or 1, 2, 0 or 2, 0, 1 - all will work.
     * However, if the order of vertices is specified in counterclockwise order (such as 0, 2, 1), then the face will be invisible from
     * below.
     */
    mesh.faces = Array (
      0, 0, 1, 1, 2, 2,       // Base face, face 0. (Vertex points 0, 1, 2, tex-coords 0, 1, 2)
      1, 1, 0, 0, 3, 3,       // Right face, face 1. (Vertex points 1, 0, 3, tex-coords 1, 0, 3)
      2, 2, 1, 1, 3, 4,       // Front face, face 2. (Vertex points 2, 1, 3, tex-coords 2, 1, 4)
      0, 0, 2, 2, 3, 5        // Left face, face 3. (Vertex points 0, 2, 3, tex-coords 0, 2, 3)
    )

    /*
     * Set the mesh's face smoothing groups array to define which faces belong to which smoothing groups.
     *
     * Often, a portion of a 3D mesh is made up of two or more triangular faces that define a single face (such as the surface of a
     * sphere).  In this case, it makes sense to smooth all such faces when rendering the shape.  This is the idea behind "face smoothing
     * groups".  Each face can be assigned to one or more smoothing groups (up to 32 in total), although its typical for each face to be
     * mapped to just a single smoothing group. Smoothing group membership is expressed as a bit field, with each bit corresponding to a
     * unique smoothing group.
     *
     * In the case of a tetrahedron, each face should belong to its own smoothing group, so we here map each face to a single smoothing
     * group.
     */
    mesh.faceSmoothingGroups = Array (
      0x1,              // Base face, smoothing group 0 (2^0).
      0x2,              // Right face, smoothing group (2^1).
      0x4,              // Front face, smoothing group (2^2).
      0x8               // Left face, smoothing group (2^3).
    )

    /*
     * Return the populated mesh.
     */
    mesh
  }

  /** Add mouse interaction to a scene, rotating given node. */
  private def addMouseInteraction(scene: Scene, node: Node) {
    val angleY = DoubleProperty(0)
    val yRotate = new Rotate {
      angle <== angleY
      axis = Rotate.YAxis
    }
    var anchorX: Double = 0
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