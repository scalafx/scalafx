/*
 * Copyright (c) 2011, ScalaFX Project
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

import javafx.scene.{input => jfxsi}
import javafx.{event => jfxe}
import scalafx.Includes._
import scalafx.scene.{input => sfxsi}

object EventIncludes extends EventIncludes

trait EventIncludes {
	implicit def jfxActionEvent2sfx(ae: jfxe.ActionEvent) = new ActionEvent(ae)

	implicit def jfxEvent2sfx(e: jfxe.Event) = new Event(e)

	implicit def jfxEventType2sfx[T <: jfxe.Event](e: jfxe.EventType[T]) = new EventType[T](e)

	implicit def eventClosureWrapper[T <: jfxe.Event](handler: => Unit) = new jfxe.EventHandler[T] {
		def handle(event: T) {
			handler
		}
	}

	implicit def eventClosureWrapperWithUnitParam[T <: jfxe.Event](handler: Unit => Unit) = new jfxe.EventHandler[T] {
		def handle(event: T) {
			handler()
		}
	}

	implicit def eventClosureWrapperWithParam[T <: jfxe.Event](handler: (T) => Unit) = new jfxe.EventHandler[T] {
		def handle(event: T) {
			handler(event)
		}
	}

  /**
 	 * Converts a Function that manipulates a [[scalafx.scene.input.DragEvent]]
 	 * and returns a [[scala.Unit]] in a
 	 * [[http://docs.oracle.com/javafx/2/api/javafx/event/EventHandler.html JavaFX`s EventHandler]]
 	 * that manipulates a
 	 * [[http://docs.oracle.com/javafx/2/api/javafx/scene/input/DragEvent.html JavaFX`s DragEvent]]
 	 *
 	 * @param handler function that manipulates a ScalaFX's DragEvent
 	 * @return a JavaFX's EventHandler that manipulates a JavaFX's DragEvent
 	 */
 	implicit def dragEventClosureWrapper(handler: (sfxsi.DragEvent) => Unit) = new jfxe.EventHandler[jfxsi.DragEvent] {
 		def handle(event: jfxsi.DragEvent) {
 			handler(event)
 		}
 	}


	/**
	 * Converts a Function that manipulates a [[scalafx.scene.input.MouseEvent]] 
	 * and returns a [[scala.Unit]] in a 
	 * [[http://docs.oracle.com/javafx/2/api/javafx/event/EventHandler.html JavaFX`s EventHandler]] 
	 * that manipulates a 
	 * [[http://docs.oracle.com/javafx/2/api/javafx/scene/input/MouseEvent.html JavaFX`s MouseEvent]]
	 * 
	 * @param handler function that manipulates a ScalaFX's MouseEvent
	 * @return a JavaFX's EventHandler that manipulates a JavaFX's MouseEvent
	 */
	implicit def mouseEventClosureWrapper(handler: (sfxsi.MouseEvent) => Unit) = new jfxe.EventHandler[jfxsi.MouseEvent] {
		def handle(event: jfxsi.MouseEvent) {
			handler(event)
		}
	}

	/**
	 * Converts a Function that manipulates a [[scalafx.scene.input.KeyEvent]] 
	 * and returns a [[scala.Unit]] in a 
	 * [[http://docs.oracle.com/javafx/2/api/javafx/event/EventHandler.html JavaFX`s EventHandler]] 
	 * that manipulates a 
	 * [[http://docs.oracle.com/javafx/2/api/javafx/scene/input/KeyEvent.html JavaFX`s KeyEvent]]
	 * 
	 * @param handler function that manipulates a ScalaFX's KeyEvent
	 * @return a JavaFX's EventHandler that manipulates a JavaFX's KeyEvent
	 */
	implicit def keyEventClosureWrapper(handler: (sfxsi.KeyEvent) => Unit) = new jfxe.EventHandler[jfxsi.KeyEvent] {
		def handle(event: jfxsi.KeyEvent) {
			handler(event)
		}
	}

	/**
	 * Converts a Function that manipulates a [[scalafx.scene.input.ScrollEvent]] 
	 * and returns a [[scala.Unit]] in a 
	 * [[http://docs.oracle.com/javafx/2/api/javafx/event/EventHandler.html JavaFX`s EventHandler]] 
	 * that manipulates a 
	 * [[http://docs.oracle.com/javafx/2/api/javafx/scene/input/ScrollEvent.html JavaFX`s ScrollEvent]]
	 * 
	 * @param handler function that manipulates a ScalaFX's ScrollEvent
	 * @return a JavaFX's EventHandler that manipulates a JavaFX's ScrollEvent
	 */
	implicit def scrollEventClosureWrapper(handler: (sfxsi.ScrollEvent) => Unit) = new jfxe.EventHandler[jfxsi.ScrollEvent] {
		def handle(event: jfxsi.ScrollEvent) {
			handler(event)
		}
	}

	/**
	 * Converts a Function that manipulates a [[scalafx.event.ActionEvent]] 
	 * and returns a [[scala.Unit]] in a 
	 * [[http://docs.oracle.com/javafx/2/api/javafx/event/EventHandler.html JavaFX`s EventHandler]] 
	 * that manipulates a 
	 * [[http://docs.oracle.com/javafx/2/api/javafx/event/ActionEvent.html JavaFX`s ActionEvent]]
	 * 
	 * @param handler function that manipulates a ScalaFX's ActionEvent
	 * @return a JavaFX's EventHandler that manipulates a JavaFX's ActionEvent
	 */
	implicit def actionEventClosureWrapper(handler: (ActionEvent) => Unit) = new jfxe.EventHandler[jfxe.ActionEvent] {
		def handle(event: jfxe.ActionEvent) {
			handler(event)
		}
	}
}
