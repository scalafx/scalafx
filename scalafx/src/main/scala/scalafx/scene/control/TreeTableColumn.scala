/*
 * Copyright (c) 2011-2025, ScalaFX Project
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

import javafx.beans.value as jfxbv
import javafx.scene.control as jfxsc
import javafx.{css as jfxcss, event as jfxe, util as jfxu}
import scalafx.Includes.*
import scalafx.beans.property.{ObjectProperty, ReadOnlyObjectProperty}
import scalafx.beans.value.ObservableValue
import scalafx.collections.ObservableBuffer
import scalafx.delegate.{SFXDelegate, SFXEnumDelegate, SFXEnumDelegateCompanion}
import scalafx.event.{Event, EventType}
import scalafx.util.JavaConverters.*

import scala.language.implicitConversions

/**
 * Object companion for [[scalafx.scene.control.TreeTableColumn]]
 */
object TreeTableColumn {

  /**
   * Converts a ScalaFX TreeTableColumn instance to its JavaFX counterpart.
   *
   * @param v ScalaFX TreeTableColumn
   * @return JavaFX TreeTableColumn
   */
  implicit def sfxTreeTableColumn2jfx[S, T](v: TreeTableColumn[S, T]): jfxsc.TreeTableColumn[S, T] =
    if (v != null) v.delegate else null

  /**
   * Object companion for [[scalafx.scene.control.TreeTableColumn.CellDataFeatures]]
   */
  object CellDataFeatures {
    implicit def sfxCellDataFeatures2jfx[S, T](v: CellDataFeatures[S, T])
      : jfxsc.TreeTableColumn.CellDataFeatures[S, T] =
      if (v != null) v.delegate else null
  }

  /**
   * Wraps a JavaFX [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/TreeTableColumn.CellDataFeatures.html]]
   *
   * @constructor Creates a new CellDataFeatures from a JavaFX one.
   * @param delegate A JavaFX CellDataFeatures to be wrapped. Its default value is a new JavaFX CellDataFeatures.
   * @tparam S The TreeTableView type
   * @tparam T The TreeTableColumn type
   * @since 8.0
   */
  class CellDataFeatures[S, T](override val delegate: jfxsc.TreeTableColumn.CellDataFeatures[S, T])
      extends SFXDelegate[jfxsc.TreeTableColumn.CellDataFeatures[S, T]] {

    /**
     * Instantiates a CellDataFeatures instance with the given properties set as read-only values of this instance.
     *
     * @param treeTableView   The TreeTableView that this instance refers to.
     * @param treeTableColumn The TreeTableColumn that this instance refers to.
     * @param value           The value for a row in the TreeTableView.
     * @return
     */
    def this(treeTableView: TreeTableView[S], treeTableColumn: TreeTableColumn[S, T], value: S) =
      this(new jfxsc.TreeTableColumn.CellDataFeatures[S, T](treeTableView, treeTableColumn, new TreeItem[S](value)))

    /**
     * Returns the TreeTableColumn passed in to the constructor.
     */
    def treeTableColumn: TreeTableColumn[S, T] = delegate.getTreeTableColumn

    /**
     * Returns the TreeTableView passed in to the constructor.
     */
    def treeTableView: TreeTableView[S] = delegate.getTreeTableView

    /**
     * Returns the value passed in to the constructor.
     */
    def value: TreeItem[S] = delegate.getValue
  }

  object CellEditEvent {

    /**
     * Converts a ScalaFX CellEditEvent instance to its JavaFX counterpart.
     *
     * @param cee ScalaFX CellEditEvent
     * @return JavaFX CellEditEvent
     */
    implicit def sfxCellEditEvent2jfx[S, T](cee: CellEditEvent[S, T]): jfxsc.TreeTableColumn.CellEditEvent[S, T] =
      if (cee != null) cee.delegate else null

  }

