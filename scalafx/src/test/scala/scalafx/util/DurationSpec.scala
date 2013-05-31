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

package scalafx.util

import javafx.{ util => jfxu }
import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers._
import scalafx.Includes._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class DurationSpec extends FlatSpec {
  "A Duration" should "be constructable from apply" in {
    Duration(500) should equal(new jfxu.Duration(500))
  }

  it should "be constructable from ms, s, m, and h" in {
    (500 ms) should equal(Duration(500))
    (5 s) should equal(Duration(5000))
    (10 m) should equal(Duration(600000))
    (1 h) should equal(Duration(3600000))
  }

  it should "expose INDEFINITE, ONE, UNKNOWN, and ZERO" in {
    Duration.INDEFINITE should equal(jfxu.Duration.INDEFINITE)
    Duration.ONE should equal(jfxu.Duration.ONE)
    Duration.UNKNOWN should equal(jfxu.Duration.UNKNOWN)
    Duration.ZERO should equal(jfxu.Duration.ZERO)
  }

  it should "support addition" in {
    (500 ms) + (500 ms) should equal(1 s)
  }

  it should "support subtraction" in {
    (1 s) - (.5 s) should equal(500 ms)
  }

  it should "support multiplication" in {
    (5 m) * 12 should equal(1 h)
  }

  it should "*not* support multiplication of Durations" in {
    // the semantics for multiplying durations is just stupid...  the second test case shows why we are not supporting this
    // (100 ms) * (100 ms) should equal (10000 ms)
    // (5 s) * (5 s) should equal (25000 s) // WTF??? - oh yeah, we are just multiplying milliseconds and ignoring units :(
  }

  it should "support division" in {
    (1 h) / 3 should equal(20 m)
  }

  it should "support proper division of Durations" in {
    // the semantics for dividing durations is equally stupid...  fortunately we can fix it by cancelling units
    (1000 ms) / (100 ms) should equal(10)
    (5 s) / (2.5 s) should equal(2)
  }

  it should "support less than" in {
    (5 ms) < (5 s) should be(true)
    (5 s) < (5 s) should be(false)
    (5 s) < (5 ms) should be(false)
  }

  it should "support less than or equal" in {
    (5 ms) <= (5 s) should be(true)
    (5 s) <= (5 s) should be(true)
    (5 s) <= (5 ms) should be(false)
  }

  it should "support greater than" in {
    (5 s) > (5 ms) should be(true)
    (5 s) > (5 s) should be(false)
    (5 ms) > (5 s) should be(false)
  }

  it should "support greater than or equal" in {
    (5 s) >= (5 ms) should be(true)
    (5 s) >= (5 s) should be(true)
    (5 ms) >= (5 s) should be(false)
  }

  it should "support equal to" in {
    (5 s) == (5 ms) should be(false)
    (5 s) == (5 s) should be(true)
    (5 ms) == (5 s) should be(false)
  }

  it should "support equal to with triple op (===)" in {
    (5 s) === (5 ms) should be(false)
    (5 s) === (5 s) should be(true)
    (5 ms) === (5 s) should be(false)
  }

  it should "support not equal to" in {
    (5 s) != (5 ms) should be(true)
    (5 s) != (5 s) should be(false)
    (5 ms) != (5 s) should be(true)
  }

  it should "support not equal to with triple op (=!=)" in {
    (5 s) =!= (5 ms) should be(true)
    (5 s) =!= (5 s) should be(false)
    (5 ms) =!= (5 s) should be(true)
  }

  it should "support unary negation" in {
    -(5 s) should equal(-5 s)
  }
}
