/*
 * Copyright (c) 2011-2014, ScalaFX Project
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
import javafx.{util => jfxu}

import scala.language.implicitConversions
import scalafx.Includes.jfxTreeTableCell2sfx
import scalafx.delegate.SFXDelegate
import scalafx.scene.control.TreeTableCell
import scalafx.util.StringConverter
import scalafx.util.StringConverter.sfxStringConverter2jfx

/**
  * Companion Object for [[scalafx.scene.control.cell.TextFieldTreeTableCell]].
  *
  * @define TFTC `TextFieldTreeTableCell`
  * @define TTYPE  The type of the elements contained within the `ListView`.
  * @define FLVINIT Provides a `TextField that allows editing of the cell content when the cell is double-clicked, or when TreeView.edit(javafx.scene.control.TreeItem) is called.
  * @define FLVRET A Function that can be inserted into the cell factory property of a `TreeView`, that enables textual editing of the content.
  */
object TextFieldTreeTableCell {

  /**
    * Converts a ScalaFX $TFTC to its JavaFX counterpart.
    *
    * @tparam T $TTYPE
    * @param cell ScalaFX $TFTC
    * @return JavaFX $TFTC
    */
  implicit def sfxTextFieldTreeTableCell2jfx[S, T](
      cell: TextFieldTreeTableCell[S, T]
  ): jfxsc.cell.TextFieldTreeTableCell[S, T] =
    if (cell != null) cell.delegate else null

  /**
    * $FLVINIT
    *
    * @return $FLVRET
    */
  def forTreeTableColumn[S](): (jfxsc.TreeTableColumn[S, String] => TreeTableCell[S, String]) =
    (view: jfxsc.TreeTableColumn[S, String]) => jfxscc.TextFieldTreeTableCell.forTreeTableColumn[S]().call(view)

  /**
    * $FLVINIT
    *
    * @param converter A `StringConverter` that can convert the given String (from what the user typed in) into an instance of type T.
    * @return $FLVRET
    */
  def forTreeTableColumn[S, T](converter: StringConverter[T]): (jfxsc.TreeTableColumn[S, T] => TreeTableCell[S, T]) =
    (view: jfxsc.TreeTableColumn[S, T]) => jfxscc.TextFieldTreeTableCell.forTreeTableColumn[S, T](converter).call(view)

  /**
    * Added to satisfy Spec tests.
    */
  @deprecated(message = "Use forTreeTableColumn[S, T](StringConverter[T])", since = "1.0")
  def forTreeTableColumn[S, T](converter: jfxu.StringConverter[T]) =
    jfxscc.TextFieldTreeTableCell.forTreeTableColumn[S, T](converter)

}

/**
  * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/cell/TextFieldTreeTableCell.html $TFTC]]
  *
  * @tparam T Type used in this cell
  * @constructor Creates a new $TFTC from a JavaFX $TFTC
  * @param delegate JavaFX $TFTC
  *
  * @define TFTC `TextFieldTreeTableCell`
  */
class TextFieldTreeTableCell[S, T](
    override val delegate: jfxscc.TextFieldTreeTableCell[S, T] = new jfxscc.TextFieldTreeTableCell[S, T]
) extends TreeTableCell[S, T](delegate)
    with ConvertableCell[jfxscc.TextFieldTreeTableCell[S, T], T, T]
    with UpdatableCell[jfxscc.TextFieldTreeTableCell[S, T], T]
    with SFXDelegate[jfxscc.TextFieldTreeTableCell[S, T]] {

  /**
    * Creates a `TextFieldTreeTableCell` that provides a `TextField` when put into editing mode that allows editing of the
    * cell content.
    *
    * @param converter A `converter` that can convert the given String (from what the user typed in) into an instance of type T.
    */
  def this(converter: StringConverter[T]) = this(new jfxscc.TextFieldTreeTableCell[S, T](converter))

}
