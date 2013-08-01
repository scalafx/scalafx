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

import scala.math.Ordering
import javafx.scene.{control => jfxsc}
import javafx.{scene => jfxs}
import scalafx.Includes._
import scalafx.beans.property.BooleanProperty
import scalafx.beans.property.DoubleProperty
import scalafx.beans.property.ObjectProperty
import scalafx.beans.property.ReadOnlyDoubleProperty
import scalafx.beans.property.ReadOnlyObjectProperty
import scalafx.beans.property.StringProperty
import scalafx.event.EventHandlerDelegate
import scalafx.scene.Node
import scalafx.delegate.SFXDelegate
import scalafx.collections.ObservableBuffer

object TableColumnBase {
  implicit def sfxTableColumn2jfx[S, T](tc: TableColumnBase[S, T]) = tc.delegate

  /**
   * By default all columns will use this comparator to perform sorting.
   */
  val DEFAULT_COMPARATOR: Ordering[_] = Ordering.comparatorToOrdering(jfxsc.TableColumnBase.DEFAULT_COMPARATOR)
}

/**
 * Wraps [[http://docs.oracle.com/javafx/8/api/javafx/scene/control/TableColumnBase.html]].
 */
abstract class TableColumnBase[S, T] protected (override val delegate: jfxsc.TableColumnBase[S, T])
  extends EventHandlerDelegate
  with SFXDelegate[jfxsc.TableColumnBase[S, T]] {

  /**
   * This enables support for nested columns, which can be useful to group together related data.
   */
  def columns: ObservableBuffer[_ <: jfxsc.TableColumnBase[S, _]]

  /**
   * Comparator function used when sorting this TableColumnBase.
   */
  def comparator: ObjectProperty[Ordering[T]] = ObjectProperty(Ordering.comparatorToOrdering(delegate.comparatorProperty.getValue))
  def comparator_=(v: Ordering[T]) {
    comparator() = v
  }

  /**
   * This menu will be shown whenever the user right clicks within the header area of this TableColumnBase.
   */
  def contextMenu: ObjectProperty[jfxsc.ContextMenu] = delegate.contextMenuProperty
  def contextMenu_=(v: ContextMenu) {
    contextMenu() = v
  }

  /**
   * Specifies whether this TableColumnBase allows editing.
   */
  def editable: BooleanProperty = delegate.editableProperty
  def editable_=(v: Boolean) {
    editable() = v
  }

  /**
   * The graphic in the TableColumnBase.
   */
  def graphic: ObjectProperty[jfxs.Node] = delegate.graphicProperty
  def graphic_=(v: Node) {
    graphic() = v
  }

  /**
   * The id of this TableColumnBase.
   */
  def id: StringProperty = delegate.idProperty
  def id_=(v: String) {
    id() = v
  }

  /**
   * The maximum width the TableColumnBase is permitted to be resized to.
   */
  def maxWidth: DoubleProperty = delegate.maxWidthProperty
  def maxWidth_=(v: Double) {
    maxWidth() = v
  }

  /**
   * The minimum width the TableColumnBase is permitted to be resized to.
   */
  def minWidth: DoubleProperty = delegate.minWidthProperty
  def minWidth_=(v: Double) {
    minWidth() = v
  }

  /**
   * This read-only property will always refer to the parent of this column, in the situation where nested columns are being used.
   */
  def parentColumn: ReadOnlyObjectProperty[jfxsc.TableColumnBase[S,_]] = delegate.parentColumnProperty

  /**
   * The preferred width of the TableColumnBase.
   */
  def prefWidth: DoubleProperty = delegate.prefWidthProperty
  def prefWidth_=(v: Double) {
    prefWidth() = v
  }

  /**
   * Used to indicate whether the width of this column can change.
   */
  def resizable: BooleanProperty = delegate.resizableProperty
  def resizable_=(v: Boolean) {
    resizable() = v
  }

  /**
   * A boolean property to toggle on and off the sortability of this column.
   */
  def sortable: BooleanProperty = delegate.sortableProperty
  def sortable_=(v: Boolean) {
    sortable() = v
  }

  /**
   * The sort node is commonly seen represented as a triangle that rotates on screen to indicate whether the
   * TableColumnBase is part of the sort order, and if so, what position in the sort order it is in.
   */
  def sortNode: ObjectProperty[jfxs.Node] = delegate.sortNodeProperty
  def sortNode_=(v: Node) {
    sortNode() = v
  }

  /**
   * The CSS style string associated to this TableColumnBase.
   */
  def style: StringProperty = delegate.styleProperty
  def style_=(v: String) {
    style() = v
  }

  /**
   * A list of String identifiers which can be used to logically group Nodes, specifically for an external style engine.
   */
  def styleClass: ObservableBuffer[String] = delegate.getStyleClass


  /**
   * This is the text to show in the header for this column.
   */
  def text: StringProperty = delegate.textProperty
  def text_=(v: String) {
    text() = v
  }

  /**
   * Returns a previously set Object property, or null if no such property has been set using the
   * setUserData(Any) method.
   */
  def userData = delegate.getUserData

  /**
   * Toggling this will immediately toggle the visibility of this column, and all children columns.
   */
  def visible: BooleanProperty = delegate.visibleProperty
  def visible_=(v: Boolean) {
    visible() = v
  }

  /**
   * The width of this column.
   */
  def width: ReadOnlyDoubleProperty = delegate.widthProperty

  /**
   * Returns the actual value for a cell at a given row index (and which belongs to this TableColumnBase).
   */
  def getCellData(index: Int) = delegate.getCellData(index)

  /**
   * Returns the actual value for a cell from the given item.
   */
  def getCellData(index: S) = delegate.getCellData(index)

  /**
   * Tests if this TableColumnBase has properties.
   */
  def hasProperties = delegate.hasProperties

  override protected def eventHandlerDelegate = delegate.asInstanceOf[EventHandled]
}