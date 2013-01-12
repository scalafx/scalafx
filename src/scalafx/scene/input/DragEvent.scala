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
package scalafx.scene.input

import javafx.scene.{ input => jfxsi }
import javafx.{ event => jfxe }
import scalafx.delegate.SFXDelegate
import scalafx.event.Event

object DragEvent {
  implicit def sfxDragEvent2jfx(de: DragEvent) = de.delegate

  /**
   * Common supertype for all drag event types.
   */
  val Any = jfxsi.DragEvent.ANY

  /**
   * This event occurs on drag-and-drop gesture source after its data has been dropped on a drop target.
   */
  val DragDone = jfxsi.DragEvent.DRAG_DONE

  /**
   * This event occurs when the mouse button is released during drag and drop gesture on a drop target.
   */
  val DragDropped = jfxsi.DragEvent.DRAG_DROPPED

  /**
   * This event occurs when drag gesture enters a node.
   */
  val DragEntered = jfxsi.DragEvent.DRAG_ENTERED

  /**
   * This event occurs when drag gesture enters a node.
   */
  val DragEnteredTarget = jfxsi.DragEvent.DRAG_ENTERED_TARGET

  /**
   * This event occurs when drag gesture exits a node.
   */
  val DragExited = jfxsi.DragEvent.DRAG_EXITED

  /**
   * This event occurs when drag gesture exits a node.
   */
  val DragExitedTarget = jfxsi.DragEvent.DRAG_EXITED_TARGET

  /**
   * This event occurs when drag gesture progresses within this node.
   */
  val DragOver = jfxsi.DragEvent.DRAG_OVER

}

class DragEvent(override val delegate: jfxsi.DragEvent) extends InputEvent(delegate) with SFXDelegate[jfxsi.DragEvent] {

  /**
   * Accepts this DragEvent, choosing the transfer mode for the drop operation.
   */
  def acceptTransferModes(transferModes: jfxsi.TransferMode*) = delegate.acceptTransferModes(transferModes: _*)

  /**
   * Gets transfer mode accepted by potential target.
   */
  def acceptedTransferMode = delegate.getAcceptedTransferMode

  /**
   * A dragboard that is available to transfer data.
   */
  def dragboard = delegate.getDragboard

  /**
   * The source object of the drag and drop gesture.
   */
  def gestureSource = delegate.getGestureSource

  /**
   * The target object of the drag and drop gesture.
   */
  def gestureTarget = delegate.getGestureSource

  /**
   * Returns horizontal position of the event relative to the origin of the Scene that contains the DragEvent's source.
   */
  def sceneX = delegate.getSceneX

  /**
   * Returns vertical position of the event relative to the origin of the Scene that contains the DragEvent's source.
   */
  def sceneY = delegate.getSceneY

  /**
   * Returns absolute horizontal position of the event.
   */
  def screenX = delegate.getScreenX

  /**
   * Returns absolute vertical position of the event.
   */
  def screenY = delegate.getScreenY

  /**
   * Data transfer mode.
   */
  def transferMode = delegate.getTransferMode

  /**
   * Horizontal position of the event relative to the origin of the DragEvent's source.
   */
  def x = delegate.getX

  /**
   * Vertical position of the event relative to the origin of the DragEvent's source.
   */
  def y = delegate.getY

  /**
   * Indicates if this event has been accepted.
   */
  def accepted = delegate.isAccepted

  /**
   * Whether setDropCompleted(true) has been called on this event.
   */
  def dropCompleted = delegate.isDropCompleted
  /**
   * Indicates that transfer handling of this DragEvent was completed successfully during a DRAG_DROPPED event handler.
   */
  def dropCompleted_=(isTransferDone: Boolean) {
    delegate.setDropCompleted(isTransferDone)
  }

}
/*
Event	copyFor(java.lang.Object newSource, EventTarget newTarget)
Creates and returns a copy of this event with the specified event source and target.
*/