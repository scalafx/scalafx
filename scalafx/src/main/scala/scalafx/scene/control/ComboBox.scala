/*
 * Copyright (c) 2011-2021, ScalaFX Project
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
import javafx.{collections => jfxc, scene => jfxs, util => jfxu}
import scalafx.Includes._
import scalafx.beans.property.{IntegerProperty, ObjectProperty, ReadOnlyObjectProperty}
import scalafx.collections.ObservableBuffer
import scalafx.collections.ObservableBuffer._
import scalafx.delegate.SFXDelegate
import scalafx.scene.Node
import scalafx.util.StringConverter
import scalafx.util.StringConverter._

import scala.language.implicitConversions

object ComboBox {
  implicit def sfxComboBox2jfx[T](cb: ComboBox[T]): jfxsc.ComboBox[T] = if (cb != null) cb.delegate else null
}

/**
 * Wraps [[https://openjfx.io/javadoc/16/javafx.controls/javafx/scene/control/ComboBox.htmlJavaFX ComboBox]], an
 * implementation of the ComboBoxBase abstract class for the most common form of ComboBox, where a popup list is shown
 * to users providing them with a choice that they may select from.
 *
 * On top of ComboBoxBase, the ComboBox class introduces additional API. Most importantly, it adds an items property
 * that works in much the same way as the ListView items property. In other words, it is the content of the items list
 * that is displayed to users when they click on the ComboBox button.
 *
 * It is not recommended to add `Node`s as ComboBox items. ScalaFX provides for a convenient customization of a ComboBox
 * content. Required `Node` or other customization is add ed through cell factory. Following code will show colored
 * `Rectangle` representing item's `Color`
 * {{{
 *   val comboBox = new ComboBox[Color] {
 *     items = Seq(Color.Red, Color.Green, Color.Blue)
 *     // Custom factory displaying list items are colored rectangles
 *     // `color` is the value of the item displayed
 *     cellFactory = (cell, color) => {
 *       cell.contentDisplay = ContentDisplay.GraphicOnly
 *       cell.graphic = Rectangle(10, 10, color)
 *     }
 *   }
 * }}}
 *
 * @param delegate
 *   the wrapped JavaFX class.
 * @tparam T
 *   The type of the value that has been selected or otherwise entered in to this ComboBox
 */
