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

package scalafx.scene

import javafx.beans.{binding => jfxbb, property => jfxbp}
import javafx.scene.{input => jfxsi, paint => jfxsp}
import javafx.{event => jfxe, geometry => jfxg, scene => jfxs}

import scala.language.implicitConversions
import scalafx.beans.property.ReadOnlyObjectProperty
import scalafx.delegate.SFXDelegate

@deprecated(
  "Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)",
  "8.0.60-R10"
)
object SceneProperty {
  @deprecated(
    "Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)",
    "8.0.60-R10"
  )
  implicit def sfxSceneProperty2jfx(p: SceneProperty): jfxbp.ReadOnlyObjectProperty[jfxs.Scene] =
    if (p != null) p.delegate else null
}

// This particular construct enables the reading of properties of the scene that will be set into the property later on.
@deprecated(
  "Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)",
  "8.0.60-R10"
)
class SceneProperty(override val delegate: jfxbp.ReadOnlyObjectProperty[jfxs.Scene])
    extends ReadOnlyObjectProperty[jfxs.Scene](delegate)
    with SFXDelegate[jfxbp.ReadOnlyObjectProperty[jfxs.Scene]] {
  @deprecated(
    "Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)",
    "8.0.60-R10"
  )
  def camera = jfxbb.Bindings.select[jfxbb.ObjectBinding[jfxs.Camera]](delegate, "camera")
  @deprecated(
    "Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)",
    "8.0.60-R10"
  )
  def cursor = jfxbb.Bindings.select[jfxbb.ObjectBinding[jfxs.Cursor]](delegate, "cursor")
  @deprecated(
    "Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)",
    "8.0.60-R10"
  )
  def depthBuffer = jfxbb.Bindings.selectBoolean(delegate, "depthBuffer")
  @deprecated(
    "Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)",
    "8.0.60-R10"
  )
  def effectiveNodeOrientation =
    jfxbb.Bindings.select[jfxbp.ReadOnlyObjectProperty[jfxg.NodeOrientation]](delegate, "effectiveNodeOrientation")
  @deprecated(
    "Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)",
    "8.0.60-R10"
  )
  def eventDispatcher = jfxbb.Bindings.select[jfxbb.ObjectBinding[jfxe.EventDispatcher]](delegate, "eventDispatcher")
  @deprecated(
    "Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)",
    "8.0.60-R10"
  )
  def fill = jfxbb.Bindings.select[jfxbb.ObjectBinding[jfxsp.Paint]](delegate, "fill")
  @deprecated(
    "Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)",
    "8.0.60-R10"
  )
  def focusOwner = jfxbb.Bindings.select[jfxs.Node](delegate, "focusOwner")
  @deprecated(
    "Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)",
    "8.0.60-R10"
  )
  def height = jfxbb.Bindings.selectDouble(delegate, "height")
  @deprecated(
    "Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)",
    "8.0.60-R10"
  )
  def nodeOrientation =
    jfxbb.Bindings.select[jfxbp.ReadOnlyObjectProperty[jfxg.NodeOrientation]](delegate, "nodeOrientation")
  @deprecated(
    "Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)",
    "8.0.60-R10"
  )
  def onContextMenuRequested =
    jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.ContextMenuEvent]](delegate, "onContextMenuRequested")
  @deprecated(
    "Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)",
    "8.0.60-R10"
  )
  def onDragDetected = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.DragEvent]](delegate, "onDragDetected")
  @deprecated(
    "Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)",
    "8.0.60-R10"
  )
  def onDragDone = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.DragEvent]](delegate, "onDragDone")
  @deprecated(
    "Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)",
    "8.0.60-R10"
  )
  def onDragDropped = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.DragEvent]](delegate, "onDragDropped")
  @deprecated(
    "Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)",
    "8.0.60-R10"
  )
  def onDragEntered = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.DragEvent]](delegate, "onDragEntered")
  @deprecated(
    "Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)",
    "8.0.60-R10"
  )
  def onDragExited = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.DragEvent]](delegate, "onDragExited")
  @deprecated(
    "Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)",
    "8.0.60-R10"
  )
  def onDragOver = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.DragEvent]](delegate, "onDragOver")
  @deprecated(
    "Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)",
    "8.0.60-R10"
  )
  def onInputMethodTextChanged =
    jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.InputEvent]](delegate, "onInputMethodTextChanged")
  @deprecated(
    "Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)",
    "8.0.60-R10"
  )
  def onKeyPressed = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.KeyEvent]](delegate, "onKeyPressed")
  @deprecated(
    "Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)",
    "8.0.60-R10"
  )
  def onKeyReleased = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.KeyEvent]](delegate, "onKeyReleased")
  @deprecated(
    "Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)",
    "8.0.60-R10"
  )
  def onKeyTyped = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.KeyEvent]](delegate, "onKeyTyped")
  @deprecated(
    "Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)",
    "8.0.60-R10"
  )
  def onMouseClicked = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.MouseEvent]](delegate, "onMouseClicked")
  @deprecated(
    "Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)",
    "8.0.60-R10"
  )
  def onMouseDragEntered =
    jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.MouseDragEvent]](delegate, "onMouseDragEntered")
  @deprecated(
    "Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)",
    "8.0.60-R10"
  )
  def onMouseDragExited =
    jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.MouseDragEvent]](delegate, "onMouseDragExited")
  @deprecated(
    "Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)",
    "8.0.60-R10"
  )
  def onMouseDragOver =
    jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.MouseDragEvent]](delegate, "onMouseDragOver")
  @deprecated(
    "Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)",
    "8.0.60-R10"
  )
  def onMouseDragReleased =
    jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.MouseDragEvent]](delegate, "onMouseDragReleased")
  @deprecated(
    "Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)",
    "8.0.60-R10"
  )
  def onMouseDragged = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.MouseEvent]](delegate, "onMouseDragged")
  @deprecated(
    "Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)",
    "8.0.60-R10"
  )
  def onMouseEntered = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.MouseEvent]](delegate, "onMouseEntered")
  @deprecated(
    "Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)",
    "8.0.60-R10"
  )
  def onMouseExited = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.MouseEvent]](delegate, "onMouseExited")
  @deprecated(
    "Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)",
    "8.0.60-R10"
  )
  def onMouseMoved = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.MouseEvent]](delegate, "onMouseMoved")
  @deprecated(
    "Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)",
    "8.0.60-R10"
  )
  def onMousePressed = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.MouseEvent]](delegate, "onMousePressed")
  @deprecated(
    "Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)",
    "8.0.60-R10"
  )
  def onMouseReleased = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.MouseEvent]](delegate, "onMouseReleased")
  @deprecated(
    "Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)",
    "8.0.60-R10"
  )
  def onRotate = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.RotateEvent]](delegate, "onRotate")
  @deprecated(
    "Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)",
    "8.0.60-R10"
  )
  def onRotationFinished =
    jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.RotateEvent]](delegate, "onRotationFinished")
  @deprecated(
    "Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)",
    "8.0.60-R10"
  )
  def onRotationStarted =
    jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.RotateEvent]](delegate, "onRotationStarted")
  @deprecated(
    "Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)",
    "8.0.60-R10"
  )
  def onScroll = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.ScrollEvent]](delegate, "onScroll")
  @deprecated(
    "Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)",
    "8.0.60-R10"
  )
  def onScrollFinished =
    jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.ScrollEvent]](delegate, "onScrollFinished")
  @deprecated(
    "Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)",
    "8.0.60-R10"
  )
  def onScrollStarted = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.ScrollEvent]](delegate, "onScrollStarted")
  @deprecated(
    "Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)",
    "8.0.60-R10"
  )
  def onSwipeDown = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.SwipeEvent]](delegate, "onSwipeDown")
  @deprecated(
    "Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)",
    "8.0.60-R10"
  )
  def onSwipeLeft = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.SwipeEvent]](delegate, "onSwipeLeft")
  @deprecated(
    "Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)",
    "8.0.60-R10"
  )
  def onSwipeRight = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.SwipeEvent]](delegate, "onSwipeRight")
  @deprecated(
    "Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)",
    "8.0.60-R10"
  )
  def onSwipeUp = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.SwipeEvent]](delegate, "onSwipeUp")
  @deprecated(
    "Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)",
    "8.0.60-R10"
  )
  def onTouchMoved = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.TouchEvent]](delegate, "onTouchMoved")
  @deprecated(
    "Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)",
    "8.0.60-R10"
  )
  def onTouchPressed = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.TouchEvent]](delegate, "onTouchPressed")
  @deprecated(
    "Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)",
    "8.0.60-R10"
  )
  def onTouchReleased = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.TouchEvent]](delegate, "onTouchReleased")
  @deprecated(
    "Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)",
    "8.0.60-R10"
  )
  def onTouchStationary =
    jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.TouchEvent]](delegate, "onTouchStationary")
  @deprecated(
    "Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)",
    "8.0.60-R10"
  )
  def onZoom = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.ZoomEvent]](delegate, "onZoom")
  @deprecated(
    "Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)",
    "8.0.60-R10"
  )
  def onZoomFinished = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.ZoomEvent]](delegate, "onZoomFinished")
  @deprecated(
    "Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)",
    "8.0.60-R10"
  )
  def onZoomStarted = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.ZoomEvent]](delegate, "onZoomStarted")
  @deprecated(
    "Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)",
    "8.0.60-R10"
  )
  def root = jfxbb.Bindings.select[jfxs.Parent](delegate, "root")
  @deprecated(
    "Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)",
    "8.0.60-R10"
  )
  def stylesheets =
    jfxbb.Bindings.select[jfxbb.ObjectBinding[javafx.collections.ObservableList[String]]](delegate, "stylesheets")
  @deprecated(
    "Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)",
    "8.0.60-R10"
  )
  def userAgentStylesheet = jfxbb.Bindings.select[String](delegate, "userAgentStylesheet")
  @deprecated(
    "Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)",
    "8.0.60-R10"
  )
  def width = jfxbb.Bindings.selectDouble(delegate, "width")
  @deprecated(
    "Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)",
    "8.0.60-R10"
  )
  def window = jfxbb.Bindings.select[javafx.stage.Window](delegate, "window")
  @deprecated(
    "Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)",
    "8.0.60-R10"
  )
  def x = jfxbb.Bindings.selectDouble(delegate, "x")
  @deprecated(
    "Use of SceneProperty can result in infinite recursion and StackOverflow errors. See discussion of [Issue #69](https://github.com/scalafx/scalafx/issues/69)",
    "8.0.60-R10"
  )
  def y = jfxbb.Bindings.selectDouble(delegate, "y")
}
