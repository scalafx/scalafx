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
import javafx.beans.property.{ReadOnlyBooleanProperty => JFXReadOnlyBooleanProperty}
import javafx.event.EventDispatcher
import javafx.event.EventHandler
import javafx.scene.Camera
import javafx.scene.Cursor
import javafx.scene.input.DragEvent
import javafx.scene.input.InputMethodEvent
import javafx.scene.input.KeyEvent
import javafx.scene.input.MouseEvent
import javafx.scene.paint.Paint
import scalafx.beans.property.ObjectProperty
import scalafx.beans.property.ReadOnlyBooleanProperty
import scalafx.beans.property.ReadOnlyDoubleProperty
import scalafx.beans.property.ReadOnlyObjectProperty
import scalafx.util.SFXDelegate

class Scene(val rootVal: Parent = new scalafx.scene.Group()) extends SFXDelegate {
   
  override val delegate = new javafx.scene.Scene(rootVal.delegate)

  private[this] lazy val _rootProperty = new ObjectProperty[javafx.scene.Parent](delegate.rootProperty())
  def root = _rootProperty
  def root_=(v: javafx.scene.Parent) {
    root() = v
  }   
  

  // todo - replace this with a little SFX collection conversion
  def getChildren = root match {
    case group: scalafx.scene.Group => group.delegate.getChildren
    case pane: scalafx.scene.layout.Pane => pane.delegate.getChildren
    case _ => throw new IllegalStateException("Cannot access children of root: " + root + "\nUse a class that extends Group or Pane, or override the getChildren method.")
  }
  def content = getChildren
  def content_=(c: Iterable[Node]) {
    getChildren.setAll(c.map(_.delegate))
  }

  private[this] lazy val _cameraProperty = new ObjectProperty[Camera](delegate.cameraProperty())
  def camera = _cameraProperty
  def camera_=(v: Camera) {
    camera() = v
  }

  private[this] lazy val _cursorProperty = new ObjectProperty[Cursor](delegate.cursorProperty())
  def cursor = _cursorProperty
  def cursor_=(v: Cursor) {
    cursor() = v
  }

  private[this] lazy val _eventDispatcherProperty = new ObjectProperty[EventDispatcher](delegate.eventDispatcherProperty())
  def eventDispatcher = _eventDispatcherProperty
  def eventDispatcher_=(v: EventDispatcher) {
    eventDispatcher() = v
  }
  
  private[this] lazy val _fillProperty = new ObjectProperty[Paint](delegate.fillProperty())
  def fill = _fillProperty
  def fill_=(v: Paint) {
    fill() = v
  }

  private[this] lazy val _heightProperty = new ReadOnlyDoubleProperty(delegate.heightProperty())
  def height = _heightProperty

  private[this] lazy val _widthProperty = new ReadOnlyDoubleProperty(delegate.widthProperty())
  def width = _widthProperty

  private[this] lazy val _onDragDetectedProperty = new ObjectProperty[EventHandler[_ >: MouseEvent]](delegate.onDragDetectedProperty())
  def onDragDetected = _onDragDetectedProperty
  def onDragDetected_=(v: EventHandler[_ >: MouseEvent]) {
    onDragDetected() = v
  }  
  
  private[this] lazy val _onDragDoneProperty = new ObjectProperty[EventHandler[_ >: DragEvent]](delegate.onDragDoneProperty())
  def onDragDone = _onDragDoneProperty
  def onDragDone_=(v: EventHandler[_ >: DragEvent]) {
    onDragDone() = v
  }  

  private[this] lazy val _onDragDroppedProperty = new ObjectProperty[EventHandler[_ >: DragEvent]](delegate.onDragDroppedProperty())
  def onDragDropped = _onDragDroppedProperty
  def onDragDropped_=(v: EventHandler[_ >: DragEvent]) {
    onDragDropped() = v
  }  

  private[this] lazy val _onDragEnteredProperty = new ObjectProperty[EventHandler[_ >: DragEvent]](delegate.onDragEnteredProperty())
  def onDragEntered = _onDragEnteredProperty
  def onDragEntered_=(v: EventHandler[_ >: DragEvent]) {
    onDragEntered() = v
  }  

  private[this] lazy val _onDragExitedProperty = new ObjectProperty[EventHandler[_ >: DragEvent]](delegate.onDragExitedProperty())
  def onDragExited = _onDragExitedProperty
  def onDragExited_=(v: EventHandler[_ >: DragEvent]) {
    onDragExited() = v
  }  

  private[this] lazy val _onDragOverProperty = new ObjectProperty[EventHandler[_ >: DragEvent]](delegate.onDragOverProperty())
  def onDragOver = _onDragOverProperty
  def onDragOver_=(v: EventHandler[_ >: DragEvent]) {
    onDragOver() = v
  }  

