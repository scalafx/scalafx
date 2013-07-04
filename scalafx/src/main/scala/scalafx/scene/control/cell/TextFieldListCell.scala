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

import javafx.scene.control.{ cell => jfxscc }
import javafx.{ util => jfxu }
import scalafx.Includes._
import scalafx.scene.control.ListCell
import scalafx.scene.control.ListView
import scalafx.delegate.SFXDelegate
import scalafx.util.StringConverter

/**
 * Companion Object for [[scalafx.scene.control.cell.TextFieldListCell]].
 *
 * @define TFLC `TextFieldListCell`
 * @define TTYPE  The type of the elements contained within the `ListView`.
 * @define FLVINTI Provides a `TextField` that allows editing of the cell content when the cell is double-clicked, or when `ListView.edit(int)` is called.
 * @define FLVRET A Function that can be inserted into the cell factory property of a `ListView`, that enables textual editing of the content.
 */
object TextFieldListCell {

  /**
   * Converts a ScalaFX $TFLC to its JavaFX counterpart.
   *
   * @tparam T $TTYPE
   * @param cell ScalaFX $TFLC
   * @return JavaFX $TFLC
   */
  implicit def sfxTextFieldListCell2jfx[T](cell: TextFieldListCell[T]) = cell.delegate

  /**
   * $FLVINTI
   * 
   * @return $FLVRET
   */
  def forListView(): (ListView[String] => ListCell[String]) =
    (view: ListView[String]) => jfxscc.TextFieldListCell.forListView().call(view)

  /**
   * $FLVINTI
   *
   * @param converter A `StringConverter` that can convert the given String (from what the user typed in) into an instance of type T.
   * @return $FLVRET
   */
  def forListView[T](converter: StringConverter[T]): (ListView[T] => ListCell[T]) =
    (view: ListView[T]) => jfxscc.TextFieldListCell.forListView[T](converter).call(view)

  /**
   * Added to satisfy Spec Texts.
   */
  @deprecated(message = "Use forListView[T](StringConverter[T])", since = "1.0")
  def forListView[T](converter: jfxu.StringConverter[T]) = jfxscc.TextFieldListCell.forListView[T](converter)

}

/**
 * Wraps [[http://docs.oracle.com/javafx/2/api/javafx/scene/control/cell/TextFieldListCell.html $TFLC]]
 *
 * @tparam T Type used in this cell
 * @constructor Creates a new $TFLC from a JavaFX $TFLC
 * @param delegate JavaFX $TFLC
 *
 * @define TFLC `TextFieldListCell`
 */
class TextFieldListCell[T](override val delegate: jfxscc.TextFieldListCell[T] = new jfxscc.TextFieldListCell[T])
  extends ListCell[T](delegate)
  with ConvertableCell[jfxscc.TextFieldListCell[T], T, T]
  with UpdatableCell[jfxscc.TextFieldListCell[T], T]
  with SFXDelegate[jfxscc.TextFieldListCell[T]] {

  /**
   * Creates a `TextFieldListCell` that provides a TextField when put into editing mode that allows editing of the
   * cell content.
   *
   * @param converter A `converter` that can convert the given String (from what the user typed in) into an instance of type T.
   */
  def this(converter: StringConverter[T]) = this(new jfxscc.TextFieldListCell[T](converter))

}