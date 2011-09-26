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
import scalafx.beans.property._

class KeyValueSpec extends FlatSpec with PropertyComparator {
  "A KeyValue" should "implement all the JavaFX properties" in {
    compareProperties(classOf[jfxa.KeyValue], classOf[KeyValue[_, _]])
  }

  it should "have a convenient apply construction format for integers" in {
    val integerProperty = new IntegerProperty(null, "test")
    val kv = KeyValue(integerProperty, 50)
    kv.target should equal (integerProperty.delegate)
    kv.endValue should equal (50)
  }

  it should "have a convenient apply construction format for longs" in {
    val longProperty = new LongProperty(null, "test")
    val kv = KeyValue(longProperty, 50l)
    kv.target should equal (longProperty.delegate)
    kv.endValue should equal (50l)
  }

  it should "have a convenient apply construction format for floats" in {
    val floatProperty = new FloatProperty(null, "test")
    val kv = KeyValue(floatProperty, 50f)
    kv.target should equal (floatProperty.delegate)
    kv.endValue should equal (50f)
  }

  it should "have a convenient apply construction format for doubles" in {
    val doubleProperty = new DoubleProperty(null, "test")
    val kv = KeyValue(doubleProperty, 50d)
    kv.target should equal (doubleProperty.delegate)
    kv.endValue should equal (50d)
  }

  it should "have a convenient apply construction format for booleans" in {
    val booleanProperty = new BooleanProperty(null, "test")
    val kv = KeyValue(booleanProperty, true)
    kv.target should equal (booleanProperty.delegate)
    kv.endValue should equal (true)
  }

  it should "have an implicit conversion from SFX to JFX" in {
    val doubleProperty = new DoubleProperty(null, "test")
    val sfxKeyValue = KeyValue(doubleProperty, 50d)
    val jfxKeyValue: jfxa.KeyValue = sfxKeyValue
    jfxKeyValue should be (sfxKeyValue.delegate)
  }

  it should "have an implicit conversion from JFX to SFX" in {
    val doubleProperty = new DoubleProperty(null, "test")
    val jfxKeyValue = new jfxa.KeyValue(doubleProperty, double2Double(50))
    val sfxKeyValue: KeyValue[_, _] = jfxKeyValue
    sfxKeyValue.delegate should be (jfxKeyValue)
  }
}
