/*
 * Copyright (c) 2011-2021, ScalaFX Project
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

import javafx.beans.{value => jfxbv}
import javafx.scene.control.{cell => jfxscc}
import javafx.scene.{control => jfxsc}
import javafx.{util => jfxu}
import scalafx.Includes._
import scalafx.beans.value.ObservableValue
import scalafx.delegate.SFXDelegate
import scalafx.scene.control.TreeTableCell
import scalafx.util.StringConverter

import scala.language.implicitConversions

/**
 * Companion Object for [[scalafx.scene.control.cell.CheckBoxTreeTableCell]].
 *
 * @since
 *   8.0
 * @todo
 *   Replace all references to $JFX $TTC to its $SFX counterpart when it was created
 * @define
 *   CBTTC `CheckBoxTreeTableCell`
 * @define
 *   TTC TreeTableColumn
 * @define
 *   SP A Function that, given an object of type $TTC[S, T], will return an ObservableValue[Boolean] that represents
 *   whether the given item is selected or not.
 * @define
 *   FTTC Creates a cell factory for use in a [[scalafx.scene.control.TreeTableCell$ T T C]] cell factory.
 * @define
 *   RETFTTC A Callback that will return a TreeTableCell that is able to work on the type of element contained within
 *   the $TTC.
 * @define
 *   STYPE
 * @define
 *   TTYPE The type of the elements contained within the `$TTC` instance.
 * @define
 *   JFX JavaFX
 * @define
 *   SFX ScalaFX
 * @define
 *   URL0
 *   [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/cell/CheckBoxTreeTableCell.html@define ORIGINALDOC Original Documentation]].
 * @define
 *   SATISFY Added just to satisfy Spec tests.
 */
object CheckBoxTreeTableCell {

  /**
   * Converts a $SFX $CBTTC to its $JFX counterpart.
   *
   * @tparam T
   *   $TTYPE
   * @tparam S
   *   $STYPE
   * @param cell
   *   $SFX $CBTTC
   * @return
   *   $JFX $CBTTC
   */
  implicit def sfxCheckBoxTreeTableCell2jfx[S, T](
      cell: CheckBoxTreeTableCell[S, T]
  ): jfxscc.CheckBoxTreeTableCell[S, T] = if (cell != null) cell.delegate else null

  type JBoolean       = java.lang.Boolean
  type JCallIntToBool = jfxu.Callback[Integer, jfxbv.ObservableValue[JBoolean]]
  type IntToBool      = Integer => ObservableValue[Boolean, JBoolean]

  /**
   * $FTTC
   *
   * @tparam T
   *   $TTYPE
   * @tparam S
   *   $STYPE
   * @param selectedProperty
   *   $SP
   * @return
   *   $RETFTTC
   * @see
   *   $URL0#forTreeTableColumn-javafx.util.Callback- $ORIGINALDOC
   */
  def forTreeTableColumn[S, T](selectedProperty: IntToBool): (jfxsc.TreeTableColumn[S, T] => TreeTableCell[S, T]) = {
    (column: jfxsc.TreeTableColumn[S, T]) =>
      jfxscc.CheckBoxTreeTableCell.forTreeTableColumn(selectedProperty).call(column)
  }

  /**
   * $SATISFY
   */
  @deprecated(
    message = "Use forTreeTableColumn[S, T](Integer => ObservableValue[Boolean, java.lang.Boolean]))",
    since = "8.0"
  )
  def forTreeTableColumn[S, T](
      selectedProperty: JCallIntToBool
  ): jfxu.Callback[jfxsc.TreeTableColumn[S, T], jfxsc.TreeTableCell[S, T]] =
    jfxscc.CheckBoxTreeTableCell.forTreeTableColumn[S, T](selectedProperty)

  /**
   * $FTTC
   *
   * @tparam T
   *   $TTYPE
   * @tparam S
   *   $STYPE
   * @param selectedProperty
   *   $SP
   * @param showLabel
   *   In some cases, it may be desirable to show a label in the TreeTableCell beside the CheckBox.
   * @return
   *   $RETFTTC
   * @see
   *   $URL0#forTreeTableColumn-javafx.util.Callback-boolean- $ORIGINALDOC
   */
  def forTreeTableColumn[S, T](
      selectedProperty: IntToBool,
      showLabel: Boolean
  ): (jfxsc.TreeTableColumn[S, T] => TreeTableCell[S, T]) = { (column: jfxsc.TreeTableColumn[S, T]) =>
    jfxscc.CheckBoxTreeTableCell.forTreeTableColumn(selectedProperty, showLabel).call(column)
  }

  /**
   * $SATISFY
   */
  @deprecated(
    message = "Use forTreeTableColumn[S, T](Integer => ObservableValue[Boolean, java.lang.Boolean], Boolean))",
    since = "8.0"
  )
  def forTreeTableColumn[S, T](
      selectedProperty: JCallIntToBool,
      showLabel: Boolean
  ): jfxu.Callback[jfxsc.TreeTableColumn[S, T], jfxsc.TreeTableCell[S, T]] =
    jfxscc.CheckBoxTreeTableCell.forTreeTableColumn[S, T](selectedProperty, showLabel)

