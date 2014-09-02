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
import scalafx.delegate.SFXDelegate

/**
 * Object companion for [[scalafx.scene.control.TablePositionBase]]
 * @since 8.0
 */
object TablePositionBase {

  /**
   * Converts a ScalaFX TablePositionBase into a JavaFX version.
   *
   * @param tpb ScalaFX TablePositionBase
   * @return JavaFX TablePositionBase
   * @since 8.0
   */
  implicit def sfxTablePositionBase2jfx[TC <: jfxsc.TableColumnBase[_, _]](tpb: TablePositionBase[TC]): jfxsc.TablePositionBase[TC] =
    if (tpb != null) tpb.delegate else null

}

/**
 * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/TablePosition.html]].
 *
 * @constructor creates a new ScalaFX TablePositionBase from a JavaFX one.
 * @param delegate JavaFX TablePositionBase
 * @tparam TC A JavaFX TableColumnBase subclass
 * @since 8.0
 */
abstract class TablePositionBase[TC <: jfxsc.TableColumnBase[_, _]](override val delegate: jfxsc.TablePositionBase[TC])
  extends SFXDelegate[jfxsc.TablePositionBase[TC]] {

  //  protected	TablePositionBase(int row, TC tableColumn)

  /**
   * The column index that this TablePosition represents in the TableView.
   */
  def column: Int = delegate.getColumn

  /**
   * The row that this TablePosition represents in the TableView.
   */
  def row: Int = delegate.getRow

  /**
   * The TableColumn that this TablePosition represents in the TableView.
   */
  def tableColumn: TC = delegate.getTableColumn

}