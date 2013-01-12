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
import scalafx.delegate.SFXDelegate
import scalafx.delegate.{ SFXEnumDelegateCompanion, SFXEnumDelegate }

object PixelFormat {
  implicit def sfxPixelFormat2jfx[B <: Buffer](pf: PixelFormat[B]) = pf.delegate

  object Type 
    extends SFXEnumDelegateCompanion[jfxsi.PixelFormat.Type, Type] {

    /**
     * The pixels are stored in adjacent bytes with the non-premultiplied components stored in order of increasing 
     * index: blue, green, red, alpha.
     */
    val BYTE_BGRA = new Type(jfxsi.PixelFormat.Type.BYTE_BGRA)

    /**
     * The pixels are stored in adjacent bytes with the premultiplied components stored in order of increasing index: 
     * blue, green, red, alpha.
     */
    val BYTE_BGRA_PRE = new Type(jfxsi.PixelFormat.Type.BYTE_BGRA_PRE)

    /**
     * The pixel colors are referenced by byte indices stored in the pixel array, with the byte interpreted as an 
     * unsigned index into a list of colors provided by the PixelFormat object.
     */
    val BYTE_INDEXED = new Type(jfxsi.PixelFormat.Type.BYTE_INDEXED)

    /**
     * The opaque pixels are stored in adjacent bytes with the color components stored in order of increasing index: 
     * red, green, blue.
     */
    val BYTE_RGB = new Type(jfxsi.PixelFormat.Type.BYTE_RGB)

    /**
     * The pixels are stored in 32-bit integers with the non-premultiplied components stored in order, from MSb to LSb: 
     * alpha, red, green, blue.
     */
    val INT_ARGB = new Type(jfxsi.PixelFormat.Type.INT_ARGB)

    /**
     * The pixels are stored in 32-bit integers with the premultiplied components stored in order, from MSb to LSb: 
     * alpha, red, green, blue.
     */
    val INT_ARGB_PRE = new Type(jfxsi.PixelFormat.Type.INT_ARGB_PRE)

    protected override def unsortedValues: Array[Type] = Array(BYTE_BGRA, BYTE_BGRA_PRE, BYTE_INDEXED, BYTE_RGB, 
        INT_ARGB, INT_ARGB_PRE)

  }
  
  /**
   * Wraps [[http://docs.oracle.com/javafx/2/api/javafx/scene/image/PixelFormat.Type.html]]
   */
  sealed case class Type(override val delegate: jfxsi.PixelFormat.Type)
    extends SFXEnumDelegate[jfxsi.PixelFormat.Type]

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

  /**
   * 
   */
  def getType: PixelFormat.Type = delegate.getType

  def premultiplied = delegate.isPremultiplied

  def writable = delegate.isWritable

}