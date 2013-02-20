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
import javafx.{ scene => jfxs }

object Cell {
  implicit def sfxCell2jfx[T](c: Cell[T]) = c.delegate
}

class Cell[T](override val delegate: jfxsc.Cell[T] = new jfxsc.Cell[T])
  extends Labeled(delegate)
  with SFXDelegate[jfxsc.Cell[T]] {

  /**
   * A property representing whether this cell is allowed to be put into an editing state.
   */
  def editable = delegate.editableProperty
  def editable_=(v: Boolean) {
    editable() = v
  }

  /**
   * Property representing whether this cell is currently in its editing state.
   */
  def editing = delegate.editingProperty

  /**
   * A property used to represent whether the cell has any contents.
   */
  def empty = delegate.emptyProperty

  /**
   * The data value associated with this Cell.
   */
  def item = delegate.itemProperty
  def item_=(v: T) {
    item.set(v)
  }

  /**
   * Indicates whether or not this cell has been selected.
   */
  def selected = delegate.selectedProperty
  def selected_=(s: Boolean) {
    delegate.updateSelected(s)
  }

  /**
   * Call this function to transition from an editing state into a non-editing state, without 
   * saving any user input.
   */
  def cancelEdit = delegate.cancelEdit
  
  /**
   * Call this function to transition from an editing state into a non-editing state, and in the 
   * process saving any user input.
   */
  def commitEdit(newValue: T) = delegate.commitEdit(newValue)
  
  /**
   * Call this function to transition from a non-editing state into an editing state, if the cell 
   * is editable.
   */
  def startEdit = delegate.startEdit
  
  // TODO: implement updateItem(T item, boolean empty)
  // might be difficult since updateItem is a protected method which needs to be defined in the delegate's class
}
