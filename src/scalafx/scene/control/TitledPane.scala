/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package scalafx.scene.control

import javafx.scene.{ control => jfxsc }
import scalafx.Includes._
import scalafx.util.SFXDelegate
import scalafx.scene._
import javafx.beans.property.BooleanProperty

object TitledPane {
  implicit def sfxTitledPane2jfx(v: TitledPane) = v.delegate
}

class TitledPane(override val delegate: jfxsc.TitledPane = new jfxsc.TitledPane)
  extends Labeled(delegate)
  with SFXDelegate[jfxsc.TitledPane] {

  def animated: BooleanProperty = delegate.animatedProperty
  def animated_=(v: Boolean) {
    animated() = v
  }

  def collapsible: BooleanProperty = delegate.collapsibleProperty
  def collapsible_=(v: Boolean) {
    collapsible() = v
  }

  def content = delegate.contentProperty
  def content_=(v: Node) {
    content() = v
  }

  def expanded: BooleanProperty = delegate.expandedProperty
  def expanded_=(v: Boolean) {
    expanded() = v
  }
}
