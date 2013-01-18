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
import scalafx.delegate.SFXDelegate

object MultipleSelectionModel {
  implicit def sfxMultipleSelectionModel2jfx[T](v: MultipleSelectionModel[T]) = v.delegate
}

abstract class MultipleSelectionModel[T](override val delegate: jfxsc.MultipleSelectionModel[T])
  extends SelectionModel[T](delegate)
  with SFXDelegate[jfxsc.MultipleSelectionModel[T]] {

  /**
   * Specifies the selection mode to use in this selection model. 
   * The selection mode specifies how many items in the underlying data model 
   * can be selected at
   * any one time.
   *
   * By default, the selection mode is SelectionMode.SINGLE.
   */
  def selectionMode = delegate.selectionModeProperty
  def selectionMode_=(v: SelectionMode) {
    selectionMode() = v
  }

  /**
   * Returns a read-only ObservableList of all selected indices. The 
   * ObservableList will be updated by the selection model to always reflect 
   * changes in selection. This can be observed by adding a ListChangeListener 
   * to the returned ObservableList.
   */
  def selectedIndices = delegate.getSelectedIndices

  /**
   * Returns a read-only ObservableList of all selected items. The 
   * ObservableList will be updated further by the selection model to always 
   * reflect changes in selection. This can be observed by adding a 
   * ListChangeListener to the returned ObservableList.
   */
  def selectedItems = delegate.getSelectedItems

  /**
   * This method allows for one or more selections to be set at the same time. 
   * It will ignore any value that is not within the valid range (i.e. greater 
   * than or equal to zero, and less than the total number of items in the 
   * underlying data model). Any duplication of indices will be ignored.
   *
   * If there is already one or more indices selected in this model, calling 
   * this method will not clear these selections - to do so it is necessary to 
   * first call clearSelection.
   *
   * The last valid value given will become the selected index / selected item.
   *
   */
  // To convert Scala varargs to Java varargs, see http://stackoverflow.com/questions/2334200/transforming-scala-varargs-into-java-object-varargs
  def selectIndices(index: Int, indices: Int*) = 
    delegate.selectIndices(index, indices.map(_.asInstanceOf[Int]): _*)

  /**
   * Selects all indices from the given start index to the item before the 
   * given end index. This means that the selection is inclusive of the start 
   * index, and exclusive of the end index. This method will work regardless 
   * of whether start < end or start > end: the only constant is that the index 
   * before the given end index will become the selected index.
   *
   * If there is already one or more indices selected in this model, calling 
   * this method will not clear these selections - to do so it is necessary to 
   * first call clearSelection.
   *
   * @param start The first index to select - this index will be selected.
   * @param end The last index of the selection - this index will not be selected.
   */
  def selectRange(start: Int, end: Int) = delegate.selectRange(start, end)

  /**
   * Convenience method to select all available indices.
   */
  def selectAll = delegate.selectAll

}