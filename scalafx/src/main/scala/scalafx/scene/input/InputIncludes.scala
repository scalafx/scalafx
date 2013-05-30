/*
 * Copyright (c) 2011-2013, ScalaFX Project
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

import javafx.{ event => jfxe }
import javafx.scene.{ input => jfxsi }
import scalafx.delegate.SFXDelegate

object InputIncludes extends InputIncludes

/**
 * Contains implcit methods to convert from
 * [[http://docs.oracle.com/javafx/2/api/javafx/scene/input/package-summary.html `javafx.scene.input`]]
 * Classes/Traits to their $SFX counterparts.
 *
 * @define JFX JavaFX
 * @define SFX ScalaFX
 * @define START Converts a $JFX `[[http://docs.oracle.com/javafx/2/api/javafx/scene/input/
 * @define END ]]` instance to its $SFX counterpart.
 * @define BEGINWR Converts a Function that manipulates a $SFX [[scalafx.scene.input.
 * @define FINISHWR ]] and returns a [[http://www.scala-lang.org/api/current/scala/Any.html scala.Any]] into a $JFX's [[http://docs.oracle.com/javafx/2/api/javafx/event/EventHandler.html EventHandler]] that manipulates it's $JFX couterpart.
 * @define PARAMWR function that manipulates a $SFX's
 * @define RETWR A $JFX's EventHandler that manipulates a $JFX's
 *
 * @define CLIP Clipboard
 * @define CLCT ClipboardContent
 * @define CMEV ContextMenuEvent
 * @define DTFM DataFormat
 * @define DRGB Dragboard
 * @define DREV DragEvent
 * @define GTEV GestureEvent
 * @define IPEV InputEvent
 * @define IMEV InputMethodEvent
 * @define IMHL InputMethodHighlight
 * @define IMTR InputMethodTextRun
 * @define KYCB KeyCombination
 * @define KCMV KeyCombination.ModifierValue
 * @define KCCB KeyCharacterCombination
 * @define KYCD KeyCode
 * @define KCCM KeyCodeCombination
 * @define KCMD KeyCombination.Modifier
 * @define KEEV KeyEvent
 * @define MNMC Mnemonic
 * @define MSBT MouseButton
 * @define MSEV MouseEvent
 * @define MSDE MouseDragEvent
 * @define RTEV RotateEvent
 * @define SCEV ScrollEvent
 * @define SEHS ScrollEvent.HorizontalTextScrollUnits
 * @define SEVS ScrollEvent.VerticalTextScrollUnits
 * @define SWEV SwipeEvent
 * @define TCEV TouchEvent
 * @define TCPT TouchPoint
 * @define TPST TouchPoint.State
 * @define TRMD TransferMode
 * @define ZMEV ZoomEvent
 */
trait InputIncludes {

  /**
   * $START$CLIP.html $CLIP$END
   *
   * @param c $JFX $CLIP
   * @return $SFX $CLIP
   */
  implicit def jfxClipboard2sfx(c: jfxsi.Clipboard) = new Clipboard(c)

  /**
   * $START$CLCT.html $CLCT$END
   *
   * @param c $JFX $CLCT
   * @return $SFX $CLCT
   */
  implicit def jfxClipboardContent2sfx(c: jfxsi.ClipboardContent) = new ClipboardContent(c)

  /**
   * $START$CMEV.html $CMEV$END
   *
   * @param c $JFX $CMEV
   * @return $SFX $CMEV
   */
  implicit def jfxContextMenuEvent2sfx(c: jfxsi.ContextMenuEvent) = new ContextMenuEvent(c)

  /**
   * $START$DTFM.html $DTFM$END
   *
   * @param df $JFX $DTFM
   * @return $SFX $DTFM
   */
  implicit def jfxDataFormat2sfx(df: jfxsi.DataFormat) = new DataFormat(df)

  /**
   * $START$DRGB.html $DRGB$END
   *
   * @param d $JFX $DRGB
   * @return $SFX $DRGB
   */
  implicit def jfxDragboard2sfx(d: jfxsi.Dragboard) = new Dragboard(d)

