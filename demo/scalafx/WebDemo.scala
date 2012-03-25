package scalafx

import scala.collection.JavaConverters._
import scalafx.application.JFXApp
import scalafx.geometry.Insets
import scalafx.Includes._
import scalafx.scene.layout._
import scalafx.scene.paint.Color._
import scalafx.scene.Scene
import scalafx.scene.control._
import scalafx.scene.web._
import scalafx.stage.Stage
import scalafx.scene.shape.Rectangle

import scene.effect._
import scene.effect.GaussianBlur._
import scene.paint.{ Stops, LinearGradient, Color }
import scene.text.Text
import javafx.scene.{ effect => jfxse }
import javafx.scene.{ layout => jfxsl }
import javafx.{ geometry => jfxg }

object WebDemo extends JFXApp {

  val browser = new WebView {
    hgrow = jfxsl.Priority.ALWAYS
    vgrow = jfxsl.Priority.ALWAYS
  }
  val engine = browser.engine
  engine.load("http://code.google.com/p/scalafx/")

  val txfUrl = new TextField {
    text = engine.location
    hgrow = jfxsl.Priority.ALWAYS
    vgrow = jfxsl.Priority.NEVER
  }
  txfUrl.onAction = (engine.load(txfUrl.text.get))

  stage = new Stage {
    title = "ScalaFX Web Demo"
    width = 800
    height = 600
    scene = new Scene {
      fill = Color.LIGHTGRAY
      content = new BorderPane {
        hgrow = javafx.scene.layout.Priority.ALWAYS
        vgrow = javafx.scene.layout.Priority.ALWAYS
        top = txfUrl
        center = browser
      }
    }
  }
  

}