package scalafx.controls

import scalafx.scene.layout.Priority
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.controls.controls.ProgressIndicatorControls
import scalafx.scene.Scene
import scalafx.scene.control.ProgressBar
import scalafx.scene.layout.BorderPane
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

  stage = new PrimaryStage {
    title = "ProgressBar Test"
    width = 300
    height = 225
    scene = new Scene {
      fill = Color.LIGHTGRAY
      content = mainPane
    }
  }

}