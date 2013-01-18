package scalafx.controls

import scalafx.stage.Stage
import scalafx.scene.Scene
import scalafx.scene.paint.Color
import scalafx.application.JFXApp
import scalafx.scene.control.{Label, MenuItem, Menu, MenuBar}
import javafx.event.{Event, EventHandler}
import scalafx.scene.layout.{BorderPane, VBox}


object MenuTest extends JFXApp {

  val menu = new Menu("File") {

    items.add(new MenuItem("Open"))
    items.add(new MenuItem("Close"))

    onShowing = printEvent("on showing")
    onShown = printEvent("on shown")
    onHiding = printEvent("on hiding")
    onHidden = printEvent("on hidden")

    implicit def fun2EventHandler(n: (Event) => Boolean) = new EventHandler[Event] {
      def handle(event: Event) {
        n(event)
      }
    }
  }

  def printEvent(eventStr: String) = {
    {
      event: Event =>
        history.content.add(new Label {
          text = eventStr
        }.delegate)
    }
  }

  val history = new VBox

  val menuBar = new MenuBar {
    useSystemMenuBar = true
    minWidth = 100
    menus.add(menu)
  }

  stage = new Stage {
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
