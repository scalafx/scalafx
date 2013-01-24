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


import scalafx.scene.Scene
import scalafx.stage.Stage
import scalafx.scene.image.{ImageView, Image}
import scalafx.application.JFXApp
import scalafx.scene.layout.{HBox, VBox}
import scalafx.geometry.Insets
import scalafx.scene.control.{RadioButton, ToggleGroup}
import scalafx.beans.property.PropertyIncludes.jfxReadOnlyObjectProperty2sfx

/**
 * @author Luc Duponcheel <luc.duponcheel@gmail.com>
 *
 * based upon:
 *
 * http://docs.oracle.com/javafx/2.0/ui_controls/radio-button.htm
 *
 */

object ScalaFX_Controls_03 extends JFXApp {

  val theToggleGroup = new ToggleGroup {

  }

  theToggleGroup.selectedToggle onChange {
    (_, _, _) =>
      val selectedToggle = theToggleGroup.getSelectedToggle()
      if (selectedToggle != null) {
        val userDataString = selectedToggle.getUserData.toString()
        iconImageView.image = new Image(this, "images/" + userDataString + ".jpg")
      }
  }

  val homeRadioButton = new RadioButton {
    toggleGroup = theToggleGroup
    userData = "Home"
  }


  val calendarRadioButton = new RadioButton {
    toggleGroup = theToggleGroup
    userData = "Calendar"
  }


  val contactsRadioButton = new RadioButton {
    toggleGroup = theToggleGroup
    userData = "Contacts"
  }

  val vBox = new VBox {
    spacing = 10
    content = List(
      homeRadioButton,
      calendarRadioButton,
      contactsRadioButton
    )
  }

  val iconImageView = new ImageView {
  }

  val hBox = new HBox {
    spacing = 50
    padding = Insets(20, 10, 10, 20)
    content = List(
      vBox,
      iconImageView
    )
  }

  stage = new Stage(JFXApp.STAGE) {
    title = "ScalaFX Controls 03"
    width = 250
    height = 150
    scene = new Scene {
      content = hBox
    }
  }
}


