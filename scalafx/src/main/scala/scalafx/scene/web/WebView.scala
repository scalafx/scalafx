/*
 * Copyright (c) 2011-2019, ScalaFX Project
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

import javafx.scene.{text => jfxst, web => jfxsw}
import javafx.{css => jfxc, event => jfxe, geometry => jfxg, util => jfxu}
import scalafx.Includes._
import scalafx.beans.property._
import scalafx.delegate.SFXDelegate
import scalafx.scene.Parent
import scalafx.scene.text.FontSmoothingType

import scala.collection.JavaConverters._
import scala.collection.mutable
import scala.language.implicitConversions

/**
  * Companion object for [[scalafx.scene.web.WebView]]
  */
object WebView {

  /**
    * Converts a ScalaFX WebView to its JavaFX counterpart.
    *
    * @param wv ScalaFX WebView
    * @return JavaFX WebView
    */
  implicit def sfxWebView2jfx(wv: WebView): jfxsw.WebView = if (wv != null) wv.delegate else null

  /**
    * @return The CssMetaData associated with this class, which may include the CssMetaData of its
    *         super classes.
    * @since 8.0
    */
  def classCssMetaData: mutable.Buffer[jfxc.CssMetaData[_ <: jfxc.Styleable, _]] =
    jfxsw.WebView.getClassCssMetaData.asScala

}

/**
  * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/web/WebView.html JavaFX WebView]].
  *
  * @constructor Creates a new WebView from its JavaFX counterpart.
  * @param delegate A JavaFX WebView. Its default value is a new instance.
  */
class WebView(override val delegate: jfxsw.WebView = new jfxsw.WebView)
    extends Parent(delegate)
    with SFXDelegate[jfxsw.WebView] {

  /**
    * Scale factor applied to font.
    */
  def fontScale: DoubleProperty = delegate.fontScaleProperty

  def fontScale_=(v: Double): Unit = {
    fontScale() = v
  }

  /**
    * Height of this WebView.
    */
  def height: ReadOnlyDoubleProperty = delegate.heightProperty

  /**
    * Maximum height property.
    */
  def maxHeight: DoubleProperty = delegate.maxHeightProperty

  def maxHeight_=(v: Double): Unit = {
    maxHeight() = v
  }

  /**
    * Maximum width property.
    */
  def maxWidth: DoubleProperty = delegate.maxWidthProperty

  def maxWidth_=(v: Double): Unit = {
    maxWidth() = v
  }

  /**
    * Minimum height property.
    */
  def minHeight: DoubleProperty = delegate.minHeightProperty

  def minHeight_=(v: Double): Unit = {
    minHeight() = v
  }

  /**
    * Minimum width property.
    */
  def minWidth: DoubleProperty = delegate.minWidthProperty

  def minWidth_=(v: Double): Unit = {
    minWidth() = v
  }

  /**
    * Preferred height property.
    */
  def prefHeight: DoubleProperty = delegate.prefHeightProperty

  def prefHeight_=(v: Double): Unit = {
    prefHeight() = v
  }

  /**
    * Preferred width property.
    */
  def prefWidth: DoubleProperty = delegate.prefWidthProperty

  def prefWidth_=(v: Double): Unit = {
    prefWidth() = v
  }

  /**
    * Width of this WebView.
    */
  def width: ReadOnlyDoubleProperty = delegate.widthProperty

  // Indirect WebEngine methods / properties.

  def engine: WebEngine = delegate.getEngine

  /**
    * JavaScript confirm handler property.
    */
  def confirmHandler: ObjectProperty[jfxu.Callback[String, java.lang.Boolean]] = delegate.engine.confirmHandler

  def confirmHandler_=(f: String => Boolean): Unit = {
    delegate.engine.confirmHandler = f
  }

  /**
    * JavaScript popup handler property.
    */
  def createPopupHandler: ObjectProperty[jfxu.Callback[jfxsw.PopupFeatures, jfxsw.WebEngine]] =
    delegate.engine.createPopupHandler

  def createPopupHandler_=(f: jfxsw.PopupFeatures => WebEngine): Unit = {
    delegate.engine.createPopupHandler = f
  }

  /**
    * URL of the current Web page.
    */
  def location: ReadOnlyStringProperty = delegate.engine.location

  /**
    * JavaScript alert handler property.
    */
  def onAlert: ObjectProperty[jfxe.EventHandler[jfxsw.WebEvent[String]]] = delegate.engine.onAlert

  def onAlert_=(v: jfxe.EventHandler[jfxsw.WebEvent[String]]): Unit = {
    delegate.engine.onAlert = v
  }

  /**
    * JavaScript window resize handler property.
    */
  def onResized: ObjectProperty[jfxe.EventHandler[jfxsw.WebEvent[jfxg.Rectangle2D]]] = delegate.engine.onResized

  def onResized_=(v: jfxe.EventHandler[jfxsw.WebEvent[jfxg.Rectangle2D]]): Unit = {
    delegate.engine.onResized = v
  }

  /**
    * JavaScript status handler property.
    */
  def onStatusChanged: ObjectProperty[jfxe.EventHandler[jfxsw.WebEvent[String]]] = delegate.engine.onStatusChanged

  def onStatusChanged_=(v: jfxe.EventHandler[jfxsw.WebEvent[String]]): Unit = {
    delegate.engine.onStatusChanged = v
  }

  /**
    * JavaScript window visibility handler property.
    */
  def onVisibilityChanged: ObjectProperty[jfxe.EventHandler[jfxsw.WebEvent[java.lang.Boolean]]] =
    delegate.engine.onVisibilityChanged

  def onVisibilityChanged_=(v: jfxe.EventHandler[jfxsw.WebEvent[java.lang.Boolean]]): Unit = {
    delegate.engine.onVisibilityChanged = v
  }

  /**
    * JavaScript prompt handler property.
    */
  def promptHandler: ObjectProperty[jfxu.Callback[jfxsw.PromptData, String]] = delegate.engine.promptHandler

  def promptHandler_=(f: PromptData => String): Unit = {
    delegate.engine.promptHandler = f
  }

  /**
    * Specifies whether context menu is enabled.
    *
    * @since 2.2
    */
  def contextMenuEnabled: BooleanProperty = delegate.contextMenuEnabledProperty

  def contextMenuEnabled_=(v: Boolean): Unit = {
    contextMenuEnabled() = v
  }

  /**
    * Specifies a requested font smoothing type : gray or LCD.
    * The width of the bounding box is defined by the widest row. Note: LCD mode doesn't apply in numerous cases,
    * such as various compositing modes, where effects are applied and very large glyphs.
    *
    * @since 2.2
    */
  def fontSmoothingType: ObjectProperty[jfxst.FontSmoothingType] = delegate.fontSmoothingTypeProperty

  def fontSmoothingType_=(v: FontSmoothingType): Unit = {
    ObjectProperty.fillProperty[jfxst.FontSmoothingType](fontSmoothingType, v)
  }

  /**
    * Zoom property object.
    *
    * @since 8.0
    */
  def zoom: DoubleProperty = delegate.zoomProperty

  def zoom_=(v: Double): Unit = {
    zoom() = v
  }

}
