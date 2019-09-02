/*
 * Copyright (c) 2011-2014, ScalaFX Project
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

import scala.language.implicitConversions
import scalafx.Includes._
import scalafx.delegate.SFXDelegate
import scalafx.event.{Event, EventType}

/**
  * Companion object for [[scalafx.scene.web.WebEvent]].
  */
object WebEvent {

  /**
    * Converts a ScalaFX WebEvent to its JavaFX counterpart.
    *
    * @param we ScalaFX WebEvent
    * @return JavaFX WebEvent
    */
  implicit def sfxWebEvent2jfx[T](we: WebEvent[T]): jfxsw.WebEvent[T] = if (we != null) we.delegate else null

  /**
    * This event occurs when a script calls the JavaScript alert function.
    */
  val Alert: EventType[jfxsw.WebEvent[_]] = jfxsw.WebEvent.ALERT
  @deprecated("Use Alert; ALERT will be removed in a future release", "8.0.60-R10")
  val ALERT = Alert

  /**
    * Common supertype for all Web event types.
    */
  val Any: EventType[jfxsw.WebEvent[_]] = jfxsw.WebEvent.ANY
  @deprecated("Use Any; ANY will be removed in a future release", "8.0.60-R10")
  val ANY = Any

  /**
    * This event occurs when a script changes location of the JavaScript window object.
    */
  val Resized: EventType[jfxsw.WebEvent[_]] = jfxsw.WebEvent.RESIZED
  @deprecated("Use Resized; RESIZED will be removed in a future release", "8.0.60-R10")
  val RESIZED = Resized

  /**
    * This event occurs when a script changes status line text.
    */
  val StatusChanged: EventType[jfxsw.WebEvent[_]] = jfxsw.WebEvent.STATUS_CHANGED
  @deprecated("Use StatusChanged; STATUS_CHANGED will be removed in a future release", "8.0.60-R10")
  val STATUS_CHANGED = StatusChanged

  /**
    * This event occurs when a script changes visibility of the JavaScript window object.
    */
  val VisibilityChanged: EventType[jfxsw.WebEvent[_]] = jfxsw.WebEvent.VISIBILITY_CHANGED
  @deprecated("Use VisibilityChanged; VISIBILITY_CHANGED will be removed in a future release", "8.0.60-R10")
  val VISIBILITY_CHANGED = VisibilityChanged
}

/**
  * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/web/WebEvent.html JavaFX WebEvent]].
  *
  * @constructor Creates a new ScalaFX WebEvent from its JavaFX equivalent.
  * @param delegate JavaFX WebEvent. Since it has no default constructor, there is not default value.
  */
final class WebEvent[T](override val delegate: jfxsw.WebEvent[T])
    extends Event(delegate)
    with SFXDelegate[jfxsw.WebEvent[T]] {

  /**
    * Creates a new event object.
    *
    */
  def this(source: Any, eventType: EventType[jfxsw.WebEvent[_]], data: T) =
    this(new jfxsw.WebEvent(source, eventType, data))

  /**
    * Returns data item carried by this event.
    */
  def data: T = delegate.getData

}
