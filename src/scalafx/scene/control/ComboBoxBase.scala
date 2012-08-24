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

package scalafx.scene.control

import javafx.scene.{ control => jfxsc }
import javafx.{ event => jfxe }
import scalafx.Includes._
import scalafx.util.SFXDelegate

object ComboBoxBase {
  implicit def sfxComboBoxBase2jfx[T](cb: ComboBoxBase[T]) = cb.delegate
}

abstract class ComboBoxBase[T](override val delegate: jfxsc.ComboBoxBase[T]) extends Control(delegate) with SFXDelegate[jfxsc.ComboBoxBase[T]] {

  /**
   * Arms the ComboBox.
   */
  def arm = delegate.arm

  /**
   * Indicates that the ComboBox has been "armed" such that a mouse release will cause the ComboBox show() method to be invoked.
   */
  def armed = delegate.armedProperty
  def armed_=(v: Boolean) {
    armed() = v
  }

  /**
   * Disarms the ComboBox.
   */
  def disarm = delegate.disarm

  /**
   * Specifies whether the ComboBox allows for user input.
   */
  def editable = delegate.editableProperty
  def editable_=(v: Boolean) {
    editable() = v
  }

  /**
   * Closes the popup / dialog that was shown when show() was called.
   */
  def hide = delegate.hide

  /**
   * The ComboBox action, which is invoked whenever the ComboBox value property is changed.
   */
  def onAction = delegate.onActionProperty
  def onAction_=(v: jfxe.EventHandler[jfxe.ActionEvent]) {
    onAction() = v
  }

  /**
   * The ComboBox prompt text to display, or null if no prompt text is displayed.
   */
  def promptText = delegate.promptTextProperty
  def promptText_=(v: String) {
    promptText() = v
  }

  /**
   * Requests that the ComboBox display the popup aspect of the user interface.
   */
  def show = delegate.show

  /**
   * Represents the current state of the ComboBox popup, and whether it is currently visible on screen (although it may be hidden behind other windows).
   */
  def showing = delegate.showingProperty

  /**
   * The value of this ComboBox is defined as the selected item if the input is not editable, or if it is editable, the most recent user action: either the value input by the user, or the last selected item.
   */
  def value = delegate.valueProperty
  def value_=(v: T) {
    delegate.setValue(v)
  }

  /**
   * Sets the Hidden event handler for this ComboBoxBase type UI object
   * @since 2.2
   */
  def onHidden = delegate.onHiddenProperty()
  def onHidden_( eventHandler:jfxe.EventHandler[jfxe.Event] ) = {
    onHidden() = eventHandler
  }

  /**
   * Sets the Hiding event handler for this ComboBoxBase type UI object
   * @since 2.2
   */
  def onHiding = delegate.onHidingProperty()
  def onHiding_( eventHandler:jfxe.EventHandler[jfxe.Event] ) = {
    onHiding() = eventHandler
  }

  /**
   * Sets the Showing event handler for this ComboBoxBase type UI object
   * @since 2.2
   */
  def onShowing = delegate.onShowingProperty()
  def onShowing_( eventHandler:jfxe.EventHandler[jfxe.Event] ) = {
    onShowing() = eventHandler
  }

  /**
   * Sets the Shown event handler for this ComboBoxBase type UI object
   * @since 2.2
   */
  def onShown = delegate.onShownProperty()
  def onShown_( eventHandler:jfxe.EventHandler[jfxe.Event] ) = {
    onShown() = eventHandler
  }

}
