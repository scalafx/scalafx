/*
 * Copyright (c) 2011-2015, ScalaFX Project
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

package scalafx.controls

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.event.ActionEvent
import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.control.TextFormatter.Change
import scalafx.scene.control.{Label, TextArea, TextField, TextFormatter}
import scalafx.scene.layout.{BorderPane, VBox}
import scalafx.util.StringConverter

/**
  * Demonstrates a TextField control with a TextFormatter that filters changes.
  *
  * The text field at a top is an input area. It should have a prompt-like text "> " that cannot be edited.
  * When pressing "Enter" the text after the prompt is copied to bottom output area.
  *
  * The changes in the input text field are monitored and filtered using TextFormatter parameter `filter`.
  * The examines the change and modifies it as needed to preserve the prompt text "> " at the beginning.
  */
object TextFormatterWithChangeFilterDemo extends JFXApp {

  case class Message(text: String) {
    override def toString = '"' + text + '"'
  }

  val prompt = "> "

  val converter = new StringConverter[Message] {
    override def fromString(s: String): Message = {
      val r =
        if (s.startsWith(prompt)) s.substring(prompt.length)
        else s
      Message(r)
    }
    override def toString(v: Message): String = {
      prompt + v.text
    }
  }

  // Filter the change restoring prompt if it was removed and correcting caret position
  val filter: (Change) => Change = { change: Change =>
    // Restore prompt if part was deleted
    if (change.controlNewText.length <= prompt.length) {
      change.text = prompt.substring(change.controlNewText.length)
    }
    // Restore caret position if it moved over the prompt
    if (change.anchor < prompt.length) change.anchor = prompt.length
    if (change.caretPosition < prompt.length) change.caretPosition = prompt.length
    change
  }
  val formatter = new TextFormatter[Message](converter, Message("hello"), filter)

  val outputTextArea = new TextArea {
    editable = false
    focusTraversable = false
  }

  val textField = new TextField {
    text = prompt
    textFormatter = formatter
    onAction = (a: ActionEvent) => {
      val str = text()
      val message = converter.fromString(str) + "\n"
      outputTextArea.text = message + outputTextArea.text()
      text() = ""
    }
  }

  stage = new PrimaryStage {
    scene = new Scene(300, 300) {
      title = "TextFormatter Demo"
      root = new VBox {
        spacing = 6
        padding = Insets(10)
        children = Seq(
          new Label("Example of using `TextFormatter` to ensure that the input field includes prompt text \"> \".") {
            wrapText = true
          },
          new Label("Type message at the prompt. Press \"Enter\" to send."),
          new BorderPane {
            top = textField
            center = outputTextArea
          }
        )
      }
    }
  }
}
