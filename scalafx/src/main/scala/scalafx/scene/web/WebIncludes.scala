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
package scalafx.scene.web

import javafx.{ event => jfxe }
import javafx.scene.{ web => jfxsw }

object WebIncludes extends WebIncludes

/**
 * Contains implcit methods to convert from
 * [[http://docs.oracle.com/javafx/2/api/javafx/scene/web/package-summary.html `javafx.scene.web`]]
 * Classes/Traits to their $SFX counterparts.
 *
 * @define JFX JavaFX
 * @define SFX ScalaFX
 * @define START Converts a $JFX `[[http://docs.oracle.com/javafx/2/api/javafx/scene/web/
 * @define END ]]` instance to its $SFX counterpart.
 * @define BEGINWR Converts a Function that manipulates a $SFX [[scalafx.scene.web.
 * @define FINISHWR ]] and returns a [[http://www.scala-lang.org/api/current/scala/Any.html scala.Any]] into a $JFX's [[http://docs.oracle.com/javafx/2/api/javafx/event/EventHandler.html EventHandler]] that manipulates it's $JFX couterpart.
 * @define PARAMWR function that manipulates a $SFX's
 * @define RETWR A $JFX's EventHandler that manipulates a $JFX's
 *
 * @define HE HTMLEditor
 * @define PF PopupFeatures
 * @define PD PromptData
 * @define WE WebEngine
 * @define WT WebEvent
 * @define WV WebView
 */
trait WebIncludes {

  /**
   * $START$HE.html $HE$END
   *
   * @param he $JFX $HE
   * @return $SFX $HE
   */
  implicit def jfxHTMLEditor2sfx(he: jfxsw.HTMLEditor) = new HTMLEditor(he)

  /**
   * $START$PF.html $PF$END
   *
   * @param pf $JFX $PF
   * @return $SFX $PF
   */
  implicit def jfxPopupFeatures2sfx(pf: jfxsw.PopupFeatures) = new PopupFeatures(pf)

  /**
   * $START$PD.html $PD$END
   *
   * @param pd $JFX $PD
   * @return $SFX $PD
   */
  implicit def jfxPromptData2sfx(pd: jfxsw.PromptData) = new PromptData(pd)

  /**
   * $START$WE.html $WE$END
   *
   * @param we $JFX $WE
   * @return $SFX $WE
   */
  implicit def jfxWebEngine2sfx(we: jfxsw.WebEngine) = new WebEngine(we)

  /**
   * $START$WT.html $WT$END
   *
   * @param we $JFX $WT
   * @return $SFX $WT
   */
  implicit def jfxWebEvent2sfx[T](we: jfxsw.WebEvent[T]) = new WebEvent(we)

  /**
   * $START$WV.html $WV$END
   *
   * @param wv $JFX $WV
   * @return $SFX $WV
   */
  implicit def jfxWebView2sfx(wv: jfxsw.WebView) = new WebView(wv)

  /**
   * $BEGINWR$WE$FINISHWR
   *
   * @param handler $PARAMWR $WE
   * @return $RETWR $WE
   */
  implicit def webEventClosureWrapper[T](handler: (WebEvent[T]) => Any) = new jfxe.EventHandler[jfxsw.WebEvent[T]] {
    def handle(event: jfxsw.WebEvent[T]) {
      handler(event)
    }
  }

}