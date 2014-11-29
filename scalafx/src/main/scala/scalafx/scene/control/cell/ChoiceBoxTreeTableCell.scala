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
import javafx.{collections => jfxc, util => jfxu}

import scala.language.implicitConversions
import scalafx.Includes._
import scalafx.collections.ObservableBuffer
import scalafx.delegate.SFXDelegate
import scalafx.scene.control.TreeTableCell
import scalafx.util.StringConverter

/**
 * Companion Object for [[scalafx.scene.control.cell.ChoiceBoxTreeTableCell]].
 *
 * @since 8.0
 * @todo Replace all references to $JFX $TTC to its $SFX counterpart when it was created
 *
 * @define CBTTC `ChoiceBoxTreeTableCell`
 * @define TTC TreeTableColumn
 * @define FTTC Creates a [[scalafx.scene.control.ChoiceBox C h o i c e B o x]] cell factory for use in $TTC controls.
 * @define RETFTTC A Function that will return a $TTCL that is able to work on the type of element contained within the $TTC.
 * @define STYPE
 * @define TTYPE The type of the elements contained within the `$TTC` instance.
 * @define JFX JavaFX
 * @define SFX ScalaFX
 * @define URL0 [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/cell/CheckBoxTreeTableCell.html
 * @define ORIGINALDOC Original Documentation]].
 * @define SATISFY Added just to satisfy Spec tests.
 */
object ChoiceBoxTreeTableCell {

  /**
   * Converts a ScalaFX $CBTTC to its JavaFX counterpart.
   *
   * @tparam T $TTYPE
   * @param cell ScalaFX $CBTTC
   * @return JavaFX $CBTTC
   */
  implicit def sfxChoiceBoxTreeTableCell2jfx[S, T](cell: ChoiceBoxTreeTableCell[S, T]): jfxsc.cell.ChoiceBoxTreeTableCell[S, T] = if (cell != null) cell.delegate else null

  /**
   * $FTTC
   *
   * @tparam T $TTYPE
   * @param items $BUFITEMSPARAM
   * @return $RETFTTC
   * @see $URL0#ChoiceBoxTreeTableCell-javafx.collections.ObservableList- $ORIGINALDOC
   */
  def forTreeTableColumn[S, T](items: ObservableBuffer[T]): (jfxsc.TreeTableColumn[S, T] => TreeTableCell[S, T]) =
    (view: jfxsc.TreeTableColumn[S, T]) => jfxscc.ChoiceBoxTreeTableCell.forTreeTableColumn[S, T](items).call(view)

  /**
   * $SATISFY
   */
  @deprecated(message = "Use forTreeTableColumn[S, T](ObservableBuffer[T])", since = "1.0")
  def forTreeTableColumn[S, T](items: jfxc.ObservableList[T]) = jfxscc.ChoiceBoxTreeTableCell.forTreeTableColumn[S, T](items)

  /**
   * $FTTC
   *
   * @tparam T $TTYPE
   * @param converter $CONVPARAM
   * @param items $BUFITEMSPARAM
   * @return $RETFTTC
   * @see $URL0#ChoiceBoxTreeTableCell-javafx.util.StringConverter-javafx.collections.ObservableList- $ORIGINALDOC
   */
  def forTreeTableColumn[S, T](converter: StringConverter[T], items: ObservableBuffer[T]): (jfxsc.TreeTableColumn[S, T] => TreeTableCell[S, T]) =
    (view: jfxsc.TreeTableColumn[S, T]) => jfxscc.ChoiceBoxTreeTableCell.forTreeTableColumn[S, T](converter, items).call(view)

  /**
   * $SATISFY
   */
  @deprecated(message = "Use forTreeTableColumn[S, T](StringConverter[T], ObservableBuffer[T])", since = "1.0")
  def forTreeTableColumn[S, T](converter: jfxu.StringConverter[T], items: jfxc.ObservableList[T]) =
    jfxscc.ChoiceBoxTreeTableCell.forTreeTableColumn[S, T](converter, items)

  /**
   * $FTTC
   *
   * @tparam T $TTYPE
   * @param converter $CONVPARAM
   * @param items $ITEMSPARAM
   * @return $RETFTTC
   * @see $URL0#ChoiceBoxTreeTableCell-javafx.util.StringConverter-T...- $ORIGINALDOC
   */
  def forTreeTableColumn[S, T](converter: StringConverter[T], items: T*): (jfxsc.TreeTableColumn[S, T] => TreeTableCell[S, T]) =
    (view: jfxsc.TreeTableColumn[S, T]) => jfxscc.ChoiceBoxTreeTableCell.forTreeTableColumn[S, T](converter, items: _*).call(view)

