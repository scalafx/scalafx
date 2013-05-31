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
package scalafx.scene.input

import javafx.scene.{ input => jfxsi }
import scalafx.delegate.SFXDelegate
import scalafx.delegate.{ SFXEnumDelegateCompanion, SFXEnumDelegate }

object ScrollEvent {
  implicit def sfxScrollEvent2jfx(se: ScrollEvent) = se.delegate

  object HorizontalTextScrollUnits
    extends SFXEnumDelegateCompanion[jfxsi.ScrollEvent.HorizontalTextScrollUnits, HorizontalTextScrollUnits] {

    /**
     * The horizontal text-based scrolling amount is a number of characters to scroll.
     */
    val CHARACTERS = new HorizontalTextScrollUnits(jfxsi.ScrollEvent.HorizontalTextScrollUnits.CHARACTERS)

    /**
     * The horizontal text-based scrolling data is not available (not provided by the underlying platform).
     */
    val NONE = new HorizontalTextScrollUnits(jfxsi.ScrollEvent.HorizontalTextScrollUnits.NONE)

    protected override def unsortedValues: Array[HorizontalTextScrollUnits] = Array(NONE, CHARACTERS)

  }

  /**
   * Wraps [[http://docs.oracle.com/javafx/2/api/javafx/scene/input/ScrollEvent.HorizontalTextScrollUnits.html]]
   */
  sealed case class HorizontalTextScrollUnits(override val delegate: jfxsi.ScrollEvent.HorizontalTextScrollUnits)
    extends SFXEnumDelegate[jfxsi.ScrollEvent.HorizontalTextScrollUnits]

  object VerticalTextScrollUnits
    extends SFXEnumDelegateCompanion[jfxsi.ScrollEvent.VerticalTextScrollUnits, VerticalTextScrollUnits] {

    /**
     * The vertical text-based scrolling amount is a number of lines to scroll.
     */
    val LINES = new VerticalTextScrollUnits(jfxsi.ScrollEvent.VerticalTextScrollUnits.LINES)

    /**
     * The vertical text-based scrolling amount is a number of pages to scroll.
     */
    val PAGES = new VerticalTextScrollUnits(jfxsi.ScrollEvent.VerticalTextScrollUnits.PAGES)

    /**
     * The vertical text-based scrolling data is not available (not provided by the underlying platform).
     */
    val NONE = new VerticalTextScrollUnits(jfxsi.ScrollEvent.VerticalTextScrollUnits.NONE)

    protected override def unsortedValues: Array[VerticalTextScrollUnits] = Array(NONE, LINES, PAGES)

  }

  /**
   * Wraps [[http://docs.oracle.com/javafx/2/api/javafx/scene/input/ScrollEvent.VerticalTextScrollUnits.html]]
   */
  sealed case class VerticalTextScrollUnits(override val delegate: jfxsi.ScrollEvent.VerticalTextScrollUnits)
    extends SFXEnumDelegate[jfxsi.ScrollEvent.VerticalTextScrollUnits]

  /**
   * Common supertype for all scroll event types.
   */
  val ANY = jfxsi.ScrollEvent.ANY

  /**
   * This event occurs when user performs a scrolling action such as rotating mouse wheel or dragging a finger over
   * touch screen.
   */
  val SCROLL = jfxsi.ScrollEvent.SCROLL

  /**
   * This event occurs when a scrolling gesture ends.
   */
  val SCROLL_FINISHED = jfxsi.ScrollEvent.SCROLL_FINISHED

  /**
   * This event occurs when a scrolling gesture is detected.
   */
  val SCROLL_STARTED = jfxsi.ScrollEvent.SCROLL_STARTED

}

/**
 * Wraps [[http://docs.oracle.com/javafx/2/api/javafx/scene/input/ScrollEvent.html]]
 */
class ScrollEvent(override val delegate: jfxsi.ScrollEvent)
  extends GestureEvent(delegate)
  with SFXDelegate[jfxsi.ScrollEvent] {

  /**
   * Gets the horizontal scroll amount.
   */
  def deltaX = delegate.getDeltaX

  /**
   * Gets the vertical scroll amount.
   */
  def deltaY = delegate.getDeltaY

  /**
   * Gets the horizontal text-based scroll amount.
   */
  def textDeltaX = delegate.getTextDeltaX

  /**
   * Gets the horizontal scrolling units for text-based scrolling.
   */
  def textDeltaXUnits: ScrollEvent.HorizontalTextScrollUnits = 
    ScrollEvent.HorizontalTextScrollUnits.jfxEnum2sfx(delegate.getTextDeltaXUnits)

  /**
   * Gets the vertical text-based scroll amount.
   */
  def textDeltaY = delegate.getTextDeltaY

  /**
   * Gets the vertical scrolling units for text-based scrolling.
   */
  def textDeltaYUnits: ScrollEvent.VerticalTextScrollUnits = 
    ScrollEvent.VerticalTextScrollUnits.jfxEnum2sfx(delegate.getTextDeltaYUnits)

}