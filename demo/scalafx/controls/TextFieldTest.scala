package scalafx.controls

import javafx.beans.value.ChangeListener
import javafx.beans.value.ObservableValue
import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.collections.ObservableBuffer._
import scalafx.collections.ObservableBuffer
import scalafx.scene.control.ChoiceBox
import scalafx.scene.control.TextField
import scalafx.scene.control.TitledPane
import javafx.scene.layout.Priority
import scalafx.scene.layout.GridPane
import scalafx.scene.control.Label
import scalafx.scene.Node
import javafx.scene.text.TextAlignment
import scalafx.scene.layout.VBox
import javafx.geometry.Pos
import scalafx.scene.layout.BorderPane
import scalafx.stage.Stage
import scalafx.scene.Scene
import scalafx.scene.paint.Color
import scalafx.scene.layout.FlowPane

object TextFieldTest extends JFXApp {

  val textField = new TextField
  
    val controlsPane = new VBox {
    spacing = 5
    fillWidth = true
    innerAlignment = Pos.CENTER
    prefHeight <== scene.height
    hgrow = Priority.NEVER
    content = List(new TextFieldControls(textField), new TextInputControlControls(textField))
  }

  val mainPane = new BorderPane {
    top = new FlowPane {
      content = List(textField)
    }
    center = controlsPane
    vgrow = Priority.ALWAYS
    hgrow = Priority.ALWAYS
  }

  stage = new Stage {
    title = "TextField Test"
    width = 300
    height = 380
    scene = new Scene {
      fill = Color.LIGHTGRAY
      content = mainPane
    }
  }

}

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