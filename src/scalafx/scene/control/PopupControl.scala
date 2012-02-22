package scalafx.scene.control

import javafx.scene.{ control => jfxsc }
import scalafx.Includes._
import scalafx.util.SFXDelegate

object PopupControl {
  implicit def sfxPopupControl2jfx(v: PopupControl) = v.delegate
}

// TODO: Make it a PopupWindow subclass.
class PopupControl(override val delegate: jfxsc.PopupControl = new jfxsc.PopupControl) extends SFXDelegate[jfxsc.PopupControl] {

  /**
   * The id of this Node.
   */
  def id = delegate.idProperty
  def id_=(v: String) {
    id = v
  }

  /**
   * Property for overriding the control's computed maximum height.
   */
  def maxHeight = delegate.maxHeightProperty
  def maxHeight_=(v: Double) {
    maxHeight = v
  }

  /**
   * Property for overriding the control's computed maximum width.
   */
  def maxWidth = delegate.maxWidthProperty
  def maxWidth_=(v: Double) {
    maxWidth = v
  }

  /**
   * Property for overriding the control's computed minimum height.
   */
  def minHeight = delegate.minHeightProperty
  def minHeight_=(v: Double) {
    minHeight = v
  }

  /**
   * Property for overriding the control's computed minimum width.
   */
  def minWidth = delegate.minWidthProperty
  def minWidth_=(v: Double) {
    minWidth = v
  }

  /**
   * Property for overriding the control's computed preferred height.
   *
   */
  def prefHeight = delegate.prefHeightProperty
  def prefHeight_=(v: Double) {
    prefHeight = v
  }

  /**
   * Property for overriding the control's computed preferred width.
   */
  def prefWidth = delegate.prefWidthProperty
  def prefWidth_=(v: Double) {
    prefWidth = v
  }

  /**
   * Skin is responsible for rendering this PopupControl.
   */
  def skin = delegate.skinProperty
  def skin_=(v: jfxsc.Skin[_]) {
    skin = v
  }

  /**
   * A string representation of the CSS style associated with this specific Node.
   */
  def style = delegate.styleProperty
  def style_=(v: String) {
    style = v
  }
  
  def styleClass = delegate.getStyleClass

}