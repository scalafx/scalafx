package scalafx.canvas

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.beans.property.ObjectProperty.sfxObjectProperty2jfx
import scalafx.collections.ObservableBuffer
import scalafx.scene.Group.sfxGroup2jfx
import scalafx.scene.canvas.Canvas
import scalafx.scene.canvas.GraphicsContext
import scalafx.scene.control.SelectionModel
import scalafx.scene.control.ChoiceBox
import scalafx.scene.input.MouseEvent
import scalafx.scene.layout.BorderPane
import scalafx.scene.layout.Pane
import scalafx.scene.paint.Color
import scalafx.scene.Group
import scalafx.scene.Scene
import scalafx.stage.Stage

/**
 * Example adapted from code showed in [[http://docs.oracle.com/javafx/2/canvas/jfxpub-canvas.htm]].
 */
object LayerTest extends JFXApp {

  private var root: Group = null
  private var borderPane: BorderPane = null
  private var layer1: Canvas = null
  private var layer2: Canvas = null
  private var gc1: GraphicsContext = null
  private var gc2: GraphicsContext = null
  private var cb: ChoiceBox[String] = null

  private def createLayers {
    // Layers 1&2 are the same size
    layer1 = new Canvas(300, 250)
    layer2 = new Canvas(300, 250)

    // Obtain Graphics Contexts
    gc1 = layer1.graphicsContext2D
    gc1.fill = Color.GREEN
    gc1.fillOval(50, 50, 20, 20);
    gc2 = layer2.graphicsContext2D
    gc2.fill = Color.BLUE
    gc2.fillOval(100, 100, 20, 20);
  }

  private def handleLayers() {
    // Handler for Layer 1
    layer1.onMousePressed = (e: MouseEvent) => {
      gc1.fillOval(e.x, e.y, 20, 20)
    }

    // Handler for Layer 2
    layer2.onMousePressed = (e: MouseEvent) => {
      gc2.fillOval(e.x, e.y, 20, 20)
    }
  }

  private def createChoiceBox {
    val layer1Title = "Layer 1 is GREEN"
    val layer2Title = "Layer 2 is BLUE"
    cb = new ChoiceBox[String] {
      items = ObservableBuffer(layer1Title, layer2Title)
    }
    val selectionModel: SelectionModel[String] = cb.selectionModel.get
    selectionModel.selectedItem.onChange((ov: Any, olaValue: Any, newValue: Any) => {
      if(newValue == layer1Title) {
        layer1.toFront
      } else if(newValue == layer2Title) {
        layer2.toFront
      }
    })
    cb.value = layer1Title
  }

  private def addLayers() {
    // Add Layers
    borderPane.top = cb
    borderPane.center = new Pane {
      content = List(layer1, layer2)
    }
    layer1.toFront
    root.children = borderPane
  }

  // Build GUI
  borderPane = new BorderPane();
  root = new Group
  createLayers
  handleLayers
  createChoiceBox
  addLayers

  stage = new Stage {
    title = "Layer Test"
    scene = new Scene(root)
  }

}