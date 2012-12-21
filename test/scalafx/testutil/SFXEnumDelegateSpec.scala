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

package scalafx.testutil

import java.util
import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import scala.collection.JavaConversions.iterableAsScalaIterable
import scalafx.util.{SFXEnumDelegateCompanion, SFXEnumDelegate}


/** Abstract class that facilitates testing of wrappers for Java enums.
  *
  * The extending classes need to also provide implicit conversion tests that utilize `canConvert` method.
  * Here a complete test implemented using `SFXEnumDelegateSpec`,
  * {{{
  *   class HPosSpec extends SFXEnumDelegateSpec[jfxg.HPos, HPos](
  *    javaClass = classOf[jfxg.HPos],
  *    scalaClass = classOf[HPos],
  *    javaValueOfFun = (s: String) => jfxg.HPos.valueOf(s),
  *    companion = HPos) {
  *
  *    it should "have implicit conversion JFX to SFX" in {
  *      canConvert[jfxg.HPos, HPos]() should be(true)
  *    }
  *
  *    it should "have implicit conversion SFX to JFX" in {
  *      canConvert[HPos, jfxg.HPos]() should be(true)
  *    }
  *  }
  * }}}
  *
  * @tparam J JavaFX enum type
  * @tparam S ScalaFX wrapper type
  *
  * @param javaClass JavaFX class
  * @param scalaClass SFXDelegate subclass related with JavaFX class
  * @param javaValueOfFun `J.valueOf(String)` function.
  * @param companion companion object of the ScalaFX wrapper class.
  */
class SFXEnumDelegateSpec[J <: Enum[J], S <: SFXEnumDelegate[J]](javaClass: Class[J],
                                                                 scalaClass: Class[S],
                                                                 javaValueOfFun: String => J,
                                                                 companion: SFXEnumDelegateCompanion[J, S])
  extends FlatSpec
  with ShouldMatchers
  with PropertyComparator {

  private val javaValues = util.EnumSet.allOf(javaClass).toList
  private val scalaClassName = scalaClass.getName
  private val javaClassName = javaClass.getName

  "%s wrapper for JavaFX enum".format(scalaClassName) should "declare all public static methods of " + javaClassName in {
    compareStaticMethods(javaClass, scalaClass)
  }

  it should "have the same number of values as " + javaClassName in {
    companion.values.size should equal(javaValues.size)
  }

  it should "return values in the same order as " + javaClassName in {
    companion.values zip javaValues foreach {p => p._1 should equal(p._2)}
  }

  it should "lookup the same values as " + javaClassName in {
    javaValues foreach {jv => companion.valueOf(jv.toString) should equal(jv)}
    companion.values foreach {sv => javaValueOfFun(sv.toString) should equal(sv.delegate)}
  }

  it should "return the same `toString`" in {
    javaValues foreach {jv => companion.valueOf(jv.toString).toString should equal(jv.toString)}
  }

  it should "not find a non registered name among enum constants" in {
    intercept[IllegalArgumentException] {
      companion.valueOf("!@#$%")
    }
  }

  it should "thhrow `IllegalArgumentException` if the argument is `null`" in {
    intercept[IllegalArgumentException] {
      companion.valueOf(null)
    }
  }


  /**
   * Implicit conversion checker suggested by [[http://stackoverflow.com/questions/5717868/test-if-implicit-conversion-is-available Moritz]]
   */
  def canConvert[A, B]()(implicit f: A => B = noConversion) =
    (f ne NoConversion)

  private case object NoConversion extends (Any => Nothing) {
    def apply(x: Any) = sys.error("No conversion")
  }

  // Just for convenience so NoConversion does not escape the scope.
  private def noConversion: Any => Nothing = NoConversion
}
