package scalafx.imaginej

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

//             ________                                __                   ________   __    __
//           /   _____/\                             /  /\                /   _____/\/__/\ /  /\
//          /  /\_____\/  ________     _______      /  / /   ________    /  /\_____\/\  \ /  / /
//         /  /_/___    /   _____/\  /_____   /\   /  / /  /_____   /\  /  /_/__      \  /  / /
//        /______  /\  /  /\_____\/  \____/  / /  /  / /   \____/  / / /   ____/\      \/  / /
//        \_____/ / / /  / /       /  ___   / /  /  / /  /  ___   / / /  /\____\/      /  / /\
//       ______/ / / /  /_/___    /  /__/  / /  /  / /  /  /__/  / / /  / /           /  / /\ \
//     /________/ / /________/\  /________/ /  /__/ /  /________/ / /__/ /           /__/ /  \ \
//     \________\/  \________\/  \________\/   \__\/   \________\/  \__\/            \__\/ \__\/
//
//                                  ScalaFX Programming Library Examples
//

import javafx.geometry.Pos
import javafx.scene.control.Tooltip

import scalafx.scene.Scene
import scalafx.stage.Stage
import scalafx.application.JFXApp
import scalafx.scene.layout.{HBox}
import scalafx.geometry.Insets
import scalafx.beans.property.PropertyIncludes.jfxReadOnlyObjectProperty2sfx
import scalafx.beans.property.PropertyIncludes.jfxReadOnlyIntegerProperty2sfx
import scalafx.scene.control.{ChoiceBox, Label}
import scalafx.collections.ObservableBuffer
import scalafx.beans.value.ObservableValue
import ObservableBuffer.observableBuffer2ObservableList

/**
 * @author Luc Duponcheel <luc.duponcheel@gmail.com>
 *
 * based upon:
 *
 * http://docs.oracle.com/javafx/2.0/ui_controls/choice-box.htm
 *
 */

object ScalaFX_Controls_06 extends JFXApp {

  val languages: ObservableBuffer[String] = new ObservableBuffer[String]()

  languages.setAll(
    "English",
    "Español",
    "Русский",
    "简体中文",
    "日本語"
  )

  val languageChoiceBox = new ChoiceBox {
    items = languages.asInstanceOf[ObservableBuffer[Nothing]]
    tooltip = new Tooltip("Select the language")
  }

  val helloLabel = new Label {
    text = "Hello"
    style = "-fx-font: 25 arial;"
    layoutX = 40
  }

  val hBox = new HBox {
    spacing = 30
    innerAlignment = Pos.CENTER
    padding = Insets(10, 0, 0, 10)
    content = List(
      languageChoiceBox,
      helloLabel
    )
  }

  val greetings = Array[String](
    "Hello",
    "Hola",
    "Привет",
    "餵",
    "こんにちは"
  )

  languageChoiceBox.selectionModel().selectedIndexProperty onChange {
    (_: ObservableValue[Int, Number], _: Number, newIndex: Number) =>
      helloLabel.text = greetings(newIndex.intValue())
  }

  stage = new Stage {
    title = "ScalaFX Controls 06"
    width = 300
    height = 100
    scene = new Scene {
      content = hBox
    }
  }

}
