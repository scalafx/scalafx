/*
 * Copyright (c) 2012, ScalaFX Project
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of the ScalaFX Project nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE SCALAFX PROJECT OR ITS CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
 * AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
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
   * JavaScript enabled handler property.
   *
   * @since 2.2
   */
  def javaScriptEnabled = delegate.javaScriptEnabledProperty
  def javaScriptEnabled_=(v: Boolean) {
    javaScriptEnabled() = v
  }

  /**
   * JavaScript enabled handler property.
   *
   * @since 2.2
   */
  def userStyleSheetLocation = delegate.userStyleSheetLocationProperty
  def userStyleSheetLocation_=(v: String) {
    userStyleSheetLocation() = v
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
