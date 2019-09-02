/*
 * Copyright (c) 2011-2015, ScalaFX Project
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

import javafx.scene.control.{cell => jfxscc}
import javafx.scene.{control => jfxsc}
import javafx.{collections => jfxc, util => jfxu}

import scala.language.implicitConversions
import scalafx.Includes.jfxTreeTableCell2sfx
import scalafx.collections.ObservableBuffer
import scalafx.collections.ObservableBuffer.observableBuffer2ObservableList
import scalafx.delegate.SFXDelegate
import scalafx.scene.control.TreeTableCell
import scalafx.util.StringConverter
import scalafx.util.StringConverter.sfxStringConverter2jfx

/**
  * Companion Object for [[scalafx.scene.control.cell.ComboBoxTreeTableCell]].
  *
  * @since 8.0
  * @todo Replace all references to $JFX `$TTC` to its $SFX counterpart when it was created
  *
  * @define TTC TreeTableColumn
  * @define CBTC `ComboBoxTreeTableCell`
  * @define TTYPE  The type of the elements contained within the `TreeTableColumn`.
  * @define FTCINIT Creates a ComboBox cell factory for use in [[scalafx.scene.control.TreeTableColumn]] controls.
  * @define ITEMSPARAM Zero or more items that will be shown to the user when the `ComboBox` menu is showing.
  * @define CONVPARAM A [[scalafx.util.StringConverter]] to convert the given item (of type T) to a String for displaying to the user.
  * @define RET A function that will return a TableCell that is able to work on the type of element contained within the TableColumn.
  * @define JFX JavaFX
  * @define SFX ScalaFX
  * @define URL0 [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/cell/CheckBoxTreeTableCell.html
  * @define ORIGINALDOC Original Documentation]].
  * @define SATISFY Added just to satisfy Spec tests.
  */
object ComboBoxTreeTableCell {

  /**
    * Converts a $SFX $CBTC to its JavaFX counterpart.
    *
    * @tparam T $TTYPE
    * @param cell $SFX $CBTC
    * @return $JFX $CBTC
    */
  implicit def sfxComboBoxTreeTableCell2jfx[S, T](
      cell: ComboBoxTreeTableCell[S, T]
  ): jfxsc.cell.ComboBoxTreeTableCell[S, T] =
    if (cell != null) cell.delegate else null

  /**
    * $FTCINIT
    *
    * @tparam T $TTYPE
    * @param items $ITEMSPARAM
    * @return $RET
    */
  def forTreeTableColumn[S, T](items: ObservableBuffer[T]): (jfxsc.TreeTableColumn[S, T] => TreeTableCell[S, T]) =
    (view: jfxsc.TreeTableColumn[S, T]) => jfxscc.ComboBoxTreeTableCell.forTreeTableColumn[S, T](items).call(view)

  /**
    * $SATISFY
    */
  @deprecated(message = "Use forTreeTableColumn[S, T](ObservableBuffer[S, T])", since = "8.0")
  def forTreeTableColumn[S, T](items: jfxc.ObservableList[T]) =
    jfxscc.ComboBoxTreeTableCell.forTreeTableColumn[S, T](items)

  /**
    * $FTCINIT
    *
    * @tparam $TTYPE
    * @param converter $CONVPARAM
    * @param items $ITEMSPARAM
    * @return $RET
    */
  def forTreeTableColumn[S, T](
      converter: StringConverter[T],
      items: ObservableBuffer[T]
  ): (jfxsc.TreeTableColumn[S, T] => TreeTableCell[S, T]) =
    (view: jfxsc.TreeTableColumn[S, T]) =>
      jfxscc.ComboBoxTreeTableCell.forTreeTableColumn[S, T](converter, items).call(view)

  /**
    * $SATISFY
    */
  @deprecated(message = "Use forTreeTableColumn[S, T](StringConverter[S, T], ObservableBuffer[S, T])", since = "8.0")
  def forTreeTableColumn[S, T](converter: jfxu.StringConverter[T], items: jfxc.ObservableList[T]) =
    jfxscc.ComboBoxTreeTableCell.forTreeTableColumn[S, T](converter, items)

