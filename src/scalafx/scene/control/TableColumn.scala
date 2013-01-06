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

import scala.math.Ordering
import javafx.beans.{ value => jfxbv }
import javafx.scene.{ control => jfxsc }
import javafx.{ event => jfxe }
import scalafx.Includes._
import scalafx.beans.property.BooleanProperty
import scalafx.beans.property.DoubleProperty
import scalafx.beans.property.ObjectProperty
import scalafx.beans.property.ReadOnlyDoubleProperty
import scalafx.beans.property.StringProperty
import scalafx.event.Event
import scalafx.scene.Node.sfxNode2jfx
import scalafx.scene.control.ContextMenu.sfxContextMenu2jfx
import scalafx.scene.control.TableColumn.CellDataFeatures.sfxCellDataFeatures2jfx
import scalafx.scene.control.TableColumn.sfxTableColumn2jfx
import scalafx.scene.control.TablePosition.sfxTablePosition2jfx
import scalafx.scene.control.TableView.sfxTableView2jfx
import scalafx.scene.Node
import scalafx.util.SFXDelegate
import scalafx.util.{ SFXEnumDelegateCompanion, SFXEnumDelegate }
import scalafx.collections.ObservableBuffer

object TableColumn {
  implicit def sfxTableColumn2jfx[S, T](tc: TableColumn[S, T]) = tc.delegate

  object CellDataFeatures {
    implicit def sfxCellDataFeatures2jfx[S, T](cdf: CellDataFeatures[S, T]) = cdf.delegate
  }

  /**
   * Wraps [[http://docs.oracle.com/javafx/2/api/javafx/scene/control/TableColumn.CellDataFeatures.html]].
   */
  class CellDataFeatures[S, T](override val delegate: jfxsc.TableColumn.CellDataFeatures[S, T])
    extends SFXDelegate[jfxsc.TableColumn.CellDataFeatures[S, T]] {

    /**
     * Instantiates a CellDataFeatures instance with the given properties set as read-only values of this instance.
     */
    def this(tableView: TableView[S], tableColumn: TableColumn[S, T], value: S) =
      this(new jfxsc.TableColumn.CellDataFeatures(tableView, tableColumn, value))

    /**
     * Returns the TableColumn passed in to the constructor.
     */
    def tableColumn = delegate.getTableColumn

    /**
     * Returns the TableView passed in to the constructor.
     */
    def tableView = delegate.getTableView

    /**
     * Returns the value passed in to the constructor.
     */
    def value = delegate.getValue

  }

  object CellEditEvent {
    implicit def sfxCellEditEvent2jfx[S, T](cee: CellEditEvent[S, T]) = cee.delegate
  }

  /**
   * Wraps [[http://docs.oracle.com/javafx/2/api/javafx/scene/control/TableColumn.CellEditEvent.html]].
   */
  class CellEditEvent[S, T](override val delegate: jfxsc.TableColumn.CellEditEvent[S, T])
    extends Event(delegate)
    with SFXDelegate[jfxsc.TableColumn.CellEditEvent[S, T]] {

    /**
     * Creates a new event that can be subsequently fired to the relevant listeners.
     */
    def this(table: TableView[S], pos: TablePosition[S, T], eventType: jfxe.EventType[jfxsc.TableColumn.CellEditEvent[_, _]], newValue: T) =
      this(new jfxsc.TableColumn.CellEditEvent(table, pos, eventType, newValue))

    /**
     * Returns the new value input by the end user.
     */
    def newValue = delegate.getNewValue

    /**
     * Attempts to return the old value at the position referred to in the TablePosition returned by `tablePosition`.
     */
    def oldValue = delegate.getOldValue

    /**
     * Convenience method that returns the value for the row (that is, from the TableView items list), for the row
     * contained within the TablePosition returned in `tablePosition`.
     */
    def rowValue = delegate.getRowValue

    /**
     * Returns the TableColumn upon which this event occurred.
     */
    def tableColumn: TableColumn[S, T] = delegate.getTableColumn

    /**
     * Returns the position upon which this event occurred.
     */
    def tablePosition: TablePosition[S, T] = delegate.getTablePosition

    /**
     * Returns the TableView upon which this event occurred.
     */
    def tableView: TableView[S] = delegate.getTableView

  }

  object SortType
    extends SFXEnumDelegateCompanion[jfxsc.TableColumn.SortType, SortType] {

    /** Column will be sorted in an ascending order. */
    val ASCENDING = new SortType(jfxsc.TableColumn.SortType.ASCENDING)

    /** Column will be sorted in a descending order. */
    val DESCENDING = new SortType(jfxsc.TableColumn.SortType.DESCENDING)

    protected override def unsortedValues: Array[SortType] = Array(ASCENDING, DESCENDING)

  }

