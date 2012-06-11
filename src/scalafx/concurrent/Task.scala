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
import javafx.{ event => jfxe }
import scalafx.Includes._
import scalafx.event.EventHandlerDelegate
import scalafx.util.SFXDelegate

object Task {
  implicit def sfxTask2jfx[T](t: Task[T]) = t.delegate

  /**
   * Creates a new [[Task]] with a operation that actually performs the background thread logic. 
   */
  def apply[T](op: => T) = new Task[T](new jfxc.Task[T] {
    def call = op
  }) {}
}

/**
 * Wrapper trait for [[http://docs.oracle.com/javafx/2/api/javafx/concurrent/Task.html Task]]
 * Class.
 */
abstract class Task[T](override val delegate: jfxc.Task[T])
  extends Worker[T]
  with jfxe.EventTarget
  with EventHandlerDelegate
  with SFXDelegate[jfxc.Task[T]] {

  def eventHandlerDelegate = delegate.asInstanceOf[EventHandled]

  /**
   * The onCancelled event handler is called whenever the Task state transitions to the CANCELLED
   * state.
   */
  def onCancelled = delegate.onCancelledProperty
  def onCancelled_=(v: jfxe.EventHandler[jfxc.WorkerStateEvent]) {
    onCancelled() = v
  }

  /**
   * The onFailed event handler is called whenever the Task state transitions to the FAILED state.
   */
  def onFailed = delegate.onFailedProperty
  def onFailed_=(v: jfxe.EventHandler[jfxc.WorkerStateEvent]) {
    onFailed() = v
  }

  /**
   * The onRunning event handler is called whenever the Task state transitions to the RUNNING state.
   */
  def onRunning = delegate.onRunningProperty
  def onRunning_=(v: jfxe.EventHandler[jfxc.WorkerStateEvent]) {
    onRunning() = v
  }

  /**
   * The onSchedule event handler is called whenever the Task state transitions to the SCHEDULED
   * state.
   */
  def onScheduled = delegate.onScheduledProperty
  def onScheduled_=(v: jfxe.EventHandler[jfxc.WorkerStateEvent]) {
    onScheduled() = v
  }

  /**
   * The onSucceeded event handler is called whenever the Task state transitions to the SUCCEEDED
   * state.
   */
  def onSucceeded = delegate.onSucceededProperty
  def onSucceeded_=(v: jfxe.EventHandler[jfxc.WorkerStateEvent]) {
    onSucceeded() = v
  }

  def buildEventDispatchChain(chain: jfxe.EventDispatchChain) = delegate.buildEventDispatchChain(chain)

}