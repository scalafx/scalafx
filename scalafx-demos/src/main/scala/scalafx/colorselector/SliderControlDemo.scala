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

package scalafx.colorselector

import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.geometry.{HPos, Pos, VPos}
import scalafx.scene.Scene
import scalafx.scene.control.{CheckBox, Label, TextField}
import scalafx.scene.layout._
import scalafx.scene.paint.Color

object SliderControlDemo extends JFXApp {

  var initialized = false

  val sliderControl = new SliderControl("X")

  val txfInputValue = new TextField {
    alignmentInParent = Pos.BaselineLeft
    promptText = "Enter the value"
    hgrow = Priority.Never
    onAction = _ => sliderControl.value = text.get.toDouble

  }

  val lblOutputValue = new Label {
    alignmentInParent = Pos.BaselineLeft
    text <== sliderControl.realValue.asString("%03.0f")
  }

  val chbSelected = new CheckBox {
    alignmentInParent = Pos.BaselineLeft
    selected <==> sliderControl.selectedControl
  }

  val chbEnabled = new CheckBox {
    alignmentInParent = Pos.BaselineLeft
    selected <==> sliderControl.disable
  }

  val pnlControls = new GridPane {
    add(new Label {
      text = "Input Value"
    }, 0, 0)
    add(txfInputValue, 1, 0)
    add(new Label {
      text = "Output Value"
    }, 2, 0)
    add(lblOutputValue, 3, 0)
    add(new Label {
      text = "Selected"
    }, 0, 1)
    add(chbSelected, 1, 1)
    add(new Label {
      text = "Disabled"
    }, 2, 1)
    add(chbEnabled, 3, 1)
    padding = insets
  }
  GridPane.setHgrow(txfInputValue, Priority.Never)
  GridPane.setValignment(txfInputValue, VPos.Baseline)
  GridPane.setVgrow(txfInputValue, Priority.Never)
  GridPane.setHgrow(lblOutputValue, Priority.Never)
  GridPane.setValignment(lblOutputValue, VPos.Baseline)
  GridPane.setVgrow(lblOutputValue, Priority.Never)
  val ccOdd = new ColumnConstraints {
    halignment = HPos.Right
    hgrow = Priority.Never
  }
  val ccEven = new ColumnConstraints {
    halignment = HPos.Left
    hgrow = Priority.Sometimes
  }
  pnlControls.columnConstraints = List(ccOdd, ccEven, ccOdd, ccEven)

  val box = new VBox(5.0) {
    children = List(sliderControl,
      pnlControls)
  }
  VBox.setVgrow(sliderControl, Priority.Never)
  VBox.setVgrow(pnlControls, Priority.Always)

  val mainScene = new Scene {
    fill = Color.LightGray
    content = new AnchorPane {
      children = List(box)
    }
  }
  box.prefWidth <== mainScene.width
  box.prefHeight <== mainScene.height

  stage = new PrimaryStage {
    title = "SliderControl Demo"
    width = 600
    height = 200
    scene = mainScene
  }
  AnchorPane.setAnchors(box, 0, 0, 0, 0)

}