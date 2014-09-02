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
 * Object companion for [[scalafx.scene.control.TableFocusModel]].
 *
 * @since 8.0
 */
object TableFocusModel {

  /**
   * Converts a ScalaFX TableFocusModel to its JavaFX counterpart
   *
   * @param tfm ScalaFX TableFocusModel
   * @return JavaFX TableFocusModel
   * @tparam T The type of the underlying data model for the UI control.
   * @tparam TC The concrete subclass of [[scalafx.scene.control.TableColumnBase]] that is used by
   *            the underlying UI control (e.g. [[scalafx.scene.control.TableColumn]] or `TreeTableColumn`).
   */
  implicit def sfxTableFocusModel2jfx[T, TC <: jfxsc.TableColumnBase[T, _]](tfm: TableFocusModel[T, TC]): jfxsc.TableFocusModel[T, TC] =
    if (tfm != null) tfm.delegate else null

}

/**
 * Wraps a JavaFX [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/TableFocusModel.html TableFocusModel]].
 *
 * @constructor Creates a new ScalaFX TableFocusModel from its JavaFX counterpart.
 * @param delegate JavaFX TableFocusModel to be wrapped.
 * @tparam T The type of the underlying data model for the UI control.
 * @tparam TC The concrete subclass of [[scalafx.scene.control.TableColumnBase]] that is used by
 *            the underlying UI control (e.g. [[scalafx.scene.control.TableColumn]] or `TreeTableColumn`).
 * @since 8.0
 */
abstract class TableFocusModel[T, TC <: jfxsc.TableColumnBase[T, _]](override val delegate: jfxsc.TableFocusModel[T, TC])
  extends FocusModel[T](delegate)
  with SFXDelegate[jfxsc.TableFocusModel[T, TC]] {

  /**
   * Causes the item at the given index to receive the focus.
   *
   * @param row The row index of the item to give focus to.
   * @param column The column of the item to give focus to. Can be null.
   */
  def focus(row: Int, column: TC) {
    delegate.focus(row, column)
  }

  /** Attempts to move focus to the cell above the currently focused cell. */
  def focusAboveCell() {
    delegate.focusAboveCell
  }

  /** Attempts to move focus to the cell below the currently focused cell. */
  def focusBelowCell() {
    delegate.focusBelowCell
  }

  /** Attempts to move focus to the cell to the left of the currently focused cell. */
  def focusLeftCell() {
    delegate.focusLeftCell
  }

  /** Attempts to move focus to the cell to the right of the the currently focused cell. */
  def focusRightCell() {
    delegate.focusRightCell
  }

  /**
   * Tests whether the row / cell at the given location currently has the focus within the UI control.
   *
   * @param row The row index of the item to give focus to.
   * @param column The column of the item to give focus to. Can be null.
   * @return `true` whether the row / cell at the given location currently has the focus within the UI control.
   */
  def isFocused(row: Integer, column: TC): Boolean = delegate.isFocused(row, column)

}