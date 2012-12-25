/*
 * Copyright (c) 2011, ScalaFX Project
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
package scalafx.animation

import javafx.{animation => jfxa}
import org.scalatest.matchers.ShouldMatchers._
import org.scalatest.FlatSpec
import scalafx.Includes._
import scalafx.testutil.PropertyComparator
import scalafx.beans.property._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
 * FadeTransition Spec tests.
 *
 * @todo When Interpolator is converted to SFXEnumDelegate, this test should be converted to a SFXEnumDelegateSpec
 */
@RunWith(classOf[JUnitRunner])
class InterpolatorSpec extends FlatSpec with PropertyComparator {
  "Interpolators" should "support all the built-in interpolators" in {
    val doubleProperty = new DoubleProperty(null, "test")
    val kv1 = doubleProperty -> 50 tween Interpolator.DISCRETE
    kv1.interpolator should equal (jfxa.Interpolator.DISCRETE)
    val kv2 = doubleProperty -> 50 tween Interpolator.EASE_BOTH
    kv2.interpolator should equal (jfxa.Interpolator.EASE_BOTH)
    val kv3 = doubleProperty -> 50 tween Interpolator.EASE_IN
    kv3.interpolator should equal (jfxa.Interpolator.EASE_IN)
    val kv4 = doubleProperty -> 50 tween Interpolator.EASE_OUT
    kv4.interpolator should equal (jfxa.Interpolator.EASE_OUT)
    val kv5 = doubleProperty -> 50 tween Interpolator.LINEAR
    kv5.interpolator should equal (jfxa.Interpolator.LINEAR)
  }

  it should "support spline interpolations" in {
    val doubleProperty = new DoubleProperty(null, "test")
    val kv1 = doubleProperty -> 50 tween Interpolator.SPLINE(.2, .2, .8, .8)
    // equals method doesn't work, so the best we can do is test the class type
    kv1.interpolator.getClass should equal (Interpolator.SPLINE(.2, .2, .8, .8).getClass)
  }

  it should "support tangent interpolations" in {
    val doubleProperty = new DoubleProperty(null, "test")
    val kv1 = doubleProperty -> 50 tween Interpolator.TANGENT((100 ms), .3)
    // equals method doesn't work, so the best we can do is test the class type
    kv1.interpolator.getClass should equal (Interpolator.TANGENT((100 ms), .3).getClass)
    val kv2 = doubleProperty -> 50 tween Interpolator.TANGENT((50 ms), .5, (100 ms), .3)
    // equals method doesn't work, so the best we can do is test the class type
    kv2.interpolator.getClass should equal (Interpolator.TANGENT((50 ms), .5, (100 ms), .3).getClass)
  }
}
