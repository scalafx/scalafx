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
import scalafx.application.{JFXApp, Platform}
import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.control.ButtonBar.ButtonData
import scalafx.scene.control._
import scalafx.scene.image.{Image, ImageView}
import scalafx.scene.layout.{GridPane, VBox}

object LoginDialogDemo extends JFXApp {

  stage = new JFXApp.PrimaryStage {
    icons += new Image("/scalafx/sfx.png")
    scene = new Scene {
      title = "Custom Dialog Demo"
      content = new VBox {
        children = new Button("Show Login Dialog") {
          onAction = handle {onShowLoginDialog()}
        }
        padding = Insets(top = 24, right = 64, bottom = 24, left = 64)
      }
    }
  }

  def onShowLoginDialog(): Unit = {
    // Create the custom dialog.
    val dialog = new Dialog[(String, String)]() {
      title = "Login Dialog"
      headerText = "Look, a Custom Login Dialog"
      graphic = new ImageView(this.getClass.getResource("login_icon.png").toString)
    }
    dialog.initOwner(stage)

    // Set the button types.
    val loginButtonType = new ButtonType("Login", ButtonData.OKDone)
    dialog.dialogPane().buttonTypes = Seq(loginButtonType, ButtonType.Cancel)

    // Create the username and password labels and fields.
    val username = new TextField() {
      promptText = "Username"
    }
    val password = new PasswordField() {
      promptText = "Password"
    }

    val grid = new GridPane() {
      hgap = 10
      vgap = 10
      padding = Insets(20, 100, 10, 10)

      add(new Label("Username:"), 0, 0)
      add(username, 1, 0)
      add(new Label("Password:"), 0, 1)
      add(password, 1, 1)
    }

    // Enable/Disable login button depending on whether a username was entered.
    val loginButton = dialog.dialogPane().lookupButton(loginButtonType)
    loginButton.disable = true

    // Do some validation (using the Java 8 lambda syntax).
    username.text.onChange { (_, _, newValue) => loginButton.disable = newValue.trim().isEmpty}

    // NOTE: Due to clash between ScalaFX Pane.content and JavaFX DialogPane.contentProperty
    // The DialogPane.content needs to accessed using `contentNode`
    dialog.dialogPane().contentNode = grid

    // Request focus on the username field by default.
    Platform.runLater(username.requestFocus())

    // Convert the result to a username-password-pair when the login button is clicked.
    dialog.resultConverter = dialogButton =>
      if (dialogButton == loginButtonType) (username.text(), password.text())
      else null

    val result = dialog.showAndWait()

    result match {
      case Some((u, p)) => println("Username=" + u + ", Password=" + p)
      case None => println("Dialog returned: None")
    }
  }

}
