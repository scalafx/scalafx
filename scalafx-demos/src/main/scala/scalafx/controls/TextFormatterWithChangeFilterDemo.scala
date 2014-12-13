/*
 * Copyright (c) 2011-2014, ScalaFX Project
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

import javafx.util.StringConverter

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.event.ActionEvent
import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.control.TextFormatter.Change
import scalafx.scene.control.{Label, TextArea, TextField, TextFormatter}
import scalafx.scene.layout.{BorderPane, VBox}

/**
 * Demonstrates a TextField control with a TextFormatter that filters changes.
 *
 * The text field at a top is an input area. It should have a prompt-like text "> " that cannot be edited.
 * When pressing "Enter" the text after the prompt is copied to bottom output area.
 *
 * The changes in the input text field are monitored and filtered using TextFormatter parameter `filter`
 * to preserve the prompt text "> " at the beginning.
 */
object TextFormatterWithChangeFilterDemo extends JFXApp {

  case class Message(text: String)

  val prompt = "> "

  val converter = new StringConverter[Message] {
    override def fromString(s: String): Message = {
      println("fromString(" + s + ")")
      if (s.startsWith("> "))
        Message(s.substring(2))
      else if (s.startsWith(">"))
        Message(s.substring(1))
      else
        Message(s)
    }
    override def toString(v: Message): String = {
      println("toString(" + v + ")")
      "> " + v.text
    }
  }

  val filter: (Change) => Change = { c: Change =>
    // Restore prompt if part was deleted
    if (c.controlNewText.length <= prompt.length) {
      c.text = prompt.substring(c.controlNewText.length)
      println("c.text: `" + c.text + "`")
    }
    // Restore caret position if it moved over the prompt
    if (c.anchor < prompt.length) c.anchor = prompt.length
    if (c.caretPosition < prompt.length) c.caretPosition = prompt.length
    c
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
      val message =
        if (outputTextArea.text().length == 0)
          converter.fromString(str)
        else
          converter.fromString(str) + "\n"
      outputTextArea.text = message + outputTextArea.text()
      text() = ""
    }
  }

  stage = new PrimaryStage {
    scene = new Scene(300, 200) {
      title = "TextFormatter Demo"
      root = new VBox {
        spacing = 6
        padding = Insets(10)
        content = Seq(
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