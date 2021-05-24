/*
 * Copyright (c) 2011-2019, ScalaFX Project
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
package scalafx.scene.control

import javafx.scene.{control => jfxsc}
import javafx.{scene => jfxs}
import scalafx.Includes._
import scalafx.beans.property.{ObjectProperty, ReadOnlyObjectProperty}
import scalafx.delegate.SFXDelegate
import scalafx.scene.Node

import scala.language.implicitConversions

/**
 * Object companion for [[scalafx.scene.control.TreeTableRow]].
 *
 * @since
 *   8.0
 */
object TreeTableRow {

  /**
   * Converts a ScalaFX TreeTableRow to its JavaFX couterpart.
   *
   * @tparam T
   *   The type of the item contained within the Cell.
   * @param ttr
   *   ScalaFX TreeTableRow
   * @return
   *   JavaFX TreeTableRow
   */
  implicit def sfxTreeTableRow2jfx[T](ttr: TreeTableRow[T]): jfxsc.TreeTableRow[T] =
    if (ttr != null) ttr.delegate else null

}

/**
 * Wraps a $JFX $URL0 $TTR]].
 *
 * @constructor
 *   Creates a new $TTR from a $JFX one.
 * @param delegate
 *   A $JFX $TTR to be wrapped. Its defaul value is a new $JFX $TTR.
 * @tparam T
 *   The type of the item contained within the Cell.
 * @since
 *   8.0
 *
 * @define
 *   TTR TreeTableRow
 * @define
 *   URL0
 *   [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/TreeTableRow.html@define JFX JavaFX @define ORIGINALDOC Original Documentation]].
 */
class TreeTableRow[T](override val delegate: jfxsc.TreeTableRow[T] = new jfxsc.TreeTableRow[T])
    extends IndexedCell[T](delegate)
    with SFXDelegate[jfxsc.TreeTableRow[T]] {

  // protected  createDefaultSkin: Skin[_]

  /**
   * The disclosure node is commonly seen represented as a triangle that rotates on screen to indicate whether or not
   * the TreeItem that it is placed beside is expanded or collapsed.
   *
   * @see
   *   $URL0#disclosureNodeProperty $ORIGINALDOC
   */
  def disclosureNode: ObjectProperty[jfxs.Node] = delegate.disclosureNodeProperty

  def disclosureNode_=(node: Node): Unit = {
    disclosureNode() = node
  }

  /**
   * Each TreeTableCell represents at most a single TreeItem, which is represented by this property.
   *
   * @see
   *   $URL0#treeItemProperty $ORIGINALDOC
   */
  def treeItem: ReadOnlyObjectProperty[jfxsc.TreeItem[T]] = delegate.treeItemProperty

  /**
   * A TreeTableCell is explicitly linked to a single `TreeTableView` instance, which is represented by this property.
   *
   * @see
   *   $URL0#treeTableViewProperty $ORIGINALDOC
   */
  def treeTableView: ReadOnlyObjectProperty[jfxsc.TreeTableView[T]] = delegate.treeTableViewProperty

  /**
   * Updates the TreeItem associated with this TreeTableCell.
   *
   * @param treeItem
   *   The new TreeItem that should be associated with this TreeTableCell.
   * @see
   *   $URL0#updateTreeTableView-javafx.scene.control.TreeTableView- $ORIGINALDOC
   */
  def updateTreeItem(treeItem: TreeItem[T]): Unit = {
    delegate.updateTreeItem(treeItem)
  }

}
