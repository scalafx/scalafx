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
package scalafx.scene.input

import javafx.scene.{input => jfxsi}
import javafx.{event => jfxe}

import scala.language.implicitConversions
import scalafx.scene.input.KeyCombination.{Modifier, ModifierValue}
import scalafx.scene.input.ScrollEvent.{HorizontalTextScrollUnits, VerticalTextScrollUnits}
import scalafx.scene.input.TouchPoint.State

object InputIncludes extends InputIncludes

/**
 * Contains implcit methods to convert from
 * [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/input/package-summary.html`javafx.scene.input`]]
 * Classes/Traits to their $SFX counterparts.
 *
 * @define
 *   JFX JavaFX
 * @define
 *   SFX ScalaFX
 * @define
 *   START Converts a $JFX `[[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/input/
 * @define
 *   END ]]` instance to its $SFX counterpart.
 * @define
 *   BEGINWR Converts a Function that manipulates a $SFX [[scalafx.scene.input.@ d e f i n e F I N I S H W R]] and
 *   returns a [[http://www.scala-lang.org/api/current/scala/Any.htmlscala.Any]] into a $JFX's
 *   [[http://docs.oracle.com/javase/8/javafx/api/javafx/event/EventHandler.htmlEventHandler]] that manipulates it's
 *   $JFX counterpart.
 * @define
 *   PARAMWR function that manipulates a $SFX's
 * @define
 *   RETWR A $JFX's EventHandler that manipulates a $JFX's
 *
 * @define
 *   CLIP Clipboard
 * @define
 *   CLCT ClipboardContent
 * @define
 *   CMEV ContextMenuEvent
 * @define
 *   DTFM DataFormat
 * @define
 *   DRGB Dragboard
 * @define
 *   DREV DragEvent
 * @define
 *   GTEV GestureEvent
 * @define
 *   IPEV InputEvent
 * @define
 *   IMEV InputMethodEvent
 * @define
 *   IMHL InputMethodHighlight
 * @define
 *   IMTR InputMethodTextRun
 * @define
 *   KYCB KeyCombination
 * @define
 *   KCMV KeyCombination.ModifierValue
 * @define
 *   KCCB KeyCharacterCombination
 * @define
 *   KYCD KeyCode
 * @define
 *   KCCM KeyCodeCombination
 * @define
 *   KCMD KeyCombination.Modifier
 * @define
 *   KEEV KeyEvent
 * @define
 *   MNMC Mnemonic
 * @define
 *   MSBT MouseButton
 * @define
 *   MSEV MouseEvent
 * @define
 *   MSDE MouseDragEvent
 * @define
 *   RTEV RotateEvent
 * @define
 *   SCEV ScrollEvent
 * @define
 *   SEHS ScrollEvent.HorizontalTextScrollUnits
 * @define
 *   SEVS ScrollEvent.VerticalTextScrollUnits
 * @define
 *   SWEV SwipeEvent
 * @define
 *   TCEV TouchEvent
 * @define
 *   TCPT TouchPoint
 * @define
 *   TPST TouchPoint.State
 * @define
 *   TRMD TransferMode
 * @define
 *   ZMEV ZoomEvent
 */
trait InputIncludes {

  /**
   * $START$CLIP.html $CLIP$END
   *
   * @param c
   *   $JFX $CLIP
   * @return
   *   $SFX $CLIP
   */
  implicit def jfxClipboard2sfx(c: jfxsi.Clipboard): Clipboard = if (c != null) new Clipboard(c) else null

  /**
   * $START$CLCT.html $CLCT$END
   *
   * @param c
   *   $JFX $CLCT
   * @return
   *   $SFX $CLCT
   */
  implicit def jfxClipboardContent2sfx(c: jfxsi.ClipboardContent): ClipboardContent =
    if (c != null) new ClipboardContent(c) else null

  /**
   * $START$CMEV.html $CMEV$END
   *
   * @param c
   *   $JFX $CMEV
   * @return
   *   $SFX $CMEV
   */
  implicit def jfxContextMenuEvent2sfx(c: jfxsi.ContextMenuEvent): ContextMenuEvent =
    if (c != null) new ContextMenuEvent(c) else null

  /**
   * $START$DTFM.html $DTFM$END
   *
   * @param df
   *   $JFX $DTFM
   * @return
   *   $SFX $DTFM
   */
  implicit def jfxDataFormat2sfx(df: jfxsi.DataFormat): DataFormat = if (df != null) new DataFormat(df) else null

  /**
   * $START$DRGB.html $DRGB$END
   *
   * @param d
   *   $JFX $DRGB
   * @return
   *   $SFX $DRGB
   */
  implicit def jfxDragboard2sfx(d: jfxsi.Dragboard): Dragboard = if (d != null) new Dragboard(d) else null