  /** Wrapper for [[http://docs.oracle.com/javafx/2/api/javafx/scene/control/TableColumn.SortType.html]] */
  sealed case class SortType(override val delegate: jfxsc.TableColumn.SortType)
    extends SFXEnumDelegate[jfxsc.TableColumn.SortType]

  /**
   * If no cellFactory is specified on a TableColumn instance, then this one will be used by default.
   */
  val DEFAULT_CELL_FACTORY: (TableColumn[_, _] => TableCell[_, _]) = (column: TableColumn[_, _]) =>
    jfxsc.TableColumn.DEFAULT_CELL_FACTORY.call(column)

  /**
   * By default all columns will use this comparator to perform sorting.
   */
  val DEFAULT_COMPARATOR: Ordering[_] = Ordering.comparatorToOrdering(jfxsc.TableColumn.DEFAULT_COMPARATOR)

  /**
   * Parent event for any TableColumn edit event.
   */
  def editAnyEvent = jfxsc.TableColumn.editAnyEvent

  /**
   * Indicates that the editing has been canceled, meaning that no change should be made to the backing data source.
   */
  def editCancelEvent = jfxsc.TableColumn.editCancelEvent

  /**
   * Indicates that the editing has been committed by the user, meaning that a change should be made to the backing
   * data source to reflect the new data.
   */
  def editCommitEvent = jfxsc.TableColumn.editCommitEvent

  /**
   * Indicates that the user has performed some interaction to start an edit event, or alternatively the
   * TableView.edit(Int, TableColumn) method has been called.
   */
  def editStartEvent = jfxsc.TableColumn.editStartEvent

}

/**
 * Wraps [[http://docs.oracle.com/javafx/2/api/javafx/scene/control/TableColumn.html]].
 */
