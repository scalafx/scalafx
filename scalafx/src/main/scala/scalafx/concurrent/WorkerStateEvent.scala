/*
 * Copyright (c) 2011-2015, ScalaFX Project
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

import javafx.{concurrent => jfxc}

import scala.language.implicitConversions
import scalafx.Includes._
import scalafx.delegate.SFXDelegate
import scalafx.event.{Event, EventType}

object WorkerStateEvent {
  implicit def sfxWorkerStateEvent2jfx(w: WorkerStateEvent): jfxc.WorkerStateEvent = if (w != null) w.delegate else null

  /**
   * Common supertype for all worker state event types.
   */
  val ANY: EventType[jfxc.WorkerStateEvent] = jfxc.WorkerStateEvent.ANY

  /**
   * This event occurs when the state of a Worker implementation has transitioned to the
   * CANCELLED state.
   */
  val WorkerStateCancelled: EventType[jfxc.WorkerStateEvent] = jfxc.WorkerStateEvent.WORKER_STATE_CANCELLED
  @deprecated ("Use WorkerStateCancelled; WORKER_STATE_CANCELLED will be removed in a future release", "8.0.60-R10")
  val WORKER_STATE_CANCELLED = WorkerStateCancelled

  /**
   * This event occurs when the state of a Worker implementation has transitioned to the
   * FAILED state.
   */
  val WorkerStateFailed: EventType[jfxc.WorkerStateEvent] = jfxc.WorkerStateEvent.WORKER_STATE_FAILED
  @deprecated ("Use WorkerStateFailed; WORKER_STATE_FAILED will be removed in a future release", "8.0.60-R10")
  val WORKER_STATE_FAILED = WorkerStateFailed

  /**
   * This event occurs when the state of a Worker implementation has transitioned to the
   * READY state.
   */
  val WorkerStateReady: EventType[jfxc.WorkerStateEvent] = jfxc.WorkerStateEvent.WORKER_STATE_READY
  @deprecated ("Use WorkerStateReady; WORKER_STATE_READY will be removed in a future release", "8.0.60-R10")
  val WORKER_STATE_READY = WorkerStateReady

  /**
   * This event occurs when the state of a Worker implementation has transitioned to the
   * RUNNING state.
   */
  val WorkerStateRunning: EventType[jfxc.WorkerStateEvent] = jfxc.WorkerStateEvent.WORKER_STATE_RUNNING
  @deprecated ("Use WorkerStateRunning; WORKER_STATE_RUNNING will be removed in a future release", "8.0.60-R10")
  val WORKER_STATE_RUNNING = WorkerStateRunning

  /**
   * This event occurs when the state of a Worker implementation has transitioned to the
   * SCHEDULED state.
   */
  val WorkerStateScheduled: EventType[jfxc.WorkerStateEvent] = jfxc.WorkerStateEvent.WORKER_STATE_SCHEDULED
  @deprecated ("Use WorkerStateScheduled; WORKER_STATE_SCHEDULED will be removed in a future release", "8.0.60-R10")
  val WORKER_STATE_SCHEDULED = WorkerStateScheduled

  /**
   * This event occurs when the state of a Worker implementation has transitioned to the
   * SUCCEEDED state.
   */
  val WorkerStateSucceeded: EventType[jfxc.WorkerStateEvent] = jfxc.WorkerStateEvent.WORKER_STATE_SUCCEEDED
  @deprecated ("Use WorkerStateSucceeded; WORKER_STATE_SUCCEEDED will be removed in a future release", "8.0.60-R10")
  val WORKER_STATE_SUCCEEDED = WorkerStateSucceeded

}

/**
 * Wrapper trait for [[http://docs.oracle.com/javase/8/javafx/api/javafx/concurrent/WorkerStateEvent.html WorkerStateEvent]] Class.
 */
class WorkerStateEvent(override val delegate: jfxc.WorkerStateEvent)
  extends Event(delegate)
  with SFXDelegate[jfxc.WorkerStateEvent] {

  /**
   * Create a new WorkerStateEvent.
   *
   * @param worker The Worker which is firing the event. The Worker really should be an
   *               EventTarget, otherwise the EventTarget for the event will be null.
   * @param eventType The type of event. This should not be null.
   */
  def this(worker: Worker[_], eventType: EventType[_ <: jfxc.WorkerStateEvent]) =
    this(new jfxc.WorkerStateEvent(worker, eventType))

}
