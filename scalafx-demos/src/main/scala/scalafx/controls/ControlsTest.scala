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

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.control._
import scalafx.scene.layout._

object ControlsTest extends JFXApp {

  val indicatorPane = new VBox {
    content = List(new Label {
      text = "LEFT"

    })
  }

  val controlsPane = new VBox {
    content = List(new Label {
      text = "RIGHT"
    })
  }

  val centerPane = new BorderPane {
    top = new Label {
      text = "Label"
    }
    center = new StackPane {
      content = List(new Button {
        text = "Button"
      })
    }
  }
  
  val mainContent = new BorderPane {
        left = indicatorPane
        center = centerPane
        right = controlsPane
      }

  stage = new PrimaryStage {
    title = "CheckBox Test"
    width = 800
    height = 600
    scene = new Scene {
//      fill = Color.LIGHTGRAY
      content = mainContent
    }
  }
  mainContent.prefHeight <== stage.scene.height
  mainContent.prefWidth <== stage.scene.width
//  setPrefSize(stage.scene.width.get, stage.scene.height.get)
  
//  indicatorPane.prefHeight <== stage.scene.height
  indicatorPane.prefWidth <== mainContent.width * 0.2
//  controlsPane.prefHeight <== stage.scene.height
  controlsPane.prefWidth <== mainContent.width * 0.2
//  centerPane.prefHeight <== stage.scene.height
//  centerPane.prefWidth <== stage.scene.width * 0.6

}