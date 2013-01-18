package scalafx.controls

import scalafx.application.JFXApp
import scalafx.stage.Stage
import scalafx.scene.Scene
import scalafx.scene.paint.Color
import scalafx.scene.control.{MenuBar, Label}
import javafx.scene.control.Menu

object MenuBarTest extends JFXApp {

  val menuBar = new MenuBar {
       useSystemMenuBar = true
       minWidth = 100
       menus.add(new Menu("test"))
     }

  stage = new Stage {
       title = "MenuBar Test"
       width = 300
       height = 225
       scene = new Scene {
         fill = Color.LIGHTGRAY
         content = menuBar
       }
     }

}
