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

import javafx.scene.control.{cell => jfxscc}
import javafx.{util => jfxu}
import scalafx.Includes._
import scalafx.delegate.SFXDelegate
import scalafx.scene.control.TableCell
import scalafx.scene.control.TableColumn
import scalafx.util.StringConverter

/**
 * Companion Object for [[scalafx.scene.control.cell.TextFieldTableCell]].
 *
 * @define TFTC `TextFieldTableCell`
 * @define TTYPE  The type of the elements contained within the `ListView`.
 * @define FLVINIT Provides a `TextField` that allows editing of the cell content when the cell is double-clicked, or when `TableView.edit(int, scalafx.scene.control.TableColumn)` is called.
 * @define FLVRET A Function  that can be inserted into the cell factory property of a `TableColumn`, that enables textual editing of the content.
 */
object TextFieldTableCell {

  /**
   * Converts a ScalaFX $TFTC to its JavaFX counterpart.
   *
   * @tparam T $TTYPE
   * @param cell ScalaFX $TFTC
   * @return JavaFX $TFTC
   */
  implicit def sfxTextFieldTableCell2jfx[S, T](cell: TextFieldTableCell[S, T]) = cell.delegate

  /**
   * $FLVINIT
   *
   * @return $FLVRET
   */
  def forTableColumn[S](): (TableColumn[S, String] => TableCell[S, String]) =
    (view: TableColumn[S, String]) => jfxscc.TextFieldTableCell.forTableColumn[S]().call(view)

  /**
   * $FLVINIT
   *
   * @param converter A `StringConverter` that can convert the given String (from what the user typed in) into an instance of type T.
   * @return $FLVRET
   */
  def forTableColumn[S, T](converter: StringConverter[T]): (TableColumn[S, T] => TableCell[S, T]) =
    (view: TableColumn[S, T]) => jfxscc.TextFieldTableCell.forTableColumn[S, T](converter).call(view)

  /**
   * Added to satisfy Spec Texts.
   */
  @deprecated(message = "Use forTableColumn[S, T](StringConverter[T])", since = "1.0")
  def forTableColumn[S, T](converter: jfxu.StringConverter[T]) = jfxscc.TextFieldTableCell.forTableColumn[S, T](converter)

}

/**
 * Wraps [[http://docs.oracle.com/javafx/2/api/javafx/scene/control/cell/TextFieldTableCell.html $TFTC]]
 *
 * @tparam T Type used in this cell
 * @constructor Creates a new $TFTC from a JavaFX $TFTC
 * @param delegate JavaFX $TFTC
 *
 * @define TFTC `TextFieldTableCell`
 */
class TextFieldTableCell[S, T](override val delegate: jfxscc.TextFieldTableCell[S, T] = new jfxscc.TextFieldTableCell[S, T])
  extends TableCell[S, T](delegate)
  with ConvertableCell[jfxscc.TextFieldTableCell[S, T], T, T]
  with UpdatableCell[jfxscc.TextFieldTableCell[S, T], T]
  with SFXDelegate[jfxscc.TextFieldTableCell[S, T]] {

  /**
   * Creates a `TextFieldTableCell` that provides a TextField when put into editing mode that allows editing of the
   * cell content.
   *
   * @param converter A `converter` that can convert the given String (from what the user typed in) into an instance of type T.
   */
  def this(converter: StringConverter[T]) = this(new jfxscc.TextFieldTableCell[S, T](converter))

}