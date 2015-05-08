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

import javafx.scene.{control => jfxsc}
import javafx.{collections => jfxc, event => jfxe, scene => jfxs, util => jfxu}

import scala.language.implicitConversions
import scalafx.Includes._
import scalafx.beans.property.{BooleanProperty, DoubleProperty, ObjectProperty, ReadOnlyObjectProperty}
import scalafx.collections.ObservableBuffer
import scalafx.delegate.SFXDelegate
import scalafx.scene.Node

/**
 * $OBJCOMPSTA$TV$OBJCOMPEND
 *
 * @define OBJCOMPSTA Object companion for [[scalafx.scene.control
 * @define OBJCOMPEND ]].
 * @define JFX JavaFX
 * @define SFX ScalaFX
 * @define WRAPSTA Wraps a $JFX [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/
 * @define WRAPEND ]].
 * @define CONSSTA Creates a new $SFX
 * @define CONSEND from its $JFX counterpart.
 * @define CONSPARAM to be wrapped.
 * @define TV TableView
 * @define RF ResizeFeatures
 * @define TVSM TableViewSelectionModel
 * @define TVFM TableViewFocusModel
 */
object TableView {
  /**
   * Converts a ScalaFX $TV instance to its $JFX counterpart.
   *
   * @param tv ScalaFX $TV
   * @return $JFX $TV
   */
  implicit def sfxTableView2jfx[S](tv: TableView[S]): jfxsc.TableView[S] = if (tv != null) tv.delegate else null

  /**
   * Very simple resize policy that just resizes the specified column by the provided delta and
   * shifts all other columns (to the right of the given column) further to the right (when the delta is positive)
   * or to the left (when the delta is negative).
   *
   * It delegates to JavaFX
   * [[https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/TableView.html#UNCONSTRAINED_RESIZE_POLICY UNCONSTRAINED_RESIZE_POLICY]]
   */
  val UnconstrainedResizePolicy = jfxsc.TableView.UNCONSTRAINED_RESIZE_POLICY

  /**
   * Simple policy that ensures the width of all visible leaf columns in this table sum up to equal
   * the width of the table itself.
   * When the user resizes a column width with this policy, the table automatically adjusts the width of the right
   * hand side columns. When the user increases a column width, the table decreases the width of the rightmost column
   * until it reaches its minimum width.
   * Then it decreases the width of the second rightmost column until it reaches minimum width and so on.
   * When all right hand side columns reach minimum size, the user cannot increase the size of resized column any more.
   *
   * It delegates to JavaFX [[https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/TableView.html#CONSTRAINED_RESIZE_POLICY CONSTRAINED_RESIZE_POLICY]]
   */
  val ConstrainedResizePolicy = jfxsc.TableView.CONSTRAINED_RESIZE_POLICY

  /**
   * $OBJCOMPSTA$TV.$RF$OBJCOMPEND
   */
  object ResizeFeatures {

    /**
     * Converts a ScalaFX ResizeFeatures instance to its JavaFX counterpart.
     *
     * @param rf ScalaFX ResizeFeatures
     * @return JavaFX ResizeFeatures
     */
    implicit def sfxResizeFeatures2jfx[S](rf: ResizeFeatures[S]): jfxsc.TableView.ResizeFeatures[S] = if (rf != null) rf.delegate else null
  }

  /**
   * $WRAPSTA$TV.$RF.html $RF$WRAPEND
   *
   * @constructor $CONSSTA $RF $CONSEND
   * @param delegate $JFX $RF $CONSPARAM
   */
  class ResizeFeatures[S](override val delegate: jfxsc.TableView.ResizeFeatures[S])
    extends ResizeFeaturesBase[S](delegate)
    with SFXDelegate[jfxsc.TableView.ResizeFeatures[S]] {

    /**
     * Creates an instance of this class, with the provided TableView, TableColumn and delta
     * values being set and stored in this immutable instance.
     *
     * @param table The TableView upon which the resize operation is occurring.
     * @param column The column upon which the resize is occurring, or `null` if this
     *               `ResizeFeatures` instance is being created as a result of a TableView resize operation.
     * @param delta The amount of horizontal space added or removed in the resize operation.
     */
    def this(table: TableView[S], column: TableColumn[S, _], delta: Double) =
      this(new jfxsc.TableView.ResizeFeatures(table, column, delta))

    /**
     * Returns the column upon which the resize is occurring, or `null` if this
     * `ResizeFeatures` instance was created as a result of a TableView resize operation.
     */
    def table: TableView[S] = delegate.getTable

  }

