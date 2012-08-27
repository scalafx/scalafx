/**
 *
 */
package scalafx.canvas

import scalafx.Includes.mouseEventClosureWrapper
import scalafx.application.JFXApp
import scalafx.beans.property.DoubleProperty.sfxDoubleProperty2jfx
import scalafx.scene.Group.sfxGroup2jfx
import scalafx.scene.canvas.Canvas
import scalafx.scene.input.MouseEvent
import scalafx.scene.paint.Stop.sfxStop2jfx
import scalafx.scene.paint.Color
import scalafx.scene.paint.CycleMethod
import scalafx.scene.paint.LinearGradient
import scalafx.scene.paint.Stop
import scalafx.scene.shape.Rectangle
import scalafx.scene.Group
import scalafx.scene.Scene
import scalafx.stage.Stage

/**
 * Example adapted from code showed in [[http://docs.oracle.com/javafx/2/canvas/jfxpub-canvas.htm]].
 */
object CanvasDoodleTest extends JFXApp {

  val canvas = new Canvas(200, 200)

  // Draw background with gradient
  val rect = new Rectangle {
    height = 400
    width = 400
    fill = new LinearGradient(0, 0, 1, 1, true, CycleMethod.REFLECT, List(Stop(0, Color.RED), Stop(1, Color.YELLOW)))
  }

  val rootPane = new Group
  rootPane.children = List(rect, canvas)

  stage = new Stage {
    title = "Canvas Doodle Test"
    scene = new Scene(400, 400) {
      root = rootPane
    }
  }

  canvas.translateX = 100
  canvas.translateY = 100

  val gc = canvas.graphicsContext2D

  reset(Color.BLUE)

  // Clear away portions as the user drags the mouse
  canvas.onMouseDragged = (e: MouseEvent) => {
    gc.clearRect(e.x - 2, e.y - 2, 5, 5)
  }

  // Fill the Canvas with a Blue rectnagle when the user double-clicks
  canvas.onMouseClicked = (e: MouseEvent) => {
    if (e.clickCount > 1) {
      reset(Color.BLUE);
    }
  }

  /**
   * Resets the canvas to its original look by filling in a rectangle covering
   * its entire width and height. Color.BLUE is used in this demo.
   *
   * @param color The color to fill
   */
  private def reset(color: Color) {
    gc.fill = color
    gc.fillRect(0, 0, canvas.width.get, canvas.height.get);
  }

}