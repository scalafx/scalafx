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
package scalafx

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.control._
import scalafx.scene.layout._
import scalafx.scene.web._
import scene.paint.Color

object WebDemo extends JFXApp {

  val browser = new WebView {
    hgrow = Priority.ALWAYS
    vgrow = Priority.ALWAYS
    onAlert = (e: WebEvent[_]) => println("onAlert: " + e)
    onStatusChanged = (e: WebEvent[_]) => println("onStatusChanged: " + e)
    onResized = (e: WebEvent[_]) => println("onResized: " + e)
    onVisibilityChanged = (e: WebEvent[_]) => println("onVisibilityChanged: " + e)
  }


  val engine = browser.engine
  engine.load("http://code.google.com/p/scalafx/")

  val txfUrl = new TextField {
    text = engine.location.value
    hgrow = Priority.ALWAYS
    vgrow = Priority.NEVER
  }
  txfUrl.onAction = engine.load(txfUrl.text.get)

  stage = new PrimaryStage {
    title = "ScalaFX Web Demo"
    width = 800
    height = 600
    scene = new Scene {
      fill = Color.LIGHTGRAY
      root = new BorderPane {
        hgrow = Priority.ALWAYS
        vgrow = Priority.ALWAYS
        top = txfUrl
        center = browser
      }
    }
  }

}