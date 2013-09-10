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

import javafx.scene.control.{ cell => jfxscc }
import scalafx.Includes._
import scalafx.delegate.SFXDelegate
import scalafx.scene.control.TableCell
import scalafx.scene.control.TableColumn

/**
 * Companion Object for [[scalafx.scene.control.cell.ProgressBarTableCell]].
 *
 * @define PBTC `ProgressBarTableCell`
 *
 */
object ProgressBarTableCell {

  /**
   * Converts a ScalaFX $PBTC to its JavaFX counterpart.
   *
   * @tparam S Type used in this cell
   * @param cell ScalaFX $PBTC
   * @return JavaFX $PBTC
   */
  implicit def sfxProgressBarTableCell2jfx[S](cell: ProgressBarTableCell[S]) = cell.delegate

  /**
   * Provides a `ProgressBar` that allows easy visualisation of a Number value as it proceeds from 0.0 to 1.0.
   *
   * @return A Function  that can be inserted into the cell factory property of a TableColumn, that enables visualisation of a Number as it progresses from 0.0 to 1.0.
   */
  def forTableColumn[S](): (TableColumn[S, java.lang.Double] => TableCell[S, java.lang.Double]) =
    (view: TableColumn[S, java.lang.Double]) => jfxscc.ProgressBarTableCell.forTableColumn[S]().call(view)

}

/**
 * Wraps [[http://docs.oracle.com/javafx/2/api/javafx/scene/control/cell/ProgressBarTableCell.html $PBTC]]
 *
 * @tparam S Type used in this cell
 * @constructor Creates a new $PBTC from a JavaFX $PBTC
 * @param delegate JavaFX $PBTC
 *
 * @define PBTC `ProgressBarTableCell`
 */
class ProgressBarTableCell[S](override val delegate: jfxscc.ProgressBarTableCell[S] = new jfxscc.ProgressBarTableCell[S])
  extends TableCell[S, java.lang.Double](delegate)
  with UpdatableCell[jfxscc.ProgressBarTableCell[S], java.lang.Double]
  with SFXDelegate[jfxscc.ProgressBarTableCell[S]] {

}