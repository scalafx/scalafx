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

import javafx.{animation => jfxa, util => jfxu}
import scalafx.Includes._
import scalafx.beans.property.ObjectProperty
import scalafx.delegate.SFXDelegate
import scalafx.util.Duration

import scala.language.implicitConversions

/**
 * Companion Object for [[scalafx.animation.PauseTransition]].
 *
 * @define PT `PauseTransition`
 */
object PauseTransition extends AnimationStatics {

  /**
   * Converts a ScalaFX $PT to a JavaFX [[http://docs.oracle.com/javase/8/javafx/api/javafx/animation/PauseTransition.html $PT]],
   * extracting its delegate.
   *
   * @param v ScalaFX $PT
   * @return JavaFX $PT extracted from `v`.
   */
  implicit def sfxPauseTransition2jfx(v: PauseTransition): jfxa.PauseTransition = if (v != null) v.delegate else null

}

/**
 * Wraps a [[http://docs.oracle.com/javase/8/javafx/api/javafx/animation/PauseTransition.html $PT]].
 *
 * @constructor Creates a new ScalaFX $PT from a JavaFX $PT.
 * @param delegate JavaFX $PT to be delegated.
 *
 * @define PT `PauseTransition`
 */
class PauseTransition(override val delegate: jfxa.PauseTransition = new jfxa.PauseTransition)
    extends Transition(delegate)
    with SFXDelegate[jfxa.PauseTransition] {

  /**
   * The constructor of $PT.
   *
   * @param duration The duration of the $PT.
   */
  def this(duration: Duration) = this(new jfxa.PauseTransition(duration))

  /**
   * The duration of this `Transition`. Default value: 400ms
   */
  def duration: ObjectProperty[jfxu.Duration] = delegate.durationProperty

  def duration_=(d: Duration): Unit = {
    duration() = d
  }

}
