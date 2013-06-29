/*
 * Copyright (c) 2011-2013, ScalaFX Project
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

import javafx.{ collections => jfxc }
import javafx.scene.control.{ cell => jfxscc }
import javafx.{ util => jfxu }
import scalafx.Includes._
import scalafx.collections.ObservableBuffer
import scalafx.scene.control.TreeCell
import scalafx.scene.control.TreeView
import scalafx.delegate.SFXDelegate
import scalafx.util.StringConverter

/**
 * Companion Object for [[scalafx.scene.control.cell.ComboBoxTreeCell]].
 *
 * @define CBTC `ComboBoxTreeCell`
 * @define TTYPE  The type of the elements contained within the `TreeView`.
 * @define FTCINIT Creates a ComboBox cell factory for use in [[scalafx.scene.control.TreeView]] controls.
 * @define FTCINITDEPREC Added to satisfy Spec tests.
 * @define ITEMSPARAM Zero or more items that will be shown to the user when the `ComboBox` menu is showing.
 * @define CONVPARAM A [[scalafx.util.StringConverter]] to convert the given item (of type T) to a String for displaying to the user.
 * @define RET A function that will return a TableCell that is able to work on the type of element contained within the TableColumn.
 */
object ComboBoxTreeCell {

  /**
   * Converts a ScalaFX $CBTC to its JavaFX counterpart.
   *
   * @tparam T $TTYPE
   * @param cell ScalaFX $CBTC
   * @return JavaFX $CBTC
   */
  implicit def sfxComboBoxTreeCell2jfx[T](cell: ComboBoxTreeCell[T]) = cell.delegate

  /**
   * $FTCINIT
   *
   * @tparam $TTYPE
   * @param items $ITEMSPARAM
   * @return $RET
   */
  def forTreeView[T](items: ObservableBuffer[T]): (TreeView[T] => TreeCell[T]) =
    (view: TreeView[T]) => jfxscc.ComboBoxTreeCell.forTreeView[T](items).call(view)

  /**
   * $FTCINITDEPREC
   */
  @deprecated(message = "Use forTreeView[T](ObservableBuffer[T])", since = "1.0")
  def forTreeView[T](items: jfxc.ObservableList[T]) = jfxscc.ComboBoxTreeCell.forTreeView[T](items)

  /**
   * $FTCINIT
   *
   * @tparam $TTYPE
   * @param converter $CONVPARAM
   * @param items $ITEMSPARAM
   * @return $RET
   */
  def forTreeView[T](converter: StringConverter[T], items: ObservableBuffer[T]): (TreeView[T] => TreeCell[T]) =
    (view: TreeView[T]) => jfxscc.ComboBoxTreeCell.forTreeView[T](converter, items).call(view)

  /**
   * $FTCINITDEPREC
   */
  @deprecated(message = "Use forTreeView[T](StringConverter[T], ObservableBuffer[T])", since = "1.0")
  def forTreeView[T](converter: jfxu.StringConverter[T], items: jfxc.ObservableList[T]) =
    jfxscc.ComboBoxTreeCell.forTreeView[T](converter, items)

  /**
   * $FTCINIT
   *
   * @tparam $TTYPE
   * @param converter $CONVPARAM
   * @param items $ITEMSPARAM
   * @return $RET
   */
  def forTreeView[T](converter: StringConverter[T], items: T*): (TreeView[T] => TreeCell[T]) =
    (view: TreeView[T]) => jfxscc.ComboBoxTreeCell.forTreeView[T](converter, items: _*).call(view)

  /**
   * $FTCINITDEPREC
   */
  @deprecated(message = "Use forTreeView[T](StringConverter[T], T*)", since = "1.0")
  def forTreeView[T](converter: jfxu.StringConverter[T], items: T*) = jfxscc.ComboBoxTreeCell.forTreeView[T](converter, items: _*)

  /**
   * $FTCINIT
   *
   * @tparam $TTYPE
   * @param items $ITEMSPARAM
   * @return $RET
   */
  def forTreeView[T](items: T*): (TreeView[T] => TreeCell[T]) =
    (view: TreeView[T]) => jfxscc.ComboBoxTreeCell.forTreeView[T](items: _*).call(view)

  /**
   * $FTCINITDEPREC
   */
  @deprecated(message = "Use forTreeView[T](T*)", since = "1.0")
  def forTreeView[T](items: Array[T]) = jfxscc.ComboBoxTreeCell.forTreeView[T](items: _*)

}

/**
 * Wraps [[http://docs.oracle.com/javafx/2/api/javafx/scene/control/cell/ComboBoxTreeCell.html $CBTC]]
 *
 * @tparam T Type used in this cell
 * @constructor Creates a new $CBTC from a JavaFX $CBTC
 * @param delegate JavaFX $CBTC
 *
 * @define CBTC `ComboBoxTreeCell`
 * @define CMBX `ComboBox`
 * @define STCV `StringConverter`
 * @define CONSTRCONVERTER Creates a $CBTC instance with the given items being used to populate the $CMBX when it is shown, and the $STCV being used to convert the item in to a user-readable form.
 * @define CONSTITEMS Creates a default $CBTC instance with the given items being used to populate the $CMBX when it is shown.
 * @define CONVPARAM A $STCV that can convert an item of type T into a user-readable string so that it may then be shown in the $CMBX popup menu.
 * @define ITEMSPARAM The items to show in the $CMBX popup menu when selected by the user.
 */
class ComboBoxTreeCell[T](override val delegate: jfxscc.ComboBoxTreeCell[T] = new jfxscc.ComboBoxTreeCell[T])
  extends TreeCell[T](delegate)
  with ConvertableCell[jfxscc.ComboBoxTreeCell[T], T, T]
  with ComboBoxEditableCell[jfxscc.ComboBoxTreeCell[T], T]
  with UpdatableCell[jfxscc.ComboBoxTreeCell[T], T]
  with ItemableCell[jfxscc.ComboBoxTreeCell[T], T]
  with SFXDelegate[jfxscc.ComboBoxTreeCell[T]] {

  /**
   * $CONSTITEMS
   *
   * @param items $ITEMSPARAM
   */
  def this(items: ObservableBuffer[T]) = this(new jfxscc.ComboBoxTreeCell[T](items))

  /**
   * $CONSTRCONVERTER
   *
   * @param converter $CONVPARAM
   * @param items $ITEMSPARAM
   */
  def this(converter: StringConverter[T], items: ObservableBuffer[T]) = this(new jfxscc.ComboBoxTreeCell[T](converter, items))

  /**
   * $CONSTRCONVERTER
   *
   * @param converter $CONVPARAM
   * @param items $ITEMSPARAM
   */
  def this(converter: StringConverter[T], items: T*) = this(new jfxscc.ComboBoxTreeCell[T](converter, items: _*))

  /**
   * $CONSTITEMS
   *
   * @param items $ITEMSPARAM
   */
  def this(items: T*) = this(new jfxscc.ComboBoxTreeCell[T](items: _*))

}