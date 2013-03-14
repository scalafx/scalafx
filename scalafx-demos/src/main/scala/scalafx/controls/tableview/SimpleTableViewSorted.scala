package scalafx.controls.tableview

import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.collections.ObservableBuffer
import scalafx.scene.Scene
import scalafx.scene.control.{TableView, TableColumn}


object SimpleTableViewSorted extends JFXApp {

  val characters = ObservableBuffer[Person](
    new Person("Peggy", "Sue", "555-6798"),
    new Person("Desmond", "Sue", "555-6798"),
    new Person("Rocky", "Raccoon", "555-8036"),
    new Person("Molly", "Raccoon", "555-0789")
  )

  stage = new PrimaryStage {
    title = "Simple Table View Sorted"
    scene = new Scene {
      val firstNameColumn = new TableColumn[Person, String] {
        text = "First Name"
        cellValueFactory = {_.value.firstName}
        prefWidth = 180

      }
      val lastNameColumn = new TableColumn[Person, String] {
        text = "Last Name"
        cellValueFactory = {_.value.lastName}
        prefWidth = 180
      }
      val phoneColumn = new TableColumn[Person, String] {
        text = "Phone"
        cellValueFactory = {_.value.phone}
        prefWidth = 180
      }

      content = new TableView[Person](characters) {
        columns +=(firstNameColumn, lastNameColumn, phoneColumn)
        sortOrder +=(phoneColumn, lastNameColumn, firstNameColumn)
      }
    }
  }
}

