/*
 * Copyright (c) 2011-2018, ScalaFX Project
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
import scalafx.Includes._
import scalafx.beans.property._
import scalafx.delegate.{SFXDelegate, SFXEnumDelegate, SFXEnumDelegateCompanion}

import scala.language.implicitConversions

object Worker {
  implicit def sfxWorker2jfx[T](w: Worker[T]): jfxc.Worker[T] = if (w != null) w.delegate else null

  object State
    extends SFXEnumDelegateCompanion[jfxc.Worker.State, State] {

    /**
     * Indicates that this Worker has been cancelled via the Worker.cancel() method. 
     */
    case object Cancelled extends State(jfxc.Worker.State.CANCELLED)
    @deprecated ("Use Cancelled; CANCELLED will be removed in a future release", "8.0.60-R10")
    val CANCELLED = Cancelled

    /**
     * Indicates that this Worker has failed, usually due to some unexpected condition having occurred. 
     */
    case object Failed extends State(jfxc.Worker.State.FAILED)
    @deprecated ("Use Failed; FAILED will be removed in a future release", "8.0.60-R10")
    val FAILED = Failed

    /**
     * Indicates that the Worker has not yet been executed and is ready to be executed, or that it has been reinitialized. 
     */
    case object Ready extends State(jfxc.Worker.State.READY)
    @deprecated ("Use Ready; READY will be removed in a future release", "8.0.60-R10")
    val READY = Ready

    /**
     * Indicates that this Worker is running. 
     */
    case object Running extends State(jfxc.Worker.State.RUNNING)
    @deprecated ("Use Running; RUNNING will be removed in a future release", "8.0.60-R10")
    val RUNNING = Running

    /**
     * Indicates that the Worker has been scheduled for execution, but that it is not currently running. 
     */
    case object Scheduled extends State(jfxc.Worker.State.SCHEDULED)
    @deprecated ("Use Scheduled; SCHEDULED will be removed in a future release", "8.0.60-R10")
    val SCHEDULED = Scheduled

    /**
     * Indicates that this Worker has completed successfully, and that there is a valid result ready to be read from 
     * the value property. 
     */
    case object Succeeded extends State(jfxc.Worker.State.SUCCEEDED)
    @deprecated ("Use Succeeded; SUCCEEDED will be removed in a future release", "8.0.60-R10")
    val SUCCEEDED = Succeeded

    protected override def unsortedValues: Array[State] = Array(Cancelled, Failed, Ready, Running, Scheduled, Succeeded)

  }

  sealed abstract class State(override val delegate: jfxc.Worker.State)
    extends SFXEnumDelegate[jfxc.Worker.State]

}

/**
 * Wrapper trait for [[http://docs.oracle.com/javase/8/javafx/api/javafx/concurrent/Worker.html Worker]]
 * Interface.
 */
trait Worker[T] extends SFXDelegate[jfxc.Worker[T]] {

  /**
   * Gets the ReadOnlyObjectProperty representing any exception which occurred.
   */
  def exception: ReadOnlyObjectProperty[Throwable] = delegate.exceptionProperty

  /**
   * Gets the ReadOnlyStringProperty representing the message.
   */
  def message: ReadOnlyStringProperty = delegate.messageProperty

  /**
   * Gets the ReadOnlyDoubleProperty representing the progress.
   */
  def progress: ReadOnlyDoubleProperty = delegate.progressProperty

  /**
   * Gets the ReadOnlyBooleanProperty representing whether the Worker is running.
   */
  def running: ReadOnlyBooleanProperty = delegate.runningProperty

  /**
   * Gets the ReadOnlyObjectProperty representing the current state.
   */
  def state: ReadOnlyObjectProperty[jfxc.Worker.State] = delegate.stateProperty

  /**
   * Gets the ReadOnlyStringProperty representing the title.
   */
  def title: ReadOnlyStringProperty = delegate.titleProperty

  /**
   * Gets the ReadOnlyDoubleProperty representing the maximum amount of work that needs to be done.
   */
  def totalWork: ReadOnlyDoubleProperty = delegate.totalWorkProperty

  /**
   * Gets the ReadOnlyObjectProperty representing the value.
   */
  def value: ReadOnlyObjectProperty[T] = delegate.valueProperty

  /**
   * Gets the ReadOnlyDoubleProperty representing the current progress.
   */
  def workDone: ReadOnlyDoubleProperty = delegate.workDoneProperty

  /**
   * Terminates execution of this Worker.
   */
  def cancel = delegate.cancel

}