  /**
   * $START$DREV.html $DREV$END
   *
   * @param de
   *   $JFX $DREV
   * @return
   *   $SFX $DREV
   */
  implicit def jfxDragEvent2sfx(de: jfxsi.DragEvent): DragEvent = if (de != null) new DragEvent(de) else null

  /**
   * $START$GTEV.html $GTEV$END
   *
   * @param ge
   *   $JFX $GTEV
   * @return
   *   $SFX $GTEV
   */
  implicit def jfxGestureEvent2sfx(ge: jfxsi.GestureEvent): GestureEvent =
    if (ge != null) new GestureEvent(ge) else null

  /**
   * $START$IPEV.html $IPEV$END
   *
   * @param ie
   *   $JFX $IPEV
   * @return
   *   $SFX $IPEV
   */
  implicit def jfxInputEvent2sfx(ie: jfxsi.InputEvent): InputEvent = if (ie != null) new InputEvent(ie) else null

  /**
   * $START$IMEV.html $IMEV$END
   *
   * @param ime
   *   $JFX $IMEV
   * @return
   *   $SFX $IMEV
   */
  implicit def jfxInputMethodEvent2sfx(ime: jfxsi.InputMethodEvent): InputMethodEvent =
    if (ime != null) new InputMethodEvent(ime) else null

  /**
   * $START$IMHL.html $IMHL$END
   *
   * @param e
   *   $JFX $IMHL
   * @return
   *   $SFX $IMHL
   */
  implicit def jfxInputMethodHighlight2sfx(e: jfxsi.InputMethodHighlight): InputMethodHighlight =
    InputMethodHighlight.jfxEnum2sfx(e)

  /**
   * $START$IMTR.html $IMTR$END
   *
   * @param imtr
   *   $JFX $IMTR
   * @return
   *   $SFX $IMTR
   */
  implicit def jfxInputMethodTextRun2sfx(imtr: jfxsi.InputMethodTextRun): InputMethodTextRun =
    if (imtr != null) new InputMethodTextRun(imtr) else null

  /**
   * $START$KYCB.html $KYCB$END
   *
   * @param kc
   *   $JFX $KYCB
   * @return
   *   $SFX $KYCB
   */
  implicit def jfxKeyCombination2sfx(kc: jfxsi.KeyCombination): KeyCombination = if (kc != null)
    new KeyCombination(kc) {}
  else null

  /**
   * $START$KCMV.html $KCMV$END
   *
   * @param mv
   *   $JFX $KCMV
   * @return
   *   $SFX $KCMV
   */
  implicit def jfxModifierValue2sfx(mv: jfxsi.KeyCombination.ModifierValue): ModifierValue =
    KeyCombination.ModifierValue.jfxEnum2sfx(mv)

  /**
   * $START$KCCB.html $KCCB$END
   *
   * @param kcc
   *   $JFX $KCCB
   * @return
   *   $SFX $KCCB
   */
  implicit def jfxKeyCharacterCombination2sfx(kcc: jfxsi.KeyCharacterCombination): KeyCharacterCombination =
    if (kcc != null) new KeyCharacterCombination(kcc) else null

  /**
   * $START$KYCD.html $KYCD$END
   *
   * @param e
   *   $JFX $KYCD
   * @return
   *   $SFX $KYCD
   */
  implicit def jfxKeyCode2sfx(e: jfxsi.KeyCode): KeyCode = KeyCode.jfxEnum2sfx(e)

  /**
   * $START$KCCM.html $KCCM$END
   *
   * @param kcc
   *   $JFX $KCCM
   * @return
   *   $SFX $KCCM
   */
  implicit def jfxKeyCodeCombination2sfx(kcc: jfxsi.KeyCodeCombination): KeyCodeCombination =
    if (kcc != null) new KeyCodeCombination(kcc) else null

  /**
   * $START$KCMD.html $KCMD$END
   *
   * @param m
   *   $JFX $KCMD
   * @return
   *   $SFX $KCMD
   */
  implicit def jfxKeyCombinationModifier2sfx(m: jfxsi.KeyCombination.Modifier): Modifier = if (m != null)
    new KeyCombination.Modifier(m) {}
  else null

  /**
   * $START$KEEV.html $KEEV$END
   *
   * @param ke
   *   $JFX $KEEV
   * @return
   *   $SFX $KEEV
   */
  implicit def jfxKeyEvent2sfx(ke: jfxsi.KeyEvent): KeyEvent = if (ke != null) new KeyEvent(ke) else null

  /**
   * $START$MNMC.html $MNMC$END
   *
   * @param m
   *   $JFX $MNMC
   * @return
   *   $SFX $MNMC
   */
  implicit def jfxMnemonic2sfx(m: jfxsi.Mnemonic): Mnemonic = if (m != null) new Mnemonic(m) else null

