/*
* Copyright (c) 2012, ScalaFX Project
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
import scalafx.Includes._
import scalafx.util.Duration
import scalafx.util.SFXDelegate

object MediaPlayer {
  implicit def sfxMediaPlayer2jfx(mp: MediaPlayer) = mp.delegate
}

class MediaPlayer(override val delegate: jfxsm.MediaPlayer) extends SFXDelegate[jfxsm.MediaPlayer] {

  /**
   * Create a player for a specific media.
   */
  def this(media: Media) = this(new jfxsm.MediaPlayer(media))

  /**
   * The interval between spectrum updates in seconds.
   */
  def audioSpectrumInterval = delegate.audioSpectrumIntervalProperty
  def audioSpectrumInterval_=(v: Double) {
    audioSpectrumInterval() = v
  }

  /**
   * A listener for audio spectrum updates.
   */
  def audioSpectrumListener = delegate.audioSpectrumListenerProperty
  def audioSpectrumListener_=(v: jfxsm.AudioSpectrumListener) {
    audioSpectrumListener() = v
  }

  /**
   * The number of bands in the audio spectrum.
   */
  def audioSpectrumNumBands = delegate.audioSpectrumNumBandsProperty
  def audioSpectrumNumBands_=(v: Int) {
    audioSpectrumNumBands() = v
  }

  /**
   * The sensitivity threshold in decibels; must be non-positive.
   */
  def audioSpectrumThreshold = delegate.audioSpectrumThresholdProperty
  def audioSpectrumThreshold_=(v: Int) {
    audioSpectrumThreshold() = v
  }

  /**
   * Whether playing should start as soon as possible.
   */
  def autoPlay = delegate.autoPlayProperty
  def autoPlay_=(v: Boolean) {
    autoPlay() = v
  }

  /**
   * The balance, or left-right setting, of the audio output.
   */
  def balance = delegate.balanceProperty
  def balance_=(v: Double) {
    balance() = v
  }

  /**
   * The current buffer position indicating how much media can be played without stalling the MediaPlayer.
   */
  def bufferProgressTime = delegate.bufferProgressTimeProperty

  /**
   * The number of completed playback cycles.
   */
  def currentCount = delegate.currentCountProperty

  /**
   * The current rate of playback regardless of settings.
   */
  def currentRate = delegate.currentRateProperty

  /**
   * The current media playback time.
   */
  def currentTime = delegate.currentTimeProperty

  /**
   * The number of times the media will be played.
   */
  def cycleCount = delegate.cycleCountProperty
  def cycleCount_=(v: Int) {
    cycleCount() = v
  }

  /**
   * The amount of time between the startTime and stopTime of this player.
   */
  def cycleDuration = delegate.cycleDurationProperty

  /**
   * Observable property set to a MediaException if an error occurs.
   */
  def error = delegate.errorProperty

  /**
   * Retrieves the Media instance being played.
   */
  def media = delegate.getMedia

  /**
   * Whether the player audio is muted.
   */
  def mute = delegate.muteProperty
  def mute_=(v: Boolean) {
    mute() = v
  }

  /**
   * Event handler invoked when the player currentTime reaches stopTime and is not repeating.
   */
  def onEndOfMedia = delegate.onEndOfMediaProperty
  def onEndOfMedia_=(v: Runnable) {
    onEndOfMedia() = v
  }

  /**
   * Event handler invoked when an error occurs.
   */
  def onError = delegate.onErrorProperty
  def onError_=(v: Runnable) {
    onError() = v
  }

  /**
   * Event handler invoked when the status changes to HALTED.
   */
  def onHalted = delegate.onHaltedProperty
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
  def onPaused = delegate.onPausedProperty
  def onPaused_=(v: Runnable) {
    onPaused() = v
  }

  /**
   * Event handler invoked when the status changes to PLAYING.
   */
  def onPlaying = delegate.onPlayingProperty
  def onPlaying_=(v: Runnable) {
    onPlaying() = v
  }

  /**
   * Event handler invoked when the status changes to READY.
   */
  def onReady = delegate.onReadyProperty
  def onReady_=(v: Runnable) {
    onReady() = v
  }

  /**
   * Event handler invoked when the player currentTime reaches stopTime and will be repeating.
   */
  def onRepeat = delegate.onRepeatProperty
  def onRepeat_=(v: Runnable) {
    onRepeat() = v
  }

  /**
   * Event handler invoked when the status changes to STALLED.
   */
  def onStalled = delegate.onStalledProperty
  def onStalled_=(v: Runnable) {
    onStalled() = v
  }

  /**
   * Event handler invoked when the status changes to STOPPED.
   */
  def onStopped = delegate.onStoppedProperty
  def onStopped_=(v: Runnable) {
    onStopped() = v
  }

  /**
   * The rate at which the media should be played.
   */
  def rate = delegate.rateProperty
  def rate_=(v: Double) {
    rate() = v
  }

  /**
   * The time offset where media should start playing, or restart from when repeating.
   */
  def startTime = delegate.startTimeProperty
  def startTime_=(v: Duration) {
    startTime() = v
  }

  /**
   * The current state of the MediaPlayer.
   */
  def status = delegate.statusProperty

  /**
   * The time offset where media should stop playing or restart when repeating.
   */
  def stopTime = delegate.stopTimeProperty
  def stopTime_=(v: Duration) {
    stopTime() = v
  }

  /**
   * The total amount of play time if allowed to play until finished.
   */
  def totalDuration = delegate.totalDurationProperty

  /**
   * The volume at which the media should be played.
   */
  def volume = delegate.volumeProperty
  def volume_=(v: Double) {
    volume() = v
  }

}