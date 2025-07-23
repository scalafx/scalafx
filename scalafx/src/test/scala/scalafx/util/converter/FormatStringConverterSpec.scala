/*
 * Copyright (c) 2011-2025, ScalaFX Project
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

import javafx.util.converter as jfxuc
import org.scalatest.matchers.should.Matchers.*
import scalafx.Includes.*
import scalafx.testutil.SimpleSFXDelegateSpec

import java.text.NumberFormat
import java.util.Locale
import scala.language.implicitConversions

/**
 * Test for [[scalafx.util.converter.FormatStringConverterSpec]].
 */
class FormatStringConverterSpec
    extends SimpleSFXDelegateSpec[jfxuc.FormatStringConverter[Number], FormatStringConverter[Number]](
      classOf[jfxuc.FormatStringConverter[Number]],
      classOf[FormatStringConverter[Number]]
    ) {

  override protected def getJavaClassInstance = getScalaClassInstance
  override protected def getScalaClassInstance =
    new FormatStringConverter[Number](NumberFormat.getCurrencyInstance(Locale.US))

  def getConverterForExample: FormatStringConverter[Number] = getScalaClassInstance

  private val examples = List[(Number, String)](
    (0.0, "$0.00"),
    (123.45, "$123.45"),
    (-123.45, "-$123.45")
  )

  private def runConverterForExamples(): Unit = {

    val converter = getConverterForExample

    def runConversionsForExamples(number: Number, string: String): Unit = {
      val numberAsString = converter.toString(number)
      numberAsString should equal(string)

      val stringToNumber = converter.fromString(string)
      stringToNumber should equal(number)
    }

    examples.foreach(example => runConversionsForExamples(example._1, example._2))
  }

  it should "convert Number to String and vice-versa" in {
    this.runConverterForExamples()
  }

}
