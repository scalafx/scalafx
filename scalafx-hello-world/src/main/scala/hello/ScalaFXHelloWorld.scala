package hello

import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.control.Label
import scalafx.scene.layout.BorderPane
import scalafx.scene.text.Font

object ScalaFXHelloWorld extends JFXApp {
  stage = new PrimaryStage {
    scene = new Scene {
      title = "ScalaFX"
      root = new BorderPane {
        padding = Insets(20)
        center = new Label("Hello World!!!") {
          font = new Font("Verdana", 24)
          style = "-fx-font-weight:bold"
        }
      }
    }
  }
}
