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
import javafx.util.{ converter => jfxuc }
import scalafx.Includes._
import scalafx.testutil.SimpleSFXDelegateSpec
import scalafx.util.SFXDelegate
import org.scalatest.matchers.ShouldMatchers._

/**
 *
 *
 *
 */
abstract class AbstractStringConverterDelegateSpec[J <: java.lang.Object, C <: jfxu.StringConverter[J], S <: Any, D <: StringConverterDelegate[_, S, C]](
  javaConverterClass: Class[C],
  scalaConverterClass: Class[D],
  scalaClass: Class[S])
  extends SimpleSFXDelegateSpec[C, D](javaConverterClass, scalaConverterClass) {

  private def runConverterForExamples[S <: Any, D <: StringConverterDelegate[_, S, _]](converter: D, examples: List[(S, String)]) {

    def runConversionsForExamples(s: S, string: String) = {
      converter.toString(s) should be(string)
      converter.fromString(string) should be(s)
    }

    examples.foreach(example => runConversionsForExamples(example._1, example._2))
  }

  protected val examples: List[(S, String)] = Nil

  protected def getJavaClassInstance = javaConverterClass.newInstance

  it should "convert %s to String and vice-versa".format(scalaClass) in {
    this.runConverterForExamples(this.getScalaClassInstance, examples)
  }

}
