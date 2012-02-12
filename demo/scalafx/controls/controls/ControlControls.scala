package scalafx.controls.controls

import javafx.scene.control.Tooltip
import scalafx.Includes.eventClosureWrapper
import scalafx.Includes.jfxDoubleProperty2sfx
import scalafx.Includes.jfxStringProperty2sfx
import scalafx.scene.control.Control
import scalafx.scene.control.Label
import scalafx.scene.control.TextField

class ControlControls(target: Control) extends PropertiesNodes[Control](target, "Control Properties") {

  val lblHeight = new Label {
    text <== target.height.asString()
  }

  val lblWidth = new Label {
    text <== target.width.asString()
  }

  val txfMaxHeight = new TextField {
    text = target.maxHeight.get.toString
    onAction = fillDoublePropertyFromText(target.maxHeight, this, false)
  }

  val txfPrefHeight = new TextField {
    text = target.prefHeight.get.toString
    onAction = fillDoublePropertyFromText(target.prefHeight, this, false)
  }

  val txfMinHeight = new TextField {
    text = target.minHeight.get.toString
    onAction = fillDoublePropertyFromText(target.minHeight, this, false)
  }

  val txfMinWidth = new TextField {
    text = target.minWidth.get.toString
    onAction = fillDoublePropertyFromText(target.minWidth, this, false)
  }

  val txfPrefWidth = new TextField {
    text = target.prefWidth.get.toString
    onAction = fillDoublePropertyFromText(target.prefWidth, this, false)
  }

  val txfMaxWidth = new TextField {
    text = target.maxWidth.get.toString
    onAction = fillDoublePropertyFromText(target.maxWidth, this, false)
  }

  val txfTootip = new TextField
  txfTootip.text.onChange {
    target.tooltip = if (txfTootip.text.get.isEmpty) null else new Tooltip(txfTootip.text.get)
  }

  super.addNode("Max Height", txfMaxHeight)
  super.addNode("Pref Height", txfPrefHeight)
  super.addNode("Min Height", txfMinHeight)
  super.addNode("Max Width", txfMaxWidth)
  super.addNode("Pref Width", txfPrefWidth)
  super.addNode("Min Width", txfMinWidth)
  super.addNode("Tooltip", txfTootip)
  super.addNode("Height", lblHeight)
  super.addNode("Width", lblWidth)
}
/*
ObjectProperty<ContextMenu>	contextMenu
The ContextMenu to show for this control.

ObjectProperty<Skin<?>>	skin
Skin is responsible for rendering this Control.

*/