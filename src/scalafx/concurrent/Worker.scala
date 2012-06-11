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
import scalafx.util.SFXDelegate

object Worker {
  implicit def sfxWorker2jfx[T](w: Worker[T]) = w.delegate
}

/**
 * Wrapper trait for [[http://docs.oracle.com/javafx/2/api/javafx/concurrent/Worker.html Worker]]
 * Interface.
 */
trait Worker[T] extends SFXDelegate[jfxc.Worker[T]] {

  /**
   * Gets the ReadOnlyObjectProperty representing any exception which occurred.
   */
  def exception = delegate.exceptionProperty

  /**
   * Gets the ReadOnlyStringProperty representing the message.
   */
  def message = delegate.messageProperty

  /**
   * Gets the ReadOnlyDoubleProperty representing the progress.
   */
  def progress = delegate.progressProperty

  /**
   * Gets the ReadOnlyBooleanProperty representing whether the Worker is running.
   */
  def running = delegate.runningProperty

  /**
   * Gets the ReadOnlyObjectProperty representing the current state.
   */
  def state = delegate.stateProperty

  /**
   * Gets the ReadOnlyStringProperty representing the title.
   */
  def title = delegate.titleProperty

  /**
   * Gets the ReadOnlyDoubleProperty representing the maximum amount of work that needs to be done.
   */
  def totalWork = delegate.totalWorkProperty()

  /**
   * Gets the ReadOnlyObjectProperty representing the value.
   */
  def value = delegate.getValue

  /**
   * Gets the ReadOnlyDoubleProperty representing the current progress.
   */
  def workDone = delegate.workDoneProperty

  /**
   * Terminates execution of this Worker.
   */
  def cancel = delegate.cancel

}
