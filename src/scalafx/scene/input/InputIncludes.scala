package scalafx.scene.input

import javafx.scene.{ input => jfxsi }
import scalafx.util.SFXDelegate

object InputIncludes extends InputIncludes

trait InputIncludes {
  implicit def jfxClipboard2sfx(c: jfxsi.Clipboard) = new Clipboard(c)
  implicit def jfxClipboardContent2sfx(c: jfxsi.ClipboardContent) = new ClipboardContent(c)
  implicit def jfxContextMenuEvent2sfx(c: jfxsi.ContextMenuEvent) = new ContextMenuEvent(c)
  implicit def jfxDataFormat2sfx(df: jfxsi.DataFormat) = new DataFormat(df)
  implicit def jfxDragboard2sfx(d: jfxsi.Dragboard) = new Dragboard(d)
  implicit def jfxDragEvent2sfx(de: jfxsi.DragEvent) = new DragEvent(de)
  implicit def jfxInputEvent2sfx(ie: jfxsi.InputEvent) = new InputEvent(ie)
  implicit def jfxInputMethodEvent2sfx(ime: jfxsi.InputMethodEvent) = new InputMethodEvent(ime)
  implicit def jfxInputMethodTextRun2sfx(imtr: jfxsi.InputMethodTextRun) = new InputMethodTextRun(imtr)
  implicit def jfxMouseEvent2sfx(me: jfxsi.MouseEvent) = new MouseEvent(me)
}