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

package scalafx.controls

import javafx.event.ActionEvent
import javafx.event.EventHandler
import scalafx.scene.layout.Priority
import scalafx.Includes.eventClosureWrapper
import scalafx.Includes.jfxBooleanProperty2sfx
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.controls.controls.ControlControls
import scalafx.controls.controls.PropertiesNodes
import scalafx.geometry.Pos
import scalafx.scene.Scene
import scalafx.scene.control.Button
import scalafx.scene.control.CheckBox
import scalafx.scene.control.Label
import scalafx.scene.control.TextField
import scalafx.scene.control.ToggleButton
import scalafx.scene.layout.BorderPane
import scalafx.scene.layout.VBox
import scalafx.scene.paint.Color
import scalafx.scene.paint.Color.sfxColor2jfx

object CheckBoxTest extends JFXApp {

  val check = new CheckBox {
    text = "CheckBox"
  }

  val controlsPane = new VBox {
    spacing = 5
    fillWidth = true
    alignment = Pos.CENTER
    hgrow = Priority.NEVER
    content = List(new CheckBoxControls(check), new ControlControls(check))
  }

  val mainPane = new BorderPane {
    top = check
    center = controlsPane
    vgrow = Priority.ALWAYS
    hgrow = Priority.ALWAYS
  }

  stage = new PrimaryStage {
    title = "CheckBox Test"
    width = 300
    height = 500
    scene = new Scene {
      fill = Color.LIGHTGRAY
      content = mainPane
    }
  }

}

class CheckBoxControls(check: CheckBox) extends PropertiesNodes[CheckBox](check, "CheckBox Properties") {

  val lblSelected = new Label {
    text = check.selected.get().toString()
  }
  check.onAction = new EventHandler[ActionEvent] {
    def handle(event: ActionEvent) {
      lblSelected.text = if (check.indeterminate.get) "Indeterminate" else check.selected.get().toString()
    }
  }

  val btnAllowIndeterminate = new ToggleButton {
    text = "Allow Indeterminate"
    selected <==> check.allowIndeterminate
  }

  val btnFire = new Button {
    text = "Fire!"
    onAction = check.fire
  }

  val txfText = new TextField {
    text <==> check.text
  }

  super.addNode("Selected", lblSelected)
  super.addNodes(btnAllowIndeterminate, btnFire)
  super.addNode("Text", txfText)

}