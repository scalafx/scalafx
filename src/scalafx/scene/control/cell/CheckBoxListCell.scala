/* Copyright (c) 2012, ScalaFX Project
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
import scalafx.util.SFXDelegate
import scalafx.util.StringConverter

object CheckBoxListCell {
  implicit def sfxCheckBoxListCell2jfx[T](cell: CheckBoxListCell[T]) = cell.delegate

  private[cell] implicit def selectedBooleanPropertyToGetSelectedProperty[T](selectedProperty: T => ObservableValue[Boolean, java.lang.Boolean]): jfxu.Callback[T, jfxbv.ObservableValue[java.lang.Boolean]] =
    new jfxu.Callback[T, jfxbv.ObservableValue[java.lang.Boolean]] {
      def call(x: T) = selectedProperty(x)
    }

  /**
   * Creates a cell factory for use in ListView controls.
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
 * Wraps [[http://docs.oracle.com/javafx/2/api/javafx/scene/control/cell/CheckBoxListCell.html]]
 */
class CheckBoxListCell[T](override val delegate: jfxscc.CheckBoxListCell[T] = new jfxscc.CheckBoxListCell[T])
  extends ListCell[T](delegate)
  with ConvertableCell[jfxscc.CheckBoxListCell[T], T]
  with UpdatableCell[jfxscc.CheckBoxListCell[T], T]
  with SFXDelegate[jfxscc.CheckBoxListCell[T]] {

  /**
   * Creates a default CheckBoxListCell.
   */
  def this(selectedProperty: T => ObservableValue[Boolean, java.lang.Boolean]) =
    this(new jfxscc.CheckBoxListCell[T](selectedProperty))

  /**
   * Creates a CheckBoxListCell with a custom string converter.
   */
  def this(selectedProperty: T => ObservableValue[Boolean, java.lang.Boolean], converter: StringConverter[T]) =
    this(new jfxscc.CheckBoxListCell[T](selectedProperty, converter))

  /**
   * Property representing the Callback that is bound to by the CheckBox shown on screen.
   */
  def selectedStateCallback = delegate.selectedStateCallbackProperty
  def selectedStateCallback_=(v: jfxu.Callback[T, jfxbv.ObservableValue[java.lang.Boolean]]) {
    selectedStateCallback() = v
  }

}