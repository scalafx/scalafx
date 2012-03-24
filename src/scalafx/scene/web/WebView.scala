package scalafx.scene.web

import javafx.scene.{ web => jfxsw }
import scalafx.Includes._
import scalafx.util.SFXDelegate
import scalafx.scene.Parent

object WebView {
  implicit def sfxWebView2jfx(wv: WebView) = wv.delegate
}

class WebView(override val delegate: jfxsw.WebView = new jfxsw.WebView) extends Parent(delegate) with SFXDelegate[jfxsw.WebView] {

  /**
   * Scale factor applied to font.
   */
  def fontScale = delegate.fontScaleProperty
  def fontScale_=(v: Double) {
    fontScale() = v
  }

  /**
   * Height of this WebView.
   */
  def height = delegate.heightProperty

  /**
   * Maximum height property.
   */
  def maxHeight = delegate.maxHeightProperty
  def maxHeight_=(v: Double) {
    maxHeight() = v
  }

  /**
   * Maximum width property.
   */
  def maxWidth = delegate.maxWidthProperty
  def maxWidth_=(v: Double) {
    maxWidth() = v
  }

  /**
   * Minimum height property.
   */
  def minHeight = delegate.minHeightProperty
  def minHeight_=(v: Double) {
    minHeight() = v
  }

  /**
   * Minimum width property.
   */
  def minWidth = delegate.minWidthProperty
  def minWidth_=(v: Double) {
    minWidth() = v
  }

  /**
   * Preferred height property.
   */
  def prefHeight = delegate.prefHeightProperty
  def prefHeight_=(v: Double) {
    prefHeight() = v
  }

  /**
   * Preferred width property.
   */
  def prefWidth = delegate.prefWidthProperty
  def prefWidth_=(v: Double) {
    prefWidth() = v
  }

  /**
   * Width of this WebView.
   */
  def width = delegate.widthProperty

}