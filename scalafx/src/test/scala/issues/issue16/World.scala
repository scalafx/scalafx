/*
 * Copyright (c) 2011-2025, ScalaFX Project
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
package issues.issue16

import scalafx.Includes.*
import scalafx.application.JFXApp3
import scalafx.application.JFXApp3.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.paint.Color
import scalafx.scene.shape.Rectangle

/**
 * Example for [[https://github.com/scalafx/scalafx/issues/16 Issue 16]] provided by "Alain.Fa...@gmail.com".
 *
 * When replacing the javafx.scene.paint.Color import by its ScalaFX counterpart, the rectangle would be Blue forever.
 * The rectangle should normally be RED, but when mouse hovers above it it should change color to GREEN.
 */
object World extends JFXApp3 {
  override def start(): Unit = {
    stage = new PrimaryStage {
      title = "Hello World"
      width = 600
      height = 450
      scene = new Scene {
        fill = Color.LightGreen
        content = new Rectangle {
          x = 25
          y = 40
          width = 100
          height = 100
          fill = Color.Blue
          // Problem with incorrect behaviour of the binding was here.

          // TODO Scala 3: Original line of code does not compile with Scala 3.0.0-RC2
          // fill <== when (hover) choose Color.Green otherwise Color.Red
          // NOTE Scala 3: variable `helper` was added to force type (and implicint conversions) on right side of `<==`
          //               This is not needed in Scala 2

          import javafx.scene.paint as jfxsp
          import scalafx.beans.binding.ObjectBinding

          val helper: ObjectBinding[jfxsp.Color] = when(hover) choose Color.Green otherwise Color.Red
          fill <== helper
        }
      }
    }
  }
}
