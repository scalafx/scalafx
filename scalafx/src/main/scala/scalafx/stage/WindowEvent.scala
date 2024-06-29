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
package scalafx.stage

import javafx.{stage => jfxs}

import scala.language.implicitConversions
import scalafx.Includes._
import scalafx.delegate.SFXDelegate
import scalafx.event.{Event, EventType}

object WindowEvent {
  implicit def sfxWindowEvent2jfx(v: WindowEvent): jfxs.WindowEvent = if (v != null) v.delegate else null

  /**
   * Common supertype for all window event types.
   */
  val Any: EventType[jfxs.WindowEvent] = jfxs.WindowEvent.ANY

  /**
   * This event is delivered to a window when there is an external request to close that window.
   */
  val WindowCloseRequest: EventType[jfxs.WindowEvent] = jfxs.WindowEvent.WINDOW_CLOSE_REQUEST

  /**
   * This event occurs on window just after it is hidden.
   */
  val WindowHidden: EventType[jfxs.WindowEvent] = jfxs.WindowEvent.WINDOW_HIDDEN

  /**
   * This event occurs on window just before it is hidden.
   */
  val WindowHiding: EventType[jfxs.WindowEvent] = jfxs.WindowEvent.WINDOW_HIDING

  /**
   * This event occurs on window just before it is shown.
   */
  val WindowShowing: EventType[jfxs.WindowEvent] = jfxs.WindowEvent.WINDOW_SHOWING

  /**
   * This event occurs on window just after it is shown.
   */
  val WindowShown: EventType[jfxs.WindowEvent] = jfxs.WindowEvent.WINDOW_SHOWN
}

class WindowEvent(override val delegate: jfxs.WindowEvent) extends Event(delegate) with SFXDelegate[jfxs.WindowEvent] {

  /**
   * Construct a new Event with the specified event source, target and type.
   */
  def this(source: Window, eventType: EventType[_ <: javafx.event.Event]) =
    this(new jfxs.WindowEvent(source, eventType))

}
