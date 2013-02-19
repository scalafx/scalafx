/*
 * Copyright (c) 2011-2013, ScalaFX Project
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
import scalafx.Includes._

object EventIncludes extends EventIncludes

trait EventIncludes {
	implicit def jfxActionEvent2sfx(ae: jfxe.ActionEvent) = new ActionEvent(ae)

	implicit def jfxEvent2sfx(e: jfxe.Event) = new Event(e)

	implicit def jfxEventType2sfx[T <: jfxe.Event](e: jfxe.EventType[T]) = new EventType[T](e)

	implicit def eventClosureWrapper[T <: jfxe.Event](handler: => Any) = new jfxe.EventHandler[T] {
		def handle(event: T) {
			handler
		}
	}

	implicit def eventClosureWrapperWithUnitParam[T <: jfxe.Event](handler: Unit => Any) = new jfxe.EventHandler[T] {
		def handle(event: T) {
			handler()
		}
	}

  implicit def eventClosureWrapperWithParam[J <: jfxe.Event](handler: (Event) => Any) = new jfxe.EventHandler[J] {
 		def handle(event: J) {
 			handler(event)
 		}
 	}

	/**
	 * Converts a Function that manipulates a [[scalafx.event.ActionEvent]] 
	 * and returns a [[scala.Any]] into a 
	 * [[http://docs.oracle.com/javafx/2/api/javafx/event/EventHandler.html JavaFX`s EventHandler]] 
	 * that manipulates a 
	 * [[http://docs.oracle.com/javafx/2/api/javafx/event/ActionEvent.html JavaFX`s ActionEvent]]
	 * 
	 * @param handler function that manipulates a ScalaFX's ActionEvent
	 * @return a JavaFX's EventHandler that manipulates a JavaFX's ActionEvent
	 */
	implicit def actionEventClosureWrapper(handler: (ActionEvent) => Any) = new jfxe.EventHandler[jfxe.ActionEvent] {
		def handle(event: jfxe.ActionEvent) {
			handler(event)
		}
	}

	/**
	 * Converts a Function that manipulates a [[scalafx.stage.WindowEvent]] 
	 * and returns a [[scala.Any]] into a 
	 * [[http://docs.oracle.com/javafx/2/api/javafx/event/EventHandler.html JavaFX`s EventHandler]] 
	 * that manipulates a 
	 * [[http://docs.oracle.com/javafx/2/api/javafx/stage/WindowEvent.html JavaFX`s WindowEvent]]
	 * 
	 * @param handler function that manipulates a ScalaFX's WindowEvent
	 * @return a JavaFX's EventHandler that manipulates a JavaFX's WindowEvent
	 */
	implicit def windowEventClosureWrapper(handler: (scalafx.stage.WindowEvent) => Any) = new jfxe.EventHandler[javafx.stage.WindowEvent] {
		def handle(event: javafx.stage.WindowEvent) {
			handler(event)
		}
	}

	/**
	 * Converts a Function that manipulates a [[scalafx.concurrent.WorkerStateEvent]] 
	 * and returns a [[scala.Any]] into a 
	 * [[http://docs.oracle.com/javafx/2/api/javafx/event/EventHandler.html JavaFX`s EventHandler]] 
	 * that manipulates a 
	 * [[http://docs.oracle.com/javafx/2/api/javafx/concurrent/WorkerStateEvent.html JavaFX`s WorkerStateEvent]]
	 * 
	 * @param handler function that manipulates a ScalaFX's WorkerStateEvent
	 * @return a JavaFX's EventHandler that manipulates a JavaFX's WorkerStateEvent
	 */
	implicit def workerStateEventClosureWrapper(handler: (scalafx.concurrent.WorkerStateEvent) => Any) = new jfxe.EventHandler[javafx.concurrent.WorkerStateEvent] {
		def handle(event: javafx.concurrent.WorkerStateEvent) {
			handler(event)
		}
	}
}
