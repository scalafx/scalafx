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
import javafx.scene.{ control => jfxsc }
import javafx.{ util => jfxu }
import scalafx.Includes._
import scalafx.beans.value.ObservableValue
import scalafx.scene.control.TreeCell
import scalafx.scene.control.ListView
import scalafx.util.SFXDelegate
import scalafx.util.StringConverter
import scalafx.scene.control.TreeItem
import scalafx.scene.control.TreeView

object CheckBoxTreeCell {
  implicit def sfxCheckBoxTreeCell2jfx[T](cell: CheckBoxTreeCell[T]) = cell.delegate

  private[cell] implicit def selectedTreeItemPropertyToGetSelectedProperty[T](selectedProperty: TreeItem[T] => ObservableValue[Boolean, java.lang.Boolean]): jfxu.Callback[jfxsc.TreeItem[T], jfxbv.ObservableValue[java.lang.Boolean]] =
    new jfxu.Callback[jfxsc.TreeItem[T], jfxbv.ObservableValue[java.lang.Boolean]] {
      def call(x: jfxsc.TreeItem[T]) = selectedProperty(x)
    }

  /**
   * Creates a cell factory for use in a TreeView control, although there is a major assumption when used in a
   * TreeView: this cell factory assumes that the TreeView root, and all children are instances of CheckBoxTreeItem,
   * rather than the default TreeItem class that is used normally.
   */
  def forTreeView[T]: (TreeView[T]) => (TreeCell[T]) =
    (view: TreeView[T]) => jfxscc.CheckBoxTreeCell.forTreeView[T].call(view.delegate)

  /**
   * Creates a cell factory for use in a TreeView control.
   */
  def forTreeView[T](selectedProperty: TreeItem[T] => ObservableValue[Boolean, java.lang.Boolean]): (TreeView[T]) => (TreeCell[T]) =
    (view: TreeView[T]) => jfxscc.CheckBoxTreeCell.forTreeView[T](selectedProperty).call(view)

  /**
   * Creates a cell factory for use in a TreeView control.
   */
  def forTreeView[T](selectedProperty: TreeItem[T] => ObservableValue[Boolean, java.lang.Boolean], converter: StringConverter[TreeItem[T]]): (TreeView[T]) => (TreeCell[T]) = {
    val jfxConverter: jfxu.StringConverter[jfxsc.TreeItem[T]] = new jfxu.StringConverter[jfxsc.TreeItem[T]] {
      def fromString(str: String) = converter.fromString(str)
      def toString(item: jfxsc.TreeItem[T]) = converter.toString(item)
    }

    (view: TreeView[T]) => jfxscc.CheckBoxTreeCell.forTreeView[T](selectedProperty, jfxConverter).call(view)
  }
}

class CheckBoxTreeCell[T](override val delegate: jfxscc.CheckBoxTreeCell[T] = new jfxscc.CheckBoxTreeCell[T])
  extends TreeCell[T](delegate)
  with ConvertableCell[jfxscc.CheckBoxTreeCell[T], T, jfxsc.TreeItem[T]]
  with StateSelectableCell[jfxscc.CheckBoxTreeCell[T], T, jfxsc.TreeItem[T]]
  with UpdatableCell[jfxscc.CheckBoxTreeCell[T], T]
  with SFXDelegate[jfxscc.CheckBoxTreeCell[T]] {

}