/**
  * Copyright (c) 2011-2014, ScalaFX Project
  * All rights reserved.
  *
  * Redistribution and use in source and binary forms, with or without
  * modification, are permitted provided that the following conditions are met:
  * * Redistributions of source code must retain the above copyright
  * notice, this list of conditions and the following disclaimer.
  * * Redistributions in binary form must reproduce the above copyright
  * notice, this list of conditions and the following disclaimer in the
  * documentation and/or other materials provided with the distribution.
  * * Neither the name of the ScalaFX Project nor the
  * names of its contributors may be used to endorse or promote products
  * derived from this software without specific prior written permission.
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
import scalafx.Includes._
import scalafx.beans.property.BooleanProperty
import scalafx.delegate.SFXDelegate

/**
  * Object companion for [[scalafx.scene.control.TablePositionBase]]
  * @since 8.0
  */
object TableSelectionModel {

  /**
    * Converts a ScalaFX TablePositionBase into a JavaFX version.
    *
    * @param tsm ScalaFX TablePositionBase
    * @return JavaFX TablePositionBase
    * @since 8.0
    */
  implicit def sfxTableSelectionModel2jfx[T](tsm: TableSelectionModel[T]): jfxsc.TableSelectionModel[T] =
    if (tsm != null) tsm.delegate else null

}

/**
  * Wraps JavaFX [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/TableSelectionModel.html TableSelectionModel]].
  *
  * @constructor creates a new ScalaFX TableSelectionModel from a JavaFX one.
  * @param delegate JavaFX TableSelectionModel
  * @tparam T The type of the underlying data model for the UI control.
  * @since 8.0
  */
class TableSelectionModel[T](override val delegate: jfxsc.TableSelectionModel[T])
    extends MultipleSelectionModel[T](delegate)
    with SFXDelegate[jfxsc.TableSelectionModel[T]] {

  //    protected abstract int getItemCount()

  //    protected abstract T getModelItem(int index)

  //    protected abstract void focus(int index)

  //    protected abstract int getFocusedIndex()

  /**
    * A boolean property used to represent whether the TableView is in row or cell selection modes.
    */
  def cellSelectionEnabled: BooleanProperty = delegate.cellSelectionEnabledProperty
  def cellSelectionEnabled_=(v: Boolean) {
    cellSelectionEnabled() = v
  }

  /**
    * Convenience function which tests whether the given row and column index is currently selected in this
    * TableView instance.
    */
  def isSelected(row: Int, column: TableColumnBase[T, _]): Boolean = delegate.isSelected(row, column)

  /**
    * Selects the cell at the given row/column intersection.
    */
  def select(row: Int, column: TableColumnBase[T, _]) {
    delegate.select(row, column)
  }

  /**
    * Clears all selection, and then selects the cell at the given row/column intersection.
    */
  def clearAndSelect(row: Int, column: TableColumnBase[T, _]) {
    delegate.clearAndSelect(row, column)
  }

  /**
    * Removes selection from the specified row/column position (in view indexes).
    */
  def clearSelection(row: Int, column: TableColumnBase[T, _]) {
    delegate.clearSelection(row, column)
  }

  /**
    * Selects the cell directly above the currently selected cell.
    */
  def selectAboveCell() {
    delegate.selectAboveCell()
  }

  /**
    * Selects the cell directly below the currently selected cell.
    */
  def selectBelowCell() {
    delegate.selectBelowCell()
  }

  /**
    * Selects the cell to the left of the currently selected cell.
    */
  def selectLeftCell() {
    delegate.selectLeftCell()
  }

  /**
    * Selects the cell to the right of the currently selected cell.
    */
  def selectRightCell() {
    delegate.selectRightCell()
  }

  /**
    * Selects the cells in the range (minRow, minColumn) to (maxRow, maxColumn), inclusive.
    */
  def selectRange(minRow: Int, minColumn: TableColumnBase[T, _], maxRow: Int, maxColumn: TableColumnBase[T, _]) {
    delegate.selectRange(minRow, minColumn, maxRow, maxColumn)
  }

}
