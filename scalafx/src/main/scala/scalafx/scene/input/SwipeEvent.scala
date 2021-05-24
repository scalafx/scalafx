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
package scalafx.scene.input

import javafx.scene.{input => jfxsi}
import scalafx.Includes._
import scalafx.delegate.SFXDelegate
import scalafx.event.EventType

import scala.language.implicitConversions

object SwipeEvent {
  implicit def sfxSwipeEvent2jfx(se: SwipeEvent): jfxsi.SwipeEvent = if (se != null) se.delegate else null

  /**
   * Common supertype for all Swipe event types.
   */
  val Any: EventType[jfxsi.SwipeEvent] = jfxsi.SwipeEvent.ANY
  @deprecated("Use Any; ANY will be removed in a future release", "8.0.60-R10")
  val ANY: EventType[jfxsi.SwipeEvent] = Any

  /**
   * This event occurs when user performs downward swipe gesture.
   */
  val SwipeDown: EventType[jfxsi.SwipeEvent] = jfxsi.SwipeEvent.SWIPE_DOWN
  @deprecated("Use SwipeDown; SWIPE_DOWN will be removed in a future release", "8.0.60-R10")
  val SWIPE_DOWN: EventType[jfxsi.SwipeEvent] = SwipeDown

  /**
   * This event occurs when user performs leftward swipe gesture.
   */
  val SwipeLeft: EventType[jfxsi.SwipeEvent] = jfxsi.SwipeEvent.SWIPE_LEFT
  @deprecated("Use SwipeLeft; SWIPE_LEFT will be removed in a future release", "8.0.60-R10")
  val SWIPE_LEFT: EventType[jfxsi.SwipeEvent] = SwipeLeft

  /**
   * This event occurs when user performs rightward swipe gesture.
   */
  val SwipeRight: EventType[jfxsi.SwipeEvent] = jfxsi.SwipeEvent.SWIPE_RIGHT
  @deprecated("Use SwipeRight; SWIPE_RIGHT will be removed in a future release", "8.0.60-R10")
  val SWIPE_RIGHT: EventType[jfxsi.SwipeEvent] = SwipeRight

  /**
   * This event occurs when user performs upward swipe gesture.
   */
  val SwipeUp: EventType[jfxsi.SwipeEvent] = jfxsi.SwipeEvent.SWIPE_UP
  @deprecated("Use SwipeUp; SWIPE_UP will be removed in a future release", "8.0.60-R10")
  val SWIPE_UP: EventType[jfxsi.SwipeEvent] = SwipeUp

}

/**
 * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/input/SwipeEvent.html]]
 */
class SwipeEvent(override val delegate: jfxsi.SwipeEvent)
    extends GestureEvent(delegate)
    with SFXDelegate[jfxsi.SwipeEvent] {

  /**
   * Gets number of touch points that caused this event.
   */
  def touchCount: Int = delegate.getTouchCount

}