class TableColumn[S, T](override val delegate: jfxsc.TableColumn[S, T] = new jfxsc.TableColumn)
  extends SFXDelegate[jfxsc.TableColumn[S, T]] {

  /**
   * Creates a TableColumn with the text set to the provided string, with default cell factory, comparator, and
   * onEditCommit implementation.
   */
  def this(text: String) = this(new jfxsc.TableColumn[S, T](text))

  /**
   * The cell factory for all cells in this column.
   */
  def cellFactory: ObjectProperty[TableColumn[S, T] => TableCell[S, T]] =
    ObjectProperty((column: TableColumn[S, T]) => new TableCell(delegate.cellFactoryProperty.getValue.call(column)))
  def cellFactory_=(v: TableColumn[S, T] => TableCell[S, T]) {
    cellFactory() = v
  }

  /**
   * The cell value factory needs to be set to specify how to populate all cells within a single TableColumn.
   */
  def cellValueFactory: ObjectProperty[TableColumn.CellDataFeatures[S, T] => jfxbv.ObservableValue[T]] =
    ObjectProperty((features: TableColumn.CellDataFeatures[S, T]) => delegate.cellValueFactoryProperty.getValue.call(features))
  def cellValueFactory_=(v: TableColumn.CellDataFeatures[S, T] => jfxbv.ObservableValue[T]) {
    cellValueFactory() = v
  }

  /**
   * This enables support for nested columns, which can be useful to group together related data.
   */
  def columns: ObservableBuffer[TableColumn[S, _]] = ObservableBuffer(delegate.getColumns.map(new TableColumn(_)))

  /**
   * Comparator function used when sorting this TableColumn.
   */
  def comparator: ObjectProperty[Ordering[T]] = ObjectProperty(Ordering.comparatorToOrdering(delegate.comparatorProperty.getValue))
  def comparator_=(v: Ordering[T]) {
    comparator() = v
  }

  /**
   * This menu will be shown whenever the user right clicks within the header area of this TableColumn.
   */
  def contextMenu = delegate.contextMenuProperty
  def contextMenu_=(v: ContextMenu) {
    contextMenu() = v
  }

  /**
   * Specifies whether this TableColumn allows editing.
   */
  def editable: BooleanProperty = delegate.editableProperty
  def editable_=(v: Boolean) {
    editable() = v
  }

  /**
   * The graphic in the TableColumn.
   */
  def graphic = delegate.graphicProperty
  def graphic_=(v: Node) {
    graphic() = v
  }

  /**
   * The id of this TableColumn.
   */
  def id: StringProperty = delegate.idProperty
  def id_=(v: String) {
    id() = v
  }

  /**
   * The maximum width the TableColumn is permitted to be resized to.
   */
  def maxWidth: DoubleProperty = delegate.maxWidthProperty
  def maxWidth_=(v: Double) {
    maxWidth() = v
  }

  /**
   * The minimum width the TableColumn is permitted to be resized to.
   */
  def minWidth: DoubleProperty = delegate.minWidthProperty
  def minWidth_=(v: Double) {
    minWidth() = v
  }

  /**
   * This event handler will be fired when the user cancels editing a cell.
   */
  def onEditCancel = delegate.onEditCancelProperty
  def onEditCancel_=(v: jfxe.EventHandler[jfxsc.TableColumn.CellEditEvent[S, T]]) {
    onEditCancel() = v
  }

  /**
   * This event handler will be fired when the user successfully commits their editing.
   */
  def onEditCommit = delegate.onEditCommitProperty
  def onEditCommit_=(v: jfxe.EventHandler[jfxsc.TableColumn.CellEditEvent[S, T]]) {
    onEditCommit() = v
  }

  /**
   * This event handler will be fired when the user successfully initiates editing.
   */
  def onEditStart = delegate.onEditCommitProperty
  def onEditStart_=(v: jfxe.EventHandler[jfxsc.TableColumn.CellEditEvent[S, T]]) {
    onEditStart() = v
  }

  /**
   * This read-only property will always refer to the parent of this column, in the situation where nested columns are being used.
   */
  def parentColumn = delegate.parentColumnProperty

  /**
   * The preferred width of the TableColumn.
   */
  def prefWidth: DoubleProperty = delegate.prefWidthProperty
  def prefWidth_=(v: Double) {
    prefWidth() = v
  }

  /**
   * Used to indicate whether the width of this column can change.
   */
  def resizable: BooleanProperty = delegate.resizableProperty
  def resizable_=(v: Boolean) {
    resizable() = v
  }

  /**
   * A boolean property to toggle on and off the sortability of this column.
   */
  def sortable: BooleanProperty = delegate.sortableProperty
  def sortable_=(v: Boolean) {
    sortable() = v
  }

  /**
   * The sort node is commonly seen represented as a triangle that rotates on screen to indicate whether the
   * TableColumn is part of the sort order, and if so, what position in the sort order it is in.
   */
  def sortNode = delegate.sortNodeProperty
  def sortNode_=(v: Node) {
    sortNode() = v
  }

  /**
   * Used to state whether this column, if it is part of the TableView.sortOrder ObservableList, should be sorted in
   * ascending or descending order.
   */
  def sortType = delegate.sortTypeProperty
  def sortType_=(v: jfxsc.TableColumn.SortType) {
    sortType() = v
  }

  /**
   * The CSS style string associated to this TableColumn.
   */
  def style: StringProperty = delegate.styleProperty
  def style_=(v: String) {
    style() = v
  }

  /**
   * A list of String identifiers which can be used to logically group Nodes, specifically for an external style engine.
   */
  def styleClass: ObservableBuffer[String] = delegate.getStyleClass

  /**
   * The TableView that this TableColumn belongs to.
   */
  def tableView = delegate.tableViewProperty

  /**
   * This is the text to show in the header for this column.
   */
  def text: StringProperty = delegate.textProperty
  def text_=(v: String) {
    text() = v
  }

  /**
   * Returns a previously set Object property, or null if no such property has been set using the
   * setUserData(Any) method.
   */
  def userData = delegate.getUserData

  /**
   * Toggling this will immediately toggle the visibility of this column, and all children columns.
   */
  def visible: BooleanProperty = delegate.visibleProperty
  def visible_=(v: Boolean) {
    visible() = v
  }

  /**
   * The width of this column.
   */
  def width: ReadOnlyDoubleProperty = delegate.widthProperty

  /**
   * Construct an event dispatch chain for this target.
   */
  def buildEventDispatchChain(tail: jfxe.EventDispatchChain) = delegate.buildEventDispatchChain(tail)

  /**
   * Returns the actual value for a cell at a given row index (and which belongs to this TableColumn).
   */
  def getCellData(index: Int) = delegate.getCellData(index)

  /**
   * Returns the actual value for a cell from the given item.
   */
  def getCellData(index: S) = delegate.getCellData(index)

  /**
   * Tests if this TableColumn has properties.
   */
  def hasProperties = delegate.hasProperties

  /**
   * Registers an event handler to this TableColumn.
   */
  def addEventHandler[E <: jfxe.Event](eventType: jfxe.EventType[E], eventHandler: jfxe.EventHandler[E]) =
    delegate.addEventHandler(eventType, eventHandler)

  /**
   *  Unregisters a previously registered event handler from this TableColumn.
   */
  def removeEventHandler[E <: jfxe.Event](eventType: jfxe.EventType[E], eventHandler: jfxe.EventHandler[E]) =
    delegate.addEventHandler(eventType, eventHandler)

}