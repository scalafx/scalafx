/*
 * Copyright (c) 2011, ScalaFX Project
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

import application.JFXApp
import javafx.geometry.Pos
import javafx.geometry.VPos
import scalafx.scene.paint.Color._
import scalafx.scene.paint.Color
import scene.control.Accordion
import scene.control.Label
import scene.control.ScrollPane
import scene.control.TitledPane
import scene.layout.HBox
import scene.shape.Circle
import scene.text.Font
import scene.text.Text
import scene.Scene
import stage.Stage

object LayoutDemo extends JFXApp {
  val hello = new Accordion {
    panes = List(
      new TitledPane {
        content = new Label { text = "Hello" }
      }
    )
  }

  val hbox1 = new HBox { content=List(hello, new Label { text = "Goodbye" }) }
  val hbox2 = new HBox { content=List(new Circle { radius=20 }, new Label { text = "Strange" }) }

  val charm = new Text("charm") { font = new Font(24); alignment = Pos.BASELINE_LEFT; textOrigin = VPos.BASELINE }
  val strange = new Text("strange") { font = new Font(12); alignment = Pos.BASELINE_LEFT; textOrigin = VPos.BASELINE }

  stage = new Stage {
    width = 1024
    height = 768
    scene = new Scene {
      content = new ScrollPane {
        content = new HBox {
          alignment = Pos.BASELINE_LEFT
          fill = Color.BLUE
          content = List(charm, strange)
        }
      }
    }
  }
}