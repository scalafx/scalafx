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
package scalafx.scene.media

import javafx.scene.{ media => jfxsm }
import javafx.{ event => jfxe }
import javafx.{ util => jfxu }
import scalafx.Includes._
import scalafx.beans.property.BooleanProperty
import scalafx.beans.property.DoubleProperty
import scalafx.beans.property.IntegerProperty
import scalafx.beans.property.ObjectProperty
import scalafx.beans.property.ReadOnlyDoubleProperty
import scalafx.beans.property.ReadOnlyIntegerProperty
import scalafx.beans.property.ReadOnlyObjectProperty
import scalafx.util.Duration
import scalafx.delegate.SFXDelegate
import scalafx.delegate.{SFXEnumDelegateCompanion, SFXEnumDelegate}

object MediaPlayer {
  implicit def sfxMediaPlayer2jfx(mp: MediaPlayer) = mp.delegate

  object Status
    extends SFXEnumDelegateCompanion[jfxsm.MediaPlayer.Status, Status] {

    /**
     * State of the player when a critical error has occurred.
     */
    val HALTED = new Status(jfxsm.MediaPlayer.Status.HALTED)

    /**
     * State of the player when playback is paused.
     */
    val PAUSED = new Status(jfxsm.MediaPlayer.Status.PAUSED)

    /**
     * State of the player when it is currently playing.
     */
    val PLAYING = new Status(jfxsm.MediaPlayer.Status.PLAYING)

    /**
     * State of the player once it is prepared to play.
     */
    val READY = new Status(jfxsm.MediaPlayer.Status.READY)

    /**
     * State of the player when data coming into the buffer has slowed or stopped and the playback buffer does not
     * have enough data to continue playing.
     */
    val STALLED = new Status(jfxsm.MediaPlayer.Status.STALLED)

    /**
     * State of the player when playback has stopped.
     */
    val STOPPED = new Status(jfxsm.MediaPlayer.Status.STOPPED)

    /**
     * State of the player immediately after creation.
     */
    val UNKNOWN = new Status(jfxsm.MediaPlayer.Status.UNKNOWN)

    protected override def unsortedValues: Array[Status] = Array(HALTED, PAUSED, PLAYING, READY, STALLED, STOPPED,
      UNKNOWN)

  }

  /**
   * Wraps [[http://docs.oracle.com/javafx/2/api/javafx/scene/input/MediaPlayer.Status.html]]
   */
  sealed case class Status(override val delegate: jfxsm.MediaPlayer.Status)
    extends SFXEnumDelegate[jfxsm.MediaPlayer.Status]

  /**
   * A value representing an effectively infinite number of playback cycles.
   */
  val Indefinite: Int = jfxsm.MediaPlayer.INDEFINITE
}

final class MediaPlayer(override val delegate: jfxsm.MediaPlayer) extends SFXDelegate[jfxsm.MediaPlayer] {

  /**
   * Create a player for a specific media.
   */
  def this(media: Media) = this(new jfxsm.MediaPlayer(media))

  /**
   * The interval between spectrum updates in seconds.
   */
  def audioSpectrumInterval: DoubleProperty = delegate.audioSpectrumIntervalProperty
  def audioSpectrumInterval_=(v: Double) {
    audioSpectrumInterval() = v
  }

  /**
   * A listener for audio spectrum updates.
   */
  def audioSpectrumListener: ObjectProperty[jfxsm.AudioSpectrumListener] = delegate.audioSpectrumListenerProperty
  def audioSpectrumListener_=(v: jfxsm.AudioSpectrumListener) {
    audioSpectrumListener() = v
  }

  /**
   * The number of bands in the audio spectrum.
   */
  def audioSpectrumNumBands: IntegerProperty = delegate.audioSpectrumNumBandsProperty
  def audioSpectrumNumBands_=(v: Int) {
    audioSpectrumNumBands() = v
  }

  /**
   * The sensitivity threshold in decibels; must be non-positive.
   */
  def audioSpectrumThreshold: IntegerProperty = delegate.audioSpectrumThresholdProperty
  def audioSpectrumThreshold_=(v: Int) {
    audioSpectrumThreshold() = v
  }

  /**
   * Whether playing should start as soon as possible.
   */
  def autoPlay: BooleanProperty = delegate.autoPlayProperty
  def autoPlay_=(v: Boolean) {
    autoPlay() = v
  }

  /**
   * The balance, or left-right setting, of the audio output.
   */
  def balance: DoubleProperty = delegate.balanceProperty
  def balance_=(v: Double) {
    balance() = v
  }

  /**
   * The current buffer position indicating how much media can be played without stalling the MediaPlayer.
   */
  def bufferProgressTime: ReadOnlyObjectProperty[jfxu.Duration] = delegate.bufferProgressTimeProperty