  /**
    * $FTCINIT
    *
    * @tparam $TTYPE
    * @param converter $CONVPARAM
    * @param items $ITEMSPARAM
    * @return $RET
    */
  def forTreeTableColumn[S, T](
      converter: StringConverter[T],
      items: T*
  ): (jfxsc.TreeTableColumn[S, T] => TreeTableCell[S, T]) =
    (view: jfxsc.TreeTableColumn[S, T]) =>
      jfxscc.ComboBoxTreeTableCell.forTreeTableColumn[S, T](converter, items: _*).call(view)

  /**
    * $SATISFY
    */
  @deprecated(message = "Use forTreeTableColumn[S, T](StringConverter[S, T], T*)", since = "8.0")
  def forTreeTableColumn[S, T](converter: jfxu.StringConverter[T], items: T*) =
    jfxscc.ComboBoxTreeTableCell.forTreeTableColumn[S, T](converter, items: _*)

  /**
    * $FTCINIT
    *
    * @tparam $TTYPE
    * @param items $ITEMSPARAM
    * @return $RET
    */
  def forTreeTableColumn[S, T](items: T*): (jfxsc.TreeTableColumn[S, T] => TreeTableCell[S, T]) =
    (view: jfxsc.TreeTableColumn[S, T]) => jfxscc.ComboBoxTreeTableCell.forTreeTableColumn[S, T](items: _*).call(view)

  /**
    * $SATISFY
    */
  @deprecated(message = "Use forTreeTableColumn[S, T](T*)", since = "8.0")
  def forTreeTableColumn[S, T](items: Array[T]) = jfxscc.ComboBoxTreeTableCell.forTreeTableColumn[S, T](items: _*)

}

/**
  * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/cell/ComboBoxTreeTableCell.html $CBTC]]
  *
  * @tparam T Type used in this cell
  * @constructor Creates a new $CBTC from a $JFX $CBTC
  * @param delegate $JFX $CBTC
  * @since 8.0
  *
  * @define CBTC `ComboBoxTreeTableCell`
  * @define CMBX `ComboBox`
  * @define STCV `StringConverter`
  * @define CONSTRCONVERTER Creates a $CBTC instance with the given items being used to populate the $CMBX when it is shown, and the $STCV being used to convert the item in to a user-readable form.
  * @define CONSTITEMS Creates a default $CBTC instance with the given items being used to populate the $CMBX when it is shown.
  * @define CONVPARAM A $STCV that can convert an item of type T into a user-readable string so that it may then be shown in the $CMBX popup menu.
  * @define ITEMSPARAM The items to show in the $CMBX popup menu when selected by the user.
  */
class ComboBoxTreeTableCell[S, T](
    override val delegate: jfxscc.ComboBoxTreeTableCell[S, T] = new jfxscc.ComboBoxTreeTableCell[S, T]
) extends TreeTableCell[S, T](delegate)
    with ConvertableCell[jfxscc.ComboBoxTreeTableCell[S, T], T, T]
    with ComboBoxEditableCell[jfxscc.ComboBoxTreeTableCell[S, T], T]
    with UpdatableCell[jfxscc.ComboBoxTreeTableCell[S, T], T]
    with ItemableCell[jfxscc.ComboBoxTreeTableCell[S, T], T]
    with SFXDelegate[jfxscc.ComboBoxTreeTableCell[S, T]] {

  /**
    * $CONSTITEMS
    *
    * @param items $ITEMSPARAM
    */
  def this(items: ObservableBuffer[T]) = this(new jfxscc.ComboBoxTreeTableCell[S, T](items))

  /**
    * $CONSTRCONVERTER
    *
    * @param converter $CONVPARAM
    * @param items $ITEMSPARAM
    */
  def this(converter: StringConverter[T], items: ObservableBuffer[T]) =
    this(new jfxscc.ComboBoxTreeTableCell[S, T](converter, items))

  /**
    * $CONSTRCONVERTER
    *
    * @param converter $CONVPARAM
    * @param items $ITEMSPARAM
    */
  def this(converter: StringConverter[T], items: T*) =
    this(new jfxscc.ComboBoxTreeTableCell[S, T](converter, items: _*))

  /**
    * $CONSTITEMS
    *
    * @param items $ITEMSPARAM
    */
  def this(items: T*) = this(new jfxscc.ComboBoxTreeTableCell[S, T](items: _*))

}
