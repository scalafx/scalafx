/*
 * Copyright (c) 2011, ScalaFX Project
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

import javafx.{stage => jfxs}
import scalafx.Includes._
import scalafx.beans.property.BooleanProperty
import scalafx.beans.property.ReadOnlyBooleanProperty
import scalafx.beans.property.StringProperty
import scalafx.scene.Scene
import scalafx.stage.Window.sfxWindow2jfx
import scalafx.util.SFXDelegate
import scalafx.application.JFXApp

object Stage {
  implicit def sfxStage2jfx(v: Stage) = v.delegate
}

class Stage(private val d: jfxs.Stage = JFXApp.STAGE)
  extends Window(d)
  with SFXDelegate[jfxs.Stage] {

  /**
   * Creates a new instance of Stage.
   */
  def this(style: jfxs.StageStyle) = this(new jfxs.Stage(style))

  override val delegate: jfxs.Stage = d

  /**
   * Specifies whether this Stage should be a full-screen, undecorated window.
   */
  def fullScreen: ReadOnlyBooleanProperty = delegate.fullScreenProperty
  def fullScreen_=(value: Boolean) {
    delegate.setFullScreen(value)
  }

  /**
   * Defines the title of the Stage.
   */
  def title: StringProperty = delegate.titleProperty
  def title_=(v: String) {
    title() = v
  }

  /**
   * Gets the icon images to be used in the window decorations and when minimized.
   */
  def icons = delegate.getIcons

  /**
   * Defines whether the Stage is iconified or not.
   */
  def iconified: ReadOnlyBooleanProperty = delegate.iconifiedProperty

  /**
   * Defines whether the Stage is resizable or not by the user.
   */
  def resizable: BooleanProperty = delegate.resizableProperty
  def resizable_=(v: Boolean) {
    resizable() = v
  }

  /**
   * Specify the scene to be used on this stage.
   */
  def scene_=(s: Scene) {
    delegate.setScene(s.delegate)
  }

  /**
   * Defines the minimum width of this Stage.
   */
  def minWidth = delegate.getMinWidth
  def minWidth_=(w: Double) {
    delegate.setMinWidth(w)
  }

  /**
   * Defines the minimum height of this Stage.
   */
  def minHeight = delegate.getMinHeight
  def minHeight_=(h: Double) {
    delegate.setMinHeight(h)
  }

  /**
   * Defines the maximum width of this Stage.
   */
  def maxWidth = delegate.getMaxWidth
  def maxWidth_=(w: Double) {
    delegate.setMaxWidth(w)
  }

  /**
   * Defines the maximum height of this Stage.
   */
  def maxHeight = delegate.getMaxHeight
  def maxHeight_=(h: Double) {
    delegate.setMaxHeight(h)
  }

  /**
   * Attempts to show or hide this Window.
   */
  def showing_=(v: Boolean) {
    v match {
      case true  => delegate.show()
      case false => delegate.hide()
    }
  }

  /**
   * Retrieves the style attribute for this stage.
   */
  def style = delegate.getStyle

  /**
   * Closes this Stage.
   */
  def close {
    delegate.close
  }

  /**
   * Retrieves the modality attribute for this stage.
   */
  def modality = delegate.getModality

  /**
   * Retrieves a [[scala.Some]] with the owner Window for this stage, or
   * [[Scala.None]] for an unowned stage.
   */
  def owner: Option[Window] = Option(delegate.getOwner)

  /**
   * Specifies the modality for this stage.
   */
  def initModality(modality: jfxs.Modality) {
    delegate.initModality(modality)
  }

  /**
   * Specifies the owner Window for this stage, or null for a top-level,
   * unowned stage.
   */
  def initOwner(owner: Window) {
    delegate.initOwner(owner)
  }

  /**
   * Specifies the style for this stage.
   */
  def initStyle(style: jfxs.StageStyle) {
    delegate.initStyle(style)
  }

  /**
   * Send the Window to the background.
   */
  def toBack {
    delegate.toBack
  }

  /**
   * Bring the Window to the foreground.
   */
  def toFront {
    delegate.toFront
  }

}
