/*
 * Copyright (c) 2011-2014, ScalaFX Project
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

import javafx.collections.ObservableList

import scala.language.implicitConversions
import scalafx.Includes._
import scalafx.beans.property._

import javafx.scene.{control => jfxsc}
import javafx.{event => jfxe, util => jfxu}

import scalafx.delegate.SFXDelegate
import scalafx.event.Event
import scalafx.scene.Node


object TreeTableView {
  implicit def sfxTreeTableView2jfx[T](v: TreeTableView[T]) = if (v != null) v.delegate else null

  object EditEvent {
    implicit def sfxTreeTableViewEditEvent2jfx[T](v: EditEvent[T]) = if (v != null) v.delegate else null
  }

  class EditEvent[T](override val delegate: jfxsc.TreeTableView.EditEvent[T])
    extends Event(delegate)
    with SFXDelegate[jfxsc.TreeTableView.EditEvent[T]] {

    /**
     * Creates a new EditEvent instance to represent an edit event.
     */
    def this(source: TreeTableView[T], eventType: jfxe.EventType[_ <: jfxsc.TreeTableView.EditEvent[T]], treeTableItem: TreeItem[T], oldValue: T, newValue: T) =
      this(new jfxsc.TreeTableView.EditEvent[T](source, eventType, treeTableItem, oldValue, newValue))

    /**
     * Returns the new value input into the TreeItem by the end user.
     */
    def newValue: T = delegate.getNewValue

    /**
     * Returns the old value that existed in the TreeItem prior to the current edit event.
     */
    def oldValue: T = delegate.getOldValue

    /**
     * Returns the TreeView upon which the edit took place.
     */
    override def source: TreeTableView[T] = delegate.getSource

    /**
     * Returns the `TreeItem` upon which the edit took place.
     */
    def treeItem: TreeItem[T] = delegate.getTreeItem

  }
  /**
   * An EventType that indicates some edit event has occurred.
   */
  def editAnyEvent = jfxsc.TreeTableView.editAnyEvent

  /**
   * An EventType used to indicate that an edit event has just been canceled
   * within the TreeView upon which the event was fired.
   */
  def editCancelEvent = jfxsc.TreeTableView.editCancelEvent

  /**
   * An EventType that is used to indicate that an edit in a TreeView has been
   *  committed.
   */
  def editCommitEvent = jfxsc.TreeTableView.editCommitEvent

  /**
   * An EventType used to indicate that an edit event has started within the
   * TreeView upon which the event was fired.
   */
  def editStartEvent = jfxsc.TreeTableView.editStartEvent

  /**
   * Returns the number of levels of 'indentation' of the given TreeItem,
   * based on how many times getParent() can be recursively called.
   */
  def nodeLevel(node: TreeItem[_]) = jfxsc.TreeTableView.getNodeLevel(node)

  /**
   * Creates a new TreeView overriding layoutChildren method from JavaFX's
   * TreeView.
   */
  def apply[T](layoutChildren: => Unit) = new TreeTableView[T](new jfxsc.TreeTableView[T] {
    override def layoutChildren() = layoutChildren()
  })


  object TreeTableViewFocusModel {

    /**
     * Converts a ScalaFX TableViewFocusModel instance to its JavaFX counterpart.
     *
     * @param tvfm ScalaFX TableViewFocusModel
     * @return JavaFX TableViewFocusModel
     */
    implicit def sfxTableViewFocusModel2jfx[S](tvfm: TreeTableViewFocusModel[S]) =
      if (tvfm != null) tvfm.delegate else null

  }

  /**
   * $WRAPSTA$TV.$TVFM.html $TVFM$WRAPEND
   *
   * @constructor $CONSSTA $TVFM $CONSEND
   * @param delegate $JFX $TVFM $CONSPARAM
   */
  class TreeTableViewFocusModel[S](override val delegate: jfxsc.TreeTableView.TreeTableViewFocusModel[S])
    extends TableFocusModel[jfxsc.TreeItem[S], jfxsc.TreeTableColumn[S, _]](delegate)
    with SFXDelegate[jfxsc.TreeTableView.TreeTableViewFocusModel[S]] {

   def this(treeTableView: TreeTableView[S]) = this(new jfxsc.TreeTableView.TreeTableViewFocusModel(treeTableView))

    /**
     * The position of the current item in the TableView which has the focus.
     */
    def focusedCell: ReadOnlyObjectProperty[jfxsc.TreeTablePosition[S, _]] = delegate.focusedCellProperty

    def focus(index: Int, column: TreeTableColumn[S, _]) {
      delegate.focus(index, column)
    }

    /**
     * Convenience method for setting focus on a particular row or cell using a
     * [[scalafx.scene.control.TablePosition]].
     *
     * @param pos The table position where focus should be set.
     */
    def focus(pos: TreeTablePosition[S, _]) {
      delegate.focus(pos)
    }

  }

}


