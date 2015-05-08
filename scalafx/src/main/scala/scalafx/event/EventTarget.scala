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
}