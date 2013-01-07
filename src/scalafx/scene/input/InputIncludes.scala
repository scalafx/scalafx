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
  implicit def jfxGestureEvent2sfx(ge: jfxsi.GestureEvent) = new GestureEvent(ge)
  implicit def jfxInputEvent2sfx(ie: jfxsi.InputEvent) = new InputEvent(ie)
  implicit def jfxInputMethodEvent2sfx(ime: jfxsi.InputMethodEvent) = new InputMethodEvent(ime)
  implicit def jfxInputMethodHighlight2sfx(e: jfxsi.InputMethodHighlight) = InputMethodHighlight.jfxEnum2sfx(e)
  implicit def jfxInputMethodTextRun2sfx(imtr: jfxsi.InputMethodTextRun) = new InputMethodTextRun(imtr)
  implicit def jfxKeyCombination2sfx(kc: jfxsi.KeyCombination) = new KeyCombination(kc) {}
  implicit def jfxModifierValue2sfx(mv: jfxsi.KeyCombination.ModifierValue) = KeyCombination.ModifierValue.jfxEnum2sfx(mv)
  implicit def jfxKeyCharacterCombination2sfx(kcc: jfxsi.KeyCharacterCombination) = new KeyCharacterCombination(kcc)
  implicit def jfxKeyCode2sfx(e: jfxsi.KeyCode) = KeyCode.jfxEnum2sfx(e)
  implicit def jfxKeyCodeCombination2sfx(kcc: jfxsi.KeyCodeCombination) = new KeyCodeCombination(kcc)
  implicit def jfxKeyCombinationModifier2sfx(m: jfxsi.KeyCombination.Modifier) = new KeyCombination.Modifier(m) {}
  implicit def jfxKeyEvent2sfx(ke: jfxsi.KeyEvent) = new KeyEvent(ke)
  implicit def jfxMnemonic2sfx(m: jfxsi.Mnemonic) = new Mnemonic(m)
  implicit def jfxMouseButton2sfx(e: jfxsi.MouseButton) = MouseButton.jfxEnum2sfx(e)
  implicit def jfxMouseEvent2sfx(me: jfxsi.MouseEvent) = new MouseEvent(me)
  implicit def jfxMouseDragEvent2sfx(mde: jfxsi.MouseDragEvent) = new MouseDragEvent(mde)
  implicit def jfxRotateEvent2sfx(re: jfxsi.RotateEvent) = new RotateEvent(re)
  implicit def jfxScrollEvent2sfx(se: jfxsi.ScrollEvent) = new ScrollEvent(se)
  implicit def jfxSwipeEvent2sfx(se: jfxsi.SwipeEvent) = new SwipeEvent(se)
  implicit def jfxTouchPoint2sfx(tp: jfxsi.TouchPoint) = new TouchPoint(tp)
  implicit def jfxTransferMode2sfx(e: jfxsi.TransferMode) = TransferMode.jfxEnum2sfx(e)
  implicit def jfxZoomEvent2sfx(ze: jfxsi.ZoomEvent) = new ZoomEvent(ze)
}