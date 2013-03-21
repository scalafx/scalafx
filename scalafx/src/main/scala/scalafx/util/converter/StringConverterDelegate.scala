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
package scalafx.util.converter

import javafx.{ util => jfxu }
import scalafx.delegate.SFXDelegate
import scalafx.util.StringConverter

/**
 * Class responsible for wrap a StringConverter from a Java type to a Scala type (eg:
 * java.lang.Integer to Int, java.lang.Character to Char). Eventually Java and Scala types can be
 * the same (like java.util.Date or java.lang.Number), so it must be used
 * StringConverterJavaToJavaDelegate class.
 *
 * @tparam J Java Class (e.g. java.lang.Integer, java.lang.Number, java.util.BigInteger, java.util.Date)
 * @tparam S Scala CLass (e.g. Int, BigInt)
 * @tparam C JavaFX StringConverter using type J (e.g. javafx.util.converter.IntegerStringConverter,
 * javafx.util.converter.BigIntegerStringConverter, javafx.util.converter.DateStringConverter)
 *
 * @param delegate JavaFx StringConverter to be wrapped.
 */
abstract class StringConverterDelegate[J <: java.lang.Object, S <: Any, C <: jfxu.StringConverter[J]] protected (override val delegate: C)
  extends StringConverter[S]
  with SFXDelegate[C] {

  def fromString(string: String): S = delegate.fromString(string).asInstanceOf[S]

  def toString(s: S): String = delegate.toString(s.asInstanceOf[J])

}

/**
 * Class responsible for wrap a StringConverter from and to a Java type(eg: java.util.Date or
 * java.lang.Number).
 *
 * @tparam J Java Class (e.g. java.lang.Number, java.util.Date)
 * @tparam C JavaFX StringConverter using type J (e.g. javafx.util.converter.IntegerStringConverter,
 * javafx.util.converter.NumberStringConverter, javafx.util.converter.BigIntegerStringConverter,
 * javafx.util.converter.DateStringConverter)
 *
 * @param delegate JavaFx StringConverter to be wrapped.
 */
abstract class StringConverterJavaToJavaDelegate[J <: java.lang.Object, C <: jfxu.StringConverter[J]] protected (override val delegate: C)
  extends StringConverterDelegate[J, J, C](delegate)