  /**
   * $START$DREV.html $DREV$END
   *
   * @param de $JFX $DREV
   * @return $SFX $DREV
   */
  implicit def jfxDragEvent2sfx(de: jfxsi.DragEvent) = new DragEvent(de)

  /**
   * $START$GTEV.html $GTEV$END
   *
   * @param ge $JFX $GTEV
   * @return $SFX $GTEV
   */
  implicit def jfxGestureEvent2sfx(ge: jfxsi.GestureEvent) = new GestureEvent(ge)

  /**
   * $START$IPEV.html $IPEV$END
   *
   * @param ie $JFX $IPEV
   * @return $SFX $IPEV
   */
  implicit def jfxInputEvent2sfx(ie: jfxsi.InputEvent) = new InputEvent(ie)

  /**
   * $START$IMEV.html $IMEV$END
   *
   * @param ime $JFX $IMEV
   * @return $SFX $IMEV
   */
  implicit def jfxInputMethodEvent2sfx(ime: jfxsi.InputMethodEvent) = new InputMethodEvent(ime)

  /**
   * $START$IMHL.html $IMHL$END
   *
   * @param e $JFX $IMHL
   * @return $SFX $IMHL
   */
  implicit def jfxInputMethodHighlight2sfx(e: jfxsi.InputMethodHighlight) = InputMethodHighlight.jfxEnum2sfx(e)

  /**
   * $START$IMTR.html $IMTR$END
   *
   * @param imtr $JFX $IMTR
   * @return $SFX $IMTR
   */
  implicit def jfxInputMethodTextRun2sfx(imtr: jfxsi.InputMethodTextRun) = new InputMethodTextRun(imtr)

  /**
   * $START$KYCB.html $KYCB$END
   *
   * @param kc $JFX $KYCB
   * @return $SFX $KYCB
   */
  implicit def jfxKeyCombination2sfx(kc: jfxsi.KeyCombination) = new KeyCombination(kc) {}

  /**
   * $START$KCMV.html $KCMV$END
   *
   * @param mv $JFX $KCMV
   * @return $SFX $KCMV
   */
  implicit def jfxModifierValue2sfx(mv: jfxsi.KeyCombination.ModifierValue) = KeyCombination.ModifierValue.jfxEnum2sfx(mv)

  /**
   * $START$KCCB.html $KCCB$END
   *
   * @param kcc $JFX $KCCB
   * @return $SFX $KCCB
   */
  implicit def jfxKeyCharacterCombination2sfx(kcc: jfxsi.KeyCharacterCombination) = new KeyCharacterCombination(kcc)

  /**
   * $START$KYCD.html $KYCD$END
   *
   * @param e $JFX $KYCD
   * @return $SFX $KYCD
   */
  implicit def jfxKeyCode2sfx(e: jfxsi.KeyCode) = KeyCode.jfxEnum2sfx(e)

  /**
   * $START$KCCM.html $KCCM$END
   *
   * @param kcc $JFX $KCCM
   * @return $SFX $KCCM
   */
  implicit def jfxKeyCodeCombination2sfx(kcc: jfxsi.KeyCodeCombination) = new KeyCodeCombination(kcc)

  /**
   * $START$KCMD.html $KCMD$END
   *
   * @param m $JFX $KCMD
   * @return $SFX $KCMD
   */
  implicit def jfxKeyCombinationModifier2sfx(m: jfxsi.KeyCombination.Modifier) = new KeyCombination.Modifier(m) {}

  /**
   * $START$KEEV.html $KEEV$END
   *
   * @param ke $JFX $KEEV
   * @return $SFX $KEEV
   */
  implicit def jfxKeyEvent2sfx(ke: jfxsi.KeyEvent) = new KeyEvent(ke)

  /**
   * $START$MNMC.html $MNMC$END
   *
   * @param m $JFX $MNMC
   * @return $SFX $MNMC
   */
  implicit def jfxMnemonic2sfx(m: jfxsi.Mnemonic) = new Mnemonic(m)

  /**
   * $START$MSBT.html $MSBT$END
   *
   * @param e $JFX $MSBT
   * @return $SFX $MSBT
   */
  implicit def jfxMouseButton2sfx(e: jfxsi.MouseButton) = MouseButton.jfxEnum2sfx(e)

