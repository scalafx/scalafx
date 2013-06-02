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
package scalafx.stage

import javafx.{ stage => jfxs }

object StageIncludes extends StageIncludes

/**
 * Contains implcit methods to convert from
 * [[http://docs.oracle.com/javafx/2/api/javafx/stage/package-summary.html `javafx.stage`]]
 * Classes/Traits to their $SFX counterparts.
 *
 * @define JFX JavaFX
 * @define SFX ScalaFX
 * @define START Converts a $JFX `[[http://docs.oracle.com/javafx/2/api/javafx/stage/
 * @define END ]]` instance to its $SFX counterpart.
 *
 * @define DC DirectoryChooser
 * @define FC FileChooser
 * @define FE FileChooser.ExtensionFilter
 * @define PW PopupWindow
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
  implicit def jfxDirectoryChooser2sfx(dc: jfxs.DirectoryChooser) = new DirectoryChooser(dc)

  /**
   * $START$FC.html $FC$END
   *
   * @param fc $JFX $FC
   * @return $SFX $FC
   */
  implicit def jfxFileChooser2sfx(fc: jfxs.FileChooser) = new FileChooser(fc)

  /**
   * $START$FE.html $FE$END
   *
   * @param ef $JFX $FE
   * @return $SFX $FE
   */
  implicit def jfxFileChooserExtensionFilter2sfx(ef: jfxs.FileChooser.ExtensionFilter) = new FileChooser.ExtensionFilter(ef)

  /**
   * $START$PW.html $PW$END
   *
   * @param pw $JFX $PW
   * @return $SFX $PW
   */
  implicit def jfxPopupWindow2sfx(pw: jfxs.PopupWindow) = new PopupWindow(pw) {}

  /**
   * $START$PP.html $PP$END
   *
   * @param p $JFX $PP
   * @return $SFX $PP
   */
  implicit def jfxPopup2sfx(p: jfxs.Popup) = new Popup(p)

  /**
   * $START$MD.html $MD$END
   *
   * @param e $JFX $MD
   * @return $SFX $MD
   */
  implicit def jfxModality2sfx(e: jfxs.Modality) = Modality.jfxEnum2sfx(e)

  /**
   * $START$SC.html $SC$END
   *
   * @param s $JFX $SC
   * @return $SFX $SC
   */
  implicit def jfxScreen2sfx(s: jfxs.Screen) = new Screen(s)

  /**
   * $START$ST.html $ST$END
   *
   * @param s $JFX $ST
   * @return $SFX $ST
   */
  implicit def jfxStage2sfx(s: jfxs.Stage) = new Stage(s)

  /**
   * $START$SS.html $SS$END
   *
   * @param e $JFX $SS
   * @return $SFX $SS
   */
  implicit def jfxStageStyle2sfx(e: jfxs.StageStyle) = StageStyle.jfxEnum2sfx(e)

  /**
   * $START$WN.html $WN$END
   *
   * @param w $JFX $WN
   * @return $SFX $WN
   */
  implicit def jfxWindow2sfx(w: jfxs.Window) = new Window(w) {}

  /**
   * $START$WE.html $WE$END
   *
   * @param we $JFX $WE
   * @return $SFX $WE
   */
  implicit def jfxWindowEvent2sfx(we: jfxs.WindowEvent) = new WindowEvent(we) {}

}