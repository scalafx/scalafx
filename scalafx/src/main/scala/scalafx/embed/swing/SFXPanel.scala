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
package scalafx.embed.swing

import java.awt.Dimension
import java.awt.im.InputMethodRequests

import javafx.embed.{ swing => jfxes }
import scalafx.Includes._
import scalafx.delegate.SFXDelegate
import scalafx.scene.Scene

/**
 * Companion Object for [[scalafx.embed.swing.SFXPanel]].
 */
object SFXPanel {

  /**
   * Converts a ScalaFX JFXPanel to its JavaFX counterpart.
   *
   * @param panel SFXPanel
   * @return JavaFX JFXPanel
   */
  implicit def sfxPanel2jfx(panel: SFXPanel): jfxes.JFXPanel = panel.delegate

}

/**
 * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/embed/swing/JFXPanel.html JavaFX 
 * JFXPanel]]. To use methods and properties from JComponent, use its delegate. 
 *
 * @constructor Creates a new SFXPanel from its JavaFX counterpart.
 * @param delegate JavaFX JFXPanel. Its defaul value is a new JFXPanel
 *
 * @since 8.0
 */
class SFXPanel(override val delegate: jfxes.JFXPanel = new jfxes.JFXPanel)
  extends SFXDelegate[jfxes.JFXPanel] {

  /**
   *
   */
  def inputMethodRequests: InputMethodRequests = delegate.getInputMethodRequests

  /**
   * Returns the preferred size of this SFXPanel, either previously set with
   * `JComponent.setPreferredSize(Dimension)` or based on the content of the JavaFX scene attached
   * to this `SFXPanel`.
   */
  def preferredSize: Dimension = delegate.getPreferredSize

  /**
   * the ScalaFX scene attached to this JFXPanel.
   */
  def scene: Scene = delegate.getScene
  def scene_=(s: Scene) {
    delegate.setScene(s)
  }

  /**
   * SFXPanel's opacity is controlled by the JavaFX content which is displayed in this component,
   * so this method overrides JComponent.isOpaque() to always return a false value.
   */
  def opaque: Boolean = delegate.isOpaque
  /**
   * SFXPanel's opacity is controlled by the JavaFX content which is displayed in this component,
   * so this method overrides JComponent.setOpaque(boolean) to only accept a false value.
   */
  def opaque_=(b: Boolean) {
    delegate.setOpaque(b)
  }

  /**
   * Notifies this component that it now has a parent component.
   */
  def addNotify: Unit = delegate.addNotify

  /**
   * Notifies this component that it no longer has a parent component.
   */
  def removeNotify: Unit = delegate.removeNotify

}