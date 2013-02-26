/*
 * Copyright (c) 2012-2013, ScalaFX Project
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

import javafx.{collections => jfxc}
import javafx.scene.{ control => jfxsc }
import scalafx.Includes._
import scalafx.beans.property.BooleanProperty
import scalafx.beans.property.ObjectProperty
import scalafx.collections.ObservableBuffer
import scalafx.scene.Node
import scalafx.delegate.SFXDelegate

object TableView {
  implicit def sfxTableView2jfx[S](tv: TableView[S]) = tv.delegate

  object ResizeFeatures {
    implicit def sfxResizeFeatures2jfx[S](rf: ResizeFeatures[S]) = rf.delegate
  }

  /**
   * Wraps [[http://docs.oracle.com/javafx/2/api/javafx/scene/control/TableView.ResizeFeatures.html]].
   */
  class ResizeFeatures[S](override val delegate: jfxsc.TableView.ResizeFeatures[S])
    extends SFXDelegate[jfxsc.TableView.ResizeFeatures[S]] {

    def this(table: TableView[S], column: TableColumn[S, _], delta: Double) =
      this(new jfxsc.TableView.ResizeFeatures(table, column, delta))

    def table: TableView[S] = delegate.getTable

    def column: TableColumn[S, _] = delegate.getColumn

    def delta = delegate.getDelta

  }

  object TableViewSelectionModel {
    implicit def sfxTableViewSelectionModel2jfx[S](tvsm: TableViewSelectionModel[S]) = tvsm.delegate
  }

  /**
   * Wraps [[http://docs.oracle.com/javafx/2/api/javafx/scene/control/TableView.TableViewSelectionModel.html]].
   */
  abstract class TableViewSelectionModel[S](override val delegate: jfxsc.TableView.TableViewSelectionModel[S])
    extends MultipleSelectionModel[S](delegate)
    with SFXDelegate[jfxsc.TableView.TableViewSelectionModel[S]] {

    /**
     * Creates a default TableViewFocusModel instance that will be used to manage focus of the provided TableView
     * control.
     */
    //    def this(tableView: TableView[S]) = this(new jfxsc.TableView.TableViewSelectionModel(tableView){}) 

    /**
     * A boolean property used to represent whether the TableView is in row or cell selection modes.
     */
    def cellSelectionEnabled: BooleanProperty = delegate.cellSelectionEnabledProperty
    def cellSelectionEnabled_=(v: Boolean) {
      cellSelectionEnabled() = v
    }

    /**
     * Clears all selection, and then selects the cell at the given row/column intersection.
     */
    def clearAndSelect(row: Int, column: TableColumn[S, _]) = delegate.clearAndSelect(row, column)

    /**
     * Removes selection from the specified row/column position (in view indexes).
     */
    def clearSelection(row: Int, column: TableColumn[S, _]) = delegate.clearSelection(row, column)

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
     * Convenience function which tests whether the given row and column index is currently selected in this
     * TableView instance.
     */
    def isSelected(row: Int, column: TableColumn[S, _]) = delegate.isSelected(row, column)

    /**
     * Selects the cell at the given row/column intersection.
     */
    def select(row: Int, column: TableColumn[S, _]) = delegate.select(row, column)

    /**
     * Selects the cell directly above the currently selected cell.
     */
    def selectAboveCell = delegate.selectAboveCell

    /**
     * Selects the cell directly below the currently selected cell.
     */
    def selectBelowCell = delegate.selectBelowCell

    /**
     * Selects the cell to the left of the currently selected cell.
     */
    def selectLeftCell = delegate.selectLeftCell

    /**
     * Selects the cell to the right of the currently selected cell.
     */
    def selectRightCell = delegate.selectRightCell

    delegate.selectLast

  }

  object TableViewFocusModel {
    implicit def sfxTableViewFocusModel2jfx[S](tvfm: TableViewFocusModel[S]) = tvfm.delegate
  }

  /**
   * Wraps [[http://docs.oracle.com/javafx/2/api/javafx/scene/control/TableView.TableViewFocusModel.html]].
   */
  class TableViewFocusModel[S](override val delegate: jfxsc.TableView.TableViewFocusModel[S])
    extends FocusModel[S](delegate)
    with SFXDelegate[jfxsc.TableView.TableViewFocusModel[S]] {

    /**
     * Creates a default TableViewFocusModel instance that will be used to manage focus of the provided TableView
     * control.
     */
    def this(tableView: TableView[S]) = this(new jfxsc.TableView.TableViewFocusModel(tableView))

    /**
     * The position of the current item in the TableView which has the focus.
     */
    def focusedCell = delegate.focusedCellProperty

    /**
     * Causes the item at the given index to receive the focus.
     */
    def focus(index: Int, column: TableColumn[S, _]) = delegate.focus(index, column)

    /**
     * Convenience method for setting focus on a particular row or cell using a TablePosition.
     */
    def focus(pos: TablePosition[_, _]) = delegate.focus(pos)

    /**
     * Attempts to move focus to the cell above the currently focused cell.
     */
    def focusAboveCell = delegate.focusAboveCell

    /**
     * Attempts to move focus to the cell below the currently focused cell.
     */
    def focusBelowCell = delegate.focusBelowCell

    /**
     * Attempts to move focus to the cell to the left of the currently focused cell.
     */
    def focusLeftCell = delegate.focusLeftCell

    /**
     * Attempts to move focus to the cell to the right of the the currently focused cell.
     */
    def focusRightCell = delegate.focusRightCell
    /**
     * Tests whether the row / cell at the given location currently has the focus within the TableView.
     */
    def isFocused(index: Int, column: TableColumn[S, _]) = delegate.isFocused(index, column)

  }
}

