/*
 * Copyright (c) 2011-2015, ScalaFX Project
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
package scalafx.stage

import javafx.{event => jfxe, stage => jfxs}

import scala.language.implicitConversions
import scalafx.Includes._
import scalafx.beans.property._
import scalafx.delegate.{SFXDelegate, SFXEnumDelegate, SFXEnumDelegateCompanion}
import scalafx.scene.Node
import scalafx.scene.Node._
import scalafx.stage.Window._

object PopupWindow {
  implicit def sfxPopupWindow2jfx(v: PopupWindow): jfxs.PopupWindow = if (v != null) v.delegate else null

  /** Anchor location constants for popup anchor point selection.
    * Wraps [[http://download.java.net/jdk8/jfxdocs/javafx/stage/PopupWindow.AnchorLocation.html AnchorLocation]]
    */
  object AnchorLocation
    extends SFXEnumDelegateCompanion[jfxs.PopupWindow.AnchorLocation, AnchorLocation] {

    /** Represents bottom left content corner. */
    val CONTENT_BOTTOM_LEFT = new AnchorLocation(jfxs.PopupWindow.AnchorLocation.CONTENT_BOTTOM_LEFT)

    /** Represents bottom right content corner. */
    val CONTENT_BOTTOM_RIGHT = new AnchorLocation(jfxs.PopupWindow.AnchorLocation.CONTENT_BOTTOM_RIGHT)

    /** Represents top left content corner. */
    val CONTENT_TOP_LEFT = new AnchorLocation(jfxs.PopupWindow.AnchorLocation.CONTENT_TOP_LEFT)

    /** Represents top right content corner. */
    val CONTENT_TOP_RIGHT = new AnchorLocation(jfxs.PopupWindow.AnchorLocation.CONTENT_TOP_RIGHT)

    /** Represents bottom left window corner. */
    val WINDOW_BOTTOM_LEFT = new AnchorLocation(jfxs.PopupWindow.AnchorLocation.WINDOW_BOTTOM_LEFT)

    /** Represents bottom right window corner. */
    val WINDOW_BOTTOM_RIGHT = new AnchorLocation(jfxs.PopupWindow.AnchorLocation.WINDOW_BOTTOM_RIGHT)

    /** Represents top left window corner. */
    val WINDOW_TOP_LEFT = new AnchorLocation(jfxs.PopupWindow.AnchorLocation.WINDOW_TOP_LEFT)

    /** Represents top right window corner. */
    val WINDOW_TOP_RIGHT = new AnchorLocation(jfxs.PopupWindow.AnchorLocation.WINDOW_TOP_RIGHT)

    protected override def unsortedValues: Array[AnchorLocation] = Array(CONTENT_BOTTOM_LEFT, CONTENT_BOTTOM_RIGHT,
      CONTENT_TOP_LEFT, CONTENT_TOP_RIGHT, WINDOW_BOTTOM_LEFT, WINDOW_BOTTOM_RIGHT, WINDOW_TOP_LEFT, WINDOW_TOP_RIGHT)
  }

  /** Anchor location constants for popup anchor point selection.
    * Wraps [[http://download.java.net/jdk8/jfxdocs/javafx/stage/PopupWindow.AnchorLocation.html AnchorLocation]]
    */
  sealed case class AnchorLocation(override val delegate: jfxs.PopupWindow.AnchorLocation)
    extends SFXEnumDelegate[jfxs.PopupWindow.AnchorLocation]

}

abstract class PopupWindow(override val delegate: jfxs.PopupWindow)
  extends Window(delegate)
  with SFXDelegate[jfxs.PopupWindow] {

  /** Specifies the popup anchor point which is used in popup positioning. */
  def anchorLocation: ObjectProperty[jfxs.PopupWindow.AnchorLocation] = delegate.anchorLocationProperty
  def anchorLocation_=(v: PopupWindow.AnchorLocation) {
    ObjectProperty.fillProperty[jfxs.PopupWindow.AnchorLocation](this.anchorLocation, v)
  }

  /** Specifies the x coordinate of the popup anchor point on the screen. */
  def anchorX: ReadOnlyDoubleProperty = delegate.anchorXProperty

  /** Specifies the y coordinate of the popup anchor point on the screen. */
  def anchorY: ReadOnlyDoubleProperty = delegate.anchorYProperty

  /**
   * This convenience variable indicates whether, when the popup is shown, it should automatically correct its position
   * such that it doesn't end up positioned off the screen.
   */
  def autoFix: BooleanProperty = delegate.autoFixProperty
  def autoFix_=(v: Boolean) {
    autoFix() = v
  }

  /**
   * Specifies whether Popups should auto hide.
   */
  def autoHide: BooleanProperty = delegate.autoHideProperty
  def autoHide_=(v: Boolean) {
    autoHide() = v
  }

  /**
   * Specifies whether the PopupWindow should be hidden when an unhandled escape key is pressed while the popup has
   * focus.
   */
  def hideOnEscape: BooleanProperty = delegate.hideOnEscapeProperty
  def hideOnEscape_=(v: Boolean) {
    hideOnEscape() = v
  }

  /**
   * Called after autoHide is run.
   */
  def onAutoHide = delegate.onAutoHideProperty
  def onAutoHide_=(v: jfxe.EventHandler[jfxe.Event]) {
    onAutoHide() = v
  }

  /**
   * The window which is the parent of this popup.
   *
   */
  def ownerWindow: ReadOnlyObjectProperty[jfxs.Window] = delegate.ownerWindowProperty

  /**
   * The node which is the owner of this popup.
   */
  def ownerNode: ReadOnlyObjectProperty[javafx.scene.Node] = delegate.ownerNodeProperty

  /**
   * Show the Popup at the specified x,y location relative to the screen
   */
  def show(owner: Node, screenX: Double, screenY: Double) {
    delegate.show(owner, screenX, screenY)
  }

  /**
   * Show the popup.
   */
  def show(owner: Window) {
    delegate.show(owner)
  }

  /**
   * Show the Popup at the specified x,y location relative to the screen
   */
  def show(owner: Window, screenX: Double, screenY: Double) {
    delegate.show(owner, screenX, screenY)
  }

  /**
   * Specifies whether the event, which caused the Popup to hide, should be consumed.
   * @since 2.2
   */
  def consumeAutoHidingEvents: BooleanProperty = delegate.consumeAutoHidingEventsProperty
  def consumeAutoHidingEvents_=(v: Boolean) {
    consumeAutoHidingEvents() = v
  }

}
