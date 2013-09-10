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
import scalafx.delegate.SFXDelegate
import scalafx.event.subscriptions.Subscription

/**
 * Companion Object for [[http://docs.oracle.com/javafx/2/api/javafx/event/EventHandler.html EventHandler]]
 * interface.
 */
object EventHandler {
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

    // Construct an event dispatch chain for this target.
    def buildEventDispatchChain(chain: jfxe.EventDispatchChain): jfxe.EventDispatchChain
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
  def addEventHandler[E <: jfxe.Event](eventType: jfxe.EventType[E], eventHandler: jfxe.EventHandler[_ >: E]) {
    eventHandlerDelegate.addEventHandler(eventType, eventHandler)
  }


  /**
   * Trait implementing [[http://spray.io/blog/2012-12-13-the-magnet-pattern/ Magnet Pattern]]
   * to avoid compilation error "ambiguous reference to overloaded definition"
   */
  sealed trait HandlerMagnet[J <: jfxe.Event, S <: SFXDelegate[J]] {
    protected val eventHandler: jfxe.EventHandler[J]

    def apply(eventType: EventType[J]): Subscription = {
      EventHandlerDelegate.this.addEventHandler(eventType.delegate, eventHandler)
      new Subscription {
        def cancel() {
          EventHandlerDelegate.this.removeEventHandler(eventType.delegate, eventHandler)
        }
      }
    }
  }

  /**
   * Companion object implementing Magnet Pattern [[http://spray.io/blog/2012-12-13-the-magnet-pattern/ Magnet Pattern]]
   * to avoid compilation error "ambiguous reference to overloaded definition"
   */
  object HandlerMagnet {
    implicit def fromUnit[J <: jfxe.Event, S <: Event with SFXDelegate[J]](op: => Unit) = {
      new HandlerMagnet[J, S] {
        override val eventHandler = new jfxe.EventHandler[J] {
          def handle(event: J) {
            op
          }
        }
      }
    }
    implicit def fromEvent[J <: jfxe.Event, S <: Event with SFXDelegate[J]](op: S => Unit)(implicit jfx2sfx: J => S) = {
      new HandlerMagnet[J, S] {
        override val eventHandler = new jfxe.EventHandler[J] {
          def handle(event: J) {
            op(jfx2sfx(event))
          }
        }
      }
    }
  }

