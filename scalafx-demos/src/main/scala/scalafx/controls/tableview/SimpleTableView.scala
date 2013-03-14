package scalafx.controls.tableview

import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.collections.ObservableBuffer
import scalafx.scene.Scene
import scalafx.scene.control.TableColumn._
import scalafx.scene.control.{TableColumn, TableView}

object SimpleTableView extends JFXApp {

  val characters = ObservableBuffer[Person](
    new Person("Peggy", "Sue", "555-6798"),
    new Person("Rocky", "Raccoon", "555-6798")
  )

  stage = new PrimaryStage {
    title = "Simple Table View"
    scene = new Scene {
      content = new TableView[Person](characters) {
        columns ++= List(
          new TableColumn[Person, String] {
            text = "First Name"
            cellValueFactory = {_.value.firstName}
            prefWidth = 180
          },
          new TableColumn[Person, String]() {
            text = "Last Name"
            cellValueFactory = {_.value.lastName}
            prefWidth = 180
          }
        )
      }
    }
  }
}
