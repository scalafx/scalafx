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
package scalafx.animation

import javafx.{ animation => jfxa, geometry => jfxg, scene => jfxs, util => jfxu }
import scalafx.util.Duration
import scalafx.Includes._
import scalafx.delegate.SFXDelegate
import scalafx.scene.Node
import scalafx.geometry.Point3D
import scalafx.beans.property.DoubleProperty
import scalafx.beans.property.ObjectProperty

/**
 * Companion Object for [[scalafx.animation.RotateTransition]].
 *
 * @define RT `RotateTransition`
 */
object RotateTransition extends AnimationStatics {

  /**
   * Converts a ScalaFX $RT to a JavaFX [[http://docs.oracle.com/javafx/2/api/javafx/animation/RotateTransition.html $RT]],
   * extracting its delegate.
   *
   * @param v ScalaFX $RT
   * @return JavaFX $RT extracted from `v`.
   */
  implicit def sfxRotateTransition2jfx(v: RotateTransition) = v.delegate

}

/**
 * Wraps a [[http://docs.oracle.com/javafx/2/api/javafx/animation/RotateTransition.html $RT]].
 *
 * @constructor Creates a new ScalaFX $RT from a JavaFX $RT.
 * @param delegate JavaFX $RT to be delegated.
 *
 * @define RT `RotateTransition`
 * @define CONST The constructor of $RT
 * @define DUR The duration of the $RT
 * @define DV Default value:
 */
class RotateTransition(override val delegate: jfxa.RotateTransition = new jfxa.RotateTransition)
  extends Transition(delegate)
  with SFXDelegate[jfxa.RotateTransition] {

  // CONSTRUCTOR

  /**
   * $CONST
   *
   * @param duration $DUR
   */
  def this(duration: Duration) = this(new jfxa.RotateTransition(duration))

  /**
   * $CONST
   *
   * @param duration $DUR
   * @param node The node which will be rotated
   */
  def this(duration: Duration, node: Node) =
    this(new jfxa.RotateTransition(duration, node))

  // PROPERTIES

  /**
   * $DUR. $DV 400ms
   */
  def duration: ObjectProperty[jfxu.Duration] = delegate.durationProperty
  def duration_=(d: Duration) {
    duration() = d
  }

  /**
   * Specifies the incremented stop angle value, from the start, of this $RT.
   */
  def byAngle: DoubleProperty = delegate.byAngleProperty
  def byAngle_=(by: Double) {
    byAngle() = by
  }

  /**
   * Specifies the stop angle value for this $RT. $DV Double.NaN
   */
  def toAngle: DoubleProperty = delegate.toAngleProperty
  def toAngle_=(to: Double) {
    toAngle() = to
  }

  /**
   * The target node of this $RT.
   */
  def node: ObjectProperty[jfxs.Node] = delegate.nodeProperty
  def node_=(n: Node) {
    node() = n
  }

  /**
   * Specifies the axis of rotation for this $RT. $DV `null`
   */
  def axis: ObjectProperty[jfxg.Point3D] = delegate.axisProperty
  def axis_=(p: Point3D) {
    axis() = p
  }

  /**
   * Specifies the start angle value for this $RT. $DV Double.NaN
   */
  def fromAngle: DoubleProperty = delegate.fromAngleProperty
  def fromAngle_=(from: Double) {
    fromAngle() = from
  }

}