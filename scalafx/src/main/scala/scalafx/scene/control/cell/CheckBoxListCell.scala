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

import scala.annotation.implicitNotFound

import javafx.beans.{ value => jfxbv }
import javafx.scene.control.{ cell => jfxscc }
import javafx.{ util => jfxu }
import scalafx.Includes._
import scalafx.beans.value.ObservableValue
import scalafx.scene.control.cell.CheckBoxListCell._
import scalafx.scene.control.ListCell
import scalafx.scene.control.ListView
import scalafx.delegate.SFXDelegate
import scalafx.util.StringConverter

/**
 * Companion Object for [[scalafx.scene.control.cell.CheckBoxListCell]].
 *
 * @define CBLC `CheckBoxListCell`
 * @define SP A Function that, given an object of type T (which is a value taken out of the
 * ListView[T] list), will return an ObservableValue[Boolean] that represents whether the given item is selected or
 * not.
 */
object CheckBoxListCell {

  /**
   * Converts a ScalaFX $CBLC to its JavaFX counterpart.
   *
   * @param cell ScalaFX $CBLC
   */
  implicit def sfxCheckBoxListCell2jfx[T](cell: CheckBoxListCell[T]) = cell.delegate

  /**
   * Creates a cell factory for use in ListView controls.
   *
   * @param selectedProperty $SP
   */
  def forListView[T](selectedProperty: T => ObservableValue[Boolean, java.lang.Boolean]): (ListView[T] => ListCell[T]) = {
    (view: ListView[T]) => jfxscc.CheckBoxListCell.forListView(selectedProperty).call(view)
  }

  /**
   * Added to satisfy Spec tests.
   */
  @deprecated(message = "Use forListView[T](T => ObservableValue[Boolean, java.lang.Boolean])", since = "1.0")
  def forListView[T](getSelectedProperty: jfxu.Callback[T, jfxbv.ObservableValue[java.lang.Boolean]]) =
    jfxscc.CheckBoxListCell.forListView(getSelectedProperty)

  /**
   * Creates a cell factory for use in ListView controls.
   *
   * @param selectedProperty $SP
   * @param converter A StringConverter that, give an object of type T, will return a String that can be used to represent the object visually.
   */
  def forListView[T](selectedProperty: T => ObservableValue[Boolean, java.lang.Boolean], converter: StringConverter[T]): (ListView[T] => ListCell[T]) = {
    (view: ListView[T]) => jfxscc.CheckBoxListCell.forListView(selectedProperty, converter).call(view)
  }

  /**
   * Added to satisfy Spec tests.
   */
  @deprecated(message = "Use forListView[T](T => ObservableValue[Boolean, java.lang.Boolean])", since = "1.0")
  def forListView[T](getSelectedProperty: jfxu.Callback[T, jfxbv.ObservableValue[java.lang.Boolean]], converter: jfxu.StringConverter[T]) =
    jfxscc.CheckBoxListCell.forListView(getSelectedProperty, converter)
}

/**
 * Wraps [[http://docs.oracle.com/javafx/2/api/javafx/scene/control/cell/CheckBoxListCell.html $CBLC]]
 *
 * @tparam T Type used in this cell
 * @constructor Creates a new $CBLC from a JavaFX $CBLC
 * @param delegate JavaFX $CBLC
 *
 * @define CBLC `CheckBoxListCell`
 * @define SP Function that takes a T instance and return a obsevable boolean.
 */
class CheckBoxListCell[T](override val delegate: jfxscc.CheckBoxListCell[T] = new jfxscc.CheckBoxListCell[T])
  extends ListCell[T](delegate)
  with ConvertableCell[jfxscc.CheckBoxListCell[T], T, T]
  with StateSelectableCell[jfxscc.CheckBoxListCell[T], T, T]
  with UpdatableCell[jfxscc.CheckBoxListCell[T], T]
  with SFXDelegate[jfxscc.CheckBoxListCell[T]] {

  /**
   * Creates a default $CBLC from a function that takes a T instance and extracts a boolean.
   *
   * @param selectedProperty $SP
   */
  def this(selectedProperty: T => ObservableValue[Boolean, java.lang.Boolean]) =
    this(new jfxscc.CheckBoxListCell[T](selectedProperty))

  /**
   * Creates a  $CBLC with a custom string converter.
   *
   * @param selectedProperty $SP
   * @param converter StringConverter that receives a T instance.
   */
  def this(selectedProperty: T => ObservableValue[Boolean, java.lang.Boolean], converter: StringConverter[T]) =
    this(new jfxscc.CheckBoxListCell[T](selectedProperty, converter))

}