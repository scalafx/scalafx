/*
* Copyright (c) 2012, ScalaFX Project
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
import scalafx.util.SFXDelegate

object ScrollEvent {
  implicit def sfxScrollEvent2jfx(se: ScrollEvent) = se.delegate
}

class ScrollEvent(override val delegate: jfxsi.ScrollEvent) extends InputEvent(delegate) with SFXDelegate[jfxsi.ScrollEvent] {

  /**
   * Gets the horizontal scroll amount.
   */
  def deltaX = delegate.getDeltaX

  /**
   * Gets the vertical scroll amount.
   */
  def deltaY = delegate.getDeltaY

  /**
   * Gets the horizontal position of the event relative to the origin of the Scene that contains the ScrollEvent's source.
   */
  def sceneX = delegate.getSceneX

  /**
   * Gets the vertical position of the event relative to the origin of the Scene that contains the ScrollEvent's source.
   */
  def sceneY = delegate.getSceneY

  /**
   * Gets the absolute horizontal position of the event.
   */
  def screenX = delegate.getScreenX

  /**
   * Gets the absolute vertical position of the event.
   */
  def screenY = delegate.getScreenY

  /**
   * Gets the horizontal text-based scroll amount.
   */
  def textDeltaX = delegate.getTextDeltaX

  /**
   * Gets the horizontal scrolling units for text-based scrolling.
   */
  def textDeltaXUnits = delegate.getTextDeltaXUnits

  /**
   * Gets the vertical text-based scroll amount.
   */
  def textDeltaY = delegate.getTextDeltaY

  /**
   * Gets the vertical scrolling units for text-based scrolling.
   */
  def textDeltaYUnits = delegate.getTextDeltaYUnits

  /**
   * Whether or not the Alt modifier is down on this event.
   */
  def altDown = delegate.isAltDown

  /**
   * Whether or not the Control modifier is down on this event.
   */
  def controlDown = delegate.isControlDown

  /**
   * Whether or not the Meta modifier is down on this event.
   */
  def metaDown = delegate.isMetaDown

  /**
   * Whether or not the Shift modifier is down on this event.
   */
  def shiftDown = delegate.isShiftDown

  /**
   * Returns whether or not the host platform common shortcut modifier is down on this event.
   */
  def shortcutDown = delegate.isShortcutDown

  /**
   * Gets the horizontal position of the event relative to the origin of the ScrollEvent's source.
   */
  def x = delegate.getX

  /**
   * Gets the vertical position of the event relative to the origin of the ScrollEvent's source.
   */
  def y = delegate.getY

}