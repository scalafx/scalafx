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

import scala.language.implicitConversions

import javafx.scene.{control => jfxsc}
import scalafx.Includes._
import scalafx.delegate.SFXDelegate

/**
 * Object companion for [[scalafx.scene.control.TablePosition]]
 */
object TablePosition {
  /**
   * Converts a ScalaFX TablePosition into a JavaFX version.
   *
   * @param tpb ScalaFX TablePosition
   * @return JavaFX TablePosition
   * @tparam S The type of the items contained within the TableView (i.e. the same generic type as the S in TableView<S>).
   * @tparam T The type of the items contained within the TableColumn.
   */
  implicit def sfxTablePosition2jfx[S, T](tp: TablePosition[S, T]) = if (tp != null) tp.delegate else null

}

/**
 * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/TablePosition.html]].
 *
 * @constructor creates a new ScalaFX TablePosition from a JavaFX one.
 * @param JavaFX TablePositionBase to be wrapped
 * @tparam S The type of the items contained within the TableView (i.e. the same generic type as the S in TableView<S>).
 * @tparam T The type of the items contained within the TableColumn.
 */
class TablePosition[S, T](override val delegate: jfxsc.TablePosition[S, T])
  extends TablePositionBase[jfxsc.TableColumn[S, T]](delegate)
  with SFXDelegate[jfxsc.TablePosition[S, T]] {

  /**
   * Constructs a TablePosition instance to represent the given row/column position in the given TableView instance.
   */
  def this(tableView: TableView[S], row: Int, tableColumn: TableColumn[S, T]) =
    this(new jfxsc.TablePosition(tableView, row, tableColumn))

  /**
   * The TableView that this TablePosition is related to.
   */
  def tableView: TableView[S] = delegate.getTableView

}