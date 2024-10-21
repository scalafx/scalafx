/*
 * Copyright (c) 2011-2024, ScalaFX Project
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

import scala.language.implicitConversions
import scalafx.Includes._
import scalafx.delegate.SFXDelegate

object TextInputDialog {

  /**
   * Converts a ScalaFX TextInputDialog to its JavaFX counterpart.
   *
   * @param v ScalaFX TextInputDialog
   * @return JavaFX TextInputDialog
   */
  implicit def sfxTextInputDialog2jfx(v: TextInputDialog): jfxsc.TextInputDialog =
    if (v != null) v.delegate else null
}

/**
 * A dialog that shows a text input control to the user.
 *
 * Wraps a $JFX $URL0 $TC]].
 *
 * @constructor Creates a new TextInputDialog without a default value entered into the dialog.
 *
 * @define TC TextInputDialog
 * @define URL0 [[https://docs.oracle.com/javase/8/javafx/api/javafx/scalafx.scene/TextInputDialog.html
 * @define JFX JavaFX
 * @define ORIGINALDOC Original Documentation]].
 */
class TextInputDialog(override val delegate: jfxsc.TextInputDialog = new jfxsc.TextInputDialog())
    extends Dialog[String](delegate)
    with SFXDelegate[jfxsc.TextInputDialog] {

  /**
   * Creates a new TextInputDialog with the default value entered into the
   * dialog `TextField`.
   */
  def this(defaultValue: String) = this(new jfxsc.TextInputDialog(defaultValue))

  /**
   * Shows the dialog and waits for the user response (in other words, brings
   * up a blocking dialog, with the returned value the users input).
   *
   * {{{
   *   dialog.showAndWait()
   * }}}
   * Or when return value is required:
   * {{{
   *   val r = dialog.showAndWait()
   *   r match {
   *     case Some(v) => ...
   *     case None    => ...
   *   }
   * }}}
   *
   * @return An `Option` that contains the `result`.
   */
  def showAndWait(): Option[String] = {
    super.showAndWait((x: String) => x).asInstanceOf[Option[String]]
  }

  /**
   * The `TextField` used within this dialog.
   */
  def editor: TextField = delegate.getEditor

  /**
   * The default value that was specified in the constructor.
   */
  def defaultValue: String = delegate.getDefaultValue
}
