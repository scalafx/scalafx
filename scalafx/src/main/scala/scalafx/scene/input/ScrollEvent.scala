/*
 * Copyright (c) 2011-2018, ScalaFX Project
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
package scalafx.scene.input

import javafx.scene.{input => jfxsi}
import scalafx.Includes._
import scalafx.delegate.{SFXDelegate, SFXEnumDelegate, SFXEnumDelegateCompanion}
import scalafx.event.EventType

import scala.language.implicitConversions

object ScrollEvent {
  implicit def sfxScrollEvent2jfx(se: ScrollEvent): jfxsi.ScrollEvent = if (se != null) se.delegate else null

  object HorizontalTextScrollUnits
    extends SFXEnumDelegateCompanion[jfxsi.ScrollEvent.HorizontalTextScrollUnits, HorizontalTextScrollUnits] {

    /**
     * The horizontal text-based scrolling amount is a number of characters to scroll.
     */
    case object Characters extends HorizontalTextScrollUnits(jfxsi.ScrollEvent.HorizontalTextScrollUnits.CHARACTERS)
    @deprecated ("Use Characters; CHARACTERS will be removed in a future release", "8.0.60-R10")
    val CHARACTERS = Characters

    /**
     * The horizontal text-based scrolling data is not available (not provided by the underlying platform).
     */
    case object None extends HorizontalTextScrollUnits(jfxsi.ScrollEvent.HorizontalTextScrollUnits.NONE)
    @deprecated ("Use None; NONE will be removed in a future release", "8.0.60-R10")
    val NONE = None

    protected override def unsortedValues: Array[HorizontalTextScrollUnits] = Array(None, Characters)

  }

  /**
   * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/input/ScrollEvent.HorizontalTextScrollUnits.html]]
   */
  sealed abstract class HorizontalTextScrollUnits(override val delegate: jfxsi.ScrollEvent.HorizontalTextScrollUnits)
    extends SFXEnumDelegate[jfxsi.ScrollEvent.HorizontalTextScrollUnits]

  object VerticalTextScrollUnits
    extends SFXEnumDelegateCompanion[jfxsi.ScrollEvent.VerticalTextScrollUnits, VerticalTextScrollUnits] {

    /**
     * The vertical text-based scrolling amount is a number of lines to scroll.
     */
    case object Lines extends VerticalTextScrollUnits(jfxsi.ScrollEvent.VerticalTextScrollUnits.LINES)
    @deprecated ("Use Lines; LINES will be removed in a future release", "8.0.60-R10")
    val LINES = Lines

    /**
     * The vertical text-based scrolling amount is a number of pages to scroll.
     */
    case object Pages extends VerticalTextScrollUnits(jfxsi.ScrollEvent.VerticalTextScrollUnits.PAGES)
    @deprecated ("Use Pages; PAGES will be removed in a future release", "8.0.60-R10")
    val PAGES = Pages

    /**
     * The vertical text-based scrolling data is not available (not provided by the underlying platform).
     */
    case object None extends VerticalTextScrollUnits(jfxsi.ScrollEvent.VerticalTextScrollUnits.NONE)
    @deprecated ("Use None; NONE will be removed in a future release", "8.0.60-R10")
    val NONE = None

    protected override def unsortedValues: Array[VerticalTextScrollUnits] = Array(None, Lines, Pages)

  }

  /**
   * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/input/ScrollEvent.VerticalTextScrollUnits.html]]
   */
  sealed abstract class VerticalTextScrollUnits(override val delegate: jfxsi.ScrollEvent.VerticalTextScrollUnits)
    extends SFXEnumDelegate[jfxsi.ScrollEvent.VerticalTextScrollUnits]

  /**
   * Common supertype for all scroll event types.
   */
  val Any: EventType[jfxsi.ScrollEvent] = jfxsi.ScrollEvent.ANY
  @deprecated ("Use Any; ANY will be removed in a future release", "8.0.60-R10")
  val ANY = Any

  /**
   * This event occurs when user performs a scrolling action such as rotating mouse wheel or dragging a finger over
   * touch screen.
   */
  val Scroll: EventType[jfxsi.ScrollEvent] = jfxsi.ScrollEvent.SCROLL
  @deprecated ("Use Scroll; SCROLL will be removed in a future release", "8.0.60-R10")
  val SCROLL = Scroll

  /**
   * This event occurs when a scrolling gesture ends.
   */
  val ScrollFinished: EventType[jfxsi.ScrollEvent] = jfxsi.ScrollEvent.SCROLL_FINISHED
  @deprecated ("Use ScrollFinished; SCROLL_FINISHED will be removed in a future release", "8.0.60-R10")
  val SCROLL_FINISHED = ScrollFinished

  /**
   * This event occurs when a scrolling gesture is detected.
   */
  val ScrollStarted: EventType[jfxsi.ScrollEvent] = jfxsi.ScrollEvent.SCROLL_STARTED
  @deprecated ("Use ScrollStarted; SCROLL_STARTED will be removed in a future release", "8.0.60-R10")
  val SCROLL_STARTED = ScrollStarted

}

/**
 * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/input/ScrollEvent.html]]
 */
class ScrollEvent(override val delegate: jfxsi.ScrollEvent)
  extends GestureEvent(delegate)
  with SFXDelegate[jfxsi.ScrollEvent] {

  /**
   * Gets the horizontal scroll amount.
   */
  def deltaX: Double = delegate.getDeltaX

  /**
   * Gets the vertical scroll amount.
   */
  def deltaY: Double = delegate.getDeltaY

  /**
   * Gets the horizontal text-based scroll amount.
   */
  def textDeltaX: Double = delegate.getTextDeltaX

  /**
   * Gets the horizontal scrolling units for text-based scrolling.
   */
  def textDeltaXUnits: ScrollEvent.HorizontalTextScrollUnits =
    ScrollEvent.HorizontalTextScrollUnits.jfxEnum2sfx(delegate.getTextDeltaXUnits)

  /**
   * Gets the vertical text-based scroll amount.
   */
  def textDeltaY: Double = delegate.getTextDeltaY

  /**
   * Gets the vertical scrolling units for text-based scrolling.
   */
  def textDeltaYUnits: ScrollEvent.VerticalTextScrollUnits =
    ScrollEvent.VerticalTextScrollUnits.jfxEnum2sfx(delegate.getTextDeltaYUnits)

}
