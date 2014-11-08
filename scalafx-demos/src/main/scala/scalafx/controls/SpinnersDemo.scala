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

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.collections.ObservableBuffer
import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.control.Spinner
import scalafx.scene.layout.{HBox, VBox}

/**
 * A sample that demonstrates the Spinner control.
 */
object SpinnersDemo extends JFXApp {

  val styles = Seq(
    "spinner", // defaults to arrows on right stacked vertically
    Spinner.StyleClassArrowsOnRightHorizontal,
    Spinner.StyleClassArrowsOnLeftVertical,
    Spinner.StyleClassArrowsOnLeftHorizontal,
    Spinner.StyleClassSplitArrowsVertical,
    Spinner.StyleClassSplitArrowsHorizontal
  )

  val intSpinners = for (s <- styles) yield
    new Spinner[Integer](1, 99, 5) {
      styleClass += s
      prefWidth = 100
    }

  val stringSpinners = for (s <- styles) yield
    new Spinner[String](ObservableBuffer("Grace", "Matt", "Katie")) {
      styleClass += s
      prefWidth = 100
    }

  val doubleSpinners = for (s <- styles) yield
    new Spinner[Double](0.0, 1.0, 0.5, 0.01) {
      styleClass += s
      prefWidth = 100
    }

  stage = new PrimaryStage {
    title = "Spinners Demo"
    scene = new Scene {
      content = new VBox(30) {
        content = Seq(
          new HBox(30, intSpinners:_*),
          new HBox(30, stringSpinners:_*),
          new HBox(30, doubleSpinners:_*)
        )
        padding = Insets(24)
      }
    }
  }
}
