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
package scalafx.scene.input

import javafx.scene.{ input => jfxsi }
import scala.collection.JavaConversions._
import scalafx.Includes._
import scalafx.delegate.SFXDelegate
import scalafx.event.EventType
import scala.collection.mutable

object TouchEvent {
  implicit def sfxTouchEvent2jfx(se: TouchEvent) = se.delegate

  /**
   * Common supertype for all touch event types.
   */
  val ANY : EventType[jfxsi.TouchEvent] = jfxsi.TouchEvent.ANY

  /**
   * This event occurs when the touch point is pressed (touched for the first time).
   */
  val TOUCH_PRESSED : EventType[jfxsi.TouchEvent] = jfxsi.TouchEvent.TOUCH_PRESSED

  /**
   * This event occurs when the touch point is moved.
   */
  val TOUCH_MOVED : EventType[jfxsi.TouchEvent] = jfxsi.TouchEvent.TOUCH_MOVED

  /**
   * This event occurs when the touch point is released.
   */
  val TOUCH_RELEASED : EventType[jfxsi.TouchEvent] = jfxsi.TouchEvent.TOUCH_RELEASED

  /**
   * This event occurs when the touch point is pressed and still (doesn't move).
   */
  val TOUCH_STATIONARY : EventType[jfxsi.TouchEvent] = jfxsi.TouchEvent.TOUCH_STATIONARY

}

/**
 * Wraps [[http://docs.oracle.com/javafx/2/api/javafx/scene/input/TouchEvent.html]]
 */
class TouchEvent(override val delegate: jfxsi.TouchEvent)
  extends InputEvent(delegate)
  with SFXDelegate[jfxsi.TouchEvent] {

  /**
   * Returns number of touch points represented by this touch event set.
   * The returned number matches the size of the touchPoints list.
   */
  def touchCount : Int = delegate.getTouchCount
  
  /**
   * Gets all the touch points represented by this set of touch events, including the touch point of this event.
   *  The list is unmodifiable and is sorted by their IDs, which means it is also sorted by the time they were pressed.
   *  To distinguish between touch points belonging to a node and unrelated touch points, TouchPoint's belongsTo method can be used.
   */
  def touchPoints : mutable.Buffer[jfxsi.TouchPoint] = delegate.getTouchPoints

  /**
   * Gets the touch point of this event.
   */
  def touchPoint : TouchPoint = delegate.getTouchPoint
  
  /**
   * Gets sequential number of the set of touch events representing the same multi-touch action.
   *  For a multi-touch user action, number of touch points may exist; each of them produces a touch event,
   *  each of those touch events carry the same list of touch points - and all of them return the same number from this method.
   *  Then state of some of the touch points changes and the new set of events has new id.
   *  The id is guaranteed to be sequential and unique in scope of one gesture (is reset when all touch points are released).
   */
  def eventSetId : Int = delegate.getEventSetId

  /**
   * Indicates whether or not the Alt modifier is down on this event.
   */
  def altDown : Boolean = delegate.isAltDown

  /**
   * Indicates whether or not the Control modifier is down on this event.
   */
  def controlDown : Boolean = delegate.isControlDown

  /**
   * Indicates whether or not the Meta modifier is down on this event.
   */
  def metaDown : Boolean = delegate.isMetaDown

  /**
   * Indicates whether or not the Shift modifier is down on this event.
   */
  def shiftDown : Boolean = delegate.isShiftDown

}