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

import javafx.scene.control.{ cell => jfxscc }

object CellIncludes extends CellIncludes

trait CellIncludes {
  implicit def jfxCheckBoxListCell2sfx[T](cell: jfxscc.CheckBoxListCell[T]) = new CheckBoxListCell[T](cell)
  implicit def jfxCheckBoxTableCell2sfx[S, T](cell: jfxscc.CheckBoxTableCell[S, T]) = new CheckBoxTableCell[S, T](cell)
  implicit def jfxCheckBoxTreeCell2sfx[T](cell: jfxscc.CheckBoxTreeCell[T]) = new CheckBoxTreeCell[T](cell)
  implicit def jfxChoiceBoxListCell2sfx[T](cell: jfxscc.ChoiceBoxListCell[T]) = new ChoiceBoxListCell[T](cell)
  implicit def jfxChoiceBoxTableCell2sfx[S, T](cell: jfxscc.ChoiceBoxTableCell[S, T]) = new ChoiceBoxTableCell[S, T](cell)
  implicit def jfxChoiceBoxTreeCell2sfx[T](cell: jfxscc.ChoiceBoxTreeCell[T]) = new ChoiceBoxTreeCell[T](cell)
  implicit def jfxComboBoxListCell2sfx[T](cell: jfxscc.ComboBoxListCell[T]) = new ComboBoxListCell[T](cell)
  implicit def jfxComboBoxTableCell2sfx[S, T](cell: jfxscc.ComboBoxTableCell[S, T]) = new ComboBoxTableCell[S, T](cell)
  implicit def jfxComboBoxTreeCell2sfx[T](cell: jfxscc.ComboBoxTreeCell[T]) = new ComboBoxTreeCell[T](cell)
  implicit def jfxProgressBarTableCell2sfx[S](cell: jfxscc.ProgressBarTableCell[S]) = new ProgressBarTableCell[S](cell)
  implicit def jfxTextFieldListCell2sfx[T](cell: jfxscc.TextFieldListCell[T]) = new TextFieldListCell[T](cell)
  implicit def jfxTextFieldTableCell2sfx[S, T](cell: jfxscc.TextFieldTableCell[S, T]) = new TextFieldTableCell[S, T](cell)
  implicit def jfxTextFieldTreeCell2sfx[T](cell: jfxscc.TextFieldTreeCell[T]) = new TextFieldTreeCell[T](cell)
}