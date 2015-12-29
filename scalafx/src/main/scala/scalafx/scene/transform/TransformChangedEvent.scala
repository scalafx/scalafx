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
package scalafx.scene.transform

import javafx.scene.{transform => jfxst}
import javafx.{event => jfxe}

import scala.language.implicitConversions
import scalafx.delegate.SFXDelegate
import scalafx.event.Event


object TransformChangedEvent {
  implicit def sfxTransformChangedEvent2jfx(v: TransformChangedEvent): jfxst.TransformChangedEvent = if (v != null) v.delegate else null

  val Any = jfxst.TransformChangedEvent.ANY
  @deprecated ("Use Any; ANY will be removed in a future release", "8.0.60-R10")
  val ANY = Any

  /** The only valid EventType for the TransformChangedEvent. */
  val TransformChanged = jfxst.TransformChangedEvent.TRANSFORM_CHANGED
  @deprecated ("Use TransformChanged; TRANSFORM_CHANGED will be removed in a future release", "8.0.60-R10")
  val TRANSFORM_CHANGED = TransformChanged
}

/** Wraps [[http://docs.oracle.com/javafx/8/api/javafx/scene/scene/transform/TransformChangedEvent.html]] */
class TransformChangedEvent(override val delegate: jfxst.TransformChangedEvent = new jfxst.TransformChangedEvent())
  extends Event(delegate) with SFXDelegate[jfxst.TransformChangedEvent] {

  def this(source: Any, target: jfxe.EventTarget) {
    this(new jfxst.TransformChangedEvent(source, target))
  }
}
