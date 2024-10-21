/*
 * Copyright (c) 2011-2024, ScalaFX Project
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

import java.lang.{Boolean => JBoolean}

import javafx.beans.{value => jfxbv}
import javafx.scene.control.{cell => jfxscc}
import javafx.scene.{control => jfxsc}
import javafx.{util => jfxu}
import scalafx.Includes._
import scalafx.beans.value.ObservableValue
import scalafx.delegate.SFXDelegate
import scalafx.scene.control.cell.CheckBoxTreeCell._
import scalafx.scene.control.{TreeCell, TreeItem, TreeView}
import scalafx.util.StringConverter

import scala.language.implicitConversions

/**
 * Companion Object for [[scalafx.scene.control.cell.CheckBoxTreeCell]].
 *
 * @define CBTC   `CheckBoxTableCell`
 * @define SP     A Function that, given an object of type `TreeItem`, will return an `ObservableValue[Boolean]` that
 *                represents whether the given item is selected or not.
 * @define FTVRET A Function that will return a TreeCell that is able to work on the type of element contained within the
 *                TreeView root, and all of its children (recursively).
 */
object CheckBoxTreeCell {

  /**
   * Converts a ScalaFX $CBTC to its JavaFX counterpart.
   *
   * @param cell ScalaFX $CBTC
   */
  implicit def sfxCheckBoxTreeCell2jfx[T](cell: CheckBoxTreeCell[T]): jfxsc.cell.CheckBoxTreeCell[T] =
    if (cell != null) cell.delegate else null

  private[cell] implicit def selectedTreeItemPropertyToGetSelectedProperty[T](
    selectedProperty: TreeItem[T] => ObservableValue[Boolean, java.lang.Boolean]
  ): jfxu.Callback[jfxsc.TreeItem[T], jfxbv.ObservableValue[JBoolean]] =
    new jfxu.Callback[jfxsc.TreeItem[T], jfxbv.ObservableValue[JBoolean]] {
      def call(x: jfxsc.TreeItem[T]): jfxbv.ObservableBooleanValue = selectedProperty(x)
    }

  private[cell] implicit def sfxStringConverterTreeItem2jfxConverter[T](converter: StringConverter[TreeItem[T]])
    : jfxu.StringConverter[jfxsc.TreeItem[T]] = new jfxu.StringConverter[jfxsc.TreeItem[T]] {
    def fromString(str: String): jfxsc.TreeItem[T] = converter.fromString(str)

    def toString(item: jfxsc.TreeItem[T]): String = converter.toString(item)
  }

  /**
   * Creates a cell factory for use in a TreeView control, although there is a major assumption when used in a
   * TreeView: this cell factory assumes that the TreeView root, and all children are instances of CheckBoxTreeItem,
   * rather than the default TreeItem class that is used normally.
   *
   * @tparam T The type of the elements contained within the CheckBoxTreeItem instances.
   * @return $FTVRET
   */
  def forTreeView[T]: (TreeView[T]) => (TreeCell[T]) =
    (view: TreeView[T]) => jfxscc.CheckBoxTreeCell.forTreeView[T].call(view)

  /**
   * Creates a cell factory for use in a TreeView control.
   *
   * @tparam T  The type of the elements contained within the TreeItem instances.
   * @param selectedProperty $SP
   * @return $FTVRET
   */
  def forTreeView[T](selectedProperty: TreeItem[T] => ObservableValue[Boolean, JBoolean])
    : (TreeView[T]) => (TreeCell[T]) =
    (view: TreeView[T]) => jfxscc.CheckBoxTreeCell.forTreeView[T](selectedProperty).call(view)

  /**
   * Added to satisfy Spec tests.
   */
  @deprecated(
    message = "Use forTreeView[T](TreeItem[T] => ObservableValue[Boolean, java.lang.Boolean]])",
    since = "1.0"
  )
  def forTreeView[T](getSelectedProperty: jfxu.Callback[jfxsc.TreeItem[T], jfxbv.ObservableValue[JBoolean]])
    : jfxu.Callback[jfxsc.TreeView[T], jfxsc.TreeCell[T]] =
    jfxscc.CheckBoxTreeCell.forTreeView[T](getSelectedProperty)

  /**
   * Creates a cell factory for use in a TreeView control.
   *
   * @tparam T  The type of the elements contained within the TreeItem instances.
   * @param selectedProperty $SP
   * @param converter A StringConverter that, give an object of type TreeItem, will return a String that can be used
   *                  to represent the object visually.
   * @return $FTVRET
   */
  def forTreeView[T](
    selectedProperty: TreeItem[T] => ObservableValue[Boolean, JBoolean],
    converter: StringConverter[TreeItem[T]]
  ): (TreeView[T]) => (TreeCell[T]) =
    (view: TreeView[T]) => jfxscc.CheckBoxTreeCell.forTreeView[T](selectedProperty, converter).call(view)

  /**
   * Added to satisfy Spec tests.
   */
  @deprecated(
    message =
      "Use forTreeView[T](TreeItem[T] => ObservableValue[Boolean, java.lang.Boolean], StringConverter[TreeItem[T]])",
    since = "1.0"
  )
  def forTreeView[T](
    getSelectedProperty: jfxu.Callback[jfxsc.TreeItem[T], jfxbv.ObservableValue[JBoolean]],
    converter: jfxu.StringConverter[jfxsc.TreeItem[T]]
  ): jfxu.Callback[jfxsc.TreeView[T], jfxsc.TreeCell[T]] =
    jfxscc.CheckBoxTreeCell.forTreeView[T](getSelectedProperty, converter)
}

/**
 * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/cell/ChoiceBoxListCell.html $CBTC]]
 *
 * @tparam T Type used in this cell
 * @constructor Creates a new $CBTC from a JavaFX $CBTC
 * @param delegate JavaFX $CBTC
 *
 * @define CBTC `CheckBoxTreeCell`
 * @define SP A Function that will return an ObservableValue<Boolean> that represents whether the given item is
 *         selected or not.
 */
class CheckBoxTreeCell[T](override val delegate: jfxscc.CheckBoxTreeCell[T] = new jfxscc.CheckBoxTreeCell[T])
    extends TreeCell[T](delegate)
    with ConvertableCell[jfxscc.CheckBoxTreeCell[T], T, jfxsc.TreeItem[T]]
    with StateSelectableCell[jfxscc.CheckBoxTreeCell[T], T, jfxsc.TreeItem[T]]
    with UpdatableCell[jfxscc.CheckBoxTreeCell[T], T]
    with SFXDelegate[jfxscc.CheckBoxTreeCell[T]] {

  /**
   * Creates a $CBTC for use in a TreeView control via a cell factory.
   *
   * @param selectedProperty $SP
   */
  def this(selectedProperty: TreeItem[T] => ObservableValue[Boolean, JBoolean]) =
    this(new jfxscc.CheckBoxTreeCell[T](selectedProperty))

  /**
   * Creates a $CBTC for use in a TreeView control via a cell factory.
   *
   * @param selectedProperty $SP
   * @param converter A StringConverter that, give an object of type TreeItem, will return a String that can be used
   *                  to represent the object visually.
   */
  def this(
    selectedProperty: TreeItem[T] => ObservableValue[Boolean, JBoolean],
    converter: StringConverter[TreeItem[T]]
  ) =
    this(new jfxscc.CheckBoxTreeCell[T](selectedProperty, converter))

}
