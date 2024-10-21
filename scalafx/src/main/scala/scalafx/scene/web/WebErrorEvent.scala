/*
 * Copyright (c) 2011-2024, ScalaFX Project
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
package scalafx.scene.web

import javafx.scene.{web => jfxsw}
import javafx.{event => jfxe}
import scalafx.Includes._
import scalafx.delegate.SFXDelegate
import scalafx.event.{Event, EventType}

import scala.language.implicitConversions

/**
 * Companion object for [[scalafx.scene.web.WebErrorEvent]].
 */
object WebErrorEvent {

  /**
   * Converts a ScalaFX WebErrorEvent to its JavaFX counterpart.
   *
   * @param wee ScalaFX WebErrorEvent
   * @return JavaFX WebErrorEvent
   */
  implicit def sfxWebErrorEventsjfx(wee: WebErrorEvent): jfxsw.WebErrorEvent =
    if (wee != null) wee.delegate else null

  /**
   * Common supertype for all WebErrorEvent types.
   */
  val Any: EventType[jfxsw.WebErrorEvent] = jfxsw.WebErrorEvent.ANY
  @deprecated("Use Any; ANY will be removed in a future release", "8.0.60-R10")
  val ANY: EventType[jfxsw.WebErrorEvent] = Any

  /**
   * This event occurs when a [[scalafx.scene.web.WebEngine]] detects that
   * its user data directory is already in use by a WebEngine running in a different VM.
   */
  val UserDataDirectoryAlreadyInUse: EventType[jfxsw.WebErrorEvent] =
    jfxsw.WebErrorEvent.USER_DATA_DIRECTORY_ALREADY_IN_USE
  @deprecated(
    "Use UserDataDirectoryAlreadyInUse; USER_DATA_DIRECTORY_ALREADY_IN_USE will be removed in a future release",
    "8.0.60-R10"
  )
  val USER_DATA_DIRECTORY_ALREADY_IN_USE: EventType[jfxsw.WebErrorEvent] = UserDataDirectoryAlreadyInUse

  /**
   * This event occurs when a [[scalafx.scene.web.WebEngine]] encounters an I/O error
   * while trying to create or access the user data directory.
   */
  val UserDataDirectoryIOError: EventType[jfxsw.WebErrorEvent] =
    jfxsw.WebErrorEvent.USER_DATA_DIRECTORY_IO_ERROR
  @deprecated(
    "Use UserDataDirectoryIOError; USER_DATA_DIRECTORY_IO_ERROR will be removed in a future release",
    "8.0.60-R10"
  )
  val USER_DATA_DIRECTORY_IO_ERROR: EventType[jfxsw.WebErrorEvent] = UserDataDirectoryIOError

  /**
   * This event occurs when a [[scalafx.scene.web.WebEngine]] encounters a security error
   * while trying to create or access the user data directory.
   */
  val UserDataDirectorySecurityError: EventType[jfxsw.WebErrorEvent] =
    jfxsw.WebErrorEvent.USER_DATA_DIRECTORY_SECURITY_ERROR
  @deprecated(
    "Use UserDataDirectorySecurityError; USER_DATA_DIRECTORY_SECURITY_ERROR will be removed in a future release",
    "8.0.60-R10"
  )
  val USER_DATA_DIRECTORY_SECURITY_ERROR: EventType[jfxsw.WebErrorEvent] = UserDataDirectorySecurityError

}

/**
 * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/web/WebEvent.html JavaFX WebEvent]].
 *
 * @constructor Creates a new ScalaFX WebErrorEvent from its JavaFX equivalent.
 * @param delegate JavaFX WebErrorEvent. Since it has no default constructor, there is not default value.
 * @since 8.0
 */
final class WebErrorEvent(override val delegate: jfxsw.WebErrorEvent)
    extends Event(delegate) with SFXDelegate[jfxsw.WebErrorEvent] {

  /**
   * Creates a new WebErrorEvent.
   *
   * @param source the event source which sent the event
   * @param eventType the event type
   * @param message the text message associated with the event; may be <code>null</code>.
   * @param exception the exception associated with the event; may be <code>null</code>.
   */
  def this(source: AnyRef, eventType: jfxe.EventType[jfxsw.WebErrorEvent], message: String, exception: Throwable) =
    this(new jfxsw.WebErrorEvent(source, eventType, message, exception))

  /**
   * The exception associated with this event.
   */
  def exception: Throwable = delegate.getException

  /**
   * The text message associated with this event.
   */
  def message: String = delegate.getMessage

}
