/*
 * Copyright (c) 2011-2025, ScalaFX Project
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
import scalafx.delegate.SFXDelegate

import scala.language.implicitConversions

object EventIncludes extends EventIncludes

/**
 * Contains implicit methods to convert from
 * [[http://docs.oracle.com/javase/8/javafx/api/javafx/event/package-summary.html `javafx.event`]]
 * Classes to their ScalaFX counterparts.
 */
trait EventIncludes {

  /**
   * Converts a
   * [[http://docs.oracle.com/javase/8/javafx/api/javafx/event/ActionEvent `javafx.event.ActionEvent`]]
   * instance to its ScalaFX counterpart.
   *
   * @param ae JavaFX ActionEvent
   * @return ScalaFX ActionEvent
   */
  implicit def jfxActionEvent2sfx(ae: jfxe.ActionEvent): ActionEvent = if (ae != null) new ActionEvent(ae) else null

  /**
   * Converts a
   * [[http://docs.oracle.com/javase/8/javafx/api/javafx/event/Event `javafx.event.Event`]]
   * instance to its ScalaFX counterpart.
   *
   * @param e JavaFX Event
   * @return ScalaFX Event
   */
  implicit def jfxEvent2sfx(e: jfxe.Event): Event = if (e != null) new Event(e) else null

  implicit def jfxEventDispatcher2sfx(e: jfxe.EventDispatcher): EventDispatcher =
    if (e != null) new EventDispatcher(e) {} else null

  implicit def jfxEventDispatchChain2sfx(e: jfxe.EventDispatchChain): EventDispatchChain =
    if (e != null) new EventDispatchChain(e) {} else null

  implicit def jfxEventTarget2sfx(e: jfxe.EventTarget): EventTarget =
    if (e != null) new EventTarget(e) {} else null

  /**
   * Converts a
   * [[http://docs.oracle.com/javase/8/javafx/api/javafx/event/EventType `javafx.event.EventType`]]
   * instance to its ScalaFX counterpart.
   *
   * @tparam T Event Type
   * @param e JavaFX EventType
   * @return ScalaFX EventType
   */
  implicit def jfxEventType2sfx[T <: jfxe.Event](e: jfxe.EventType[T]): EventType[T] =
    if (e != null) new EventType[T](e) else null

  /**
   * Converts a
   * [[http://docs.oracle.com/javase/8/javafx/api/javafx/event/WeakEventHandler `javafx.event.WeakEventHandler`]]
   * instance to its ScalaFX counterpart.
   *
   * @tparam T Event Type
   * @param weh JavaFX WeakEventHandler
   * @return ScalaFX WeakEventHandler
   * @since 8.0
   */
  implicit def jfxWeakEventHandler2sfx[T <: jfxe.Event](weh: jfxe.WeakEventHandler[T]): WeakEventHandler[T] =
    if (weh != null) new WeakEventHandler(weh) else null

  /**
   * NOTE: use of `handle` is deprecated in Scala 2.12 and newer, you can use standard Scala syntax:
   *
   * {{{
   * button.onAction = _ => {
   *   println("Handling button action")
   *   doSomething()
   * }
   * }}}
   *
   * For Scala 2.11 and older, you can use `handle` to create a simple event handler when information about event is not be used.
   *
   * Enables following use:
   * {{{
   * button.onAction = handle {
   *   println("Handling button action")
   *   doSomething()
   * }
   * }}}
   *
   * @tparam J JavaFX Event subclass.
   * @param handler code executed when event is handled.
   * @return JavaFX EventHandler which will wrap the input code `handler`.
   */
  @deprecated("Starting with Scala 2.12 `handle{...}` can be replaced with idiomatic Scala code `_ => {...}`", "R19")
  def handle[J <: jfxe.Event, R](handler: => R): jfxe.EventHandler[J] = new jfxe.EventHandler[J] {
    def handle(event: J): Unit = {
      handler
    }
  }

  /**
   * Converts a closure to a JavaFX EventHandler. It is used when information about event is not be used.
   *
   * Enables following use:
   * {{{
   *  button.onAction = () => {
   *    println("Handling button action")
   *    doSomething()
   * }
   * }}}
   *
   * @tparam T JavaFX Event subclass.
   * @param handler Closure that ''will not'' handle event.
   * @return JavaFX EventHandler which handle method will call handler
   */
  implicit def eventClosureWrapperWithZeroParam[T <: jfxe.Event, R](handler: () => R): jfxe.EventHandler[T] =
    new jfxe.EventHandler[T] {
      def handle(event: T): Unit = {
        handler()
      }
    }

  /**
   * Converts a closure to a JavaFX EventHandler. It is used when the event properties ''will be used''.
   *
   * Enables the following use:
   * {{{
   * button.onAction = (e:ActionEvent) => {
   *   println("Handling button action: " + e)
   *   doSomething(e)
   * }
   * }}}
   *
   * @tparam J JavaFX Event subclass.
   * @param handler Closure that that takes scalafx.event.Event as argument.
   * @return JavaFX EventHandler which handle method will call handler
   */
  implicit def eventClosureWrapperWithParam[J <: jfxe.Event, S <: SFXDelegate[J], R](handler: (S) => R)(
    implicit jfx2sfx: J => S
  ): jfxe.EventHandler[J] = {
    new jfxe.EventHandler[J] {
      def handle(event: J): Unit = {
        handler(jfx2sfx(event))
      }
    }
  }

}
