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
package scalafx.stage

import javafx.{stage => jfxs}

import scala.language.implicitConversions
import scalafx.stage.FileChooser.ExtensionFilter

object StageIncludes extends StageIncludes

/**
 * Contains implcit methods to convert from
 * [[http://download.java.net/jdk8/jfxdocs/javafx/stage/package-summary.html `javafx.stage`]]
 * Classes/Traits to their $SFX counterparts.
 *
 * @define JFX JavaFX
 * @define SFX ScalaFX
 * @define START Converts a $JFX `[[http://download.java.net/jdk8/jfxdocs/javafx/stage/
 * @define END ]]` instance to its $SFX counterpart.
 *
 * @define DC DirectoryChooser
 * @define FC FileChooser
 * @define FE FileChooser.ExtensionFilter
 * @define PW PopupWindow
 * @define PWAL PopupWindow.AnchorLocation
 * @define PP Popup
 * @define MD Modality
 * @define SC Screen
 * @define ST Stage
 * @define SS StageStyle
 * @define WN Window
 * @define WE WindowEvent
 */
trait StageIncludes {

  /**
   * $START$DC.html $DC$END
   *
   * @param dc $JFX $DC
   * @return $SFX $DC
   */
  implicit def jfxDirectoryChooser2sfx(dc: jfxs.DirectoryChooser): DirectoryChooser = if (dc != null) new DirectoryChooser(dc) else null

  /**
   * $START$FC.html $FC$END
   *
   * @param fc $JFX $FC
   * @return $SFX $FC
   */
  implicit def jfxFileChooser2sfx(fc: jfxs.FileChooser): FileChooser = if (fc != null) new FileChooser(fc) else null

  /**
   * $START$FE.html $FE$END
   *
   * @param ef $JFX $FE
   * @return $SFX $FE
   */
  implicit def jfxFileChooserExtensionFilter2sfx(ef: jfxs.FileChooser.ExtensionFilter): ExtensionFilter = if (ef != null) new FileChooser.ExtensionFilter(ef) else null

  /**
   * $START$PW.html $PW$END
   *
   * @param pw $JFX $PW
   * @return $SFX $PW
   */
  implicit def jfxPopupWindow2sfx(pw: jfxs.PopupWindow): PopupWindow = if (pw != null) new PopupWindow(pw) {} else null

  /**
   * $START$PWAL.html $PWAL$END
   *
   * @param v $JFX $PWAL
   * @return $SFX $PWAL
   */
  implicit def jfxPopupWindowAnchorLocation2sfx(v: jfxs.PopupWindow.AnchorLocation) = PopupWindow.AnchorLocation.jfxEnum2sfx(v)

  /**
   * $START$PP.html $PP$END
   *
   * @param p $JFX $PP
   * @return $SFX $PP
   */
  implicit def jfxPopup2sfx(p: jfxs.Popup): Popup = if (p != null) new Popup(p) else null

  /**
   * $START$MD.html $MD$END
   *
   * @param e $JFX $MD
   * @return $SFX $MD
   */
  implicit def jfxModality2sfx(e: jfxs.Modality): Modality = Modality.jfxEnum2sfx(e)

  /**
   * $START$SC.html $SC$END
   *
   * @param s $JFX $SC
   * @return $SFX $SC
   */
  implicit def jfxScreen2sfx(s: jfxs.Screen): Screen = if (s != null) new Screen(s) else null

  /**
   * $START$ST.html $ST$END
   *
   * @param s $JFX $ST
   * @return $SFX $ST
   */
  implicit def jfxStage2sfx(s: jfxs.Stage): Stage = if (s != null) new Stage(s) else null

  /**
   * $START$SS.html $SS$END
   *
   * @param e $JFX $SS
   * @return $SFX $SS
   */
  implicit def jfxStageStyle2sfx(e: jfxs.StageStyle): StageStyle = StageStyle.jfxEnum2sfx(e)

  /**
   * $START$WN.html $WN$END
   *
   * @param w $JFX $WN
   * @return $SFX $WN
   */
  implicit def jfxWindow2sfx(w: jfxs.Window): Window = if (w != null) new Window(w) {} else null

  /**
   * $START$WE.html $WE$END
   *
   * @param we $JFX $WE
   * @return $SFX $WE
   */
  implicit def jfxWindowEvent2sfx(we: jfxs.WindowEvent): WindowEvent = if (we != null) new WindowEvent(we) {} else null

}