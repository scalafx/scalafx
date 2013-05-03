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
package scalafx.controls

import javafx.scene.control.ContentDisplay
import javafx.scene.control.OverrunStyle
import javafx.scene.layout.Priority
import javafx.scene.text.TextAlignment
import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.collections.ObservableBuffer
import scalafx.controls.controls._
import scalafx.geometry.Pos
import scalafx.scene.Scene
import scalafx.scene.control._
import scalafx.scene.layout.VBox
import scalafx.scene.paint.Color

object TooltipDemo extends JFXApp {

  val myTooltip = new Tooltip

  val btnTooltip = new Button {
    text = "Mouse over me to see Tooltip"
    tooltip = myTooltip
    alignmentInParent = Pos.CENTER
  }

  val controlsPane = new VBox {
    spacing = 5
    fillWidth = true
    alignment = Pos.CENTER
    alignmentInParent = Pos.TOP_CENTER
    hgrow = Priority.ALWAYS
    content = List(new TooltipControls(myTooltip), new PopupControlControls(myTooltip))
  }

  val mainPane = new VBox {
    content = List(btnTooltip, controlsPane)
  }

  stage = new JFXApp.PrimaryStage {
    title = "Tooltip Test"
    width = 300
    height = 600
    scene = new Scene {
      fill = Color.LIGHTGRAY
      content = mainPane
    }
  }
  mainPane.prefHeight <== stage.scene.height
  mainPane.prefWidth <== stage.scene.width

}

class TooltipControls(target: Tooltip) extends PropertiesNodes[Tooltip](target, "Tooltip Properties") {

  val lblActivated = new Label {
    text <== when(target.activated) choose "Activated" otherwise "Deactivated"
  }

  val originalContentDisplay = target.contentDisplay()
  val chbContentDisplay = new ChoiceBox[ContentDisplay] {
    items = ObservableBuffer(ContentDisplay.BOTTOM, ContentDisplay.CENTER, ContentDisplay.GRAPHIC_ONLY, ContentDisplay.LEFT, ContentDisplay.RIGHT,
      ContentDisplay.TEXT_ONLY, ContentDisplay.TOP)
    value <==> target.contentDisplay
  }

  val originalText = target.text()
  val txfText = new TextField {
    text <==> target.text
  }

  val originalTextAlignment = target.textAlignment()
  val chbTextAlignment = new ChoiceBox[TextAlignment] {
    items = ObservableBuffer(TextAlignment.CENTER, TextAlignment.JUSTIFY, TextAlignment.LEFT, TextAlignment.RIGHT)
    value <==> target.textAlignment
  }

  val originalTextOverrun = target.textOverrun()
  val chbTextOverrun = new ChoiceBox[OverrunStyle] {
    items = ObservableBuffer(OverrunStyle.CENTER_ELLIPSIS, OverrunStyle.CENTER_WORD_ELLIPSIS, OverrunStyle.CLIP, OverrunStyle.ELLIPSIS,
      OverrunStyle.LEADING_ELLIPSIS, OverrunStyle.LEADING_WORD_ELLIPSIS, OverrunStyle.WORD_ELLIPSIS)
    value <==> target.textOverrun
  }

  val originalWrap = target.wrapText()
  val chbWrap = new CheckBox {
    selected <==> target.wrapText
  }

  override protected def resetProperties() {
    target.contentDisplay = originalContentDisplay
    target.text = originalText
    target.textAlignment = originalTextAlignment
    target.textOverrun = originalTextOverrun
    target.wrapText = originalWrap
  }

  super.addNode("Activated?", lblActivated)
  super.addNode("ContentDisplay", chbContentDisplay)
  super.addNode("Text", txfText)
  super.addNode("TextAlignment", chbTextAlignment)
  super.addNode("TextOverrun", chbTextOverrun)
  super.addNode("Wrap", chbWrap)
  //  super.addNode("TextAlignment", chbTextAlignment)
  super.addNode(btnReset)

}
/*
def font_=(v: Font) {
def graphic_=(v: Node) {
def graphicTextGap_=(v: Double) {
*/
