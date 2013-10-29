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

import javafx.{ event => jfxe }
import scalafx.Includes._
import scalafx.delegate.SFXDelegate

object EventIncludes extends EventIncludes

/**
 * Contains implicit methods to convert from
 * [[http://docs.oracle.com/javafx/2/api/javafx/event/package-summary.html `javafx.event`]]
 * Classes to their ScalaFX counterparts.
 */
trait EventIncludes {

  /**
   * Converts a
   * [[http://docs.oracle.com/javafx/2/api/javafx/event/ActionEvent `javafx.event.ActionEvent`]]
   * instance to its ScalaFX counterpart.
   *
   * @param ae JavaFX ActionEvent
   * @return ScalaFX ActionEvent
   */
  implicit def jfxActionEvent2sfx(ae: jfxe.ActionEvent) = new ActionEvent(ae)

  /**
   * Converts a
   * [[http://docs.oracle.com/javafx/2/api/javafx/event/Event `javafx.event.Event`]]
   * instance to its ScalaFX counterpart.
   *
   * @param e JavaFX Event
   * @return ScalaFX Event
   */
  implicit def jfxEvent2sfx(e: jfxe.Event) = new Event(e)

  /**
   * Converts a
   * [[http://docs.oracle.com/javafx/2/api/javafx/event/EventType `javafx.event.EventType`]]
   * instance to its ScalaFX counterpart.
   *
   * @tparam T Event Type
   * @param e JavaFX EventType
   * @return ScalaFX EventType
   */
  implicit def jfxEventType2sfx[T <: jfxe.Event](e: jfxe.EventType[T]) = new EventType[T](e)

  /**
   * Converts a closure to a JavaFX EventHandler. It is used when the event properties ''will not be used''.
   *
   * @tparam T JavaFX Event subclass.
   * @param handler Closure that ''will not'' handle event.
   * @return JavaFX EventHandler which handle method will call handler
   */
  implicit def eventClosureWrapper[T <: jfxe.Event, R](handler: => R) = new jfxe.EventHandler[T] {
    def handle(event: T) {
      handler
    }
  }

  /**
   * Converts a closure to a JavaFX EventHandler. It is used when the event properties ''will not be used''.
   *
   * @tparam T JavaFX Event subclass.
   * @param handler Closure that ''will not'' handle event.
   * @return JavaFX EventHandler which handle method will call handler
   */
  implicit def eventClosureWrapperWithUnitParam[T <: jfxe.Event, R](handler: Unit => R) = new jfxe.EventHandler[T] {
    def handle(event: T) {
      handler()
    }
  }

  /**
   * Converts a closure to a JavaFX EventHandler. It is used when the event properties ''will be used''.
   *
   * @tparam J JavaFX Event subclass.
   * @param handler Closure that ''will'' handle event.
   * @return JavaFX EventHandler which handle method will call handler
   */
  implicit def eventClosureWrapperWithParam[J <: jfxe.Event, S <: SFXDelegate[J], R](handler: (S) => R)(implicit jfx2sfx: J => S) =
    new jfxe.EventHandler[J] {
    def handle(event: J) {
      handler(event)
    }
  }
}
