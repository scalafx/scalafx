/*
 * Copyright (c) 2011-2019, ScalaFX Project
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

import javafx.scene.{control => jfxsc, text => jfxst}
import scalafx.Includes._
import scalafx.beans.property.{
  BooleanProperty,
  ReadOnlyIntegerProperty,
  ReadOnlyObjectProperty,
  ReadOnlyStringProperty,
  StringProperty,
  _
}
import scalafx.delegate.SFXDelegate

import scala.language.implicitConversions

object TextInputControl {
  implicit def sfxTextInputControl2jfx(v: TextInputControl): jfxsc.TextInputControl =
    if (v != null) v.delegate else null
}

abstract class TextInputControl(override val delegate: jfxsc.TextInputControl)
    extends Control(delegate)
    with SFXDelegate[jfxsc.TextInputControl] {

  /**
   * The anchor of the text selection.
   */
  def anchor: ReadOnlyIntegerProperty = delegate.anchorProperty

  /**
   * The current position of the caret within the text.
   */
  def caretPosition: ReadOnlyIntegerProperty = delegate.caretPositionProperty

  /**
   * Indicates whether this TextInputControl can be edited by the user.
   */
  def editable: BooleanProperty = delegate.editableProperty

  def editable_=(v: Boolean): Unit = {
    editable() = v
  }

  /**
   * The default font to use for text in the TextInputControl.
   */
  def font: ObjectProperty[jfxst.Font] = delegate.fontProperty()

  def font_=(v: jfxst.Font): Unit = {
    ObjectProperty.fillProperty[jfxst.Font](font, v)
  }

  /**
   * The number of characters in the text input.
   */
  def length: ReadOnlyIntegerProperty = delegate.lengthProperty

  /**
   * Defines the characters in the TextInputControl which are selected
   */
  def selectedText: ReadOnlyStringProperty = delegate.selectedTextProperty

  /**
   * The current selection.
   */
  def selection: ReadOnlyObjectProperty[jfxsc.IndexRange] = delegate.selectionProperty

  /**
   * The property describes if it's currently possible to undo the latest change of the content that was done.
   */
  def undoable: ReadOnlyBooleanProperty = delegate.undoableProperty()

  /**
   * The property describes if it's currently possible to redo the latest change of the content that was undone.
   */
  def redoable: ReadOnlyBooleanProperty = delegate.redoableProperty()

  /**
   * The textual content of this TextInputControl.
   */
  def text: StringProperty = delegate.textProperty

  def text_=(v: String): Unit = {
    text() = v
  }

  /**
   * The prompt text to display in the TextInputControl, or null if no prompt text is displayed.
   * @since
   *   2.2
   */
  def promptText: StringProperty = delegate.promptTextProperty()

  def promptText_=(v: String): Unit = {
    promptText() = v
  }

  /**
   * The property contains currently attached `TextFormatter`. Since the value is part of the `Formatter`, changing the
   * TextFormatter will update the text based on the new textFormatter.
   */
  def textFormatter: ObjectProperty[jfxsc.TextFormatter[_]] = delegate.textFormatterProperty()
  def textFormatter_=(v: TextFormatter[_]): Unit = {
    ObjectProperty.fillProperty(textFormatter, v)
  }
}