  /**
   * $START$MSEV.html $MSEV$END
   *
   * @param me $JFX $MSEV
   * @return $SFX $MSEV
   */
  implicit def jfxMouseEvent2sfx(me: jfxsi.MouseEvent) = new MouseEvent(me)

  /**
   * $START$MSDE.html $MSDE$END
   *
   * @param mde $JFX $MSDE
   * @return $SFX $MSDE
   */
  implicit def jfxMouseDragEvent2sfx(mde: jfxsi.MouseDragEvent) = new MouseDragEvent(mde)

  /**
   * $START$RTEV.html $RTEV$END
   *
   * @param re $JFX $RTEV
   * @return $SFX $RTEV
   */
  implicit def jfxRotateEvent2sfx(re: jfxsi.RotateEvent) = new RotateEvent(re)

  /**
   * $START$SCEV.html $SCEV$END
   *
   * @param se $JFX $SCEV
   * @return $SFX $SCEV
   */
  implicit def jfxScrollEvent2sfx(se: jfxsi.ScrollEvent) = new ScrollEvent(se)

  /**
   * $START$SEHS.html $SEHS$END
   *
   * @param h $JFX $SEHS
   * @return $SFX $SEHS
   */
  implicit def jfxScrollEventHorizontalTextScrollUnits2sfx(h: jfxsi.ScrollEvent.HorizontalTextScrollUnits) = ScrollEvent.HorizontalTextScrollUnits.jfxEnum2sfx(h)

  /**
   * $START$SEVS.html $SEVS$END
   *
   * @param v $JFX $SEVS
   * @return $SFX $SEVS
   */
  implicit def jfxScrollEventVerticalTextScrollUnits2sfx(v: jfxsi.ScrollEvent.VerticalTextScrollUnits) = ScrollEvent.VerticalTextScrollUnits.jfxEnum2sfx(v)

  /**
   * $START$SWEV.html $SWEV$END
   *
   * @param se $JFX $SWEV
   * @return $SFX $SWEV
   */
  implicit def jfxSwipeEvent2sfx(se: jfxsi.SwipeEvent) = new SwipeEvent(se)

  /**
   * $START$TCEV.html $TCEV$END
   *
   * @param te $JFX $TCEV
   * @return $SFX $TCEV
   */
  implicit def jfxTouchEvent2sfx(te: jfxsi.TouchEvent) = new TouchEvent(te)

  /**
   * $START$TCPT.html $TCPT$END
   *
   * @param tp $JFX $TCPT
   * @return $SFX $TCPT
   */
  implicit def jfxTouchPoint2sfx(tp: jfxsi.TouchPoint) = new TouchPoint(tp)

  /**
   * $START$TPST.html $TPST$END
   *
   * @param s $JFX $TPST
   * @return $SFX $TPST
   */
  implicit def jfxTouchPointState2sfx(s: jfxsi.TouchPoint.State) = TouchPoint.State.jfxEnum2sfx(s)

  /**
   * $START$TRMD.html $TRMD$END
   *
   * @param e $JFX $TRMD
   * @return $SFX $TRMD
   */
  implicit def jfxTransferMode2sfx(e: jfxsi.TransferMode) = TransferMode.jfxEnum2sfx(e)

  /**
   * $START$ZMEV.html $ZMEV$END
   *
   * @param ze $JFX $ZMEV
   * @return $SFX $ZMEV
   */
  implicit def jfxZoomEvent2sfx(ze: jfxsi.ZoomEvent) = new ZoomEvent(ze)

  /**
   *  $BEGINWR$CMEV$FINISHWR
   *
   * @param handler $PARAMWR $CMEV
   * @return $RETWR $CMEV
   */
  implicit def contextMenuEventClosureWrapper(handler: (ContextMenuEvent) => Any) = new jfxe.EventHandler[jfxsi.ContextMenuEvent] {
    def handle(event: jfxsi.ContextMenuEvent) {
      handler(event)
    }
  }

