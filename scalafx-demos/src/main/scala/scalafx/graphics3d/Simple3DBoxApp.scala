package scalafx.graphics3d

import javafx.scene.SubScene
import javafx.scene.shape.Box

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.{Group, Parent, Scene, PerspectiveCamera}
import scalafx.scene.transform.{Translate, Rotate}
import scalafx.scene.paint.{Color, PhongMaterial}
import scalafx.scene.shape.DrawMode

/** Demo of a triangular frame of a 3D box based on example in Ensemble 8. */
object Simple3DBoxApp extends JFXApp {

  stage = new PrimaryStage {
    scene = new Scene(createContent) {
      resizable = false
    }
  }

  def createContent: Parent = {
    val testBox = new Box(5, 5, 5)
    testBox.setMaterial(new PhongMaterial(Color.RED))
    testBox.setDrawMode(DrawMode.LINE)

    val camera = new PerspectiveCamera(true) {
      transforms +=(
        new Rotate(-20, Rotate.YAxis),
        new Rotate(-20, Rotate.XAxis),
        new Translate(0, 0, -15))
    }

    val root = new Group {
      children ++= Seq(camera, testBox)
    }

    val subScene = new SubScene(root, 300, 300)
    subScene.setFill(Color.ALICEBLUE)
    subScene.setCamera(camera)

    new Group {
      children += subScene
    }
  }
}
