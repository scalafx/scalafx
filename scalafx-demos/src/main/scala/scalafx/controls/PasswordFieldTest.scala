/*
 * Copyright (c) 2011-2021, ScalaFX Project
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

import scalafx.application.JFXApp3
import scalafx.application.JFXApp3.PrimaryStage
import scalafx.controls.controls.{ControlControls, PropertiesNodes, TextFieldControls, TextInputControlControls}
import scalafx.geometry.Pos
import scalafx.scene.Scene
import scalafx.scene.control.{Button, Label, PasswordField}
import scalafx.scene.layout.{BorderPane, FlowPane, Priority, VBox}
import scalafx.scene.paint.Color

object PasswordFieldTest extends JFXApp3 {
  override def start(): Unit = {
    val passwordField = new PasswordField
    val controlsPane: VBox = new VBox {
      spacing = 5
      fillWidth = true
      alignment = Pos.Center
      hgrow = Priority.Never
      children = Seq(
        new PasswordFieldControls(passwordField),
        new TextFieldControls(passwordField),
        new TextInputControlControls(passwordField),
        new ControlControls(passwordField)
      )
    }
    val mainPane: BorderPane = new BorderPane {
      top = new FlowPane { children = List(passwordField) }
      center = controlsPane
      vgrow = Priority.Always
      hgrow = Priority.Always
    }
    stage = new PrimaryStage {
      title = "passwordField Test"
      width = 520
      height = 700
      scene = new Scene {
        fill = Color.LightGray
        content = mainPane
      }
    }
  }
}

class PasswordFieldControls(target: PasswordField)
    extends PropertiesNodes[PasswordField](target, "PasswordField Properties") {

  val lblText: Label = new Label {
    text <== target.text
  }

  /**
   * It is not really working. Probably because when the button is clicked, password field lose its focus. To make Copy
   * and cut work a possibility could be use a keyboard shortcut. And they must be different Ctrl + C and Ctrl + X to
   * not confuse with traditional shortcuts.
   */
  val btnCopy: Button = new Button {
    text = "Copy"
    onAction = _ => target.copy()
  }

  val btnCut: Button = new Button {
    text = "Cut"
    onAction = _ => target.cut()
  }

  super.addNode("Typed Text", lblText)
  super.addNodes(btnCopy, btnCut)

}
