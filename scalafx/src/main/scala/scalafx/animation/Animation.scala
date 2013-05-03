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

import javafx.{ animation => jfxa, event => jfxe, util => jfxu }
import scalafx.Includes._
import scalafx.beans.property.BooleanProperty
import scalafx.beans.property.DoubleProperty
import scalafx.beans.property.IntegerProperty
import scalafx.beans.property.ObjectProperty
import scalafx.beans.property.ReadOnlyDoubleProperty
import scalafx.beans.property.ReadOnlyObjectProperty
import scalafx.util.Duration.sfxDuration2jfx
import scalafx.util.Duration
import scalafx.delegate._

/**
 * Defines Constants to be used for all [[scalafx.animation.Animation]]s object companions. 
 */
trait AnimationStatics {
  
  /**
   * Used to specify an animation that repeats indefinitely, until the stop() method is called.
   */
  def INDEFINITE = jfxa.Animation.INDEFINITE
}

/**
 * Companion Object for [[scalafx.animation.Animation]].
 *
 * @define AN `Animation`
 * @define ST `Status`
 */
object Animation extends AnimationStatics {
  
  /**
   * Converts a ScalaFX $AN to a JavaFX [[http://docs.oracle.com/javafx/2/api/javafx/animation/Animation.html $AN]], 
   * extracting its delegate.
   *
   * @param v ScalaFX $AN
   * @return Delegated JavaFX $AN extracted from `v`.
   */
  implicit def sfxAnimation2jfx(v: Animation) = v.delegate

  /**
   * Companion Object for $ST, where its values are defined.
   */
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
   * Wraps [[http://docs.oracle.com/javafx/2/api/javafx/animation/Animation.Status.html $ST]]
   * 
   * @constructor Creates a new ScalaFX $ST from a JavaFX $ST.
   * @param delegate JavaFX $ST to be delegated.
   */
  sealed case class Status(override val delegate: jfxa.Animation.Status)
    extends SFXEnumDelegate[jfxa.Animation.Status]

}

/**
 * Wraps JavaFX's [[http://docs.oracle.com/javafx/2/api/javafx/animation/Animation.html $AN]].
 *
 * @define AN `Animation`
 * @define DV Default value:
 */
abstract class Animation protected (override val delegate: jfxa.Animation)
  extends SFXDelegate[jfxa.Animation] {

  // Properties

  /**
   * Defines whether this $AN reverses direction on alternating cycles. $DV false.
   */
  def autoReverse: BooleanProperty = delegate.autoReverseProperty
  def autoReverse_=(ar: Boolean) {
    autoReverse() = ar
  }

  /**
   * Read-only variable to indicate current direction/speed at which the
   * $AN is being played. $DV 0.0.
   */
  def currentRate: ReadOnlyDoubleProperty = delegate.currentRateProperty

  /**
   * Defines the $AN's play head position. $DV 0ms.
   */
  def currentTime: ReadOnlyObjectProperty[jfxu.Duration] = delegate.currentTimeProperty

  /**
   * Defines the number of cycles in this $AN. $DV 0ms
   */
  def cycleCount: IntegerProperty = delegate.cycleCountProperty
  def cycleCount_=(r: Int) {
    cycleCount() = r
  }

  /**
   * Read-only variable to indicate the duration of one cycle of this
   * $AN: the time it takes to play from time 0 to the KeyFrame with
   * the largest time. $DV 1.0
   */
  def cycleDuration: ReadOnlyObjectProperty[jfxu.Duration] = delegate.cycleDurationProperty

  /**
   * Delays the start of an $AN. $DV 0ms.
   */
  def delay: ObjectProperty[jfxu.Duration] = delegate.delayProperty
  def delay_=(d: Duration) {
    delay() = d
  }

  /**
   * The action to be executed at the conclusion of this $AN.
   */
  def onFinished = delegate.onFinishedProperty
  def onFinished_=(handler: jfxe.EventHandler[jfxe.ActionEvent]) {
    onFinished() = handler
  }

  /**
   * Defines the direction/speed at which the $AN is expected to be played. $DV 1.0
   */
  def rate: DoubleProperty = delegate.rateProperty
  def rate_=(r: Double) {
    rate() = r
  }

  /**
   * The `status` of the $AN.
   */
  def status: ReadOnlyObjectProperty[jfxa.Animation.Status] = delegate.statusProperty

  /**
   * Read-only variable to indicate the total duration of this $AN, including repeats. $DV 0ms
   */
  def totalDuration: ReadOnlyObjectProperty[jfxu.Duration] = delegate.totalDurationProperty

  // Methods

  /**
   * Jumps to a given position in this $AN.
   * 
   * @param time the new position
   */
  def jumpTo(time: Duration) {
    delegate.jumpTo(time)
  }

  /**
   * Jumps to a predefined position in this $AN.
   * 
   * @param cuePoint the name of the cue point
   */
  def jumpTo(cuePoint: String) {
    delegate.jumpTo(cuePoint)
  }

  /**
   * Pauses the $AN.
   */
  def pause() {
    delegate.pause()
  }

  /**
   * Plays $AN from current position in the direction indicated by `rate`.
   */
  def play() {
    delegate.play()
  }

  /**
   * A convenience method to play this $AN from a specific position.
   *
   * @param time position where to play from
   */
  def playFrom(time: Duration) {
    delegate.playFrom(time)
  }

  /**
   * A convenience method to play this $AN from a predefined position.
   *
   * @param cuePoint name of the cue point
   */
  def playFrom(cuePoint: String) {
    delegate.playFrom(cuePoint)
  }

  /**
   * Plays an $AN from initial position in forward direction.
   */
  def playFromStart() {
    delegate.playFromStart()
  }

  /**
   * Stops the $AN and resets the play head to its initial position.
   */
  def stop() {
    delegate.stop()
  }

  /**
   * The target framerate is the maximum framerate at which this $AN will run, in frames per second.
   */
  def targetFramerate = delegate.getTargetFramerate

}
