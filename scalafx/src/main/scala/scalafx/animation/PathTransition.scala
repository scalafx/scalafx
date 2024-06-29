/*
 * Copyright (c) 2011-2024, ScalaFX Project
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

import javafx.scene.{shape => jfxss}
import javafx.{animation => jfxa, scene => jfxs, util => jfxu}
import scalafx.Includes._
import scalafx.beans.property.ObjectProperty
import scalafx.delegate.{SFXDelegate, SFXEnumDelegate, SFXEnumDelegateCompanion}
import scalafx.scene.Node
import scalafx.scene.shape.Shape
import scalafx.util.Duration

import scala.language.implicitConversions

/**
 * Companion Object for [[scalafx.animation.PathTransition]].
 *
 * @define PT `PathTransition`
 * @define OT `OrientationType`
 */
object PathTransition extends AnimationStatics {

  /**
   * Converts a ScalaFX $PT to a JavaFX [[http://docs.oracle.com/javase/8/javafx/api/javafx/animation/PathTransition.html $PT]],
   * extracting its delegate.
   *
   * @param v ScalaFX $PT
   * @return JavaFX $PT extracted from `v`.
   */
  implicit def sfxPathTransition2jfx(v: PathTransition): jfxa.PathTransition = if (v != null) v.delegate else null

  /**
   * Companion Object for $OT, where its values are defined.
   */
  object OrientationType
      extends SFXEnumDelegateCompanion[jfxa.PathTransition.OrientationType, OrientationType] {

    /**
     * The targeted node's rotation matrix stays unchanged along the geometric path.
     */
    case object None extends OrientationType(jfxa.PathTransition.OrientationType.NONE)
    @deprecated("Use None; NONE will be removed in a future release", "8.0.60-R10")
    val NONE: OrientationType = None

    /**
     * The targeted node's rotation matrix is set to keep node perpendicular to the path's tangent along the geometric
     * path.
     */
    case object OrthogonalToTangent extends OrientationType(jfxa.PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT)

    @deprecated("Use OrthogonalToTangent; ORTHOGONAL_TO_TANGENT will be removed in a future release", "8.0.60-R10")
    val ORTHOGONAL_TO_TANGENT: OrientationType = OrthogonalToTangent

    protected override def unsortedValues: Array[OrientationType] = Array(None, OrthogonalToTangent)

  }

  /**
   * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/animation/PathTransition.OrientationType.html $OT]].
   *
   * @constructor Creates a new ScalaFX $OT from a JavaFX $OT.
   * @param delegate JavaFX $OT to be delegated.
   */
  sealed abstract class OrientationType(override val delegate: jfxa.PathTransition.OrientationType)
      extends SFXEnumDelegate[jfxa.PathTransition.OrientationType]

}

/**
 * Wraps a [[http://docs.oracle.com/javase/8/javafx/api/javafx/animation/PathTransition.html PathTransition]].
 *
 * @constructor Creates a new ScalaFX $PT from a JavaFX $PT.
 * @param delegate JavaFX $PT to be delegated.
 *
 * @define PT `PathTransition`
 * @define CONSTR The constructor of $PT.
 */
class PathTransition(override val delegate: jfxa.PathTransition = new jfxa.PathTransition)
    extends Transition(delegate)
    with SFXDelegate[jfxa.PathTransition] {

  /**
   * $CONSTR
   *
   * @param duration The duration of this $PT.
   * @param path The path of this $PT.
   * @param node The node of this $PT.
   */
  def this(duration: Duration, path: Shape, node: Node) =
    this(new jfxa.PathTransition(duration, path, node))

  /**
   * $CONSTR
   *
   * @param duration The duration of this $PT.
   * @param path The path of this $PT.
   */
  def this(duration: Duration, path: Shape) =
    this(new jfxa.PathTransition(duration, path))

  /**
   * The target node of this $PT.
   */
  def node: ObjectProperty[jfxs.Node] = delegate.nodeProperty

  def node_=(n: Node): Unit = {
    node() = n
  }

  /**
   * The duration of this `Transition`.
   */
  def duration: ObjectProperty[jfxu.Duration] = delegate.durationProperty

  def duration_=(d: Duration): Unit = {
    duration() = d
  }

  /**
   * The shape on which outline the node should be animated.
   */
  def path: ObjectProperty[jfxss.Shape] = delegate.pathProperty

  def path_=(s: Shape): Unit = {
    path() = s
  }

  /**
   * Specifies the upright orientation of node along the path.
   */
  def orientation: ObjectProperty[jfxa.PathTransition.OrientationType] = delegate.orientationProperty

  def orientation_=(o: PathTransition.OrientationType): Unit = {
    orientation() = o
  }

}
