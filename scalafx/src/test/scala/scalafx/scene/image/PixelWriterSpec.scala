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

import java.nio.Buffer

/**
 * PixelWriter Spec tests.
 */
class PixelWriterSpec
    extends SimpleSFXDelegateSpec[jfxsi.PixelWriter, PixelWriter](classOf[jfxsi.PixelWriter], classOf[PixelWriter]) {

  override protected def getScalaClassInstance: PixelWriter = new PixelWriter {
    override val delegate: jfxsi.PixelWriter = getJavaClassInstance
  }

  override protected def getJavaClassInstance: jfxsi.PixelWriter = new jfxsi.PixelWriter {
    def getPixelFormat: jfxsi.PixelFormat[? <: Buffer] = null

    def setArgb(x: Int, y: Int, argb: Int): Unit = {}

    def setColor(x: Int, y: Int, c: jfxsp.Color): Unit = {}

    def setPixels(
      x: Int,
      y: Int,
      w: Int,
      h: Int,
      pixelformat: jfxsi.PixelFormat[java.nio.ByteBuffer],
      buffer: Array[Byte],
      offset: Int,
      scanlineStride: Int
    ): Unit = {}

    def setPixels(
      x: Int,
      y: Int,
      w: Int,
      h: Int,
      pixelformat: jfxsi.PixelFormat[java.nio.IntBuffer],
      buffer: Array[Int],
      offset: Int,
      scanlineStride: Int
    ): Unit = {}

    def setPixels[B <: Buffer](
      x: Int,
      y: Int,
      w: Int,
      h: Int,
      pixelformat: jfxsi.PixelFormat[B],
      buffer: B,
      scanlineStride: Int
    ): Unit = {}

    def setPixels(dstx: Int, dsty: Int, w: Int, h: Int, reader: jfxsi.PixelReader, srcx: Int, srcy: Int): Unit = {}
  }
}
