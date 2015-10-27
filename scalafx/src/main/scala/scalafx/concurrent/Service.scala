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
package scalafx.concurrent

import java.util.{concurrent => juc}
import javafx.{concurrent => jfxc, event => jfxe}

import scala.language.implicitConversions
import scalafx.Includes._
import scalafx.beans.property.ObjectProperty
import scalafx.delegate.SFXDelegate
import scalafx.event.EventHandlerDelegate

object Service {
  implicit def sfxService2jfx[T](s: Service[T]): jfxc.Service[T] = if (s != null) s.delegate else null

  /**
   * Create a new [[scalafx.concurrent.Service]] with a operation to be invoked after this was started on the JavaFX
   * Application Thread.
   *
   * @param op [[scala.Function]] that returns a [[scalafx.concurrent.Task]] to be invoked after this was started on
   *           the JavaFX Application Thread.
   */
  def apply[T](op: => jfxc.Task[T]) = new Service[T](new jfxc.Service[T] {
    protected def createTask = op
  }) {}
}

/**
 * Wrapper trait for [[http://docs.oracle.com/javase/8/javafx/api/javafx/concurrent/Service.html Service]]
 * Class.
 */
abstract class Service[T](override val delegate: jfxc.Service[T])
  extends Worker[T]
  with jfxe.EventTarget
  with EventHandlerDelegate
  with SFXDelegate[jfxc.Service[T]] {

  def eventHandlerDelegate = delegate.asInstanceOf[EventHandled]

  /**
   * The executor to use for running this Service.
   */
  def executor: ObjectProperty[juc.Executor] = delegate.executorProperty
  def executor_=(v: juc.Executor) {
    executor() = v
  }

  /**
   * The onCancelled event handler is called whenever the Task state transitions to the CANCELLED
   * state.
   */
  def onCancelled = delegate.onCancelledProperty
  def onCancelled_=(v: jfxe.EventHandler[jfxc.WorkerStateEvent]) {
    onCancelled() = v
  }
  def onCancelled_=(handler: WorkerStateEvent => Unit) {
    onCancelled() = new jfxe.EventHandler[jfxc.WorkerStateEvent] {
      override def handle(event: jfxc.WorkerStateEvent): Unit = handler(event)
    }
  }

  /**
   * The onFailed event handler is called whenever the Task state transitions to the FAILED state.
   */
  def onFailed = delegate.onFailedProperty
  def onFailed_=(v: jfxe.EventHandler[jfxc.WorkerStateEvent]) {
    onFailed() = v
  }
  def onFailed_=(handler: WorkerStateEvent => Unit) {
    onFailed() = new jfxe.EventHandler[jfxc.WorkerStateEvent] {
      override def handle(event: jfxc.WorkerStateEvent): Unit = handler(event)
    }
  }

  /**
   * The onReady event handler is called whenever the Task state transitions to the READY state.
   */
  def onReady = delegate.onReadyProperty
  def onReady_=(v: jfxe.EventHandler[jfxc.WorkerStateEvent]) {
    onReady() = v
  }
  def onReady_=(handler: WorkerStateEvent => Unit) {
    onReady() = new jfxe.EventHandler[jfxc.WorkerStateEvent] {
      override def handle(event: jfxc.WorkerStateEvent): Unit = handler(event)
    }
  }

  /**
   * The onRunning event handler is called whenever the Task state transitions to the RUNNING state.
   */
  def onRunning = delegate.onRunningProperty
  def onRunning_=(v: jfxe.EventHandler[jfxc.WorkerStateEvent]) {
    onRunning() = v
  }
  def onRunning_=(handler: WorkerStateEvent => Unit) {
    onRunning() = new jfxe.EventHandler[jfxc.WorkerStateEvent] {
      override def handle(event: jfxc.WorkerStateEvent): Unit = handler(event)
    }
  }

  /**
   * The onSchedule event handler is called whenever the Task state transitions to the SCHEDULED
   * state.
   */
  def onScheduled = delegate.onScheduledProperty
  def onScheduled_=(v: jfxe.EventHandler[jfxc.WorkerStateEvent]) {
    onScheduled() = v
  }
  def onScheduled_=(handler: WorkerStateEvent => Unit) {
    onScheduled() = new jfxe.EventHandler[jfxc.WorkerStateEvent] {
      override def handle(event: jfxc.WorkerStateEvent): Unit = handler(event)
    }
  }

  /**
   * The onSucceeded event handler is called whenever the Task state transitions to the SUCCEEDED
   * state.
   */
  def onSucceeded = delegate.onSucceededProperty
  def onSucceeded_=(v: jfxe.EventHandler[jfxc.WorkerStateEvent]) {
    onSucceeded() = v
  }
  def onSucceeded_=(handler: WorkerStateEvent => Unit) {
    onSucceeded() = new jfxe.EventHandler[jfxc.WorkerStateEvent] {
      override def handle(event: jfxc.WorkerStateEvent): Unit = handler(event)
    }
  }

  /**
   * Resets the Service.
   */
  def reset() {
    delegate.reset()
  }

  /**
   * Cancels any currently running Task, if any, and restarts this Service.
   */
  def restart() {
    delegate.restart()
  }

  /**
   * Starts this Service.
   */
  def start() {
    delegate.start()
  }

}
