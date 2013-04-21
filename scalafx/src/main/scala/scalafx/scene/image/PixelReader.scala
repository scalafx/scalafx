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

import java.nio.Buffer
import java.nio.ByteBuffer
import java.nio.IntBuffer

import javafx.scene.{image => jfxsi}
import scalafx.Includes._
import scalafx.scene.paint.Color
import scalafx.delegate.SFXDelegate

object PixelReader {
  implicit def sfxPixelReader2jfx(pr: PixelReader) = pr.delegate
}

/**
 * Wraps [[http://docs.oracle.com/javafx/2/api/javafx/scene/image/PixelReader.html]]
 */
trait PixelReader extends SFXDelegate[jfxsi.PixelReader] {

  /**
   * Reads a 32-bit integer representation of the color of a pixel from the specified coordinates in the surface.
   */
  def getArgb(x: Int, y: Int): Int = delegate.getArgb(x, y)

  /**
   * Reads the color of a pixel from the specified coordinates in the surface and returns the value as a Color object.
   */
  def getColor(x: Int, y: Int): Color = delegate.getColor(x, y)

  /**
   * This method returns the PixelFormat in which the surface stores its pixels, or a roughly equivalent pixel format
   * into which it can easily convert its pixels for purposes of reading them.
   */
  def pixelFormat: PixelFormat[_] = delegate.getPixelFormat

  /**
   * Reads pixel data from a rectangular region of the surface into the specified byte array.
   */
  def getPixels(x: Int, y: Int, w: Int, h: Int, pixelformat: WritablePixelFormat[ByteBuffer], buffer: Array[Byte], offset: Int, scanlineStride: Int) {
    delegate.getPixels(x, y, w, h, pixelformat, buffer, offset, scanlineStride)
  }

  /**
   * Reads pixel data from a rectangular region of the surface into the specified int array.
   */
  def getPixels(x: Int, y: Int, w: Int, h: Int, pixelformat: WritablePixelFormat[IntBuffer], buffer: Array[Int], offset: Int, scanlineStride: Int) {
    delegate.getPixels(x, y, w, h, pixelformat, buffer, offset, scanlineStride)
  }

  /**
   * Reads pixel data from a rectangular region of the surface into the specified buffer.
   */
  def getPixels[B <: Buffer](x: Int, y: Int, w: Int, h: Int, pixelformat: WritablePixelFormat[B], buffer: B, scanlineStride: Int) {
    delegate.getPixels(x, y, w, h, pixelformat, buffer, scanlineStride)
  }

}