class TreeTableView[T](override val delegate: jfxsc.TreeTableView[T] = new jfxsc.TreeTableView[T])
  extends Control(delegate)
  with SFXDelegate[jfxsc.TreeTableView[T]] {



  object TreeTableViewSelectionModel {
    implicit def sfxTreeTableViewSelectionModel2jfx(v: TreeTableView[T]#TreeTableViewSelectionModel) = v.delegate
  }


  class TreeTableViewSelectionModel(override val delegate: jfxsc.TreeTableView.TreeTableViewSelectionModel[T])
    extends SFXDelegate[jfxsc.TreeTableView.TreeTableViewSelectionModel[T]] {

  }



  /**
   * Creates a TreeTableView with the provided root node.
   */
  def this(rootItem: TreeItem[T]) = this(new TreeTableView[T](rootItem))

  //ObjectProperty<Callback<TreeTableView.ResizeFeatures,Boolean>>	columnResizePolicy
  // ReadOnlyObjectProperty<Comparator<TreeItem<S>>>	comparator

  /**
   * Specifies whether this TreeView is editable - only if the TreeView and
   * the TreeCells within it are both editable will a TreeCell be able to go
   * into their editing state.
   */

  def editable = delegate.editableProperty
  def editable_=(v: Boolean) {
    editable() = v
  }

  def editingCell : ReadOnlyObjectProperty[jfxsc.TreeTablePosition[T,_]] = delegate.editingCellProperty

  def expandedItemCount: ReadOnlyIntegerProperty = delegate.expandedItemCountProperty

  def fixedCellSize = delegate.fixedCellSizeProperty
  def fixedCellSize_=(v: Double) {
    fixedCellSize() = v
  }



  /**
   * The FocusModel provides the API through which it is possible to control
   * focus on zero or one rows of the TreeView.
   */
  def focusModel = delegate.focusModelProperty
  def focusModel_=(v: TreeTableView.TreeTableViewFocusModel[T]) {
    focusModel() = v
  }

  def onScrollToColumn = delegate.onScrollToColumnProperty()
  def onScrollToColumn_=(v: jfxe.EventHandler[jfxsc.ScrollToEvent[jfxsc.TreeTableColumn[T,_]]])= {
    onScrollToColumn() = v
  }


  def onScrollTo = delegate.onScrollToProperty()
  def onScrollTo_=(v: jfxe.EventHandler[jfxsc.ScrollToEvent[Integer]])= {
    onScrollTo() = v
  }

  def onSort = delegate.onSortProperty()
  def onSort_=(v: jfxe.EventHandler[jfxsc.SortEvent[jfxsc.TreeTableView[T]]])= {
    onSort() = v
  }

  def placeholder = delegate.placeholderProperty
  def placeholder_=(v: Node) {
    placeholder() = v
  }

  /**
   * Property representing the root node of the TreeView.
   */
  def root = delegate.rootProperty
  def root_=(v: TreeItem[T]) {
    root() = v
  }

  def rowFactory = delegate.rowFactoryProperty
  def rowFactory_=(v: (TreeTableView[T] => TreeTableRow[T]) ) {
    rowFactory() = new jfxu.Callback[jfxsc.TreeTableView[T], jfxsc.TreeTableRow[T]] {
      def call(tv: jfxsc.TreeTableView[T]): jfxsc.TreeTableRow[T] = {
        v(tv)
      }
    }
  }

  /**
   *
   */
  def selectionModel = delegate.selectionModelProperty
  def selectionModel_=(v: TreeTableViewSelectionModel) {
    selectionModel() = v
  }

  /**
   * Property that represents whether or not the TreeView root node is visible.
   */
  def showRoot = delegate.showRootProperty
  def showRoot_=(v: Boolean) {
    showRoot() = v
  }

  def sortMode = delegate.sortModeProperty
  def sortMode_=(v: TreeSortMode): Unit = {
    sortMode() = v
  }

  /*
  def sortPolicy = delegate.sortPolicyProperty
  def sortPolicy_=(v: (TreeTableView[T] => Boolean) ) {
    sortPolicy() = new jfxu.Callback[jfxsc.TreeTableView[T], Boolean] {
      def call(tv: jfxsc.TreeTableView[T]): Boolean = {
        v(tv)
      }
    }
  }
  */

  def tableMenuButtonVisible = delegate.tableMenuButtonVisibleProperty
  def tableMenuButtonVisible_=(v: Boolean) {
    tableMenuButtonVisible() = v
  }



  /**
   * Instructs the TreeView to begin editing the given TreeItem, if the
   * TreeView is `editable`.
   */
  def edit(row: Int, item: TreeTableColumn[T, _]) = delegate.edit(row, item)

  /**
   * Returns the index position of the given TreeItem, taking into account the
   * current state of each TreeItem (i.e. whether or not it is expanded).
   */
  def row(item: TreeItem[T]) = delegate.getRow(item)

  def treeColumn = delegate.treeColumnProperty
  def treeColumn_=(v: TreeTableColumn[T, _]) {
    treeColumn() = v
  }

  def columns: ObservableList[jfxsc.TreeTableColumn[T, _]] = delegate.getColumns

}