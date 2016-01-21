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
package scalafx.event

import javafx.{event => jfxe}

import scala.language.implicitConversions
import scalafx.delegate.SFXDelegate

object EventType {
  implicit def sfxEventType2jfx[T <: jfxe.Event](et: EventType[T]): jfxe.EventType[T] = if (et != null) et.delegate else null

  /**
   * The root event type. All other event types are either direct or indirect sub types of it.
   * It is also the only event type which has its super event type set to null.
   */
  val Root = new EventType(jfxe.EventType.ROOT)
  @deprecated ("Use Root; ROOT will be removed in a future release", "8.0.60-R10")
  val ROOT = Root
}

class EventType[T <: jfxe.Event](override val delegate: jfxe.EventType[T]) extends SFXDelegate[jfxe.EventType[T]] {

  /**
   * Constructs a new `EventType` with the specified super type and the name set to null. 
   */
  // Dummy implicit is used to disambiguate this auxiliary constructor from the main constructor - otherwise, they both have the same type after erasure, and the code cannot compile.
  def this(superType: jfxe.EventType[_ >: T])(implicit d: DummyImplicit) =
    this(new jfxe.EventType[T](superType))

  /**
   * Constructs a new `EventType` with the specified super type and name.
   */
  def this(superType: jfxe.EventType[_ >: T], name: String) =
    this(new jfxe.EventType[T](superType, name))

  /**
   * Constructs a new `EventType` with the specified name and the EventType.ROOT as its super type.
   *
   * @param name The name
   */
  def this(name: String) =
    this(new jfxe.EventType[T](name))

  /**
   * Gets the name of this event type.
   */
  def name = delegate.getName

  /**
   * Gets the super type of this event type.
   */
  def superType = delegate.getSuperType

}
