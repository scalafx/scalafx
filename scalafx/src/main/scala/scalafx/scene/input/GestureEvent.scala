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
package scalafx.scene.input

import javafx.event as jfxe
import javafx.scene.input as jfxsi
import scalafx.Includes.*
import scalafx.delegate.SFXDelegate
import scalafx.event.{Event, EventType}

import scala.language.implicitConversions

object GestureEvent {
  implicit def sfxGestureEvent2jfx(ge: GestureEvent): jfxsi.GestureEvent = if (ge != null) ge.delegate else null

  /**
   * Common supertype for all gestures.
   */
  val Any: EventType[jfxsi.GestureEvent] = jfxsi.GestureEvent.ANY

  @deprecated("Use Any; ANY will be removed in a future release", "8.0.60-R10")
  val ANY: EventType[jfxsi.GestureEvent] = jfxsi.GestureEvent.ANY

}

/**
 * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/input/GestureEvent.html]]
 */
class GestureEvent(override val delegate: jfxsi.GestureEvent)
    extends InputEvent(delegate)
    with SFXDelegate[jfxsi.GestureEvent] {

  /**
   * Creates and returns a copy of this event with the specified event source and target.
   */
  override def copyFor(newSource: AnyRef, newTarget: jfxe.EventTarget): Event = delegate.copyFor(newSource, newTarget)

  /**
   * Gets the horizontal position of the event relative to the origin of the event's source.
   */
  def x: Double = delegate.getX

  /**
   * Gets the vertical position of the event relative to the origin of the event's source.
   */
  def y: Double = delegate.getY

  /**
   * Gets the horizontal position of the event relative to the origin of the Scene that contains the event's source.
   */
  def sceneX: Double = delegate.getSceneX

  /**
   * Gets the vertical position of the event relative to the origin of the Scene that contains the event's source.
   */
  def sceneY: Double = delegate.getSceneY

  /**
   * Gets the absolute horizontal position of the event.
   */
  def screenX: Double = delegate.getScreenX

  /**
   * Gets the absolute vertical position of the event.
   */
  def screenY: Double = delegate.getScreenY

  /**
   * Indicates whether or not the Alt modifier is down on this event.
   */
  def altDown: Boolean = delegate.isAltDown

  /**
   * Indicates whether or not the Control modifier is down on this event.
   */
  def controlDown: Boolean = delegate.isControlDown

  /**
   * Indicates whether this gesture is caused by a direct or indirect input device.
   */
  def direct: Boolean = delegate.isDirect

  /**
   * Indicates if this event represents an inertia of an already finished gesture.
   */
  def inertia: Boolean = delegate.isInertia

  /**
   * Indicates whether or not the Meta modifier is down on this event.
   */
  def metaDown: Boolean = delegate.isMetaDown

  /**
   * Indicates whether or not the Shift modifier is down on this event.
   */
  def shiftDown: Boolean = delegate.isShiftDown

  /**
   * Indicates whether or not the host platform common shortcut modifier is down on this event.
   */
  def shortcutDown: Boolean = delegate.isShortcutDown

}
