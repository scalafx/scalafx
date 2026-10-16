/*
 * Copyright (c) 2011-2026, ScalaFX Project
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
import scalafx.scene.media.MediaException.Type
import scalafx.scene.media.MediaPlayer.Status

import scala.language.implicitConversions

object MediaIncludes extends MediaIncludes

/**
 * Contains implcit methods to convert from
 * [[javafx.scene.media]]
 * Classes/Traits to their $SFX counterparts.
 *
 * @define JFX JavaFX
 * @define SFX ScalaFX
 * @define START Converts a $JFX
 * @define END instance to its $SFX counterpart.
 * @define BEGINWR Converts a Function that manipulates a $SFX [[scalafx.scene.media.
 * @ d e f i n e F I N I S H W R ]] and returns a [[http://www.scala-lang.org/api/current/scala/Any.html scala.Any]] into a $JFX's [[javafx.event.EventHandler EventHandler]] that manipulates it's $JFX couterpart.
 * @define PARAMWR function that manipulates a $SFX's
 * @define RETWR A $JFX's EventHandler that manipulates a $JFX's
 *
 * @define AUCL AudioClip
 * @define AUEQ AudioEqualizer
 * @define AUTR AudioTrack
 * @define EQBD EqualizerBand
 * @define MEDI Media
 * @define MDEE MediaErrorEvent
 * @define MDEX MediaException
 * @define MDET MediaException.Type
 * @define MDME MediaMarkerEvent
 * @define MDPL MediaPlayer
 * @define MPST MediaPlayer.Status
 * @define MDVW MediaView
 * @define SBTR SubtitleTrack
 * @define TRAC Track
 * @define VDTC VideoTrack
 */
trait MediaIncludes {

  /**
   * $START [[javafx.scene.media.AudioClip AudioClip]] $END
   *
   * @param ac $JFX $AUCL
   * @return $SFX $AUCL
   */
  implicit def jfxAudioClip2sfx(ac: jfxsm.AudioClip): AudioClip = if (ac != null) new AudioClip(ac) else null

  /**
   * $START [[javafx.scene.media.AudioEqualizer AudioEqualizer]] $END
   *
   * @param ae $JFX $AUEQ
   * @return $SFX $AUEQ
   */
  implicit def jfxAudioEqualizer2sfx(ae: jfxsm.AudioEqualizer): AudioEqualizer =
    if (ae != null) new AudioEqualizer(ae) else null

  /**
   * $START [[javafx.scene.media.AudioTrack AudioTrack]] $END
   *
   * @param at $JFX $AUTR
   * @return $SFX $AUTR
   */
  implicit def jfxAudioTrack2sfx(at: jfxsm.AudioTrack): AudioTrack = if (at != null) new AudioTrack(at) else null

  /**
   * $START [[javafx.scene.media.EqualizerBand EqualizerBand]] $END
   *
   * @param eb $JFX $EQBD
   * @return $SFX $EQBD
   */
  implicit def jfxEqualizerBand2sfx(eb: jfxsm.EqualizerBand): EqualizerBand =
    if (eb != null) new EqualizerBand(eb) else null

  /**
   * $START [[javafx.scene.media.Media Media]] $END
   *
   * @param m $JFX $MEDI
   * @return $SFX $MEDI
   */
  implicit def jfxMedia2sfx(m: jfxsm.Media): Media = if (m != null) new Media(m) else null

  /**
   * $START [[javafx.scene.media.MediaErrorEvent MediaErrorEvent]] $END
   *
   * @param mee $JFX $MDEE
   * @return $SFX $MDEE
   */
  implicit def jfxMediaErrorEvent2sfx(mee: jfxsm.MediaErrorEvent): MediaErrorEvent =
    if (mee != null) new MediaErrorEvent(mee) else null

  /**
   * $START [[javafx.scene.media.MediaException MediaException]] $END
   *
   * @param me $JFX $MDEX
   * @return $SFX $MDEX
   */
  implicit def jfxMediaException2sfx(me: jfxsm.MediaException): MediaException =
    if (me != null) new MediaException(me) else null

  /**
   * $START [[javafx.scene.media.MediaException.Type MediaException.Type]] $END
   *
   * @param t $JFX $MDET
   * @return $SFX $MDET
   */
  implicit def jfxMediaExceptionType2sfx(t: jfxsm.MediaException.Type): Type = MediaException.Type.jfxEnum2sfx(t)

  /**
   * $START [[javafx.scene.media.MediaMarkerEvent MediaMarkerEvent]] $END
   *
   * @param mme $JFX $MDME
   * @return $SFX $MDME
   */
  implicit def jfxMediaMarkerEvent2sfx(mme: jfxsm.MediaMarkerEvent): MediaMarkerEvent =
    if (mme != null) new MediaMarkerEvent(mme) else null

  /**
   * $START [[javafx.scene.media.MediaPlayer MediaPlayer]] $END
   *
   * @param mp $JFX $MDPL
   * @return $SFX $MDPL
   */
  implicit def jfxMediaPlayer2sfx(mp: jfxsm.MediaPlayer): MediaPlayer = if (mp != null) new MediaPlayer(mp) else null

  /**
   * $START [[javafx.scene.media.MediaPlayer.Status MediaPlayer.Status]] $END
   *
   * @param s $JFX $MPST
   * @return $SFX $MPST
   */
  implicit def jfxMediaPlayerStatus2sfx(s: jfxsm.MediaPlayer.Status): Status = MediaPlayer.Status.jfxEnum2sfx(s)

  /**
   * $START [[javafx.scene.media.MediaView MediaView]] $END
   *
   * @param mv $JFX $MDVW
   * @return $SFX $MDVW
   */
  implicit def jfxMediaView2sfx(mv: jfxsm.MediaView): MediaView = if (mv != null) new MediaView(mv) else null

  /**
   * $START [[javafx.scene.media.SubtitleTrack SubtitleTrack]] $END
   *
   * @param st $JFX $SBTR
   * @return $SFX $SBTR
   */
  implicit def jfxSubtitleTrack2sfx(st: jfxsm.SubtitleTrack): SubtitleTrack =
    if (st != null) new SubtitleTrack(st) else null

  /**
   * $START [[javafx.scene.media.Track Track]] $END
   *
   * @param t $JFX $TRAC
   * @return $SFX $TRAC
   */
  implicit def jfxTrack2sfx(t: jfxsm.Track): Track = if (t != null) new Track(t) {} else null

  /**
   * $START [[javafx.scene.media.VideoTrack VideoTrack]] $END
   *
   * @param vt $JFX $VDTC
   * @return $SFX $VDTC
   */
  implicit def jfxVideoTrack2sfx(vt: jfxsm.VideoTrack): VideoTrack = if (vt != null) new VideoTrack(vt) else null
}
