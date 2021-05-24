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
import scalafx.Includes._
import scalafx.beans.property.ReadOnlyObjectProperty
import scalafx.delegate.SFXDelegate

import scala.language.implicitConversions

/**
 * Object Companion for [[scalafx.scene.control.SortEvent]]
 *
 * @since
 *   8.0
 */
object TreeTableCell {

  /**
   * Converts a ScalaFX TreeTableCell to its JavaFX counterpart.
   *
   * @param ttc
   *   ScalaFX TreeTableCell
   * @tparam T
   *   The type of the item contained within the Cell.
   * @return
   *   JavaFX TreeTableCell
   */
  implicit def sfxTreeTableCell2jfx[S, T](ttc: TreeTableCell[S, T]): jfxsc.TreeTableCell[S, T] =
    if (ttc != null) ttc.delegate else null

}

/**
 * Wraps a $JFX $URL0 $TTC]].
 *
 * @constructor
 *   Creates a new $TTC from a $JFX one.
 * @param delegate
 *   A $JFX $TTC to be wrapped. Its defaul value is a new $JFX $TTC.
 * @tparam T
 *   The type of the item contained within the Cell.
 * @tparam S
 *   The type of the item contained within the Cell.
 * @since
 *   8.0
 *
 * @define
 *   TTC TreeTableCell
 * @define
 *   URL0
 *   [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/TreeTableCell.html@define JFX JavaFX @define ORIGINALDOC Original Documentation]].
 */
class TreeTableCell[S, T](override val delegate: jfxsc.TreeTableCell[S, T] = new jfxsc.TreeTableCell[S, T])
    extends IndexedCell[T](delegate)
    with SFXDelegate[jfxsc.TreeTableCell[S, T]] {

  /**
   * @see
   *   $URL0#tableColumnProperty $ORIGINALDOC
   */
  def tableColumn: ReadOnlyObjectProperty[jfxsc.TreeTableColumn[S, T]] = delegate.tableColumnProperty

  /**
   * @see
   *   $URL0#tableRowProperty $ORIGINALDOC
   */
  def tableRow: ReadOnlyObjectProperty[jfxsc.TreeTableRow[S]] = delegate.tableRowProperty

  /**
   * The TreeTableView associated with this $TTC.
   *
   * @see
   *   $URL0#treeTableViewProperty $ORIGINALDOC
   */
  def treeTableView: ReadOnlyObjectProperty[jfxsc.TreeTableView[S]] = delegate.treeTableViewProperty

  /**
   * Updates the TreeTableView associated with this $TTC. This is typically only done once when the $TTC is first added
   * to the TreeTableView.
   *
   * @see
   *   $URL0#updateTreeTableView-javafx.scene.control.TreeTableView- $ORIGINALDOC
   */
  def updateTreeTableView(tv: TreeTableView[S]): Unit = {
    delegate.updateTreeTableView(tv)
  }

  /**
   * Updates the TreeTableRow associated with this $TTC.
   *
   * @see
   *   $URL0#updateTreeTableRow-javafx.scene.control.TreeTableRow- $ORIGINALDOC
   */
  def updateTreeTableRow(treeTableRow: TreeTableRow[S]): Unit = {
    delegate.updateTreeTableRow(treeTableRow)
  }

  /**
   * Updates the TreeTableColumn associated with this $TTC.
   *
   * @see
   *   $URL0#updateTreeTableColumn-javafx.scene.control.TreeTableColumn- $ORIGINALDOC
   */
  def updateTreeTableColumn(col: TreeTableColumn[S, T]): Unit = {
    delegate.updateTreeTableColumn(col)
  }

}
