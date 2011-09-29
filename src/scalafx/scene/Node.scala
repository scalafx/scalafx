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

package scalafx.scene

import scalafx.Includes._
import javafx.{scene => jfxs}
import javafx.{event => jfxe}
import jfxs.{input => jfxsi, effect => jfxse}
import scalafx.util.SFXDelegate

object Node {
  implicit def sfxNode2jfx(v: Node) = v.delegate
}

abstract class Node extends SFXDelegate[jfxs.Node] {
  def blendMode = delegate.blendModeProperty
  def blendMode_=(v: jfxse.BlendMode) {
    blendMode() = v
  }

  def boundsInLocal = delegate.boundsInLocalProperty

  def boundsInParent = delegate.boundsInParentProperty

  def cacheHint = delegate.cacheHintProperty
  def cacheHint_=(v: jfxs.CacheHint) {
    cacheHint() = v
  }

  def cache = delegate.cacheProperty
  def cache_=(v: Boolean) {
    cache() = v
  }

  def clip = delegate.clipProperty
  def clip_=(v: jfxs.Node) {
    clip() = v
  }

  def cursor = delegate.cursorProperty
  def cursor_=(v: jfxs.Cursor) {
    cursor() = v
  }

  def depthTest = delegate.depthTestProperty
  def depthTest_=(v: jfxs.DepthTest) {
    depthTest() = v
  }

  def disabled = delegate.disabledProperty

  def disable = delegate.disableProperty
  def disable_=(v: Boolean) {
    disable() = v
  }

  def effect = delegate.effectProperty
  def effect_=(v: jfxse.Effect) {
    effect() = v
  }

  def rotate = delegate.rotateProperty
  def rotate_=(v: Double) {
    rotate() = v
  }

  def onDragDetected = delegate.onDragDetectedProperty
  def onDragDetected_=(v: jfxe.EventHandler[_ >: jfxsi.MouseEvent]) {
    onDragDetected() = v
  }

  def onDragDone = delegate.onDragDoneProperty
  def onDragDone_=(v: jfxe.EventHandler[_ >: jfxsi.DragEvent]) {
    onDragDone() = v
  }

  def onDragDropped = delegate.onDragDroppedProperty
  def onDragDropped_=(v: jfxe.EventHandler[_ >: jfxsi.DragEvent]) {
    onDragDropped() = v
  }

  def onDragEntered = delegate.onDragEnteredProperty
  def onDragEntered_=(v: jfxe.EventHandler[_ >: jfxsi.DragEvent]) {
    onDragEntered() = v
  }

  def onDragExited = delegate.onDragExitedProperty
  def onDragExited_=(v: jfxe.EventHandler[_ >: jfxsi.DragEvent]) {
    onDragExited() = v
  }

  def onDragOver = delegate.onDragOverProperty
  def onDragOver_=(v: jfxe.EventHandler[_ >: jfxsi.DragEvent]) {
    onDragOver() = v
  }

  def onInputMethodTextChanged = delegate.onInputMethodTextChangedProperty
  def onInputMethodTextChanged_=(v: jfxe.EventHandler[_ >: jfxsi.InputMethodEvent]) {
    onInputMethodTextChanged() = v
  }

  def onKeyPressed = delegate.onKeyPressedProperty
  def onKeyPressed_=(v: jfxe.EventHandler[_ >: jfxsi.KeyEvent]) {
    onKeyPressed() = v
  }

  def onKeyReleased = delegate.onKeyReleasedProperty
  def onKeyReleased_=(v: jfxe.EventHandler[_ >: jfxsi.KeyEvent]) {
    onKeyReleased() = v
  }

  def onKeyTyped = delegate.onKeyTypedProperty
  def onKeyTyped_=(v: jfxe.EventHandler[_ >: jfxsi.KeyEvent]) {
    onKeyTyped() = v
  }

  def onMouseClicked = delegate.onMouseClickedProperty
  def onMouseClicked_=(v: jfxe.EventHandler[_ >: jfxsi.MouseEvent]) {
    onMouseClicked() = v
  }

  def onMouseDragged = delegate.onMouseDraggedProperty
  def onMouseDragged_=(v: jfxe.EventHandler[_ >: jfxsi.MouseEvent]) {
    onMouseDragged() = v
  }

  def onMouseEntered = delegate.onMouseEnteredProperty
  def onMouseEntered_=(v: jfxe.EventHandler[_ >: jfxsi.MouseEvent]) {
    onMouseEntered() = v
  }

  def onMouseExited = delegate.onMouseExitedProperty
  def onMouseExited_=(v: jfxe.EventHandler[_ >: jfxsi.MouseEvent]) {
    onMouseExited() = v
  }

  def onMouseMoved = delegate.onMouseMovedProperty
  def onMouseMoved_=(v: jfxe.EventHandler[_ >: jfxsi.MouseEvent]) {
    onMouseMoved() = v
  }

  def onMousePressed = delegate.onMousePressedProperty
  def onMousePressed_=(v: jfxe.EventHandler[_ >: jfxsi.MouseEvent]) {
    onMousePressed() = v
  }

  def onMouseReleased = delegate.onMouseReleasedProperty
  def onMouseReleased_=(v: jfxe.EventHandler[_ >: jfxsi.MouseEvent]) {
    onMouseReleased() = v
  }

  def mouseTransparent = delegate.mouseTransparentProperty
  def mouseTransparent_=(v: Boolean) {
    mouseTransparent() = v
  }

  def hover = delegate.hoverProperty
}
