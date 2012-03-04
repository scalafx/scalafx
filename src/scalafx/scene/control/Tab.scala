package scalafx.scene.control

import javafx.scene.{ control => jfxsc }
import javafx.{ event => jfxe }
import scalafx.Includes._
import scalafx.scene.Node._
import scalafx.scene.Node
import scalafx.util.SFXDelegate

object Tab {

  implicit def sfxTab2jfx(v: Tab) = v.delegate

}

class Tab(override val delegate: jfxsc.Tab = new jfxsc.Tab) extends SFXDelegate[jfxsc.Tab] {

  /**
   * The closable state for this tab.
   */
  def closable = delegate.closableProperty
  def closable_=(v: Boolean) {
    closable() = v
  }

  /**
   * The content associated with the tab.
   */
  def content = delegate.contentProperty
  def content_=(v: Node) {
    content() = v
  }

  /**
   * The context menu associated with the tab.
   */
  def contextMenu = delegate.contextMenuProperty
  def contextMenu_=(v: jfxsc.ContextMenu) {
    contextMenu() = v
  }

  /**
   * The graphic in the tab.
   */
  def graphic = delegate.graphicProperty
  def graphic_=(v: Node) {
    graphic() = v
  }

  /**
   * The id of this tab.
   */
  def id = delegate.idProperty
  def id_=(v: String) {
    id() = v
  }

  /**
   * The event handler that is associated with the tab when the tab is closed.
   */
  def onClosed = delegate.onClosedProperty
  def onClosed_=(v: jfxe.EventHandler[jfxe.Event]) {
    onClosed() = v
  }

  /**
   * The event handler that is associated with a selection on the tab.
   */
  def onSelectionChanged = delegate.onSelectionChangedProperty
  def onSelectionChanged_=(v: jfxe.EventHandler[jfxe.Event]) {
    onSelectionChanged() = v
  }

  /**
   * The currently selected tab.
   */
  def selected = delegate.selectedProperty

  /**
   * The CSS style string associated to this tab.
   */
  def style = delegate.styleProperty
  def style_=(v: String) {
    style() = v
  }

  def styleClass = delegate.getStyleClass

  /**
   * The TabPane that contains this tab.
   */
  def tabPane = delegate.tabPaneProperty

  /**
   * The text shown in the tab.
   */
  def text = delegate.textProperty
  def text_=(v: String) {
    text() = v
  }

  /**
   * The tooltip associated with this tab.
   */
  def tooltip = delegate.tooltipProperty
  def tooltip_=(v: Tooltip) {
    tooltip() = v
  }

}
