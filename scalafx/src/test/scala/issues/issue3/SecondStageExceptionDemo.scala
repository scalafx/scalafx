package issues.issue3

import javafx.{stage => jfxs}

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.event.ActionEvent
import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.control.{Label, Button}
import scalafx.scene.layout.StackPane
import scalafx.stage.Stage
import scalafx.application.JFXApp.PrimaryStage

/**
 * Illustration of problem with creating and showing a second stage using `showAndWait()`.
 */
object SecondStageExceptionDemo extends JFXApp {

  stage = new PrimaryStage {
    scene = new Scene(200, 100) {
      content = new StackPane {
        padding = Insets(20, 20, 20, 20)
        content = new Button {
          text = "Show Dialog"
          onAction = (ae: ActionEvent) => {
            // the JavaFX stage constructor argument below was needed to prevent exceptions
            val dialogStage = new Stage {
              scene = new Scene {
                content = new StackPane {
                  padding = Insets(20, 20, 20, 20)
                  content = new Label("  This is a new dialog!  ")
                }
              }
            }
            // Exception was thrown here: java.lang.IllegalStateException: Cannot call this method on primary stage
            dialogStage.showAndWait()
          }
        }
      }
    }
  }
}
