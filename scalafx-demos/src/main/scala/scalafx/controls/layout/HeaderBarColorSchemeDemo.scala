/*
 * Copyright (c) 2011-2026, ScalaFX Project
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

package scalafx.controls.layout

import scalafx.Includes.*
import scalafx.application.JFXApp3.PrimaryStage
import scalafx.application.{ColorScheme, JFXApp3}
import scalafx.geometry.{Insets, Pos}
import scalafx.scene.Scene
import scalafx.scene.control.{Button, Label, RadioButton, ToggleGroup}
import scalafx.scene.layout.{BorderPane, HBox, HeaderBar, VBox}
import scalafx.stage.StageStyle

/**
 * Demonstrates `HeaderBar.systemColorScheme`, added in JavaFX 27.
 *
 * By default, the color scheme of the system-provided header buttons (iconify, maximize, close)
 * follows the scene color scheme. The `systemColorScheme` attached property can override it,
 * for instance, to show dark header buttons on a light window content, or the other way around.
 *
 * Use the "Window content" choices to change the scene color scheme,
 * and "Header buttons" choices to override the color scheme of the header buttons.
 * The label at the bottom shows the effective value of `HeaderBar.systemColorScheme`.
 *
 * The header bar also contains application-provided buttons. The header bar is styled to match
 * the effective `systemColorScheme`, so that application buttons and system-provided header buttons
 * change together, independently of the window content.
 */
object HeaderBarColorSchemeDemo extends JFXApp3 {

  private val LightStyle = "-fx-background: #f4f4f4; -fx-background-color: #f4f4f4; -fx-text-fill: #202020;"
  private val DarkStyle  = "-fx-background: #2b2b2b; -fx-background-color: #2b2b2b; -fx-text-fill: #e0e0e0;"

  private val LightHeaderStyle = "-fx-base: #e4e4e4; -fx-background: #ffffff; -fx-background-color: #ffffff;"
  private val DarkHeaderStyle  = "-fx-base: #3c3f41; -fx-background: #1e1e1e; -fx-background-color: #1e1e1e;"

  override def start(): Unit = {

    val headerButtonsBox = new HBox {
      spacing = 6
      alignment = Pos.CenterLeft
      children = Seq("New", "Open", "Help").map { name =>
        new Button(name) {
          onAction = _ => println(s"Header button '$name' clicked")
        }
      }
    }
    HeaderBar.setAlignment(headerButtonsBox, Pos.CenterLeft)
    HeaderBar.setMargin(headerButtonsBox, Insets(4, 8, 4, 8))

    val headerBar = new HeaderBar {
      left = headerButtonsBox
      center = new Label("HeaderBar systemColorScheme Demo")
    }

    val contentPane = new BorderPane {
      top = headerBar
      style = LightStyle
    }

    val contentScene = new Scene(560, 340) {
      root = contentPane
    }

    stage = new PrimaryStage {
      initStyle(StageStyle.Extended)
      title = "HeaderBar systemColorScheme Demo"
      scene = contentScene
    }

    // Window content color scheme, sets the scene color scheme preference
    def setContentColorScheme(colorScheme: ColorScheme): Unit = {
      contentScene.preferences.colorScheme = colorScheme
      contentPane.style = if (colorScheme == ColorScheme.Dark) DarkStyle else LightStyle
    }

    val contentGroup   = new ToggleGroup()
    val contentChoices = Seq(
      ("Light", ColorScheme.Light),
      ("Dark", ColorScheme.Dark)
    ).map { case (text, colorScheme) =>
      new RadioButton(text) {
        toggleGroup = contentGroup
        onAction = _ => setContentColorScheme(colorScheme)
      }
    }
    contentChoices.head.selected = true
    setContentColorScheme(ColorScheme.Light)

    // Header buttons color scheme, `null` means: follow the scene color scheme
    val buttonsGroup   = new ToggleGroup()
    val buttonsChoices = Seq(
      ("Follow window content (null)", null),
      ("Light", ColorScheme.Light),
      ("Dark", ColorScheme.Dark)
    ).map { case (text, colorScheme) =>
      new RadioButton(text) {
        toggleGroup = buttonsGroup
        onAction = _ => HeaderBar.setSystemColorScheme(stage, colorScheme)
      }
    }
    buttonsChoices.head.selected = true

    // Style the header bar to match the effective color scheme of the system-provided header buttons
    def updateHeaderStyle(colorScheme: ColorScheme): Unit =
      headerBar.style = if (colorScheme == ColorScheme.Dark) DarkHeaderStyle else LightHeaderStyle
    HeaderBar.systemColorScheme(stage).onChange { (_, _, colorScheme) => updateHeaderStyle(colorScheme) }
    updateHeaderStyle(HeaderBar.systemColorScheme(stage).value)

    val effectiveLabel = new Label {
      text <== HeaderBar.systemColorScheme(stage).asString("Effective header buttons color scheme: %s")
    }

    contentPane.center = new VBox {
      spacing = 8
      padding = Insets(10, 20, 10, 20)
      alignment = Pos.CenterLeft
      children =
        Seq(new Label("Window content (scene color scheme):")) ++
          contentChoices ++
          Seq(new Label("Header buttons (HeaderBar.systemColorScheme):") {
            padding = Insets(12, 0, 0, 0)
          }) ++
          buttonsChoices ++
          Seq(effectiveLabel)
    }
  }
}
