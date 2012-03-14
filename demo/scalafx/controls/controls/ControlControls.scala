package scalafx.controls.controls

import javafx.scene.control.Tooltip
import scalafx.Includes.eventClosureWrapper
import scalafx.Includes.jfxDoubleProperty2sfx
import scalafx.Includes.jfxStringProperty2sfx
import scalafx.scene.control.Control
import scalafx.scene.control.Label
import scalafx.scene.control.TextField

class ControlControls(target: Control, val maxMinHeight: Double = 100.0, val maxMaxHeight: Double = 100.0, val maxPrefHeight: Double = 100.0,
  val maxMinWidth: Double = 100.0, val maxMaxWidth: Double = 100.0, val maxPrefWidth: Double = 100.0)
  extends PropertiesNodes[Control](target, "Control Properties") {

  val lblHeight = new Label {
    text <== target.height.asString()
  }

  val lblWidth = new Label {
    text <== target.width.asString()
  }

  val originalMaxHeight = target.maxHeight
  val sldMaxHeight = new SliderLabelControl(target.maxHeight) {
    min = -10
    max = maxMaxHeight
  }

  val originalPrefHeight = target.prefHeight
  val sldPrefHeight = new SliderLabelControl(target.prefHeight) {
    min = -10
    max = maxPrefHeight
  }

  val originalMinHeight = target.minHeight
  val sldMinHeight = new SliderLabelControl(target.minHeight) {
    min = -10
    max = maxMinHeight
  }

  val originalMinWidth = target.minWidth
  val sldMinWidth = new SliderLabelControl(target.minWidth) {
    min = -10
    max = maxMinWidth
  }

  val originalPrefWidth = target.prefWidth
  val sldPrefWidth = new SliderLabelControl(target.prefWidth) {
    min = -10
    max = maxPrefWidth
  }

  val originalMaxWidth = target.maxWidth
  val sldMaxWidth = new SliderLabelControl(target.maxWidth) {
    min = -10
    max = maxMaxWidth
  }

  val txfTootip = new TextField
  txfTootip.text.onChange {
    target.tooltip = if (txfTootip.text.get.isEmpty) null else new Tooltip(txfTootip.text.get)
  }

  super.addNode("Max Height", sldMaxHeight)
  super.addNode("Pref Height", sldPrefHeight)
  super.addNode("Min Height", sldMinHeight)
  super.addNode("Max Width", sldMaxWidth)
  super.addNode("Pref Width", sldPrefWidth)
  super.addNode("Min Width", sldMinWidth)
  super.addNode("Tooltip", txfTootip)
  super.addNode("Height", lblHeight)
  super.addNode("Width", lblWidth)
  //  super.addNode(btnReset)

  override def resetProperties {
    target.maxHeight = originalMaxHeight.get
    target.prefHeight = originalPrefHeight.get
    target.minHeight = originalMinHeight.get
    target.minWidth = originalMinWidth.get
    target.prefWidth = originalPrefWidth.get
    target.maxWidth = originalMaxWidth.get
  }
}
/*
ObjectProperty<ContextMenu>	contextMenu
The ContextMenu to show for this control.

ObjectProperty<Skin<?>>	skin
Skin is responsible for rendering this Control.

*/