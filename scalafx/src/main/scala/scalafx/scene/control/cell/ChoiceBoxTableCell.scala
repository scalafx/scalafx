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
import scalafx.scene.control.TableCell
import scalafx.scene.control.TableColumn
import scalafx.delegate.SFXDelegate
import scalafx.util.StringConverter

object ChoiceBoxTableCell {
  implicit def sfxChoiceBoxTableCell2jfx[S, T](cell: ChoiceBoxTableCell[S, T]) = cell.delegate

  /**
   * Creates a ChoiceBox cell factory for use in `TableColumn` controls.
   */
  def forTableColumn[S, T](items: ObservableBuffer[T]): (TableColumn[S, T] => TableCell[S, T]) =
    (view: TableColumn[S, T]) => jfxscc.ChoiceBoxTableCell.forTableColumn[S, T](items).call(view)

  /**
   * Added to satisfy Spec tests.
   */
  @deprecated(message = "Use forTableColumn[S, T](ObservableBuffer[T])", since = "1.0")
  def forTableColumn[S, T](items: jfxc.ObservableList[T]) = jfxscc.ChoiceBoxTableCell.forTableColumn[S, T](items)

  /**
   * Creates a ChoiceBox cell factory for use in `TableColumn` controls.
   */
  def forTableColumn[S, T](converter: StringConverter[T], items: ObservableBuffer[T]): (TableColumn[S, T] => TableCell[S, T]) =
    (view: TableColumn[S, T]) => jfxscc.ChoiceBoxTableCell.forTableColumn[S, T](converter, items).call(view)

  /**
   * Added to satisfy Spec tests.
   */
  @deprecated(message = "Use forTableColumn[S, T](StringConverter[T], ObservableBuffer[T])", since = "1.0")
  def forTableColumn[S, T](converter: jfxu.StringConverter[T], items: jfxc.ObservableList[T]) =
    jfxscc.ChoiceBoxTableCell.forTableColumn[S, T](converter, items)

  /**
   * Creates a ChoiceBox cell factory for use in `TableColumn` controls.
   */
  def forTableColumn[S, T](converter: StringConverter[T], items: T*): (TableColumn[S, T] => TableCell[S, T]) =
    (view: TableColumn[S, T]) => jfxscc.ChoiceBoxTableCell.forTableColumn[S, T](converter, items: _*).call(view)

  /**
   * Added to satisfy Spec tests.
   */
  @deprecated(message = "Use forTableColumn[S, T](StringConverter[T], T*)", since = "1.0")
  def forTableColumn[S, T](converter: jfxu.StringConverter[T], items: T*) = jfxscc.ChoiceBoxTableCell.forTableColumn[S, T](converter, items: _*)

  /**
   * Creates a ChoiceBox cell factory for use in `TableColumn` controls.
   */
  def forTableColumn[S, T](items: T*): (TableColumn[S, T] => TableCell[S, T]) =
    (view: TableColumn[S, T]) => jfxscc.ChoiceBoxTableCell.forTableColumn[S, T](items: _*).call(view)

  /**
   * Added to satisfy Spec tests.
   */
  @deprecated(message = "Use forTableColumn[S, T](T*)", since = "1.0")
  def forTableColumn[S, T](items: Array[T]) = jfxscc.ChoiceBoxTableCell.forTableColumn[S, T](items: _*)

}

/**
 * Wraps [[http://docs.oracle.com/javafx/2/api/javafx/scene/control/cell/ChoiceBoxListCell.html]]
 */
class ChoiceBoxTableCell[S, T](override val delegate: jfxscc.ChoiceBoxTableCell[S, T] = new jfxscc.ChoiceBoxTableCell[S, T])
  extends TableCell[S, T](delegate)
  with ConvertableCell[jfxscc.ChoiceBoxTableCell[S, T], T, T]
  with UpdatableCell[jfxscc.ChoiceBoxTableCell[S, T], T]
  with ItemableCell[jfxscc.ChoiceBoxTableCell[S, T], T]
  with SFXDelegate[jfxscc.ChoiceBoxTableCell[S, T]] {

  /**
   * Creates a default `ChoiceBoxListCell` instance with the given items being used to populate the ChoiceBox when
   * it is shown.
   */
  def this(items: ObservableBuffer[T]) = this(new jfxscc.ChoiceBoxTableCell[S, T](items))

  /**
   * Creates a `ChoiceBoxListCell` instance with the given items being used to populate the `ChoiceBox` when it is
   * shown, and the StringConverter being used to convert the item in to a user-readable form.
   */
  def this(converter: StringConverter[T], items: ObservableBuffer[T]) = this(new jfxscc.ChoiceBoxTableCell[S, T](converter, items))

  /**
   * Creates a `ChoiceBoxListCell` instance with the given items being used to populate the `ChoiceBox` when it is
   * shown, and the StringConverter being used to convert the item in to a user-readable form.
   */
  def this(converter: StringConverter[T], items: T*) = this(new jfxscc.ChoiceBoxTableCell[S, T](converter, items: _*))

  /**
   * Creates a default `ChoiceBoxListCell` instance with the given items being used to populate the `ChoiceBox` when
   * it is shown.
   */
  def this(items: T*) = this(new jfxscc.ChoiceBoxTableCell[S, T](items: _*))

}