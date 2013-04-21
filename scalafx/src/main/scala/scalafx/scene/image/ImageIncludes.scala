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
package scalafx.scene.image

import javafx.scene.{ image => jfxsi }
import java.nio.Buffer

object ImageIncludes extends ImageIncludes

trait ImageIncludes {
  implicit def jfxImage2sfx(i: jfxsi.Image) = new Image(i)
  implicit def jfxImageView2sfx(iv: jfxsi.ImageView) = new ImageView(iv)
  implicit def jfxPixelFormat2sfx[B <: Buffer](pf: jfxsi.PixelFormat[B]) = new PixelFormat[B](pf) {}
  implicit def jfxType2sfx(t: jfxsi.PixelFormat.Type) = PixelFormat.Type.jfxEnum2sfx(t)
  implicit def jfxPixelReader2sfx(pr: jfxsi.PixelReader) = new PixelReader {
    override val delegate = pr
  }
  implicit def jfxPixelWriter2sfx(pw: jfxsi.PixelWriter) = new PixelWriter {
    override val delegate = pw
  }
  implicit def jfxWritableImage2sfx(wi: jfxsi.WritableImage) = new WritableImage(wi)
  implicit def jfxWritablePixelFormat2sfx[B <: Buffer](pf: jfxsi.WritablePixelFormat[B]) = new WritablePixelFormat[B](pf) {}
}