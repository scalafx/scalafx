/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package scalafx.scene.control

import javafx.scene.{control => jfxsc}

import scalafx.Includes._
import scalafx.util.SFXDelegate
import collection.JavaConversions._

object Accordion {
  implicit def sfxAccordion2jfx(v: Accordion) = v.delegate
}

/*
 - should implement all the JavaFX properties *** FAILED ***
[info]   Missing Properties: expandedPane (PropertyComparator.scala:50)
[info] - should implement all the JavaFX builder properties *** FAILED ***
[info]   Missing Properties: expandedPaneProperty, getExpandedPane, getPanes, setExpandedPane (PropertyComparator.scala:60)
 */
class Accordion(override val delegate:jfxsc.Accordion = new jfxsc.Accordion) extends Control with SFXDelegate[jfxsc.Accordion] {
  
  def expandedPane = delegate.expandedPaneProperty
  def expandedPane_= (v: TitledPane) {
    expandedPane() = v
  }
  
  def panes = delegate.getPanes
  def panes_=(c: Iterable[TitledPane]) {
    panes.setAll(c.map(_.delegate))
  }
  
  
}
