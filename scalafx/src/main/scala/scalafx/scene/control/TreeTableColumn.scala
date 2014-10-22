package scalafx.scene.control

import javafx.beans.{value => jfxbv}
import javafx.scene.{control => jfxsc}
import javafx.{event => jfxe, util => jfxu}

import scala.language.implicitConversions
import scalafx.Includes._
import scalafx.beans.property.{ObjectProperty, ReadOnlyObjectProperty}
import scalafx.beans.value.ObservableValue
import scalafx.collections.ObservableBuffer
import scalafx.delegate.{SFXDelegate, SFXEnumDelegate, SFXEnumDelegateCompanion}
import scalafx.event.Event

object TreeTableColumn {
  implicit def sfxTreeTableColumn2jfx[S,T](v: TreeTableColumn[S,T]) =  if (v != null)  v.delegate else null

  object CellDataFeatures {
    implicit def sfxCellDataFeatures2jfx[S,T](v: CellDataFeatures[S,T]) = if (v != null)  v.delegate else null
  }


  class CellDataFeatures[S,T](override val delegate: jfxsc.TreeTableColumn.CellDataFeatures[S,T])
    extends SFXDelegate[jfxsc.TreeTableColumn.CellDataFeatures[S,T]] {

    def this(treeTableView: TreeTableView[S], treeTableColumn: TreeTableColumn[S, T], value: S) =
      this(new jfxsc.TreeTableColumn.CellDataFeatures[S,T](treeTableView, treeTableColumn, new TreeItem[S](value)))

    /**
     * Returns the TableColumn passed in to the constructor.
     */
    def tableColumn = delegate.getTreeTableColumn

    /**
     * Returns the TableView passed in to the constructor.
     */
    def tableView = delegate.getTreeTableView

    /**
     * Returns the value passed in to the constructor.
     */
    def value = delegate.getValue
  }

  object CellEditEvent {
    implicit def sfxCellEditEvent2jfx[S, T](cee: CellEditEvent[S, T]) = if (cee != null) cee.delegate else null

  }

  /**
   * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/TableColumn.CellEditEvent.html]].
   */
  class CellEditEvent[S, T](override val delegate: jfxsc.TreeTableColumn.CellEditEvent[S, T])
    extends Event(delegate)
    with SFXDelegate[jfxsc.TreeTableColumn.CellEditEvent[S, T]] {

    /**
     * Creates a new event that can be subsequently fired to the relevant listeners.
     */
    def this(table: TreeTableView[S], pos: TreeTablePosition[S, T], eventType: jfxe.EventType[jfxsc.TreeTableColumn.CellEditEvent[S, T]], newValue: T) =
      this(new jfxsc.TreeTableColumn.CellEditEvent(table, pos, eventType, newValue))

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
    def rowValue: TreeItem[S] = delegate.getRowValue

    /**
     * Returns the TableColumn upon which this event occurred.
     */
    def tableColumn: TreeTableColumn[S, T] = delegate.getTableColumn

    /**
     * Returns the position upon which this event occurred.
     */
    def tablePosition: TreeTablePosition[S, T] = delegate.getTreeTablePosition

    /**
     * Returns the TableView upon which this event occurred.
     */
    def treeTableView: TreeTableView[S] = delegate.getTreeTableView

  }

  object SortType
    extends SFXEnumDelegateCompanion[jfxsc.TreeTableColumn.SortType, SortType] {

    /** Column will be sorted in an ascending order. */
    val ASCENDING = new SortType(jfxsc.TreeTableColumn.SortType.ASCENDING)

    /** Column will be sorted in a descending order. */
    val DESCENDING = new SortType(jfxsc.TreeTableColumn.SortType.DESCENDING)

    protected override def unsortedValues: Array[SortType] = Array(ASCENDING, DESCENDING)

  }

  /** Wrapper for [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/TableColumn.SortType.html]] */
  sealed case class SortType(override val delegate: jfxsc.TreeTableColumn.SortType)
    extends SFXEnumDelegate[jfxsc.TreeTableColumn.SortType]

