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
package scalafx.scene.input

import javafx.scene.{ input => jfxsi }
import scalafx.util.SFXDelegate

object SwipeEvent {
  implicit def sfxSwipeEvent2jfx(se: SwipeEvent) = se.delegate

  /**
   * Common supertype for all Swipe event types.
   */
  val ANY = jfxsi.SwipeEvent.ANY

  /**
   * This event occurs when user performs downward swipe gesture.
   */
  val SWIPE_DOWN = jfxsi.SwipeEvent.SWIPE_DOWN

  /**
   * This event occurs when user performs leftward swipe gesture.
   */
  val SWIPE_LEFT = jfxsi.SwipeEvent.SWIPE_LEFT

  /**
   * This event occurs when user performs rightward swipe gesture.
   */
  val SWIPE_RIGHT = jfxsi.SwipeEvent.SWIPE_RIGHT

  /**
   * This event occurs when user performs upward swipe gesture.
   */
  val SWIPE_UP = jfxsi.SwipeEvent.SWIPE_UP

}

/**
 * Wraps [[http://docs.oracle.com/javafx/2/api/javafx/scene/input/SwipeEvent.html]]
 */
class SwipeEvent(override val delegate: jfxsi.SwipeEvent)
  extends GestureEvent(delegate)
  with SFXDelegate[jfxsi.SwipeEvent] {

  /**
   * Gets number of touch points that caused this event.
   */
  def touchCount = delegate.getTouchCount

}