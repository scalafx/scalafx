/*
 * Copyright (c) 2012, ScalaFX Project
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

import javafx.scene.{ control => jfxsc }
import scalafx.Includes._
import scalafx.util.SFXDelegate

object TablePosition {
  implicit def sfxTablePosition2jfx[S, T](tp: TablePosition[S, T]) = tp.delegate
}

/**
 * Wraps [[http://docs.oracle.com/javafx/2/api/javafx/scene/control/TablePosition.html]].
 */
class TablePosition[S, T](override val delegate: jfxsc.TablePosition[S, T])
  extends SFXDelegate[jfxsc.TablePosition[S, T]] {

  /**
   * Constructs a TablePosition instance to represent the given row/column position in the given TableView instance.
   */
  def this(tableView: TableView[S], row: Int, tableColumn: TableColumn[S, T]) =
    this(new jfxsc.TablePosition(tableView, row, tableColumn))

  /**
   * The column index that this TablePosition represents in the TableView.
   */
  def column = delegate.getColumn

  /**
   * The row that this TablePosition represents in the TableView.
   */
  def row = delegate.getRow

  /**
   * The TableColumn that this TablePosition represents in the TableView.
   */
  def tableColumn: TableColumn[S, T] = delegate.getTableColumn

  /**
   * The TableView that this TablePosition is related to.
   */
  def tableView: TableView[S] = delegate.getTableView
}