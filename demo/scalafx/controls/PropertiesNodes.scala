package scalafx.controls

import javafx.scene.layout.Priority
import javafx.scene.text.TextAlignment
import scalafx.Includes.jfxLabeled2sfx
import scalafx.scene.Node.sfxNode2jfx
import scalafx.scene.Node
import scalafx.scene.control.Label
import scalafx.scene.control.TitledPane
import scalafx.scene.control.TitledPane._
import scalafx.scene.layout.GridPane.sfxGridPane2jfx
import scalafx.scene.layout.GridPane
import scalafx.scene.Node
import scalafx.scene.text.Font._
import javafx.scene.text.FontWeight

/**
 * Basic class to control a control properties
 *
 *  @tparam N scalafx.scene.Node subclass
 *
 *  @param target Node to be manipulated
 *  @param title TitledPane titled
 */
abstract class PropertiesNodes[N <: Node](target: N, title: String) extends TitledPane {

  private var index = 0

  private val controlsPane = new GridPane {
    hgap = 5
    vgap = 5
    hgrow = Priority.NEVER
  }

  /**
   * Add a Control Node with its respective title
   * 
   * @param title Control Node title
   * @param control Control Node 
   */
  protected def addNode(title: String, control: Node) {
    controlsPane.add(new Label {
      font = PropertiesNodes.TitleFont
      labelFor = control
      text = title
      textAlignment = TextAlignment.RIGHT
    }.asInstanceOf[Node], 0, index)
    controlsPane.add(control, 1, index)
    index += 1
  }

  /**
   * Add a Control Node occupying 2 columns
   * 
   * @param control Control Node
   */
  protected def addNode(control: Node) {
    controlsPane.add(control, 0, index, 2, 1)
    index += 1
  }

  /**
   * Add 2 Controls Nodes to occupy a row.
   * 
   * @param control1 Control Node 1
   * @param control2 Control Node 2
   */
  protected def addNodes(control1: Node, control2: Node) {
    controlsPane.add(control1, 0, index)
    controlsPane.add(control2, 1, index)
    index += 1
  }

  delegate.text = title
  content = controlsPane

}

object PropertiesNodes {
  
  private val lblBase = new Label
  private val fontBase = lblBase.font.get()
  
  val TitleFont = font(fontBase.getFamily, FontWeight.BOLD, fontBase.getSize)
}