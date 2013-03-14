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
package scalafx.scene.control

import javafx.scene.{ control => jfxsc }
import javafx.{ util => jfxu }
import scalafx.Includes._
import scalafx.beans.property.ObjectProperty
import scalafx.beans.property.ReadOnlyBooleanProperty
import scalafx.collections.ObservableBuffer
import scalafx.util.StringConverter
import scalafx.delegate.SFXDelegate

object ChoiceBox {
  implicit def sfxChoiceBox2jfx[J <: Any](cb: ChoiceBox[J]) = cb.delegate
}

class ChoiceBox[J <: Any](override val delegate: jfxsc.ChoiceBox[J] = new jfxsc.ChoiceBox[J])
  extends Control(delegate)
  with SFXDelegate[jfxsc.ChoiceBox[J]] {

  /**
   * Create a new ChoiceBox with the given set of items.
   */
  def this(items: ObservableBuffer[J]) = this(new jfxsc.ChoiceBox[J](items))

  /**
   * Allows a way to specify how to represent objects in the items list.
   */
  def converter: ObjectProperty[jfxu.StringConverter[J]] = delegate.converterProperty
  def converter_=(v: StringConverter[J]) {
    converter() = v
  }

  /**
   * The items to display in the choice box.
   */
  def items = delegate.itemsProperty
  def items_=(v: ObservableBuffer[J]) {
    items() = v
  }

  /**
   * The selection model for the ChoiceBox.
   */
  def selectionModel: ObjectProperty[jfxsc.SingleSelectionModel[J]] = delegate.selectionModelProperty
  def selectionModel_=(v: SingleSelectionModel[J]) {
    selectionModel() = v
  }

  /**
   * Indicates whether the drop down is displaying the list of choices to the
   * user. Although showing be a ReadOnlyBooleanProperty, a setter method is
   * implemented using `show()` and `hide()` method from ChoiceBox JavaFX.
   */
  def showing: ReadOnlyBooleanProperty = delegate.showingProperty
  def showing_=(show: Boolean) {
    if (show) delegate.show
    else delegate.hide
  }

  /**
   * The value of this ChoiceBox is defined as the selected item in the
   * ChoiceBox selection model.
   *
   */
  def value: ObjectProperty[J] = delegate.valueProperty
  def value_=(v: J) {
    value() = v
  }

}