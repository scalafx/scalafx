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

package scalafx.event

import javafx.{ event => jfxe }
import scalafx.util.SFXDelegate
import scalafx.event.EventIncludes._

object EventType {
  implicit def sfxEventType2jfx[T <: jfxe.Event](et: EventType[T]) = et.delegate

  /**
   * The root event type. All other event types are eighter direct or indirect sub types of it.
   * It is also the only event type which has its super event type set to null.
   */
  val ROOT = jfxe.EventType.ROOT
}

class EventType[T <: jfxe.Event](override val delegate: jfxe.EventType[T] = new jfxe.EventType[T]) extends SFXDelegate[jfxe.EventType[T]] {
  /*
   * COMPILER ERROR MESSAGE:
	- overloaded method constructor EventType with alternatives: 
	(javafx.event.EventType[_ >: T(in class EventType)(in class EventType)])javafx.event.EventType[T(in class EventType)(in class EventType)]  <and> 
	(java.lang.String)javafx.event.EventType[T(in class EventType)(in class EventType)] cannot be applied to (T(in class EventType)(in class EventType))
   */
  //  def this(superType: T) = this(new jfxe.EventType(superType))

  /*
   * COMPILER ERROR MESSAGE:
   * type mismatch; found : T required: javafx.event.EventType[_ >: ?]
   */
  //  def this(superType: T, name: String) = this(new jfxe.EventType(superType, name))

  /**
   * Constructs a new EventType with the specified name and the EventType.ROOT as its super type.
   *
   * @param The name
   */
  def this(name: String) = this(new jfxe.EventType[T](name))

  /**
   * Gets the name of this event type.
   */
  def name = delegate.getName

  /**
   * Gets the super type of this event type.
   */
  def superType = delegate.getSuperType

}