  /**
   * $OBJCOMPSTA$TV.$TVSM$OBJCOMPEND
   */
  object TableViewSelectionModel {

    /**
     * Converts a ScalaFX TableViewSelectionModel instance to its JavaFX counterpart.
     *
     * @param tvsm ScalaFX TableViewSelectionModel
     * @return JavaFX TableViewSelectionModel
     */
    implicit def sfxTableViewSelectionModel2jfx[S](tvsm: TableViewSelectionModel[S]): jfxsc.TableView.TableViewSelectionModel[S] =
      if (tvsm != null) tvsm.delegate else null

  }

  /**
   * $WRAPSTA$TV.$TVSM.html $TVSM$WRAPEND
   *
   * @constructor $CONSSTA $TVSM $CONSEND
   * @param delegate $JFX $TVSM $CONSPARAM
   */
  abstract class TableViewSelectionModel[S](override val delegate: jfxsc.TableView.TableViewSelectionModel[S])
    extends TableSelectionModel[S](delegate)
    with SFXDelegate[jfxsc.TableView.TableViewSelectionModel[S]] {

    /**
     * Clears all selection, and then selects the cell at the given row/column intersection.
     */
    def clearAndSelect(row: Int, column: TableColumn[S, _]) {
      delegate.clearAndSelect(row, column)
    }

    /**
     * Removes selection from the specified row/column position (in view indexes).
     */
    def clearSelection(row: Int, column: TableColumn[S, _]) {
      delegate.clearSelection(row, column)
    }

    def focus(row: Int) {
      delegate.focus(row)
    }

    def focusedIndex: Int = delegate.getFocusedIndex

    /**
     * A read-only ObservableList representing the currently selected cells in this TableView.
     */
    def selectedCells: ObservableBuffer[TablePosition[_, _]] =
      ObservableBuffer(delegate.getSelectedCells.map(jtp => new TablePosition(jtp)))

    /**
     * Returns the TableView instance that this selection model is installed in.
     */
    def tableView: TableView[S] = delegate.getTableView

    /**
     * Selects the cell at the given row/column intersection.
     */
    def select(row: Int, column: TableColumn[S, _]) {
      delegate.select(row, column)
    }

    /**
     * Selects the cell at the given row/column intersection.
     */
    def isSelected(row: Int, column: TableColumn[S, _]): Boolean =
      delegate.isSelected(row, column)

  }

  /**
   * $OBJCOMPSTA$TV.$TVFM$OBJCOMPEND
   */
  object TableViewFocusModel {

    /**
     * Converts a ScalaFX TableViewFocusModel instance to its JavaFX counterpart.
     *
     * @param tvfm ScalaFX TableViewFocusModel
     * @return JavaFX TableViewFocusModel
     */
    implicit def sfxTableViewFocusModel2jfx[S](tvfm: TableViewFocusModel[S]): jfxsc.TableView.TableViewFocusModel[S] =
      if (tvfm != null) tvfm.delegate else null

  }

  /**
   * $WRAPSTA$TV.$TVFM.html $TVFM$WRAPEND
   *
   * @constructor $CONSSTA $TVFM $CONSEND
   * @param delegate $JFX $TVFM $CONSPARAM
   */
  class TableViewFocusModel[S](override val delegate: jfxsc.TableView.TableViewFocusModel[S])
    extends TableFocusModel[S, jfxsc.TableColumn[S, _]](delegate)
    with SFXDelegate[jfxsc.TableView.TableViewFocusModel[S]] {

    /**
     * Creates a default TableViewFocusModel instance that will be used to manage focus of the provided TableView
     * control.
     *
     * @param tableView The tableView upon which this focus model operates.
     */
    def this(tableView: TableView[S]) = this(new jfxsc.TableView.TableViewFocusModel(tableView))

    /**
     * The position of the current item in the TableView which has the focus.
     */
    def focusedCell: ReadOnlyObjectProperty[jfxsc.TablePosition[_, _]] = delegate.focusedCellProperty

    /**
     * Causes the item at the given index to receive the focus.
     *
     * @param index The row index of the item to give focus to.
     * @param column The column of the item to give focus to. Can be `null`.
     */
    def focus(index: Int, column: TableColumn[S, _]) {
      delegate.focus(index, column)
    }

    /**
     * Convenience method for setting focus on a particular row or cell using a
     * [[scalafx.scene.control.TablePosition]].
     *
     * @param pos The table position where focus should be set.
     */
    def focus(pos: TablePosition[_, _]) {
      delegate.focus(pos)
    }

  }

}

