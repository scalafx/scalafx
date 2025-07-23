/*
 * Copyright (c) 2011-2025, ScalaFX Project
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

import javafx.scene.media as jfxsm
import javafx.{event as jfxe, util as jfxu}
import scalafx.Includes.*
import scalafx.beans.property.*
import scalafx.delegate.{SFXDelegate, SFXEnumDelegate, SFXEnumDelegateCompanion}
import scalafx.util.Duration

import scala.language.implicitConversions

object MediaPlayer {
  implicit def sfxMediaPlayer2jfx(mp: MediaPlayer): jfxsm.MediaPlayer = if (mp != null) mp.delegate else null

  object Status
      extends SFXEnumDelegateCompanion[jfxsm.MediaPlayer.Status, Status] {

    /**
     * State of the player after dispose() method is invoked.
     *
     * This state indicates player is disposed, all resources are free and player SHOULD NOT be used again.
     * Media and MediaView objects associated with disposed player can be reused.
     */
    case object Disposed extends Status(jfxsm.MediaPlayer.Status.DISPOSED)
    @deprecated("Use Disposed; DISPOSED will be removed in a future release", "8.0.60-R10")
    val DISPOSED: Status = Disposed

    /**
     * State of the player when a critical error has occurred.
     */
    case object Halted extends Status(jfxsm.MediaPlayer.Status.HALTED)

    @deprecated("Use Halted; HALTED will be removed in a future release", "8.0.60-R10")
    val HALTED: Status = Halted

    /**
     * State of the player when playback is paused.
     */
    case object Paused extends Status(jfxsm.MediaPlayer.Status.PAUSED)

    @deprecated("Use Paused; PAUSED will be removed in a future release", "8.0.60-R10")
    val PAUSED: Status = Paused

    /**
     * State of the player when it is currently playing.
     */
    case object Playing extends Status(jfxsm.MediaPlayer.Status.PLAYING)

    @deprecated("Use Playing; PLAYING will be removed in a future release", "8.0.60-R10")
    val PLAYING: Status = Playing

    /**
     * State of the player once it is prepared to play.
     */
    case object Ready extends Status(jfxsm.MediaPlayer.Status.READY)

    @deprecated("Use Ready; READY will be removed in a future release", "8.0.60-R10")
    val READY: Status = Ready

    /**
     * State of the player when data coming into the buffer has slowed or stopped and the playback buffer does not
     * have enough data to continue playing.
     */
    case object Stalled extends Status(jfxsm.MediaPlayer.Status.STALLED)

    @deprecated("Use Stalled; STALLED will be removed in a future release", "8.0.60-R10")
    val STALLED: Status = Stalled

    /**
     * State of the player when playback has stopped.
     */
    case object Stopped extends Status(jfxsm.MediaPlayer.Status.STOPPED)

    @deprecated("Use Stopped; STOPPED will be removed in a future release", "8.0.60-R10")
    val STOPPED: Status = Stopped

    /**
     * State of the player immediately after creation.
     */
    case object Unknown extends Status(jfxsm.MediaPlayer.Status.UNKNOWN)

    @deprecated("Use Unknown; UNKNOWN will be removed in a future release", "8.0.60-R10")
    val UNKNOWN: Status = Unknown

    protected override def unsortedValues: Array[Status] =
      Array(Disposed, Halted, Paused, Playing, Ready, Stalled, Stopped, Unknown)
  }

  /**
   * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/input/MediaPlayer.Status.html]]
   */
  sealed abstract class Status(override val delegate: jfxsm.MediaPlayer.Status)
      extends SFXEnumDelegate[jfxsm.MediaPlayer.Status]

  /**
   * A value representing an effectively infinite number of playback cycles.
   */
  val Indefinite: Int = jfxsm.MediaPlayer.INDEFINITE

  private def runnable(op: => Unit): Runnable = new Runnable {
    def run(): Unit = {
      op
    }
  }
}

class MediaPlayer(override val delegate: jfxsm.MediaPlayer) extends SFXDelegate[jfxsm.MediaPlayer] {

  /**
   * Create a player for a specific media.
   */
  def this(media: Media) = this(new jfxsm.MediaPlayer(media))

  /**
   * The interval between spectrum updates in seconds.
   */
  def audioSpectrumInterval: DoubleProperty = delegate.audioSpectrumIntervalProperty

  def audioSpectrumInterval_=(v: Double): Unit = {
    audioSpectrumInterval() = v
  }

  /**
   * A listener for audio spectrum updates.
   */
  def audioSpectrumListener: ObjectProperty[jfxsm.AudioSpectrumListener] = delegate.audioSpectrumListenerProperty

  def audioSpectrumListener_=(v: jfxsm.AudioSpectrumListener): Unit = {
    audioSpectrumListener() = v
  }

  /**
   * The number of bands in the audio spectrum.
   */
  def audioSpectrumNumBands: IntegerProperty = delegate.audioSpectrumNumBandsProperty

  def audioSpectrumNumBands_=(v: Int): Unit = {
    audioSpectrumNumBands() = v
  }

