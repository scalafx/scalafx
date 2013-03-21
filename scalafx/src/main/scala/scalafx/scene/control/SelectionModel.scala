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

import javafx.scene.{control => jfxsc}
import scalafx.Includes.jfxReadOnlyIntegerProperty2sfx
import scalafx.beans.property.ReadOnlyIntegerProperty
import scalafx.beans.property.ReadOnlyObjectProperty
import scalafx.delegate.SFXDelegate

object SelectionModel {
  implicit def sfxSelectionModel2jfx[T](v: SelectionModel[T]) = v.delegate
}

abstract class SelectionModel[T](override val delegate: jfxsc.SelectionModel[T])
  extends SFXDelegate[jfxsc.SelectionModel[T]] {

  /**
   * Refers to the selected index property, which is used to indicate the
   * currently selected index value in the selection model.
   */
  def selectedIndex: ReadOnlyIntegerProperty = delegate.selectedIndexProperty

  /**
   * Refers to the selected item property, which is used to indicate the
   * currently selected item in the selection model.
   */
  def selectedItem: ReadOnlyObjectProperty[T] = 
    new ReadOnlyObjectProperty[T](delegate.selectedItemProperty)

  /**
   * A method that clears any selection prior to setting the selection to the
   * given index.
   */
  def clearAndSelect(index: Int) {
    delegate.clearAndSelect(index)
  }

  /**
   * Clears the selection model of all selected indices.
   */
  def clearSelection() {
    delegate.clearSelection()
  }

  /**
   * This method will clear the selection of the item in the given index.
   */
  def clearSelection(index: Int) {
    delegate.clearSelection(index)
  }

  /**
   * This method is available to test whether there are any selected
   * indices/items.
   */
  def isEmpty: Boolean = delegate.isEmpty

  /**
   * Convenience method to inform if the given index is currently selected in this SelectionModel.
   */
  def isSelected(index: Int): Boolean = delegate.isSelected(index)

  /**
   * This will select the given index in the selection model, assuming the
   * index is within the valid range (i.e.
   */
  def select(index: Int) {
    delegate.select(index)
  }

  /**
   * This method will attempt to select the index that contains the given object.
   */
  def select(obj: T) {
    delegate.select(obj)
  }

  /**
   * This method will attempt to select the first index in the control.
   */
  def selectFirst() {
    delegate.selectFirst()
  }

  /**
   * This method will attempt to select the last index in the control.
   */
  def selectLast() {
    delegate.selectLast()
  }

  /**
   * This method will attempt to select the index directly after the current
   * focused index.
   */
  def selectNext() {
    delegate.selectNext()
  }

  /**
   * This method will attempt to select the index directly before the current focused index.
   */
  def selectPrevious() {
    delegate.selectPrevious()
  }

}
