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

package scalafx.geometry

import javafx.{geometry => jfxg}
import org.junit.runner.RunWith
import org.scalatest.FlatSpec
import org.scalatest.junit.JUnitRunner
import org.scalatest.matchers.ShouldMatchers
import scalafx.testutil.PropertyComparator

/** Tests for [[scalafx.geometry.VPos]]. */
@RunWith(classOf[JUnitRunner])
class VPosSpec extends FlatSpec with ShouldMatchers with PropertyComparator {

  val javaClass = classOf[jfxg.VPos]
  val scalaClass = classOf[VPos]

  "A %s".format(scalaClass.getSimpleName) should "declare all public static methods of " + javaClass.getName in {
    compareStaticMethods(javaClass, scalaClass)
  }

  it should "have the same number of values as javafx.geometry.VPos" in {
    VPos.values.size should equal(jfxg.VPos.values.length)
  }

  it should "lookup the same values as javafx.geometry.VPos" in {
    for (v <- jfxg.VPos.values) {
      val sv: VPos = VPos.valueOf(v.toString)
      sv should equal(v)
    }

    for (sv <- VPos.values) {
      val v = jfxg.VPos.valueOf(sv.toString)
      v should equal(sv.delegate)
    }
  }

  it should "return the same `toString`" in {
    for (jv <- jfxg.VPos.values) {
      val sv: VPos = VPos.valueOf(jv.toString)
      sv.toString should equal(jv.toString)
    }
  }
}
