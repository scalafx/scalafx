/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package scalafx


import javafx.scene.paint.Color
import scalafx.application.JFXApp
import scalafx.scene.Scene

import scalafx.scene.control._
import scalafx.stage.Stage
import scalafx.scene.shape._
import scalafx.scene.layout._

object AccordionTest extends JFXApp {

  stage = new Stage {
    width = 600
    height = 450
    scene = new Scene {
      fill = Color.LIGHTGREEN
      content = new Accordion {
        panes = List( 
          new TitledPane {
            content = new Arc {
              radiusX = 25
              radiusY = 50
              startAngle = 135
              length = 45
              fill = Color.BLACK
              stroke = Color.YELLOW
              strokeWidth = 3
            }
          }
        )
      }
    }
  }
}
