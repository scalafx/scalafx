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
package scalafx.scene.input

import javafx.scene.{input => jfxsi}

import scala.language.implicitConversions
import scalafx.Includes._
import scalafx.delegate.SFXDelegate
import scalafx.event.EventType

object ZoomEvent {
  implicit def sfxZoomEvent2jfx(ze: ZoomEvent): jfxsi.ZoomEvent = if (ze != null) ze.delegate else null

  /**
   * Common supertype for all Zoom event types.
   */
  val Any: EventType[jfxsi.ZoomEvent] = jfxsi.ZoomEvent.ANY
  @deprecated ("Use Any; ANY will be removed in a future release", "8.0.60-R10")
  val ANY = Any

  /**
   * This event occurs when user performs a zooming gesture such as dragging two fingers apart.
   */
  val Zoom: EventType[jfxsi.ZoomEvent] = jfxsi.ZoomEvent.ZOOM
  @deprecated ("Use Zoom; ZOOM will be removed in a future release", "8.0.60-R10")
  val ZOOM = Zoom

  /**
   * This event occurs when a zooming gesture is detected.
   */
  val ZoomStarted: EventType[jfxsi.ZoomEvent] = jfxsi.ZoomEvent.ZOOM_STARTED
  @deprecated ("Use ZoomStarted; ZOOM_STARTED will be removed in a future release", "8.0.60-R10")
  val ZOOM_STARTED = ZoomStarted

  /**
   * This event occurs when a zooming gesture ends.
   */
  val ZoomFinished: EventType[jfxsi.ZoomEvent] = jfxsi.ZoomEvent.ZOOM_FINISHED
  @deprecated ("Use ZoomFinished; ZOOM_FINISHED will be removed in a future release", "8.0.60-R10")
  val ZOOM_FINISHED = ZoomFinished

}

/**
 * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/input/ZoomEvent.html]]
 */
class ZoomEvent(override val delegate: jfxsi.ZoomEvent)
  extends GestureEvent(delegate)
  with SFXDelegate[jfxsi.ZoomEvent] {

  /**
   * Gets the zooming amount of this gesture.
   */
  def totalZoomFactor: Double = delegate.getTotalZoomFactor

  /**
   * Gets the zooming amount of this event.
   */
  def zoomFactor: Double = delegate.getZoomFactor

}
