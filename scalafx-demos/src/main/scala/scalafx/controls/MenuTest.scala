package scalafx.controls

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.control.{Label, MenuItem, Menu, MenuBar}
import scalafx.scene.layout.{BorderPane, VBox}
import scalafx.scene.paint.Color


object MenuTest extends JFXApp {

  val menu = new Menu("File") {

    items = List(
      new MenuItem("Open"),
      new MenuItem("Close")
    )

    onShowing = printEvent("on showing")
    onShown = printEvent("on shown")
    onHiding = printEvent("on hiding")
    onHidden = printEvent("on hidden")
  }

  def printEvent(eventStr: String)() {
    val label = new Label {
      text = eventStr
    }
    history.content += label
  }

  val history = new VBox

  val menuBar = new MenuBar {
    useSystemMenuBar = true
    minWidth = 100
    menus.add(menu)
  }

  stage = new PrimaryStage {
    title = "Menu test"
    width = 300
    height = 225
    scene = new Scene {
      fill = Color.LIGHTGRAY
      content = new BorderPane {
        top = menuBar
        bottom = history
      }
    }
  }

}
