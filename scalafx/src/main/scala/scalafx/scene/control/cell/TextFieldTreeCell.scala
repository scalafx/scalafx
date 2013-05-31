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
package scalafx.scene.control.cell

import javafx.{ collections => jfxc }
import javafx.scene.control.{ cell => jfxscc }
import javafx.{ util => jfxu }
import scalafx.Includes._
import scalafx.collections.ObservableBuffer
import scalafx.scene.control.TreeCell
import scalafx.scene.control.TreeView
import scalafx.delegate.SFXDelegate
import scalafx.util.StringConverter

object TextFieldTreeCell {
  implicit def sfxTextFieldTreeCell2jfx[T](cell: TextFieldTreeCell[T]) = cell.delegate

  /**
   * Creates a TextField cell factory for use in `TreeView` controls.
   */
  def forTreeView(): (TreeView[String] => TreeCell[String]) =
    (view: TreeView[String]) => jfxscc.TextFieldTreeCell.forTreeView().call(view)

  /**
   * Added to satisfy Spec tests.
   */
//  @deprecated(message = "Use forTreeView()", since = "1.0")
//  def forTreeView() = jfxscc.TextFieldTreeCell.forTreeView()

  /**
   * Creates a TextField cell factory for use in `TreeView` controls.
   */
  def forTreeView[T](converter: StringConverter[T]): (TreeView[T] => TreeCell[T]) =
    (view: TreeView[T]) => jfxscc.TextFieldTreeCell.forTreeView[T](converter).call(view)

  /**
   * Added to satisfy Spec tests.
   */
  @deprecated(message = "Use forTreeView[T](StringConverter[T])", since = "1.0")
  def forTreeView[T](converter: jfxu.StringConverter[T]) = jfxscc.TextFieldTreeCell.forTreeView[T](converter)

}

/**
 * Wraps [[http://docs.oracle.com/javafx/2/api/javafx/scene/control/cell/TextFieldTreeCell.html]]
 */
class TextFieldTreeCell[T](override val delegate: jfxscc.TextFieldTreeCell[T] = new jfxscc.TextFieldTreeCell[T])
  extends TreeCell[T](delegate)
  with ConvertableCell[jfxscc.TextFieldTreeCell[T], T, T]
  with UpdatableCell[jfxscc.TextFieldTreeCell[T], T]
  with SFXDelegate[jfxscc.TextFieldTreeCell[T]] {

  /**
   * Creates a `TextFieldTreeCell` that provides a `TextField` when put into editing mode that allows editing of the 
   * cell content.
   */
  def this(converter: StringConverter[T]) = this(new jfxscc.TextFieldTreeCell[T](converter))
}