/**
 * Wraps [[http://docs.oracle.com/javafx/2/api/javafx/scene/control/TableView.html]].
 */
class TableView[S](override val delegate: jfxsc.TableView[S] = new jfxsc.TableView[S])
  extends Control(delegate)
  with SFXDelegate[jfxsc.TableView[S]] {

  def this(items: ObservableBuffer[S]) = this(new jfxsc.TableView(items))

  /**
   * The TableColumns that are part of this TableView.
   */
  def columns : jfxc.ObservableList[jfxsc.TableColumn[S,_]] = delegate.getColumns

  /**
   * This is the function called when the user completes a column-resize operation.
   */
  def columnResizePolicy: ObjectProperty[TableView.ResizeFeatures[S] => Boolean] =
    ObjectProperty((features: TableView.ResizeFeatures[S]) => delegate.columnResizePolicyProperty.value.call(features))
  def columnResizePolicy_=(v: TableView.ResizeFeatures[S] => Boolean) {
    columnResizePolicy() = v
  }

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
  def editingCell = delegate.editingCellProperty

  /**
   * Represents the currently-installed TableView.TableViewFocusModel for this TableView.
   */
  def focusModel = delegate.focusModelProperty
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
  def placeholder = delegate.placeholderProperty
  def placeholder_=(v: Node) {
    placeholder() = v
  }

  /**
   * A function which produces a TableRow.
   */
  def rowFactory: ObjectProperty[TableView[S] => TableRow[S]] =
    ObjectProperty((view: TableView[S]) => delegate.rowFactoryProperty.value.call(view))
  def rowFactory_=(factory: TableView[S] => TableRow[S]) {
    rowFactory() = factory
  }

  /**
   * The SelectionModel provides the API through which it is possible to select single or multiple items within a
   * TableView, as well as inspect which items have been selected by the user.
   */
  def selectionModel = delegate.selectionModelProperty
  def selectionModel_=(v: TableView.TableViewSelectionModel[S]) {
    selectionModel() = v
  }

  /**
   * The sortOrder list defines the order in which `TableColumn` instances are sorted.
   */
  def sortOrder = delegate.getSortOrder.map(new TableColumn(_))

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
  def edit(row: Int, column: TableColumn[S, _]) = delegate.edit(row, column)

  /**
   * Applies the currently installed resize policy against the given column, resizing it based on the delta value
   * provided.
   */
  def resizeColumn(column: TableColumn[S, _], delta: Double) = delegate.resizeColumn(column, delta)

  /**
   * Scrolls the TableView so that the given index is visible within the viewport.
   */
  def scrollTo(index: Int) = delegate.scrollTo(index)

}