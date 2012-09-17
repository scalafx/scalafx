/* Copyright (c) 2012, ScalaFX Project
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

import scala.annotation.implicitNotFound
import javafx.beans.{ value => jfxbv }
import javafx.scene.control.{ cell => jfxscc }
import javafx.scene.{ control => jfxsc }
import javafx.{ util => jfxu }
import scalafx.Includes._
import scalafx.beans.value.ObservableValue
import scalafx.scene.control.cell.CheckBoxTableCell._
import scalafx.scene.control.ListCell
import scalafx.scene.control.ListView
import scalafx.util.SFXDelegate
import scalafx.util.StringConverter
import scalafx.scene.control.TableCell
import scalafx.scene.control.TableColumn

object CheckBoxTableCell {
  implicit def sfxCheckBoxTableCell2jfx[S, T](cell: CheckBoxTableCell[S, T]) = cell.delegate

  private[cell] implicit def selectedIntPropertyToGetSelectedProperty(selectedProperty: Int => ObservableValue[Boolean, java.lang.Boolean]): jfxu.Callback[java.lang.Integer, jfxbv.ObservableValue[java.lang.Boolean]] =
    new jfxu.Callback[java.lang.Integer, jfxbv.ObservableValue[java.lang.Boolean]] {
      def call(x: java.lang.Integer) = selectedProperty(x)
    }

  /**
   * Creates a cell factory for use in a `TableColumn` cell factory.
   */
  def forTableColumn[S, T](selectedProperty: Int => ObservableValue[Boolean, java.lang.Boolean]): (TableColumn[S, T] => TableCell[S, T]) =
    (column: TableColumn[S, T]) => jfxscc.CheckBoxTableCell.forTableColumn(selectedProperty).call(column)

  /**
   * Added to satisfy Spec tests.
   */
  @deprecated(message = "Use forTableView[S, T](Int => ObservableValue[Boolean, java.lang.Boolean])", since = "1.0")
  def forTableColumn[S, T](getSelectedProperty: jfxu.Callback[java.lang.Integer, jfxbv.ObservableValue[java.lang.Boolean]]) =
    jfxscc.CheckBoxTableCell.forTableColumn(getSelectedProperty)

  /**
   * Creates a cell factory for use in a `TableColumn` cell factory.
   */
  def forTableColumn[S, T](selectedProperty: Int => ObservableValue[Boolean, java.lang.Boolean], showLabel: Boolean): (TableColumn[S, T] => TableCell[S, T]) =
    (column: TableColumn[S, T]) => jfxscc.CheckBoxTableCell.forTableColumn(selectedProperty, showLabel).call(column)

  /**
   * Added to satisfy Spec tests.
   */
  @deprecated(message = "Use forTableView[S, T](Int => ObservableValue[Boolean, java.lang.Boolean], Boolean)", since = "1.0")
  def forTableColumn[S, T](getSelectedProperty: jfxu.Callback[java.lang.Integer, jfxbv.ObservableValue[java.lang.Boolean]], showLabel: Boolean) =
    jfxscc.CheckBoxTableCell.forTableColumn(getSelectedProperty, showLabel)

  /**
   * Creates a cell factory for use in a `TableColumn` cell factory.
   */
  def forTableColumn[S, T](selectedProperty: Int => ObservableValue[Boolean, java.lang.Boolean], converter: StringConverter[T]): (TableColumn[S, T] => TableCell[S, T]) =
    (column: TableColumn[S, T]) => jfxscc.CheckBoxTableCell.forTableColumn(selectedProperty, converter).call(column)

  /**
   * Added to satisfy Spec tests.
   */
  @deprecated(message = "Use forTableView[S, T](Int => ObservableValue[Boolean, java.lang.Boolean], StringConverter[T])", since = "1.0")
  def forTableColumn[S, T](getSelectedProperty: jfxu.Callback[java.lang.Integer, jfxbv.ObservableValue[java.lang.Boolean]], converter: jfxu.StringConverter[T]) =
    jfxscc.CheckBoxTableCell.forTableColumn(getSelectedProperty, converter)

  /*
   * Creates a cell factory for use in a `TableColumn` cell factory.
   *
  def forTableColumn[S](column: TableColumn[S, Boolean]): (TableColumn[S, Boolean] => TableCell[S, Boolean]) = {
    val jfxColumn: jfxsc.TableColumn[S, java.lang.Boolean] = column.delegate.asInstanceOf[jfxsc.TableColumn[S, java.lang.Boolean]]
    val jfxCallback = jfxscc.CheckBoxTableCell.forTableColumn(jfxColumn).call(column.delegate.asInstanceOf[jfxsc.TableColumn[S, java.lang.Boolean]])
    (column: TableColumn[S, Boolean]) => jfxscc.CheckBoxTableCell.forTableColumn(jfxColumn).call(column.delegate.asInstanceOf[jfxsc.TableColumn[S, java.lang.Boolean]])
    *
 overloaded method value forTableColumn with alternatives: 
[S, T](x$1: javafx.util.Callback[java.lang.Integer,javafx.beans.value.ObservableValue[java.lang.Boolean]])javafx.util.Callback[javafx.scene.control.TableColumn[S,T],javafx.scene.control.T
	 ableCell[S,T]] <and> 
[S   ](x$1: javafx.scene.control.TableColumn[S,java.lang.Boolean])javafx.util.Callback[javafx.scene.control.TableColumn[S,java.lang.Boolean],javafx.scene.control.TableCell[S,java.lang.
	 Boolean]] cannot be applied to (scalafx.scene.control.TableColumn[S,scala.Boolean])     * 
     
  }
*/

  /**
   * Added to satisfy Spec tests.
   * TODO: Create ScalaFX Version
   */
  def forTableColumn[S](column: jfxsc.TableColumn[S, java.lang.Boolean]) = jfxscc.CheckBoxTableCell.forTableColumn(column)

}

/**
 * Wraps [[http://docs.oracle.com/javafx/2/api/javafx/scene/control/cell/CheckBoxTableCell.html]]
 */
class CheckBoxTableCell[S, T](override val delegate: jfxscc.CheckBoxTableCell[S, T] = new jfxscc.CheckBoxTableCell[S, T])
  extends TableCell[S, T](delegate)
  with ConvertableCell[jfxscc.CheckBoxTableCell[S, T], T, T]
  with StateSelectableCell[jfxscc.CheckBoxTableCell[S, T], T, java.lang.Integer]
  with UpdatableCell[jfxscc.CheckBoxTableCell[S, T], T]
  with SFXDelegate[jfxscc.CheckBoxTableCell[S, T]] {

  /**
   * Creates a default CheckBoxTableCell with a custom `Callback` to retrieve an ObservableValue for a given cell index.
   */
  def this(selectedProperty: Int => ObservableValue[Boolean, java.lang.Boolean]) =
    this(new jfxscc.CheckBoxTableCell[S, T](selectedProperty))

  /**
   * Creates a CheckBoxTableCell with a custom string converter.
   */
  def this(selectedProperty: Int => ObservableValue[Boolean, java.lang.Boolean], converter: StringConverter[T]) =
    this(new jfxscc.CheckBoxTableCell[S, T](selectedProperty, converter))

}