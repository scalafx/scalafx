package scalafx.controls

import javafx.scene.layout.Priority
import scalafx.application.JFXApp
import scalafx.scene.control.ProgressIndicator
import scalafx.scene.layout.BorderPane
import scalafx.scene.paint.Color.sfxColor2jfx
import scalafx.scene.paint.Color
import scalafx.scene.Scene
import scalafx.stage.Stage

object ProgressIndicatorTest extends JFXApp {

  val progressIndicator = new ProgressIndicator

  val progressIndicatorController = new ProgressIndicatorControls(progressIndicator)

  val mainPane = new BorderPane {
    top = progressIndicator
    center = progressIndicatorController
    vgrow = Priority.ALWAYS
    hgrow = Priority.ALWAYS
  }

  stage = new Stage {
    title = "ProgressIndicator Test"
    width = 300
    height = 225
    scene = new Scene {
      fill = Color.LIGHTGRAY
      content = mainPane
    }
  }

}