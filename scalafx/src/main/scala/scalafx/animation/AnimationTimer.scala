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

import javafx.{ animation => jfxa }
import scalafx.Includes._
import scalafx.delegate.SFXDelegate

/**
 * Companion Object for [[scalafx.animation.AnimationTimer]].
 *
 * @define AT `AnimationTimer`
 */
object AnimationTimer {

  /**
   * Converts a ScalaFX $AT to a JavaFX [[http://docs.oracle.com/javafx/2/api/javafx/animation/AnimationTimer.html $AT]], 
   * extracting its delegate.
   *
   * @param at ScalaFX $AT
   * @return JavaFX $AT extracted from `at`.
   */
  implicit def sfxAnimationTimer2jfx(at: AnimationTimer) = at.delegate

  /**
   * Creates a new [[scalafx.animation.AnimationTimer]] from a handle function that receives a Long parameter.
   *
   * @param handler function that is called in every frame while the $AT is active.
   * @return a new $AT.
   */
  def apply(handler: Long => Unit): AnimationTimer = new AnimationTimer(new jfxa.AnimationTimer {
    def handle(now: Long) = handler(now)
  }) {}

}

/**
 * Wraps a [[http://docs.oracle.com/javafx/2/api/javafx/animation/Animation.html $AT]].
 *
 * @constructor Creates a new ScalaFX $AT from a JavaFX $AT.
 * @param delegate JavaFX $AT to be delegated.
 * 
 * @define AT `AnimationTimer`
 */
abstract class AnimationTimer(override val delegate: jfxa.AnimationTimer)
  extends SFXDelegate[jfxa.AnimationTimer] {

  /**
   * This method needs to be overridden by extending classes.
   *
   * @param now The timestamp of the current frame given in nanoseconds. This value will be the same for all $AT's
   * called during one frame.
   */
  def handle(now: Long) {
    delegate.handle(now)
  }

  /**
   * Starts the $AT's.
   */
  def start() = delegate.start()

  /**
   * Stops the $AT's. It can be activated again by calling `start`.
   */
  def stop() = delegate.stop()

}