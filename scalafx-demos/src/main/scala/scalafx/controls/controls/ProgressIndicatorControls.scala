package scalafx.controls.controls

import scalafx.Includes._
import scalafx.scene.control.Label
import scalafx.scene.control.ProgressIndicator
import scalafx.scene.control.TextField

class ProgressIndicatorControls(target: ProgressIndicator) extends PropertiesNodes[ProgressIndicator](target, target.getClass.getSimpleName + " Properties") {

  val txfValue = new TextField 
  txfValue.onAction = fillDoublePropertyFromText(target.progress, txfValue, true, () => (target.progress = ProgressIndicator.INDETERMINATE_PROGRESS)) 

  val lblRealValue = new Label {
    text <== target.progress.asString()
  }

  val lblIndeterminate = new Label {
    text <== target.indeterminate.asString()
  }

  super.addNode("Value", txfValue)
  super.addNode("Real Value", lblRealValue)
  super.addNode("Indeterminate", lblIndeterminate)

}