  private[this] lazy val _onInputMethodTextChangedProperty = new ObjectProperty[EventHandler[_ >: InputMethodEvent]](delegate.onInputMethodTextChangedProperty())
  def onInputMethodTextChanged = _onInputMethodTextChangedProperty
  def onInputMethodTextChanged_=(v: EventHandler[_ >: InputMethodEvent]) {
    onInputMethodTextChanged() = v
  }  

  private[this] lazy val _onKeyPressedProperty = new ObjectProperty[EventHandler[_ >: KeyEvent]](delegate.onKeyPressedProperty())
  def onKeyPressed = _onKeyPressedProperty
  def onKeyPressed_=(v: EventHandler[_ >: KeyEvent]) {
    onKeyPressed() = v
  }  

  private[this] lazy val _onKeyReleasedProperty = new ObjectProperty[EventHandler[_ >: KeyEvent]](delegate.onKeyReleasedProperty())
  def onKeyReleased = _onKeyReleasedProperty
  def onKeyReleased_=(v: EventHandler[_ >: KeyEvent]) {
    onKeyReleased() = v
  }  
  
  private[this] lazy val _onKeyTypedProperty = new ObjectProperty[EventHandler[_ >: KeyEvent]](delegate.onKeyTypedProperty())
  def onKeyTyped = _onKeyTypedProperty
  def onKeyTyped_=(v: EventHandler[_ >: KeyEvent]) {
    onKeyTyped() = v
  }  
  
  
  private[this] lazy val _onMouseClickedProperty = new ObjectProperty[EventHandler[_ >: MouseEvent]](delegate.onMouseClickedProperty())
  def onMouseClicked = _onMouseClickedProperty
  def onMouseClicked_=(v: EventHandler[_ >: MouseEvent]) {
    onMouseClicked() = v
  } 

  private[this] lazy val _onMouseDraggedProperty = new ObjectProperty[EventHandler[_ >: MouseEvent]](delegate.onMouseDraggedProperty())
  def onMouseDragged = _onMouseDraggedProperty
  def onMouseDragged_=(v: EventHandler[_ >: MouseEvent]) {
    onMouseDragged() = v
  }  

  private[this] lazy val _onMouseEnteredProperty = new ObjectProperty[EventHandler[_ >: MouseEvent]](delegate.onMouseEnteredProperty())
  def onMouseEntered = _onMouseEnteredProperty
  def onMouseEntered_=(v: EventHandler[_ >: MouseEvent]) {
    onMouseEntered() = v
  }
  
  private[this] lazy val _onMouseExitedProperty = new ObjectProperty[EventHandler[_ >: MouseEvent]](delegate.onMouseExitedProperty())
  def onMouseExited = _onMouseExitedProperty
  def onMouseExited_=(v: EventHandler[_ >: MouseEvent]) {
    onMouseExited() = v
  }  

  private[this] lazy val _onMouseMovedProperty = new ObjectProperty[EventHandler[_ >: MouseEvent]](delegate.onMouseMovedProperty())
  def onMouseMoved = _onMouseMovedProperty
  def onMouseMoved_=(v: EventHandler[_ >: MouseEvent]) {
    onMouseMoved() = v
  }  
  
  private[this] lazy val _onMousePressedProperty = new ObjectProperty[EventHandler[_ >: MouseEvent]](delegate.onMousePressedProperty())
  def onMousePressed = _onMousePressedProperty
  def onMousePressed_=(v: EventHandler[_ >: MouseEvent]) {
    onMousePressed() = v
  }
  
  private[this] lazy val _onMouseReleasedProperty = new ObjectProperty[EventHandler[_ >: MouseEvent]](delegate.onMouseReleasedProperty())
  def onMouseReleased = _onMouseReleasedProperty
  def onMouseReleased_=(v: EventHandler[_ >: MouseEvent]) {
    onMouseReleased() = v
  }   

  private[this] lazy val _windowProperty = new ReadOnlyObjectProperty[javafx.stage.Window](delegate.windowProperty())
  def window = _windowProperty

  
  private[this] lazy val _xProperty = new ReadOnlyDoubleProperty(delegate.xProperty())
  def x = _xProperty

  private[this] lazy val _yProperty = new ReadOnlyDoubleProperty(delegate.yProperty())
  def y = _yProperty
  
  private[this] lazy val _depthBufferProperty = new ReadOnlyBooleanProperty(delegate, "depthBuffer", delegate.isDepthBuffer())
  def depthBuffer = _depthBufferProperty
 
  private[this] lazy val _stylesheetsProperty = delegate.getStylesheets

  def stylesheets = _stylesheetsProperty
  def stylesheets_=(c: Iterable[String]) {
    stylesheets.addAll(c)
  }  
  
}