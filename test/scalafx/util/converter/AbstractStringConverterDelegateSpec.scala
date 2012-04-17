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

import java.text.SimpleDateFormat
import javafx.{ util => jfxu }
import javafx.util.{ converter => jfxuc }
import scalafx.Includes._
import scalafx.testutil.SimpleSFXDelegateSpec
import scalafx.util.SFXDelegate
import org.scalatest.matchers.ShouldMatchers._

/**
 *
 * @tparam J Java Class (e.g. java.lang.Integer, java.lang.Number, java.util.BigInteger, java.util.Date)
 * @tparam C JavaFX StringConverter using type J (e.g. javafx.util.converter.IntegerStringConverter,
 * javafx.util.converter.BigIntegerStringConverter, javafx.util.converter.DateStringConverter)
 * @tparam S Scala Class (e.g. Int, BigInt)
 * @tparam D Scala StringConverter who wraps type C using type S
 *
 * @param javaConverterClass C class, to be send to superclass
 * @param scalaConverterClass D class, to be send to superclass
 * @param scalaClass S class
 */
abstract private[converter] class AbstractStringConverterDelegateSpec[J <: java.lang.Object, C <: jfxu.StringConverter[J], S <: Any, D <: StringConverterDelegate[_, S, C]] protected (javaConverterClass: Class[C], scalaConverterClass: Class[D], scalaClass: Class[S])
  extends SimpleSFXDelegateSpec[C, D](javaConverterClass, scalaConverterClass) {

  private def runConverterForExamples {

    val converter = this.getConverterForExample

    def runConversionsForExamples(s: S, string: String) = {
      converter.toString(s) should be(string)
      val result = converter.fromString(string)
      result should equal(s)
    }

    examples.foreach(example => runConversionsForExamples(example._1, example._2))
  }

  protected val dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")

  protected val examples: List[(S, String)]

  protected def getConverterForExample = this.getScalaClassInstance

  protected def getJavaClassInstance = javaConverterClass.newInstance

  it should "convert %s to String and vice-versa".format(scalaClass) in {
    this.runConverterForExamples
  }

}