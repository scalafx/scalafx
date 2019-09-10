/*
 * Copyright (c) 2011-2019, ScalaFX Project
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

import javafx.scene.{input => jfxsi}
import javafx.{stage => jfxs}
import scalafx.Includes._
import scalafx.beans.property.{BooleanProperty, ObjectProperty, ReadOnlyBooleanProperty, StringProperty}
import scalafx.delegate.SFXDelegate
import scalafx.scene.Scene
import scalafx.scene.input.KeyCombination
import scalafx.stage.Window.sfxWindow2jfx

import scala.language.implicitConversions

object Stage {
  implicit def sfxStage2jfx(v: Stage): jfxs.Stage = if (v != null) v.delegate else null
}

/**
 * The primary stage for your application has to be created by wrapping the `JFXApp.STAGE` object.
 * <pre>
 * stage = new JFXApp.PrimaryStage {
 * // your definitions
 * }
 * </pre>
 * Any further stage would be simply instantiated by the no-arg constructor.
 */
class Stage(override val delegate: jfxs.Stage = new jfxs.Stage)
  extends Window(delegate)
  with SFXDelegate[jfxs.Stage] {

  /**
   * Creates a new instance of Stage.
   */
  def this(style: jfxs.StageStyle) = this(new jfxs.Stage(style))

  /**
   * Defines whether this `Stage` is kept on top of other windows.
   *
   * If some other window is already always-on-top then the relative order between these windows
   * is unspecified (depends on platform).
   *
   * There are differences in behavior between applications if a security manager is present.
   * Applications with permissions are allowed to set "always on top" flag on a Stage.
   * In applications without the proper permissions, an attempt to set the flag will be ignored and the property
   * value will be restored to "false".
   *
   * The property is read only because it can be changed externally by the underlying platform and therefore must not be bindable.
   */
  def alwaysOnTop: ReadOnlyBooleanProperty = delegate.alwaysOnTopProperty

  def alwaysOnTop_=(value: Boolean): Unit = {
    delegate.setAlwaysOnTop(value)
  }

  def fullScreenExitHint: ObjectProperty[String] = delegate.fullScreenExitHintProperty

  def fullScreenExitHint_=(value: String): Unit = {
    fullScreenExitHint() = value
  }

  /**
   * Specifies the Full Screen exit key combination
   */
  def fullScreenExitKey: ObjectProperty[jfxsi.KeyCombination] = delegate.fullScreenExitKeyProperty

  def fullScreenExitKey_=(value: KeyCombination): Unit = {
    fullScreenExitKey() = value
  }

  /**
   * Specifies whether this Stage should be a full-screen, undecorated window.
   */
  def fullScreen: ReadOnlyBooleanProperty = delegate.fullScreenProperty

  def fullScreen_=(value: Boolean): Unit = {
    delegate.setFullScreen(value)
  }

  /** Defines whether the Stage is maximized or not. */
  def maximized: ReadOnlyBooleanProperty = delegate.maximizedProperty

  def maximized_=(value: Boolean): Unit = {
    delegate.setMaximized(value)
  }

  /**
   * Defines the title of the Stage.
   */
  def title: StringProperty = delegate.titleProperty

  def title_=(v: String): Unit = {
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

  def resizable_=(v: Boolean): Unit = {
    resizable() = v
  }

  /**
   * Specify the scene to be used on this stage.
   */
  def scene_=(s: Scene): Unit = {
    delegate.setScene(s.delegate)
  }

  /**
   * Defines the minimum width of this Stage.
   */
  def minWidth: Double = delegate.getMinWidth

  def minWidth_=(w: Double): Unit = {
    delegate.setMinWidth(w)
  }

  /**
   * Defines the minimum height of this Stage.
   */
  def minHeight: Double = delegate.getMinHeight

  def minHeight_=(h: Double): Unit = {
    delegate.setMinHeight(h)
  }

  /**
   * Defines the maximum width of this Stage.
   */
  def maxWidth: Double = delegate.getMaxWidth

  def maxWidth_=(w: Double): Unit = {
    delegate.setMaxWidth(w)
  }

  /**
   * Defines the maximum height of this Stage.
   */
  def maxHeight: Double = delegate.getMaxHeight

  def maxHeight_=(h: Double): Unit = {
    delegate.setMaxHeight(h)
  }

  /**
   * Attempts to show or hide this Window.
   */
  def showing_=(v: Boolean): Unit = {
    v match {
      case true  => delegate.show()
      case false => delegate.hide()
    }
  }

  /**
   * Retrieves the style attribute for this stage.
   */
  def style: StageStyle = delegate.getStyle

  /**
   * Closes this Stage.
   */
  def close(): Unit = {
    delegate.close()
  }

  /**
   * Retrieves the modality attribute for this stage.
   */
  def modality: Modality = delegate.getModality

  /**
   * Retrieves a [[scala.Some]] with the owner Window for this stage, or
   * [[scala.None]] for an unowned stage.
   */
  def owner: Option[Window] = Option(delegate.getOwner)

  /**
   * Specifies the modality for this stage.
   */
  def initModality(modality: Modality): Unit = {
    delegate.initModality(modality)
  }

  /**
   * Specifies the owner Window for this stage, or null for a top-level,
   * unowned stage.
   */
  def initOwner(owner: Window): Unit = {
    delegate.initOwner(owner)
  }

  /**
   * Specifies the style for this stage.
   */
  def initStyle(style: StageStyle): Unit = {
    delegate.initStyle(style)
  }

  /**
   * Attempts to show this Window by setting visibility to true.
   */
  def show(): Unit = {
    delegate.show()
  }

  /**
   * Shows this stage and waits for it to be hidden (closed) before returning to the caller.
   * This method temporarily blocks processing of the current event, and starts a nested event loop to handle other events.
   * This method must be called on the FX Application thread.
   */
  def showAndWait(): Unit = {
    delegate.showAndWait()
  }

  /**
   * Send the Window to the background.
   */
  def toBack(): Unit = {
    delegate.toBack()
  }

  /**
   * Bring the Window to the foreground.
   */
  def toFront(): Unit = {
    delegate.toFront()
  }

}
