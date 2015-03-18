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

package scalafx.scene.control

import javafx.scene.{control => jfxsc}
import javafx.{event => jfxe}

import scala.language.implicitConversions
import scalafx.Includes._
import scalafx.delegate.SFXDelegate
import scalafx.event.{Event, EventType}

/**
 * Object companion for [[scalafx.scene.control.DialogEvent]].
 */
object DialogEvent {
  /**
   * Converts a ScalaFX DialogEvent to its JavaFX counterpart.
   *
   * @param v ScalaFX DialogEvent
   * @return JavaFX DialogEvent
   */
  implicit def sfxDialogEvent2jfx(v: DialogEvent): jfxsc.DialogEvent =
    if (v != null) v.delegate else null
  /**
   * Common supertype for all dialog event types.
   */
  val Any: EventType[jfxsc.DialogEvent] = jfxsc.DialogEvent.ANY
  /**
   * This event occurs on dialog just before it is shown.
   */
  val DialogShowing: EventType[jfxsc.DialogEvent] = jfxsc.DialogEvent.DIALOG_SHOWING
  /**
   * This event occurs on dialog just after it is shown.
   */
  val DialogShown: EventType[jfxsc.DialogEvent] = jfxsc.DialogEvent.DIALOG_SHOWN
  /**
   * This event occurs on dialog just before it is hidden.
   */
  val DialogHiding: EventType[jfxsc.DialogEvent] = jfxsc.DialogEvent.DIALOG_HIDING
  /**
   * This event occurs on dialog just after it is hidden.
   */
  val DialogHidden: EventType[jfxsc.DialogEvent] = jfxsc.DialogEvent.DIALOG_HIDDEN
  /**
   * This event is delivered to a
   * dialog when there is an external request to close that dialog. If the
   * event is not consumed by any installed dialog event handler, the default
   * handler for this event closes the corresponding dialog.
   */
  val DialogCloseRequest: EventType[jfxsc.DialogEvent] = jfxsc.DialogEvent.DIALOG_CLOSE_REQUEST
}

/**
 * Event related to dialog showing/hiding actions.
 * Wraps a $JFX $URL0 $TC]].
 *
 * @define TC DialogEvent
 * @define URL0 [[https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/DialogEvent.html
 * @define JFX JavaFX
 * @define ORIGINALDOC Original Documentation]].
 */
class DialogEvent(override val delegate: jfxsc.DialogEvent)
  extends Event(delegate)
  with SFXDelegate[jfxsc.DialogEvent] {

  def this(source: Dialog[_], eventType: EventType[_ <: jfxe.Event]) =
    this(new jfxsc.DialogEvent(source.delegate, eventType.delegate))

  override def eventType: EventType[jfxsc.DialogEvent] = delegate.getEventType
}