/*
 * Copyright (c) 2011-2024, ScalaFX Project
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

package scalafx.scene.control

import javafx.scene.{control => jfxsc}
import javafx.{event => jfxe}

import scala.language.implicitConversions
import scalafx.delegate.SFXDelegate
import scalafx.event.Event

/**
 * Object Companion for [[scalafx.scene.control.SortEvent]]
 *
 * @since 8.0
 */
object SortEvent {

  /**
   * Converts a ScalaFX SortEvent to its JavaFX couterpart.
   *
   * @param se ScalaFX SortEvent
   * @tparam C SortEvent Type
   * @return JavaFX SortEvent
   */
  implicit def sfxSortEvent2jfx[C](se: SortEvent[C]): jfxsc.SortEvent[C] = if (se != null) se.delegate else null

  /**
   * Common supertype for all sort event types.
   */
  val Any: jfxe.EventType[jfxsc.SortEvent[_]] = jfxsc.SortEvent.ANY

  def sortEvent[C]: jfxe.EventType[jfxsc.SortEvent[C]] = jfxsc.SortEvent.sortEvent()

}

/**
 * Wraps a $JFX [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/SortEvent.html SortEvent]].
 *
 * @constructor Creates a new ScalaFX SortEvent from a JavaFX one.
 * @param delegate JavaFX SortEvent to be wrapped.
 * @tparam C Event Type
 * @since 8.0
 *
 * @define JFX JavaFX
 */
class SortEvent[C](override val delegate: jfxsc.SortEvent[C])
    extends Event(delegate)
    with SFXDelegate[jfxsc.SortEvent[C]] {

  /**
   * Constructor with source and target
   *
   * @param source Event Source
   * @param target Event Target
   * @see [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/SortEvent.html#SortEvent-C-javafx.event.EventTarget- Original Documentation]].
   */
  def this(source: C, target: jfxe.EventTarget) = this(new jfxsc.SortEvent[C](source, target))

}
