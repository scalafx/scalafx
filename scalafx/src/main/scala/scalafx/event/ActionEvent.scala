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
import scalafx.Includes._
import scalafx.delegate.SFXDelegate

/**
 * Companion Object for [[scalafx.event.ActionEvent]].
 */
object ActionEvent {

  /**
   * Converts a ScalaFX ActionEvent to its JavaFX counterpart.
   *
   * @param ie ScalaFX ActionEvent
   * @return JavaFX ActionEvent
   */
  implicit def sfxActionEvent2jfx(ie: ActionEvent): jfxe.ActionEvent = if (ie != null) ie.delegate else null

  @deprecated("Use scalafx.event.ActionEvent.Any instead", "8.0")
  val ACTION: EventType[jfxe.ActionEvent] = jfxe.ActionEvent.ACTION

  /**
   * The only valid EventType for the ActionEvent.
   * @since 8.0
   */
  val Action: EventType[jfxe.ActionEvent] = jfxe.ActionEvent.ACTION

  /**
   * Common supertype for all action event types.
   * @since 8.0
   */
  val Any: EventType[jfxe.ActionEvent] = jfxe.ActionEvent.ANY

}


/**
 * Wraps JavaFX [[http://docs.oracle.com/javase/8/javafx/api/javafx/event/ActionEvent.html ActionEvent]].
 */
class ActionEvent(override val delegate: jfxe.ActionEvent = new jfxe.ActionEvent)
  extends Event(delegate)
  with SFXDelegate[jfxe.ActionEvent] {

  /**
   * Construct a new ActionEvent with the specified event source and target.
   */
  def this(source: Any, target: jfxe.EventTarget) = this(new jfxe.ActionEvent(source, target))

}