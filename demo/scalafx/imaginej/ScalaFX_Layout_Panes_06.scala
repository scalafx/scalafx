package scalafx.imaginej

import javafx.geometry.Pos
import javafx.geometry.VPos
import javafx.scene.paint.Color
import javafx.scene.text.FontWeight
import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.geometry.Insets
import scalafx.scene.control.Button
import scalafx.scene.control.ToolBar
import scalafx.scene.image.Image
import scalafx.scene.image.ImageView
import scalafx.scene.layout._
import scalafx.scene.shape.Rectangle
import scalafx.scene.text.Font
import scalafx.scene.text.Text
import scalafx.scene.Scene
import scalafx.stage.Stage
import javafx.geometry.Orientation

/**
 * @author prasannakumar <prassee.sathian@gmail.com>
 *
 * based upon: Example ScalaFX_Layout_Panes_05.scala
 *
 */
object ScalaFX_Layout_Panes_06 extends JFXApp {
  val currentButton = new Button {
    text = "Current"
    prefWidth = 100
    prefHeight = 20
  }
  val projectedButton = new Button {
    text = "Projected"
    prefWidth = 100
    prefHeight = 20
  }
  val questionText: Text = new Text {
    fill = Color.WHITE
    stroke = Color.DARKBLUE
    font = Font.font("Amble Cn", FontWeight.BOLD, 18)
    text = " ? "
  }
  val questionRectangle = new Rectangle {
    fill = Color.LIGHTBLUE
    stroke = Color.WHITE
    arcHeight = 3.5
    arcWidth = 3.5
    width = questionText.boundsInLocal.getValue.getWidth() + 10
    height = questionText.boundsInLocal.getValue.getHeight() + 10
  }
  val stackPane = new StackPane {
    innerAlignment = Pos.CENTER
    content = List(questionRectangle, questionText)
  }

  val toolbar = new ToolBar {
    orientation = Orientation.HORIZONTAL
    content = List(
      new Button {
        text = "toolbar Button 1"
      },
      new Button {
        text = "toolbar Button 2"
      })
  }

  val data = List(
    new Text {
      font = Font.font("Amble CN", FontWeight.BOLD, 14)
      text = "Data"
    },
    new Text {
      text = "  Sales"
    },
    new Text {
      text = "  Marketing"
    },
    new Text {
      text = "  Distribution"
    },
    new Text {
      text = "  Costs"
    })
  val vBox = new VBox {
    spacing = 10
    padding = Insets(10, 10, 10, 10)
    content = data
  }

  val salesText = new Text {
    font = Font.font("Tahoma", FontWeight.BOLD, 20)
    text = "Sales:"
  }

  val yearText = new Text {
    font = Font.font("Tahoma", FontWeight.BOLD, 20)
    text = "Current Year"
  }

  val iconImageView = new ImageView {
    image = new Image(this, "images/icon.png")
  }

  val oldAndNewText = new Text {
    text = "Old and New"
  }

  val oldText = new Text {
    text = "Old\n20%"
  }

  val newText = new Text {
    text = "New\n80%"
  }

  val newImageView = new ImageView {
    image = new Image(this, "images/new.png")
  }

  val gridPane = new GridPane {
    hgap = 10
    vgap = 10
    padding = Insets(0, 0, 0, 10)
  }

  gridPane.add(iconImageView, 0, 0, 1, 2)
  gridPane.add(salesText, 1, 0)
  gridPane.add(yearText, 2, 0)
  gridPane.add(oldAndNewText, 1, 1, 2, 1);
  GridPane.setValignment(oldText, VPos.BOTTOM)
  gridPane.add(oldText, 0, 2)
  gridPane.add(newImageView, 1, 2, 2, 1)
  GridPane.setValignment(newText, VPos.TOP)
  gridPane.add(newText, 3, 2)

  stage = new Stage {
    title = "ScalaFX Layout Panes 05"
    scene = new Scene {
      content = new BorderPane {
        top = toolbar //hBox
        left = vBox
        center = gridPane
      }
    }
  }
}


