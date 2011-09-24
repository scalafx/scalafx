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

import collection.JavaConversions._
import javafx.event.EventDispatcher
import javafx.event.EventHandler
import javafx.{scene => jfxs}
import javafx.scene.Camera
import javafx.scene.Cursor
import javafx.scene.input.DragEvent
import javafx.scene.input.InputMethodEvent
import javafx.scene.input.KeyEvent
import javafx.scene.input.MouseEvent
import javafx.scene.paint.Paint
import scalafx.Includes._
import scalafx.util.SFXDelegate

object Scene {
  implicit def sfxScene2jfx(v: Scene) = v.delegate
}

class Scene(val rootVal: Parent = new scalafx.scene.Group()) extends SFXDelegate[javafx.scene.Scene] {
  override val delegate = new javafx.scene.Scene(rootVal.delegate)

  def root = delegate.rootProperty
  def root_=(v: jfxs.Parent) {
    root() = v
  }

  def getChildren = root.value match {
    case group: scalafx.scene.Group => group.delegate.getChildren
    case pane: scalafx.scene.layout.Pane => pane.delegate.getChildren
    case jfxgroup: javafx.scene.Group => jfxgroup.getChildren
    case jfxpane: javafx.scene.layout.Pane => jfxpane.getChildren
    case _ => throw new IllegalStateException("Cannot access children of root: " + root + "\nUse a class that extends Group or Pane, or override the getChildren method.")
  }
  def content = getChildren
  def content_=(c: Iterable[Node]) {
    getChildren.setAll(c.map(_.delegate))
  }
  def content_=(n: Node) {
    getChildren.clear()
    getChildren.add(n)
  }

  def camera = delegate.cameraProperty
  def camera_=(v: Camera) {
    camera() = v
  }

  def cursor = delegate.cursorProperty
  def cursor_=(v: Cursor) {
    cursor() = v
  }

  def eventDispatcher = delegate.eventDispatcherProperty
  def eventDispatcher_=(v: EventDispatcher) {
    eventDispatcher() = v
  }

  def fill = delegate.fillProperty
  def fill_=(v: Paint) {
    fill() = v
  }

  def height = delegate.heightProperty

  def width = delegate.widthProperty

  def onDragDetected = delegate.onDragDetectedProperty
  def onDragDetected_=(v: EventHandler[_ >: MouseEvent]) {
    onDragDetected() = v
  }

  def onDragDone = delegate.onDragDoneProperty
  def onDragDone_=(v: EventHandler[_ >: DragEvent]) {
    onDragDone() = v
  }

  def onDragDropped = delegate.onDragDroppedProperty
  def onDragDropped_=(v: EventHandler[_ >: DragEvent]) {
    onDragDropped() = v
  }

  def onDragEntered = delegate.onDragEnteredProperty
  def onDragEntered_=(v: EventHandler[_ >: DragEvent]) {
    onDragEntered() = v
  }

  def onDragExited = delegate.onDragExitedProperty
  def onDragExited_=(v: EventHandler[_ >: DragEvent]) {
    onDragExited() = v
  }

  def onDragOver = delegate.onDragOverProperty
  def onDragOver_=(v: EventHandler[_ >: DragEvent]) {
    onDragOver() = v
  }

  def onInputMethodTextChanged = delegate.onInputMethodTextChangedProperty
  def onInputMethodTextChanged_=(v: EventHandler[_ >: InputMethodEvent]) {
    onInputMethodTextChanged() = v
  }

  def onKeyPressed = delegate.onKeyPressedProperty
  def onKeyPressed_=(v: EventHandler[_ >: KeyEvent]) {
    onKeyPressed() = v
  }

  def onKeyReleased = delegate.onKeyReleasedProperty
  def onKeyReleased_=(v: EventHandler[_ >: KeyEvent]) {
    onKeyReleased() = v
  }

  def onKeyTyped = delegate.onKeyTypedProperty
  def onKeyTyped_=(v: EventHandler[_ >: KeyEvent]) {
    onKeyTyped() = v
  }

  def onMouseClicked = delegate.onMouseClickedProperty
  def onMouseClicked_=(v: EventHandler[_ >: MouseEvent]) {
    onMouseClicked() = v
  }

  def onMouseDragged = delegate.onMouseDraggedProperty
  def onMouseDragged_=(v: EventHandler[_ >: MouseEvent]) {
    onMouseDragged() = v
  }

  def onMouseEntered = delegate.onMouseEnteredProperty
  def onMouseEntered_=(v: EventHandler[_ >: MouseEvent]) {
    onMouseEntered() = v
  }

  def onMouseExited = delegate.onMouseExitedProperty
  def onMouseExited_=(v: EventHandler[_ >: MouseEvent]) {
    onMouseExited() = v
  }

  def onMouseMoved = delegate.onMouseMovedProperty
  def onMouseMoved_=(v: EventHandler[_ >: MouseEvent]) {
    onMouseMoved() = v
  }

  def onMousePressed = delegate.onMousePressedProperty
  def onMousePressed_=(v: EventHandler[_ >: MouseEvent]) {
    onMousePressed() = v
  }

  def onMouseReleased = delegate.onMouseReleasedProperty
  def onMouseReleased_=(v: EventHandler[_ >: MouseEvent]) {
    onMouseReleased() = v
  }

  def window = delegate.windowProperty

  def x = delegate.xProperty

  def y = delegate.yProperty

  def depthBuffer = delegate.isDepthBuffer

  def stylesheets = delegate.getStylesheets
  def stylesheets_=(c: Iterable[String]) {
    stylesheets.addAll(c)
  }
}