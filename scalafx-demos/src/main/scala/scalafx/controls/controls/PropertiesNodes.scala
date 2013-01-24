/*
 * Copyright (c) 2012, ScalaFX Project
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of the ScalaFX Project nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE SCALAFX PROJECT OR ITS CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
 * AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package scalafx.controls.controls

import javafx.scene.layout.Priority
import javafx.scene.text.FontWeight
import javafx.scene.text.TextAlignment
import scalafx.Includes._
import scalafx.beans.property._
import scalafx.geometry.Pos
import scalafx.scene.Node
import scalafx.scene.Node._
import scalafx.scene.control.TextField
import scalafx.scene.control.TitledPane
import scalafx.scene.control._
import scalafx.scene.layout.GridPane
import scalafx.scene.text.Font._

/**
 * Basic class to control a control properties
 *
 *  @tparam N scalafx.scene.Node subclass
 *
 *  @param target Node to be manipulated
 *  @param title TitledPane titled
 */
abstract class PropertiesNodes[T](target: T, title: String) extends TitledPane {

  private var index = 0

  protected def resetProperties = {}

  protected val btnReset = new Button {
    text = "Reset"
    onAction = resetProperties
    alignmentInParent = Pos.CENTER
  }

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

  protected def fillDoublePropertyFromText(property: DoubleProperty, field: TextField, cleanAfterAction: Boolean = true, onError: () => Unit = () => ()) {
    try {
      val txt = field.text.get
      property.value = txt.toDouble
    } catch {
      case t: NumberFormatException => onError
    }

    if (cleanAfterAction) {
      field.text = ""
    }

  }

  protected def fillIntPropertyFromText(property: IntegerProperty, field: TextField, cleanAfterAction: Boolean = true, onError: () => Unit = () => ()) {
    try {
      val txt = field.text.get
      property.value = txt.toInt
    } catch {
      case t: NumberFormatException => onError
    }

    if (cleanAfterAction) {
      field.text = ""
    }

  }
  
  protected def getCheckBox(property: BooleanProperty, tip: String = "") = new CheckBox {
    selected <==> property
    tooltip = if(tip.isEmpty) null else Tooltip(tip)
  }
  
  protected def getTextField(property: StringProperty, tip: String = "") = new TextField {
    text <==> property
    tooltip = if(tip.isEmpty) null else Tooltip(tip)
  }
  
  protected def getLabel(property: StringProperty) = new Label {
    text <== property
  }

  delegate.text = title
  content = controlsPane

}

object PropertiesNodes {

  private val lblBase = new Label
  private val fontBase = lblBase.font.get()

  val TitleFont = font(fontBase.getFamily, FontWeight.BOLD, fontBase.getSize)
}