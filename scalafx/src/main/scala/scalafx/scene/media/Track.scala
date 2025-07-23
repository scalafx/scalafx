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
import scalafx.delegate.SFXDelegate
import scalafx.util.JavaConverters.*

import java.util.Locale
import scala.collection.mutable
import scala.language.implicitConversions

object Track {
  implicit def sfxTrack2jfx(t: Track): jfxsm.Track = if (t != null) t.delegate else null
}

abstract class Track(override val delegate: jfxsm.Track) extends SFXDelegate[jfxsm.Track] {

  /**
   * Retrieves the name of the track.
   */
  def name: String = delegate.getName

  /**
   * The `Locale` specifying the language and possibly the country that the `Track` contents are formatted for.
   */
  def locale: Locale = delegate.getLocale

  def metadata: mutable.Map[String, AnyRef] = delegate.getMetadata.asScala

  /**
   * Gets the `trackID` as defined by the media container format.
   */
  def trackID: Long = delegate.getTrackID
}
