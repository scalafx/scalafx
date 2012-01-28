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

package scalafx.controls

import javafx.beans.value.ObservableValue
import javafx.beans.value.ChangeListener
import javafx.scene.layout.Priority
import javafx.scene.text.TextAlignment
import scalafx.Includes.jfxBooleanProperty2sfx
import scalafx.application.JFXApp
import scalafx.collections.ObservableBuffer
import scalafx.scene.Node.sfxNode2jfx
import scalafx.scene.control.Control.sfxControl2jfx
import scalafx.scene.control.CheckBox
import scalafx.scene.control.ChoiceBox
import scalafx.scene.control.Label
import scalafx.scene.control.TextArea
import scalafx.scene.layout.GridPane.sfxGridPane2jfx
import scalafx.scene.layout.BorderPane
import scalafx.scene.layout.GridPane
import scalafx.scene.paint.Color.sfxColor2jfx
import scalafx.scene.paint.Color
import scalafx.scene.Node
import scalafx.scene.Scene
import scalafx.stage.Stage

object TextAreaTest extends JFXApp {
  // TODO: ChoiceBoxes are not really working. In JavaFX 2.1, bind their respectives values with TextArea properties. 

  lazy val textArea = new TextArea {
    prefColumnCount = 20
    //    scrollLeft <== chbScrollLeft.selectionModel.get().getSelectedItem()
    wrapText <== chbWrap.selected
    hgrow = Priority.ALWAYS
  }

  val chbPrefColumnCount = new ChoiceBox[Int] {
    items = ObservableBuffer[Int](0, 5, 10, 15, 20, 25, 30)
  }
  // In JAvaFX 2.1, bind TextArea.prefColumnCount with value
  chbPrefColumnCount.delegate.selectionModelProperty.addListener(new ChangeListener[Any] {
    def changed(observable: ObservableValue[_], oldValue: Any, newValue: Any) {
      textArea.prefColumnCount = newValue.toString().toInt
    }
  })

  val chbPrefRowCount = new ChoiceBox[Int] {
    items = ObservableBuffer[Int](0, 5, 10, 15, 20, 25, 30)
  }
  // In JAvaFX 2.1, bind TextArea.prefRowCount with value
  chbPrefRowCount.delegate.selectionModelProperty.addListener(new ChangeListener[Any] {
    def changed(observable: ObservableValue[_], oldValue: Any, newValue: Any) {
      textArea.prefRowCount = newValue.toString().toInt
    }
  })

  val chbScrollLeft = new ChoiceBox[Double] {
    items = ObservableBuffer[Double](-10, -5, 0, 5, 10, 15, 20)
  }
  //  chbScrollLeft.delegate.selectionModelProperty.set
  // In JAvaFX 2.1, bind TextArea.prefRowCount with value
  chbPrefRowCount.delegate.selectionModelProperty.addListener(new ChangeListener[Any] {
    def changed(observable: ObservableValue[_], oldValue: Any, newValue: Any) {
      textArea.scrollLeft = chbScrollLeft.items.get().get(newValue.toString().toInt)
    }
  })

  val chbScrollTop = new ChoiceBox[Double] {
    items = ObservableBuffer[Double](-10, -5, 0, 5, 10, 15, 20)
  }
  // In JAvaFX 2.1, bind TextArea.prefRowCount with value
  chbPrefRowCount.delegate.selectionModelProperty.addListener(new ChangeListener[Any] {
    def changed(observable: ObservableValue[_], oldValue: Any, newValue: Any) {
      textArea.scrollTop = chbScrollTop.items.get().get(newValue.toString().toInt)
    }
  })

  val chbWrap = new CheckBox {
    text = "Wrapped"
  }
  

  // TODO: Add a label indicating number of Paragraphs
  
  val controlsPane = new GridPane {
    hgap = 5
    vgap = 5
    hgrow = Priority.NEVER
  }
  controlsPane.add(new Label {
    text = "Pref Column Count"
    textAlignment = TextAlignment.RIGHT
  }.asInstanceOf[Node], 0, 0)
  controlsPane.add(chbPrefColumnCount, 1, 0)
  controlsPane.add(new Label {
    text = "Pref Row Count"
    textAlignment = TextAlignment.RIGHT
  }.asInstanceOf[Node], 0, 1)
  controlsPane.add(chbPrefRowCount, 1, 1)
  controlsPane.add(new Label {
    text = "Scroll Left"
    textAlignment = TextAlignment.RIGHT
  }.asInstanceOf[Node], 0, 2)
  controlsPane.add(chbScrollLeft, 1, 2)
  controlsPane.add(new Label {
    text = "Scroll Top"
    textAlignment = TextAlignment.RIGHT
  }.asInstanceOf[Node], 0, 3)
  controlsPane.add(chbScrollTop, 1, 3)
  controlsPane.add(chbWrap, 0, 4, 2, 1)

  val mainPane = new BorderPane {
    center = textArea
    right = controlsPane
    vgrow = Priority.ALWAYS
    hgrow = Priority.ALWAYS
  }

  stage = new Stage {
    title = "TextArea Test"
    width = 450
    height = 250
    scene = new Scene {
      fill = Color.LIGHTGRAY
      content = mainPane
    }
  }

}