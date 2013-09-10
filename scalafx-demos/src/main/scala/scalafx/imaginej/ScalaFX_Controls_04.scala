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
package scalafx.imaginej

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


import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.beans.property.PropertyIncludes.jfxReadOnlyObjectProperty2sfx
import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.control.{ToggleButton, Label, ToggleGroup}
import scalafx.scene.layout.{HBox, VBox}
import scalafx.scene.paint.Color
import scalafx.scene.shape.Rectangle

/**
 * @author Luc Duponcheel <luc.duponcheel@gmail.com>
 *
 * based upon:
 *
 * http://docs.oracle.com/javafx/2.0/ui_controls/toggle-button.htm
 *
 */

object ScalaFX_Controls_04 extends JFXApp {

  val priorityLabel = new Label {
    text = "Priority:"
  }

  val theToggleGroup = new ToggleGroup {

  }

  val minorToggleButton = new ToggleButton {
    text = "Minor"
    toggleGroup = theToggleGroup
    userData = Color.LIGHTGREEN
    selected = true
    style = "-fx-base: lightgreen;"
  }

  val majorToggleButton = new ToggleButton {
    text = "Major"
    toggleGroup = theToggleGroup
    userData = Color.LIGHTBLUE
    selected = true
    style = "-fx-base: lightblue;"
  }

  val criticalToggleButton = new ToggleButton {
    text = "Critical"
    toggleGroup = theToggleGroup
    userData = Color.SALMON
    selected = true
    style = "-fx-base: salmon;"
  }

  val hBox = new HBox {
    content = List(
      minorToggleButton,
      majorToggleButton,
      criticalToggleButton
    )
  }

  val rectangle = new Rectangle {
    width = 158
    height = 50
    fill = Color.WHITE
    stroke = Color.DARKGRAY
    strokeWidth = 2
    arcHeight = 10
    arcWidth = 10
  }

  val vBox = new VBox {
    padding = Insets(20, 10, 10, 20)
    content = List(
      priorityLabel,
      hBox,
      rectangle
    )
  }

  theToggleGroup.selectedToggle onChange {
    (_, _, newToggle) =>
      if (newToggle != null) {
        val selectedToggle = theToggleGroup.getSelectedToggle
        val userDataColor = selectedToggle.getUserData.asInstanceOf[Color]
        rectangle.fill = userDataColor
      } else {
        rectangle.fill = Color.WHITE
      }
  }

  stage = new PrimaryStage {
    title = "ScalaFX Controls 04"
    width = 250
    height = 180
    scene = new Scene {
      content = vBox
    }
  }
}



