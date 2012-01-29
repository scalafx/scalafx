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
import scalafx.Includes.jfxLabeled2sfx
import scalafx.Includes.jfxStringProperty2sfx
import scalafx.collections.ObservableBuffer
import scalafx.scene.Node.sfxNode2jfx
import scalafx.scene.control.ChoiceBox.sfxChoiceBox2jfx
import scalafx.scene.control.TextField.sfxTextField2jfx
import scalafx.scene.control.ChoiceBox
import scalafx.scene.control.Label
import scalafx.scene.control.TextField
import scalafx.scene.control.TitledPane
import scalafx.scene.layout.GridPane.sfxGridPane2jfx
import scalafx.scene.layout.GridPane
import scalafx.scene.Node

class TextFieldControls(target: TextField) extends TitledPane {

  val txfPromptText = new TextField {
    text <==> target.promptText
  }

  val chbPrefColumnCount = new ChoiceBox[Int] {
    items = ObservableBuffer[Int](0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)
  }
  // In JAvaFX 2.1, bind TextArea.prefRowCount with value
  chbPrefColumnCount.delegate.selectionModelProperty.addListener(new ChangeListener[Any] {
    def changed(observable: ObservableValue[_], oldValue: Any, newValue: Any) {
      target.prefColumnCount = chbPrefColumnCount.items.get().get(newValue.toString().toInt)
    }
  })

  val controlsPane = new GridPane {
    hgap = 5
    vgap = 5
    hgrow = Priority.NEVER
  }
  controlsPane.add(new Label {
    labelFor = txfPromptText
    text = "Prompt Text"
    textAlignment = TextAlignment.RIGHT
  }.asInstanceOf[Node], 0, 0)
  controlsPane.add(txfPromptText, 1, 0)
  controlsPane.add(new Label {
    labelFor = txfPromptText
    text = "Text columns"
    textAlignment = TextAlignment.RIGHT
  }.asInstanceOf[Node], 0, 1)
  controlsPane.add(chbPrefColumnCount, 1, 1)

  // TODO: Make TiledPane a Labeled subclass and use text property directly
  delegate.text = "TextField Properties"
  content = controlsPane

}