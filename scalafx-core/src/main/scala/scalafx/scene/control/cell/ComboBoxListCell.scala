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

object ComboBoxListCell {
  implicit def sfxComboBoxListCell2jfx[T](cell: ComboBoxListCell[T]) = cell.delegate

  /**
   * Creates a ComboBox cell factory for use in ListView controls.
   */
  def forListView[T](items: ObservableBuffer[T]): (ListView[T] => ListCell[T]) =
    (view: ListView[T]) => jfxscc.ComboBoxListCell.forListView[T](items).call(view)

  /**
   * Added to satisfy Spec tests.
   */
  @deprecated(message = "Use forListView[T](T => ObservableValue[Boolean, java.lang.Boolean])", since = "1.0")
  def forListView[T](items: jfxc.ObservableList[T]) = jfxscc.ComboBoxListCell.forListView(items)

  /**
   * Creates a ComboBox cell factory for use in ListView controls.
   */
  def forListView[T](converter: StringConverter[T], items: ObservableBuffer[T]): (ListView[T] => ListCell[T]) =
    (view: ListView[T]) => jfxscc.ComboBoxListCell.forListView[T](converter, items).call(view)

  /**
   * Added to satisfy Spec tests.
   */
  @deprecated(message = "Use forListView[T](StringConverter[T], ObservableBuffer[T])", since = "1.0")
  def forListView[T](converter: jfxu.StringConverter[T], items: jfxc.ObservableList[T]) =
    jfxscc.ComboBoxListCell.forListView(converter, items)

  /**
   * Creates a ComboBox cell factory for use in ListView controls.
   */
  def forListView[T](converter: StringConverter[T], items: T*): (ListView[T] => ListCell[T]) =
    (view: ListView[T]) => jfxscc.ComboBoxListCell.forListView[T](converter, items: _*).call(view)

  /**
   * Added to satisfy Spec tests.
   */
  @deprecated(message = "Use forListView[T](StringConverter[T], T*)", since = "1.0")
  def forListView[T](converter: jfxu.StringConverter[T], items: T*) =
    jfxscc.ComboBoxListCell.forListView[T](converter, items: _*)

  /**
   * Creates a ComboBox cell factory for use in ListView controls.
   */
  def forListView[T](items: T*): (ListView[T] => ListCell[T]) =
    (view: ListView[T]) => jfxscc.ComboBoxListCell.forListView[T](items: _*).call(view)

}

class ComboBoxListCell[T](override val delegate: jfxscc.ComboBoxListCell[T] = new jfxscc.ComboBoxListCell[T])
  extends ListCell[T](delegate)
  with ConvertableCell[jfxscc.ComboBoxListCell[T], T, T]
  with ComboBoxEditableCell[jfxscc.ComboBoxListCell[T], T]
  with UpdatableCell[jfxscc.ComboBoxListCell[T], T]
  with ItemnableCell[jfxscc.ComboBoxListCell[T], T]
  with SFXDelegate[jfxscc.ComboBoxListCell[T]] {

  /**
   * Creates a default `ComboBoxListCell` instance with the given items being used to populate the `ComboBox` when
   * it is shown.
   */
  def this(items: ObservableBuffer[T]) = this(new jfxscc.ComboBoxListCell[T](items))

  /**
   * Creates a `ComboBoxListCell` instance with the given items being used to populate the `ComboBox` when it is
   * shown, and the `StringConverter` being used to convert the item in to a user-readable form.
   */
  def this(converter: StringConverter[T], items: ObservableBuffer[T]) = this(new jfxscc.ComboBoxListCell[T](converter, items))

  /**
   * Creates a `ComboBoxListCell` instance with the given items being used to populate the `ComboBox` when it is
   * shown, and the `StringConverter` being used to convert the item in to a user-readable form.
   */
  def this(converter: StringConverter[T], items: T*) = this(new jfxscc.ComboBoxListCell[T](converter, items: _*))

  /**
   * Creates a default `ComboBoxListCell` instance with the given items being used to populate the `ComboBox` when
   * it is shown.
   */
  def this(items: T*) = this(new jfxscc.ComboBoxListCell[T](items: _*))

}