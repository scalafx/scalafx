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
import scalafx.util.{ SFXEnumDelegateCompanion, SFXEnumDelegate }

object MediaException {
  implicit def sfxMediaException2jfx(me: MediaException) = me.delegate

  object Type
    extends SFXEnumDelegateCompanion[jfxsm.MediaException.Type, Type] {

    /**
     * Indicates an error has occurred: the media appears to be invalid or corrupted.
     */
    val MEDIA_CORRUPTED = new Type(jfxsm.MediaException.Type.MEDIA_CORRUPTED)

    /**
     * Indicates an error has occurred: although the media may exist, it is not accessible.
     */
    val MEDIA_INACCESSIBLE = new Type(jfxsm.MediaException.Type.MEDIA_INACCESSIBLE)

    /**
     * Indicates an error has occurred: the media does not exist or is otherwise unavailable.
     */
    val MEDIA_UNAVAILABLE = new Type(jfxsm.MediaException.Type.MEDIA_UNAVAILABLE)

    /**
     * Indicates that the media has not been specified.
     */
    val MEDIA_UNSPECIFIED = new Type(jfxsm.MediaException.Type.MEDIA_UNSPECIFIED)

    /**
     * Indicates that this media type is not supported by this platform.
     */
    val MEDIA_UNSUPPORTED = new Type(jfxsm.MediaException.Type.MEDIA_UNSUPPORTED)

    /**
     * Indicates that an operation performed on the media is not supported by this platform.
     */
    val OPERATION_UNSUPPORTED = new Type(jfxsm.MediaException.Type.OPERATION_UNSUPPORTED)

    /**
     * Indicates a playback error which does not fall into any of the other pre-defined categories.
     */
    val PLAYBACK_ERROR = new Type(jfxsm.MediaException.Type.PLAYBACK_ERROR)

    /**
     * Indicates an unrecoverable error which has resulted in halting playback.
     */
    val PLAYBACK_HALTED = new Type(jfxsm.MediaException.Type.PLAYBACK_HALTED)

    /**
     * Indicates an error has occurred for an unknown reason.
     */
    val UNKNOWN = new Type(jfxsm.MediaException.Type.UNKNOWN)

    protected override def unsortedValues: Array[Type] = Array(MEDIA_CORRUPTED, MEDIA_INACCESSIBLE, MEDIA_UNAVAILABLE,
      MEDIA_UNSPECIFIED, MEDIA_UNSUPPORTED, OPERATION_UNSUPPORTED, PLAYBACK_ERROR, PLAYBACK_HALTED, UNKNOWN)

  }

  /**
   * Wraps [[http://docs.oracle.com/javafx/2/api/javafx/scene/input/MediaException.Type.html]]
   */
  sealed case class Type(override val delegate: jfxsm.MediaException.Type)
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