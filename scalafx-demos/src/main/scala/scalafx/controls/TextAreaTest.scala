/*
 * Copyright (c) 2011-2019, ScalaFX Project
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

import javafx.beans.value.{ChangeListener, ObservableValue}
import scalafx.Includes.{observableList2ObservableBuffer, _}
import scalafx.application.JFXApp3
import scalafx.collections.ObservableBuffer
import scalafx.controls.controls.{ControlControls, PropertiesNodes, TextInputControlControls}
import scalafx.geometry.Pos
import scalafx.scene.Scene
import scalafx.scene.control.{CheckBox, ChoiceBox, Label, TextArea}
import scalafx.scene.layout.{BorderPane, Priority, VBox}
import scalafx.scene.paint.Color

object TextAreaTest extends JFXApp3 {
  private val initialPreferredHeight: Int = 380
  override def start(): Unit = {
    lazy val textArea = new TextArea { prefColumnCount = 20 }
    val controlsPane = new VBox {
      spacing = 5
      fillWidth = true
      alignment = Pos.Center
      prefHeight <== initialPreferredHeight
      hgrow = Priority.Never
      children =
        List(new TextAreaControls(textArea), new TextInputControlControls(textArea), new ControlControls(textArea))
    }
    val mainPane = new BorderPane {
      top = textArea
      center = controlsPane
    }
    stage = new JFXApp3.PrimaryStage {
      title = "TextArea Test"
      width = 450
      height = initialPreferredHeight
      scene = new Scene {
        fill = Color.LightGray
        content = mainPane
      }
    }
    controlsPane.prefHeight <== stage.scene().height
  }
}

class TextAreaControls(target: TextArea) extends PropertiesNodes[TextArea](target, "TextArea Properties") {
  // TODO: ChoiceBoxes are not really working. In JavaFX 2.1, bind their respective values with TextArea properties.

  val chbPrefColumnCount = new ChoiceBox[Int] {
    items = ObservableBuffer[Int](0, 5, 10, 15, 20, 25, 30)
  }
  // In JAvaFX 2.1, bind TextArea.prefColumnCount with value
  chbPrefColumnCount.delegate.selectionModelProperty.addListener(new ChangeListener[Any] {
    def changed(observable: ObservableValue[_], oldValue: Any, newValue: Any): Unit = {
      target.prefColumnCount = newValue.toString.toInt
    }
  })

  val chbPrefRowCount = new ChoiceBox[Int] {
    items = ObservableBuffer[Int](0, 5, 10, 15, 20, 25, 30)
  }
  // In JAvaFX 2.1, bind TextArea.prefRowCount with value
  chbPrefRowCount.delegate.selectionModelProperty.addListener(new ChangeListener[Any] {
    def changed(observable: ObservableValue[_], oldValue: Any, newValue: Any): Unit = {
      target.prefRowCount = newValue.toString.toInt
    }
  })

  val chbScrollLeft = new ChoiceBox[Double] {
    items = ObservableBuffer[Double](-10, -5, 0, 5, 10, 15, 20)
  }
  //  chbScrollLeft.delegate.selectionModelProperty.set
  // In JAvaFX 2.1, bind TextArea.prefRowCount with value
  chbPrefRowCount.delegate.selectionModelProperty.addListener(new ChangeListener[Any] {
    def changed(observable: ObservableValue[_], oldValue: Any, newValue: Any): Unit = {
      target.scrollLeft = chbScrollLeft.items.get().get(newValue.toString.toInt)
    }
  })

  val chbScrollTop = new ChoiceBox[Double] {
    items = ObservableBuffer[Double](-10, -5, 0, 5, 10, 15, 20)
  }
  // In JAvaFX 2.1, bind TextArea.prefRowCount with value
  chbPrefRowCount.delegate.selectionModelProperty.addListener(new ChangeListener[Any] {
    def changed(observable: ObservableValue[_], oldValue: Any, newValue: Any): Unit = {
      target.scrollTop = chbScrollTop.items.get().get(newValue.toString.toInt)
    }
  })

  val chbWrap = new CheckBox {
    selected <==> target.wrapText
  }

  // TODO: Add a label indicating number of Paragraphs
  val lblParagraphs = new Label
  target.paragraphs.onChange(lblParagraphs.text = target.paragraphs.size.toString)

  super.addNode("Wrapped", chbWrap)
  super.addNode("Pref Column Count", chbPrefColumnCount)
  super.addNode("Pref Row Count", chbPrefRowCount)
  super.addNode("Scroll Left", chbScrollLeft)
  super.addNode("Scroll Top", chbScrollTop)
  super.addNode("Paragraphs", lblParagraphs)

}
