package scalafx.colorselector

import javafx.scene.layout.Priority
import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.beans.property.DoubleProperty.sfxDoubleProperty2jfx
import scalafx.geometry.{HPos, Pos, VPos}
import scalafx.scene.Scene
import scalafx.scene.control.CheckBox
import scalafx.scene.control.Label
import scalafx.scene.control.TextField
import scalafx.scene.layout.AnchorPane
import scalafx.scene.layout.ColumnConstraints
import scalafx.scene.layout.GridPane
import scalafx.scene.layout.VBox
import scalafx.scene.paint.Color
import scalafx.scene.paint.Color.sfxColor2jfx
import scalafx.stage.Stage

object SliderControlDemo extends JFXApp {


  var initialized = false

  val sliderControl = new SliderControl("X")

  val txfInputValue = new TextField {
    alignment = Pos.BASELINE_LEFT
    promptText = "Enter the value"
    hgrow = Priority.NEVER
    onAction = {
      sliderControl.value = text.get.toDouble
    }
  }

  val lblOutputValue = new Label {
    alignment = Pos.BASELINE_LEFT
    text <== sliderControl.realValue.asString("%03.0f")
  }

  val chbSelected = new CheckBox {
    alignment = Pos.BASELINE_LEFT
    selected <==> sliderControl.selectedControl
  }

  val chbEnabled = new CheckBox {
    alignment = Pos.BASELINE_LEFT
    selected <==> sliderControl.disable
  }

  val pnlControls = new GridPane {
    add(new Label {
      text = "Input Value"
    }, 0, 0)
    add(txfInputValue, 1, 0)
    add(new Label {
      text = "Output Value"
    }, 2, 0)
    add(lblOutputValue, 3, 0)
    add(new Label {
      text = "Selected"
    }, 0, 1)
    add(chbSelected, 1, 1)
    add(new Label {
      text = "Disabled"
    }, 2, 1)
    add(chbEnabled, 3, 1)
    padding = insets
  }
  GridPane.setHgrow(txfInputValue, Priority.NEVER)
  GridPane.setValignment(txfInputValue, VPos.BASELINE)
  GridPane.setVgrow(txfInputValue, Priority.NEVER)
  GridPane.setHgrow(lblOutputValue, Priority.NEVER)
  GridPane.setValignment(lblOutputValue, VPos.BASELINE)
  GridPane.setVgrow(lblOutputValue, Priority.NEVER)
  val ccOdd = new ColumnConstraints {
    halignment = HPos.RIGHT
    hgrow = Priority.NEVER
  }
  val ccEven = new ColumnConstraints {
    halignment = HPos.LEFT
    hgrow = Priority.SOMETIMES
  }
  pnlControls.columnConstraints = List(ccOdd, ccEven, ccOdd, ccEven)

  val box = new VBox(5.0) {
    content = List(sliderControl,
      pnlControls)
  }
  VBox.setVgrow(sliderControl, Priority.NEVER)
  VBox.setVgrow(pnlControls, Priority.ALWAYS)

  val mainScene = new Scene {
    fill = Color.LIGHTGRAY
    content = new AnchorPane {
      content = List(box)
    }
  }
  box.prefWidth <== mainScene.width
  box.prefHeight <== mainScene.height

  stage = new Stage(JFXApp.STAGE) {
    title = "SliderControl Demo"
    width = 600
    height = 200
    scene = mainScene
  }
  AnchorPane.setAnchors(box, 0, 0, 0, 0)

}