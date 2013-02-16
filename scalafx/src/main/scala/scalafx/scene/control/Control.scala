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
package scalafx.scene.control

import javafx.scene.{ control => jfxsc }

import scalafx.Includes._
import scalafx.scene.Node
import scalafx.beans.property.DoubleProperty
import scalafx.delegate.SFXDelegate

object Control {
  implicit def sfxControl2jfx(v: Control) = v.delegate

  /**
   * Sentinel value which can be passed to a control's setMinWidth(), setMinHeight(),
   * setPrefWidth(), setPrefHeight(), setMaxWidth(), setMaxHeight() methods to reset the
   * control's size constraint back to it's intrinsic size returned by computeMinWidth(),
   * computeMinHeight(), computePrefWidth(), computePrefHeight(), computeMaxWidth(), or
   * computeMaxHeight().
   */
  val USE_COMPUTED_SIZE = jfxsc.Control.USE_COMPUTED_SIZE

  /**
   * Sentinel value which can be passed to a control's setMinWidth(), setMinHeight(),
   * setMaxWidth() or setMaxHeight() methods to indicate that the preferred dimension
   * should be used for that max and/or min constraint.
   */
  val USE_PREF_SIZE = jfxsc.Control.USE_PREF_SIZE
}

abstract class Control(override val delegate: jfxsc.Control)
  extends Node(delegate)
  with Skinnable
  with SFXDelegate[jfxsc.Control] {

  /**
   * The ContextMenu to show for this control.
   */
  def contextMenu = delegate.contextMenuProperty
  def contextMenu_=(v: jfxsc.ContextMenu) {
    contextMenu() = v
  }

  /**
   * The height of this control.
   */
  def height = delegate.heightProperty

  /**
   * Property for overriding the control's computed maximum height.
   */
  def maxHeight: DoubleProperty = delegate.maxHeightProperty
  def maxHeight_=(v: Double) {
    maxHeight() = v
  }

  /**
   * Property for overriding the control's computed maximum width.
   */
  def maxWidth: DoubleProperty = delegate.maxWidthProperty
  def maxWidth_=(v: Double) {
    maxWidth() = v
  }

  /**
   * Property for overriding the control's computed minimum height.
   */
  def minHeight: DoubleProperty = delegate.minHeightProperty
  def minHeight_=(v: Double) {
    minHeight() = v
  }

  /**
   * Property for overriding the control's computed minimum width.
   */
  def minWidth: DoubleProperty = delegate.minWidthProperty
  def minWidth_=(v: Double) {
    minWidth() = v
  }

  /**
   * Property for overriding the control's computed preferred height.
   */
  def prefHeight: DoubleProperty = delegate.prefHeightProperty
  def prefHeight_=(v: Double) {
    prefHeight() = v
  }

  /**
   * Property for overriding the control's computed preferred width.
   */
  def prefWidth: DoubleProperty = delegate.prefWidthProperty
  def prefWidth_=(v: Double) {
    prefWidth() = v
  }

  /**
   * The ToolTip for this control.
   */
  def tooltip = delegate.tooltipProperty
  def tooltip_=(v: Tooltip) {
    tooltip() = v
  }

  /**
   * The width of this control.
   */
  def width = delegate.widthProperty

}
