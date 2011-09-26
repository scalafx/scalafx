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

package scalafx.util

import javafx.{util => jfxu}
import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers._
import scalafx.Includes._

class DurationSpec extends FlatSpec {
  "A Duration" should "be constructable from apply" in {
    Duration(500) should equal (new jfxu.Duration(500))
  }

  it should "be constructable from ms, s, m, and h" in {
    (500 ms) should equal (Duration(500))
    (5 s) should equal (Duration(5000))
    (10 m) should equal (Duration(600000))
    (1 h) should equal (Duration(3600000))
  }

  it should "expose INDEFINITE, ONE, UNKNOWN, and ZERO" in {
    Duration.INDEFINITE should equal (jfxu.Duration.INDEFINITE)
    Duration.ONE should equal (jfxu.Duration.ONE)
    Duration.UNKNOWN should equal (jfxu.Duration.UNKNOWN)
    Duration.ZERO should equal (jfxu.Duration.ZERO)
  }
}