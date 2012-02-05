package scalafx.controls

import scalafx.Includes.eventClosureWrapper
import scalafx.Includes.jfxStringProperty2sfx
import scalafx.scene.control.Label
import scalafx.scene.control.ProgressIndicator
import scalafx.scene.control.TextField

class ProgressIndicatorControls(target: ProgressIndicator) extends PropertiesNodes[ProgressIndicator](target, target.getClass().getSimpleName() + " Properties") {

  val txfValue = new TextField {
    onAction = setProgress
  }

  def setProgress {
    try {
      val txt = txfValue.text.get
      target.progress = txt.toDouble
    } catch {
      case t: NumberFormatException => target.progress = ProgressIndicator.INDETERMINATE_PROGRESS
    }
    
    txfValue.text = ""
  }

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