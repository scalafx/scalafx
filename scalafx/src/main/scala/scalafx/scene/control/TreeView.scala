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
package scalafx.scene.control

import javafx.scene.{control => jfxsc}
import javafx.{event => jfxe}
import javafx.{util => jfxu}
import scalafx.Includes._
import scalafx.beans.property.BooleanProperty
import scalafx.beans.property.ObjectProperty
import scalafx.beans.property.ReadOnlyObjectProperty
import scalafx.event.Event
import scalafx.delegate.SFXDelegate

object TreeView {
  implicit def sfxTreeView2jfx[T](v: TreeView[T]) = v.delegate

  object EditEvent {
    implicit def sfxTreeViewEditEvent2jfx[T](v: EditEvent[T]) = v.delegate
  }
  
  class EditEvent[T](override val delegate: jfxsc.TreeView.EditEvent[T])
    extends Event(delegate)
    with SFXDelegate[jfxsc.TreeView.EditEvent[T]] {

    /**
     * Creates a new EditEvent instance to represent an edit event.
     */
    def this(source: TreeView[T], eventType: jfxe.EventType[_ <: jfxsc.TreeView.EditEvent[T]], treeItem: TreeItem[T], oldValue: T, newValue: T) =
      this(new jfxsc.TreeView.EditEvent[T](source, eventType, treeItem, oldValue, newValue))

    /**
     * Returns the new value input into the TreeItem by the end user.
     */
    def newValue : T = delegate.getNewValue

    /**
     * Returns the old value that existed in the TreeItem prior to the current edit event.
     */
    def oldValue : T = delegate.getOldValue

    /**
     * Returns the TreeView upon which the edit took place.
     */
    override def source : TreeView[T] = delegate.getSource

    /**
     * Returns the `TreeItem` upon which the edit took place.
     */
    def treeItem : TreeItem[T] = delegate.getTreeItem

  }

  /**
   * An EventType that indicates some edit event has occurred.
   */
  def editAnyEvent = jfxsc.TreeView.editAnyEvent

  /**
   * An EventType used to indicate that an edit event has just been canceled
   * within the TreeView upon which the event was fired.
   */
  def editCancelEvent = jfxsc.TreeView.editCancelEvent

  /**
   * An EventType that is used to indicate that an edit in a TreeView has been
   *  committed.
   */
  def editCommitEvent = jfxsc.TreeView.editCommitEvent

  /**
   * An EventType used to indicate that an edit event has started within the
   * TreeView upon which the event was fired.
   */
  def editStartEvent = jfxsc.TreeView.editStartEvent

  /**
   * Returns the number of levels of 'indentation' of the given TreeItem,
   * based on how many times getParent() can be recursively called.
   */
  def nodeLevel(node: TreeItem[_]) = jfxsc.TreeView.getNodeLevel(node)

  /**
   * Creates a new TreeView overriding layoutChildren method from JavaFX's
   * TreeView.
   */
  def apply[T](layoutChildrenOp:() => Unit) = new TreeView[T](new jfxsc.TreeView[T] {
    override def layoutChildren() {
      layoutChildrenOp()
    }
  })

}

class TreeView[T](override val delegate: jfxsc.TreeView[T] = new jfxsc.TreeView[T])
  extends Control(delegate)
  with SFXDelegate[jfxsc.TreeView[T]] {

  /**
   * Creates a TreeView with the provided root node.
   */
  def this(rootItem: TreeItem[T]) = this(new jfxsc.TreeView[T](rootItem))

  def cellFactory = delegate.cellFactoryProperty
  def cellFactory_=(v: (TreeView[T] => jfxsc.TreeCell[T])) {
    cellFactory() = new jfxu.Callback[jfxsc.TreeView[T], jfxsc.TreeCell[T]] {
      def call(tv: jfxsc.TreeView[T]): jfxsc.TreeCell[T] = {
        v(tv)
      }
    }
  }

  /**
   * Specifies whether this TreeView is editable - only if the TreeView and
   * the TreeCells within it are both editable will a TreeCell be able to go
   * into their editing state.
   */
  def editable: BooleanProperty = delegate.editableProperty
  def editable_=(v: Boolean) {
    editable() = v
  }

  /**
   * A property used to represent the TreeItem currently being edited in the
   * TreeView, if editing is taking place, or -1 if no item is being edited.
   */
  def editingItem: ReadOnlyObjectProperty[jfxsc.TreeItem[T]] = delegate.editingItemProperty

  /**
   * The FocusModel provides the API through which it is possible to control
   * focus on zero or one rows of the TreeView.
   */
  def focusModel: ObjectProperty[jfxsc.FocusModel[jfxsc.TreeItem[T]]] = delegate.focusModelProperty
  def focusModel_=(v: FocusModel[jfxsc.TreeItem[T]]) {
    focusModel() = v
  }

  /**
   * This event handler will be fired when the user cancels editing a cell.
   */
  def onEditCancel = delegate.onEditCancelProperty
  def onEditCancel_=(v: jfxe.EventHandler[jfxsc.TreeView.EditEvent[T]]) {
    onEditCancel() = v
  }

  /**
   * This event handler will be fired when the user commits editing a cell.
   */
  def onEditCommit = delegate.onEditCommitProperty
  def onEditCommit_=(v: jfxe.EventHandler[jfxsc.TreeView.EditEvent[T]]) {
    onEditCommit() = v
  }

  /**
   * This event handler will be fired when the user starts editing a cell.
   */
  def onEditStart = delegate.onEditStartProperty
  def onEditStart_=(v: jfxe.EventHandler[jfxsc.TreeView.EditEvent[T]]) {
    onEditStart() = v
  }

  /**
   * Property representing the root node of the TreeView.
   */
  def root: ObjectProperty[jfxsc.TreeItem[T]] = delegate.rootProperty
  def root_=(v: TreeItem[T]) {
    root() = v
  }

  /**
   *
   */
  def selectionModel: ObjectProperty[jfxsc.MultipleSelectionModel[jfxsc.TreeItem[T]]] = delegate.selectionModelProperty
  def selectionModel_=(v: MultipleSelectionModel[jfxsc.TreeItem[T]]) {
    selectionModel() = v
  }

  /**
   * Property that represents whether or not the TreeView root node is visible.
   */
  def showRoot: BooleanProperty = delegate.showRootProperty
  def showRoot_=(v: Boolean) {
    showRoot() = v
  }

  /**
   * Instructs the TreeView to begin editing the given TreeItem, if the
   * TreeView is `editable`.
   */
  def edit(item: TreeItem[T]) {
    delegate.edit(item)
  }

  /**
   * Returns the index position of the given TreeItem, taking into account the
   * current state of each TreeItem (i.e. whether or not it is expanded).
   */
  def row(item: TreeItem[T]) = delegate.getRow(item)

}
