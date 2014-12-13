/*
 * Copyright (c) 2011-2014, ScalaFX Project
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

import java.text.NumberFormat
import javafx.util.{converter => jfxu}

import scala.language.implicitConversions
import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.geometry.Insets
import scalafx.scene.control.{Label, Slider, TextField, TextFormatter}
import scalafx.scene.layout.{Region, VBox}
import scalafx.scene.{Parent, Scene}

/**
 * Demonstrates a TextField control with a TextFormatter that formats the content.
 */
object TextFormatterDemo extends JFXApp {

  val infoLabel = new Label {
    text = "" +
      "Demonstrates a TextField control with a TextFormatter. Text is formatted as a currency. " +
      "Move slider or edit the text field content."
    wrapText = true
    prefHeight = Region.USE_COMPUTED_SIZE
  }
  val slider = new Slider(0, 10000, 1000)

  def createContent(): Parent = {
    val converter = new jfxu.FormatStringConverter[Number](NumberFormat.getCurrencyInstance)
    new TextField {
      textFormatter = new TextFormatter[Number](converter) {
        value <==> slider.value
      }
      maxWidth = 140
      maxHeight = Region.USE_COMPUTED_SIZE
    }
  }

  stage = new PrimaryStage {
    scene = new Scene(300, 200) {
      title = "TextFormatter Demo"
      root = new VBox {
        content = Seq(infoLabel, createContent(), slider)
        padding = Insets(20)
        spacing = 12
      }
    }
  }

  slider.requestFocus()
}