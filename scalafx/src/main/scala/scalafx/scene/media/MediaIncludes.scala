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
import javafx.{event => jfxe}

object MediaIncludes extends MediaIncludes

trait MediaIncludes {
  implicit def jfxAudioClip2sfx(ac: jfxsm.AudioClip) = new AudioClip(ac)
  implicit def jfxAudioEqualizer2sfx(ae: jfxsm.AudioEqualizer) = new AudioEqualizer(ae)
  implicit def jfxAudioTrack2sfx(at: jfxsm.AudioTrack) = new AudioTrack(at)
  implicit def jfxEqualizerBand2sfx(eb: jfxsm.EqualizerBand) = new EqualizerBand(eb)
  implicit def jfxMedia2sfx(m: jfxsm.Media) = new Media(m)
  implicit def jfxMediaErrorEvent2sfx(mee: jfxsm.MediaErrorEvent) = new MediaErrorEvent(mee)
  implicit def jfxMediaException2sfx(me: jfxsm.MediaException) = new MediaException(me)
  implicit def jfxMediaExceptionType2sfx(t: jfxsm.MediaException.Type) = MediaException.Type.jfxEnum2sfx(t)
  implicit def jfxMediaMarkerEvent2sfx(mme: jfxsm.MediaMarkerEvent) = new MediaMarkerEvent(mme)
  implicit def jfxMediaPlayer2sfx(mp: jfxsm.MediaPlayer) = new MediaPlayer(mp)
  implicit def jfxMediaPlayerStatus2sfx(s: jfxsm.MediaPlayer.Status) = MediaPlayer.Status.jfxEnum2sfx(s)
  implicit def jfxMediaView2sfx(mv: jfxsm.MediaView) = new MediaView(mv)
  implicit def jfxTrack2sfx(t: jfxsm.Track) = new Track(t) {}
  implicit def jfxVideoTrack2sfx(vt: jfxsm.VideoTrack) = new VideoTrack(vt)


  /**
   * Converts a Function that manipulates a [[scalafx.scene.media.MediaMarkerEvent]]
   * and returns a [[scala.Unit]] in a
   * [[http://docs.oracle.com/javafx/2/api/javafx/event/EventHandler.html JavaFX`s EventHandler]]
   * that manipulates a
   * [[http://docs.oracle.com/javafx/2/api/javafx/scene/media/MediaMarkerEvent.html JavaFX`s MediaMarkerEvent]]
   *
   * @param handler function that manipulates a ScalaFX's MediaMarkerEvent
   * @return a JavaFX's EventHandler that manipulates a JavaFX's MediaMarkerEvent
   */
  implicit def mediaMarkerEventClosureWrapper(handler: (MediaMarkerEvent) => Unit) = new jfxe.EventHandler[jfxsm.MediaMarkerEvent] {
    def handle(event: jfxsm.MediaMarkerEvent) {
      handler(event)
    }
  }

  /**
   * Converts a Function that manipulates a [[scalafx.scene.media.MediaErrorEvent]]
   * and returns a [[scala.Unit]] in a
   * [[http://docs.oracle.com/javafx/2/api/javafx/event/EventHandler.html JavaFX`s EventHandler]]
   * that manipulates a
   * [[http://docs.oracle.com/javafx/2/api/javafx/scene/media/MediaErrorEvent.html JavaFX`s MediaErrorEvent]]
   *
   * @param handler function that manipulates a ScalaFX's MediaErrorEvent
   * @return a JavaFX's EventHandler that manipulates a JavaFX's MediaErrorEvent
   */
  implicit def mediaErrorEventClosureWrapper(handler: (MediaErrorEvent) => Unit) = new jfxe.EventHandler[jfxsm.MediaErrorEvent] {
    def handle(event: jfxsm.MediaErrorEvent) {
      handler(event)
    }
  }

}