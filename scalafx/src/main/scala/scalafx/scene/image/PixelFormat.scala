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

import java.nio.{Buffer, ByteBuffer, IntBuffer}

import javafx.scene.{image => jfxsi}
import scalafx.Includes._
import scalafx.delegate.{SFXDelegate, SFXEnumDelegate, SFXEnumDelegateCompanion}

import scala.language.implicitConversions

object PixelFormat {
  implicit def sfxPixelFormat2jfx[B <: Buffer](pf: PixelFormat[B]): jfxsi.PixelFormat[B] = pf.delegate

  object Type
      extends SFXEnumDelegateCompanion[jfxsi.PixelFormat.Type, Type] {

    /**
     * The pixels are stored in adjacent bytes with the non-premultiplied components stored in order of increasing
     * index: blue, green, red, alpha.
     */
    case object ByteBGRA extends Type(jfxsi.PixelFormat.Type.BYTE_BGRA)
    @deprecated("Use ByteBGRA; BYTE_BGRA will be removed in a future release", "8.0.60-R10")
    val BYTE_BGRA: Type = ByteBGRA

    /**
     * The pixels are stored in adjacent bytes with the premultiplied components stored in order of increasing index:
     * blue, green, red, alpha.
     */
    case object ByteBRGAPre extends Type(jfxsi.PixelFormat.Type.BYTE_BGRA_PRE)

    @deprecated("Use ByteBRGAPre; BYTE_BGRA_PRE will be removed in a future release", "8.0.60-R10")
    val BYTE_BGRA_PRE: Type = ByteBRGAPre

    /**
     * The pixel colors are referenced by byte indices stored in the pixel array, with the byte interpreted as an
     * unsigned index into a list of colors provided by the PixelFormat object.
     */
    case object ByteIndexed extends Type(jfxsi.PixelFormat.Type.BYTE_INDEXED)

    @deprecated("Use ByteIndexed; BYTE_INDEXED will be removed in a future release", "8.0.60-R10")
    val BYTE_INDEXED: Type = ByteIndexed

    /**
     * The opaque pixels are stored in adjacent bytes with the color components stored in order of increasing index:
     * red, green, blue.
     */
    case object ByteRGB extends Type(jfxsi.PixelFormat.Type.BYTE_RGB)

    @deprecated("Use ByteRGB; BYTE_RGB will be removed in a future release", "8.0.60-R10")
    val BYTE_RGB: Type = ByteRGB

    /**
     * The pixels are stored in 32-bit integers with the non-premultiplied components stored in order, from MSb to LSb:
     * alpha, red, green, blue.
     */
    case object IntARGB extends Type(jfxsi.PixelFormat.Type.INT_ARGB)

    @deprecated("Use IntARGB; INT_ARGB will be removed in a future release", "8.0.60-R10")
    val INT_ARGB: Type = IntARGB

    /**
     * The pixels are stored in 32-bit integers with the premultiplied components stored in order, from MSb to LSb:
     * alpha, red, green, blue.
     */
    case object IntARGBPre extends Type(jfxsi.PixelFormat.Type.INT_ARGB_PRE)

    @deprecated("Use IntARGBPre; INT_ARGB_PRE will be removed in a future release", "8.0.60-R10")
    val INT_ARGB_PRE: Type = IntARGBPre

    protected override def unsortedValues: Array[Type] =
      Array(ByteBGRA, ByteBRGAPre, ByteIndexed, ByteRGB, IntARGB, IntARGBPre)

  }

  /**
   * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/image/PixelFormat.Type.html]]
   */
  sealed abstract class Type(override val delegate: jfxsi.PixelFormat.Type)
      extends SFXEnumDelegate[jfxsi.PixelFormat.Type]

  def createByteIndexedInstance(colors: Array[Int]): PixelFormat[ByteBuffer] =
    jfxsi.PixelFormat.createByteIndexedInstance(colors)

  def createByteIndexedPremultipliedInstance(colors: Array[Int]): PixelFormat[ByteBuffer] =
    jfxsi.PixelFormat.createByteIndexedPremultipliedInstance(colors)

  def getByteBgraInstance: WritablePixelFormat[ByteBuffer] = jfxsi.PixelFormat.getByteBgraInstance

  def getByteBgraPreInstance: WritablePixelFormat[ByteBuffer] = jfxsi.PixelFormat.getByteBgraPreInstance

  def getByteRgbInstance: PixelFormat[ByteBuffer] = jfxsi.PixelFormat.getByteRgbInstance

  def getIntArgbInstance: WritablePixelFormat[IntBuffer] = jfxsi.PixelFormat.getIntArgbInstance

  def getIntArgbPreInstance: WritablePixelFormat[IntBuffer] = jfxsi.PixelFormat.getIntArgbPreInstance

}

/**
 * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/image/PixelFormat.html]]
 */
abstract class PixelFormat[B <: Buffer](override val delegate: jfxsi.PixelFormat[B])
    extends SFXDelegate[jfxsi.PixelFormat[B]] {

  /**
   * Reads a 32-bit integer representation of the color from the buffer at the specified coordinates.
   */
  def getArgb(buf: B, x: Int, y: Int, scanlineStride: Int): Int = delegate.getArgb(buf, x, y, scanlineStride)

  /**
   */
  def getType: PixelFormat.Type = delegate.getType

  def premultiplied: Boolean = delegate.isPremultiplied

  def writable: Boolean = delegate.isWritable

}
