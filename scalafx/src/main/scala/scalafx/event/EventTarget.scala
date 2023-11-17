/*
 * Copyright (c) 2011-2023, ScalaFX Project
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

import javafx.event as jfxe
import scalafx.Includes.*
import scalafx.delegate.SFXDelegate
import scalafx.event.subscriptions.Subscription

import scala.language.implicitConversions

object EventTarget {
  implicit def sfxEventTarget2jfx(v: EventTarget): jfxe.EventTarget = if (v != null) v.delegate else null
}

/**
 * Wraps a $JFX $URL0 $FC]].
 *
 * @define FC EventTarget
 * @define URL0 [[https://docs.oracle.com/javase/8/javafx/api/javafx/event/EventTarget.html
 * @define JFX JavaFX
 * @define ORIGINALDOC Original Documentation]].
 */
abstract class EventTarget(override val delegate: jfxe.EventTarget)
    extends SFXDelegate[jfxe.EventTarget] {

  /**
   * Construct an event dispatch chain for this target. The event dispatch
   * chain contains event dispatchers which might be interested in processing
   * of events targeted at this `EventTarget`. This event target is
   * not automatically added to the chain, so if it wants to process events,
   * it needs to add an `EventDispatcher` for itself to the chain.
   * <p>
   * In the case the event target is part of some hierarchy, the chain for it
   * is usually built from event dispatchers collected from the root of the
   * hierarchy to the event target.
   * <p>
   * The event dispatch chain is constructed by modifications to the provided
   * initial event dispatch chain. The returned chain should have the initial
   * chain at its end so the dispatchers should be prepended to the initial
   * chain.
   * <p>
   * The caller shouldn't assume that the initial chain remains unchanged nor
   * that the returned value will reference a different chain.
   *
   * @param tail the initial chain to build from
   * @return the resulting event dispatch chain for this target
   * @see $URL0#buildEventDispatchChain $ORIGINALDOC
   */
  def buildEventDispatchChain(tail: EventDispatchChain): EventDispatchChain =
    delegate.buildEventDispatchChain(tail)

  /**
   * Registers an event handler. The handler is called when the node receives an Event of the specified type during
   * the bubbling phase of event delivery.
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
   *  pane.handleEvent(MouseEvent.Any) { () => println("Some mouse event handled") }
   * }}}
   *
   * @param eventType type of events that will be handled.
   * @param handler   code handling the event, see examples above.
   * @tparam J type JavaFX delegate of the event
   * @tparam S ScalaFX type for `J` type wrapper.
   * @return Returns a subscription that can be used to cancel/remove this event handler
   */
  def handleEvent[J <: jfxe.Event, S <: Event with SFXDelegate[J]](eventType: EventType[J])(handler: HandlerMagnet[
    J,
    S
  ]): Subscription = {
    handler(eventType)
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
   *  pane.filterEvent(MouseEvent.Any) { () => println("Some mouse event handled") }
   * }}}
   *
   * @param eventType type of events that will be handled.
   * @param filter    code handling the event, see examples above.
   * @tparam J type JavaFX delegate of the event
   * @tparam S ScalaFX type for `J` type wrapper.
   */
  def filterEvent[J <: jfxe.Event, S <: Event with SFXDelegate[J]](eventType: EventType[J])(filter: FilterMagnet[J, S])
    : Subscription = {
    filter(eventType)
  }

  /**
   * Trait implementing [[http://spray.io/blog/2012-12-13-the-magnet-pattern/ Magnet Pattern]]
   * to avoid compilation error "ambiguous reference to overloaded definition"
   */
  sealed trait FilterMagnet[J <: jfxe.Event, S <: SFXDelegate[J]] {
    protected val eventFilter: jfxe.EventHandler[J]

    def apply(eventType: EventType[J]): Subscription = {
      EventTarget.this.addEventFilter(eventType.delegate, eventFilter)
      new Subscription {
        def cancel(): Unit = {
          EventTarget.this.removeEventFilter(eventType.delegate, eventFilter)
        }
      }
    }
  }

  /**
   * Companion object implementing Magnet Pattern [[http://spray.io/blog/2012-12-13-the-magnet-pattern/ Magnet Pattern]]
   * to avoid compilation error "ambiguous reference to overloaded definition"
   */
  object FilterMagnet {
    implicit def fromParen[J <: jfxe.Event, S <: Event with SFXDelegate[J]](op: () => Unit): FilterMagnet[J, S] = {
      new FilterMagnet[J, S] {
        override val eventFilter: jfxe.EventHandler[J] = new jfxe.EventHandler[J] {
          def handle(event: J): Unit = {
            op()
          }
        }
      }
    }

    implicit def fromEvent[J <: jfxe.Event, S <: Event with SFXDelegate[J]](op: S => Unit)(implicit
      jfx2sfx: J => S
    ): FilterMagnet[J, S] = {
      new FilterMagnet[J, S] {
        override val eventFilter: jfxe.EventHandler[J] = new jfxe.EventHandler[J] {
          def handle(event: J): Unit = {
            op(jfx2sfx(event))
          }
        }
      }
    }
  }

  /**
   * Trait implementing [[http://spray.io/blog/2012-12-13-the-magnet-pattern/ Magnet Pattern]]
   * to avoid compilation error "ambiguous reference to overloaded definition"
   */
  sealed trait HandlerMagnet[J <: jfxe.Event, S <: SFXDelegate[J]] {
    protected val eventHandler: jfxe.EventHandler[J]

    def apply(eventType: EventType[J]): Subscription = {
      EventTarget.this.addEventHandler(eventType.delegate, eventHandler)
      new Subscription {
        def cancel(): Unit = {
          EventTarget.this.removeEventHandler(eventType.delegate, eventHandler)
        }
      }
    }
  }

  /**
   * Companion object implementing Magnet Pattern [[http://spray.io/blog/2012-12-13-the-magnet-pattern/ Magnet Pattern]]
   * to avoid compilation error "ambiguous reference to overloaded definition"
   */
  object HandlerMagnet {
    implicit def fromParen[J <: jfxe.Event, S <: Event with SFXDelegate[J]](op: () => Unit): HandlerMagnet[J, S] = {
      new HandlerMagnet[J, S] {
        override val eventHandler: jfxe.EventHandler[J] = new jfxe.EventHandler[J] {
          def handle(event: J): Unit = {
            op()
          }
        }
      }
    }

    implicit def fromEvent[J <: jfxe.Event, S <: Event with SFXDelegate[J]](op: S => Unit)(implicit
      jfx2sfx: J => S
    ): HandlerMagnet[J, S] = {
      new HandlerMagnet[J, S] {
        override val eventHandler: jfxe.EventHandler[J] = new jfxe.EventHandler[J] {
          def handle(event: J): Unit = {
            op(jfx2sfx(event))
          }
        }
      }
    }
  }
}
