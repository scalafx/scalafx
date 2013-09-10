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
package scalafx.scene.text

import javafx.scene.{ text => jfxst }

object TextIncludes extends TextIncludes

/**
 * Contains implcit methods to convert from
 * [[http://docs.oracle.com/javafx/2/api/javafx/scene/text/package-summary.html `javafx.scene.text`]]
 * Classes/Traits to their $SFX counterparts.
 *
 * @define JFX JavaFX
 * @define SFX ScalaFX
 * @define START Converts a $JFX `[[http://docs.oracle.com/javafx/2/api/javafx/scene/text/
 * @define END ]]` instance to its $SFX counterpart.
 *
 * @define FT Font
 * @define FP FontPosture
 * @define FS FontSmoothingType
 * @define FW FontWeight
 * @define TX Text
 * @define TA TextAlignment
 * @define TB TextBoundsType
 */
trait TextIncludes {

  /**
   * $START$FT.html $FT$END
   *
   * @param f $JFX $FT
   * @return $SFX $FT
   */
  implicit def jfxFont2sfxFont(f: jfxst.Font) = new Font(f)

  /**
   * $START$FP.html $FP$END
   *
   * @param e $JFX $FP
   * @return $SFX $FP
   */
  implicit def jfxFontPosture2sfx(e: jfxst.FontPosture) = FontPosture.jfxEnum2sfx(e)

  /**
   * $START$FS.html $FS$END
   *
   * @param e $JFX $FS
   * @return $SFX $FS
   */
  implicit def jfxFontSmoothingType2sfx(e: jfxst.FontSmoothingType) = FontSmoothingType.jfxEnum2sfx(e)

  /**
   * $START$FW.html $FW$END
   *
   * @param e $JFX $FW
   * @return $SFX $FW
   */
  implicit def jfxFontWeight2sfx(e: jfxst.FontWeight) = FontWeight.jfxEnum2sfx(e)

  /**
   * $START$TX.html $TX$END
   *
   * @param t $JFX $TX
   * @return $SFX $TX
   */
  implicit def jfxText2sfxText(t: jfxst.Text) = new Text(t)

  /**
   * $START$TA.html $TA$END
   *
   * @param e $JFX $TA
   * @return $SFX $TA
   */
  implicit def jfxTextAlignment2sfx(e: jfxst.TextAlignment) = TextAlignment.jfxEnum2sfx(e)

  /**
   * $START$TB.html $TB$END
   *
   * @param e $JFX $TB
   * @return $SFX $TB
   */
  implicit def jfxTextBoundsType2sfx(e: jfxst.TextBoundsType) = TextBoundsType.jfxEnum2sfx(e)

}