  /**
   * $SATISFY
   */
  @deprecated(message = "Use forTreeTableColumn[S, T](StringConverter[T], T*)", since = "1.0")
  def forTreeTableColumn[S, T](converter: jfxu.StringConverter[T], items: T*) = jfxscc.ChoiceBoxTreeTableCell.forTreeTableColumn[S, T](converter, items: _*)

  /**
   * $FTTC
   *
   * @tparam T $TTYPE
   * @param items $ITEMSPARAM
   * @return $RETFTTC
   * @see $URL0#ChoiceBoxTreeTableCell-T...- $ORIGINALDOC
   */
  def forTreeTableColumn[S, T](items: T*): (jfxsc.TreeTableColumn[S, T] => TreeTableCell[S, T]) =
    (view: jfxsc.TreeTableColumn[S, T]) => jfxscc.ChoiceBoxTreeTableCell.forTreeTableColumn[S, T](items: _*).call(view)

  /**
   * $SATISFY
   */
  @deprecated(message = "Use forTreeTableColumn[S, T](T*)", since = "1.0")
  def forTreeTableColumn[S, T](items: Array[T]) = jfxscc.ChoiceBoxTreeTableCell.forTreeTableColumn[S, T](items: _*)

}

/**
 * Wraps $JFX $URL0 $CBTTC]]
 *
 * @tparam T The type of the elements contained within the TreeTableColumn.
 * @tparam S
 * @constructor Creates a new $CBTTC from a $JFX $CBTTC
 * @param delegate JavaFX $CBTTC. Its default value is a new $JFX $CBTTC
 * @since 8.0
 *
 * @define CBTTC `ChoiceBoxTreeTableCell`
 * @define JFX JavaFX
 * @define CONVPARAM A `StringConverter` to convert the given item (of type T) to a String for displaying to the user.
 * @define ITEMSPARAM Zero or more items that will be shown to the user when the ChoiceBox menu is showing.
 * @define BUFITEMSPARAM A `ObservableBuffer` containing $ITEMSPARAM
 * @define DEFCOMPL Creates a default $CBTTC instance with the given items being used to populate the
 *         [[scalafx.scene.control.ChoiceBox C h o i c e B o x]] when it is shown.
 * @define CONSCOMPL Creates a `$CBTTC` instance with the given items being used to populate the
 *         [[scalafx.scene.control.ChoiceBox C h o i c e B o x]] when it is shown, and the [[scalafx.util.StringConverter S t r i n g C o n v e r t e r]]
 *         being used to convert the item in to a user-readable form.
 * @define URL0 [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/cell/ChoiceBoxTreeTableCell.html
 * @define ORIGINALDOC Original Documentation]].
 */
class ChoiceBoxTreeTableCell[S, T](override val delegate: jfxscc.ChoiceBoxTreeTableCell[S, T] = new jfxscc.ChoiceBoxTreeTableCell[S, T])
  extends TreeTableCell[S, T](delegate)
  with ConvertableCell[jfxscc.ChoiceBoxTreeTableCell[S, T], T, T]
  with UpdatableCell[jfxscc.ChoiceBoxTreeTableCell[S, T], T]
  with ItemableCell[jfxscc.ChoiceBoxTreeTableCell[S, T], T]
  with SFXDelegate[jfxscc.ChoiceBoxTreeTableCell[S, T]] {

  /**
   * $CONSCOMPL
   *
   * @param items $BUFITEMSPARAM
   * @see $URL0#ChoiceBoxTreeTableCell-javafx.collections.ObservableList- $ORIGINALDOC
   */
  def this(items: ObservableBuffer[T]) = this(new jfxscc.ChoiceBoxTreeTableCell[S, T](items))

  /**
   * $CONSCOMPL
   *
   * @param converter $CONVPARAM
   * @param items $BUFITEMSPARAM
   * @see $URL0#ChoiceBoxTreeTableCell-javafx.util.StringConverter-javafx.collections.ObservableList- $ORIGINALDOC
   */
  def this(converter: StringConverter[T], items: ObservableBuffer[T]) = this(new jfxscc.ChoiceBoxTreeTableCell[S, T](converter, items))

  /**
   * $CONSCOMPL
   *
   * @param converter $CONVPARAM
   * @param items $ITEMSPARAM
   * @see $URL0#ChoiceBoxTreeTableCell-javafx.util.StringConverter-T...- $ORIGINALDOC
   */
  def this(converter: StringConverter[T], items: T*) = this(new jfxscc.ChoiceBoxTreeTableCell[S, T](converter, items: _*))

  /**
   * $CONSCOMPL
   *
   * @param items $ITEMSPARAM
   * @see $URL0#ChoiceBoxTreeTableCell-T...- $ORIGINALDOC
   */
  def this(items: T*) = this(new jfxscc.ChoiceBoxTreeTableCell[S, T](items: _*))

}