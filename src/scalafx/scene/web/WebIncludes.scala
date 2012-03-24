package scalafx.scene.web

import javafx.scene.{ web => jfxsw }

object WebIncludes extends WebIncludes

trait WebIncludes {
  implicit def jfxHTMLEditor2sfx(he: jfxsw.HTMLEditor) = new HTMLEditor(he)
  implicit def jfxPopupFeatures2sfx(pf: jfxsw.PopupFeatures) = new PopupFeatures(pf)
  implicit def jfxPromptData2sfx(pd: jfxsw.PromptData) = new PromptData(pd)
  implicit def jfxWebEngine2sfx(we: jfxsw.WebEngine) = new WebEngine(we)
  implicit def jfxWebEvent2sfx[T](we: jfxsw.WebEvent[T]) = new WebEvent(we)
  implicit def jfxWebView2sfx(wv: jfxsw.WebView) = new WebView(wv)
}