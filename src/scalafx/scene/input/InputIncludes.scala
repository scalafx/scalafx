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
  implicit def jfxKeyCombination2sfx(kc: jfxsi.KeyCombination) = new KeyCombination(kc) {}  
  implicit def jfxKeyCharacterCombination2sfx(kcc: jfxsi.KeyCharacterCombination) = new KeyCharacterCombination(kcc) 
  implicit def jfxKeyCodeCombination2sfx(kcc: jfxsi.KeyCodeCombination) = new KeyCodeCombination(kcc)  
  implicit def jfxKeyCombinationModifier2sfx(m: jfxsi.KeyCombination.Modifier) = new KeyCombination.Modifier(m) {}
  implicit def jfxKeyEvent2sfx(ke: jfxsi.KeyEvent) = new KeyEvent(ke)
  implicit def jfxMnemonic2sfx(m: jfxsi.Mnemonic) = new Mnemonic(m)
  implicit def jfxMouseEvent2sfx(me: jfxsi.MouseEvent) = new MouseEvent(me)
  implicit def jfxMouseDragEvent2sfx(mde: jfxsi.MouseDragEvent) = new MouseDragEvent(mde)
  implicit def jfxScrollEvent2sfx(se: jfxsi.ScrollEvent) = new ScrollEvent(se)
}