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
package scalafx.concurrent

import javafx.{ concurrent => jfxc }
import scalafx.event.Event
import scalafx.event.EventType
import scalafx.delegate.SFXDelegate

object WorkerStateEvent {
  implicit def sfxWorkerStateEvent2jfx(w: WorkerStateEvent) = w.delegate

  // Constant definitions

  /**
   * Common supertype for all worker state event types.
   */
  val ANY = new EventType(jfxc.WorkerStateEvent.ANY)

  /**
   * This event occurs when the state of a Worker implementation has transitioned to the
   * CANCELLED state.
   */
  val WORKER_STATE_CANCELLED = new EventType(jfxc.WorkerStateEvent.WORKER_STATE_CANCELLED)

  /**
   * This event occurs when the state of a Worker implementation has transitioned to the
   * FAILED state.
   */
  val WORKER_STATE_FAILED = new EventType(jfxc.WorkerStateEvent.WORKER_STATE_FAILED)

  /**
   * This event occurs when the state of a Worker implementation has transitioned to the
   * READY state.
   */
  val WORKER_STATE_READY = new EventType(jfxc.WorkerStateEvent.WORKER_STATE_READY)

  /**
   * This event occurs when the state of a Worker implementation has transitioned to the
   * RUNNING state.
   */
  val WORKER_STATE_RUNNING = new EventType(jfxc.WorkerStateEvent.WORKER_STATE_RUNNING)

  /**
   * This event occurs when the state of a Worker implementation has transitioned to the
   * SCHEDULED state.
   */
  val WORKER_STATE_SCHEDULED = new EventType(jfxc.WorkerStateEvent.WORKER_STATE_SCHEDULED)

  /**
   * This event occurs when the state of a Worker implementation has transitioned to the
   * SUCCEEDED state.
   */
  val WORKER_STATE_SUCCEEDED = new EventType(jfxc.WorkerStateEvent.WORKER_STATE_SUCCEEDED)

}

/**
 * Wrapper trait for [[http://docs.oracle.com/javafx/2/api/javafx/concurrent/WorkerStateEvent.html
 * WorkerStateEvent]] Class.
 */
class WorkerStateEvent(override val delegate: jfxc.WorkerStateEvent)
  extends Event(delegate)
  with SFXDelegate[jfxc.WorkerStateEvent] {

  /**
   * Create a new WorkerStateEvent.
   *
   * @param worker The Worker which is firing the event. The Worker really should be an
   * EventTarget, otherwise the EventTarget for the event will be null.
   * @param eventType The type of event. This should not be null.
   */
  def this(worker: Worker[_], eventType: EventType[_ <: jfxc.WorkerStateEvent]) =
    this(new jfxc.WorkerStateEvent(worker, eventType))

}