  /**
   * Wraps a JavaFX [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/TreeTableColumn.CellEditEvent.html]]
   *
   * @constructor Creates a new CellDataFeatures from a JavaFX one.
   * @param delegate A JavaFX CellDataFeatures to be wrapped. Its default value is a new JavaFX CellDataFeatures.
   * @tparam S The TreeTableView type
   * @tparam T The TreeTableColumn type
   * @since 8.0
   */
  class CellEditEvent[S, T](override val delegate: jfxsc.TreeTableColumn.CellEditEvent[S, T])
      extends Event(delegate)
      with SFXDelegate[jfxsc.TreeTableColumn.CellEditEvent[S, T]] {

    /**
     * Creates a new event that can be subsequently fired to the relevant listeners.
     *
     * @param table     The TreeTableView on which this event occurred.
     * @param pos       The position upon which this event occurred.
     * @param eventType The type of event that occurred.
     * @param newValue  The value input by the end user.
     */
    def this(
      table: TreeTableView[S],
      pos: TreeTablePosition[S, T],
      eventType: jfxe.EventType[jfxsc.TreeTableColumn.CellEditEvent[S, T]],
      newValue: T
    ) =
      this(new jfxsc.TreeTableColumn.CellEditEvent(table, pos, eventType, newValue))

    /**
     * Returns the TreeTableView upon which this event occurred.
     */
    def treeTableView: TreeTableView[S] = delegate.getTreeTableView

    /**
     * Returns the TreeTableColumn upon which this event occurred.
     */
    def tableColumn: TreeTableColumn[S, T] = delegate.getTableColumn

    /**
     * Returns the position upon which this event occurred.
     */
    def treeTablePosition: TreeTablePosition[S, T] = delegate.getTreeTablePosition

    /**
     * Returns the new value input by the end user.
     */
    def newValue: T = delegate.getNewValue

    /**
     * Attempts to return the old value at the position referred to in the TreeTablePosition returned by `treeTablePosition`.
     */
    def oldValue: T = delegate.getOldValue

    /**
     * Convenience method that returns the value for the row (that is, from the TableView items list), for the row
     * contained within the TablePosition returned in `tablePosition`.
     */
    def rowValue: TreeItem[S] = delegate.getRowValue

  }

  object SortType extends SFXEnumDelegateCompanion[jfxsc.TreeTableColumn.SortType, SortType] {

    /** Column will be sorted in an ascending order. */
    case object Ascending extends SortType(jfxsc.TreeTableColumn.SortType.ASCENDING)

    /** Column will be sorted in a descending order. */
    case object Descending extends SortType(jfxsc.TreeTableColumn.SortType.DESCENDING)

    protected override def unsortedValues: Array[SortType] = Array(Ascending, Descending)

  }

  /** Wrapper for [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/TreeTableColumn.SortType.html]] */
  sealed abstract class SortType(override val delegate: jfxsc.TreeTableColumn.SortType)
      extends SFXEnumDelegate[jfxsc.TreeTableColumn.SortType]

  /**
   * If no cellFactory is specified on a TreeTableColumn instance, then this one will be used by default.
   */
  val DefaultCellFactory: TreeTableColumn[?, ?] => TreeTableCell[?, ?] =
    (column: TreeTableColumn[?, ?]) => jfxsc.TreeTableColumn.DEFAULT_CELL_FACTORY.call(column)

  /**
   * Parent event for any TreeTableColumn edit event.
   */
  def editAnyEvent: EventType[jfxsc.TreeTableColumn.CellEditEvent[Nothing, Nothing]] =
    new EventType(jfxsc.TreeTableColumn.editAnyEvent)

  /**
   * Indicates that the editing has been canceled, meaning that no change should be made to the backing data source.
   */
  def editCancelEvent: EventType[jfxsc.TreeTableColumn.CellEditEvent[Nothing, Nothing]] =
    new EventType(jfxsc.TreeTableColumn.editCancelEvent)

  /**
   * Indicates that the editing has been committed by the user, meaning that a change should be made to the backing
   * data source to reflect the new data.
   */
  def editCommitEvent: EventType[jfxsc.TreeTableColumn.CellEditEvent[Nothing, Nothing]] =
    new EventType(jfxsc.TreeTableColumn.editCommitEvent)

  /**
   * Indicates that the user has performed some interaction to start an edit event, or alternatively the
   * TableView.edit(Int, TableColumn) method has been called.
   */
  def editStartEvent: EventType[jfxsc.TreeTableColumn.CellEditEvent[Nothing, Nothing]] =
    new EventType(jfxsc.TreeTableColumn.editStartEvent)

