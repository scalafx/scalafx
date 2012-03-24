package scalafx.scene.web

import javafx.scene.{ web => jfxsw }
import scalafx.Includes._
import scalafx.util.SFXDelegate
import scalafx.scene.control.Control

object HTMLEditor {
  implicit def sfxHTMLEditor2jfx(he: HTMLEditor) = he.delegate
}

class HTMLEditor(override val delegate: jfxsw.HTMLEditor = new jfxsw.HTMLEditor) extends Control(delegate) with SFXDelegate[jfxsw.HTMLEditor] {

  /**
   * Returns the HTML content of the editor.
   */
  def htmlText = delegate.getHtmlText
  def htmlText_=(htmlText: String) {
    delegate.setHtmlText(htmlText)
  }

}