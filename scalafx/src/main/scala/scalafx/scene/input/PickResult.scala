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
package scalafx.scene.input

import javafx.scene.{input => jfxsi}
import javafx.{event => jfxe}

import scala.language.implicitConversions
import scalafx.Includes._
import scalafx.delegate.SFXDelegate
import scalafx.geometry.{Point2D, Point3D}
import scalafx.scene.Node

object PickResult {
  implicit def sfxPickResult2jfx(m: PickResult): jfxsi.PickResult = if (m != null) m.delegate else null

  /** An undefined face. This value is used for the intersected face if the picked node has no user-specified faces. */
  val FaceUndefined: Int = jfxsi.PickResult.FACE_UNDEFINED
  @deprecated ("Use FaceUndefined; FACE_UNDEFINED will be removed in a future release", "8.0.60-R10")
  val FACE_UNDEFINED = FaceUndefined
}

/** A container for the result of a pick event. Wrapper for JavaFX's
  * [[http://download.java.net/jdk8/jfxdocs/javafx/scene/input/PickResult.html PickResult]]. */
class PickResult(override val delegate: jfxsi.PickResult)
  extends SFXDelegate[jfxsi.PickResult] {

  /** Creates a pick result for a 2D case where no additional information is needed.
    *
    * Converts the given scene coordinates to the target's local coordinate space and stores
    * the value as the intersected point. Sets intersected node to the given target,
    * distance to 1.0, face to FACE_UNDEFINED and texCoord to null.
    *
    * @param target - The picked target (null in case of a Scene)
    * @param sceneX - The scene X coordinate
    * @param sceneY - The scene Y coordinate
    */
  def this(target: jfxe.EventTarget, sceneX: Double, sceneY: Double) = {
    this(new jfxsi.PickResult(target, sceneX, sceneY))
  }

  /** Creates a new instance of PickResult for a non-3d-shape target.
    *
    * Sets face to FACE_UNDEFINED and texCoord to null.
    *
    * @param node - The intersected node
    * @param point - The intersected point in local coordinate of the picked Node
    * @param distance - The intersected distance between camera position and the picked Node
    */
  def this(node: Node, point: Point3D, distance: Double) = {
    this(new jfxsi.PickResult(node, point, distance))
  }

  /** Creates a new instance of PickResult.
    * @param node - The intersected node
    * @param point - The intersected point in local coordinate of the picked Node
    * @param distance - The intersected distance between camera position and the picked Node
    * @param face - The intersected face of the picked Node
    * @param texCoord - The intersected texture coordinates of the picked Node
    */
  def this(node: Node, point: Point3D, distance: Double, face: Int, texCoord: Point2D) = {
    this(new jfxsi.PickResult(node, point, distance, face, texCoord))
  }

  /** Returns the intersected distance between camera position and the intersected point. */
  def intersectedDistance: Double = delegate.getIntersectedDistance

  /** Returns the intersected face of the picked Node,
    * `FACE_UNDEFINED` if the node doesn't have user-specified faces or was picked on bounds.
    */
  def intersectedFace: Int = delegate.getIntersectedFace

  /** Returns the intersected node. Returns `None` if there was no intersection with any node and the scene was picked. */
  def intersectedNode: Option[Node] = delegate.getIntersectedNode match {
    case null => None
    case v    => Some[Node](v)
  }

  /** Returns the intersected point in local coordinate of the picked Node. */
  def intersectedPoint: Point3D = delegate.getIntersectedPoint

  /** Return the intersected texture coordinates of the picked 3d shape.
    * If the picked target is not Shape3D or has pickOnBounds==true, it returns `None`.
    */
  def intersectedTexCoord: Option[Point2D] = delegate.getIntersectedTexCoord match {
    case null => None
    case v    => Some[Point2D](v)
  }
}
