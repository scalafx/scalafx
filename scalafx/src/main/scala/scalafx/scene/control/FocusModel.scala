/*
 * Copyright (c) 2011-2025, ScalaFX Project
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

import javafx.scene.control as jfxsc
import scalafx.Includes.*
import scalafx.beans.property.{ReadOnlyIntegerProperty, ReadOnlyObjectProperty}
import scalafx.delegate.SFXDelegate

import scala.language.implicitConversions

/**
 * Object companion for [[scalafx.scene.control.FocusModel]].
 */
object FocusModel {

  /**
   * Converts a ScalaFX FocusModel to its JavaFX counterpart
   *
   * @param v ScalaFX FocusModel
   * @return JavaFX FocusModel
   * @tparam T The type of the underlying data model for the UI control.
   */
  implicit def sfxFocusModel2jfx[T](v: FocusModel[T]): jfxsc.FocusModel[T] = if (v != null) v.delegate else null
}

/**
 * Wraps a JavaFX [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/FocusModel.html FocusModel]].
 *
 * @constructor Creates a new ScalaFX FocusModel from its JavaFX counterpart.
 * @param delegate JavaFX FocusModel to be wrapped.
 * @tparam T The type of the underlying data model for the UI control.
 */
abstract class FocusModel[T](override val delegate: jfxsc.FocusModel[T])
    extends SFXDelegate[jfxsc.FocusModel[T]] {

  /**
   * The index of the current item in the FocusModel which has the focus.
   */
  def focusedIndex: ReadOnlyIntegerProperty = delegate.focusedIndexProperty

  /**
   * The current item in the FocusModel which has the focus.
   */
  def focusedItem: ReadOnlyObjectProperty[T] = delegate.focusedItemProperty

  /**
   * Causes the item at the given index to receive the focus.
   *
   * @param index The index of the item to get focus.
   */
  def focus(index: Int): Unit = {
    delegate.focus(index)
  }

  /**
   * Attempts to give focus to the row after to the currently focused row.
   */
  def focusNext(): Unit = {
    delegate.focusNext()
  }

  /**
   * Attempts to give focus to the row previous to the currently focused row.
   */
  def focusPrevious(): Unit = {
    delegate.focusPrevious()
  }

  /*
   * Returns the number of items in the data model that underpins the control.
   */
  //  protected def itemCount: Int

  /*
   * Returns the item at the given index.
   */
  //  protected def modelItem(index: Int): T

}