/**
 * Wraps JavaFX [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/TableView.html TableView]].
 *
 * @constructor Creates a new ScalaFX TableView Wrapping a JavaFX TableView.
 * @param delegate JavaFX TableView to be wrapped. Its default value is a new JavaFX TableView.
 * @tparam S The type of the objects contained within the TableView items list.
 */
class TableView[S](override val delegate: jfxsc.TableView[S] = new jfxsc.TableView[S])
  extends Control(delegate)
  with SFXDelegate[jfxsc.TableView[S]] {

  /**
   * Creates a TableView with the content provided in the items ObservableBuffer.
   *
   * @param items The items to insert into the TableView, and the list to watch for changes
   *              (to automatically show in the TableView).
   */
  def this(items: ObservableBuffer[S]) = this(new jfxsc.TableView(items))

  /**
   * The TableColumns that are part of this TableView.
   */
  def columns: ObservableBuffer[jfxsc.TableColumn[S, _]] = delegate.getColumns

  /**
   * This is the function called when the user completes a column-resize operation.
   *
   * There are predefined resize policies defined by
   * [[scalafx.scene.control.TableView#ConstrainedResizePolicy UnconstrainedResizePolicy]] and
   * [[scalafx.scene.control.TableView#UnconstrainedResizePolicy UnconstrainedResizePolicy]].
   *
   * Example use:
   * {{{
   *   tableView.columnResizePolicy = TableView.UnconstrainedResizePolicy
   * }}}
   */
  def columnResizePolicy: ObjectProperty[TableView.ResizeFeatures[S] => Boolean] =
    ObjectProperty((features: TableView.ResizeFeatures[S]) => delegate.columnResizePolicyProperty.value.call(features))
  def columnResizePolicy_=(p: TableView.ResizeFeatures[_] => Boolean) {
    delegate.columnResizePolicyProperty().setValue(new jfxu.Callback[jfxsc.TableView.ResizeFeatures[_], java.lang.Boolean] {
      def call(v: jfxsc.TableView.ResizeFeatures[_]): java.lang.Boolean = {
        p(v)
      }
    })
  }
  def columnResizePolicy_=(p: jfxu.Callback[jfxsc.TableView.ResizeFeatures[_], java.lang.Boolean]) {
    delegate.columnResizePolicyProperty().setValue(p)
  }

  /** The comparator property is a read-only property that is representative of the current state of the `sort order` list. */
  def comparator: ReadOnlyObjectProperty[java.util.Comparator[S]] = delegate.comparatorProperty

  /**
   * Specifies whether this TableView is editable - only if the TableView, the TableColumn (if applicable) and the
   * TableCells within it are both editable will a TableCell be able to go into their editing state.
   */
  def editable: BooleanProperty = delegate.editableProperty
  def editable_=(v: Boolean) {
    editable() = v
  }

  /**
   * Represents the current cell being edited, or null if there is no cell being edited.
   */
  def editingCell: ReadOnlyObjectProperty[jfxsc.TablePosition[S, _]] = delegate.editingCellProperty

  /** Specifies whether this control has cells that are a fixed height (of the specified value). */
  def fixedCellSize: DoubleProperty = delegate.fixedCellSizeProperty
  def fixedCellSize_=(v: Double) {
    fixedCellSize() = v
  }

  /**
   * Represents the currently-installed TableView.TableViewFocusModel for this TableView.
   */
  def focusModel: ObjectProperty[jfxsc.TableView.TableViewFocusModel[S]] = delegate.focusModelProperty
  def focusModel_=(v: TableView.TableViewFocusModel[S]) {
    focusModel() = v
  }

  /**
   * The underlying data model for the TableView.
   */
  def items = delegate.itemsProperty
  def items_=(v: ObservableBuffer[S]) {
    items() = v
  }

  /**
   * This Node is shown to the user when the table has no content to show.
   */
  def placeholder: ObjectProperty[jfxs.Node] = delegate.placeholderProperty
  def placeholder_=(v: Node) {
    placeholder() = v
  }

  /**
   * A function which produces a TableRow.
   */
  def rowFactory: ObjectProperty[TableView[S] => TableRow[S]] =
    ObjectProperty((view: TableView[S]) => delegate.rowFactoryProperty.value.call(view))
  def rowFactory_=(factory: TableView[S] => TableRow[S]) {
    delegate.rowFactoryProperty.setValue(new jfxu.Callback[jfxsc.TableView[S], jfxsc.TableRow[S]] {
      def call(v: jfxsc.TableView[S]): jfxsc.TableRow[S] = {
        factory(v)
      }
    })
  }

  /**
   * The SelectionModel provides the API through which it is possible to select single or multiple items within a
   * TableView, as well as inspect which items have been selected by the user.
   */
  def selectionModel: ObjectProperty[jfxsc.TableView.TableViewSelectionModel[S]] = delegate.selectionModelProperty
  def selectionModel_=(v: TableView.TableViewSelectionModel[S]) {
    selectionModel() = v
  }

  /**
   * The sortOrder list defines the order in which `TableColumn` instances are sorted.
   */
  def sortOrder: ObservableBuffer[jfxsc.TableColumn[S, _]] = delegate.getSortOrder

  /**
   * This controls whether a menu button is available when the user clicks in a designated space within the TableView,
   * within which is a radio menu item for each TableColumn in this table.
   */
  def tableMenuButtonVisible: BooleanProperty = delegate.tableMenuButtonVisibleProperty
  def tableMenuButtonVisible_=(v: Boolean) {
    tableMenuButtonVisible() = v
  }

  /**
   * Causes the cell at the given row/column view indexes to switch into its editing state, if it is not already in
   * it, and assuming that the TableView and column are also editable.
   */
  def edit(row: Int, column: TableColumn[S, _]) {
    delegate.edit(row, column)
  }

  /**
   * Applies the currently installed resize policy against the given column, resizing it based on the delta value
   * provided.
   */
  def resizeColumn(column: TableColumn[S, _], delta: Double) = delegate.resizeColumn(column, delta)

  /**
   * Called when there's a request to scroll an index into view using `scrollTo(int)` or `scrollTo(Object)`
   */
  def onScrollTo: ObjectProperty[jfxe.EventHandler[jfxsc.ScrollToEvent[Integer]]] = delegate.onScrollToProperty
  def onScrollTo_=(v: jfxe.EventHandler[jfxsc.ScrollToEvent[Integer]]) {
    ObjectProperty.fillProperty[jfxe.EventHandler[jfxsc.ScrollToEvent[Integer]]](onScrollTo, v)
  }

  /**
   * Called when there's a request to scroll a column into view using `scrollToColumn(TableColumn)` or `scrollToColumnIndex(int)`.
   */
  def onScrollToColumn: ObjectProperty[jfxe.EventHandler[jfxsc.ScrollToEvent[jfxsc.TableColumn[S, _]]]] = delegate.onScrollToColumnProperty
  def onScrollToColumn_=(v: jfxe.EventHandler[jfxsc.ScrollToEvent[jfxsc.TableColumn[S, _]]]) {
    ObjectProperty.fillProperty[jfxe.EventHandler[jfxsc.ScrollToEvent[jfxsc.TableColumn[S, _]]]](onScrollToColumn, v)
  }

  /** Called when there's a request to sort the control. */
  def onSort: ObjectProperty[jfxe.EventHandler[jfxsc.SortEvent[jfxsc.TableView[S]]]] = delegate.onSortProperty
  def onSort_=(v: jfxe.EventHandler[jfxsc.SortEvent[jfxsc.TableView[S]]]) {
    ObjectProperty.fillProperty[jfxe.EventHandler[jfxsc.SortEvent[jfxsc.TableView[S]]]](onSort, v)
  }

  /**
   * Scrolls the TableView so that the given index is visible within the viewport.
   */
  def scrollTo(index: Int) {
    delegate.scrollTo(index)
  }

  /** Scrolls the TableView so that the given object is visible within the viewport. */
  def scrollTo(o: Object) {
    delegate.scrollTo(o)
  }

  /** Scrolls the TableView so that the given object is visible within the viewport. */
  def onScrollToColumn(column: TableColumn[S, _]) {
    delegate.onScrollToColumn(column)
  }

  /**
   * Scrolls the TableView so that the given index is visible within the viewport.
   */
  def scrollToColumnIndex(index: Int) {
    delegate.scrollToColumnIndex(index)
  }

  /** The sort policy specifies how sorting in this TableView should be performed. */
  def sortPolicy: ObjectProperty[jfxu.Callback[jfxsc.TableView[S], java.lang.Boolean]] = delegate.sortPolicyProperty
  def sortPolicy_=(v: jfxu.Callback[jfxsc.TableView[S], java.lang.Boolean]) {
    ObjectProperty.fillProperty[jfxu.Callback[jfxsc.TableView[S], java.lang.Boolean]](sortPolicy, v)
  }

}
