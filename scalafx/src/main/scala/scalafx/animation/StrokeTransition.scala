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

import javafx.{ animation => jfxa, util => jfxu }
import javafx.scene.{ paint => jfxsp, shape => jfxss }
import scalafx.Includes._
import scalafx.beans.property.ObjectProperty
import scalafx.scene.paint.Color
import scalafx.scene.shape.Shape
import scalafx.util.Duration
import scalafx.delegate.SFXDelegate

/**
 * Companion Object for [[scalafx.animation.StrokeTransition]].
 *
 * @define ST `StrokeTransition`
 */
object StrokeTransition extends AnimationStatics {

  /**
   * Converts a ScalaFX $ST to a JavaFX [[http://docs.oracle.com/javafx/2/api/javafx/animation/StrokeTransition.html $ST]],
   * extracting its delegate.
   *
   * @param v ScalaFX $ST
   * @return JavaFX $ST extracted from `v`.
   */
  implicit def sfxStrokeTransition2jfx(v: StrokeTransition) = v.delegate

}

/**
 * Wraps a [[http://docs.oracle.com/javafx/2/api/javafx/animation/StrokeTransition.html StrokeTransition]].
 *
 * @constructor Creates a new ScalaFX $ST from a JavaFX $ST.
 * @param delegate JavaFX $ST to be delegated.
 *
 * @define ST `StrokeTransition`
 * @define CONST The constructor of $ST
 * @define DUR The duration of the $ST.
 * @define DV Default value:
 */
class StrokeTransition(override val delegate: jfxa.StrokeTransition = new jfxa.StrokeTransition)
  extends Transition(delegate)
  with SFXDelegate[jfxa.StrokeTransition] {

  // CONSTRUCTORS

  /**
   * $CONST
   *
   * @param duration $DUR
   * @param shape The shape which filling will be animated
   * @param fromValue The start value of the color-animation
   * @param toValue The end value of the color-animation
   */
  def this(duration: Duration, shape: Shape, fromValue: Color, toValue: Color) =
    this(new jfxa.StrokeTransition(duration, shape, fromValue, toValue))

  /**
   * $CONST
   *
   * @param duration $DUR
   * @param fromValue The start value of the color-animation
   * @param toValue The end value of the color-animation
   */
  def this(duration: Duration, fromValue: Color, toValue: Color) =
    this(new jfxa.StrokeTransition(duration, fromValue, toValue))

  /**
   * $CONST
   *
   * @param duration $DUR
   * @param shape The shape which filling will be animated
   */
  def this(duration: Duration, shape: Shape) =
    this(new jfxa.StrokeTransition(duration, shape))

  /**
   * $CONST
   *
   * @param duration $DUR
   */
  def this(duration: Duration) = this(new jfxa.StrokeTransition(duration))

  // PROPERTIES

  /**
   * The target shape of this $ST.
   */
  def shape: ObjectProperty[jfxss.Shape] = delegate.shapeProperty
  def shape_=(s: Shape) {
    shape() = s
  }

  /**
   * $DUR. $DV 400ms
   */
  def duration: ObjectProperty[jfxu.Duration] = delegate.durationProperty
  def duration_=(d: Duration) {
    duration() = d
  }

  /**
   * Specifies the start color value for this $ST. $DV `null`
   */
  def fromValue: ObjectProperty[jfxsp.Color] = delegate.fromValueProperty
  def fromValue_=(from: Color) {
    fromValue() = from
  }

  /**
   * Specifies the stop color value for this $ST. $DV `null`
   */
  def toValue: ObjectProperty[jfxsp.Color] = delegate.toValueProperty
  def toValue_=(to: Color) {
    toValue() = to
  }

}