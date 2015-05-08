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

import javafx.{css => jfxcss}
import javafx.scene.{control => jfxsc}
import javafx.{event => jfxe, util => jfxu}

import scala.language.implicitConversions
import scala.collection.JavaConversions._

import scalafx.Includes._
import scalafx.beans.property._
import scalafx.collections.ObservableBuffer
import scalafx.delegate.SFXDelegate
import scalafx.event.{EventType, Event, EventHandler}
import scalafx.scene.Node



/**
 * Object companion for [[scalafx.scene.control.TreeTableView]]
 */
object TreeTableView {

  /**
   * Converts a ScalaFX TreeTableView instance to its JavaFX counterpart.
   *
   * @param v ScalaFX TreeTableView
   * @return JavaFX TreeTableView
   */
  implicit def sfxTreeTableView2jfx[T](v: TreeTableView[T]) = if (v != null) v.delegate else null




  /************* ResizeFeatures *****************/

  /**
   * Object companion for [[scalafx.scene.control.TreeTableView.ResizeFeatures]]
   */
  object ResizeFeatures  {

    /**
     * Converts a ScalaFX ResizeFeatures instance to its JavaFX counterpart.
     *
     * @param rf ScalaFX TreeTableView.ResizeFeatures
     * @return JavaFX TreeTableView.ResizeFeatures
     */
    implicit def sfxTreeTableViewResizeFeatures2jfx[S](rf: ResizeFeatures[S]) = if (rf != null) rf.delegate else null

  }

  /**
   * Wraps a JavaFX [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/TreeTableView.ResizeFeatures.html]]
   *
   * @constructor Creates a new ScalaFX ResizeFeatures from its JavaFX counterpart.
   * @param delegate JavaFX ResizeFeatures to be wrapped.
   */
  class ResizeFeatures[S](override val delegate: jfxsc.TreeTableView.ResizeFeatures[S])
    extends ResizeFeaturesBase[jfxsc.TreeItem[S]](delegate)
    with SFXDelegate[jfxsc.TreeTableView.ResizeFeatures[S]] {

    type Delegate = jfxsc.TreeTableView.ResizeFeatures[S]

    /**
     * Creates an instance of this class, with the provided TreeTableView, TreeTableColumn and delta values
     * being set and stored in this immutable instance.
     *
     * @param table The TreeTableView upon which the resize operation is occurring.
     * @param column The column upon which the resize is occurring, or null if this ResizeFeatures instance is being
     *               created as a result of a TreeTableView resize operation.
     * @param delta The amount of horizontal space added or removed in the resize operation.
     */
    def this(table: TreeTableView[S], column: TreeTableColumn[S, _], delta: Double) =
      this(new jfxsc.TreeTableView.ResizeFeatures(table, column, delta))

    /**
     * Returns the TreeTableView upon which the resize operation is occurring.
     */
    def table: TreeTableView[S] = delegate.getTable

    /**
     * Returns the column upon which the resize is occurring, or null if this ResizeFeatures
     * instance was created as a result of a TreeTableView resize operation.
     */
    // TODO: override def column: TreeTableColumn[S,_] = delegate.getColumn

  }




  /************* EditEvent *****************/

  /**
   * Object companion for [[scalafx.scene.control.TreeTableView.EditEvent]]
   */
  object EditEvent  {
    /**
     * Converts a ScalaFX EditEvent instance to its JavaFX counterpart.
     *
     * @param v ScalaFX TreeTableView EditEvent
     * @return JavaFX TreeTableView EditEvent
     */
    implicit def sfxTreeTableViewEditEvent2jfx[T](v: EditEvent[T]) = if (v != null) v.delegate else null

    // TODO: correct?
    /**
     * Common supertype for all edit event types.
     */
    def ANY: jfxe.EventType[_] = jfxsc.TreeTableView.EditEvent.ANY
  }

