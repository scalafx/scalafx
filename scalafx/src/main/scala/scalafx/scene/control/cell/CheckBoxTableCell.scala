/*
 * Copyright (c) 2011-2024, ScalaFX Project
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

package scalafx.scene.control.cell

import javafx.beans.{value => jfxbv}
import javafx.scene.control.{cell => jfxscc}
import javafx.scene.{control => jfxsc}
import javafx.{util => jfxu}
import scalafx.Includes._
import scalafx.beans.value.ObservableValue
import scalafx.delegate.SFXDelegate
import scalafx.scene.control.cell.CheckBoxTableCell._
import scalafx.scene.control.{TableCell, TableColumn}
import scalafx.util.StringConverter

import scala.language.implicitConversions

/**
 * Companion Object for [[scalafx.scene.control.cell.CheckBoxTableCell]].
 *
 * @define CBTC `CheckBoxTableCell`
 * @define SP   A Callback that, given an object of type TableColumn[S,T], will return an ObservableValue[Boolean] that
 *              represents whether the given item is selected or not.
 */
object CheckBoxTableCell {

  /**
   * Converts a ScalaFX $CBTC to its JavaFX counterpart.
   *
   * @param cell ScalaFX $CBTC
   */
  implicit def sfxCheckBoxTableCell2jfx[S, T](cell: CheckBoxTableCell[S, T]): jfxsc.cell.CheckBoxTableCell[S, T] =
    if (cell != null) cell.delegate else null

  private[cell] implicit def selectedIntPropertyToGetSelectedProperty(selectedProperty: Int => ObservableValue[
    Boolean,
    java.lang.Boolean
  ]): jfxu.Callback[java.lang.Integer, jfxbv.ObservableValue[java.lang.Boolean]] =
    new jfxu.Callback[java.lang.Integer, jfxbv.ObservableValue[java.lang.Boolean]] {
      def call(x: java.lang.Integer): jfxbv.ObservableBooleanValue = selectedProperty(x)
    }

  /**
   * Creates a cell factory for use in a `TableColumn` cell factory.
   *
   * @param selectedProperty $SP
   */
  def forTableColumn[S, T](selectedProperty: Int => ObservableValue[Boolean, java.lang.Boolean])
    : (TableColumn[S, T] => TableCell[S, T]) =
    (column: TableColumn[S, T]) => jfxscc.CheckBoxTableCell.forTableColumn(selectedProperty).call(column)

  /**
   * Added to satisfy Spec tests.
   */
  @deprecated(message = "Use forTableView[S, T](Int => ObservableValue[Boolean, java.lang.Boolean])", since = "1.0")
  def forTableColumn[S, T](getSelectedProperty: jfxu.Callback[
    java.lang.Integer,
    jfxbv.ObservableValue[java.lang.Boolean]
  ]): jfxu.Callback[jfxsc.TableColumn[Any, Any], jfxsc.TableCell[Any, Any]] =
    jfxscc.CheckBoxTableCell.forTableColumn(getSelectedProperty)

  /**
   * Creates a cell factory for use in a `TableColumn` cell factory.
   *
   * @param selectedProperty $SP
   * @param showLabel In some cases, it may be desirable to show a label in the TableCell beside the CheckBox.
   */
  def forTableColumn[S, T](
    selectedProperty: Int => ObservableValue[Boolean, java.lang.Boolean],
    showLabel: Boolean
  ): (TableColumn[S, T] => TableCell[S, T]) =
    (column: TableColumn[S, T]) => jfxscc.CheckBoxTableCell.forTableColumn(selectedProperty, showLabel).call(column)

  /**
   * Added to satisfy Spec tests.
   */
  @deprecated(
    message = "Use forTableView[S, T](Int => ObservableValue[Boolean, java.lang.Boolean], Boolean)",
    since = "1.0"
  )
  def forTableColumn[S, T](
    getSelectedProperty: jfxu.Callback[java.lang.Integer, jfxbv.ObservableValue[java.lang.Boolean]],
    showLabel: Boolean
  ): jfxu.Callback[jfxsc.TableColumn[Any, Any], jfxsc.TableCell[Any, Any]] =
    jfxscc.CheckBoxTableCell.forTableColumn(getSelectedProperty, showLabel)

