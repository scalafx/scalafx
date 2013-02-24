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
import javafx.{event => jfxe, scene => jfxs}
import jfxs.{input => jfxsi, paint => jfxsp, layout => jfxsl}
import scalafx.Includes._
import scalafx.beans.property.ObjectProperty
import scalafx.scene.paint.Paint
import scalafx.delegate.SFXDelegate

object Scene {
  implicit def sfxScene2jfx(v: Scene) = v.delegate
}

class Scene(override val delegate: jfxs.Scene = new jfxs.Scene(new jfxs.Group())) extends SFXDelegate[jfxs.Scene] {
  def this(width: Double, height: Double) = this (new jfxs.Scene(new jfxs.Group(), width, height))

  def this(parent: Parent) = this(new jfxs.Scene(parent))

  def this(parent: Parent, width: Double, height: Double) = this(new jfxs.Scene(parent, width, height))

  def this(parent: Parent, width: Double, height: Double, depthBuffer: Boolean ) = this(new jfxs.Scene(parent, width, height, depthBuffer ))
  //def this(stackPane: jfxsl.StackPane) = this (new jfxs.Scene(stackPane))

  //def this(stackPane: jfxsl.StackPane, width: Double, height: Double) = this (new jfxs.Scene(stackPane, width, height))

  def root: ObjectProperty[jfxs.Parent] = delegate.rootProperty

  def root_=(v: Parent) {
    root() = v
  }

