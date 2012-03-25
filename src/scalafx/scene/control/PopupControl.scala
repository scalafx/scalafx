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
import scalafx.Includes._
import scalafx.stage.PopupWindow
import scalafx.util.SFXDelegate

object PopupControl {
  implicit def sfxPopupControl2jfx(v: PopupControl) = v.delegate
}

class PopupControl(override val delegate: jfxsc.PopupControl = new jfxsc.PopupControl) extends PopupWindow(delegate) with SFXDelegate[jfxsc.PopupControl] {

  /**
   * The id of this Node.
   */
  def id = delegate.idProperty
  def id_=(v: String) {
    id = v
  }

  /**
   * Property for overriding the control's computed maximum height.
   */
  def maxHeight = delegate.maxHeightProperty
  def maxHeight_=(v: Double) {
    maxHeight = v
  }

  /**
   * Property for overriding the control's computed maximum width.
   */
  def maxWidth = delegate.maxWidthProperty
  def maxWidth_=(v: Double) {
    maxWidth = v
  }

  /**
   * Property for overriding the control's computed minimum height.
   */
  def minHeight = delegate.minHeightProperty
  def minHeight_=(v: Double) {
    minHeight = v
  }

  /**
   * Property for overriding the control's computed minimum width.
   */
  def minWidth = delegate.minWidthProperty
  def minWidth_=(v: Double) {
    minWidth = v
  }

  /**
   * Property for overriding the control's computed preferred height.
   *
   */
  def prefHeight = delegate.prefHeightProperty
  def prefHeight_=(v: Double) {
    prefHeight = v
  }

  /**
   * Property for overriding the control's computed preferred width.
   */
  def prefWidth = delegate.prefWidthProperty
  def prefWidth_=(v: Double) {
    prefWidth = v
  }

  /**
   * Skin is responsible for rendering this PopupControl.
   */
  def skin = delegate.skinProperty
  def skin_=(v: jfxsc.Skin[_]) {
    skin = v
  }

  /**
   * A string representation of the CSS style associated with this specific Node.
   */
  def style = delegate.styleProperty
  def style_=(v: String) {
    style = v
  }
  
  def styleClass = delegate.getStyleClass

}