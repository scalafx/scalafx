package scalafx.controls

import javafx.scene.control.Menu
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.control.MenuBar
import scalafx.scene.paint.Color

object MenuBarTest extends JFXApp {

  val menuBar = new MenuBar {
       useSystemMenuBar = true
       minWidth = 100
       menus.add(new Menu("test"))
     }

  stage = new PrimaryStage {
       title = "MenuBar Test"
       width = 300
       height = 225
       scene = new Scene {
         fill = Color.LIGHTGRAY
         content = menuBar
       }
     }

}
