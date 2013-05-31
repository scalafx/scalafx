/*
 * Copyright (c) 2011-2013, ScalaFX Project
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

import javafx.beans.{binding => jfxbb}
import javafx.beans.{property => jfxbp}
import javafx.{scene => jfxs, event => jfxe}
import jfxs.{input => jfxsi, paint => jfxsp}
import scalafx.beans.property.ReadOnlyObjectProperty
import scalafx.delegate.SFXDelegate

object SceneProperty {
  implicit def sfxSceneProperty2jfx(p: SceneProperty) = p.delegate
}

// This particular construct enables the reading of properties of the scene that will be set into the property later on.
class SceneProperty(override val delegate: jfxbp.ReadOnlyObjectProperty[jfxs.Scene]) extends ReadOnlyObjectProperty[jfxs.Scene](delegate) with SFXDelegate[jfxbp.ReadOnlyObjectProperty[jfxs.Scene]] {
  def camera = jfxbb.Bindings.select[jfxbb.ObjectBinding[jfxs.Camera]](delegate, "camera")
  def cursor = jfxbb.Bindings.select[jfxbb.ObjectBinding[jfxs.Cursor]](delegate, "cursor")
  def depthBuffer = jfxbb.Bindings.selectBoolean(delegate, "depthBuffer")
  def eventDispatcher = jfxbb.Bindings.select[jfxbb.ObjectBinding[jfxe.EventDispatcher]](delegate, "eventDispatcher")
  def fill = jfxbb.Bindings.select[jfxbb.ObjectBinding[jfxsp.Paint]](delegate, "fill")
  def focusOwner = jfxbb.Bindings.select[jfxs.Node](delegate, "focusOwner")
  def height = jfxbb.Bindings.selectDouble(delegate, "height")
  def onContextMenuRequested = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.ContextMenuEvent]](delegate, "onContextMenuRequested")
  def onDragDetected = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.DragEvent]](delegate, "onDragDetected")
  def onDragDone = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.DragEvent]](delegate, "onDragDone")
  def onDragDropped = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.DragEvent]](delegate, "onDragDropped")
  def onDragEntered = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.DragEvent]](delegate, "onDragEntered")
  def onDragExited = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.DragEvent]](delegate, "onDragExited")
  def onDragOver = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.DragEvent]](delegate, "onDragOver")
  def onInputMethodTextChanged = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.InputEvent]](delegate, "onInputMethodTextChanged")
  def onKeyPressed = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.KeyEvent]](delegate, "onKeyPressed")
  def onKeyReleased = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.KeyEvent]](delegate, "onKeyReleased")
  def onKeyTyped = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.KeyEvent]](delegate, "onKeyTyped")
  def onMouseClicked = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.MouseEvent]](delegate, "onMouseClicked")
  def onMouseDragEntered = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.MouseEvent]](delegate, "onMouseDragEntered")
  def onMouseDragExited = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.MouseEvent]](delegate, "onMouseDragExited")
  def onMouseDragOver = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.MouseEvent]](delegate, "onMouseDragOver")
  def onMouseDragReleased = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.MouseEvent]](delegate, "onMouseDragReleased")
  def onMouseDragged = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.MouseEvent]](delegate, "onMouseDragged")
  def onMouseEntered = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.MouseEvent]](delegate, "onMouseEntered")
  def onMouseExited = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.MouseEvent]](delegate, "onMouseExited")
  def onMouseMoved = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.MouseEvent]](delegate, "onMouseMoved")
  def onMousePressed = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.MouseEvent]](delegate, "onMousePressed")
  def onMouseReleased = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.MouseEvent]](delegate, "onMouseReleased")
  def onRotate = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.RotateEvent]](delegate, "onRotate")
  def onRotationFinished = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.RotateEvent]](delegate, "onRotationFinished")
  def onRotationStarted = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.RotateEvent]](delegate, "onRotationStarted")
  def onScroll = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.ScrollEvent]](delegate, "onScroll")
  def onScrollFinished = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.ScrollEvent]](delegate, "onScrollFinished")
  def onScrollStarted = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.ScrollEvent]](delegate, "onScrollStarted")
  def onSwipeDown = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.SwipeEvent]](delegate, "onSwipeDown")
  def onSwipeLeft = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.SwipeEvent]](delegate, "onSwipeLeft")
  def onSwipeRight = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.SwipeEvent]](delegate, "onSwipeRight")
  def onSwipeUp = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.SwipeEvent]](delegate, "onSwipeUp")
  def onTouchMoved = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.TouchEvent]](delegate, "onTouchMoved")
  def onTouchPressed = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.TouchEvent]](delegate, "onTouchPressed")
  def onTouchReleased = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.TouchEvent]](delegate, "onTouchReleased")
  def onTouchStationary = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.TouchEvent]](delegate, "onTouchStationary")
  def onZoom = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.ZoomEvent]](delegate, "onZoom")
  def onZoomFinished = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.ZoomEvent]](delegate, "onZoomFinished")
  def onZoomStarted = jfxbb.Bindings.select[jfxbb.ObjectBinding[_ >: jfxsi.ZoomEvent]](delegate, "onZoomStarted")
  def root = jfxbb.Bindings.select[jfxs.Parent](delegate, "root")
  def stylesheets = jfxbb.Bindings.select[jfxbb.ObjectBinding[javafx.collections.ObservableList[String]]](delegate, "stylesheets")
  def width = jfxbb.Bindings.selectDouble(delegate, "width")
  def window = jfxbb.Bindings.select[javafx.stage.Window](delegate, "window")
  def x = jfxbb.Bindings.selectDouble(delegate, "x")
  def y = jfxbb.Bindings.selectDouble(delegate, "y")
}
