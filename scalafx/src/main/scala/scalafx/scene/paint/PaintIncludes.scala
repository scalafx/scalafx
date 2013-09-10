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
package scalafx.scene.paint

import javafx.scene.{ paint => jfxsp }

object PaintIncludes extends PaintIncludes

/**
 * Contains implcit methods to convert from
 * [[http://docs.oracle.com/javafx/2/api/javafx/scene/paint/package-summary.html `javafx.scene.paint`]]
 * Classes/Traits to their $SFX counterparts.
 *
 * @define JFX JavaFX
 * @define SFX ScalaFX
 * @define START Converts a $JFX `[[http://docs.oracle.com/javafx/2/api/javafx/scene/paint/
 * @define END ]]` instance to its $SFX counterpart.
 * @define BEGINSTRING Converts an HTML or CSS attribute string to a
 * @define ENDSTRING See $JFX's `Color.web()` for more details.
 * @define PARAMSTRING The name or numeric representation of the color in one of the supported formats
 * @define RETSTRING Color correspondent to argument
 * @define BEGINHEX Converts a Interger (preferentially in a Hexadecinal format) to a
 * @define ENDHEX See $JFX's `Color.rgb()` for more details.
 * @define PARAMHEX Number to be converted
 * @define RETHEX Color correspondent to Number.
 * @define TUPLE3 a tuple of 3 Integers
 * @define BEGINTUPLE3 Converts $TUPLE3 to a
 * @define BEGINTUPLE4 Converts $TUPLE3 and a double to a
 * @define PTUPLE3 A tuple of 3 Integers (all of them must be lesser than 256) correspondent respectively to red, green and blue components of desired $CLR
 * @define PTUPLE4 A tuple of 3 Integers (all of them must be lesser than 256) and a Double (lesser than 1.0) correspondent respectively to red, green, blue and opacity components of desired $CLR
 * @define RETTUPLE Color correspondent to Tuple.
 *
 * @define CLR Color
 * @define CMT CycleMethod
 * @define LGD LinearGradient
 * @define RGD RadialGradient
 * @define STP Stop
 * @define PNT Paint
 */
trait PaintIncludes {

  /**
   * $BEGINSTRING $SFX $CLR. $ENDSTRING
   *
   * @param s $PARAMSTRING
   * @return $SFX $RETSTRING
   */
  implicit def string2sfxColor(s: String) = Color.web(s)

  /**
   * $BEGINSTRING $JFX $CLR. $ENDSTRING
   *
   * @param s $PARAMSTRING
   * @return $JFX $RETSTRING
   */
  implicit def string2jfxColor(s: String) = jfxsp.Color.web(s)

  /**
   * $BEGINHEX $SFX $CLR. $ENDHEX
   *
   * @param s $PARAMHEX
   * @return $SFX $RETHEX
   */
  implicit def hex2sfxColor(h: Int) = Color.rgb(h >>> 16 & 0xFF, h >>> 8 & 0xFF, h & 0xFF)

  /**
   * $BEGINHEX $JFX $CLR. $ENDHEX
   *
   * @param s $PARAMHEX
   * @return $JFX $RETHEX
   */
  implicit def hex2jfxColor(h: Int) = jfxsp.Color.rgb(h >>> 16 & 0xFF, h >>> 8 & 0xFF, h & 0xFF)

  /**
   * $BEGINTUPLE3 $SFX $CLR.
   *
   * @param tuple $PTUPLE3
   * @return $RETTUPLE
   */
  implicit def tuple32SfxColor(tuple: (Int, Int, Int)) = Color.rgb(tuple._1, tuple._2, tuple._3)

  /**
   * $BEGINTUPLE4 $SFX $CLR.
   *
   * @param tuple $PTUPLE4
   * @return $RETTUPLE
   */
  implicit def tuple42SfxColor(tuple: (Int, Int, Int, Double)) = Color.rgb(tuple._1, tuple._2, tuple._3, tuple._4)

  /**
   * $BEGINTUPLE3 $JFX $CLR.
   *
   * @param tuple $PTUPLE3 
   * @return $RETTUPLE
   */
  implicit def tuple32JfxColor(tuple: (Int, Int, Int)) = jfxsp.Color.rgb(tuple._1, tuple._2, tuple._3)

  /**
   * $BEGINTUPLE4 $JFX $CLR.
   *
   * @param tuple $PTUPLE4
   * @return $RETTUPLE
   */
  implicit def tuple42JfxColor(tuple: (Int, Int, Int, Double)) = jfxsp.Color.rgb(tuple._1, tuple._2, tuple._3, tuple._4)

  /**
   * $START$CLR.html $CLR$END
   *
   * @param c $JFX $CLR
   * @return $SFX $CLR
   */
  implicit def jfxColor2sfx(c: jfxsp.Color) = new Color(c)

  /**
   * $START$CMT.html $CMT$END
   *
   * @param e $JFX $CMT
   * @return $SFX $CMT
   */
  implicit def jfxCycleMethod2sfx(e: jfxsp.CycleMethod) = CycleMethod.jfxEnum2sfx(e)

  /**
   * $START$LGD.html $LGD$END
   *
   * @param lg $JFX $LGD
   * @return $SFX $LGD
   */
  implicit def jfxLinearGradient2sfx(lg: jfxsp.LinearGradient) = new LinearGradient(lg)

  /**
   * $START$RGD.html $RGD$END
   *
   * @param rg $JFX $RGD
   * @return $SFX $RGD
   */
  implicit def jfxRadialGradient2sfx(rg: jfxsp.RadialGradient) = new RadialGradient(rg)

  /**
   * $START$STP.html $STP$END
   *
   * @param c $JFX $STP
   * @return $SFX $STP
   */
  implicit def jfxStop2sfx(c: jfxsp.Stop) = new Stop(c)

  /**
   * $START$PNT.html $PNT$END
   *
   * @param p $JFX $PNT
   * @return $SFX $PNT
   */
  implicit def jfxPaint2sfx(p: jfxsp.Paint) = new Paint(p) {}

}