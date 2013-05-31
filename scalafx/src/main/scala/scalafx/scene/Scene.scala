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

import collection.JavaConversions._
import javafx.{ event => jfxe, scene => jfxs }
import jfxs.{ input => jfxsi, paint => jfxsp, layout => jfxsl }
import javafx.{ collections => jfxc }
import javafx.{ util => jfxu }
import scalafx.collections._
import scalafx.Includes._
import scalafx.beans.property.ObjectProperty
import scalafx.beans.property.ReadOnlyDoubleProperty
import scalafx.beans.property.ReadOnlyObjectProperty
import scalafx.scene.paint.Paint
import scalafx.delegate.SFXDelegate
import scalafx.scene.input.Mnemonic
import scalafx.scene.image.WritableImage
import scalafx.scene.input.TransferMode
import scalafx.scene.input.Dragboard

object Scene {
  implicit def sfxScene2jfx(v: Scene) = v.delegate
}

/**
 * Wraps [[http://docs.oracle.com/javafx/2/api/javafx/scene/Scene.html]].
 *
 * @constructor Create a new ScalaFX Scene with JavaFX Scene as delegate.
 * @param delegate JavaFX Scene delegated. Its default value is a JavaFX Scene with a
 * [[http://docs.oracle.com/javafx/2/api/javafx/scene/Group.html Group]] as root Node.
 */
