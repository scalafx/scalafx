/*
 * Copyright (c) 2011-2020, ScalaFX Project
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

import javafx.scene.{media => jfxsm}
import scalafx.Includes._
import scalafx.delegate.{SFXDelegate, SFXEnumDelegate, SFXEnumDelegateCompanion}

import scala.language.implicitConversions

object MediaException {
  implicit def sfxMediaException2jfx(me: MediaException): jfxsm.MediaException = if (me != null) me.delegate else null

  object Type
    extends SFXEnumDelegateCompanion[jfxsm.MediaException.Type, Type] {

    /**
     * Indicates an error has occurred: the media appears to be invalid or corrupted.
     */
    case object MediaCorrupted extends Type(jfxsm.MediaException.Type.MEDIA_CORRUPTED)
    @deprecated("Use MediaCorrupted; MEDIA_CORRUPTED will be removed in a future release", "8.0.60-R10")
    val MEDIA_CORRUPTED: Type = MediaCorrupted

    /**
     * Indicates an error has occurred: although the media may exist, it is not accessible.
     */
    case object MediaInaccessible extends Type(jfxsm.MediaException.Type.MEDIA_INACCESSIBLE)

    @deprecated("Use MediaInaccessible; MEDIA_INACCESSIBLE will be removed in a future release", "8.0.60-R10")
    val MEDIA_INACCESSIBLE: Type = MediaInaccessible

    /**
     * Indicates an error has occurred: the media does not exist or is otherwise unavailable.
     */
    case object MediaUnavailable extends Type(jfxsm.MediaException.Type.MEDIA_UNAVAILABLE)

    @deprecated("Use MediaUnavailable; MEDIA_UNAVAILABLE will be removed in a future release", "8.0.60-R10")
    val MEDIA_UNAVAILABLE: Type = MediaUnavailable

    /**
     * Indicates that the media has not been specified.
     */
    case object MediaUnspecified extends Type(jfxsm.MediaException.Type.MEDIA_UNSPECIFIED)

    @deprecated("Use MediaUnspecified; MEDIA_UNSPECIFIED will be removed in a future release", "8.0.60-R10")
    val MEDIA_UNSPECIFIED: Type = MediaUnspecified

    /**
     * Indicates that this media type is not supported by this platform.
     */
    case object MediaUnsupported extends Type(jfxsm.MediaException.Type.MEDIA_UNSUPPORTED)

    @deprecated("Use MediaUnsupported; MEDIA_UNSUPPORTED will be removed in a future release", "8.0.60-R10")
    val MEDIA_UNSUPPORTED: Type = MediaUnsupported

    /**
     * Indicates that an operation performed on the media is not supported by this platform.
     */
    case object OperationUnsupported extends Type(jfxsm.MediaException.Type.OPERATION_UNSUPPORTED)

    @deprecated("Use OperationUnsupported; OPERATION_UNSUPPORTED will be removed in a future release", "8.0.60-R10")
    val OPERATION_UNSUPPORTED: Type = OperationUnsupported

    /**
     * Indicates a playback error which does not fall into any of the other pre-defined categories.
     */
    case object PlaybackError extends Type(jfxsm.MediaException.Type.PLAYBACK_ERROR)

    @deprecated("Use PlaybackError; PLAYBACK_ERROR will be removed in a future release", "8.0.60-R10")
    val PLAYBACK_ERROR: Type = PlaybackError

    /**
     * Indicates an unrecoverable error which has resulted in halting playback.
     */
    case object PlaybackHalted extends Type(jfxsm.MediaException.Type.PLAYBACK_HALTED)

    @deprecated("Use PlaybackHalted; PLAYBACK_HALTED will be removed in a future release", "8.0.60-R10")
    val PLAYBACK_HALTED: Type = PlaybackHalted

    /**
     * Indicates an error has occurred for an unknown reason.
     */
    case object Unknown extends Type(jfxsm.MediaException.Type.UNKNOWN)

    @deprecated("Use Unknown; UNKNOWN will be removed in a future release", "8.0.60-R10")
    val UNKNOWN: Type = Unknown

    protected override def unsortedValues: Array[Type] = Array(MediaCorrupted, MediaInaccessible, MediaUnavailable,
      MediaUnspecified, MediaUnsupported, OperationUnsupported, PlaybackError, PlaybackHalted, Unknown)

  }

  /**
   * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/input/MediaException.Type.html]]
   */
  sealed abstract class Type(override val delegate: jfxsm.MediaException.Type)
    extends SFXEnumDelegate[jfxsm.MediaException.Type]

}

class MediaException(override val delegate: jfxsm.MediaException)
  extends Exception(delegate)
  with SFXDelegate[jfxsm.MediaException] {

  /**
   * Retrieves the category into which this error falls.
   *
   * IMPLEMENTATION NOTE: Its name was changed from JavaFX name to not conflict with Scala `type` keyword.
   */
  def exceptionType: MediaException.Type = delegate.getType

}
