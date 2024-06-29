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
package scalafx.scene.input

import javafx.scene.{input => jfxsi}
import scalafx.Includes._
import scalafx.delegate.SFXDelegate
import scalafx.event.EventType

import scala.collection.JavaConverters._
import scala.collection.mutable
import scala.language.implicitConversions

object TouchEvent {
  implicit def sfxTouchEvent2jfx(se: TouchEvent): jfxsi.TouchEvent = if (se != null) se.delegate else null

  /**
   * Common supertype for all touch event types.
   */
  val Any: EventType[jfxsi.TouchEvent] = jfxsi.TouchEvent.ANY
  @deprecated("Use Any; ANY will be removed in a future release", "8.0.60-R10")
  val ANY: EventType[jfxsi.TouchEvent] = Any

  /**
   * This event occurs when the touch point is pressed (touched for the first time).
   */
  val TouchPressed: EventType[jfxsi.TouchEvent] = jfxsi.TouchEvent.TOUCH_PRESSED
  @deprecated("Use TouchPressed; TOUCH_PRESSED will be removed in a future release", "8.0.60-R10")
  val TOUCH_PRESSED: EventType[jfxsi.TouchEvent] = TouchPressed

  /**
   * This event occurs when the touch point is moved.
   */
  val TouchMoved: EventType[jfxsi.TouchEvent] = jfxsi.TouchEvent.TOUCH_MOVED
  @deprecated("Use TouchMoved; TOUCH_MOVED will be removed in a future release", "8.0.60-R10")
  val TOUCH_MOVED: EventType[jfxsi.TouchEvent] = TouchMoved

  /**
   * This event occurs when the touch point is released.
   */
  val TouchReleased: EventType[jfxsi.TouchEvent] = jfxsi.TouchEvent.TOUCH_RELEASED
  @deprecated("Use TouchReleased; TOUCH_RELEASED will be removed in a future release", "8.0.60-R10")
  val TOUCH_RELEASED: EventType[jfxsi.TouchEvent] = TouchReleased

  /**
   * This event occurs when the touch point is pressed and still (doesn't move).
   */
  val TouchStationary: EventType[jfxsi.TouchEvent] = jfxsi.TouchEvent.TOUCH_STATIONARY
  @deprecated("Use TouchStationary; TOUCH_STATIONARY will be removed in a future release", "8.0.60-R10")
  val TOUCH_STATIONARY: EventType[jfxsi.TouchEvent] = TouchStationary

}

/**
 * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/input/TouchEvent.html]]
 */
class TouchEvent(override val delegate: jfxsi.TouchEvent)
    extends InputEvent(delegate)
    with SFXDelegate[jfxsi.TouchEvent] {

  /**
   * Returns number of touch points represented by this touch event set.
   * The returned number matches the size of the touchPoints list.
   */
  def touchCount: Int = delegate.getTouchCount

  /**
   * Gets all the touch points represented by this set of touch events, including the touch point of this event.
   * The list is unmodifiable and is sorted by their IDs, which means it is also sorted by the time they were pressed.
   * To distinguish between touch points belonging to a node and unrelated touch points, TouchPoint's belongsTo method can be used.
   */
  def touchPoints: mutable.Buffer[jfxsi.TouchPoint] = delegate.getTouchPoints.asScala

  /**
   * Gets the touch point of this event.
   */
  def touchPoint: TouchPoint = delegate.getTouchPoint

  /**
   * Gets sequential number of the set of touch events representing the same multi-touch action.
   * For a multi-touch user action, number of touch points may exist; each of them produces a touch event,
   * each of those touch events carry the same list of touch points - and all of them return the same number from this method.
   * Then state of some of the touch points changes and the new set of events has new id.
   * The id is guaranteed to be sequential and unique in scope of one gesture (is reset when all touch points are released).
   */
  def eventSetId: Int = delegate.getEventSetId

  /**
   * Indicates whether or not the Alt modifier is down on this event.
   */
  def altDown: Boolean = delegate.isAltDown

  /**
   * Indicates whether or not the Control modifier is down on this event.
   */
  def controlDown: Boolean = delegate.isControlDown

  /**
   * Indicates whether or not the Meta modifier is down on this event.
   */
  def metaDown: Boolean = delegate.isMetaDown

  /**
   * Indicates whether or not the Shift modifier is down on this event.
   */
  def shiftDown: Boolean = delegate.isShiftDown

}
