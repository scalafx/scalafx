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
package scalafx.controls

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.event.ActionEvent
import scalafx.scene.Scene
import scalafx.scene.control.{Label, MenuItem, Menu, MenuBar}
import scalafx.scene.layout.{BorderPane, VBox}
import scalafx.scene.paint.Color


object MenuTest extends JFXApp {

  val menu = new Menu("File") {
    items = List(
      new MenuItem("Open") {
        onAction = (ae: ActionEvent) => history.content += new Label("Selected item `Open`")
      },
      new MenuItem("Close") {
        onAction = (ae: ActionEvent) => history.content += new Label("Selected item `Close`")
      }
    )

    onShowing = printEvent("on showing")
    onShown = printEvent("on shown")
    onHiding = printEvent("on hiding")
    onHidden = printEvent("on hidden")
  }

  val history = new VBox()

  val menuBar = new MenuBar {
    useSystemMenuBar = true
    minWidth = 100
    menus.add(menu)
  }

  stage = new PrimaryStage {
    title = "Menu test"
    width = 300
    height = 225
    scene = new Scene {
      fill = Color.LIGHTGRAY
      root = new BorderPane {
        top = menuBar
        bottom = history
      }
    }
  }

  def printEvent(eventStr: String)() {
    history.content += new Label(eventStr)
  }
}
