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

import javafx.{animation => jfxa}
import scalafx.Includes._
import scalafx.beans.property.ObjectProperty
import scalafx.delegate.SFXDelegate

import scala.language.implicitConversions

/**
 * Companion Object for [[scalafx.animation.Transition]].
 *
 * @define TR `Transition`
 */
object Transition extends AnimationStatics {

  /**
   * Converts a ScalaFX $TR to a JavaFX [[http://docs.oracle.com/javase/8/javafx/api/javafx/animation/Transition.html $TR]],
   * extracting its delegate.
   *
   * @param v ScalaFX $TR
   * @return JavaFX $TR extracted from `v`.
   */
  implicit def sfxTransition2jfx(v: Transition): jfxa.Transition = if (v != null) v.delegate else null
}

/**
 * Wraps a [[http://docs.oracle.com/javase/8/javafx/api/javafx/animation/Transition.html $TR]].
 *
 * @constructor Creates a new ScalaFX $TR from a JavaFX $TR.
 * @param delegate JavaFX $TR to be delegated.
 *
 * @define TR `Transition`
 */
abstract class Transition(override val delegate: jfxa.Transition)
    extends Animation(delegate)
    with SFXDelegate[jfxa.Transition] {

  /**
   * Controls the timing for acceleration and deceleration at each $TR cycle. Default Value: `Interpolator.EASE_BOTH`.
   */
  def interpolator: ObjectProperty[jfxa.Interpolator] = delegate.interpolatorProperty

  def interpolator_=(i: jfxa.Interpolator): Unit = {
    interpolator() = i
  }

}
