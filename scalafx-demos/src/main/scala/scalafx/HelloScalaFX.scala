package scalafx

import javafx.scene.{ effect => jfxse }
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.layout.HBox
import scalafx.scene.paint.Color._
import scene.effect._
import scene.paint.{ Stops, LinearGradient }
import scene.text.Text

object HelloScalaFX extends JFXApp {
  stage = new PrimaryStage {
    title = "ScalaFX Hello World"
    width = 650
    height = 450
    scene = new Scene {
      fill = BLACK
      content = new HBox {
//        padding = Insets(5)
        content = Seq(new Text {
          text = "Scala"
          style = "-fx-font-size: 100pt"
          fill = new LinearGradient(
            endX = 0,
            stops = Stops(PALEGREEN, SEAGREEN))
        }, new Text {
          text = "FX"
          style = "-fx-font-size: 100pt"
          fill = new LinearGradient(
            endX = 0,
            stops = Stops(CYAN, DODGERBLUE))
          effect = new DropShadow {
            color = DODGERBLUE
            radius = 25
            spread = 0.25
          }
        })
        effect = new Reflection {
          fraction = 0.5
          topOffset = -5.0
          bottomOpacity = 0.75
          input = new Lighting {
            light = new Light.Distant {
              elevation = 60
            }
          }
        }
      }
    }
  }
}