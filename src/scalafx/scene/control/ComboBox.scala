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

import scala.annotation.implicitNotFound

import javafx.scene.{control => jfxsc}
import javafx.{collections => jfxc}
import scalafx.Includes._
import scalafx.util.StringConverter._
import scalafx.util.SFXDelegate
import scalafx.util.StringConverter

object ComboBox {
  implicit def sfxComboBox2jfx[T](cb: ComboBox[T]) = cb.delegate
}

class ComboBox[T](override val delegate: jfxsc.ComboBox[T] = new jfxsc.ComboBox[T]) extends ComboBoxBase(delegate) with SFXDelegate[jfxsc.ComboBox[T]] {

  /**
   * Providing a custom cell factory allows for complete customization of the rendering of items in the ComboBox.
   * TODO: Replace ListView and ListCell from JavaFX for their respectives version in ScalaFX.
   */
  def cellFactory = delegate.cellFactoryProperty
  def cellFactory_=(v: jfxsc.ListView[T] => jfxsc.ListCell[T]) {
    cellFactory() = v
  }

  /**
   * Converts the user-typed input (when the ComboBox is editable) to an object of type T, such that the input may be retrieved via the value property.
   */
  def converter = delegate.converterProperty
  def converter_=(v: StringConverter[T]) {
    converter() = v
  }

  /**
   * The list of items to show within the ComboBox popup.
   */
  def items = delegate.itemsProperty
  def items_=(v: jfxc.ObservableList[T]) {
    items() = v
  }

  /**
   * The selection model for the ComboBox.
   */
  def selectionModel = delegate.selectionModelProperty
  def selectionModel_=(v: SingleSelectionModel[T]) {
    selectionModel() = v.delegate
  }

  /**
   * The maximum number of rows to be visible in the ComboBox popup when it is showing.
   */
  def visibleRowCount = delegate.visibleRowCountProperty
  def visibleRowCount_=(v: Int) {
    visibleRowCount() = v
  }

  /**
   * Append a item at end of list of items
   *
   * @param item Item to be added.
   * @return Combobox itself
   */
  def +=(item: T) {
    this.items.get += item

    this
  }

  /**
   * Remove a item in list of items
   *
   * @param item Item to be removed.
   * @return Combobox itself
   */
  def -=(item: T) {
    this.items.get -= item

    this
  }

}
