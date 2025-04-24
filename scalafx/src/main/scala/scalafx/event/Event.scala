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
package scalafx.event

import javafx.event as jfxe
import scalafx.Includes.*
import scalafx.delegate.SFXDelegate

import scala.language.implicitConversions

object Event {
  implicit def sfxEvent2jfx(e: Event): jfxe.Event = if (e != null) e.delegate else null

  def apply[T <: jfxe.Event](eventType: jfxe.EventType[T]) = new Event(new jfxe.Event(eventType))

  /**
   * Fires the specified event.
   */
  def fireEvent(eventTarget: jfxe.EventTarget, event: jfxe.Event): Unit = {
    jfxe.Event.fireEvent(eventTarget, event)
  }

  /**
   * Common supertype for all event types.
   */
  val Any: EventType[jfxe.Event] = jfxe.Event.ANY
  @deprecated("Use Any; ANY will be removed in a future release", "8.0.60-R10")
  val ANY: EventType[jfxe.Event] = jfxe.Event.ANY

  /**
   * The constant which represents an unknown event source / target.
   */
  val NullSourceTarget: jfxe.EventTarget = jfxe.Event.NULL_SOURCE_TARGET
  @deprecated("Use NullSourceTarget; NULL_SOURCE_TARGET will be removed in a future release", "8.0.60-R10")
  val NULL_SOURCE_TARGET: jfxe.EventTarget = NullSourceTarget

}

/**
 * Wrapper class for [[http://docs.oracle.com/javase/8/javafx/api/javafx/event/Event.html Event]].
 */
class Event(override val delegate: jfxe.Event) extends SFXDelegate[jfxe.Event] {

  /**
   * Construct a new Event with the specified event type.
   *
   * @param eventType The event type
   */
  def this(eventType: EventType[_ <: Event]) = this(new Event(eventType))

  /**
   * Construct a new Event with the specified event source, target and type.
   *
   * @param source the event source which sent the event
   * @param target the event target to associate with the event
   * @param eventType The event type
   */
  def this(source: Any, target: jfxe.EventTarget, eventType: EventType[_ <: Event]) =
    this(new Event(source, target, eventType))

  /**
   * Marks this Event as consumed. This stops its further propagation.
   */
  def consume(): Unit = {
    delegate.consume()
  }

  /**
   * Indicates whether this Event has been consumed by any filter or handler.
   */
  def consumed: Boolean = delegate.isConsumed

  /**
   * Creates and returns a copy of this event with the specified event source and target.
   */
  def copyFor(newSource: AnyRef, newTarget: jfxe.EventTarget): Event =
    new Event(delegate.copyFor(newSource, newTarget))

  /**
   * Gets the event type of this event.
   */
  def eventType: EventType[_ <: jfxe.Event] = delegate.getEventType

  /**
   * Returns the object on which the Event initially occurred.
   */
  def source: Object = delegate.getSource

  /**
   * Returns the event target of this event.
   */
  def target: jfxe.EventTarget = delegate.getTarget

}
