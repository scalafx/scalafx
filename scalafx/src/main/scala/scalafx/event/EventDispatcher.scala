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

package scalafx.event

import javafx.{event => jfxe}

import scala.language.implicitConversions
import scalafx.Includes._
import scalafx.delegate.SFXDelegate

object EventDispatcher {
  implicit def sfxEventDispatcher2jfx(v: EventDispatcher): jfxe.EventDispatcher =
    if (v != null) v.delegate else null
}

/**
 * An represents an event dispatching and processing entity. It is used when an needs to be dispatched to the associated
 * `EventTarget` through the `EventDispatchChain` specified by the target. Each in the chain can influence the event
 * path and the event itself. One can appear in multiple chains.
 *
 * Wraps a $JFX $URL0 $FC]].
 *
 * @define
 *   FC EventDispatcher
 * @define
 *   URL0
 *   [[https://docs.oracle.com/javase/8/javafx/api/javafx/event/EventDispatcher.html@define JFX JavaFX @define ORIGINALDOC Original Documentation]].
 */
abstract class EventDispatcher(override val delegate: jfxe.EventDispatcher) extends SFXDelegate[jfxe.EventDispatcher] {

  /**
   * Dispatches the specified event by this . Does any required event processing. Both the event and its further path
   * can be modified in this method. If the event is not handled / consumed during the capturing phase, it should be
   * dispatched to the rest of the chain ().
   *
   * @param event
   *   the event do dispatch
   * @param tail
   *   the rest of the chain to dispatch event to
   * @return
   *   the return event or if the event has been handled / consumed
   * @see
   *   $URL0#dispatchEvent $ORIGINALDOC
   */
  def dispatchEvent(event: Event, tail: EventDispatchChain): Event =
    delegate.dispatchEvent(event.delegate, tail.delegate)
}
