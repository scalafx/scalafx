package scalafx

import scala.collection.JavaConverters._

import javafx.scene.{layout => jfxsl}
import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.control._
import scalafx.scene.layout._
import scalafx.scene.paint.Color._
import scalafx.scene.web._
import scalafx.stage.Stage
import scene.effect.GaussianBlur._
import scene.paint.Color

object WebDemo extends JFXApp {

  val browser = new WebView {
    hgrow = Priority.ALWAYS
    vgrow = Priority.ALWAYS
  }
  val engine = browser.engine
  engine.load("http://code.google.com/p/scalafx/")

  val txfUrl = new TextField {
    text = engine.location.value
    hgrow = Priority.ALWAYS
    vgrow = Priority.NEVER
  }
  txfUrl.onAction = (engine.load(txfUrl.text.get))

  stage = new Stage {
    title = "ScalaFX Web Demo"
    width = 800
    height = 600
    scene = new Scene {
      fill = Color.LIGHTGRAY
      content = new BorderPane {
        hgrow = Priority.ALWAYS
        vgrow = Priority.ALWAYS
        top = txfUrl
        center = browser
      }
    }
  }
  

}