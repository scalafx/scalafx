package scalafx.scene.web

import javafx.scene.{ web => jfxsw }
import scalafx.Includes._
import scalafx.util.SFXDelegate

object PopupFeatures {
  implicit def sfxPopupFeatures2jfx(pe: PopupFeatures) = pe.delegate
}

class PopupFeatures(override val delegate: jfxsw.PopupFeatures) extends SFXDelegate[jfxsw.PopupFeatures] {

  /**
   * Creates a new instance.
   */
  def this(menu: Boolean, status: Boolean, toolbar: Boolean, resizable: Boolean) = this(new jfxsw.PopupFeatures(menu, status, toolbar, resizable))

  /**
   * Returns whether menu bar should be present.
   */
  def hasMenu = delegate.hasMenu()

  /**
   * Returns whether status bar should be present.
   */
  def hasStatus = delegate.hasStatus

  /**
   * Returns whether tool bar should be present.
   */
  def hasToolbar = delegate.hasToolbar

  /**
   * Returns whether popup window should be resizable.
   */
  def resizable = delegate.isResizable

}