  /**
   * Creates a cell factory for use in a `TableColumn` cell factory.
   *
   * @param selectedProperty $SP
   * @param converter A StringConverter that, give an object of type T, will return a String that can be used to represent the object visually.
   */
  def forTableColumn[S, T](
    selectedProperty: Int => ObservableValue[Boolean, java.lang.Boolean],
    converter: StringConverter[T]
  ): (TableColumn[S, T] => TableCell[S, T]) =
    (column: TableColumn[S, T]) => jfxscc.CheckBoxTableCell.forTableColumn(selectedProperty, converter).call(column)

  /**
   * Added to satisfy Spec tests.
   */
  @deprecated(
    message = "Use forTableView[S, T](Int => ObservableValue[Boolean, java.lang.Boolean], StringConverter[T])",
    since = "1.0"
  )
  def forTableColumn[S, T](
    getSelectedProperty: jfxu.Callback[java.lang.Integer, jfxbv.ObservableValue[java.lang.Boolean]],
    converter: jfxu.StringConverter[T]
  ): jfxu.Callback[jfxsc.TableColumn[Any, T], jfxsc.TableCell[Any, T]] =
    jfxscc.CheckBoxTableCell.forTableColumn(getSelectedProperty, converter)

  /**
   * Creates a cell factory producing `CheckBoxTableCell` for use in a TableColumn cell factory.
   * This method requires that the TableColumn be of type Boolean.
   * When used in a TableColumn, the CheckBoxCell is rendered with a CheckBox centered in the column.
   *
   * Equivalent to JavaFX static method `forTableColumn`.
   *
   * Example use:
   * {{{
   *   new TableColumn[Item, java.lang.Boolean] {
   *     ...
   *     cellFactory = CheckBoxTableCell.forTableColumn(this)
   *     ...
   *   }
   * }}}
   *
   * @param column column for which to create the factory
   * @tparam S cell value type.
   * @return Cell factory
   */
  def forTableColumn[S](column: jfxsc.TableColumn[S, java.lang.Boolean])
    : jfxu.Callback[jfxsc.TableColumn[S, java.lang.Boolean], jfxsc.TableCell[S, java.lang.Boolean]] =
    jfxscc.CheckBoxTableCell.forTableColumn(column)
}

/**
 * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/cell/CheckBoxTableCell.html $CBTC]]
 *
 * @tparam T Type used in this cell
 * @constructor Creates a new $CBTC from a JavaFX $CBTC
 * @param delegate JavaFX $CBTC
 *
 * @define CBTC `CheckBoxTableCell`
 * @define SP Function that will return an ObservableValue given an index from the TableColumn.
 */
class CheckBoxTableCell[S, T](override val delegate: jfxscc.CheckBoxTableCell[S, T] =
  new jfxscc.CheckBoxTableCell[S, T])
    extends TableCell[S, T](delegate)
    with ConvertableCell[jfxscc.CheckBoxTableCell[S, T], T, T]
    with StateSelectableCell[jfxscc.CheckBoxTableCell[S, T], T, java.lang.Integer]
    with UpdatableCell[jfxscc.CheckBoxTableCell[S, T], T]
    with SFXDelegate[jfxscc.CheckBoxTableCell[S, T]] {

  /**
   * Creates a default CheckBoxTableCell with a custom `Callback` to retrieve an ObservableValue for a given cell index.
   *
   * @param selectedProperty $SP
   */
  def this(selectedProperty: Int => ObservableValue[Boolean, java.lang.Boolean]) =
    this(new jfxscc.CheckBoxTableCell[S, T](selectedProperty))

  /**
   * Creates a CheckBoxTableCell with a custom string converter.
   *
   * @param selectedProperty $SP
   * @param converter StringConverter that receives a T instance.
   */
  def this(selectedProperty: Int => ObservableValue[Boolean, java.lang.Boolean], converter: StringConverter[T]) =
    this(new jfxscc.CheckBoxTableCell[S, T](selectedProperty, converter))

}
