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

import javafx.scene.input as jfxsi
import scalafx.Includes.*
import scalafx.delegate.SFXDelegate
import scalafx.event.EventType

import scala.language.implicitConversions

object RotateEvent {
  implicit def sfxRotateEvent2jfx(re: RotateEvent): jfxsi.RotateEvent = if (re != null) re.delegate else null

  /**
   * Common supertype for all rotate event types.
   */
  val Any: EventType[jfxsi.RotateEvent] = jfxsi.RotateEvent.ANY
  @deprecated("Use Any; ANY will be removed in a future release", "8.0.60-R10")
  val ANY: EventType[jfxsi.RotateEvent] = Any

  /**
   * This event occurs when user performs a rotating gesture such as dragging two fingers around each other.
   */
  val Rotate: EventType[jfxsi.RotateEvent] = jfxsi.RotateEvent.ROTATE
  @deprecated("Use Rotate; ROTATE will be removed in a future release", "8.0.60-R10")
  val ROTATE: EventType[jfxsi.RotateEvent] = Rotate

  /**
   * This event occurs when a rotating gesture ends.
   */
  val RotationFinished: EventType[jfxsi.RotateEvent] = jfxsi.RotateEvent.ROTATION_FINISHED
  @deprecated("Use RotationFinished; ROTATION_FINISHED will be removed in a future release", "8.0.60-R10")
  val ROTATION_FINISHED: EventType[jfxsi.RotateEvent] = RotationFinished

  /**
   * This event occurs when a rotating gesture is detected.
   */
  val RotationStarted: EventType[jfxsi.RotateEvent] = jfxsi.RotateEvent.ROTATION_STARTED
  @deprecated("Use RotationStarted; ROTATION_STARTED will be removed in a future release", "8.0.60-R10")
  val ROTATION_STARTED: EventType[jfxsi.RotateEvent] = RotationStarted

}

/**
 * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/input/RotateEvent.html]]
 */
class RotateEvent(override val delegate: jfxsi.RotateEvent)
    extends InputEvent(delegate)
    with SFXDelegate[jfxsi.RotateEvent] {

  /**
   * Gets the rotation angle of this event.
   */
  def angle: Double = delegate.getAngle

  /**
   * Gets the cumulative rotation angle of this gesture.
   */
  def totalAngle: Double = delegate.getTotalAngle

}