  /**
   *  $BEGINWR$DREV$FINISHWR
   *
   * @param handler $PARAMWR $DREV
   * @return $RETWR $DREV
   */
  implicit def dragEventClosureWrapper(handler: (DragEvent) => Any) = new jfxe.EventHandler[jfxsi.DragEvent] {
    def handle(event: jfxsi.DragEvent) {
      handler(event)
    }
  }

  /**
   *  $BEGINWR$IMEV$FINISHWR
   *
   * @param handler $PARAMWR $IMEV
   * @return $RETWR $IMEV
   */
  implicit def inputMethodEventClosureWrapper(handler: (InputMethodEvent) => Any) = new jfxe.EventHandler[jfxsi.InputMethodEvent] {
    def handle(event: jfxsi.InputMethodEvent) {
      handler(event)
    }
  }

  /**
   *  $BEGINWR$KEEV$FINISHWR
   *
   * @param handler $PARAMWR $KEEV
   * @return $RETWR $KEEV
   */
  implicit def keyEventClosureWrapper(handler: (KeyEvent) => Any) = new jfxe.EventHandler[jfxsi.KeyEvent] {
    def handle(event: jfxsi.KeyEvent) {
      handler(event)
    }
  }

  /**
   *  $BEGINWR$MSDE$FINISHWR
   *
   * @param handler $PARAMWR $MSDE	
   * @return $RETWR $MSDE
   */
  implicit def mouseDragEventClosureWrapper(handler: (MouseDragEvent) => Any) = new jfxe.EventHandler[jfxsi.MouseDragEvent] {
    def handle(event: jfxsi.MouseDragEvent) {
      handler(event)
    }
  }

  /**
   *  $BEGINWR$MSEV$FINISHWR
   *
   * @param handler $PARAMWR $MSEV
   * @return $RETWR $MSEV
   */
  implicit def mouseEventClosureWrapper(handler: (MouseEvent) => Any) = new jfxe.EventHandler[jfxsi.MouseEvent] {
    def handle(event: jfxsi.MouseEvent) {
      handler(event)
    }
  }

  /**
   *  $BEGINWR$RTEV$FINISHWR
   *
   * @param handler $PARAMWR $RTEV
   * @return $RETWR $RTEV
   */
  implicit def rotateEventClosureWrapper(handler: (RotateEvent) => Any) = new jfxe.EventHandler[jfxsi.RotateEvent] {
    def handle(event: jfxsi.RotateEvent) {
      handler(event)
    }
  }

  /**
   *  $BEGINWR$SCEV$FINISHWR
   *
   * @param handler $PARAMWR $SCEV
   * @return $RETWR $SCEV
   */
  implicit def scrollEventClosureWrapper(handler: (ScrollEvent) => Any) = new jfxe.EventHandler[jfxsi.ScrollEvent] {
    def handle(event: jfxsi.ScrollEvent) {
      handler(event)
    }
  }

  /**
   *  $BEGINWR$SWEV$FINISHWR
   *
   * @param handler $PARAMWR $SWEV
   * @return $RETWR $SWEV
   */
  implicit def swipeEventClosureWrapper(handler: (SwipeEvent) => Any) = new jfxe.EventHandler[jfxsi.SwipeEvent] {
    def handle(event: jfxsi.SwipeEvent) {
      handler(event)
    }
  }

  /**
   *  $BEGINWR$TCEV$FINISHWR
   *
   * @param handler $PARAMWR $TCEV
   * @return $RETWR $TCEV
   */
  implicit def touchEventClosureWrapper(handler: (TouchEvent) => Any) = new jfxe.EventHandler[jfxsi.TouchEvent] {
    def handle(event: jfxsi.TouchEvent) {
      handler(event)
    }
  }

  /**
   *  $BEGINWR$ZMEV$FINISHWR
   *
   * @param handler $PARAMWR $ZMEV
   * @return $RETWR $ZMEV
   */
  implicit def zoomEventClosureWrapper(handler: (ZoomEvent) => Any) = new jfxe.EventHandler[jfxsi.ZoomEvent] {
    def handle(event: jfxsi.ZoomEvent) {
      handler(event)
    }
  }

}