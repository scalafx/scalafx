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
import scalafx.delegate.SFXDelegate

object ZoomEvent {
  implicit def sfxZoomEvent2jfx(ze: ZoomEvent) = ze.delegate

  /**
   * Common supertype for all Zoom event types.
   */
  val ANY = jfxsi.ZoomEvent.ANY

  /**
   * This event occurs when user performs a zooming gesture such as dragging two fingers apart.
   */
  def ZOOM = jfxsi.ZoomEvent.ZOOM

  /**
   * This event occurs when a zooming gesture is detected.
   */
  def ZOOM_STARTED = jfxsi.ZoomEvent.ZOOM_STARTED

  /**
   * This event occurs when a zooming gesture ends.
   */
  def ZOOM_FINISHED = jfxsi.ZoomEvent.ZOOM_FINISHED

}

/**
 * Wraps [[http://docs.oracle.com/javafx/2/api/javafx/scene/input/ZoomEvent.html]]
 */
class ZoomEvent(override val delegate: jfxsi.ZoomEvent)
  extends GestureEvent(delegate)
  with SFXDelegate[jfxsi.ZoomEvent] {

  /**
   * Gets the zooming amount of this gesture.
   */
  def totalZoomFactor = delegate.getTotalZoomFactor()

  /**
   * Gets the zooming amount of this event.
   */
  def zoomFactor = delegate.getZoomFactor()

}