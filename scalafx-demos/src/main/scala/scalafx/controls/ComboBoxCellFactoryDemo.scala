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

package scalafx.controls

import scalafx.application.JFXApp3
import scalafx.collections.ObservableBuffer
import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.control.{ComboBox, ContentDisplay, Label}
import scalafx.scene.layout.VBox
import scalafx.scene.paint.Color
import scalafx.scene.shape.Rectangle

/**
 * Example of using ComboBox with ScalaFX cellFactory helper.
 * Based on example in ComboBox API documentation. ScalaFX allows for safe and simple implementation.
 *
 * Compare ScalaFX:
 * {{{
 * comboBox.cellFactory = (cell, colorValue) => {
 *   cell.contentDisplay = ContentDisplay.GraphicOnly
 *   cell.graphic = Rectangle(10, 10, colorValue)
 * }
 * }}}
 *
 * to equivalent JavaFX:
 * {{{
 * comboBox.setCellFactory(new Callback<ListView<Color>, ListCell<Color>>() {
 *     @Override public ListCell<Color> call(ListView<Color> p) {
 *         return new ListCell<Color>() {
 *             private final Rectangle rectangle;
 *             {
 *                 setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
 *                 rectangle = new Rectangle(10, 10);
 *             }
 *
 *             @Override protected void updateItem(Color item, boolean empty) {
 *                 super.updateItem(item, empty);
 *
 *                 if (item == null || empty) {
 *                     setGraphic(null);
 *                 } else {
 *                     rectangle.setFill(item);
 *                     setGraphic(rectangle);
 *                 }
 *             }
 *         };
 *     }
 * });
 * }}}
 */
object ComboBoxCellFactoryDemo extends JFXApp3 {
  case class MyColor(name: String, color: Color) {
    override def toString: String = name
  }

  /**
   * The main application method. Executed on JavaFX Application thread.
   */
  override def start(): Unit = {
    stage = new JFXApp3.PrimaryStage {
      title = "ComboBox cellFactory Demo"

      private val comboBox = new ComboBox[Color] {
        items = ObservableBuffer(Color.Red, Color.Green, Color.Blue)
        // Custom factory displaying list items are colored rectangles
        cellFactory = (cell, colorValue) => {
          cell.contentDisplay = ContentDisplay.GraphicOnly
          cell.graphic = Rectangle(10, 10, colorValue)
        }
      }

      scene = new Scene(400, 300) {
        fill = Color.White
        content = new VBox {
          padding = Insets(14)
          spacing = 7
          children ++= Seq(
            Label("Select Color"),
            comboBox
          )
        }
      }
    }
  }
}
