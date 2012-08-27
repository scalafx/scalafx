package scalafx.canvas

import scalafx.application.JFXApp
import scalafx.scene.canvas.Canvas
import scalafx.scene.paint.Color
import scalafx.scene.shape.ArcType
import scalafx.scene.Scene
import scalafx.stage.Stage

/**
 * Example adapted from code showed in [[http://docs.oracle.com/javafx/2/canvas/jfxpub-canvas.htm]].
 */
object BasicOpsTest extends JFXApp {

  val canvas = new Canvas(300, 300)
  val gc = canvas.graphicsContext2D

  gc.fill = Color.GREEN
  gc.stroke = Color.BLUE
  gc.lineWidth = 5
  gc.strokeLine(40, 10, 10, 40)
  gc.fillOval(10, 60, 30, 30)
  gc.strokeOval(60, 60, 30, 30)
  gc.fillRoundRect(110, 60, 30, 30, 10, 10)
  gc.strokeRoundRect(160, 60, 30, 30, 10, 10)
  gc.fillArc(10, 110, 30, 30, 45, 240, ArcType.OPEN)
  gc.fillArc(60, 110, 30, 30, 45, 240, ArcType.CHORD)
  gc.fillArc(110, 110, 30, 30, 45, 240, ArcType.ROUND)
  gc.strokeArc(10, 160, 30, 30, 45, 240, ArcType.OPEN)
  gc.strokeArc(60, 160, 30, 30, 45, 240, ArcType.CHORD)
  gc.strokeArc(110, 160, 30, 30, 45, 240, ArcType.ROUND)
  gc.fillPolygon(Seq((10.0, 210), (40, 210), (10, 240), (40, 240)))
  gc.strokePolygon(Seq((60.0, 210), (90, 210), (60, 240), (90, 240)))
  gc.strokePolyline(Seq((110.0, 210), (140, 210), (110, 240), (140, 240)))

  stage = new Stage {
    title = "Drawing Operations Test"
    scene = new Scene {
      content = canvas
    }
  }
}