  /**
   * If no cellFactory is specified on a TableColumn instance, then this one will be used by default.
   */
  val DEFAULT_CELL_FACTORY: (TreeTableColumn[_, _] => TreeTableCell[_, _]) = (column: TreeTableColumn[_, _]) =>
    jfxsc.TreeTableColumn.DEFAULT_CELL_FACTORY.call(column)


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


class TreeTableColumn[S,T](override val delegate: jfxsc.TreeTableColumn[S,T] = new  jfxsc.TreeTableColumn[S, T]())
  extends  TableColumnBase[jfxsc.TreeItem[S],T]( delegate )
  with SFXDelegate[jfxsc.TreeTableColumn[S,T]] {


  def this(text: String) = this(new jfxsc.TreeTableColumn[S, T](text))


  def cellFactory: ObjectProperty[TreeTableColumn[S, T] => TreeTableCell[S, T]] =
    ObjectProperty((column: TreeTableColumn[S, T]) => new TreeTableCell(delegate.cellFactoryProperty.getValue.call(column)))
  def cellFactory_=(f: TreeTableColumn[S, T] => TreeTableCell[S, T]) {
    delegate.cellFactoryProperty.setValue(new jfxu.Callback[jfxsc.TreeTableColumn[S, T], jfxsc.TreeTableCell[S, T]] {
      def call(v: jfxsc.TreeTableColumn[S, T]): jfxsc.TreeTableCell[S, T] = {
        f(v)
      }
    })
  }



  def cellValueFactory: ObjectProperty[TreeTableColumn.CellDataFeatures[S, T] => ObservableValue[T, T]] =
    ObjectProperty((features: TreeTableColumn.CellDataFeatures[S, T]) => jfxObservableValue2sfx[T](delegate.cellValueFactoryProperty.getValue.call(features)))

  def cellValueFactory_=(f: TreeTableColumn.CellDataFeatures[S, T] => ObservableValue[T, T]) {
    delegate.cellValueFactoryProperty.setValue(new jfxu.Callback[jfxsc.TreeTableColumn.CellDataFeatures[S, T], jfxbv.ObservableValue[T]] {
      def call(v: jfxsc.TreeTableColumn.CellDataFeatures[S, T]): jfxbv.ObservableValue[T] = {
        f(v).delegate
      }
    })
  }

  def columns: ObservableBuffer[jfxsc.TreeTableColumn[S, _]] = delegate.getColumns


  /**
   * This event handler will be fired when the user cancels editing a cell.
   */
  def onEditCancel = delegate.onEditCancelProperty
  def onEditCancel_=(v: jfxe.EventHandler[jfxsc.TreeTableColumn.CellEditEvent[S, T]]) {
    onEditCancel() = v
  }

  /**
   * This event handler will be fired when the user successfully commits their editing.
   */
  def onEditCommit = delegate.onEditCommitProperty
  def onEditCommit_=(v: jfxe.EventHandler[jfxsc.TreeTableColumn.CellEditEvent[S, T]]) {
    onEditCommit() = v
  }

  /**
   * This event handler will be fired when the user successfully initiates editing.
   */
  def onEditStart = delegate.onEditCommitProperty
  def onEditStart_=(v: jfxe.EventHandler[jfxsc.TreeTableColumn.CellEditEvent[S, T]]) {
    onEditStart() = v
  }

  /**
   * Used to state whether this column, if it is part of the TableView.sortOrder ObservableList, should be sorted in
   * ascending or descending order.
   */
  def sortType: ObjectProperty[jfxsc.TreeTableColumn.SortType] = delegate.sortTypeProperty
  def sortType_=(v: TreeTableColumn.SortType) {
    sortType() = v
  }


  /**
   * The TableView that this TableColumn belongs to.
   */
  def tableView: ReadOnlyObjectProperty[jfxsc.TreeTableView[S]] = delegate.treeTableViewProperty
}