  /**
   * Wraps a JavaFX [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/TreeTableView.EditEvent.html]]
   *
   * @constructor Creates a new ScalaFX EditEvent from its JavaFX counterpart.
   * @param delegate JavaFX EditEvent to be wrapped.
   */
  class EditEvent[T](override val delegate: jfxsc.TreeTableView.EditEvent[T])
    extends Event(delegate)
    with SFXDelegate[jfxsc.TreeTableView.EditEvent[T]] {

    type Delegate = jfxsc.TreeTableView.EditEvent[T]

    /**
     * Creates a new EditEvent instance to represent an edit event. This event is used for
     * TreeTableView.EDIT_START_EVENT, TreeTableView.EDIT_COMMIT_EVENT and
     * TreeTableView.EDIT_CANCEL_EVENT types.
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








  /************* TreeTableViewFocusModel *****************/

  /**
   * Object companion for [[scalafx.scene.control.TreeTableView.TreeTableViewFocusModel]]
   */
  object TreeTableViewFocusModel  {

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
   * Wraps a JavaFX [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/TreeTableView.TreeTableViewFocusModel.html]]
   *
   * @constructor Creates a new ScalaFX TreeTableViewFocusModel from its JavaFX counterpart.
   * @param delegate JavaFX TreeTableViewFocusModel to be wrapped.
   */
  class TreeTableViewFocusModel[S](override val delegate: jfxsc.TreeTableView.TreeTableViewFocusModel[S])
    extends TableFocusModel[jfxsc.TreeItem[S], jfxsc.TreeTableColumn[S, _]](delegate)
    with SFXDelegate[jfxsc.TreeTableView.TreeTableViewFocusModel[S]] {

    type Delegate = jfxsc.TreeTableView.TreeTableViewFocusModel[S]

    /**
     * Creates a default TableViewFocusModel instance that will be used to manage focus of the provided TableView control.
     *
     * @param treeTableView The tableView upon which this focus model operates.
     */
   def this(treeTableView: TreeTableView[S]) = this(new jfxsc.TreeTableView.TreeTableViewFocusModel(treeTableView))

    /**
     * The position of the current item in the TableView which has the focus.
     */
    def focusedCell: ReadOnlyObjectProperty[jfxsc.TreeTablePosition[S, _]] = delegate.focusedCellProperty

    /**
     * Causes the item at the given index to receive the focus.
     *
     * @param index The row index of the item to give focus to.
     * @param column The column of the item to give focus to. Can be null.
     */
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

    /**
     * Tests whether the row / cell at the given location currently has the focus within the TableView.
     *
     * @param row The row index of the item to be checked.
     * @param column The column index of the item to be checked.
     */
    def isFocused(row: Int, column: TreeTableColumn[S,_]): Boolean = delegate.isFocused(row, column)

    /**
     * Causes the item at the given index to receive the focus. This does not cause the current selection to change.
     * Updates the focusedItem and focusedIndex properties such that focusedIndex = -1 unless
     * 0 <= index < model size
     * .
     *
     * @param index The index of the item to get focus.
     */
    override def focus(index: Int) {
      delegate.focus(index)
    }

  }








  /************* TreeTableViewSelectionModel *****************/

  /**
   * Object companion for [[scalafx.scene.control.TreeTableView.TreeTableViewFocusModel]]
   */
  object TreeTableViewSelectionModel  {
    /**
     * Converts a ScalaFX TreeTableViewSelectionModel instance to its JavaFX counterpart.
     *
     * @param v ScalaFX TreeTableViewSelectionModel
     * @return JavaFX TreeTableViewSelectionModel
     */
    implicit def sfxTreeTableViewSelectionModel2jfx[S](v: TreeTableView.TreeTableViewSelectionModel[S]) = v.delegate
  }

  /**
   * Wraps a JavaFX [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/TreeTableView.TreeTableViewSelectionModel.html]]
   *
   * @constructor Creates a new TreeTableViewSelectionModel from a JavaFX one.
   * @param delegate A JavaFX TreeTableViewSelectionModel to be wrapped. Its default value is a new JavaFX TreeTableViewSelectionModel.
   * @since 8.0
   *
   */
  abstract class TreeTableViewSelectionModel[S](override val delegate: jfxsc.TreeTableView.TreeTableViewSelectionModel[S])
    extends SFXDelegate[jfxsc.TreeTableView.TreeTableViewSelectionModel[S]] {

    type Delegate = jfxsc.TreeTableView.TreeTableViewSelectionModel[S]

    /**
     * A read-only ObservableBuffer representing the currently selected cells in this TreeTableView. Rather than directly
     * modify this list, please use the other methods provided in the TreeTableViewSelectionModel.
     */
    def selectedCells: ObservableBuffer[TreeTablePosition[S,_]] =
      ObservableBuffer(delegate.getSelectedCells.map(ttp => new TreeTablePosition(ttp)))

    /**
     * Returns the TreeTableView instance that this selection model is installed in.
     */
    def treeTableView: TreeTableView[S] = delegate.getTreeTableView

    /**
     * Returns the item at the given index. An example using ListView would be listView.getItems().get(index).
     *
     * @param index The index of the item that is requested from the underlying data model.
     * @return Returns null if the index is out of bounds, or an element of type TreeItem[S] that is related to the given index.
     */
    def modelItem(index: Int): TreeItem[S] = delegate.getModelItem(index)


    def focus(row: Int) { delegate.focus(row) }

    def focusedIndex = delegate.getFocusedIndex

    /**
     * Selects the cells in the range (minRow, minColumn) to (maxRow, maxColumn), inclusive.
     */
    def selectRange(minRow: Int, minColumn: TableColumnBase[TreeItem[S],_], maxRow: Int, maxColumn: TableColumnBase[TreeItem[S],_]) {
      delegate.selectRange(minRow, minColumn, maxRow, maxColumn)
    }

    /**
     * Returns a read-only ObservableList of all selected indices. The ObservableList will be updated by the selection
     * model to always reflect changes in selection. This can be observed by adding a ListChangeListener to the returned
     * ObservableList.
     */
    def selectedIndices: ObservableBuffer[Int] = ObservableBuffer(delegate.getSelectedIndices.map(i => i.intValue()))

    /**
     * Returns a read-only ObservableList of all selected items. The ObservableList will be updated further by the
     * selection model to always reflect changes in selection. This can be observed by adding a ListChangeListener to
     * the returned ObservableList.
     */
    def selectedItems: ObservableBuffer[TreeItem[S]] = ObservableBuffer(delegate.getSelectedItems.map(ti => new TreeItem[S](ti)))

    /**
     * A method that clears any selection prior to setting the selection to the given index. The purpose of this method
     * is to avoid having to call SelectionModel.clearSelection() first, meaning that observers that are listening to
     * the selected index property will not see the selected index being temporarily set to -1.
     * @param row The index that should be the only selected index in this selection model.
     */
    def clearAndSelect(row: Int) {
      delegate.clearAndSelect(row)
    }

    /**
     * This will select the given index in the selection model, assuming the index is within the valid range (i.e.
     * greater than or equal to zero, and less than the total number of items in the underlying data model).
     *
     * If there is already one or more indices selected in this model, calling this method will not clear these selections -
     * to do so it is necessary to first call SelectionModel.clearSelection().
     *
     * If the index is already selected, it will not be selected again, or unselected. However, if multiple selection is
     * implemented, then calling select on an already selected index will have the effect of making the index the new
     * selected index (as returned by SelectionModel.getSelectedIndex().
     *
     * @param row The position of the item to select in the selection model.
     */
    def select(row: Int) {
      delegate.select(row)
    }

    /**
     * This method will attempt to select the index that contains the given object. It will iterate through the
     * underlying data model until it finds an item whose value is equal to the given object. At this point it will stop
     * iterating - this means that this method will not select multiple indices.
     *
     * @param obj The object to attempt to select in the underlying data model.
     */
    def select(obj: TreeItem[S]) {
      delegate.select(obj)
    }

    /**
     * This method allows for one or more selections to be set at the same time. It will ignore any value that is not
     * within the valid range (i.e. greater than or equal to zero, and less than the total number of items in the
     * underlying data model). Any duplication of indices will be ignored.
     *
     * If there is already one or more indices selected in this model, calling this method will not clear these
     * selections - to do so it is necessary to first call clearSelection.
     *
     * The last valid value given will become the selected index / selected item.
     */
    def selectIndices(row: Int, rows: Int*) {
      delegate.selectIndices(row, rows : _*)
    }

    /**
     * Convenience method to select all available indices.
     */
    def selectAll() {
      delegate.selectAll()
    }

    /**
     * This method will attempt to select the first index in the control. If clearSelection is not called first, this
     * method will have the result of selecting the first index, whilst retaining the selection of any other currently
     * selected indices.
     *
     * If the first index is already selected, calling this method will have no result, and no selection event will
     * take place.
     */
    def selectFirst() {
      delegate.selectFirst()
    }

    /**
     * This method will attempt to select the last index in the control. If clearSelection is not called first, this
     * method will have the result of selecting the last index, whilst retaining the selection of any other currently
     * selected indices.
     *
     * If the last index is already selected, calling this method will have no result, and no selection event will
     * take place.
     */
    def selectLast() {
      delegate.selectLast()
    }

    /**
     * Clears the selection model of all selected indices.
     */
    def clearSelection() {
      delegate.clearSelection()
    }

    /**
     * This method will clear the selection of the item in the given index. If the given index is not selected,
     * nothing will happen.
     *
     * @param index The selected item to deselect.
     */
    def clearSelection(index: Int) {
      delegate.clearSelection(index)
    }

    /**
     * Convenience method to inform if the given index is currently selected in this SelectionModel. Is functionally
     * equivalent to calling getSelectedIndices().contains(index).
     *
     * @param index The index to check as to whether it is currently selected or not.
     * @return True if the given index is selected, false otherwise.
     */
    def isSelected(index: Int): Boolean  = delegate.isSelected(index)


    /**
     * This method is available to test whether there are any selected indices/items. It will return true if there are
     * no selected items, and false if there are.
     *
     * @return Will return true if there are no selected items, and false if there are.
     */
    def isEmpty(): Boolean  = delegate.isEmpty()

    /**
     * This method will attempt to select the index directly before the current focused index. If clearSelection is not
     * called first, this method will have the result of selecting the previous index, whilst retaining the selection of
     * any other currently selected indices.
     *
     * Calling this method will only succeed if:
     * - There is currently a lead/focused index.
     * - The lead/focus index is not the first index in the control.
     * - The previous index is not already selected.
     *
     * If any of these conditions is false, no selection event will take place.
     */
    def selectPrevious() {
      delegate.selectPrevious()
    }

    /**
     * This method will attempt to select the index directly after the current focused index. If clearSelection is not
     * called first, this method will have the result of selecting the next index, whilst retaining the selection of any
     * other currently selected indices.
     *
     * Calling this method will only succeed if:
     * - There is currently a lead/focused index.
     * - The lead/focus index is not the last index in the control.
     * - The next index is not already selected.
     *
     * If any of these conditions is false, no selection event will take place.
     */
    def selectNext() {
      delegate.selectNext()
    }

  }









  // TODO: fix!
  // def treeItemLevel(node: TreeItem[_]) = jfxsc.TreeTableView.getTreeItemLevel(node)



  /**
   * Creates a new TreeView overriding layoutChildren method from JavaFX's
   * TreeView.
   */
  def apply[T](layoutChildren: => Unit) = new TreeTableView[T](new jfxsc.TreeTableView[T] {
    override def layoutChildren() = layoutChildren()
  })

  /**
   * Very simple resize policy that just resizes the specified column by the provided delta and shifts all other columns
   * (to the right of the given column) further to the right (when the delta is positive) or to the left (when the delta
   * is negative).
   *
   * It also handles the case where we have nested columns by sharing the new space, or subtracting the removed space,
   * evenly between all immediate children columns. Of course, the immediate children may themselves be nested, and they
   * would then use this policy on their children.
   */
  val UNCONSTRAINED_RESIZE_POLICY: TreeTableView.ResizeFeatures[_] => Boolean =
    tvrf => jfxsc.TreeTableView.UNCONSTRAINED_RESIZE_POLICY(tvrf)

  /**
   * Simple policy that ensures the width of all visible leaf columns in this table sum up to equal the width of the
   * table itself.
   *
   * When the user resizes a column width with this policy, the table automatically adjusts the width of the right hand
   * side columns. When the user increases a column width, the table decreases the width of the rightmost column until
   * it reaches its minimum width. Then it decreases the width of the second rightmost column until it reaches minimum
   * width and so on. When all right hand side columns reach minimum size, the user cannot increase the size of resized
   * column any more.
   */
  val CONSTRAINED_RESIZE_POLICY: TreeTableView.ResizeFeatures[_] => Boolean =
    tvrf => jfxsc.TreeTableView.CONSTRAINED_RESIZE_POLICY(tvrf)

  /**
   * The default sort policy that this TreeTableView will use if no other policy is specified. The sort policy is a
   * simple Callback that accepts a TreeTableView as the sole argument and expects a Boolean response representing
   * whether the sort succeeded or not. A Boolean response of true represents success, and a response of false (or null)
   * will be considered to represent failure.
   */
  val DEFAULT_SORT_POLICY: TreeTableView[_] => Boolean =
    ttv => jfxsc.TreeTableView.DEFAULT_SORT_POLICY(ttv)

/*
  /**
   * An EventType that indicates some edit event has occurred.
   */
  def editAnyEvent[S]: EventType[EditEvent[S]] = jfxsc.TreeTableView.editAnyEvent.asInstanceOf[EventType[EditEvent[S]]]

  // def ANY[T <: jfxe.Event]: EventType[T] = jfxsc.TreeTableView.EditEvent.ANY.asInstanceOf[jfxe.EventType[T]]

  /**
   * An EventType used to indicate that an edit event has just been canceled
   * within the TreeTableView upon which the event was fired.
   */
  def editCancelEvent[S]: EventType[EditEvent[S]] = jfxsc.TreeTableView.editCancelEvent.asInstanceOf[EventType[EditEvent[S]]]

  /**
   * An EventType that is used to indicate that an edit in a TreeTableView has been
   *  committed.
   */
  def editCommitEvent[S]: EventType[EditEvent[S]] = jfxsc.TreeTableView.editCommitEvent.asInstanceOf[EventType[EditEvent[S]]]

  /**
   * An EventType used to indicate that an edit event has started within the
   * TreeTableView upon which the event was fired.
   */
  def editStartEvent[S]: EventType[EditEvent[S]] = jfxsc.TreeTableView.editStartEvent.asInstanceOf[EventType[EditEvent[S]]]
*/



}









/**
 * Wraps a JavaFX [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/TreeTableView.TreeTableView.html]]
 *
 * @constructor Creates a new TreeTableView from a JavaFX one.
 * @param delegate A JavaFX TreeTableView to be wrapped. Its default value is a new JavaFX TreeTableView.
 * @tparam T The type of the TreeItem instances used in this TreeTableView.
 * @since 8.0
 *
 */
class TreeTableView[T](override val delegate: jfxsc.TreeTableView[T] = new jfxsc.TreeTableView[T])
  extends Control(delegate)
  with SFXDelegate[jfxsc.TreeTableView[T]] {

 type Delegate = jfxsc.TreeTableView[T]


  /**
   * An EventType that indicates some edit event has occurred.
   */
  val editAnyEvent: EventType[jfxsc.TreeTableView.EditEvent[T]] = jfxsc.TreeTableView.editAnyEvent[T]()

  // def ANY[T <: jfxe.Event]: EventType[T] = jfxsc.TreeTableView.EditEvent.ANY.asInstanceOf[jfxe.EventType[T]]

  /**
   * An EventType used to indicate that an edit event has just been canceled
   * within the TreeTableView upon which the event was fired.
   */
  val editCancelEvent: EventType[jfxsc.TreeTableView.EditEvent[T]] = jfxsc.TreeTableView.editCancelEvent[T]()

  /**
   * An EventType that is used to indicate that an edit in a TreeTableView has been
   *  committed.
   */
  val editCommitEvent: EventType[jfxsc.TreeTableView.EditEvent[T]] = jfxsc.TreeTableView.editCommitEvent[T]()

  /**
   * An EventType used to indicate that an edit event has started within the
   * TreeTableView upon which the event was fired.
   */
  val editStartEvent: EventType[jfxsc.TreeTableView.EditEvent[T]] = jfxsc.TreeTableView.editStartEvent[T]()

  /**
   * Returns the number of levels of 'indentation' of the given TreeItem,
   * based on how many times getParent() can be recursively called.
   * DEPRECATED:
   *
   * @param node The ScalaFX TreeItem for which the level is needed.
   * @return An integer representing the number of parents above the given node,
   *         or -1 if the given TreeItem is null.
   */
  @deprecated("use [[treeItemLevel(TreeItem)]] instead", "8.0_20")
  def nodeLevel(node: TreeItem[T]) = jfxsc.TreeTableView.getNodeLevel(node: TreeItem[T])

  /**
   * Creates a TreeTableView with the provided root node.
   *
   * Refer to the [[TreeTableView]] class documentation for details on the default state of other properties.
   *
   * @param rootItem The node to be the root in this TreeTableView.
   */
  def this(rootItem: TreeItem[T]) = this(new jfxsc.TreeTableView[T](rootItem))


  /**
   * Property representing the root node of the TreeView.
   */
  def root = delegate.rootProperty
  def root_=(v: TreeItem[T]) {
    root() = v
  }

  /**
   * Property that represents whether or not the TreeView root node is visible.
   */
  def showRoot = delegate.showRootProperty
  def showRoot_=(v: Boolean) {
    showRoot() = v
  }

  /**
   * Property that represents which column should have the disclosure node shown in it (that is, the column with the
   * arrow). By default this will be the left-most column if this property is null, otherwise it will be the specified
   * column assuming it is non-null and contained within the visible leaf columns list.
   */
  def treeColumn = delegate.treeColumnProperty
  def treeColumn_=(v: TreeTableColumn[T, _]) {
    treeColumn() = v
  }

  /**
   * The SelectionModel provides the API through which it is possible to select single or multiple items within a
   * TreeTableView, as well as inspect which rows have been selected by the user. Note that it has a generic type that
   * must match the type of the TreeTableView itself.
   */
  def selectionModel = delegate.selectionModelProperty
  def selectionModel_=(v: TreeTableView.TreeTableViewSelectionModel[T]) {
    selectionModel() = v
  }

  /**
   * The FocusModel provides the API through which it is possible to control focus on zero or one rows of the
   * TreeTableView. Generally the default implementation should be more than sufficient.
   */
  def focusModel = delegate.focusModelProperty
  def focusModel_=(v: TreeTableView.TreeTableViewFocusModel[T]) {
    focusModel() = v
  }

  /**
   * Represents the number of tree nodes presently able to be visible in the TreeTableView. This is essentially the
   * count of all expanded tree items, and their children.
   *
   * For example, if just the root node is visible, the expandedItemCount will be one. If the root had three children
   * and the root was expanded, the value will be four.
   */
  def expandedItemCount: ReadOnlyIntegerProperty = delegate.expandedItemCountProperty

  /**
   * Specifies whether this TreeTableView is editable - only if the TreeTableView and the TreeCells within it are both
   * editable will a TreeCell be able to go into their editing state.
   */

  def editable = delegate.editableProperty
  def editable_=(v: Boolean) {
    editable() = v
  }

  /**
   * Represents the current cell being edited, or null if there is no cell being edited.
   */
  def editingCell : ReadOnlyObjectProperty[jfxsc.TreeTablePosition[T,_]] = delegate.editingCellProperty

  /**
   * This controls whether a menu button is available when the user clicks in a designated space within the TableView,
   * within which is a radio menu item for each TreeTableColumn in this table. This menu allows for the user to show
   * and hide all TreeTableColumns easily.
   */
  def tableMenuButtonVisible = delegate.tableMenuButtonVisibleProperty
  def tableMenuButtonVisible_=(v: Boolean) {
    tableMenuButtonVisible() = v
  }

  /**
   * This is the function called when the user completes a column-resize operation. The two most common policies are
   * available as static functions in the TableView class: [[TreeTableView#UNCONSTRAINED_RESIZE_POLICY]] and
   * [[TreeTableView#CONSTRAINED_RESIZE_POLICY]].
   */
  def columnResizePolicy: ObjectProperty[TreeTableView.ResizeFeatures[T] => Boolean] =
    ObjectProperty((features: TreeTableView.ResizeFeatures[T]) => delegate.columnResizePolicyProperty.value.call(features))
  def columnResizePolicy_=(p: TreeTableView.ResizeFeatures[_] => Boolean) {
    delegate.columnResizePolicyProperty().setValue(new jfxu.Callback[jfxsc.TreeTableView.ResizeFeatures[_], java.lang.Boolean] {
      def call(v: jfxsc.TreeTableView.ResizeFeatures[_]): java.lang.Boolean = {
        p(v)
      }
    })
  }

  /**
   * A function which produces a TreeTableRow. The system is responsible for reusing TreeTableRows. Return from this
   * function a TreeTableRow which might be usable for representing a single row in a TableView.
   *
   * Note that a TreeTableRow is not a TableCell. A TreeTableRow is simply a container for a TableCell, and in most
   * circumstances it is more likely that you'll want to create custom TableCells, rather than TreeTableRows. The
   * primary use case for creating custom TreeTableRow instances would most probably be to introduce some form of
   * column spanning support.
   *
   * You can create custom TableCell instances per column by assigning the appropriate function to the cellFactory
   * property in the TreeTableColumn class.
   */
  def rowFactory = delegate.rowFactoryProperty
  def rowFactory_=(v: (TreeTableView[T] => TreeTableRow[T]) ) {
    rowFactory() = new jfxu.Callback[jfxsc.TreeTableView[T], jfxsc.TreeTableRow[T]] {
      def call(tv: jfxsc.TreeTableView[T]): jfxsc.TreeTableRow[T] = {
        v(tv)
      }
    }
  }

  /**
   * This Node is shown to the user when the table has no content to show. This may be the case because the table model
   * has no data in the first place, that a filter has been applied to the table model, resulting in there being nothing
   * to show the user, or that there are no currently visible columns.
   */
  def placeholder = delegate.placeholderProperty
  def placeholder_=(v: Node) {
    placeholder() = v
  }

  /**
   * Specifies whether this control has cells that are a fixed height (of the specified value). If this value is less 
   * than or equal to zero, then all cells are individually sized and positioned. This is a slow operation. Therefore, 
   * when performance matters and developers are not dependent on variable cell sizes it is a good idea to set the fixed 
   * cell size value. Generally cells are around 24px, so setting a fixed cell size of 24 is likely to result in very 
   * little difference in visuals, but a improvement to performance.
   * 
   * To set this property via CSS, use the -fx-fixed-cell-size property. This should not be confused with the 
   * `-fx-cell-size` property. The difference between these two CSS properties is that `-fx-cell-size` will size all cells 
   * to the specified size, but it will not enforce that this is the only size (thus allowing for variable cell sizes, 
   * and preventing the performance gains from being possible). Therefore, when performance matters use 
   * -fx-fixed-cell-size, instead of `-fx-cell-size`. If both properties are specified in CSS, 
   * -fx-fixed-cell-size takes precedence.
   */
  def fixedCellSize = delegate.fixedCellSizeProperty
  def fixedCellSize_=(v: Double) {
    fixedCellSize() = v
  }

  /**
   * Specifies the sort mode to use when sorting the contents of this TreeTableView, should any columns be specified
   * in the sort order list.
   */
  def sortMode = delegate.sortModeProperty
  def sortMode_=(v: TreeSortMode): Unit = {
    sortMode() = v
  }

  /**
   *The comparator property is a read-only property that is representative of the current state of the sort order list.
   * The sort order list contains the columns that have been added to it either programmatically or via a user clicking
   * on the headers themselves.
   */
  // TODO: Ordering?
  def comparator: ReadOnlyObjectProperty[java.util.Comparator[jfxsc.TreeItem[T]]] = delegate.comparatorProperty

  /** The sort policy specifies how sorting in this TreeTableView should be performed. For example, a basic sort policy
    * may just recursively sort the children of the root tree item, whereas a more advanced sort policy may call to a
    * database to perform the necessary sorting on the server-side.
    *
    * TreeTableView ships with a default sort policy that does precisely as mentioned above: it simply attempts to sort
    * the tree hierarchy in-place.
    *
    * It is recommended that rather than override the sort method that a different sort policy be provided instead.
    */
  def sortPolicy: ObjectProperty[TreeTableView[T] => Boolean] =
    ObjectProperty( ( ttv: TreeTableView[T] ) => delegate.sortPolicyProperty.get().call(ttv) )
  def sortPolicy_=(v: TreeTableView[T] => Boolean) {
    ObjectProperty.fillProperty[TreeTableView[T] => Boolean](sortPolicy, v)
  }
  /*
  def sortPolicy: ObjectProperty[jfxu.Callback[jfxsc.TreeTableView[T], java.lang.Boolean]] = delegate.sortPolicyProperty
  def sortPolicy_=(v: jfxu.Callback[jfxsc.TreeTableView[T], java.lang.Boolean]) {
    ObjectProperty.fillProperty[jfxu.Callback[jfxsc.TreeTableView[T], java.lang.Boolean]](sortPolicy, v)
  }
   */


  /**
   * Called when there's a request to sort the control.
   */
  def onSort = delegate.onSortProperty
  def onSort_=(v: jfxe.EventHandler[jfxsc.SortEvent[jfxsc.TreeTableView[T]]]) {
    onSort() = v
  }

  /**
   * Scrolls the TreeTableView such that the item in the given index is visible to the end user.
   *
   * @param index The index that should be made visible to the user, assuming of course that it is greater than, or
   *              equal to 0, and less than the number of the visible items in the TreeTableView.
   */
  def scrollTo(index: Int) { delegate.scrollTo(index) }

  /**
   * Called when there's a request to scroll an index into view using [[scrollTo(int)]]
   */
  def onScrollTo = delegate.onScrollToProperty
  def onScrollTo_=(v: jfxe.EventHandler[jfxsc.ScrollToEvent[Integer]])= {
    onScrollTo() = v
  }

  /**
   * Scrolls the TreeTableView so that the given column is visible within the viewport.
   *
   * @param column The column that should be visible to the user.
   */
  def scrollToColumn(column: TreeTableColumn[T,_]) { delegate.scrollToColumn(column) }

  /**
   * Scrolls the TreeTableView so that the given index is visible within the viewport.
   *
   * @param index The index of a column that should be visible to the user.
   */
  def scrollToColumnIndex(index: Int) { delegate.scrollToColumnIndex(index) }

  /**
   * Called when there's a request to scroll a column into view using scrollToColumn(TreeTableColumn) or scrollToColumnIndex(int)
   */
  def onScrollToColumn: ObjectProperty[jfxe.EventHandler[jfxsc.ScrollToEvent[jfxsc.TreeTableColumn[T, _]]]] = delegate.onScrollToColumnProperty
  def onScrollToColumn_=(v: jfxe.EventHandler[jfxsc.ScrollToEvent[jfxsc.TreeTableColumn[T,_]]])= {
    ObjectProperty.fillProperty[jfxe.EventHandler[jfxsc.ScrollToEvent[jfxsc.TreeTableColumn[T, _]]]](onScrollToColumn, v)
  }


  /**
   * Returns the index position of the given TreeItem, taking into account the
   * current state of each TreeItem (i.e. whether or not it is expanded).
   */
  def row(item: TreeItem[T]) = delegate.getRow(item)

  /**
   * Returns the TreeItem in the given index, or null if it is out of bounds.
   *
   * @param row The index of the TreeItem being sought.
   * @return The TreeItem in the given index, or null if it is out of bounds.
   */
  def treeItem(row: Int): TreeItem[T] = delegate.getTreeItem(row)

  // TODO: fix!
  //def treeItemLevel(node: TreeItem[_]) = delegate.getTreeItemLevel(node)


  /**
   * The TreeTableColumns that are part of this TableView. As the user reorders the TableView columns, this list will
   * be updated to reflect the current visual ordering.
   *
   * Note: to display any data in a TableView, there must be at least one TreeTableColumn in this ObservableList.
   */
  def columns: ObservableBuffer[jfxsc.TreeTableColumn[T, _]] = delegate.getColumns

  /**
   * The sortOrder list defines the order in which TreeTableColumn instances are sorted. An empty sortOrder list means
   * that no sorting is being applied on the TableView. If the sortOrder list has one TreeTableColumn within it, the
   * TableView will be sorted using the sortType and comparator properties of this TreeTableColumn (assuming
   * TreeTableColumn.sortable is true). If the sortOrder list contains multiple TreeTableColumn instances, then the
   * TableView is firstly sorted based on the properties of the first TreeTableColumn. If two elements are considered
   * equal, then the second TreeTableColumn in the list is used to determine ordering. This repeats until the results
   * from all TreeTableColumn comparators are considered, if necessary.
   */
  def sortOrder: ObservableBuffer[jfxsc.TreeTableColumn[T, _]] = delegate.getSortOrder

  /**
   * Applies the currently installed resize policy against the given column, resizing it based on the delta value provided.
   *
   * @param column
   * @param delta
   */
  def resizeColumn(column: TreeTableColumn[T,_], delta: Double) { delegate.resizeColumn(column, delta) }


  /**
   * Causes the cell at the given row/column view indexes to switch into its editing state, if it is not already in it,
   * and assuming that the TableView and column are also editable.
   */
  def edit(row: Int, item: TreeTableColumn[T, _]) = delegate.edit(row, item)

  /**
   * Returns an unmodifiable list containing the currently visible leaf columns.
   */
  def getVisibleLeafColumns: ObservableBuffer[jfxsc.TreeTableColumn[T,_]] = delegate.getVisibleLeafColumns

  /**
   * Returns the position of the given column, relative to all other visible leaf columns.
   */
  def getVisibleLeafIndex(column: TreeTableColumn[T,_]) = delegate.getVisibleLeafIndex(column)

  /**
   * Returns the TreeTableColumn in the given column index, relative to all other visible leaf columns.
   */
  def getVisibleLeafColumn(column: Int): TreeTableColumn[T,_] = delegate.getVisibleLeafColumn(column)

  /**
   * The sort method forces the TreeTableView to re-run its sorting algorithm. More often than not it is not necessary
   * to call this method directly, as it is automatically called when the sort order, sort policy, or the state of the
   * TreeTableColumn sort type properties change. In other words, this method should only be called directly when
   * something external changes and a sort is required.
   */
  def sort() { delegate.sort() }

  // TODO: why?
  //def classCssMetaData = delegate

  /**
   * unmodifiable Seq of the controls css styleable properties
   */
  def controlCssMetaData: Seq[jfxcss.CssMetaData[_ <: jfxcss.Styleable, _]] = delegate.getControlCssMetaData

}