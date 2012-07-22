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

object FillTransition extends AnimationStatics {
  implicit def sfxFillTransition2jfx(v: FillTransition) = v.delegate
}

/**
 * Wraps a [[http://docs.oracle.com/javafx/2/api/javafx/animation/FillTransition.html FillTransition]].
 */
class FillTransition(override val delegate: jfxa.FillTransition = new jfxa.FillTransition())
  extends Transition(delegate)
  with SFXDelegate[jfxa.FillTransition] {

  /**
   * The constructor of FillTransition
   *
   * @param duration The duration of the FillTransition
   * @param shape The shape which filling will be animated
   * @param fromValue The start value of the color-animation
   * @param toValue The end value of the color-animation
   */
  def this(duration: Duration, shape: Shape, fromValue: Color, toValue: Color) =
    this(new jfxa.FillTransition(duration, shape, fromValue, toValue))

  /**
   * The constructor of FillTransition
   *
   * @param duration The duration of the FillTransition
   * @param fromValue The start value of the color-animation
   * @param toValue The end value of the color-animation
   */
  def this(duration: Duration, fromValue: Color, toValue: Color) =
    this(new jfxa.FillTransition(duration, fromValue, toValue))

  /**
   * The constructor of FillTransition
   *
   * @param duration The duration of the FillTransition
   * @param shape The shape which filling will be animated
   */
  def this(duration: Duration, shape: Shape) =
    this(new jfxa.FillTransition(duration, shape))
    
      /**
   * The constructor of FillTransition
   *
   * @param duration The duration of the FillTransition
   */
  def this(duration: Duration) = this(new jfxa.FillTransition(duration))



  /**
   * The target shape of this `FillTransition`.
   */
  def shape = delegate.shapeProperty
  def shape_=(s: Shape) {
    shape() = s
  }

  /**
   * The duration of this `FillTransition`. Default value:
   * 400ms
   */
  def duration = delegate.durationProperty
  def duration_=(d: Duration) {
    duration() = d
  }

  /**
   * Specifies the start color value for this `FillTransition`. Default value:
   * null
   */
  def fromValue = delegate.fromValueProperty
  def fromValue_=(from: Color) {
    fromValue() = from
  }

  /**
   * Specifies the stop color value for this FillTransition. Default value:
   * null
   */
  def toValue = delegate.toValueProperty
  def toValue_=(to: Color) {
    toValue() = to
  }
}