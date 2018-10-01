/*
 * Copyright (c) 2011-2014, ScalaFX Project
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
package scalafx.css

import java.io.{DataInputStream, DataOutputStream}

import javafx.{css => jfxcss}

import scala.collection.JavaConversions._
import scala.language.implicitConversions
import scalafx.delegate.SFXDelegate
import scalafx.scene.text.Font
import scalafx.scene.text.Font.sfxFont2jfx

/**
 * Companion object for [[scalafx.css.StyleConverter]].
 */
object StyleConverter {

  /**
   * Converts a ScalaFX StyleConverter to its JavaFX counterpart.
   *
   * @param s ScalaFX StyleConverter
   * @tparam F
   * @tparam T
   * @return JavaFX StyleConverter
   */
  implicit def sfxStyleConverterProperty2jfx[F, T](s: StyleConverter[F, T]): jfxcss.StyleConverter[F, T] =
    if (s != null) s.delegate else null

  // CONVERTERS

  def booleanConverter: StyleConverter[String, java.lang.Boolean] =
    new StyleConverter(jfxcss.StyleConverter.getBooleanConverter)

  def colorConverter: StyleConverter[String, javafx.scene.paint.Color] =
    new StyleConverter(jfxcss.StyleConverter.getColorConverter)

  def effectConverter: StyleConverter[Array[jfxcss.ParsedValue[_, _]], javafx.scene.effect.Effect] =
    new StyleConverter(jfxcss.StyleConverter.getEffectConverter)

  def enumConverter[E <: Enum[E]](enumClass: Class[E]): StyleConverter[String, _ <: Enum[_]] =
    new StyleConverter(jfxcss.StyleConverter.getEnumConverter(enumClass))

  def fontConverter: StyleConverter[Array[jfxcss.ParsedValue[_, _]], javafx.scene.text.Font] =
    new StyleConverter(jfxcss.StyleConverter.getFontConverter)

  def insetsConverter: StyleConverter[Array[jfxcss.ParsedValue[_, _]], javafx.geometry.Insets] =
    new StyleConverter(jfxcss.StyleConverter.getInsetsConverter)

  def paintConverter: StyleConverter[jfxcss.ParsedValue[_, javafx.scene.paint.Paint], javafx.scene.paint.Paint] =
    new StyleConverter(jfxcss.StyleConverter.getPaintConverter)

  /**
   * CSS length and number values are parsed into a Size object that is converted to a Number
   * before the value is applied.
   */
  def sizeConverter: StyleConverter[_, Number] =
    new StyleConverter(jfxcss.StyleConverter.getSizeConverter)

  /**
   * A converter for quoted strings which may have embedded unicode characters.
   */
  def stringConverter: StyleConverter[String, String] =
    new StyleConverter(jfxcss.StyleConverter.getStringConverter)

  /**
   * A converter for URL strings.
   */
  def urlConverter: StyleConverter[Array[jfxcss.ParsedValue[_, _]], String] =
    new StyleConverter(jfxcss.StyleConverter.getUrlConverter)

  /**
   * Read binary data stream.
   * @param is      the data input stream
   * @param strings the strings
   * @return the style converter
   * @throws java.io.IOException the exception
   * @since 9
   */
  def readBinary(is: DataInputStream, strings: Array[String]): StyleConverter[_, _] =
    new StyleConverter(jfxcss.StyleConverter.readBinary(is, strings))

  /**
   * Clear the cache.
   * @since 9
   */
  def clearCache(): Unit = jfxcss.StyleConverter.clearCache()

  /**
   * The StringStore class
   *
   * @since 9
   */
  class StringStore(override val delegate: jfxcss.StyleConverter.StringStore = new jfxcss.StyleConverter.StringStore)
    extends SFXDelegate[jfxcss.StyleConverter.StringStore]{

    def strings: Seq[String] = delegate.strings.toSeq

    def addString(s: String): Int = delegate.addString(s)

    def writeBinary(os: DataOutputStream): Unit = delegate.writeBinary(os)

    def readBinary(is: DataInputStream): Array[String] = jfxcss.StyleConverter.StringStore.readBinary(is)
  }
}

/**
 * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/css/StyleConverter.html JavaFX
 * StyleConverter]].
 *
 * @constructor Creates a new ScalaFX StyleConverter from a JavaFX StyleConverter. 
 *              Its default value is a new JavaFX StyleConverter.
 * @param delegate JavaFX StyleConverter.
 * @tparam F
 * @tparam T
 * @since 8.0
 */
class StyleConverter[F, T](override val delegate: jfxcss.StyleConverter[F, T] = new jfxcss.StyleConverter)
  extends SFXDelegate[jfxcss.StyleConverter[F, T]] {

  /**
   * Convert from the parsed CSS value to the target property type.
   *
   * @param value The ParsedValue to convert
   * @param font The Font to use when converting a relative value
   */
  def convert(value: jfxcss.ParsedValue[F, T], font: Font): T = delegate.convert(value, font)

}