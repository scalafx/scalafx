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

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.event.ActionEvent
import scalafx.geometry.Pos
import scalafx.scene.Scene
import scalafx.scene.control.{Label, Button}
import scalafx.scene.effect.DropShadow
import scalafx.scene.image.{ImageView, Image}
import scalafx.scene.input.MouseEvent
import scalafx.scene.layout.{HBox, VBox}
import scalafx.scene.paint.Color
import scalafx.scene.text.Font


/**
 * @author Luc Duponcheel <luc.duponcheel@gmail.com>
 *
 * based upon:
 *
 * http://docs.oracle.com/javafx/2.0/ui_controls/button.htm
 *
 */

object ScalaFX_Controls_02 extends JFXApp {
  val label = new Label {
    font = Font.font("Times New Roman", 22)
    textFill = Color.web("#464646")
  }

  val okImageView = new ImageView {
    image = new Image(this, "images/ok.png")
  }

  val koImageView = new ImageView {
    image = new Image(this, "images/ko.png")
  }

  val okButton1 = new Button {
    graphic = okImageView
    text = "Accept"
    style = "-fx-font: 22 arial; -fx-base: #b6e7c9;"
    onAction = {
      (_: ActionEvent) =>
        label.text = "Accepted"
    }
  }

  val okButton2 = new Button {
    text = "Accept"
    onAction = {
      (_: ActionEvent) =>
        label.text = "Accepted"
    }
  }

  val koButton1 = new Button {
    text = "Decline"
    onAction = {
      (_: ActionEvent) =>
        label.text = "Declined"
    }
  }

  koButton1 addOnMouseEnteredHandler {
    (_: MouseEvent) =>
      koButton1.effect = new DropShadow()
  }

  koButton1 addOnMouseExitedHandler {
    (_: MouseEvent) =>
      koButton1.effect = null
  }

  val hBox1 = new HBox {
    spacing = 10
    alignment = Pos.BOTTOM_CENTER
    content = List(
      okButton2,
      koButton1,
      label
    )
  }

  val okButton3 = new Button {
    graphic = okImageView
    onAction = {
      (_: ActionEvent) =>
        label.text = "Accepted"
    }
  }


  val koButton2 = new Button {
    graphic = koImageView
    onAction = {
      (_: ActionEvent) =>
        label.text = "Declined"
    }
  }

  val hBox2 = new HBox {
    spacing = 25
    content = List(
      okButton3,
      koButton2
    )
  }

  val vBox = new VBox {
    layoutX = 20
    layoutY = 20
    spacing = 10
    content = List(
      okButton1,
      hBox1,
      hBox2
    )
  }
  stage = new PrimaryStage {
    title = "ScalaFX Controls 02"
    width = 300
    height = 190
    scene = new Scene {
      content = vBox
    }
  }
}

