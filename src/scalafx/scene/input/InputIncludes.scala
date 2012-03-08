package scalafx.scene.input

import javafx.scene.{ input => jfxsi }
import scalafx.util.SFXDelegate

object InputIncludes extends InputIncludes

trait InputIncludes {
  implicit def jfxClipboard2sfx(c: jfxsi.Clipboard) = new Clipboard(c)
  implicit def jfxClipboardContent2sfx(c: jfxsi.ClipboardContent) = new ClipboardContent(c)
  implicit def jfxDataFormat2sfx(df: jfxsi.DataFormat) = new DataFormat(df)
  implicit def jfxInputEvent2sfx(ie: jfxsi.InputEvent) = new InputEvent(ie)
}