/**
 *
 */
package scalafx.controls.controls

import scalafx.Includes._
import scalafx.scene.control._

class PopupControlControls(target: PopupControl) extends PropertiesNodes[PopupControl](target, "Popup Control Properties") {

  val originalId: String = target.id.get()
  val txfID = new TextField {
    text <==> target.id
    prefWidth = 50.0
    minWidth = 50.0
//    maxWidth = 50.0
  }

  val originalMaxHeight: Double = target.maxHeight.get()
  val originalMinHeight: Double = target.minHeight.get()
  val originalPrefHeight = target.prefHeight
  val originalPrefWidth = target.prefWidth
  val originalMinWidth = target.minWidth
  val originalMaxWidth = target.maxWidth
  

  super.addNode("ID", txfID)
  super.addNode("Pref Width", new SliderLabelControl(target.prefWidth))
  super.addNode("Min Width", new SliderLabelControl(target.minWidth))
  super.addNode("Max Width", new SliderLabelControl(target.maxWidth) {
    max = 200d
  })
  super.addNode("Pref Height", new SliderLabelControl(target.prefHeight))
  super.addNode("Min Height", new SliderLabelControl(target.minHeight))
  super.addNode("Max Height", new SliderLabelControl(target.maxHeight)) 

}
/*
def id = delegate.idProperty
def skin = delegate.skinProperty
def style_=(v: String) {
*/