class ComboBox[T](override val delegate: jfxsc.ComboBox[T] = new jfxsc.ComboBox[T])
    extends ComboBoxBase(delegate)
    with SFXDelegate[jfxsc.ComboBox[T]] {

  /**
   * Creates a default ComboBox instance from a [[scalafx.collections.ObservableBuffer]] with the provided items list
   * and a default selection model.
   */
  def this(items: ObservableBuffer[T]) = this(new jfxsc.ComboBox[T](items))

  /**
   * Creates a default ComboBox instance from a [[scala.Seq]] with the provided items list and a default selection
   * model.
   */
  def this(items: Seq[T]) = this(new jfxsc.ComboBox[T](ObservableBuffer.from(items)))

  /**
   * Providing a custom cell factory allows for complete customization of the rendering of items in the ComboBox.
   */
  def cellFactory: ObjectProperty[jfxu.Callback[jfxsc.ListView[T], jfxsc.ListCell[T]]] = delegate.cellFactoryProperty
  def cellFactory_=(callback: javafx.util.Callback[jfxsc.ListView[T], jfxsc.ListCell[T]]): Unit = {
    cellFactory() = callback
  }

  @deprecated(
    message = "" +
      "This method does not allow for correct handling of empty cells leading to possible rendering artifacts. " +
      "See explanation in [[https://github.com/scalafx/scalafx/issues/256 ScalaFX Issue #256]]. " +
      "Use the new `cellFactory` assignment method: `cellFactory_=(op: (ListCell[T], T) => Unit)` that automatically " +
      "handles empty cells.",
    since = "16.0.0-R25"
  )
  def cellFactory_=(f: ListView[T] => ListCell[T]): Unit = {
    delegate.cellFactoryProperty.setValue(new jfxu.Callback[jfxsc.ListView[T], jfxsc.ListCell[T]] {
      def call(v: jfxsc.ListView[T]): jfxsc.ListCell[T] = {
        f(v)
      }
    })
  }

  /**
   * A convenience method for creation of custom cell factory. The caller is responsible for providing an operation `op`
   * that renders a non-empty cells from a non-null value.
   *
   * Implementation provides logic for handling empty cells and `null` values.
   *
   * The `op` provides two arguments: a pre-created `cell` and `value` for that cell. Caller can customize content of
   * the `cell` based on the `value`.
   *
   * The `value` is guaranteed to be non `null`. The `null` values are automatically rendered as empty cells by the
   * implementation.
   *
   * Here is an example where `value`'s type is a class `Person` that contains two text fields: `firstName` and
   * `lastName`.
   * {{{
   *   case class Person(firstName:String, lastName:String)
   *   ...
   *   cellFactory = (cell, value) => {
   *     cell.text = value.firstName + " " + value.lastName
   *   }
   * }}}
   *
   * Another example where `value` is of type `Color` and the cell factory creates a circle representing that color:
   * {{{
   *   cellFactory = (cell, value) => {
   *     cell.graphic = new Circle {
   *       fill = value
   *       radius = 8
   *     }
   *   }
   * }}}
   *
   * @param op
   *   a method that will create content for a given `cell`. It gets as an input automatically created custom `cell` and
   *   a non-null `value` of that cell. `op` is called in the cell's `updateItem` method.
   */
  def cellFactory_=(op: (ListCell[T], T) => Unit): Unit = {
    val callback =
      Option(op).map { op =>
        new jfxu.Callback[jfxsc.ListView[T], jfxsc.ListCell[T]] {
          def call(tv: jfxsc.ListView[T]): jfxsc.ListCell[T] = {
            new jfxsc.ListCell[T] {
              val sfxThis = new ListCell(this)
              override def updateItem(item: T, empty: Boolean): Unit = {
                super.updateItem(item, empty)
                if (empty || item == null) {
                  setText(null)
                  setGraphic(null)
                } else {
                  op(sfxThis, item)
                }
              }
            }
          }
        }
      }.orNull
    delegate.cellFactoryProperty.setValue(callback)
  }

  /**
   * Converts the user-typed input (when the ComboBox is editable) to an object of type T, such that the input may be
   * retrieved via the value property.
   */
  def converter: ObjectProperty[jfxu.StringConverter[T]] = delegate.converterProperty

  def converter_=(v: StringConverter[T]): Unit = {
    converter() = v
  }

  /**
   * The list of items to show within the ComboBox popup.
   */
  def items: ObjectProperty[jfxc.ObservableList[T]] = delegate.itemsProperty

  def items_=(v: ObservableBuffer[T]): Unit = {
    items() = v
  }

  /**
   * This Node is shown to the user when the ComboBox has no content to show.
   */
  def placeholder: ObjectProperty[jfxs.Node] = delegate.placeholderProperty

  def placeholder_=(v: Node): Unit = {
    ObjectProperty.fillProperty[jfxs.Node](placeholder, v)
  }

  /**
   * The selection model for the ComboBox.
   */
  def selectionModel: ObjectProperty[jfxsc.SingleSelectionModel[T]] = delegate.selectionModelProperty

  def selectionModel_=(v: SingleSelectionModel[T]): Unit = {
    selectionModel() = v.delegate
  }

  /**
   * The maximum number of rows to be visible in the ComboBox popup when it is showing.
   */
  def visibleRowCount: IntegerProperty = delegate.visibleRowCountProperty

  def visibleRowCount_=(v: Int): Unit = {
    visibleRowCount() = v
  }

  /**
   * The button cell is used to render what is shown in the ComboBox 'button' area. If a cell is set here, it does not
   * change the rendering of the ComboBox popup list - that rendering is controlled via the cell factory API.
   *
   * @since
   *   2.2
   */
  def buttonCell: ObjectProperty[jfxsc.ListCell[T]] = delegate.buttonCellProperty()

  def buttonCell_=(v: ListCell[T]): Unit = {
    buttonCell() = v
  }

  /**
   * The editor for the ComboBox.
   *
   * @since
   *   2.2
   */
  def editor: ReadOnlyObjectProperty[jfxsc.TextField] = delegate.editorProperty()

  /**
   * Append a item at end of list of items
   *
   * @param item
   *   Item to be added.
   * @return
   *   Combobox itself
   */
  def +=(item: T): Unit = {
    this.items.value += item
  }

  /**
   * Remove a item in list of items
   *
   * @param item
   *   Item to be removed.
   * @return
   *   Combobox itself
   */
  def -=(item: T): Unit = {
    this.items.value -= item
  }

}
