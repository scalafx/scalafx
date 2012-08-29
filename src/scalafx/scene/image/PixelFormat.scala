/*
 * Copyright (c) 2012, ScalaFX Project
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

import javafx.scene.{ image => jfxsi }
import scalafx.Includes._
import scalafx.util.SFXDelegate

object PixelFormat {
  implicit def sfxPixelFormat2jfx[B <: Buffer](pf: PixelFormat[B]) = pf.delegate

  def createByteIndexedInstance(colors: Array[Int]): PixelFormat[ByteBuffer] = jfxsi.PixelFormat.createByteIndexedInstance(colors)

  def createByteIndexedPremultipliedInstance(colors: Array[Int]): PixelFormat[ByteBuffer] = jfxsi.PixelFormat.createByteIndexedPremultipliedInstance(colors)

  def getByteBgraInstance: WritablePixelFormat[ByteBuffer] = jfxsi.PixelFormat.getByteBgraInstance

  def getByteBgraPreInstance: WritablePixelFormat[ByteBuffer] = jfxsi.PixelFormat.getByteBgraPreInstance

  def getByteRgbInstance: PixelFormat[ByteBuffer] = jfxsi.PixelFormat.getByteRgbInstance

  def getIntArgbInstance: WritablePixelFormat[IntBuffer] = jfxsi.PixelFormat.getIntArgbInstance

  def getIntArgbPreInstance: WritablePixelFormat[IntBuffer] = jfxsi.PixelFormat.getIntArgbPreInstance

}

/**
 * Wraps [[http://docs.oracle.com/javafx/2/api/javafx/scene/image/PixelFormat.html]]
 */
abstract class PixelFormat[B <: Buffer](override val delegate: jfxsi.PixelFormat[B])
  extends SFXDelegate[jfxsi.PixelFormat[B]] {

  /**
   * Reads a 32-bit integer representation of the color from the buffer at the specified coordinates.
   */
  def getArgb(buf: B, x: Int, y: Int, scanlineStride: Int): Int = delegate.getArgb(buf, x, y, scanlineStride)

  def getType = delegate.getType

  def premultiplied = delegate.isPremultiplied

  def writable = delegate.isWritable

}