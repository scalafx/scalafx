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

import javafx.scene.{image as jfxsi, paint as jfxsp}
import scalafx.Includes.*
import scalafx.testutil.SimpleSFXDelegateSpec

import java.nio.{Buffer, ByteBuffer, IntBuffer}

/**
 * PixelReader Spec tests.
 */
class PixelReaderSpec
    extends SimpleSFXDelegateSpec[jfxsi.PixelReader, PixelReader](classOf[jfxsi.PixelReader], classOf[PixelReader]) {

  override protected def getScalaClassInstance: PixelReader = new PixelReader {
    override val delegate: jfxsi.PixelReader = getJavaClassInstance
  }

  override protected def getJavaClassInstance: jfxsi.PixelReader = new jfxsi.PixelReader {
    def getArgb(x: Int, y: Int): Int = 0

    def getColor(x: Int, y: Int): jfxsp.Color = null

    def getPixelFormat: jfxsi.PixelFormat[? <: Buffer] = null

    def getPixels(
      x: Int,
      y: Int,
      w: Int,
      h: Int,
      pixelformat: jfxsi.WritablePixelFormat[ByteBuffer],
      buffer: Array[Byte],
      offset: Int,
      scanlineStride: Int
    ): Unit = {}

    def getPixels(
      x: Int,
      y: Int,
      w: Int,
      h: Int,
      pixelformat: jfxsi.WritablePixelFormat[IntBuffer],
      buffer: Array[Int],
      offset: Int,
      scanlineStride: Int
    ): Unit = {}

    def getPixels[B <: Buffer](
      x: Int,
      y: Int,
      w: Int,
      h: Int,
      pixelformat: jfxsi.WritablePixelFormat[B],
      buffer: B,
      scanlineStride: Int
    ): Unit = {}
  }
}
