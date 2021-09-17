/*
 * Copyright (c) 2011-2020, ScalaFX Project
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

package scalafx

import scalafx.application.JFXApp3
import scalafx.application.JFXApp3.PrimaryStage
import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.layout.HBox
import scalafx.scene.paint.Color._
import scalafx.scene.paint._
import scalafx.scene.text.Text

/**
 * `JFXApp3` is intended to be a replacement for `JFXApp` but is implemented without `scala.DelayedInit`.
 *
 * `JFXApp3` can be used with Scala 3 where `DelayedInit` is no longer supported at runtime. It can also be used with
 * Scala 2, where `DelayedInit` is deprecated but works at runtime.
 *
 * In `JFXApp`, due to `DelayedInit` magic, UI construction and startup code can be put directly in the constructor.
 * That code is executed on JavaFX Application Thread. Without `DelayedInit` it is not possible to use that constructor
 * "magic". `JFXApp3` adds method `start()` that is intended simulate that constructor "magic" and perform UI
 * construction and startup on JavaFX Application Thread.
 *
 * A simple way of porting from from `JFXApp` to `JFXApp3` is to wrap constructors UI building code into `start()`
 * method, see details by comparing `JFXAppDemo` and `JFXApp3Demo`.
 */
object JFXApp3Demo extends JFXApp3 {
  override def start(): Unit = {
    stage = new PrimaryStage {
      title = "ScalaFX Hello World!"
      scene = new Scene {
        fill = Color.rgb(38, 38, 38)
        content = new HBox {
          padding = Insets(50, 80, 50, 80)
          children = Seq(
            new Text {
              text = "Hello World!"
              style = "-fx-font: normal bold 100pt sans-serif"
              fill = new LinearGradient(endX = 0, stops = Stops(Red, DarkRed))
            }
          )
        }
      }
    }
  }
}
