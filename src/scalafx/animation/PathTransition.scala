/*
 * Copyright (c) 2011, ScalaFX Project
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
package scalafx.animation

import javafx.{ animation => jfxa }
import javafx.util.Duration
import scalafx.Includes._
import scalafx.util.SFXDelegate
import scalafx.scene.Node
import scalafx.scene.shape.Shape
import scalafx.util.{ SFXEnumDelegateCompanion, SFXEnumDelegate }

object PathTransition extends AnimationStatics {
  implicit def sfxPathTransition2jfx(v: PathTransition) = v.delegate

  object OrientationType
    extends SFXEnumDelegateCompanion[jfxa.PathTransition.OrientationType, OrientationType] {

    /**
     * The targeted node's rotation matrix stays unchange along the geometric path.
     */
    val NONE = new OrientationType(jfxa.PathTransition.OrientationType.NONE)

    /**
     * The targeted node's rotation matrix is set to keep node perpendicular to the path's tangent along the geometric
     * path.
     */
    val ORTHOGONAL_TO_TANGENT = new OrientationType(jfxa.PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT)

    protected override def unsortedValues: Array[OrientationType] = Array(NONE, ORTHOGONAL_TO_TANGENT)

  }

  /**
   * Wraps [[http://docs.oracle.com/javafx/2/api/javafx/animation/PathTransition.OrientationType.html]]
   */
  sealed case class OrientationType(override val delegate: jfxa.PathTransition.OrientationType)
    extends SFXEnumDelegate[jfxa.PathTransition.OrientationType]

}

/**
 * Wraps a [[http://docs.oracle.com/javafx/2/api/javafx/animation/PathTransition.html PathTransition]].
 */
class PathTransition(override val delegate: jfxa.PathTransition = new jfxa.PathTransition)
  extends Transition(delegate)
  with SFXDelegate[jfxa.PathTransition] {

  /**
   * The constructor of PathTransition.
   *
   * @param duration The duration of this PathTransition
   * @param path The path of this PathTransition
   * @param node The node of this PathTransition
   */
  def this(duration: Duration, path: Shape, node: Node) =
    this(new jfxa.PathTransition(duration, path, node))

  /**
   * The constructor of PathTransition.
   *
   * @param duration The duration of this PathTransition
   * @param path The path of this PathTransition
   */
  def this(duration: Duration, path: Shape) =
    this(new jfxa.PathTransition(duration, path))

  /**
   * The target node of this PathTransition.
   */
  def node = delegate.nodeProperty
  def node_=(n: Node) {
    node() = n
  }

  /**
   * The duration of this Transition.
   */
  def duration = delegate.durationProperty
  def duration_=(d: Duration) {
    duration() = d
  }

  /**
   * The shape on which outline the node should be animated.
   */
  def path = delegate.pathProperty
  def path_=(s: Shape) {
    path() = s
  }

  /**
   * Specifies the upright orientation of node along the path.
   */
  def orientation = delegate.orientationProperty
  def orientation_=(o: PathTransition.OrientationType) {
    orientation() = o
  }

}