  /**
   * Registers an event handler. The handler is called when the node receives an Event of the specified type during the bubbling phase of event delivery.
   *
   * Example of handling mouse events
   * {{{
   *  pane.handleEvent(MouseEvent.Any) {
   *    me: MouseEvent => {
   *      me.eventType match {
   *        case MouseEvent.MousePressed => ...
   *        case MouseEvent.MouseDragged => ...
   *        case _                       => {}
   *      }
   *    }
   *  }
   * }}}
   * or
   * {{{
   *  pane.handleEvent(MouseEvent.Any) { println("Some mouse event handled") }
   * }}}
   * NOTE: be careful with the code block, as in the second example above, they are not functions.
   * Due to the way Scala treats code blocks, only the last statement is invoked by the handler.
   * Statements before the last are treated as a "constructor" and executed only once, when handler is created.
   * To avoid issue use the first form above {{{me: MouseEvent => ...}}}.
   * If using code blocks, use only a single statement, for instance call to a function or a method.
   *
   * @param eventType type of events that will be handled.
   * @param handler code handling the event, see examples above.
   * @tparam J type JavaFX delegate of the event
   * @tparam S ScalaFX type for `J` type wrapper.
   * @return Returns a subscription that can be used to cancel/remove this event handler
   */
  def handleEvent[J <: jfxe.Event, S <: Event with SFXDelegate[J]](eventType: EventType[J])(handler: HandlerMagnet[J, S]): Subscription = {
    handler(eventType)
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
  def removeEventHandler[E <: jfxe.Event](eventType: jfxe.EventType[E], eventHandler: jfxe.EventHandler[_ >: E]) {
    eventHandlerDelegate.removeEventHandler(eventType, eventHandler)
  }

  /**
   * Registers an event filter to this task. Registered event filters get an event before any
   * associated event handlers.
   *
   * @tparam E Event class
   * @param eventType  the type of the events to receive by the filter
   * @param eventFilter the filter to register that will filter event
   */
  def addEventFilter[E <: jfxe.Event](eventType: jfxe.EventType[E], eventFilter: jfxe.EventHandler[_ >: E]) {
    eventHandlerDelegate.addEventFilter(eventType, eventFilter)
  }

  /**
   * Trait implementing [[http://spray.io/blog/2012-12-13-the-magnet-pattern/ Magnet Pattern]]
   * to avoid compilation error "ambiguous reference to overloaded definition"
   */
  sealed trait FilterMagnet[J <: jfxe.Event, S <: SFXDelegate[J]] {
    def apply(eventType: EventType[J])
  }

  /**
   * Companion object implementing Magnet Pattern [[http://spray.io/blog/2012-12-13-the-magnet-pattern/ Magnet Pattern]]
   * to avoid compilation error "ambiguous reference to overloaded definition"
   */
  object FilterMagnet {
    implicit def fromUnit[J <: jfxe.Event, S <: Event with SFXDelegate[J]](op: => Unit) = {
      new FilterMagnet[J, S] {
        def apply(eventType: EventType[J]) {
          EventHandlerDelegate.this.addEventFilter(
            eventType.delegate,
            new jfxe.EventHandler[J] {
              def handle(event: J) {
                op
              }
            }
          )
        }
      }
    }
    implicit def fromEvent[J <: jfxe.Event, S <: Event with SFXDelegate[J]](op: S => Unit)(implicit jfx2sfx: J => S) = {
      new FilterMagnet[J, S] {
        def apply(eventType: EventType[J]) {
          EventHandlerDelegate.this.addEventFilter(
            eventType.delegate,
            new jfxe.EventHandler[J] {
              def handle(event: J) {
                op(jfx2sfx(event))
              }
            }
          )
        }
      }
    }
  }

  /**
   * Registers an event filter. Registered event filters get an event before any associated event handlers.
   *
   * Example of filtering mouse events
   * {{{
   *  pane.filterEvent(MouseEvent.Any) {
   *    me: MouseEvent => {
   *      me.eventType match {
   *        case MouseEvent.MousePressed => {
   *          ...
   *        }
   *        case MouseEvent.MouseDragged => {
   *          ...
   *        }
   *        case _ => {
   *          ...
   *        }
   *      }
   *    }
   *  }
   * }}}
   * or
   * {{{
   *  pane.filterEvent(MouseEvent.Any) { println("Some mouse event handled") }
   * }}}
   * NOTE: be careful with the code block, as in the second example above, they are not functions.
   * Due to the way Scala treats code blocks, only the last statement is invoked by the handler.
   * Statements before the last are treated as a "constructor" and executed only once, when handler is created.
   * To avoid issue use the first form in with explicit event the example above {{{me: MouseEvent => ...}}}.
   * If using code blocks, use only a single statement, for instance call to a function or a method.
   *
   * @param eventType type of events that will be handled.
   * @param filter code handling the event, see examples above.
   * @tparam J type JavaFX delegate of the event
   * @tparam S ScalaFX type for `J` type wrapper.
   */
  def filterEvent[J <: jfxe.Event, S <: Event with SFXDelegate[J]](eventType: EventType[J])(filter: FilterMagnet[J, S]) {
    filter(eventType)
  }

  /**
   * Unregisters a previously registered event filter from this task. One filter might have been
   * registered for different event types, so the caller needs to specify the particular event
   * type from which to unregister the filter.
   *
   * @tparam E Event class
   * @param eventType the event type from which to unregister
   * @param eventHandler the filter to unregister
   */
  def removeEventFilter[E <: jfxe.Event](eventType: jfxe.EventType[E], eventHandler: jfxe.EventHandler[_ >: E]) {
    eventHandlerDelegate.removeEventFilter(eventType, eventHandler)
  }

  /**
   * Construct an event dispatch chain for this target.
   */
  def buildEventDispatchChain(chain: jfxe.EventDispatchChain) = eventHandlerDelegate.buildEventDispatchChain(chain)

}
