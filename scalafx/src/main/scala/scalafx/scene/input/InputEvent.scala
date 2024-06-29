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
import javafx.{event => jfxe}

import scala.language.implicitConversions
import scalafx.delegate.SFXDelegate
import scalafx.event.Event

// so far ony minimal stuff

object InputEvent {
  implicit def sfxInputEvent2jfx(ie: InputEvent): jfxsi.InputEvent = if (ie != null) ie.delegate else null

  val Any: jfxe.EventType[jfxsi.InputEvent] = jfxsi.InputEvent.ANY
}

class InputEvent(override val delegate: jfxsi.InputEvent) extends Event(delegate) with SFXDelegate[jfxsi.InputEvent] {

  def this(eventType: jfxe.EventType[jfxsi.InputEvent]) = this(new jfxsi.InputEvent(eventType))

  def this(source: AnyRef, target: jfxe.EventTarget, eventType: jfxe.EventType[jfxsi.InputEvent]) =
    this(new jfxsi.InputEvent(source, target, eventType))

}
