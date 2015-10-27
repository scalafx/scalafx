/*
 * Copyright (c) 2011-2014, ScalaFX Project
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

import javafx.geometry.Rectangle2D
import javafx.scene.{web => jfxsw}
import javafx.{event => jfxe, util => jfxu}

import org.w3c.dom.Document

import scala.language.implicitConversions
import scalafx.Includes._
import scalafx.beans.property._
import scalafx.delegate.SFXDelegate
import scalafx.print.PrinterJob

/**
 * Companion object for [[scalafx.scene.web.WebEngine]]
 */
object WebEngine {

  /**
   * Converts a ScalaFX WebEngine to its JavaFX counterpart.
   *
   * @param we ScalaFX WebEngine
   * @return JavaFX WebEngine
   */
  implicit def sfxWebEngine2jfx(we: WebEngine): jfxsw.WebEngine = if (we != null) we.delegate else null
}

/**
 * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/web/WebEngine.html JavaFX WebEngine]].
 *
 * @constructor Creates a new WebEngine from its JavaFX counterpart.
 * @param delegate A JavaFX WebEngine. Its default value is a new instance.
 */
class WebEngine(override val delegate: jfxsw.WebEngine = new jfxsw.WebEngine)
  extends SFXDelegate[jfxsw.WebEngine] {

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
  def document: Document = delegate.getDocument

  /**
   * URL of the current Web page.
   */
  def location: ReadOnlyStringProperty = delegate.locationProperty

  /**
   * JavaScript alert handler property.
   */
  def onAlert = delegate.onAlertProperty
  def onAlert_=(v: jfxe.EventHandler[jfxsw.WebEvent[String]]) {
    onAlert() = v
  }
  def onAlert_=(handler: WebEvent[String] => Unit) {
    onAlert() = new jfxe.EventHandler[jfxsw.WebEvent[String]] {
      override def handle(event: jfxsw.WebEvent[String]): Unit = handler(event)
    }
  }

  /**
   * The event handler called when an error occurs.
   *
   * @since 8.0
   */
  def onError = delegate.onErrorProperty
  def onError_=(v: jfxe.EventHandler[jfxsw.WebErrorEvent]) {
    onError() = v
  }
  def onError_=(handler: WebErrorEvent => Unit) {
    onError() = new jfxe.EventHandler[jfxsw.WebErrorEvent] {
      override def handle(event: jfxsw.WebErrorEvent): Unit = handler(event)
    }
  }

  /**
   * JavaScript window resize handler property.
   */
  def onResized = delegate.onResizedProperty
  def onResized_=(v: jfxe.EventHandler[jfxsw.WebEvent[Rectangle2D]]) {
    onResized() = v
  }
  def onResized_=(handler: WebEvent[Rectangle2D] => Unit): Unit = {
    onResized() = new jfxe.EventHandler[jfxsw.WebEvent[Rectangle2D]] {
      override def handle(event: jfxsw.WebEvent[Rectangle2D]): Unit = handler(event)
    }
  }

  /**
   * JavaScript status handler property.
   */
  def onStatusChanged = delegate.onStatusChangedProperty
  def onStatusChanged_=(v: jfxe.EventHandler[jfxsw.WebEvent[String]]) {
    onStatusChanged() = v
  }
  def onStatusChanged_=(handler: WebEvent[String] => Unit) {
    onStatusChanged() = new jfxe.EventHandler[jfxsw.WebEvent[String]] {
      override def handle(event: jfxsw.WebEvent[String]): Unit = handler(event)
    }
  }

  /**
   * JavaScript window visibility handler property.
   */
  def onVisibilityChanged = delegate.onVisibilityChangedProperty
  def onVisibilityChanged_=(v: jfxe.EventHandler[jfxsw.WebEvent[java.lang.Boolean]]) {
    onVisibilityChanged() = v
  }
  def onVisibilityChanged_=(handler: WebEvent[java.lang.Boolean] => Unit) {
    onVisibilityChanged() = new jfxe.EventHandler[jfxsw.WebEvent[java.lang.Boolean]] {
      override def handle(event: jfxsw.WebEvent[java.lang.Boolean]): Unit = handler(event)
    }
  }

  /**
   * JavaScript prompt handler property.
   */
  def promptHandler = delegate.promptHandlerProperty
  def promptHandler_=(f: PromptData => String) {
    promptHandler() = new jfxu.Callback[jfxsw.PromptData, String] {
      def call(pd: jfxsw.PromptData) = f(pd)
    }
  }

  /**
   * JavaScript enabled handler property.
   *
   * @since 2.2
   */
  def javaScriptEnabled: BooleanProperty = delegate.javaScriptEnabledProperty
  def javaScriptEnabled_=(v: Boolean) {
    javaScriptEnabled() = v
  }

  /**
   * Specifies the directory to be used by this WebEngine to store local user data.
   *
   * @since 8.0
   */
  def userDataDirectory: ObjectProperty[java.io.File] = delegate.userDataDirectoryProperty
  def userDataDirectory_=(v: java.io.File) {
    ObjectProperty.fillProperty[java.io.File](this.userDataDirectory, v)
  }

  /**
   * JavaScript enabled handler property.
   *
   * @since 2.2
   */
  def userStyleSheetLocation: StringProperty = delegate.userStyleSheetLocationProperty
  def userStyleSheetLocation_=(v: String) {
    userStyleSheetLocation() = v
  }

  /**
   * Title of the current Web page.
   */
  def title: ReadOnlyStringProperty = delegate.titleProperty

  /**
   * Loads a Web page into this engine.
   */
  def load(url: String) {
    delegate.load(url)
  }

  /**
   * Loads the given HTML content directly.
   */
  def loadContent(content: String) {
    delegate.loadContent(content)
  }

  /**
   * Loads the given content directly.
   */
  def loadContent(content: String, contentType: String) {
    delegate.loadContent(content, contentType)
  }

  /**
   * Specifies user agent ID string.
   *
   * @since 8.0
   */
  def userAgent: StringProperty = delegate.userAgentProperty
  def userAgent_=(v: String) {
    userAgent() = v
  }

  /**
   * Prints the content of the editor using the given printer job.
   *
   * @param job printer job used for printing
   * @since 8.0
   */
  def print(job: PrinterJob): Unit = delegate.print(job)

}
