package scalafx.scene.control

import javafx.scene.control.ContentDisplay
import javafx.scene.control.OverrunStyle
import javafx.scene.text.TextAlignment
import javafx.scene.{ control => jfxsc }
import scalafx.Includes.jfxBooleanProperty2sfx
import scalafx.Includes.jfxDoubleProperty2sfx
import scalafx.Includes.jfxObjectProperty2sfx
import scalafx.Includes.jfxStringProperty2sfx
import scalafx.scene.Node.sfxNode2jfx
import scalafx.scene.text.Font.sfxFont2jfx
import scalafx.scene.text.Font
import scalafx.scene.Node
import scalafx.util.SFXDelegate

object Tooltip {

  implicit def sfxTooltip2jfx(v: Tooltip) = v.delegate

  def apply(string: String) = new Tooltip {
    text = string
  }

  /**
   * Generates a Simple Tooltip with defaul properties from a text.
   *
   * @param string Tooltip's text.
   */
  implicit def stringToTooltip(string: String) = new Tooltip {
    text() = string
  }

  class TooltipInstaller(node: Node) {

    /**
     * Associates the given Tooltip with a given Node. The tooltip can then behave similar to when it is set on any Control.
     * A single tooltip can be associated with multiple nodes.
     */
    def installTooltip(tooltip: Tooltip) {
      jfxsc.Tooltip.install(node, tooltip)
    }

    /**
     * Removes the association of the given Tooltip on a specified Node. Hence hovering on the node will no longer result in showing of the tooltip.
     */
    def uninstallTooltip(tooltip: Tooltip) {
      jfxsc.Tooltip.uninstall(node, tooltip)
    }

  }

  implicit def nodeToTooltipInstaller(node: Node) = new TooltipInstaller(node)
}

class Tooltip(override val delegate: jfxsc.Tooltip = new jfxsc.Tooltip) extends PopupControl(delegate) with SFXDelegate[jfxsc.Tooltip] {

  /**
   * Typically, the tooltip is "activated" when the mouse moves over a Control.
   */
  def activated = delegate.activatedProperty

  /**
   * Specifies the positioning of the graphic relative to the text.
   */
  def contentDisplay = delegate.contentDisplayProperty
  def contentDisplay_=(v: ContentDisplay) {
    contentDisplay() = v
  }

  /**
   * The default font to use for text in the Tooltip.
   */
  def font = delegate.fontProperty
  def font_=(v: Font) {
    font() = v
  }

  /**
   * An optional icon for the Tooltip.
   */
  def graphic = delegate.graphicProperty
  def graphic_=(v: Node) {
    graphic() = v
  }

  /**
   * The amount of space between the graphic and text
   */
  def graphicTextGap = delegate.graphicTextGapProperty
  def graphicTextGap_=(v: Double) {
    graphicTextGap() = v
  }

  /**
   * Specifies the behavior for lines of text when text is multiline Unlike contentDisplay which affects the graphic and text,
   * this setting only affects multiple lines of text relative to the text bounds.
   */
  def textAlignment = delegate.textAlignmentProperty
  def textAlignment_=(v: TextAlignment) {
    textAlignment() = v
  }

  /**
   * Specifies the behavior to use if the text of the Tooltip exceeds the available space for rendering the text.
   */
  def textOverrun = delegate.textOverrunProperty
  def textOverrun_=(v: OverrunStyle) {
    textOverrun() = v
  }

  /**
   * The text to display in the tooltip.
   */
  def text = delegate.textProperty
  def text_=(v: String) {
    text() = v
  }

  /**
   * If a run of text exceeds the width of the Tooltip, then this variable indicates whether the text should wrap onto another line.
   */
  def wrapText = delegate.wrapTextProperty
  def wrapText_=(v: Boolean) {
    wrapText() = v
  }

}