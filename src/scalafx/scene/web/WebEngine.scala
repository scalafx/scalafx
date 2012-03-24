package scalafx.scene.web

import javafx.{ event => jfxe }
import javafx.scene.{ web => jfxsw }
import javafx.{ util => jfxu }
import scalafx.Includes._
import javafx.geometry.Rectangle2D
import scalafx.util.SFXDelegate

object WebEngine {
  implicit def sfxWebEngine2jfx(we: WebEngine) = we.delegate
}

class WebEngine(override val delegate: jfxsw.WebEngine = new jfxsw.WebEngine) extends SFXDelegate[jfxsw.WebEngine] {

  /**
   * Creates a new engine and loads a Web page into it.
   */
  def this(url: String) = this(new jfxsw.WebEngine(url))

  /**
   * JavaScript confirm handler property.
   */
  def confirmHandler = delegate.confirmHandlerProperty
  def confirmHandler_=(f: String => Boolean) {
    confirmHandler() = new jfxu.Callback[java.lang.String, java.lang.Boolean] {
      def call(msg: java.lang.String) = f(msg)
    }
  }

  /**
   * JavaScript popup handler property.
   */
  def createPopupHandler = delegate.createPopupHandlerProperty
  def createPopupHandler_=(f: jfxsw.PopupFeatures => WebEngine) {
    createPopupHandler() = new jfxu.Callback[jfxsw.PopupFeatures, jfxsw.WebEngine] {
      def call(pf: jfxsw.PopupFeatures) = f(pf)
    }
  }

  /**
   * Document object for the current Web page.
   */
  def document = delegate.getDocument

  /**
   * URL of the current Web page.
   */
  def location = delegate.getLocation

  /**
   * JavaScript alert handler property.
   */
  def onAlert = delegate.onAlertProperty
  def onAlert_=(v: jfxe.EventHandler[jfxsw.WebEvent[String]]) {
    onAlert() = v
  }

  /**
   * JavaScript window resize handler property.
   */
  def onResized = delegate.onResizedProperty
  def onResized_=(v: jfxe.EventHandler[jfxsw.WebEvent[Rectangle2D]]) {
    onResized() = v
  }

  /**
   * JavaScript status handler property.
   */
  def onStatusChanged = delegate.onStatusChangedProperty
  def onStatusChanged_=(v: jfxe.EventHandler[jfxsw.WebEvent[String]]) {
    onStatusChanged() = v
  }

  /**
   * JavaScript window visibility handler property.
   */
  def onVisibilityChanged = delegate.onVisibilityChangedProperty
  def onVisibilityChanged_=(v: jfxe.EventHandler[jfxsw.WebEvent[java.lang.Boolean]]) {
    onVisibilityChanged() = v
  }

  /**
   * JavaScript prompt handler property.
   */
  def promptHandler = delegate.promptHandlerProperty
  def promptHandler_=(f: jfxsw.PromptData => String) {
    promptHandler() = new jfxu.Callback[jfxsw.PromptData, String] {
      def call(pd: jfxsw.PromptData) = f(pd)
    }
  }

  /**
   * Title of the current Web page.
   */
  def title = delegate.getTitle

  /**
   * Loads a Web page into this engine.
   */
  def load(url: String) = delegate.load(url)

  /**
   * Loads the given HTML content directly.
   */
  def loadContent(content: String) = delegate.loadContent(content)

  /**
   * Loads the given content directly.
   */
  def loadContent(content: String, contentType: String) = delegate.loadContent(content, contentType)

}