  /**
   * $START$MSBT.html $MSBT$END
   *
   * @param e
   *   $JFX $MSBT
   * @return
   *   $SFX $MSBT
   */
  implicit def jfxMouseButton2sfx(e: jfxsi.MouseButton): MouseButton = MouseButton.jfxEnum2sfx(e)

  /**
   * $START$MSEV.html $MSEV$END
   *
   * @param me
   *   $JFX $MSEV
   * @return
   *   $SFX $MSEV
   */
  implicit def jfxMouseEvent2sfx(me: jfxsi.MouseEvent): MouseEvent = if (me != null) new MouseEvent(me) else null

  /**
   * $START$MSDE.html $MSDE$END
   *
   * @param mde
   *   $JFX $MSDE
   * @return
   *   $SFX $MSDE
   */
  implicit def jfxMouseDragEvent2sfx(mde: jfxsi.MouseDragEvent): MouseDragEvent =
    if (mde != null) new MouseDragEvent(mde) else null

  implicit def jfxPickResult2sfx(m: jfxsi.PickResult): PickResult =
    if (m != null) new PickResult(m) else null

  /**
   * $START$RTEV.html $RTEV$END
   *
   * @param re
   *   $JFX $RTEV
   * @return
   *   $SFX $RTEV
   */
  implicit def jfxRotateEvent2sfx(re: jfxsi.RotateEvent): RotateEvent = if (re != null) new RotateEvent(re) else null

  /**
   * $START$SCEV.html $SCEV$END
   *
   * @param se
   *   $JFX $SCEV
   * @return
   *   $SFX $SCEV
   */
  implicit def jfxScrollEvent2sfx(se: jfxsi.ScrollEvent): ScrollEvent = if (se != null) new ScrollEvent(se) else null

  /**
   * $START$SEHS.html $SEHS$END
   *
   * @param h
   *   $JFX $SEHS
   * @return
   *   $SFX $SEHS
   */
  implicit def jfxScrollEventHorizontalTextScrollUnits2sfx(
      h: jfxsi.ScrollEvent.HorizontalTextScrollUnits
  ): HorizontalTextScrollUnits = ScrollEvent.HorizontalTextScrollUnits.jfxEnum2sfx(h)

  /**
   * $START$SEVS.html $SEVS$END
   *
   * @param v
   *   $JFX $SEVS
   * @return
   *   $SFX $SEVS
   */
  implicit def jfxScrollEventVerticalTextScrollUnits2sfx(
      v: jfxsi.ScrollEvent.VerticalTextScrollUnits
  ): VerticalTextScrollUnits = ScrollEvent.VerticalTextScrollUnits.jfxEnum2sfx(v)

  /**
   * $START$SWEV.html $SWEV$END
   *
   * @param se
   *   $JFX $SWEV
   * @return
   *   $SFX $SWEV
   */
  implicit def jfxSwipeEvent2sfx(se: jfxsi.SwipeEvent): SwipeEvent = if (se != null) new SwipeEvent(se) else null

  /**
   * $START$TCEV.html $TCEV$END
   *
   * @param te
   *   $JFX $TCEV
   * @return
   *   $SFX $TCEV
   */
  implicit def jfxTouchEvent2sfx(te: jfxsi.TouchEvent): TouchEvent = if (te != null) new TouchEvent(te) else null

  /**
   * $START$TCPT.html $TCPT$END
   *
   * @param tp
   *   $JFX $TCPT
   * @return
   *   $SFX $TCPT
   */
  implicit def jfxTouchPoint2sfx(tp: jfxsi.TouchPoint): TouchPoint = if (tp != null) new TouchPoint(tp) else null

  /**
   * $START$TPST.html $TPST$END
   *
   * @param s
   *   $JFX $TPST
   * @return
   *   $SFX $TPST
   */
  implicit def jfxTouchPointState2sfx(s: jfxsi.TouchPoint.State): State = TouchPoint.State.jfxEnum2sfx(s)

  /**
   * $START$TRMD.html $TRMD$END
   *
   * @param e
   *   $JFX $TRMD
   * @return
   *   $SFX $TRMD
   */
  implicit def jfxTransferMode2sfx(e: jfxsi.TransferMode): TransferMode = TransferMode.jfxEnum2sfx(e)

  /**
   * $START$ZMEV.html $ZMEV$END
   *
   * @param ze
   *   $JFX $ZMEV
   * @return
   *   $SFX $ZMEV
   */
  implicit def jfxZoomEvent2sfx(ze: jfxsi.ZoomEvent): ZoomEvent = if (ze != null) new ZoomEvent(ze) else null
}
