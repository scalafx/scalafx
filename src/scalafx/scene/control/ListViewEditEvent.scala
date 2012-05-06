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
import javafx.{ event => jfxe }
import javafx.{ geometry => jfxg }
import javafx.{ util => jfxu }
import scalafx.Includes._
import scalafx.collections.ObservableBuffer
import scalafx.event.Event
import scalafx.util.SFXDelegate

object _ListView {
  implicit def sfxListView2jfx[T](l: ListView[T]) = l.delegate

  object _EditEvent {
    implicit def sfxEditEvent2jfx[T](e: EditEvent[T]) = e.delegate
  }

  class EditEvent[T](override val delegate: jfxsc.ListView.EditEvent[T])
    extends Event(delegate)
    with SFXDelegate[jfxsc.ListView.EditEvent[T]] {

    /**
     * Creates a new EditEvent instance to represent an edit event. This event is used for
     * ListView.EDIT_START_EVENT, ListView.EDIT_COMMIT_EVENT and ListView.EDIT_CANCEL_EVENT types.
     */
    def this(source: ListView[T], eventType: jfxe.EventType[_ <: jfxsc.ListView.EditEvent[T]], newValue: T, editIndex: Int) =
      this(new jfxsc.ListView.EditEvent[T](source, eventType, newValue, editIndex))

    /**
     * Returns the ListView upon which the edit took place.
     */
    def source = delegate.getSource()

    /**
     * Returns the value of the new input provided by the end user.
     */
    def newValue = delegate.getNewValue

    /**
     * Returns the index in which the edit took place.
     */
    def index = delegate.getIndex

  }

  /**
   * An EventType that indicates some edit event has occurred.
   */
  def editAnyEvent = jfxsc.ListView.editAnyEvent

  /**
   * An EventType used to indicate that an edit event has just been canceled within the ListView
   * upon which the event was fired.
   */
  def editCancelEvent = jfxsc.ListView.editCancelEvent

  /**
   * An EventType used to indicate that an edit event has been committed within the ListView
   * upon which the event was fired.
   */
  def editCommitEvent = jfxsc.ListView.editCommitEvent

  /**
   * An EventType used to indicate that an edit event has started within the ListView
   * upon which the event was fired.
   */
  def editStartEvent = jfxsc.ListView.editStartEvent
}

/**
 * @constructor Creates a default ListView which will display contents stacked vertically.
 */
class _ListView[T](override val delegate: jfxsc.ListView[T] = new jfxsc.ListView[T])
  extends Control(delegate)
  with SFXDelegate[jfxsc.ListView[T]] {

  /**
   * Creates a default ListView which will stack the contents retrieved from the provided
   * [[scalafx.collections.ObservableBuffer]] vertically.
   *
   */
  def this(items: ObservableBuffer[T]) = this(new jfxsc.ListView[T](items))

  /**
   * Creates a default ListView which will stack the contents retrieved from the provided
   * [[scala.Seq]] vertically.
   */
  def this(items: Seq[T]) = this(new jfxsc.ListView[T](ObservableBuffer.empty ++ items))

  /**
   * Setting a custom cell factory has the effect of deferring all cell creation, allowing for 
   * total customization of the cell.
   */
  def cellFactory = delegate.cellFactoryProperty
  def cellFactory_=(v: (ListView[T] => ListCell[T])) {
    cellFactory() = new jfxu.Callback[jfxsc.ListView[T], jfxsc.ListCell[T]] {
      def call(lv: jfxsc.ListView[T]) = {
        v(lv)
      }
    }
  }

  /**
   * Specifies whether this ListView is editable - only if the ListView and the ListCells within
   * it are both editable will a ListCell be able to go into their editing state.
   */
  def editable = delegate.editableProperty
  def editable_=(v: Boolean) {
    editable() = v
  }

  /**
   * A property used to represent the index of the item currently being edited in the ListView,
   * if editing is taking place, or -1 if no item is being edited.
   */
  def editingIndex = delegate.editingIndexProperty

  /**
   * The FocusModel provides the API through which it is possible to both get and set the focus on
   * a single item within a ListView.
   */
  def focusModel = delegate.focusModelProperty
  def focusModel_=(v: FocusModel[T]) {
    focusModel() = v
  }

  /**
   * The underlying data model for the ListView.
   */
  def items = delegate.itemsProperty
  def items_=(v: ObservableBuffer[T]) {
    items() = v
  }

  /**
   * This event handler will be fired when the user cancels editing a cell.
   */
  def onEditCancel = delegate.onEditCancelProperty
  def onEditCancel_=(v: jfxe.EventHandler[jfxsc.ListView.EditEvent[T]]) {
    onEditCancel() = v
  }

  /**
   * This property is used when the user performs an action that should result in their editing
   * input being persisted.
   */
  def onEditCommit = delegate.onEditCommitProperty
  def onEditCommit_=(v: jfxe.EventHandler[jfxsc.ListView.EditEvent[T]]) {
    onEditCommit() = v
  }

  /**
   * This event handler will be fired when the user successfully initiates editing.
   */
  def onEditStart = delegate.onEditStartProperty
  def onEditStart_=(v: jfxe.EventHandler[jfxsc.ListView.EditEvent[T]]) {
    onEditStart() = v
  }

  /**
   * The orientation of the ListView - this can either be horizontal or vertical.
   */
  def orientation = delegate.orientationProperty
  def orientation_=(v: jfxg.Orientation) {
    orientation() = v
  }

  /**
   * The SelectionModel provides the API through which it is possible to select single or multiple
   * items within a ListView, as well as inspect which items have been selected by the user.
   */
  def selectionModel = delegate.selectionModelProperty
  def selectionModel_=(v: MultipleSelectionModel[T]) {
    selectionModel() = v.delegate
  }

  /**
   * Instructs the ListView to begin editing the item in the given index, if the ListView is
   * editable.
   */
  def edit(itemIndex: Int) = delegate.edit(itemIndex)

  /**
   * Scrolls the ListView such that the item in the given index is visible to the end user.
   */
  def scrollTo(index: Int) = delegate.scrollTo(index)

}