  def getChildren = root.value match {
    case group: jfxs.Group => group.getChildren
    case pane: jfxsl.Pane => pane.getChildren
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

  def camera: ObjectProperty[jfxs.Camera] = delegate.cameraProperty

  def camera_=(v: Camera) {
    camera() = v
  }

  def cursor: ObjectProperty[jfxs.Cursor] = delegate.cursorProperty

  def cursor_=(v: Cursor) {
    cursor() = v
  }

  def eventDispatcher = delegate.eventDispatcherProperty

  def eventDispatcher_=(v: jfxe.EventDispatcher) {
    eventDispatcher() = v
  }

  def fill: ObjectProperty[jfxsp.Paint] = delegate.fillProperty

  def fill_=(v: Paint) {
    fill() = v
  }

  def height = delegate.heightProperty

  def width = delegate.widthProperty

  def onContextMenuRequested = delegate.onContextMenuRequestedProperty

  def onContextMenuRequested_=(v: jfxe.EventHandler[_ >: jfxsi.ContextMenuEvent]) {
    onContextMenuRequested() = v
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

  def onMouseDragEntered = delegate.onMouseDragEnteredProperty

  def onMouseDragEntered_=(v: jfxe.EventHandler[_ >: jfxsi.MouseEvent]) {
    onMouseDragEntered() = v
  }

  def onMouseDragExited = delegate.onMouseDragExitedProperty

  def onMouseDragExited_=(v: jfxe.EventHandler[_ >: jfxsi.MouseEvent]) {
    onMouseDragExited() = v
  }

  def onMouseDragOver = delegate.onMouseDragOverProperty

  def onMouseDragOver_=(v: jfxe.EventHandler[_ >: jfxsi.MouseEvent]) {
    onMouseDragOver() = v
  }

  def onMouseDragReleased = delegate.onMouseDragReleasedProperty

  def onMouseDragReleased_=(v: jfxe.EventHandler[_ >: jfxsi.MouseEvent]) {
    onMouseDragReleased() = v
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

  def onScroll = delegate.onScrollProperty

  def onScroll_=(v: jfxe.EventHandler[_ >: jfxsi.ScrollEvent]) {
    onScroll() = v
  }

  def window = delegate.windowProperty

  def x = delegate.xProperty

  def y = delegate.yProperty

  def depthBuffer = delegate.isDepthBuffer

  def stylesheets = delegate.getStylesheets

  def stylesheets_=(c: Iterable[String]) {
    stylesheets.addAll(c)
  }

  /**
   * The scene's current focus owner node. This node's "focused" variable might be false if this scene has no window,
   * or if the window is inactive (window.focused == false).
   *
   * @since 2.2
   */
  def focusOwner = delegate.focusOwnerProperty()

  /**
   * Defines a function to be called when user performs a rotation action.
   *
   * @since 2.2
   */
  def onRotate = delegate.onRotateProperty
  def onRotate_= ( v: jfxe.EventHandler[jfxsi.RotateEvent]) {
    onRotate() = v
  }

  /**
   * Defines a function to be called when a rotation gesture ends.
   *
   * @since 2.2
   */
  def onRotationFinished = delegate.onRotationFinishedProperty()
  def onRotationFinished_= ( v: jfxe.EventHandler[jfxsi.RotateEvent]) {
    onRotationFinished() = v
  }

  /**
   * Defines a function to be called when a rotation gesture starts.
   *
   * @since 2.2
   */
  def onRotationStarted = delegate.onRotationFinishedProperty()
  def onRotationStarted_= ( v: jfxe.EventHandler[jfxsi.RotateEvent]) {
    onRotationStarted() = v
  }

  /**
   * Defines a function to be called when a Scroll gesture ends.
   *
   * @since 2.2
   */
  def onScrollFinished = delegate.onScrollFinishedProperty()
  def onScrollFinished_= ( v: jfxe.EventHandler[jfxsi.ScrollEvent]) {
    onScrollFinished() = v
  }

  /**
   * Defines a function to be called when a Scroll gesture starts.
   *
   * @since 2.2
   */
  def onScrollStarted = delegate.onScrollStartedProperty()
  def onScrollStarted_= ( v: jfxe.EventHandler[jfxsi.ScrollEvent]) {
    onScrollStarted() = v
  }

  /**
   * Defines a function to be called when a Swipe Down gesture starts.
   *
   * @since 2.2
   */
  def onSwipeDown = delegate.onSwipeDownProperty()
  def onSwipeDown_= ( v: jfxe.EventHandler[jfxsi.SwipeEvent]) {
    onSwipeDown() = v
  }

  /**
   * Defines a function to be called when a Swipe Down gesture starts.
   *
   * @since 2.2
   */
  def onSwipeLeft = delegate.onSwipeLeftProperty()
  def onSwipeLeft_= ( v: jfxe.EventHandler[jfxsi.SwipeEvent]) {
    onSwipeLeft() = v
  }

  /**
   * Defines a function to be called when a Swipe Up gesture starts.
   *
   * @since 2.2
   */
  def onSwipeUp = delegate.onSwipeUpProperty()
  def onSwipeUp_= ( v: jfxe.EventHandler[jfxsi.SwipeEvent]) {
    onSwipeUp() = v
  }

  /**
   * Defines a function to be called when a Swipe Right gesture starts.
   *
   * @since 2.2
   */
  def onSwipeRight = delegate.onSwipeRightProperty()
  def onSwipeRight_= ( v: jfxe.EventHandler[jfxsi.SwipeEvent]) {
    onSwipeRight() = v
  }

  /**
   * Defines a function to be called when user performs a Touch action.
   *
   * @since 2.2
   */
  def onZoom = delegate.onZoomProperty()
  def onZoom_= ( v: jfxe.EventHandler[jfxsi.ZoomEvent]) {
    onZoom() = v
  }


  /**
   * Defines a function to be called when a Zoom gesture ends.
   *
   * @since 2.2
   */
  def onZoomFinished = delegate.onZoomFinishedProperty()
  def onZoomFinished_= ( v: jfxe.EventHandler[jfxsi.ZoomEvent]) {
    onZoomFinished() = v
  }

  /**
   * Defines a function to be called when a Zoom gesture starts.
   *
   * @since 2.2
   */
  def onZoomStarted = delegate.onZoomStartedProperty()
  def onZoomStarted_= ( v: jfxe.EventHandler[jfxsi.ZoomEvent]) {
    onZoomStarted() = v
  }

  /**
   * Defines a function to be called when user performs a Touch Moved action.
   *
   * @since 2.2
   */
  def onTouchMoved = delegate.onTouchMovedProperty()
  def onTouchMoved_= ( v: jfxe.EventHandler[jfxsi.TouchEvent]) {
    onTouchMoved() = v
  }

  /**
   * Defines a function to be called when user performs a Touch Pressed action.
   *
   * @since 2.2
   */
  def onTouchPressed = delegate.onTouchPressedProperty()
  def onTouchPressed_= ( v: jfxe.EventHandler[jfxsi.TouchEvent]) {
    onTouchPressed() = v
  }

  /**
   * Defines a function to be called when user performs a Touch Released action.
   *
   * @since 2.2
   */
  def onTouchReleased = delegate.onTouchPressedProperty()
  def onTouchReleased_= ( v: jfxe.EventHandler[jfxsi.TouchEvent]) {
    onTouchReleased() = v
  }

  /**
   * Defines a function to be called when user performs a Touch Stationary action.
   *
   * @since 2.2
   */
  def onTouchStationary = delegate.onTouchStationaryProperty()
  def onTouchStationary_= ( v: jfxe.EventHandler[jfxsi.TouchEvent]) {
    onTouchStationary() = v
  }

}