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

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import scalafx.util.SFXEnumDelegate


/** Abstract class that facilitates testing of wrappers for Java enums.
  *
  * @tparam J JavaFX enum type
  * @tparam S ScalaFX wrapper type
  *
  * @param javaClass JavaFX class
  * @param scalaClass SFXDelegate subclass related with JavaFX class
  * @param javaValuesFun `J.values()` function.
  * @param javaValueOfFun `J.valueOf(String)` function.
  * @param scalaValuesFun `S.values()` function.
  * @param scalaValueOfFun `S.valueOf(String)` function.
  *
  * @todo It should be possible to shorten the parameter list of the constructor.
  *       That is, it should be possible to derive some of the parameter values.
  */
class AbstractSFXEnumDelegateSpec[J <: Enum[J], S <: SFXEnumDelegate[J]](javaClass: Class[J],
                                                                         scalaClass: Class[S],
                                                                         javaValuesFun: Unit => Array[J],
                                                                         javaValueOfFun: String => J,
                                                                         scalaValuesFun: Unit => List[S],
                                                                         scalaValueOfFun: String => S)
  extends FlatSpec
  with ShouldMatchers
  with PropertyComparator {

  val scalaClassName = scalaClass.getName
  val javaClassName = javaClass.getName

  "%s wrapper for JavaFX enum".format(scalaClassName) should "declare all public static methods of " + javaClassName in {
    compareStaticMethods(javaClass, scalaClass)
  }

  it should "have the same number of values as " + javaClassName in {
    scalaValuesFun().size should equal(javaValuesFun().length)
  }

  it should "return values in the same order as " + javaClassName in {
    for ((sv, jv) <- scalaValuesFun() zip javaValuesFun()) {
      sv should equal(jv)
    }
  }

  it should "lookup the same values as " + javaClassName in {
    for (v <- javaValuesFun()) {
      val sv = scalaValueOfFun(v.toString)
      sv.delegate should equal(v)
    }

    for (sv <- scalaValuesFun()) {
      val v = javaValueOfFun(sv.toString)
      v should equal(sv.delegate)
    }
  }

  it should "return the same `toString`" in {
    for (jv <- javaValuesFun()) {
      val sv = scalaValueOfFun(jv.toString)
      sv.toString should equal(jv.toString)
    }
  }
}
