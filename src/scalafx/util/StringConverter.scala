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

package scalafx.util

import java.{ text => jt }
import javafx.{ util => jfxu }
import java.util.Date

object StringConverter {

  /**
   * Converts a ScalaFX StringConverter to a JavaFX StringConverter
   *
   * @param s ScalaFX StringConverter
   */
  implicit def sfxStringConverter2jfx[T](s: StringConverter[T]) = new jfxu.StringConverter[T] {

    def fromString(string: String): T = s.fromString(string)

    def toString(t: T): String = s.toString(t)

  }

  /**
   * Generates a StringConverter from a Pair of Conversions Functions
   *
   * @tparam T Type to convert
   *
   * @param fromStringFunction Function that converts a String to a new T instance
   * @param toStringFunction Function that converts a T instance to a new String
   */
  def apply[T](fromStringFunction: String => T, toStringFunction: T => String) = new StringConverter[T] {

    def fromString(string: String): T = fromStringFunction(string)

    def toString(t: T): String = toStringFunction(t)

  }

  /**
   * StringConverter that uses pattern to make conversions.
   *
   * @param formatter A java.text.Format that makes parsing and formatting.
   */
  class FormatConverter[T](protected val formatter: jt.Format) extends jfxu.StringConverter[T] {

    def fromString(string: String): T = formatter.parseObject(string).asInstanceOf[T]

    def toString(t: T): String = formatter.format(t)

  }

  sealed class NumberFormatConverter[N](pattern: String, converter: (Number) => N) extends jfxu.StringConverter[N] {
    val formatter = new jt.DecimalFormat(pattern)

    def fromString(string: String): N = converter(formatter.parse(string))

    def toString(n: N): String = formatter.format(n)

  }

  /**
   * Makes a Conversion from String to a Date and vice-versa using a pattern.
   * See http://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html for more details.
   *
   * Example:
   * {{{
   * val converter = StringConverter.dateFormatterConverter("dd/MM/yyyy")
   * }}}
   */
  def dateFormatterConverter(pattern: String) = new FormatConverter[Date](new jt.SimpleDateFormat(pattern))

  /**
   * Makes a Conversion from String to a Byte and vice-versa using a pattern.
   * See http://docs.oracle.com/javase/7/docs/api/java/text/DecimalFormat.html for more details.
   */
  def byteFormatterConverter(pattern: String) = new NumberFormatConverter[Byte](pattern, (n => n.byteValue))

  /**
   * A Byte converter with no special pattern.
   *
   * @return A Byte converter with no special pattern.
   */
  lazy val byteSimpleConverter = apply[Byte]((s => s.toByte), (b => b.toString))

  /**
   * Makes a Conversion from String to a Short and vice-versa using a pattern.
   * See http://docs.oracle.com/javase/7/docs/api/java/text/DecimalFormat.html for more details.
   */
  def shortFormatterConverter(pattern: String) = new NumberFormatConverter[Short](pattern, (n => n.shortValue))

  /**
   * A Short converter with no special pattern.
   *
   * @return A Short converter with no special pattern.
   */
  lazy val shortSimpleConverter = apply[Short]((s => s.toShort), (s => s.toString))

  /**
   * Makes a Conversion from String to a Int and vice-versa using a pattern.
   * See http://docs.oracle.com/javase/7/docs/api/java/text/DecimalFormat.html for more details.
   */
  def intFormatterConverter(pattern: String) = new NumberFormatConverter[Int](pattern, n => n.intValue)

  /**
   * A Int converter with no special pattern.
   *
   * @return A Int converter with no special pattern.
   */
  lazy val intSimpleConverter = apply[Int]((s => s.toInt), (i => i.toString))

  /**
   * Makes a Conversion from String to a Long and vice-versa using a pattern.
   * See http://docs.oracle.com/javase/7/docs/api/java/text/DecimalFormat.html for more details.
   */
  def longFormatterConverter(pattern: String) = new NumberFormatConverter[Long](pattern, (n => n.longValue()))

  /**
   * A Long converter with no special pattern.
   *
   * @return A Long converter with no special pattern.
   */
  lazy val longSimpleConverter = apply[Long]((s => s.toLong), (l => l.toString))

  /**
   * Makes a Conversion from String to a Float and vice-versa using a pattern.
   * See http://docs.oracle.com/javase/7/docs/api/java/text/DecimalFormat.html for more details.
   */
  def floatFormatterConverter(pattern: String) = new NumberFormatConverter[Float](pattern, (n => n.floatValue))

  /**
   * A Float converter with no special pattern.
   *
   * @return A Float converter with no special pattern.
   */
  lazy val floatSimpleConverter = apply[Float]((s => s.toFloat), (f => f.toString))

  /**
   * Makes a Conversion from String to a Double and vice-versa using a pattern.
   * See http://docs.oracle.com/javase/7/docs/api/java/text/DecimalFormat.html for more details.
   */
  def doubleFormatterConverter(pattern: String) = new NumberFormatConverter[Double](pattern, (n => n.doubleValue))

  /**
   * A Double converter with no special pattern.
   *
   * @return A Double converter with no special pattern.
   */
  lazy val doubleSimpleConverter = apply[Double]((s => s.toDouble), (d => d.toString))

}

abstract class StringConverter[T] {

  def fromString(string: String): T

  def toString(t: T): String

}

