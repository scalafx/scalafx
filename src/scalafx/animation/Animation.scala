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

import javafx.{ event => jfxe }
import javafx.{ animation => jfxa }
import scalafx.Includes._
import scalafx.beans.property.BooleanProperty
import scalafx.beans.property.DoubleProperty
import scalafx.beans.property.IntegerProperty
import scalafx.beans.property.ReadOnlyDoubleProperty
import scalafx.util.Duration.sfxDuration2jfx
import scalafx.util.Duration
import scalafx.util.SFXDelegate
import scalafx.util.{ SFXEnumDelegateCompanion, SFXEnumDelegate }

trait AnimationStatics {
  def INDEFINITE = jfxa.Animation.INDEFINITE
}

object Animation extends AnimationStatics {
  implicit def sfxAnimation2jfx(v: Animation) = v.delegate

  object Status
    extends SFXEnumDelegateCompanion[jfxa.Animation.Status, Status] {

    /**
     * The paused state.
     */
    val PAUSED = new Status(jfxa.Animation.Status.PAUSED)

    /**
     * The running state.
     */
    val RUNNING = new Status(jfxa.Animation.Status.RUNNING)

    /**
     * The stopped state.
     */
    val STOPPED = new Status(jfxa.Animation.Status.STOPPED)

    protected override def unsortedValues: Array[Status] = Array(PAUSED, RUNNING, STOPPED)

  }

  /**
   * Wraps [[http://docs.oracle.com/javafx/2/api/javafx/animation/Animation.Status.html]]
   */
  sealed case class Status(override val delegate: jfxa.Animation.Status)
    extends SFXEnumDelegate[jfxa.Animation.Status]

}

/**
 * Wraps [[http://docs.oracle.com/javafx/2/api/javafx/animation/Animation.html Animation]].
 */
abstract class Animation protected (override val delegate: jfxa.Animation)
  extends SFXDelegate[jfxa.Animation] {

  /**
   * Defines whether this Animation reverses direction on alternating cycles.
   */
  def autoReverse: BooleanProperty = delegate.autoReverseProperty
  def autoReverse_=(ar: Boolean) {
    autoReverse() = ar
  }

  /**
   * Read-only variable to indicate current direction/speed at which the
   * `Timeline` is being played.
   */
  def currentRate: ReadOnlyDoubleProperty = delegate.currentRateProperty

  /**
   *
   */
  def currentTime = delegate.currentTimeProperty

  /**
   * Defines the number of cycles in this animation.
   */
  def cycleCount: IntegerProperty = delegate.cycleCountProperty
  def cycleCount_=(r: Int) {
    cycleCount() = r
  }

  /**
   * Read-only variable to indicate the duration of one cycle of this
   * `Timeline`: the time it takes to play from time 0 to the KeyFrame with
   * the largest time (at the default rate of 1.0).
   */
  def cycleDuration = delegate.cycleDurationProperty

  /**
   * Delays the start of an animation.
   */
  def delay = delegate.delayProperty
  def delay_=(d: Duration) {
    delay() = d
  }

  /**
   * The action to be executed at the conclusion of this Animation.
   */
  def onFinished = delegate.onFinishedProperty
  def onFinished_=(handler: jfxe.EventHandler[jfxe.ActionEvent]) {
    onFinished() = handler
  }

  /**
   * Defines the direction/speed at which the Timeline is expected to be played.
   */
  def rate: DoubleProperty = delegate.rateProperty
  def rate_=(r: Double) {
    rate() = r
  }

  /**
   * The status of the Animation.
   */
  def status = delegate.statusProperty

  /**
   * Read-only variable to indicate the total duration of this `Timeline`,
   * including repeats.
   */
  def totalDuration = delegate.totalDurationProperty

  /**
   * Jumps to a given position in this Animation.
   */
  def jumpTo(time: Duration) {
    delegate.jumpTo(time)
  }

  /**
   * Jumps to a predefined position in this Animation.
   */
  def jumpTo(cuePoint: String) {
    delegate.jumpTo(cuePoint)
  }

  /**
   * Pauses the animation.
   */
  def pause {
    delegate.pause
  }

  /**
   * Plays `Timeline` from current position in the direction indicated by rate.
   */
  def play {
    delegate.play
  }

  def playFrom(time: Duration) {
    delegate.playFrom(time)
  }

  /**
   * A convenience method to play this Animation from a predefined position.
   */
  def playFrom(cuePoint: String) {
    delegate.playFrom(cuePoint)
  }

  /**
   * Plays timeline from initial position in forward direction.
   */
  def playFromStart {
    delegate.playFromStart
  }

  /**
   * Stops the animation and resets the play head to its initial position.
   */
  def stop() {
    delegate.stop()
  }

  /**
   * The target framerate is the maximum framerate at which this animation
   * will run, in frames per second.
   */
  def targetFramerate = delegate.getTargetFramerate

}
