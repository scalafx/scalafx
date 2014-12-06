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

import javafx.beans.{value => jfxbv}
import javafx.scene.{control => jfxsc}
import javafx.{event => jfxe, scene => jfxs, util => jfxu}

import scala.language.implicitConversions
import scalafx.Includes._
import scalafx.beans.property.{ObjectProperty, ReadOnlyObjectProperty}
import scalafx.beans.value.ObservableValue
import scalafx.collections.ObservableBuffer
import scalafx.delegate.{SFXDelegate, SFXEnumDelegate, SFXEnumDelegateCompanion}
import scalafx.event.Event

object TableColumn {
  implicit def sfxTableColumn2jfx[S, T](tc: TableColumn[S, T]): jfxsc.TableColumn[S, T] = if (tc != null) tc.delegate else null

  object CellDataFeatures {
    implicit def sfxCellDataFeatures2jfx[S, T](cdf: CellDataFeatures[S, T]): jfxsc.TableColumn.CellDataFeatures[S, T] = if (cdf != null) cdf.delegate else null
  }

  /**
   * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/TableColumn.CellDataFeatures.html]].
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
    implicit def sfxCellEditEvent2jfx[S, T](cee: CellEditEvent[S, T]): jfxsc.TableColumn.CellEditEvent[S, T] = if (cee != null) cee.delegate else null

  }

  /**
   * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/TableColumn.CellEditEvent.html]].
   */
  class CellEditEvent[S, T](override val delegate: jfxsc.TableColumn.CellEditEvent[S, T])
    extends Event(delegate)
    with SFXDelegate[jfxsc.TableColumn.CellEditEvent[S, T]] {

    /**
     * Creates a new event that can be subsequently fired to the relevant listeners.
     */
    def this(table: TableView[S], pos: TablePosition[S, T], eventType: jfxe.EventType[jfxsc.TableColumn.CellEditEvent[S, T]], newValue: T) =
      this(new jfxsc.TableColumn.CellEditEvent(table, pos, eventType, newValue))

    /**
     * Returns the new value input by the end user.
     */
    def newValue: T = delegate.getNewValue

    /**
     * Attempts to return the old value at the position referred to in the TablePosition returned by `tablePosition`.
     */
    def oldValue: T = delegate.getOldValue

    /**
     * Convenience method that returns the value for the row (that is, from the TableView items list), for the row
     * contained within the TablePosition returned in `tablePosition`.
     */
    def rowValue: S = delegate.getRowValue

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

  /** Wrapper for [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/TableColumn.SortType.html]] */
  sealed case class SortType(override val delegate: jfxsc.TableColumn.SortType)
    extends SFXEnumDelegate[jfxsc.TableColumn.SortType]

  /**
   * If no cellFactory is specified on a TableColumn instance, then this one will be used by default.
   */
  val DEFAULT_CELL_FACTORY: (TableColumn[_, _] => TableCell[_, _]) = (column: TableColumn[_, _]) =>
    jfxsc.TableColumn.DEFAULT_CELL_FACTORY.call(column)


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
 * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/TableColumn.html]].
 */
class TableColumn[S, T](override val delegate: jfxsc.TableColumn[S, T] = new jfxsc.TableColumn[S, T]())
  extends TableColumnBase[S,T](delegate)
  with SFXDelegate[jfxsc.TableColumn[S, T]] {

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
  def cellFactory_=(f: TableColumn[S, T] => TableCell[S, T]) {
    delegate.cellFactoryProperty.setValue(new jfxu.Callback[jfxsc.TableColumn[S, T], jfxsc.TableCell[S, T]] {
      def call(v: jfxsc.TableColumn[S, T]): jfxsc.TableCell[S, T] = {
        f(v)
      }
    })
  }

  /**
   * The cell value factory needs to be set to specify how to populate all cells within a single TableColumn.
   */
  def cellValueFactory: ObjectProperty[TableColumn.CellDataFeatures[S, T] => ObservableValue[T, T]] =
    ObjectProperty((features: TableColumn.CellDataFeatures[S, T]) => delegate.cellValueFactoryProperty.getValue.call(features))
  def cellValueFactory_=(f: TableColumn.CellDataFeatures[S, T] => ObservableValue[T, T]) {
    delegate.cellValueFactoryProperty.setValue(new jfxu.Callback[jfxsc.TableColumn.CellDataFeatures[S, T], jfxbv.ObservableValue[T]] {
      def call(v: jfxsc.TableColumn.CellDataFeatures[S, T]): jfxbv.ObservableValue[T] = {
        f(v).delegate
      }
    })
  }

  /**
   * This enables support for nested columns, which can be useful to group together related data.
   */
  def columns: ObservableBuffer[jfxsc.TableColumn[S, _]] = delegate.getColumns


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
   * Used to state whether this column, if it is part of the TableView.sortOrder ObservableList, should be sorted in
   * ascending or descending order.
   */
  def sortType: ObjectProperty[jfxsc.TableColumn.SortType] = delegate.sortTypeProperty
  def sortType_=(v: TableColumn.SortType) {
    sortType() = v
  }


  /**
   * The TableView that this TableColumn belongs to.
   */
  def tableView: ReadOnlyObjectProperty[jfxsc.TableView[S]] = delegate.tableViewProperty
}