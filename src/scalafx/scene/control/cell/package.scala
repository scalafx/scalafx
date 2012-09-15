/* Copyright (c) 2012, ScalaFX Project
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
import javafx.beans.{ property => jfxbp }
import javafx.{ util => jfxu }
import scalafx.Includes._
import scalafx.beans.property.ObjectProperty
import scalafx.util.SFXDelegate
import scalafx.util.StringConverter
import scalafx.beans.property.BooleanProperty

package object cell {

  /**
   * Types that contains the method `converterProperty(): jfxbp.ObjectProperty[jfxu.StringConverter[T]]`
   */
  type Convertable[T] = {
    def converterProperty(): jfxbp.ObjectProperty[jfxu.StringConverter[T]]
  }

  /**
   * [[javafx.scene.control.Cell]]s that contains the method `converterProperty(): jfxbp.ObjectProperty[jfxu.StringConverter[T]]`
   */
  type JfxConvertableCell[T] = jfxsc.Cell[T] with Convertable[T]

  /**
   * Cells which delegate contains the method `converterProperty(): jfxbp.ObjectProperty[jfxu.StringConverter[T]]`
   */
  trait ConvertableCell[C <: JfxConvertableCell[T], T]
    extends SFXDelegate[C] {
    /**
     * The `StringConverter` property.
     */
    def converter: ObjectProperty[StringConverter[T]] = ObjectProperty(delegate.converterProperty.getValue)
    def converter_=(v: StringConverter[T]) {
      converter() = v
    }
  }

  /**
   * Types that contains the method `comboBoxEditableProperty(): jfxbp.BooleanProperty`
   */
  type ComboBoxEditable = {
    def comboBoxEditableProperty(): jfxbp.BooleanProperty
  }

  /**
   * [[javafx.scene.control.Cell]]s that contains the method `comboBoxEditableProperty(): jfxbp.BooleanProperty`.
   */
  type JfxComboBoxEditableCell[T] = jfxsc.Cell[T] with ComboBoxEditable

  /**
   * Cells which delegate contains the method `comboBoxEditableProperty(): jfxbp.BooleanProperty`.
   */
  trait ComboBoxEditableCell[C <: JfxComboBoxEditableCell[T], T]
    extends SFXDelegate[C] {
    /**
     * A property representing whether the `ComboBox`, when shown to the user, is editable or not.
     */
    def comboBoxEditable: BooleanProperty = delegate.comboBoxEditableProperty
    def comboBoxEditable_=(v: Boolean) {
      comboBoxEditable() = v
    }
  }

  /**
   * Cells which delegate contains the method `updateItem(item: Any, empty: Boolean): Unit`.
   */
  // TODO: Add Implementation note
  trait UpdatableCell[C <: jfxsc.Cell[T], T]
    extends SFXDelegate[C] {

    /**
     * Types that contains the method `updateItem(item: Any, empty: Boolean): Unit`
     */
    type Updated[T] = {
      def updateItem(item: Any, empty: Boolean): Unit
    }

    /**
     * Updates the item associated with this Cell.
     */
    def updateItem(item: T, empty: Boolean) = delegate.asInstanceOf[Updated[T]].updateItem(item, empty)
  }

  /*
   * Types that contains the method `updateItem(item: Any, empty: Boolean): Unit`
   *
  type JfxConvertableUpdatableCell[T] = jfxsc.Cell[T] with Convertable[T] with Updated[T]

  trait ConvertableUpdatableCell[C <: JfxConvertableUpdatableCell[T], T]
    extends SFXDelegate[C]
    with ConvertableCell[C, T]
    with UpdatableCell[C, T]
*/
  /**
   * Types that contains the methods `startEdit(): Unit` and `cancelEdit(): Unit`.
   */
  type Editable = {
    def startEdit(): Unit
    def cancelEdit(): Unit
  }

  /**
   * [[javafx.scene.control.Cell]]s that contains the methods `startEdit(): Unit` and `cancelEdit(): Unit`.
   */
  type JfxEditableCell[T] = jfxsc.Cell[T] with Editable

  /**
   * Cells which delegate contains the methods `startEdit(): Unit` and `cancelEdit(): Unit`.
   */
  trait EditableCell[C <: jfxsc.Cell[T] with Editable, T]
    extends SFXDelegate[C] {
    def startEdit = delegate.startEdit
    def cancelEdit = delegate.cancelEdit
  }

}