  /**
   * The number of completed playback cycles.
   */
  def currentCount: ReadOnlyIntegerProperty = delegate.currentCountProperty

  /**
   * The current rate of playback regardless of settings.
   */
  def currentRate: ReadOnlyDoubleProperty = delegate.currentRateProperty

  /**
   * The current media playback time.
   */
  def currentTime: ReadOnlyObjectProperty[jfxu.Duration] = delegate.currentTimeProperty

  /**
   * The number of times the media will be played.
   */
  def cycleCount: IntegerProperty = delegate.cycleCountProperty
  def cycleCount_=(v: Int) {
    cycleCount() = v
  }

  /**
   * The amount of time between the startTime and stopTime of this player.
   */
  def cycleDuration: ReadOnlyObjectProperty[jfxu.Duration] = delegate.cycleDurationProperty

  /**
   * Observable property set to a MediaException if an error occurs.
   */
  def error: ReadOnlyObjectProperty[jfxsm.MediaException] = delegate.errorProperty

  /**
   * Retrieves the Media instance being played.
   */
  def media = delegate.getMedia

  /**
   * Whether the player audio is muted.
   */
  def mute: BooleanProperty = delegate.muteProperty
  def mute_=(v: Boolean) {
    mute() = v
  }

  /**
   * Event handler invoked when the player currentTime reaches stopTime and is not repeating.
   */
  def onEndOfMedia: ObjectProperty[Runnable] = delegate.onEndOfMediaProperty
  def onEndOfMedia_=(v: Runnable) {
    onEndOfMedia() = v
  }

  /**
   * Event handler invoked when an error occurs.
   */
  def onError: ObjectProperty[Runnable] = delegate.onErrorProperty
  def onError_=(v: Runnable) {
    onError() = v
  }

  /**
   * Event handler invoked when the status changes to HALTED.
   */
  def onHalted: ObjectProperty[Runnable] = delegate.onHaltedProperty
  def onHalted_=(v: Runnable) {
    onHalted() = v
  }

  /**
   * Event handler invoked when the player currentTime reaches a media marker.
   */
  def onMarker = delegate.onMarkerProperty
  def onMarker_=(v: jfxe.EventHandler[jfxsm.MediaMarkerEvent]) {
    onMarker() = v
  }

  /**
   * Event handler invoked when the status changes to PAUSED.
   */
  def onPaused: ObjectProperty[Runnable] = delegate.onPausedProperty
  def onPaused_=(v: Runnable) {
    onPaused() = v
  }

  /**
   * Event handler invoked when the status changes to PLAYING.
   */
  def onPlaying: ObjectProperty[Runnable] = delegate.onPlayingProperty
  def onPlaying_=(v: Runnable) {
    onPlaying() = v
  }

  /**
   * Event handler invoked when the status changes to READY.
   */
  def onReady: ObjectProperty[Runnable] = delegate.onReadyProperty
  def onReady_=(v: Runnable) {
    onReady() = v
  }

  /**
   * Event handler invoked when the player currentTime reaches stopTime and will be repeating.
   */
  def onRepeat: ObjectProperty[Runnable] = delegate.onRepeatProperty
  def onRepeat_=(v: Runnable) {
    onRepeat() = v
  }

  /**
   * Event handler invoked when the status changes to STALLED.
   */
  def onStalled: ObjectProperty[Runnable] = delegate.onStalledProperty
  def onStalled_=(v: Runnable) {
    onStalled() = v
  }

  /**
   * Event handler invoked when the status changes to STOPPED.
   */
  def onStopped: ObjectProperty[Runnable] = delegate.onStoppedProperty
  def onStopped_=(v: Runnable) {
    onStopped() = v
  }

  /**
   * The rate at which the media should be played.
   */
  def rate: DoubleProperty = delegate.rateProperty
  def rate_=(v: Double) {
    rate() = v
  }

  /**
   * The time offset where media should start playing, or restart from when repeating.
   */
  def startTime: ObjectProperty[jfxu.Duration] = delegate.startTimeProperty
  def startTime_=(v: Duration) {
    startTime() = v
  }

  /**
   * The current state of the MediaPlayer.
   */
  def status: ReadOnlyObjectProperty[jfxsm.MediaPlayer.Status] = delegate.statusProperty

  /**
   * The time offset where media should stop playing or restart when repeating.
   */
  def stopTime: ObjectProperty[jfxu.Duration] = delegate.stopTimeProperty
  def stopTime_=(v: Duration) {
    stopTime() = v
  }

  /**
   * The total amount of play time if allowed to play until finished.
   */
  def totalDuration: ReadOnlyObjectProperty[jfxu.Duration] = delegate.totalDurationProperty

  /**
   * The volume at which the media should be played.
   */
  def volume: DoubleProperty = delegate.volumeProperty
  def volume_=(v: Double) {
    volume() = v
  }

}