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

import scala.language.implicitConversions
import scalafx.Includes._
import scalafx.delegate.SFXDelegate
import scalafx.event.EventType

object MouseDragEvent {
  implicit def sfxMouseDragEvent2jfx(mde: MouseDragEvent): jfxsi.MouseDragEvent =
    if (mde != null) mde.delegate else null

  /**
   * Common supertype for all mouse event types.
   */
  val Any: EventType[jfxsi.MouseDragEvent] = jfxsi.MouseDragEvent.ANY

  /**
   * This event occurs when the gesture enters a node.
   */
  val MouseDragEntered: EventType[jfxsi.MouseDragEvent] = jfxsi.MouseDragEvent.MOUSE_DRAG_ENTERED

  /**
   * This event occurs when the gesture enters a node.
   */
  val MouseDragEnteredTarget: EventType[jfxsi.MouseDragEvent] = jfxsi.MouseDragEvent.MOUSE_DRAG_ENTERED_TARGET

  /**
   * This event occurs when the gesture exits a node.
   */
  val MouseDragExited: EventType[jfxsi.MouseDragEvent] = jfxsi.MouseDragEvent.MOUSE_DRAG_EXITED

  /**
   * This event occurs when the gesture exits a node.
   */
  val MouseDragExitedTarget: EventType[jfxsi.MouseDragEvent] = jfxsi.MouseDragEvent.MOUSE_DRAG_EXITED_TARGET

  /**
   * This event occurs when the gesture progresses within this node.
   */
  val MouseDragOver: EventType[jfxsi.MouseDragEvent] = jfxsi.MouseDragEvent.MOUSE_DRAG_OVER

  /**
   * This event occurs when the gesture ends (by releasing mouse button) on this node.
   */
  val MouseDragReleased: EventType[jfxsi.MouseDragEvent] = jfxsi.MouseDragEvent.MOUSE_DRAG_RELEASED

}

class MouseDragEvent(override val delegate: jfxsi.MouseDragEvent) extends MouseEvent(delegate)
    with SFXDelegate[jfxsi.MouseDragEvent] {

  /**
   * Returns the source object of the ongoing gesture.
   */
  def gestureSource: Object = delegate.getGestureSource

}