  /**
   * $FTTC
   *
   * @tparam T
   *   $TTYPE
   * @tparam S
   *   $STYPE
   * @param selectedProperty
   *   $SP
   * @param converter
   *   A [[scalafx.util.StringConverterS t r i n g C o n v e r t e r]] that, give an object of type T, will return a
   *   String that can be used to represent the object visually.
   * @return
   *   $RETFTTC
   * @see
   *   $URL0#forTreeTableColumn-javafx.util.Callback-javafx.util.StringConverter- $ORIGINALDOC
   */
  def forTreeTableColumn[S, T](
      selectedProperty: IntToBool,
      converter: StringConverter[T]
  ): (jfxsc.TreeTableColumn[S, T] => TreeTableCell[S, T]) = { (column: jfxsc.TreeTableColumn[S, T]) =>
    jfxscc.CheckBoxTreeTableCell.forTreeTableColumn(selectedProperty, converter).call(column)
  }

  /**
   * $SATISFY
   */
  @deprecated(
    message =
      "Use forTreeTableColumn[S, T](Integer => ObservableValue[Boolean, java.lang.Boolean], StringConverter[T]))",
    since = "8.0"
  )
  def forTreeTableColumn[S, T](
      selectedProperty: JCallIntToBool,
      converter: jfxu.StringConverter[T]
  ): jfxu.Callback[jfxsc.TreeTableColumn[S, T], jfxsc.TreeTableCell[S, T]] =
    jfxscc.CheckBoxTreeTableCell.forTreeTableColumn[S, T](selectedProperty, converter)

  /**
   * $FTTC
   *
   * @tparam S
   *   $STYPE
   * @return
   *   $RETFTTC
   * @see
   *   $URL0#forTreeTableColumn-javafx.scene.control.TreeTableColumn- $ORIGINALDOC
   */
  def forTreeTableColumn[S](
      column: jfxsc.TreeTableColumn[S, JBoolean]
  ): jfxu.Callback[jfxsc.TreeTableColumn[S, JBoolean], jfxsc.TreeTableCell[S, JBoolean]] = {
    jfxscc.CheckBoxTreeTableCell.forTreeTableColumn(column)
  }

  /*
   * $SATISFY
   *
  @deprecated(message = "Use forTreeTableColumn[S](column: jfxsc.TreeTableColumn[S, java.lang.Boolean])", since = "8.0")
  def forTreeTableColumn[S](column: jfxsc.TreeTableColumn[S, JBoolean]) = jfxscc.CheckBoxTreeTableCell.forTreeTableColumn[S](column)
   */

}

/**
 * Wraps $JFX $URL0 $CBTTC]]
 *
 * @tparam T
 *   The type of the elements contained within the TreeTableColumn.
 * @tparam S
 *   @constructor Creates a new $CBTTC from a $JFX $CBTTC
 * @param delegate
 *   JavaFX $CBTTC. Its default value is a new $JFX $CBTTC
 * @since
 *   8.0
 *
 * @define
 *   CBTTC `CheckBoxTreeTableCell`
 * @define
 *   JFX JavaFX
 * @define
 *   OV ObservableValue
 * @define
 *   SP Function that will return an $OV given an index from the TreeTableColumn.
 * @define
 *   URL0
 *   [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/cell/CheckBoxTreeTableCell.html@define ORIGINALDOC Original Documentation]].
 */
class CheckBoxTreeTableCell[S, T](
    override val delegate: jfxscc.CheckBoxTreeTableCell[S, T] = new jfxscc.CheckBoxTreeTableCell[S, T]
) extends TreeTableCell[S, T](delegate)
    with ConvertableCell[jfxscc.CheckBoxTreeTableCell[S, T], T, T]
    with StateSelectableCell[jfxscc.CheckBoxTreeTableCell[S, T], T, java.lang.Integer]
    with UpdatableCell[jfxscc.CheckBoxTreeTableCell[S, T], T]
    with SFXDelegate[jfxscc.CheckBoxTreeTableCell[S, T]] {

  /**
   * Creates a default $CBTTC with a custom function to retrieve an $OV for a given cell index.
   *
   * @param selectedProperty
   *   $SP
   * @see
   *   $URL0#CheckBoxTreeTableCell-javafx.util.Callback- $ORIGINALDOC
   */
  def this(selectedProperty: java.lang.Integer => ObservableValue[Boolean, java.lang.Boolean]) =
    this(new jfxscc.CheckBoxTreeTableCell[S, T](selectedProperty))

  /**
   * Creates a $CBTTC with a custom string converter.
   *
   * @param selectedProperty
   *   $SP
   * @param converter
   *   A StringConverter that, given an object of type T, will return a String that can be used to represent the object
   *   visually.
   * @see
   *   $URL0#CheckBoxTreeTableCell-javafx.util.Callback-javafx.util.StringConverter- $ORIGINALDOC
   */
  def this(
      selectedProperty: java.lang.Integer => ObservableValue[Boolean, java.lang.Boolean],
      converter: StringConverter[T]
  ) =
    this(new jfxscc.CheckBoxTreeTableCell[S, T](selectedProperty, converter))

}
