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
package scalafx.scene.image

import javafx.scene.image as jfxsi
import scalafx.Includes.*
import scalafx.delegate.SFXDelegate
import scalafx.scene.paint.Color

import java.nio.Buffer
import scala.language.implicitConversions

object PixelWriter {
  implicit def sfxPixelWriter2jfx(pw: PixelWriter): jfxsi.PixelWriter = if (pw != null) pw.delegate else null
}

/**
 * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/image/PixelWriter.html]]
 */
trait PixelWriter
    extends SFXDelegate[jfxsi.PixelWriter] {

  /**
   * This method returns the PixelFormat in which the surface stores its pixels, or a roughly equivalent pixel format
   * from which it can easily convert pixels for purposes of writing them.
   */
  def pixelFormat: PixelFormat[_] = delegate.getPixelFormat

  /**
   * Stores pixel data for a color into the specified coordinates of the surface.
   */
  def setArgb(x: Int, y: Int, argb: Int): Unit = {
    delegate.setArgb(x, y, argb)
  }

  /**
   * Stores pixel data for a Color into the specified coordinates of the surface.
   */
  def setColor(x: Int, y: Int, c: Color): Unit = {
    delegate.setColor(x, y, c)
  }

  /**
   * Stores pixel data from a byte array into a rectangular region of the surface.
   */
  def setPixels(
    x: Int,
    y: Int,
    w: Int,
    h: Int,
    pixelformat: PixelFormat[java.nio.ByteBuffer],
    buffer: Array[Byte],
    offset: Int,
    scanlineStride: Int
  ): Unit = {
    delegate.setPixels(x, y, w, h, pixelformat, buffer, offset, scanlineStride)
  }

  /**
   * Stores pixel data from an int array into a rectangular region of the surface.
   */
  def setPixels(
    x: Int,
    y: Int,
    w: Int,
    h: Int,
    pixelformat: PixelFormat[java.nio.IntBuffer],
    buffer: Array[Int],
    offset: Int,
    scanlineStride: Int
  ): Unit = {
    delegate.setPixels(x, y, w, h, pixelformat, buffer, offset, scanlineStride)
  }

  /**
   * Stores pixel data from a buffer into a rectangular region of the surface.
   */
  def setPixels[B <: Buffer](
    x: Int,
    y: Int,
    w: Int,
    h: Int,
    pixelformat: PixelFormat[B],
    buffer: B,
    scanlineStride: Int
  ): Unit = {
    delegate.setPixels(x, y, w, h, pixelformat, buffer, scanlineStride)
  }

  /**
   * Stores pixel data retrieved from a PixelReader instance into a rectangular region of the surface.
   */
  def setPixels(dstx: Int, dsty: Int, w: Int, h: Int, reader: PixelReader, srcx: Int, srcy: Int): Unit = {
    delegate.setPixels(dstx, dsty, w, h, reader, srcx, srcy)
  }

}