  /**
   * The sensitivity threshold in decibels; must be non-positive.
   */
  def audioSpectrumThreshold: IntegerProperty = delegate.audioSpectrumThresholdProperty

  def audioSpectrumThreshold_=(v: Int): Unit = {
    audioSpectrumThreshold() = v
  }

  /**
   * Whether playing should start as soon as possible.
   */
  def autoPlay: BooleanProperty = delegate.autoPlayProperty

  def autoPlay_=(v: Boolean): Unit = {
    autoPlay() = v
  }

  /**
   * The balance, or left-right setting, of the audio output.
   */
  def balance: DoubleProperty = delegate.balanceProperty

  def balance_=(v: Double): Unit = {
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

  def cycleCount_=(v: Int): Unit = {
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
  def media: Media = delegate.getMedia

  /**
   * Whether the player audio is muted.
   */
  def mute: BooleanProperty = delegate.muteProperty

  def mute_=(v: Boolean): Unit = {
    mute() = v
  }

  /**
   * Event handler invoked when the player currentTime reaches stopTime and is not repeating.
   */
  def onEndOfMedia: ObjectProperty[Runnable] = delegate.onEndOfMediaProperty

  def onEndOfMedia_=(v: Runnable): Unit = {
    onEndOfMedia() = v
  }

  def onEndOfMedia_=(op: => Unit): Unit = {
    onEndOfMedia() = MediaPlayer.runnable(op)
  }

  /**
   * Event handler invoked when an error occurs.
   */
  def onError: ObjectProperty[Runnable] = delegate.onErrorProperty

  def onError_=(v: Runnable): Unit = {
    onError() = v
  }

  def onError_=(op: => Unit): Unit = {
    onError() = MediaPlayer.runnable(op)
  }

  /**
   * Event handler invoked when the status changes to HALTED.
   */
  def onHalted: ObjectProperty[Runnable] = delegate.onHaltedProperty

  def onHalted_=(v: Runnable): Unit = {
    onHalted() = v
  }

  def onHalted_=(op: => Unit): Unit = {
    onHalted() = MediaPlayer.runnable(op)
  }

  /**
   * Event handler invoked when the player currentTime reaches a media marker.
   */
  def onMarker: ObjectProperty[jfxe.EventHandler[jfxsm.MediaMarkerEvent]] = delegate.onMarkerProperty

  def onMarker_=(v: jfxe.EventHandler[jfxsm.MediaMarkerEvent]): Unit = {
    onMarker() = v
  }

  /**
   * Event handler invoked when the status changes to PAUSED.
   */
  def onPaused: ObjectProperty[Runnable] = delegate.onPausedProperty

  def onPaused_=(v: Runnable): Unit = {
    onPaused() = v
  }

  def onPaused_=(op: => Unit): Unit = {
    onPaused() = MediaPlayer.runnable(op)
  }

  /**
   * Event handler invoked when the status changes to PLAYING.
   */
  def onPlaying: ObjectProperty[Runnable] = delegate.onPlayingProperty

  def onPlaying_=(v: Runnable): Unit = {
    onPlaying() = v
  }

  def onPlaying_=(op: => Unit): Unit = {
    onPlaying() = MediaPlayer.runnable(op)
  }

  /**
   * Event handler invoked when the status changes to READY.
   */
  def onReady: ObjectProperty[Runnable] = delegate.onReadyProperty

  def onReady_=(v: Runnable): Unit = {
    onReady() = v
  }

  def onReady_=(op: => Unit): Unit = {
    onReady() = MediaPlayer.runnable(op)
  }

  /**
   * Event handler invoked when the player currentTime reaches stopTime and will be repeating.
   */
  def onRepeat: ObjectProperty[Runnable] = delegate.onRepeatProperty

  def onRepeat_=(v: Runnable): Unit = {
    onRepeat() = v
  }

  def onRepeat_=(op: => Unit): Unit = {
    onRepeat() = MediaPlayer.runnable(op)
  }

  /**
   * Event handler invoked when the status changes to STALLED.
   */
  def onStalled: ObjectProperty[Runnable] = delegate.onStalledProperty

  def onStalled_=(v: Runnable): Unit = {
    onStalled() = v
  }

  def onStalled_=(op: => Unit): Unit = {
    onStalled() = MediaPlayer.runnable(op)
  }

  /**
   * Event handler invoked when the status changes to STOPPED.
   */
  def onStopped: ObjectProperty[Runnable] = delegate.onStoppedProperty

  def onStopped_=(v: Runnable): Unit = {
    onStopped() = v
  }

  def onStopped_=(op: => Unit): Unit = {
    onStopped() = MediaPlayer.runnable(op)
  }

  /**
   * The rate at which the media should be played.
   */
  def rate: DoubleProperty = delegate.rateProperty

  def rate_=(v: Double): Unit = {
    rate() = v
  }

  /**
   * The time offset where media should start playing, or restart from when repeating.
   */
  def startTime: ObjectProperty[jfxu.Duration] = delegate.startTimeProperty

  def startTime_=(v: Duration): Unit = {
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

  def stopTime_=(v: Duration): Unit = {
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

  def volume_=(v: Double): Unit = {
    volume() = v
  }
}
