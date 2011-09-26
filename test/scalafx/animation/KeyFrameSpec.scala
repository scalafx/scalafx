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

import collection.JavaConversions._
import javafx.{animation => jfxa}
import javafx.{event => jfxe}
import org.scalatest.matchers.ShouldMatchers._
import org.scalatest.FlatSpec
import scalafx.Includes._
import scalafx.testutil.PropertyComparator
import scalafx.beans.property.DoubleProperty

class KeyFrameSpec extends FlatSpec with PropertyComparator {
  "A KeyFrame" should "implement all the JavaFX properties" in {
    compareProperties(classOf[jfxa.KeyFrame], classOf[KeyFrame])
  }

  it should "have a convenient apply construction format and property access for time" in {
    KeyFrame(10 ms).time should equal (10 ms)
  }

  it should "have a convenient apply construction format and property access for name" in {
    KeyFrame(10 ms, name = "sample").name should equal ("sample")
  }

  it should "have a convenient apply construction format and property access for finish handlers" in {
    val finishHandler = new jfxe.EventHandler[jfxe.ActionEvent] {
      def handle(p1: jfxe.ActionEvent) {}
    }
    KeyFrame(10 ms, onFinished = finishHandler).onFinished should equal (finishHandler)
  }

  it should "have a convenient apply construction format and property access for values" in {
    val doubleProperty = new DoubleProperty(null, "sample")
    val frames = Set(
      KeyValue(doubleProperty, 50)
    )
    KeyFrame(10 ms, values = frames).values should equal (setAsJavaSet(frames.map(_.delegate)))
  }

  it should "have an implicit conversion from SFX to JFX" in {
    val sfxKeyFrame = KeyFrame(5 s)
    val jfxKeyFrame: jfxa.KeyFrame = sfxKeyFrame
    jfxKeyFrame should be (sfxKeyFrame.delegate)
  }

  it should "have an implicit conversion from JFX to SFX" in {
    val jfxKeyFrame = new jfxa.KeyFrame(5 s)
    val sfxKeyFrame: KeyFrame = jfxKeyFrame
    sfxKeyFrame.delegate should be (jfxKeyFrame)
  }
}
