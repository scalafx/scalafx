package scalafx.controls

import scalafx.application.JFXApp
import scalafx.controls.controls.ProgressIndicatorControls
import scalafx.scene.layout.BorderPane
import scalafx.scene.control.ProgressBar
import scalafx.stage.Stage
import javafx.scene.layout.Priority
import scalafx.scene.Scene
import scalafx.scene.paint.Color

object ProgressBarTest extends JFXApp {

  val progressBar = new ProgressBar

  val progressBarController = new ProgressIndicatorControls(progressBar)

  val mainPane = new BorderPane {
    top = progressBar
    center = progressBarController
    vgrow = Priority.ALWAYS
    hgrow = Priority.ALWAYS
  }

  stage = new Stage(JFXApp.STAGE) {
    title = "ProgressBar Test"
    width = 300
    height = 225
    scene = new Scene {
      fill = Color.LIGHTGRAY
      content = mainPane
    }
  }

}