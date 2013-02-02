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

import javafx.{ event => jfxe }

/**
 * Companion Object for [[http://docs.oracle.com/javafx/2/api/javafx/event/EventHandler.html EventHandler]]
 * interface.
 */
object EventHandler {

  /**
   * Generates a new [[javafx.event.EventHandler]] from a simple function that neither receives
   * parameter either return value (just [[scala.Unit]]).
   */
  implicit def function2jfxEventHandler[E <: jfxe.Event, H <: jfxe.EventHandler[E]](op: => Unit) =
    new jfxe.EventHandler[E] {
      def handle(event: E) {
        op
      }
    }

  /**
   * Generates a new [[javafx.event.EventHandler]] from a simple function that neither receives
   * parameter either return value (just [[scala.Unit]]).
   */
  implicit def function2jfxEventHandlerWithParam[E <: jfxe.Event, H <: jfxe.EventHandler[E]](op: (E) => Unit) =
    new jfxe.EventHandler[E] {
      def handle(event: E) {
        op(event)
      }
    }
}

/**
 * Trait used for handle events manipulation. JavaFX class wrapped must have methods defined in
 * [[scalafx.event.EventHandlerDelegate.EventHandled]] Type:
 * {{{
 * def addEventHandler   [E <: jfxe.Event](eventType: jfxe.EventType[E], eventHandler: jfxe.EventHandler[_ >: E])
 * def removeEventHandler[E <: jfxe.Event](eventType: jfxe.EventType[E], eventHandler: jfxe.EventHandler[_ >: E])
 * def addEventFilter    [E <: jfxe.Event](eventType: jfxe.EventType[E], eventHandler: jfxe.EventHandler[_ >: E])
 * def removeEventFilter [E <: jfxe.Event](eventType: jfxe.EventType[E], eventHandler: jfxe.EventHandler[_ >: E])
 * }}}
 */
trait EventHandlerDelegate {

  /**
   *
   */
  type EventHandled = {
    // Registers an event handler to this type.
    def addEventHandler[E <: jfxe.Event](eventType: jfxe.EventType[E], eventHandler: jfxe.EventHandler[_])

    // Unregisters a previously registered event handler from this type.
    def removeEventHandler[E <: jfxe.Event](eventType: jfxe.EventType[E], eventHandler: jfxe.EventHandler[_])

    // Registers an event filter to this type.
    def addEventFilter[E <: jfxe.Event](eventType: jfxe.EventType[E], eventHandler: jfxe.EventHandler[_])

    // Unregisters a previously registered event filter from this type.
    def removeEventFilter[E <: jfxe.Event](eventType: jfxe.EventType[E], eventHandler: jfxe.EventHandler[_])
  }

  /**
   * Returns a object that implements [[scalafx.event.EventHandlerDelegate.EventHandled]].
   */
  protected def eventHandlerDelegate: EventHandled

  /**
   * Registers an event handler to this task. Any event filters are first processed, then the
   * specified onFoo event handlers, and finally any event handlers registered by this method.
   * As with other events in the scene graph, if an event is consumed, it will not continue
   * dispatching.
   *
   * @tparam E Event class
   * @param eventType  the type of the events to receive by the handler
   * @param eventHandler the handler to register that will manipulate event
   */
  def addEventHandler[E <: jfxe.Event](eventType: jfxe.EventType[E], eventHandler: jfxe.EventHandler[_ >: E]) =
    eventHandlerDelegate.addEventHandler(eventType, eventHandler)

  /**
   * Register an event handler to this task that will manipulate the
   * [[http://docs.oracle.com/javafx/2/api/javafx/event/Event.html Event]] associated to a
   * [[http://docs.oracle.com/javafx/2/api/javafx/event/EventType.html EventType]].
   *
   * @tparam E Event class
   * @param eventType  the type of the events to receive by the handler
   * @param op the handler to register that will manipulate event
   */
  def handleEvent[E <: jfxe.Event](eventType: jfxe.EventType[E])(op: E => Unit) {
    this.addEventHandler(eventType, new jfxe.EventHandler[E] {
      def handle(event: E) = op(event)
    })
  }

  /**
   * Register an event handler to this task that will ''not'' manipulate the
   * [[http://docs.oracle.com/javafx/2/api/javafx/event/Event.html Event]] associated to a
   * [[http://docs.oracle.com/javafx/2/api/javafx/event/EventType.html EventType]].
   *
   * @tparam E Event class
   * @param eventType  the type of the events to receive by the handler
   * @param op the handler to register that will ''not'' manipulate event
   */
  def handleEvent[E <: jfxe.Event](eventType: jfxe.EventType[E])(op: => Unit) {
    this.addEventHandler(eventType, new jfxe.EventHandler[E] {
      def handle(event: E) = op
    })
  }

  /**
   * Unregisters a previously registered event handler from this task. One handler might have been
   * registered for different event types, so the caller needs to specify the particular event type
   * from which to unregister the handler.
   *
   * @tparam E Event class
   * @param eventType  the event type from which to unregister
   * @param eventHandler  the handler to unregister
   */
  def removeEventHandler[E <: jfxe.Event](eventType: jfxe.EventType[E], eventHandler: jfxe.EventHandler[_ >: E]) =
    eventHandlerDelegate.addEventHandler(eventType, eventHandler)

  /**
   * Registers an event filter to this task. Registered event filters get an event before any
   * associated event handlers.
   *
   * @tparam E Event class
   * @param eventType  the type of the events to receive by the filter
   * @param eventFilter the filter to register that will filter event
   */
  def addEventFilter[E <: jfxe.Event](eventType: jfxe.EventType[E], eventFilter: jfxe.EventHandler[_ >: E]) =
    eventHandlerDelegate.addEventFilter(eventType, eventFilter)

  /**
   * Registers an event filter to this task that will filter the
   * [[http://docs.oracle.com/javafx/2/api/javafx/event/Event.html Event]] associated to a
   * [[http://docs.oracle.com/javafx/2/api/javafx/event/EventType.html EventType]].
   *
   * @tparam E Event class
   * @param eventType  the type of the events to receive by the filter
   * @param op the filter to register that will filter event
   */
  def filterEvent[E <: jfxe.Event](eventType: jfxe.EventType[E])(op: E => Unit) {
    this.addEventFilter(eventType, new jfxe.EventHandler[E] {
      def handle(event: E) = op(event)
    })
  }

  /**
   * Registers an event filter to this task that will ''not'' filter the
   * [[http://docs.oracle.com/javafx/2/api/javafx/event/Event.html Event]] associated to a
   * [[http://docs.oracle.com/javafx/2/api/javafx/event/EventType.html EventType]].
   *
   * @tparam E Event class
   * @param eventType  the type of the events to receive by the filter
   * @param op the filter to register that will ''not'' filter event
   */
  def filterEvent[E <: jfxe.Event](eventType: jfxe.EventType[E])(op: => Unit) {
    this.addEventFilter(eventType, new jfxe.EventHandler[E] {
      def handle(event: E) = op
    })
  }

  /**
   * Unregisters a previously registered event filter from this task. One filter might have been
   * registered for different event types, so the caller needs to specify the particular event
   * type from which to unregister the filter.
   *
   * @tparam E Event class
   * @param eventType the event type from which to unregister
   * @param eventFilter the filter to unregister
   */
  def removeEventFilter[E <: jfxe.Event](eventType: jfxe.EventType[E], eventHandler: jfxe.EventHandler[_ >: E]) =
    eventHandlerDelegate.addEventFilter(eventType, eventHandler)

}