  /**
   * The CssMetaData of this Styleable. This may be returned as an unmodifiable list.
   */
  def classCssMetaData: Seq[jfxcss.CssMetaData[? <: jfxcss.Styleable, ?]] =
    jfxsc.TreeTableColumn.getClassCssMetaData.asScala.toSeq

}

/**
 * A `TreeTableView` is made up of a number of `TreeTableColumn` instances.
 * Each `TreeTableColumn` in a `TreeTableView` is responsible for displaying (and editing) the contents of that column.
 *
 * Wraps a JavaFX [[https://openjfx.io/javadoc/16/javafx.controls/javafx/scene/control/TreeTableColumn.html TreeTableColumn]]
 *
 * @constructor Creates a new `TreeTableColumn` from a JavaFX one.
 * @param delegate A JavaFX TreeTableColumn to be wrapped. Its default value is a new JavaFX TreeTableColumn.
 * @tparam S The type of the TreeTableView generic type (i.e. S == TreeTableView<S>)
 * @tparam T The type of the content in all cells in this TreeTableColumn.
 * @since 8.0
 */
class TreeTableColumn[S, T](override val delegate: jfxsc.TreeTableColumn[S, T] = new jfxsc.TreeTableColumn[S, T]())
    extends TableColumnBase[jfxsc.TreeItem[S], T](delegate)
    with SFXDelegate[jfxsc.TreeTableColumn[S, T]] {

  /**
   * Creates a TreeTableColumn with the text set to the provided string, with default cell factory, comparator,
   * and onEditCommit implementation.
   *
   * @param text The string to show when the TreeTableColumn is placed within the TreeTableView.
   */
  def this(text: String) = this(new jfxsc.TreeTableColumn[S, T](text))

  /**
   * The cell factory for all cells in this column. The cell factory is responsible for rendering the data contained
   * within each TreeTableCell for a single TreeTableColumn.
   *
   * By default TreeTableColumn uses a default cell factory, but this can be replaced with a custom implementation,
   * for example to show data in a different way or to support editing. There is a lot of documentation on creating
   * custom cell factories elsewhere (see Cell and TreeTableView for example).
   *
   * Finally, there are a number of pre-built cell factories available in the javafx.scene.control.cell package.
   */
  def cellFactory: ObjectProperty[jfxu.Callback[jfxsc.TreeTableColumn[S, T], jfxsc.TreeTableCell[S, T]]] =
    delegate.cellFactoryProperty
  def cellFactory_=(callback: jfxu.Callback[jfxsc.TreeTableColumn[S, T], jfxsc.TreeTableCell[S, T]]): Unit = {
    delegate.cellFactoryProperty.setValue(callback)
  }
  def cellFactory_=(f: TreeTableColumn[S, T] => TreeTableCell[S, T]): Unit = {
    delegate.cellFactoryProperty.setValue(
      new jfxu.Callback[jfxsc.TreeTableColumn[S, T], jfxsc.TreeTableCell[S, T]] {
        def call(v: jfxsc.TreeTableColumn[S, T]): jfxsc.TreeTableCell[S, T] = {
          f(v)
        }
      }
    )
  }

  /**
   * This is a helper method for easy creation of custom cell factories.
   * The custom cell is automatically created, and it handles rendering of empty cells.
   * The user is only responsible for providing an operation `op` that renders non-empty cells.
   *
   * The operation `op` provides as input the already created custom `cell` and `value` of that cell.
   * The `value` is provided by the `cellValueFactory`. The `value` is guaranteed to be non `null`.
   * The `null` values are automatically rendered as empty cells by the provided `cell` object.
   *
   * Here is an example where value's type is a case class `Person` that contains two text fields: `firstName` and `lastName`.
   * {{{
   *   case class Person(firstName:String, lastName:String)
   *   ...
   *
   *   cellFactory = (cell, value) => {
   *     cell.text = value.firstName + " " + value.lastName
   *   }
   * }}}
   *
   * Another example where 'value' is of type 'Color' and the cell factory creates a circle representing that color:
   * {{{
   *   cellFactory = (cell, value) => {
   *     cell.graphic = new Circle {
   *        fill = value
   *        radius = 8
   *     }
   *   }
   * }}}
   *
   * @param op a method that will create content for a given `cell`.
   *           It gets as an input automatically created custom `cell` and a non-null `value` of that cell.
   *           `op` is called in the cell's `updateItem` method.
   */
  def cellFactory_=(op: (TreeTableCell[S, T], T) => Unit): Unit = {
    val callback =
      Option(op)
        .map { op =>
          new jfxu.Callback[jfxsc.TreeTableColumn[S, T], jfxsc.TreeTableCell[S, T]] {
            def call(tv: jfxsc.TreeTableColumn[S, T]): jfxsc.TreeTableCell[S, T] = {
              new jfxsc.TreeTableCell[S, T] {
                val sfxThis = new TreeTableCell(this)
                override def updateItem(item: T, empty: Boolean): Unit = {
                  super.updateItem(item, empty)
                  if (empty || item == null) {
                    setText(null)
                    setGraphic(null)
                  } else {
                    op(sfxThis, item)
                  }
                }
              }
            }
          }
        }
        .orNull

    delegate.cellFactoryProperty.setValue(callback)
  }

  /**
   * The TreeTableView that this TreeTableColumn belongs to.
   */
  def treeTableView: ReadOnlyObjectProperty[jfxsc.TreeTableView[S]] = delegate.treeTableViewProperty

  /**
   * The cell value factory needs to be set to specify how to populate all cells within a single TreeTableColumn. A cell
   * value factory is a Callback that provides a TreeTableColumn.CellDataFeatures instance, and expects an
   * ObservableValue to be returned. The returned ObservableValue instance will be observed internally to allow for
   * updates to the value to be immediately reflected on screen.
   *
   * An example of how to set a cell value factory is:
   * {{{
   *   // p.value returns the TreeItem[Person] instance for a particular TreeTableView row,
   *   // p.value.value returns the Person instance inside the TreeItem[Person]
   *   cellValueFactory = { p => p.value.value.firstName }
   * }}}
   * A simple complete example (from `scalafx-demos` `SimpleTreeTableView`):
   * {{{
   * import scalafx.application.JFXApp3
   * import scalafx.application.JFXApp3.PrimaryStage
   * import scalafx.controls.tableview.Person
   * import scalafx.scene.Scene
   * import scalafx.scene.control.TreeTableColumn._
   * import scalafx.scene.control.{TreeItem, TreeTableColumn, TreeTableView}
   *
   * object SimpleTreeTableView extends JFXApp3 {
   *
   *  override def start(): Unit = {
   *
   *    val treeRoot = new TreeItem[Person](new Person("Peggy", "Sue", "555-6798"))
   *
   *    treeRoot.children += new TreeItem[Person](new Person("Rocky", "Raccoon", "555-6798"))
   *
   *    stage = new PrimaryStage {
   *      title = "Simple Table View"
   *      scene = new Scene {
   *        content = new TreeTableView[Person](treeRoot) {
   *          columns ++= Seq(
   *            new TreeTableColumn[Person, String] {
   *              text = "First Name"
   *              cellValueFactory = _.value.getValue.firstName
   *              prefWidth = 180
   *            },
   *            new TreeTableColumn[Person, String]() {
   *              text = "Last Name"
   *              cellValueFactory = _.value.getValue.lastName
   *              prefWidth = 180
   *            }
   *          )
   *        }
   *      }
   *    }
   *  }
   * }
   * }}}
   *
   * A common approach is to want to populate cells in a TreeTableColumn using a single value from a Java bean. To
   * support this common scenario, there is the TreeItemPropertyValueFactory class. Refer to this class for more
   * information on how to use it, but briefly here is how the above use case could be simplified using the
   * TreeItemPropertyValueFactory class:
   *
   * firstNameCol.cellValueFactory = new TreeItemPropertyValueFactory[Person,String]("firstName"))
   */
  def cellValueFactory: ObjectProperty[TreeTableColumn.CellDataFeatures[S, T] => ObservableValue[T, T]] =
    ObjectProperty((features: TreeTableColumn.CellDataFeatures[S, T]) =>
      jfxObservableValue2sfx[T](delegate.cellValueFactoryProperty.getValue.call(features))
    )

  def cellValueFactory_=(f: TreeTableColumn.CellDataFeatures[S, T] => ObservableValue[T, T]): Unit = {
    delegate.cellValueFactoryProperty.setValue(
      new jfxu.Callback[jfxsc.TreeTableColumn.CellDataFeatures[S, T], jfxbv.ObservableValue[T]] {
        def call(v: jfxsc.TreeTableColumn.CellDataFeatures[S, T]): jfxbv.ObservableValue[T] = {
          Option(f(v)).map(_.delegate).orNull
        }
      }
    )
  }

  /**
   * Used to state whether this column, if it is part of the TableView.sortOrder ObservableList, should be sorted in
   * ascending or descending order.
   */
  def sortType: ObjectProperty[jfxsc.TreeTableColumn.SortType] = delegate.sortTypeProperty

  def sortType_=(v: TreeTableColumn.SortType): Unit = {
    sortType() = v
  }

  /**
   * This event handler will be fired when the user successfully initiates editing.
   */
  def onEditStart: ObjectProperty[jfxe.EventHandler[jfxsc.TreeTableColumn.CellEditEvent[S, T]]] =
    delegate.onEditCommitProperty

  def onEditStart_=(v: jfxe.EventHandler[jfxsc.TreeTableColumn.CellEditEvent[S, T]]): Unit = {
    onEditStart() = v
  }

  /**
   * This event handler will be fired when the user successfully commits their editing.
   */
  def onEditCommit: ObjectProperty[jfxe.EventHandler[jfxsc.TreeTableColumn.CellEditEvent[S, T]]] =
    delegate.onEditCommitProperty

  def onEditCommit_=(v: jfxe.EventHandler[jfxsc.TreeTableColumn.CellEditEvent[S, T]]): Unit = {
    onEditCommit() = v
  }

  /**
   * This event handler will be fired when the user cancels editing a cell.
   */
  def onEditCancel: ObjectProperty[jfxe.EventHandler[jfxsc.TreeTableColumn.CellEditEvent[S, T]]] =
    delegate.onEditCancelProperty

  def onEditCancel_=(v: jfxe.EventHandler[jfxsc.TreeTableColumn.CellEditEvent[S, T]]): Unit = {
    onEditCancel() = v
  }

  /**
   * This enables support for nested columns, which can be useful to group together related data. For example, we may
   * have a 'Name' column with two nested columns for 'First' and 'Last' names.
   *
   * This has no impact on the table as such - all column indices point to the leaf columns only, and it isn't
   * possible to sort using the parent column, just the leaf columns. In other words, this is purely a visual feature.
   *
   * @return An ObservableBuffer containing TableColumnBase instances (or subclasses) that are the children of this
   *         TableColumnBase. If these children TableColumnBase instances are set as visible, they will appear
   *         beneath this table column.
   */
  def columns: ObservableBuffer[jfxsc.TreeTableColumn[S, ?]] = delegate.getColumns

  /**
   * Attempts to return an ObservableValue<T> for the item in the given index (which is of type S). In other words,
   * this method expects to receive an integer value that is greater than or equal to zero, and less than the size
   * of the underlying data model. If the index is valid, this method will return an ObservableValue<T> for
   * this specific column.
   *
   * This is achieved by calling the cell value factory, and returning whatever it returns when passed a
   * CellDataFeatures (see, for example, the CellDataFeatures classes belonging to TableColumn and TreeTableColumn
   * for more information).
   *
   * @param index The index of the item (of type S) for which an ObservableValue<T> is sought.
   * @return An ObservableValue<T> for this specific table column.
   */
  def cellObservableValue(index: Int): ObservableValue[T, T] = delegate.getCellObservableValue(index)

  /**
   * Attempts to return an ObservableValue<T> for the given item (which is of type S). In other words, this method
   * expects to receive an object from the underlying data model for the entire 'row' in the table, and it must
   * return an ObservableValue<T> for the value in this specific column.
   *
   * This is achieved by calling the cell value factory, and returning whatever it returns when passed a
   * CellDataFeatures (see, for example, the CellDataFeatures classes belonging to TableColumn and TreeTableColumn
   * for more information).
   *
   * @param item The item (of type S) for which an ObservableValue<T> is sought.
   * @return An ObservableValue<T> for this specific table column.
   */
  def cellObservableValue(item: TreeItem[S]): ObservableValue[T, T] = delegate.getCellObservableValue(item)

  /**
   * The CssMetaData of this Styleable. This may be returned as an unmodifiable list.
   */
  override def cssMetaData: Seq[jfxcss.CssMetaData[? <: jfxcss.Styleable, ?]] = delegate.getCssMetaData.asScala.toSeq

}
