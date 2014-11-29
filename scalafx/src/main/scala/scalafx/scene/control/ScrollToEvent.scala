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
package scalafx.scene.control

import javafx.scene.{control => jfxsc}
import javafx.{event => jfxe}

import scala.language.implicitConversions
import scalafx.Includes._
import scalafx.delegate.SFXDelegate
import scalafx.event.{Event, EventType}

/**
 * Companion Object for [[scalafx.scene.control.ScrollToEvent]].
 */
object ScrollToEvent {

  /**
   * Converts a ScalaFX ScrollToEvent to its JavaFX couterpart
   *
   * @param event ScalaFX ScrollToEvent
   * @return JavaFX ScrollToEvent
   */
  implicit def sfxScrollToEvent2jfx[T](event: ScrollToEvent[T]): jfxsc.ScrollToEvent[T] =
    if (event != null) event.delegate else null

  /**
   * Common supertype for all scroll-to event types.
   */
  val Any: EventType[jfxsc.ScrollToEvent[_]] = jfxsc.ScrollToEvent.ANY

  /**
   * This event occurs if the user requests scrolling a `TableColumnBase` (ie `TableColumn` or `TreeTableColumn`) into view.
   */
  def scrollToColumn[T <: jfxsc.TableColumnBase[_, _]]() = jfxsc.ScrollToEvent.scrollToColumn()

  /**
   * This event occurs if the user requests scrolling a given index into view.
   */
  def scrollToTopIndex(): EventType[jfxsc.ScrollToEvent[Integer]] = jfxsc.ScrollToEvent.scrollToTopIndex()

}

/**
 * Wraps JavaFX [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/ScrollToEvent.html ScrollToEvent]].
 *
 * @constructor Creates a new ScrollToEvent from its JavaFX counterpart.
 * @param delegate JavaFX ScrollToEvent
 * @tparam
 */
class ScrollToEvent[T](override val delegate: jfxsc.ScrollToEvent[T])
  extends Event(delegate)
  with SFXDelegate[jfxsc.ScrollToEvent[T]] {

  /**
   * Construct a new Event with the specified event source, target and type.
   *
   * @param source the event source which sent the event
   * @param target the event source which receives the event
   * @param eventType the event type
   * @param scrollTarget the target of the scroll to operation
   */
  def this(source: Any, target: jfxe.EventTarget, eventType: jfxe.EventType[jfxsc.ScrollToEvent[T]], scrollTarget: T) = this(new jfxsc.ScrollToEvent[T](source, target, eventType, scrollTarget))

  /**
   *
   */
  def scrollTarget: T = delegate.getScrollTarget

}