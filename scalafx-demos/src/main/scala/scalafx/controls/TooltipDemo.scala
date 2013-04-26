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

  override protected def resetProperties() = {
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