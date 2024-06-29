/*
 * Copyright (c) 2011-2024, ScalaFX Project
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
package scalafx.scene.image

import java.nio.Buffer

import javafx.scene.{image => jfxsi}
import scalafx.scene.image.PixelFormat.Type

import scala.language.implicitConversions

object ImageIncludes extends ImageIncludes

/**
 * Contains implcit methods to convert from
 * [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/image/package-summary.html `javafx.scene.image`]]
 * Classes/Traits to their $SFX counterparts.
 *
 * @define JFX   JavaFX
 * @define SFX   ScalaFX
 * @define START Converts a $JFX `[[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/image/
 * @define END ]]` instance to its $SFX counterpart.
 *
 * @define IMG Image
 * @define IMV ImageView
 * @define PXF PixelFormat
 * @define PFT PixelFormat.Type
 * @define PXR PixelReader
 * @define PXW PixelWriter
 * @define WRI WritableImage
 * @define WPF WritablePixelFormat
 */
trait ImageIncludes {

  /**
   * $START$IMG.html $IMG$END
   *
   * @param i $JFX $IMG
   * @return $SFX $IMG
   */
  implicit def jfxImage2sfx(i: jfxsi.Image): Image = if (i != null) new Image(i) else null

  /**
   * $START$IMV.html $IMV$END
   *
   * @param iv $JFX $IMV
   * @return $SFX $IMV
   */
  implicit def jfxImageView2sfx(iv: jfxsi.ImageView): ImageView = if (iv != null) new ImageView(iv) else null

  /**
   * $START$PXF.html $PXF$END
   *
   * @param pf $JFX $PXF
   * @return $SFX $PXF
   */
  implicit def jfxPixelFormat2sfx[B <: Buffer](pf: jfxsi.PixelFormat[B]): PixelFormat[B] = if (pf != null)
    new PixelFormat[B](pf) {}
  else null

  /**
   * $START$PFT.html $PFT$END
   *
   * @param t $JFX $PFT
   * @return $SFX $PFT
   */
  implicit def jfxType2sfx(t: jfxsi.PixelFormat.Type): Type = PixelFormat.Type.jfxEnum2sfx(t)

  /**
   * $START$PXR.html $PXR$END
   *
   * @param pr $JFX $PXR
   * @return $SFX $PXR
   */
  implicit def jfxPixelReader2sfx(pr: jfxsi.PixelReader): PixelReader =
    if (pr != null) new PixelReader {
      override val delegate: jfxsi.PixelReader = pr
    }
    else null

  /**
   * $START$PXW.html $PXW$END
   *
   * @param pw $JFX $PXW
   * @return $SFX $PXW
   */
  implicit def jfxPixelWriter2sfx(pw: jfxsi.PixelWriter): PixelWriter =
    if (pw != null) new PixelWriter {
      override val delegate: jfxsi.PixelWriter = pw
    }
    else null

  /**
   * $START$WRI.html $WRI$END
   *
   * @param wi $JFX $WRI
   * @return $SFX $WRI
   */
  implicit def jfxWritableImage2sfx(wi: jfxsi.WritableImage): WritableImage =
    if (wi != null) new WritableImage(wi) else null

  /**
   * $START$WPF.html $WPF$END
   *
   * @param pf $JFX $WPF
   * @return $SFX $WPF
   */
  implicit def jfxWritablePixelFormat2sfx[B <: Buffer](pf: jfxsi.WritablePixelFormat[B]): WritablePixelFormat[B] =
    new WritablePixelFormat[B](pf) {}

}
