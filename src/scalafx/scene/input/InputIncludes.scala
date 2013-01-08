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
package scalafx.scene.input

import javafx.scene.{ input => jfxsi }
import scalafx.delegate.SFXDelegate

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
  implicit def jfxScrollEventHorizontalTextScrollUnits2sfx(h: jfxsi.ScrollEvent.HorizontalTextScrollUnits) = ScrollEvent.HorizontalTextScrollUnits.jfxEnum2sfx(h)
  implicit def jfxScrollEventVerticalTextScrollUnits2sfx(v: jfxsi.ScrollEvent.VerticalTextScrollUnits) = ScrollEvent.VerticalTextScrollUnits.jfxEnum2sfx(v)
  implicit def jfxSwipeEvent2sfx(se: jfxsi.SwipeEvent) = new SwipeEvent(se)
  implicit def jfxTouchPoint2sfx(tp: jfxsi.TouchPoint) = new TouchPoint(tp)
  implicit def jfxTouchPointState2sfx(s: jfxsi.TouchPoint.State) = TouchPoint.State.jfxEnum2sfx(s)
  implicit def jfxTransferMode2sfx(e: jfxsi.TransferMode) = TransferMode.jfxEnum2sfx(e)
  implicit def jfxZoomEvent2sfx(ze: jfxsi.ZoomEvent) = new ZoomEvent(ze)
}