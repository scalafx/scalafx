package scalafx.controls

import scalafx.scene.layout.Priority
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.controls.controls.ProgressIndicatorControls
import scalafx.scene.Scene
import scalafx.scene.control.ProgressIndicator
import scalafx.scene.layout.BorderPane
import scalafx.scene.paint.Color
import scalafx.scene.paint.Color.sfxColor2jfx

object ProgressIndicatorTest extends JFXApp {

  val progressIndicator = new ProgressIndicator

  val progressIndicatorController = new ProgressIndicatorControls(progressIndicator)

  val mainPane = new BorderPane {
    top = progressIndicator
    center = progressIndicatorController
    vgrow = Priority.ALWAYS
    hgrow = Priority.ALWAYS
  }

  stage = new PrimaryStage {
    title = "ProgressIndicator Test"
    width = 300
    height = 225
    scene = new Scene {
      fill = Color.LIGHTGRAY
      content = mainPane
    }
  }

}