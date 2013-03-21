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
package scalafx.canvas

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.collections.ObservableBuffer
import scalafx.scene.Group
import scalafx.scene.Group.sfxGroup2jfx
import scalafx.scene.Scene
import scalafx.scene.canvas.Canvas
import scalafx.scene.control.ChoiceBox
import scalafx.scene.control.SelectionModel
import scalafx.scene.input.MouseEvent
import scalafx.scene.layout.BorderPane
import scalafx.scene.layout.Pane
import scalafx.scene.paint.Color

/**
 * Example adapted from code showed in [[http://docs.oracle.com/javafx/2/canvas/jfxpub-canvas.htm]].
 */
object LayerTest extends JFXApp {

  //  Create Layers
  // Layers 1&2 are the same size
  private val layer1 = new Canvas(300, 250)
  private val layer2 = new Canvas(300, 250)

  // Obtain Graphics Contexts
  private val gc1 = layer1.graphicsContext2D
  gc1.fill = Color.GREEN
  gc1.fillOval(50, 50, 20, 20)
  private val gc2 = layer2.graphicsContext2D
  gc2.fill = Color.BLUE
  gc2.fillOval(100, 100, 20, 20)

  // Handle Layers
  // Handler for Layer 1
  layer1.onMousePressed = (e: MouseEvent) => {
    gc1.fillOval(e.x, e.y, 20, 20)
  }
  // Handler for Layer 2
  layer2.onMousePressed = (e: MouseEvent) => {
    gc2.fillOval(e.x, e.y, 20, 20)
  }

  // Create Choice Box 
  val layer1Title = "Layer 1 is GREEN"
  val layer2Title = "Layer 2 is BLUE"
  private val cb = new ChoiceBox[String] {
    items = ObservableBuffer(layer1Title, layer2Title)
  }
  val selectionModel: SelectionModel[String] = cb.selectionModel.get
  selectionModel.selectedItem.onChange((ov: Any, olaValue: Any, newValue: Any) => {
    if (newValue == layer1Title) {
      layer1.toFront()
    } else if (newValue == layer2Title) {
      layer2.toFront()
    }
  })
  cb.value = layer1Title

  // Build GUI
  private val borderPane = new BorderPane()
  // Add Layers
  borderPane.top = cb
  borderPane.center = new Pane {
    content = List(layer1, layer2)
  }
  layer1.toFront()

  private val root = new Group
  root.children = borderPane

  stage = new PrimaryStage {
    title = "Layer Test"
    scene = new Scene(root)
  }

}