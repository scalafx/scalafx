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
package scalafx.css

import javafx.{css => jfxcss}

import scala.language.implicitConversions

object CssIncludes extends CssIncludes

/**
 * Contains implicit methods to convert from
 * [[http://docs.oracle.com/javase/8/javafx/api/javafx/css/package-summary.html `javafx.css`]]
 * classes/interfaces to their ScalaFX counterparts.
 *
 * @since 8.0
 *
 * @define JFX JavaFX
 * @define SFX ScalaFX
 * @define START Converts a $JFX `[[http://docs.oracle.com/javase/8/javafx/api/javafx/css/
 * @define END ]]` instance to its $SFX counterpart.
 * @define PV ParsedValue
 * @define PS PseudoClass
 * @define ST Styleable
 * @define SP StyleableProperty
 * @define SO StyleOrigin
 * @define SC StyleConverter
 * @define MD CssMetaData
 * @define FD FontCssMetaData
 */
trait CssIncludes {

  /*
   * $START$PV.html $PV$END
   *
   * @param pv $JFX $PV
   * @return $SFX $PV
   */
  //  implicit def jfxParsedValur2sfx[V, T](pv: jfxcss.ParsedValue[V, T]): ParsedValue[V, T] =
  //    new ParsedValue[V, T](pv)

  /**
   * $START$PS.html $PS$END
   *
   * @param d $JFX $PS
   * @return $SFX $PS
   */
  implicit def jfxPseudoClass2sfx(d: jfxcss.PseudoClass): PseudoClass = if (d != null) new PseudoClass(d) {} else null

  /**
   * $START$ST.html $ST$END
   *
   * @param s $JFX $ST
   * @return $SFX $ST
   */
  implicit def jfxStyleable2sfx(s: jfxcss.Styleable): Styleable =
    if (s != null)
      new Styleable {
        override val delegate = s
      }
    else null

  /*
   * $START$SP.html $SP$END
   *
   * @param s $JFX $SP
   * @return $SFX $SP
   */
  //  implicit def jfxStyleableProperty2sfx[T](s: jfxcss.StyleableProperty[T]) = new StyleableProperty[T] {
  //    override val delegate = s
  //  }

  /**
   * $START$SO.html $SO$END
   *
   * @param o $JFX $SO
   * @return $SFX $SO
   */
  implicit def jfxStyleOrigin2sfx(o: jfxcss.StyleOrigin): StyleOrigin = StyleOrigin.jfxEnum2sfx(o)

  /*
   * $START$MD.html $MD$END
   *
   * @param cmd $JFX $MD
   * @return $SFX $MD
   */
  //  implicit def jfxCssMetaData2sfx[S <: jfxcss.Styleable, V](cmd: jfxcss.CssMetaData[S, V]) =
  //    new CssMetaData[S, V](cmd) {}

  /*
   * $START$FD.html $MD$END
   *
   * @param f $JFX $FD
   * @return $SFX $FD
   */
  //  implicit def jfxFontCssMetaData2sfx[S <: jfxcss.Styleable](f: jfxcss.FontCssMetaData[S]) =
  //    new FontCssMetaData[S](f) {}

  /**
   * $START$SC.html $SC$END
   *
   * @tparam F
   * @tparam T
   * @param sc $JFX $SC
   * @return $SFX $SC
   */
  implicit def jfxStyleConverter2sfx[F, T](sc: jfxcss.StyleConverter[F, T]): StyleConverter[F, T] =
    if (sc != null) new StyleConverter[F, T](sc) else null

}