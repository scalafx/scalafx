package issues.issue16

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.paint.Color
import scalafx.scene.shape.Rectangle
import scalafx.stage.Stage


/**
 * Example for Issue 16 [[http://code.google.com/p/scalafx/issues/detail?id=16]] provided by "Alain.Fa...@gmail.com".
 *
 * When replacing the javafx.scene.paint.Color import by its ScalaFX counterpart, the rectangle would be BLUE forever.
 * The rectangle should normally be RED, but when mouse hovers above it it should change color to GREEN.
 */
object World extends JFXApp {
  stage = new Stage {
    title = "Hello World"
    width = 600
    height = 450
    scene = new Scene {
      fill = Color.LIGHTGREEN
      content = new Rectangle {
        x = 25
        y = 40
        width = 100
        height = 100
        fill = Color.BLUE
        // Problem with incorrect behaviour of the binding was here.
        fill <== when(hover) then Color.GREEN otherwise Color.RED
      }
    }
  }
}
