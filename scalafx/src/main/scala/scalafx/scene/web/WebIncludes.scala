/*
 * Copyright (c) 2011-2025, ScalaFX Project
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

import javafx.event as jfxe
import javafx.event.EventHandler
import javafx.scene.web as jfxsw

import scala.language.implicitConversions

object WebIncludes extends WebIncludes

/**
 * Contains implcit methods to convert from
 * [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/web/package-summary.html `javafx.scene.web`]]
 * Classes/Traits to their $SFX counterparts.
 *
 * @define JFX JavaFX
 * @define SFX ScalaFX
 * @define START Converts a $JFX `[[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/web/
 * @define END ]]` instance to its $SFX counterpart.
 * @define BEGINWR Converts a Function that manipulates a $SFX [[scalafx.scene.web.
 * @define FINISHWR ]] and returns a [[http://www.scala-lang.org/api/current/scala/Any.html scala.Any]] into a $JFX's [[http://docs.oracle.com/javase/8/javafx/api/javafx/event/EventHandler.html EventHandler]] that manipulates it's $JFX counterpart.
 * @define PARAMWR function that manipulates a $SFX's
 * @define RETWR A $JFX's EventHandler that manipulates a $JFX's
 *
 * @define HE HTMLEditor
 * @define PF PopupFeatures
 * @define PD PromptData
 * @define WE WebEngine
 * @define WT WebEvent
 * @define WR WebErrorEvent
 * @define WV WebView
 */
trait WebIncludes {

  /**
   * $START$HE.html $HE$END
   *
   * @param he $JFX $HE
   * @return $SFX $HE
   */
  implicit def jfxHTMLEditor2sfx(he: jfxsw.HTMLEditor): HTMLEditor = if (he != null) new HTMLEditor(he) else null

  /**
   * $START$PF.html $PF$END
   *
   * @param pf $JFX $PF
   * @return $SFX $PF
   */
  implicit def jfxPopupFeatures2sfx(pf: jfxsw.PopupFeatures): PopupFeatures =
    if (pf != null) new PopupFeatures(pf) else null

  /**
   * $START$PD.html $PD$END
   *
   * @param pd $JFX $PD
   * @return $SFX $PD
   */
  implicit def jfxPromptData2sfx(pd: jfxsw.PromptData): PromptData = if (pd != null) new PromptData(pd) else null

  /**
   * $START$WE.html $WE$END
   *
   * @param we $JFX $WE
   * @return $SFX $WE
   */
  implicit def jfxWebEngine2sfx(we: jfxsw.WebEngine): WebEngine = if (we != null) new WebEngine(we) else null

  /**
   * $START$WT.html $WT$END
   *
   * @param we $JFX $WT
   * @return $SFX $WT
   */
  implicit def jfxWebEvent2sfx[T](we: jfxsw.WebEvent[T]): WebEvent[T] = if (we != null) new WebEvent(we) else null

  /**
   * $START$WR.html $WR$END
   *
   * @param wr $JFX $WR
   * @return $SFX $WR
   */
  implicit def jfxWebErrorEvent2sfx(wr: jfxsw.WebErrorEvent): WebErrorEvent =
    if (wr != null) new WebErrorEvent(wr) else null

  /**
   * $START$WV.html $WV$END
   *
   * @param wv $JFX $WV
   * @return $SFX $WV
   */
  implicit def jfxWebView2sfx(wv: jfxsw.WebView): WebView = if (wv != null) new WebView(wv) else null

  /**
   * $BEGINWR$WE$FINISHWR
   *
   * @param handler $PARAMWR $WE
   * @return $RETWR $WE
   */
  implicit def webEventClosureWrapper[T](handler: (WebEvent[T]) => Any): EventHandler[jfxsw.WebEvent[T]] =
    new jfxe.EventHandler[jfxsw.WebEvent[T]] {
      def handle(event: jfxsw.WebEvent[T]): Unit = {
        handler(event)
      }
    }

}
