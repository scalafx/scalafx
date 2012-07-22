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
import javafx.scene.paint.Color
import javafx.util.Duration
import scalafx.Includes._
import scalafx.util.SFXDelegate
import scalafx.scene.shape.Shape

object StrokeTransition extends AnimationStatics {
  implicit def sfxStrokeTransition2jfx(v: StrokeTransition) = v.delegate
}

/**
 * Wraps a [[http://docs.oracle.com/javafx/2/api/javafx/animation/StrokeTransition.html StrokeTransition]].
 */
class StrokeTransition(override val delegate: jfxa.StrokeTransition = new jfxa.StrokeTransition)
  extends Transition(delegate)
  with SFXDelegate[jfxa.StrokeTransition] {

  /**
   * The constructor of StrokeTransition
   *
   * @param duration The duration of the StrokeTransition
   * @param shape The shape which filling will be animated
   * @param fromValue The start value of the color-animation
   * @param toValue The end value of the color-animation
   */
  def this(duration: Duration, shape: Shape, fromValue: Color, toValue: Color) =
    this(new jfxa.StrokeTransition(duration, shape, fromValue, toValue))

  /**
   * The constructor of StrokeTransition
   *
   * @param duration The duration of the StrokeTransition
   * @param fromValue The start value of the color-animation
   * @param toValue The end value of the color-animation
   */
  def this(duration: Duration, fromValue: Color, toValue: Color) =
    this(new jfxa.StrokeTransition(duration, fromValue, toValue))

  /**
   * The constructor of StrokeTransition
   *
   * @param duration The duration of the StrokeTransition
   * @param shape The shape which filling will be animated
   */
  def this(duration: Duration, shape: Shape) =
    this(new jfxa.StrokeTransition(duration, shape))

  /**
   * The constructor of StrokeTransition
   *
   * @param duration The duration of the StrokeTransition
   */
  def this(duration: Duration) = this(new jfxa.StrokeTransition(duration))

  /**
   * The target shape of this StrokeTransition.
   */
  def shape = delegate.shapeProperty
  def shape_=(s: Shape) {
    shape() = s
  }

  /**
   * The duration of this StrokeTransition.
   */
  def duration = delegate.durationProperty
  def duration_=(d: Duration) {
    duration() = d
  }

  /**
   * Specifies the start color value for this StrokeTransition.
   */
  def fromValue = delegate.fromValueProperty
  def fromValue_=(from: Color) {
    fromValue() = from
  }

  /**
   * Specifies the stop color value for this StrokeTransition.
   */
  def toValue = delegate.toValueProperty
  def toValue_=(to: Color) {
    toValue() = to
  }
}