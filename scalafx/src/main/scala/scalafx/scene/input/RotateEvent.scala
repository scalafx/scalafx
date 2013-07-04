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
import scalafx.delegate.SFXDelegate

object RotateEvent {
  implicit def sfxRotateEvent2jfx(re: RotateEvent) = re.delegate

  /**
   * Common supertype for all rotate event types.
   */
  val ANY = jfxsi.RotateEvent.ANY

  /**
   * This event occurs when user performs a rotating gesture such as dragging two fingers around each other.
   */
  val ROTATE = jfxsi.RotateEvent.ROTATE

  /**
   * This event occurs when a rotating gesture ends.
   */
  val ROTATION_FINISHED = jfxsi.RotateEvent.ROTATION_FINISHED

  /**
   * This event occurs when a rotating gesture is detected.
   */
  val ROTATION_STARTED = jfxsi.RotateEvent.ROTATION_STARTED

}

/**
 * Wraps [[http://docs.oracle.com/javafx/2/api/javafx/scene/input/RotateEvent.html]]
 */
class RotateEvent(override val delegate: jfxsi.RotateEvent)
  extends InputEvent(delegate)
  with SFXDelegate[jfxsi.RotateEvent] {

  /**
   * Gets the rotation angle of this event.
   */
  def angle = delegate.getAngle

  /**
   * Gets the cumulative rotation angle of this gesture.
   */
  def totalAngle = delegate.getTotalAngle

}