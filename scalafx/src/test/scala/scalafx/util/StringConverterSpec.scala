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

/**
 *
 */
package scalafx.util

import javafx.{ util => jfxu }
import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers._
import org.scalatest.matchers._
import scalafx.Includes._
import scalafx.util.StringConverter._
import java.{ text => jt }
import java.util._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import java.util.Calendar
import java.text.ParseException
import java.text.DecimalFormatSymbols

/**
 * StringConverter Spec tests.
 *
 */
@RunWith(classOf[JUnitRunner])
class StringConverterSpec extends FlatSpec {

  // Just For Fun
  object TFBooleanConverter extends StringConverter[Boolean] {
    def toString(b: Boolean) = if (b) "t" else "f"

    def fromString(s: String) = s match {
      case "t" => true
      case "f" => false
      case _   => throw new java.text.ParseException("'%s' can not be converted to a boolean".format(s), 0)
    }
  }

  // Getting decimal and group separator from current Locale 
  private val symbols = DecimalFormatSymbols.getInstance()
  val decimalSeparator = symbols.getDecimalSeparator
  val groupSeparator = symbols.getGroupingSeparator

  // HELPER METHODS - BEGIN

  private def testIrregularStringConversion[T](converter: StringConverter[T], isNumberFormat: Boolean) {
    it should "not convert a Irregular String" in {
      if (isNumberFormat) {
        intercept[NumberFormatException] {
          converter.fromString("ABCSDE")
        }
      } else {
        intercept[ParseException] {
          converter.fromString("ABCSDE")
        }
      }
    }
  }

  private def testNullStringConversion[T](converter: StringConverter[T], isNumberFormat: Boolean) {
    it should "not convert a Null String" in {
      if (isNumberFormat) {
        intercept[NumberFormatException] {
          converter.fromString(null)
        }
      } else {
        intercept[NullPointerException] {
          converter.fromString(null)
        }
      }
    }
  }

  private def testConversion[T](converter: StringConverter[T], string: String, value: T, converterName: String, typeName: String) {
    converterName should "convert '%s' in a %s and vice-versa".format(string, typeName) in {
      val numericValue = converter.fromString(string)
      numericValue should equal(value)
      converter.toString(numericValue) should equal(string)
    }
  }

  // HELPER METHODS - END

  // TESTING METHODS - BEGIN

  private def testImplicitConversion() {
    "A Scala StringConverter" should "be converteble to a JavaFX StringConverter" in {
      val sc = StringConverter[Char](s => s.charAt(0), ch => ch.toString)
      val jc: jfxu.StringConverter[Char] = sc

      jc.isInstanceOf[jfxu.StringConverter[_]] should be(true)
    }

    "A JavaFX StringConverter" should "be converteble to a Scala StringConverter" in {
      val jc = new jfxu.StringConverter[Char] {
        def toString(c: Char) = c.toString
        def fromString(s: String) = s.charAt(0)
      }
      val sc: StringConverter[Char] = jc

      sc.isInstanceOf[StringConverter[_]] should be(true)
    }
  }

  // TESTING METHODS - END

  // TESTS EXECUTION

  testImplicitConversion()

}