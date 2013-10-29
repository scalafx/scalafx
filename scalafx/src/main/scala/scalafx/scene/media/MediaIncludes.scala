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

object MediaIncludes extends MediaIncludes

/**
 * Contains implcit methods to convert from
 * [[http://docs.oracle.com/javafx/2/api/javafx/scene/media/package-summary.html `javafx.scene.media`]]
 * Classes/Traits to their $SFX counterparts.
 *
 * @define JFX JavaFX
 * @define SFX ScalaFX
 * @define START Converts a $JFX `[[http://docs.oracle.com/javafx/2/api/javafx/scene/media/
 * @define END ]]` instance to its $SFX counterpart.
 * @define BEGINWR Converts a Function that manipulates a $SFX [[scalafx.scene.media.
 * @define FINISHWR ]] and returns a [[http://www.scala-lang.org/api/current/scala/Any.html scala.Any]] into a $JFX's [[http://docs.oracle.com/javafx/2/api/javafx/event/EventHandler.html EventHandler]] that manipulates it's $JFX couterpart.
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
 * @define TRAC Track
 * @define VDTC VideoTrack
 */
trait MediaIncludes {

  /**
   * $START$AUCL.html $AUCL$END
   *
   * @param ac $JFX $AUCL
   * @return $SFX $AUCL
   */
  implicit def jfxAudioClip2sfx(ac: jfxsm.AudioClip) = new AudioClip(ac)

  /**
   * $START$AUEQ.html $AUEQ$END
   *
   * @param ae $JFX $AUEQ
   * @return $SFX $AUEQ
   */
  implicit def jfxAudioEqualizer2sfx(ae: jfxsm.AudioEqualizer) = new AudioEqualizer(ae)


  /**
   * $START$AUTR.html $AUTR$END
   *
   * @param at $JFX $AUTR
   * @return $SFX $AUTR
   */
  implicit def jfxAudioTrack2sfx(at: jfxsm.AudioTrack) = new AudioTrack(at)

  /**
   * $START$EQBD.html $EQBD$END
   *
   * @param eb $JFX $EQBD
   * @return $SFX $EQBD
   */
  implicit def jfxEqualizerBand2sfx(eb: jfxsm.EqualizerBand) = new EqualizerBand(eb)

  /**
   * $START$MEDI.html $MEDI$END
   *
   * @param m $JFX $MEDI
   * @return $SFX $MEDI
   */
  implicit def jfxMedia2sfx(m: jfxsm.Media) = new Media(m)

  /**
   * $START$MDEE.html $MDEE$END
   *
   * @param mee $JFX $MDEE
   * @return $SFX $MDEE
   */
  implicit def jfxMediaErrorEvent2sfx(mee: jfxsm.MediaErrorEvent) = new MediaErrorEvent(mee)

  /**
   * $START$MDEX.html $MDEX$END
   *
   * @param me $JFX $MDEX
   * @return $SFX $MDEX
   */
  implicit def jfxMediaException2sfx(me: jfxsm.MediaException) = new MediaException(me)

  /**
   * $START$MDET.html $MDET$END
   *
   * @param t $JFX $MDET
   * @return $SFX $MDET
   */
  implicit def jfxMediaExceptionType2sfx(t: jfxsm.MediaException.Type) = MediaException.Type.jfxEnum2sfx(t)

  /**
   * $START$MDME.html $MDME$END
   *
   * @param mme $JFX $MDME
   * @return $SFX $MDME
   */
  implicit def jfxMediaMarkerEvent2sfx(mme: jfxsm.MediaMarkerEvent) = new MediaMarkerEvent(mme)

  /**
   * $START$MDPL.html $MDPL$END
   *
   * @param mp $JFX $MDPL
   * @return $SFX $MDPL
   */
  implicit def jfxMediaPlayer2sfx(mp: jfxsm.MediaPlayer) = new MediaPlayer(mp)

  /**
   * $START$MPST.html $MPST$END
   *
   * @param s $JFX $MPST
   * @return $SFX $MPST
   */
  implicit def jfxMediaPlayerStatus2sfx(s: jfxsm.MediaPlayer.Status) = MediaPlayer.Status.jfxEnum2sfx(s)

  /**
   * $START$MDVW.html $MDVW$END
   *
   * @param mv $JFX $MDVW
   * @return $SFX $MDVW
   */
  implicit def jfxMediaView2sfx(mv: jfxsm.MediaView) = new MediaView(mv)

  /**
   * $START$TRAC.html $TRAC$END
   *
   * @param t $JFX $TRAC
   * @return $SFX $TRAC
   */
  implicit def jfxTrack2sfx(t: jfxsm.Track) = new Track(t) {}

  /**
   * $START$VDTC.html $VDTC$END
   *
   * @param vt $JFX $VDTC
   * @return $SFX $VDTC
   */
  implicit def jfxVideoTrack2sfx(vt: jfxsm.VideoTrack) = new VideoTrack(vt)
}