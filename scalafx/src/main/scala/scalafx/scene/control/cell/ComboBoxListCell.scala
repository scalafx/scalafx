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
import scalafx.scene.control.ListCell
import scalafx.scene.control.ListView
import scalafx.delegate.SFXDelegate
import scalafx.util.StringConverter

/**
 * Companion Object for [[scalafx.scene.control.cell.ComboBoxListCell]].
 *
 * @define CBLC `ComboBoxListCell`
 * @define TTYPE  The type of the elements contained within the `TableColumn`.
 * @define FLVINIT Creates a ComboBox cell factory for use in [[scalafx.scene.control.ListView]] controls.
 * @define FLVINITDEPREC Added to satisfy Spec tests.
 * @define ITEMSPARAM Zero or more items that will be shown to the user when the `ComboBox` menu is showing.
 * @define CONVPARAM A [[scalafx.util.StringConverter]] to convert the given item (of type T) to a String for displaying to the user.
 * @define RET A function that will return a ListCell that is able to work on the type of element contained within the ListView. 
 */
object ComboBoxListCell {

  /**
   * Converts a ScalaFX $CBLC to its JavaFX counterpart.
   *
   * @tparam T $TTYPE
   * @param cell ScalaFX $CBLC
   * @return JavaFX $CBLC
   */
  implicit def sfxComboBoxListCell2jfx[T](cell: ComboBoxListCell[T]) = cell.delegate

  /**
   * $FLVINIT
   * 
   * @param items $ITEMSPARAM
   * @return $RET
   */
  def forListView[T](items: ObservableBuffer[T]): (ListView[T] => ListCell[T]) =
    (view: ListView[T]) => jfxscc.ComboBoxListCell.forListView[T](items).call(view)

  /**
   * $FLVINITDEPREC 
   */
  @deprecated(message = "Use forListView[T](T => ObservableValue[Boolean, java.lang.Boolean])", since = "1.0")
  def forListView[T](items: jfxc.ObservableList[T]) = jfxscc.ComboBoxListCell.forListView(items)

  /**
   * $FLVINIT
   * 
   * @param converter $CONVPARAM 
   * @param items $ITEMSPARAM
   * @return $RET
   */
  def forListView[T](converter: StringConverter[T], items: ObservableBuffer[T]): (ListView[T] => ListCell[T]) =
    (view: ListView[T]) => jfxscc.ComboBoxListCell.forListView[T](converter, items).call(view)

  /**
   * $FLVINITDEPREC 
   */
  @deprecated(message = "Use forListView[T](StringConverter[T], ObservableBuffer[T])", since = "1.0")
  def forListView[T](converter: jfxu.StringConverter[T], items: jfxc.ObservableList[T]) =
    jfxscc.ComboBoxListCell.forListView(converter, items)

  /**
   * $FLVINIT
   * 
   * @param converter $CONVPARAM 
   * @param items $ITEMSPARAM
   * @return $RET
   */
  def forListView[T](converter: StringConverter[T], items: T*): (ListView[T] => ListCell[T]) =
    (view: ListView[T]) => jfxscc.ComboBoxListCell.forListView[T](converter, items: _*).call(view)

  /**
   * $FLVINITDEPREC 
   */
  @deprecated(message = "Use forListView[T](StringConverter[T], T*)", since = "1.0")
  def forListView[T](converter: jfxu.StringConverter[T], items: T*) =
    jfxscc.ComboBoxListCell.forListView[T](converter, items: _*)

  /**
   * $FLVINIT
   * 
   * @param items $ITEMSPARAM
   * @return $RET
   */
  def forListView[T](items: T*): (ListView[T] => ListCell[T]) =
    (view: ListView[T]) => jfxscc.ComboBoxListCell.forListView[T](items: _*).call(view)

}

/**
 * Wraps [[http://docs.oracle.com/javafx/2/api/javafx/scene/control/cell/ChoiceBoxTreeCell.html $CBLC]]
 * 
 * @tparam T Type used in this cell
 * @constructor Creates a new $CBLC from a JavaFX $CBLC
 * @param delegate JavaFX $CBLC
 * 
 * @define CBLC `ChoiceBoxListCell`
 * @define CMBX `ComboBox`
 * @define STCV `StringConverter`
 * @define CONSTRCONVERTER Creates a $CBLC instance with the given items being used to populate the $CMBX when it is shown, and the $STCV being used to convert the item in to a user-readable form.
 * @define CONSTITEMS Creates a default $CBLC instance with the given items being used to populate the $CMBX when it is shown.
 * @define CONVPARAM A $STCV that can convert an item of type T into a user-readable string so that it may then be shown in the $CMBX popup menu.
 * @define ITEMSPARAM The items to show in the $CMBX popup menu when selected by the user. 
 */
class ComboBoxListCell[T](override val delegate: jfxscc.ComboBoxListCell[T] = new jfxscc.ComboBoxListCell[T])
  extends ListCell[T](delegate)
  with ConvertableCell[jfxscc.ComboBoxListCell[T], T, T]
  with ComboBoxEditableCell[jfxscc.ComboBoxListCell[T], T]
  with UpdatableCell[jfxscc.ComboBoxListCell[T], T]
  with ItemableCell[jfxscc.ComboBoxListCell[T], T]
  with SFXDelegate[jfxscc.ComboBoxListCell[T]] {

  /**
   * $CONSTITEMS 
   * 
   * @param items $ITEMSPARAM 
   */
  def this(items: ObservableBuffer[T]) = this(new jfxscc.ComboBoxListCell[T](items))

  /**
   * $CONSTRCONVERTER
   * 
   * @param converter $CONVPARAM
   * @param items $ITEMSPARAM 
   */
  def this(converter: StringConverter[T], items: ObservableBuffer[T]) = this(new jfxscc.ComboBoxListCell[T](converter, items))

  /**
   * $CONSTRCONVERTER
   * 
   * @param converter $CONVPARAM
   * @param items $ITEMSPARAM 
   */
  def this(converter: StringConverter[T], items: T*) = this(new jfxscc.ComboBoxListCell[T](converter, items: _*))

  /**
   * $CONSTITEMS 
   * 
   * @param items $ITEMSPARAM 
   */
  def this(items: T*) = this(new jfxscc.ComboBoxListCell[T](items: _*))

}