package scalafx.controls

import javafx.scene.layout.Priority
import javafx.{geometry => jfxg}
import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.collections.ObservableBuffer
import scalafx.controls.controls._
import scalafx.geometry._
import scalafx.scene.Scene
import scalafx.scene.control._
import scalafx.scene.layout._
import scalafx.scene.paint.Color

object SeparatorDemo extends JFXApp {

  val separator = new Separator

  val pnlSeparator = new FlowPane {
    content = List(new Button { text = "Button 1" }, separator, new Button { text = "Button 2" })
    minHeight = 100
    prefHeight = 100
    minWidth = 100
    prefWidth = 300    
  }

  val controlsPane = new VBox {
    spacing = 5
    fillWidth = true
    alignment = Pos.CENTER
    alignmentInParent = Pos.TOP_CENTER
    hgrow = Priority.ALWAYS
    content = List(new SeparatorControls(separator), new ControlControls(separator))
  }

  val mainPane = new BorderPane {
    top = pnlSeparator
    center = controlsPane
  }

  stage = new PrimaryStage {
    title = "Tooltip Test"
    width = 300
    height = 600
    scene = new Scene {
      fill = Color.WHITE
      content = mainPane
    }
  }

}

class SeparatorControls(target: Separator) extends PropertiesNodes[Separator](target, "Separator Controls") {

  val chbHPos = new ChoiceBox[jfxg.HPos] {
    items = ObservableBuffer(HPos.CENTER, HPos.LEFT, HPos.RIGHT)
    value <==> target.halignment
  }

  val chbOrientation = new ChoiceBox[jfxg.Orientation] {
    items = ObservableBuffer(Orientation.HORIZONTAL, Orientation.VERTICAL)
    value <==> target.orientation
  }

  // NOTE: The type of ChoiceBox is using javafx.geometry.VPos due to current limitations of binding implementation
  val chbVPos = new ChoiceBox[jfxg.VPos] {
    items = ObservableBuffer(VPos.BASELINE, VPos.BOTTOM, VPos.CENTER, VPos.TOP)
    value <==> target.valignment
  }

  super.addNode("HPos", chbHPos)
  super.addNode("VPos", chbVPos)
  super.addNode("Orientation", chbOrientation)

}