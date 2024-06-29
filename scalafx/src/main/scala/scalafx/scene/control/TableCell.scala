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
package scalafx.scene.control

import javafx.scene.{control => jfxsc}
import scalafx.Includes._
import scalafx.beans.property.ReadOnlyObjectProperty
import scalafx.delegate.SFXDelegate

import scala.language.implicitConversions

object TableCell {
  implicit def sfxTableCell2jfx[S, T](tc: TableCell[S, T]): jfxsc.TableCell[S, T] =
    if (tc != null) tc.delegate else null
}

/**
 * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/TableCell.html]].
 */
class TableCell[S, T](override val delegate: jfxsc.TableCell[S, T] = new jfxsc.TableCell[S, T]())
    extends IndexedCell[T]
    with SFXDelegate[jfxsc.TableCell[S, T]] {

  /**
   * The TableColumn instance that backs this TableCell.
   */
  def tableColumn: ReadOnlyObjectProperty[jfxsc.TableColumn[S, T]] = delegate.tableColumnProperty

  /**
   * The TableRow that this TableCell currently finds itself placed within.
   */
  def tableRow: ReadOnlyObjectProperty[jfxsc.TableRow[S]] = delegate.tableRowProperty

  /**
   * The TableView associated with this TableCell.
   */
  def tableView: ReadOnlyObjectProperty[jfxsc.TableView[S]] = delegate.tableViewProperty
}
