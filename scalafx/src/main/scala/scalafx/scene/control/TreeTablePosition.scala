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
package scalafx.scene.control

import javafx.scene.{control => jfxsc}

import scala.language.implicitConversions
import scalafx.delegate.SFXDelegate

/**
 * Object companion for [[scalafx.scene.control.TreeTablePosition]].
 *
 * @since
 *   8.0
 */
object TreeTablePosition {

  /**
   * Converts a ScalaFX TreeTablePosition to its JavaFX couterpart.
   *
   * @param ttp
   *   ScalaFX TreeTablePosition
   * @tparam S
   *   The type of the TreeItem instances contained within the TreeTableView.
   * @tparam T
   *   The type of the items contained within the TreeTableColumn.
   * @return
   *   JavaFX TreeTablePosition
   */
  implicit def sfxTreeTablePosition2jfx[S, T](ttp: TreeTablePosition[S, T]): jfxsc.TreeTablePosition[S, T] =
    if (ttp != null) ttp.delegate else null

}

/**
 * Wraps a $JFX $URL0 $TTP]].
 *
 * @constructor
 *   Creates a new $TTP from a $JFX one.
 * @tparam S
 *   The type of the TreeItem instances contained within the TreeTableView.
 * @tparam T
 *   The type of the items contained within the TreeTableColumn.
 * @param delegate
 *   A $JFX $TTP to be wrapped. Its defaul value is a new $JFX $TTP.
 * @since
 *   8.0
 *
 * @define
 *   TTP TreeTablePosition
 * @define
 *   URL0
 *   [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/$TTP.html@define JFX JavaFX @define ORIGINALDOC Original Documentation]].
 */
class TreeTablePosition[S, T](override val delegate: jfxsc.TreeTablePosition[S, T])
    extends TablePositionBase[jfxsc.TreeTableColumn[S, T]](delegate)
    with SFXDelegate[jfxsc.TreeTablePosition[S, T]] {

  /**
   * Constructs a TreeTablePosition instance to represent the given row/column position in the given TreeTableView
   * instance.
   *
   * @param treeTableView
   *   The TreeTableView that this position is related to.
   * @param row
   *   The row that this TreeTablePosition is representing.
   * @param tableColumn
   *   The TreeTableColumn instance that this TreeTablePosition represents.
   * @see
   *   $URL0#TreeTablePosition-javafx.scene.control.TreeTableView-int-javafx.scene.control.TreeTableColumn- $ORIGINALDOC
   */
  def this(treeTableView: jfxsc.TreeTableView[S], row: Int, tableColumn: jfxsc.TreeTableColumn[S, T]) =
    this(new jfxsc.TreeTablePosition(treeTableView, row, tableColumn))

  /**
   * The TreeTableView that this TreeTablePosition is related to.
   *
   * @see
   *   $URL0#getTreeTableView-- $ORIGINALDOC
   */
  def treeTableView: jfxsc.TreeTableView[S] = delegate.getTreeTableView

  /**
   * Returns the TreeItem that backs the TablePositionBase.row
   *
   * @see
   *   $URL0#getTreeItem-- $ORIGINALDOC
   */
  def treeItem: jfxsc.TreeItem[S] = delegate.getTreeItem

}
