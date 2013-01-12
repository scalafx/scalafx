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
   * Convenience method that will create a StringConverter implementation that just makes
   * conversion from object to String. [[fromString]] Method will throw a
   * [[scala.UnsupportedOperationException]].
   *
   * @tparam T Type to convert
   *
   * @param toStringFunction Function that converts a T instance to a new String
   */
  def toStringConverter[T](toStringFunction: T => String) = new StringConverter[T] {

    def fromString(string: String): T =
      throw new UnsupportedOperationException("Convertsior from String not supported. Consider create a new StringConverter impletentation that support it.")

    def toString(t: T): String = toStringFunction(t)

  }

  /**
   * Convenience method that will create a StringConverter implementation that just makes
   * conversion from String to object. [[toString]] Method will throw a
   * [[scala.UnsupportedOperationException]].
   *
   * @tparam T Type to convert
   *
   * @param fromStringFunction Function that converts a String to a new T instance
   */
  def fromStringConverter[T](fromStringFunction: String => T) = new StringConverter[T] {

    def fromString(string: String): T = fromStringFunction(string)

    def toString(t: T): String =
      throw new UnsupportedOperationException("Convertsior to String not supported. Consider create a new StringConverter impletentation that support it.")

  }

}

abstract class StringConverter[T] {

  /**
   * Converts the string provided into an object defined by the specific converter.
   */
  def fromString(string: String): T

  /**
   * Converts the object provided into its string form.
   */
  def toString(t: T): String

}