class Scene(override val delegate: jfxs.Scene = new jfxs.Scene(new jfxs.Group()))
  extends SFXDelegate[jfxs.Scene] {

  /**
   * Creates a Scene with a [[http://docs.oracle.com/javafx/2/api/javafx/scene/Group.html Group]] as root Node with a
   * specific size.
   *
   * @param width The width of the scene
   * @param height The height of the scene
   */
  def this(width: Double, height: Double) = this(new jfxs.Scene(new jfxs.Group(), width, height))

  /**
   * Creates a Scene for a specific root Node.
   *
   * @param parent The root node of the scene graph
   */
  def this(parent: Parent) = this(new jfxs.Scene(parent))

  /**
   * Creates a Scene for a specific root Node with a specific size.
   *
   * @param parent The root node of the scene graph
   * @param width The width of the scene
   * @param height The height of the scene
   */
  def this(parent: Parent, width: Double, height: Double) = this(new jfxs.Scene(parent, width, height))

  /**
   * Creates a Scene for a specific root Node with a specific size.
   *
   * @param parent The root node of the scene graph
   * @param width The width of the scene
   * @param height The height of the scene
   */
  def this(parent: Parent, width: Double, height: Double, depthBuffer: Boolean) = this(new jfxs.Scene(parent, width, height, depthBuffer))
  //def this(stackPane: jfxsl.StackPane) = this (new jfxs.Scene(stackPane))

  //def this(stackPane: jfxsl.StackPane, width: Double, height: Double) = this (new jfxs.Scene(stackPane, width, height))

  /**
   * Returns the root Node of the scene graph
   */
  def root: ObjectProperty[jfxs.Parent] = delegate.rootProperty

  /**
   * Sets the root Node of the scene graph
   */
  def root_=(v: Parent) {
    root() = v
  }

  /**
   * Returns Nodes children from this Scene's `root`.
   */
  def getChildren = root.value match {
    case group: jfxs.Group => group.getChildren
    case pane: jfxsl.Pane  => pane.getChildren
    case _                 => throw new IllegalStateException("Cannot access children of root: " + root + "\nUse a class that extends Group or Pane, or override the getChildren method.")
  }

  /**
   * Returns Content's Node children from this Scene's `root`.
   */
  def content: jfxc.ObservableList[jfxs.Node] = getChildren

  /**
   * Sets the list of Nodes children from this Scene's `root`, replacing the prior content. If you want append to
   * current content, use `add` or similar.
   *
   * @param c list of Nodes children from this Scene's `root` to replace prior content.
   */
  def content_=(c: Iterable[Node]) {
    fillSFXCollection(this.content, c)
  }

  /**
   * Sets a Node child, replacing the prior content. If you want append to current content, use `add` or similar.
   *
   * @param n Node child to replace prior content.
   */
  def content_=(n: Node) {
    fillSFXCollectionWithOne(this.content, n)
  }

  /**
   * Specifies the type of camera use for rendering this `Scene`.
   */
  def camera: ObjectProperty[jfxs.Camera] = delegate.cameraProperty
  def camera_=(v: Camera) {
    camera() = v
  }

  /**
   * Defines the mouse cursor for this `Scene`.
   */
  def cursor: ObjectProperty[jfxs.Cursor] = delegate.cursorProperty
  def cursor_=(v: Cursor) {
    cursor() = v
  }

  /**
   * Specifies the event dispatcher for this scene.
   */
  def eventDispatcher: ObjectProperty[jfxe.EventDispatcher] = delegate.eventDispatcherProperty
  def eventDispatcher_=(v: jfxe.EventDispatcher) {
    eventDispatcher() = v
  }

  /**
   * Defines the background fill of this Scene.
   */
  def fill: ObjectProperty[jfxsp.Paint] = delegate.fillProperty
  def fill_=(v: Paint) {
    fill() = v
  }

  /**
   * The height of this Scene
   */
  def height: ReadOnlyDoubleProperty = delegate.heightProperty

  /**
   * The width of this Scene
   */
  def width: ReadOnlyDoubleProperty = delegate.widthProperty

  /**
   * Defines a function to be called when a mouse button has been clicked (pressed and released) on this `Scene`.
   */
  def onContextMenuRequested = delegate.onContextMenuRequestedProperty
  def onContextMenuRequested_=(v: jfxe.EventHandler[_ >: jfxsi.ContextMenuEvent]) {
    onContextMenuRequested() = v
  }

  /**
   * Defines a function to be called when drag gesture has been detected.
   */
  def onDragDetected = delegate.onDragDetectedProperty
  def onDragDetected_=(v: jfxe.EventHandler[_ >: jfxsi.MouseEvent]) {
    onDragDetected() = v
  }

  /**
   * Defines a function to be called when this `Scene` is a drag and drop gesture source after its data has been
   * dropped on a drop target.
   */
  def onDragDone = delegate.onDragDoneProperty
  def onDragDone_=(v: jfxe.EventHandler[_ >: jfxsi.DragEvent]) {
    onDragDone() = v
  }

  /**
   * Defines a function to be called when the mouse button is released on this `Scene` during drag and drop gesture.
   */
  def onDragDropped = delegate.onDragDroppedProperty
  def onDragDropped_=(v: jfxe.EventHandler[_ >: jfxsi.DragEvent]) {
    onDragDropped() = v
  }

  /**
   * Defines a function to be called when drag gesture enters this Scene.
   */
  def onDragEntered = delegate.onDragEnteredProperty
  def onDragEntered_=(v: jfxe.EventHandler[_ >: jfxsi.DragEvent]) {
    onDragEntered() = v
  }

  /**
   * Defines a function to be called when drag gesture exits this Scene.
   */
  def onDragExited = delegate.onDragExitedProperty
  def onDragExited_=(v: jfxe.EventHandler[_ >: jfxsi.DragEvent]) {
    onDragExited() = v
  }

  /**
   * Defines a function to be called when drag gesture progresses within this `Scene`.
   */
  def onDragOver = delegate.onDragOverProperty
  def onDragOver_=(v: jfxe.EventHandler[_ >: jfxsi.DragEvent]) {
    onDragOver() = v
  }

  /**
   * Defines a function to be called when this `Node` has input focus and the input method text has changed.
   */
  def onInputMethodTextChanged = delegate.onInputMethodTextChangedProperty
  def onInputMethodTextChanged_=(v: jfxe.EventHandler[_ >: jfxsi.InputMethodEvent]) {
    onInputMethodTextChanged() = v
  }

  /**
   * Defines a function to be called when some `Node` of this `Scene` has input focus and a key has been pressed.
   */
  def onKeyPressed = delegate.onKeyPressedProperty
  def onKeyPressed_=(v: jfxe.EventHandler[_ >: jfxsi.KeyEvent]) {
    onKeyPressed() = v
  }

  /**
   * Defines a function to be called when some `Node` of this `Scene` has input focus and a key has been released.
   */
  def onKeyReleased = delegate.onKeyReleasedProperty
  def onKeyReleased_=(v: jfxe.EventHandler[_ >: jfxsi.KeyEvent]) {
    onKeyReleased() = v
  }

  /**
   * Defines a function to be called when some `Node` of this `Scene` has input focus and a key has been typed.
   */
  def onKeyTyped = delegate.onKeyTypedProperty
  def onKeyTyped_=(v: jfxe.EventHandler[_ >: jfxsi.KeyEvent]) {
    onKeyTyped() = v
  }

  /**
   * Defines a function to be called when a mouse button has been clicked (pressed and released) on this `Scene`.
   */
  def onMouseClicked = delegate.onMouseClickedProperty
  def onMouseClicked_=(v: jfxe.EventHandler[_ >: jfxsi.MouseEvent]) {
    onMouseClicked() = v
  }

  /**
   * Defines a function to be called when a mouse button is pressed on this `Scene` and then dragged.
   */
  def onMouseDragged = delegate.onMouseDraggedProperty
  def onMouseDragged_=(v: jfxe.EventHandler[_ >: jfxsi.MouseEvent]) {
    onMouseDragged() = v
  }

  /**
   * Defines a function to be called when a full press-drag-release gesture enters this `Scene`.
   */
  def onMouseDragEntered = delegate.onMouseDragEnteredProperty
  def onMouseDragEntered_=(v: jfxe.EventHandler[_ >: jfxsi.MouseEvent]) {
    onMouseDragEntered() = v
  }

  /**
   * Defines a function to be called when a full press-drag-release gesture exits this `Scene`.
   */
  def onMouseDragExited = delegate.onMouseDragExitedProperty
  def onMouseDragExited_=(v: jfxe.EventHandler[_ >: jfxsi.MouseEvent]) {
    onMouseDragExited() = v
  }

  /**
   * Defines a function to be called when a full press-drag-release gesture progresses within this `Scene`.
   */
  def onMouseDragOver = delegate.onMouseDragOverProperty
  def onMouseDragOver_=(v: jfxe.EventHandler[_ >: jfxsi.MouseEvent]) {
    onMouseDragOver() = v
  }

  /**
   * Defines a function to be called when a full press-drag-release gesture ends within this `Scene`.
   */
  def onMouseDragReleased = delegate.onMouseDragReleasedProperty
  def onMouseDragReleased_=(v: jfxe.EventHandler[_ >: jfxsi.MouseEvent]) {
    onMouseDragReleased() = v
  }

  /**
   * Defines a function to be called when the mouse enters this `Scene`.
   */
  def onMouseEntered = delegate.onMouseEnteredProperty
  def onMouseEntered_=(v: jfxe.EventHandler[_ >: jfxsi.MouseEvent]) {
    onMouseEntered() = v
  }

  /**
   * Defines a function to be called when the mouse exits this `Scene`.
   */
  def onMouseExited = delegate.onMouseExitedProperty
  def onMouseExited_=(v: jfxe.EventHandler[_ >: jfxsi.MouseEvent]) {
    onMouseExited() = v
  }

  /**
   * Defines a function to be called when mouse cursor moves within this `Scene` but no buttons have been pushed.
   */
  def onMouseMoved = delegate.onMouseMovedProperty
  def onMouseMoved_=(v: jfxe.EventHandler[_ >: jfxsi.MouseEvent]) {
    onMouseMoved() = v
  }

  /**
   * Defines a function to be called when a mouse button has been pressed on this `Scene`.
   */
  def onMousePressed = delegate.onMousePressedProperty
  def onMousePressed_=(v: jfxe.EventHandler[_ >: jfxsi.MouseEvent]) {
    onMousePressed() = v
  }

  /**
   * Defines a function to be called when a mouse button has been released on this `Scene`.
   */
  def onMouseReleased = delegate.onMouseReleasedProperty
  def onMouseReleased_=(v: jfxe.EventHandler[_ >: jfxsi.MouseEvent]) {
    onMouseReleased() = v
  }

  /**
   * Defines a function to be called when user performs a scrolling action.
   */
  def onScroll = delegate.onScrollProperty
  def onScroll_=(v: jfxe.EventHandler[_ >: jfxsi.ScrollEvent]) {
    onScroll() = v
  }

  /**
   * The `Window` for this Scene
   */
  def window: ReadOnlyObjectProperty[javafx.stage.Window] = delegate.windowProperty

  /**
   * The horizontal location of this `Scene` on the `Window`.
   */
  def x: ReadOnlyDoubleProperty = delegate.xProperty

  /**
   * The vertical location of this `Scene` on the `Window`.
   */
  def y: ReadOnlyDoubleProperty = delegate.yProperty

  /**
   * Retrieves the depth buffer attribute for this scene.
   */
  def depthBuffer = delegate.isDepthBuffer

  /**
   * Gets an observable list of string URLs linking to the stylesheets to use with this Parent's contents.
   */
  def stylesheets: jfxc.ObservableList[String] = delegate.getStylesheets

  /**
   * Sets the list of stylesheets URLs, replacing the prior content. If you want append to current content, use `add` or
   * similar.
   *
   * @param c list of stylesheets URLs to replace prior content.
   */
  def stylesheets_=(c: Iterable[String]) {
    fillCollection(stylesheets, c)
  }

  /**
   * Looks for any node within the scene graph based on the specified CSS selector.
   *
   * @param selector The css selector to look up
   * @return A [[scala.Some]] containing the Node in the scene which matches the CSS selector, or [[scala.None]]
   * if none is found.
   */
  def lookup(selector: String): Option[Node] = Option(delegate.lookup(selector))

  /**
   * Registers the specified mnemonic.
   *
   * @param m The Mnemonic
   */
  def addMnemonic(m: Mnemonic) {
    delegate.addMnemonic(m)
  }

  /**
   * Unregisters the specified mnemonic.
   *
   * @param m The Mnemonic to be removed.
   */
  def removeMnemonic(m: Mnemonic) {
    delegate.removeMnemonic(m)
  }

  /**
   * Gets the list of mnemonics for this `Scene`.
   */
  def getMnemonics: jfxc.ObservableMap[jfxsi.KeyCombination, jfxc.ObservableList[jfxsi.Mnemonic]] = delegate.getMnemonics

  /**
   * Gets the list of accelerators for this Scene.
   */
  def accelerators: jfxc.ObservableMap[jfxsi.KeyCombination, Runnable] = delegate.getAccelerators

  /**
   * Confirms a potential drag and drop gesture that is recognized over this `Scene`.
   *
   * @param  transferModes The supported `TransferMode`(s) of this `Node`
   * @return A `Dragboard` to place this `Scene`'s data on
   */
  def startDragAndDrop(transferModes: TransferMode*): Dragboard =
    delegate.startDragAndDrop(transferModes.map(_.delegate): _*)

  /**
   * Starts a full press-drag-release gesture with this scene as gesture source.
   */
  def startFullDrag() {
    delegate.startFullDrag()
  }

  /**
   * The scene's current focus owner node. This node's "focused" variable might be false if this scene has no window,
   * or if the window is inactive (window.focused == false).
   *
   * @since 2.2
   */
  def focusOwner: ReadOnlyObjectProperty[jfxs.Node] = delegate.focusOwnerProperty()

  /**
   * Defines a function to be called when user performs a rotation action.
   *
   * @since 2.2
   */
  def onRotate = delegate.onRotateProperty
  def onRotate_=(v: jfxe.EventHandler[jfxsi.RotateEvent]) {
    onRotate() = v
  }

  /**
   * Defines a function to be called when a rotation gesture ends.
   *
   * @since 2.2
   */
  def onRotationFinished = delegate.onRotationFinishedProperty()
  def onRotationFinished_=(v: jfxe.EventHandler[jfxsi.RotateEvent]) {
    onRotationFinished() = v
  }

  /**
   * Defines a function to be called when a rotation gesture starts.
   *
   * @since 2.2
   */
  def onRotationStarted = delegate.onRotationFinishedProperty()
  def onRotationStarted_=(v: jfxe.EventHandler[jfxsi.RotateEvent]) {
    onRotationStarted() = v
  }

  /**
   * Defines a function to be called when a Scroll gesture ends.
   *
   * @since 2.2
   */
  def onScrollFinished = delegate.onScrollFinishedProperty()
  def onScrollFinished_=(v: jfxe.EventHandler[jfxsi.ScrollEvent]) {
    onScrollFinished() = v
  }

  /**
   * Defines a function to be called when a Scroll gesture starts.
   *
   * @since 2.2
   */
  def onScrollStarted = delegate.onScrollStartedProperty()
  def onScrollStarted_=(v: jfxe.EventHandler[jfxsi.ScrollEvent]) {
    onScrollStarted() = v
  }

  /**
   * Defines a function to be called when a Swipe Down gesture starts.
   *
   * @since 2.2
   */
  def onSwipeDown = delegate.onSwipeDownProperty()
  def onSwipeDown_=(v: jfxe.EventHandler[jfxsi.SwipeEvent]) {
    onSwipeDown() = v
  }

  /**
   * Defines a function to be called when a Swipe Down gesture starts.
   *
   * @since 2.2
   */
  def onSwipeLeft = delegate.onSwipeLeftProperty()
  def onSwipeLeft_=(v: jfxe.EventHandler[jfxsi.SwipeEvent]) {
    onSwipeLeft() = v
  }

  /**
   * Defines a function to be called when a Swipe Up gesture starts.
   *
   * @since 2.2
   */
  def onSwipeUp = delegate.onSwipeUpProperty()
  def onSwipeUp_=(v: jfxe.EventHandler[jfxsi.SwipeEvent]) {
    onSwipeUp() = v
  }

  /**
   * Defines a function to be called when a Swipe Right gesture starts.
   *
   * @since 2.2
   */
  def onSwipeRight = delegate.onSwipeRightProperty()
  def onSwipeRight_=(v: jfxe.EventHandler[jfxsi.SwipeEvent]) {
    onSwipeRight() = v
  }

  /**
   * Defines a function to be called when user performs a Touch action.
   *
   * @since 2.2
   */
  def onZoom = delegate.onZoomProperty()
  def onZoom_=(v: jfxe.EventHandler[jfxsi.ZoomEvent]) {
    onZoom() = v
  }

  /**
   * Defines a function to be called when a Zoom gesture ends.
   *
   * @since 2.2
   */
  def onZoomFinished = delegate.onZoomFinishedProperty()
  def onZoomFinished_=(v: jfxe.EventHandler[jfxsi.ZoomEvent]) {
    onZoomFinished() = v
  }

  /**
   * Defines a function to be called when a Zoom gesture starts.
   *
   * @since 2.2
   */
  def onZoomStarted = delegate.onZoomStartedProperty()
  def onZoomStarted_=(v: jfxe.EventHandler[jfxsi.ZoomEvent]) {
    onZoomStarted() = v
  }

  /**
   * Defines a function to be called when user performs a Touch Moved action.
   *
   * @since 2.2
   */
  def onTouchMoved = delegate.onTouchMovedProperty()
  def onTouchMoved_=(v: jfxe.EventHandler[jfxsi.TouchEvent]) {
    onTouchMoved() = v
  }

  /**
   * Defines a function to be called when user performs a Touch Pressed action.
   *
   * @since 2.2
   */
  def onTouchPressed = delegate.onTouchPressedProperty()
  def onTouchPressed_=(v: jfxe.EventHandler[jfxsi.TouchEvent]) {
    onTouchPressed() = v
  }

  /**
   * Defines a function to be called when user performs a Touch Released action.
   *
   * @since 2.2
   */
  def onTouchReleased = delegate.onTouchPressedProperty()
  def onTouchReleased_=(v: jfxe.EventHandler[jfxsi.TouchEvent]) {
    onTouchReleased() = v
  }

  /**
   * Defines a function to be called when user performs a Touch Stationary action.
   *
   * @since 2.2
   */
  def onTouchStationary = delegate.onTouchStationaryProperty()
  def onTouchStationary_=(v: jfxe.EventHandler[jfxsi.TouchEvent]) {
    onTouchStationary() = v
  }

  /**
   * Takes a snapshot of this scene and returns the rendered image when it is ready.
   *
   * @param image The writable image that will be used to hold the rendered scene.
   * @return the rendered image
   *
   * @since 2.2
   */
  def snapshot(image: WritableImage): WritableImage = delegate.snapshot(image)

  /**
   * Takes a snapshot of this scene at the next frame and calls the specified callback method when the image is ready.
   *
   * @param callback A function to be called  when the image is ready.
   * @param image The writable image that will be used to hold the rendered scene.
   *
   * @since 2.2
   */
  def snapshot(callback: SnapshotResult => Unit, image: WritableImage) {
    val javaCallback = new jfxu.Callback[jfxs.SnapshotResult, java.lang.Void] {
      def call(result: jfxs.SnapshotResult): java.lang.Void = {
        callback(new SnapshotResult(result))
        null
      }
    }
    delegate.snapshot(javaCallback, image)
  }

}