package issues.issue23

import scalafx.application.JFXApp
import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.layout.StackPane
import scalafx.scene.paint.Color
import scalafx.scene.shape.Rectangle
import scalafx.stage.Stage

/**
 * Issue 23: Cannot assign a ScalaFX object to "scene.root".
 * An attempt to do so resulted (before issue was fixed) in compilation error:
 * {{{
 *   error: type mismatch;
 *   found   : scalafx.scene.layout.StackPane
 *   required: javafx.scene.Parent
 *   root = new StackPane {
 * }}}
 */
object SceneRootAssignmentDemo extends JFXApp {

  stage = new Stage(JFXApp.STAGE) {
    title = "Scene.root Assignment Demo"
    scene = new Scene {
      root = new StackPane {
        padding = Insets(20)
        content = new Rectangle {
          width = 200
          height = 200
          fill = Color.DEEPSKYBLUE
        }
      }
    }
  }
}
