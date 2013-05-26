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
package scalafx.scene.control.cell

import javafx.scene.control.{ cell => jfxscc }

object CellIncludes extends CellIncludes

/**
 * Contains implcit methods to convert from
 * [[http://docs.oracle.com/javafx/2/api/javafx/scene/control/cell/package-summary.html `javafx.scene.control.cell`]]
 * Classes/Traits to their $SFX counterparts.
 *
 * @define JFX JavaFX
 * @define SFX ScalaFX
 * @define START Converts a $JFX `[[http://docs.oracle.com/javafx/2/api/javafx/scene/control/cell/
 * @define END ]]` instance to its $SFX counterpart.
 *
 * @define CHBLC CheckBoxListCell
 * @define CHBTC CheckBoxTableCell
 * @define CHBRC CheckBoxTreeCell
 * @define XOBLC ChoiceBoxListCell
 * @define XOBTC ChoiceBoxTableCell
 * @define XOBRC ChoiceBoxTreeCell
 * @define CMBLC ComboBoxListCell
 * @define CMBTC ComboBoxTableCell
 * @define CMBRC ComboBoxTreeCell
 * @define PRBTC ProgressBarTableCell
 * @define TXFLC TextFieldListCell
 * @define TXFTC TextFieldTableCell
 * @define TXFRC TextFieldTreeCell
 * @define TTYPE The type of the elements contained within the Element
 * @define STYPE The type of the elements contained  ...
 */
trait CellIncludes {

  /**
   * $START$CHBLC.html $CHBLC$END
   *
   * @tparam T $TTYPE
   * @param cell $JFX $CHBLC
   * @return $SFX $CHBLC
   */
  implicit def jfxCheckBoxListCell2sfx[T](cell: jfxscc.CheckBoxListCell[T]) = new CheckBoxListCell[T](cell)

  /**
   * $START$CHBTC.html $CHBTC$END
   *
   * @tparam S $STYPE
   * @tparam T $TTYPE
   * @param cell $JFX $CHBTC
   * @return $SFX $CHBTC
   */
  implicit def jfxCheckBoxTableCell2sfx[S, T](cell: jfxscc.CheckBoxTableCell[S, T]) = new CheckBoxTableCell[S, T](cell)

  /**
   * $START$CHBRC.html $CHBRC$END
   *
   * @tparam T $TTYPE
   * @param cell $JFX $CHBRC
   * @return $SFX $CHBRC
   */
  implicit def jfxCheckBoxTreeCell2sfx[T](cell: jfxscc.CheckBoxTreeCell[T]) = new CheckBoxTreeCell[T](cell)

  /**
   * $START$XOBLC.html $XOBLC$END
   *
   * @tparam T $TTYPE
   * @param cell $JFX $XOBLC
   * @return $SFX $XOBLC
   */
  implicit def jfxChoiceBoxListCell2sfx[T](cell: jfxscc.ChoiceBoxListCell[T]) = new ChoiceBoxListCell[T](cell)

  /**
   * $START$XOBTC.html $XOBTC$END
   *
   * @tparam S $STYPE
   * @tparam T $TTYPE
   * @param cell $JFX $XOBTC
   * @return $SFX $XOBTC
   */
  implicit def jfxChoiceBoxTableCell2sfx[S, T](cell: jfxscc.ChoiceBoxTableCell[S, T]) = new ChoiceBoxTableCell[S, T](cell)

  /**
   * $START$XOBRC.html $XOBRC$END
   *
   * @tparam T $TTYPE
   * @param cell $JFX $XOBRC
   * @return $SFX $XOBRC
   */
  implicit def jfxChoiceBoxTreeCell2sfx[T](cell: jfxscc.ChoiceBoxTreeCell[T]) = new ChoiceBoxTreeCell[T](cell)

  /**
   * $START$CMBLC.html $CMBLC$END
   *
   * @tparam T $TTYPE
   * @param cell $JFX $CMBLC
   * @return $SFX $CMBLC
   */
  implicit def jfxComboBoxListCell2sfx[T](cell: jfxscc.ComboBoxListCell[T]) = new ComboBoxListCell[T](cell)

  /**
   * $START$CMBTC.html $CMBTC$END
   *
   * @tparam S $STYPE
   * @tparam T $TTYPE
   * @param cell $JFX $CMBTC
   * @return $SFX $CMBTC
   */
  implicit def jfxComboBoxTableCell2sfx[S, T](cell: jfxscc.ComboBoxTableCell[S, T]) = new ComboBoxTableCell[S, T](cell)

  /**
   * $START$CMBRC.html $CMBRC$END
   *
   * @tparam T $TTYPE
   * @param cell $JFX $CMBRC
   * @return $SFX $CMBRC
   */
  implicit def jfxComboBoxTreeCell2sfx[T](cell: jfxscc.ComboBoxTreeCell[T]) = new ComboBoxTreeCell[T](cell)

  /**
   * $START$PRBTC.html $PRBTC$END
   *
   * @tparam S $STYPE
   * @param cell $JFX $PRBTC
   * @return $SFX $PRBTC
   */
  implicit def jfxProgressBarTableCell2sfx[S](cell: jfxscc.ProgressBarTableCell[S]) = new ProgressBarTableCell[S](cell)

  /**
   * $START$TXFLC.html $TXFLC$END
   *
   * @tparam T $TTYPE
   * @param cell $JFX $TXFLC
   * @return $SFX $TXFLC
   */
  implicit def jfxTextFieldListCell2sfx[T](cell: jfxscc.TextFieldListCell[T]) = new TextFieldListCell[T](cell)

  /**
   * $START$TXFTC.html $TXFTC$END
   *
   * @tparam S $STYPE
   * @tparam T $TTYPE
   * @param cell $JFX $TXFTC
   * @return $SFX $TXFTC
   */
  implicit def jfxTextFieldTableCell2sfx[S, T](cell: jfxscc.TextFieldTableCell[S, T]) = new TextFieldTableCell[S, T](cell)

  /**
   * $START$TXFRC.html $TXFRC$END
   *
   * @tparam T $TTYPE
   * @param cell $JFX $TXFRC
   * @return $SFX $TXFRC
   */
  implicit def jfxTextFieldTreeCell2sfx[T](cell: jfxscc.TextFieldTreeCell[T]) = new TextFieldTreeCell[T](cell)

}