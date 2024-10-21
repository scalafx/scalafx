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
import scalafx.delegate.SFXDelegate

import scala.language.implicitConversions

object WritablePixelFormat {
  implicit def sfxWritablePixelFormat2jfx[B <: Buffer](wpf: WritablePixelFormat[B]): jfxsi.WritablePixelFormat[B] =
    if (null == wpf) null else wpf.delegate
}

/**
 * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/image/WritablePixelFormat.html]]
 */
abstract class WritablePixelFormat[B <: Buffer](override val delegate: jfxsi.WritablePixelFormat[B])
    extends PixelFormat(delegate)
    with SFXDelegate[jfxsi.WritablePixelFormat[B]] {

  /**
   * Stores a 32-bit integer representation of the color in the buffer at the specified coordinates.
   */
  def setArgb(buf: B, x: Int, y: Int, scanlineStride: Int, argb: Int): Unit = {
    delegate.setArgb(buf, x, y, scanlineStride, argb)
  }

}
