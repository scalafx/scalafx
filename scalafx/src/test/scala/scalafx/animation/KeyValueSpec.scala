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
package scalafx.animation

import javafx.{ animation => jfxa }
import org.scalatest.Matchers._
import scalafx.Includes._
import scalafx.beans.property._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import scalafx.testutil.SimpleSFXDelegateSpec
import javafx.beans.{ property => jfxbp }

/**
 * KeyValue Spec tests.
 */
@RunWith(classOf[JUnitRunner])
class KeyValueSpec
  extends SimpleSFXDelegateSpec[jfxa.KeyValue, KeyValue[_, _]](classOf[jfxa.KeyValue], classOf[KeyValue[_, _]]) {

  //////////////////////////////
  // PRIVATE VALUES AND METHODS 
  //////////////////////////////

  private val name = "test"

  private val doubleProperty = new DoubleProperty(null, name)

  private def evaluateFromSfx(property: Property[_, _], endValue: Any, kv: KeyValue[_, _], evaluateInterpolator: Boolean = false) {
    kv.target should equal(property.delegate)
    kv.endValue should equal(endValue)
    if (evaluateInterpolator)
      kv.interpolator should equal(jfxa.Interpolator.EASE_BOTH)
  }

  private def evaluateFromJfx[S, J](property: jfxbp.Property[J], endValue: S, kv: KeyValue[S, J]) {
    kv.target should equal(property.delegate)
    kv.endValue should equal(endValue)
  }

  //////////////////////////////
  // OVERRIDE PROTECTED METHODS 
  //////////////////////////////

  override protected def getScalaClassInstance = KeyValue(doubleProperty, 50d)

  override protected def getJavaClassInstance = new jfxa.KeyValue(doubleProperty, double2Double(50))

  /////////
  // TESTS 
  /////////

  it should "have a convenient apply construction format for integers" in {
    val property = new IntegerProperty(null, name)
    val endValue = 50
    evaluateFromSfx(property, endValue, KeyValue(property, endValue))
  }

  it should "have a convenient apply construction format for jfx integers" in {
    val property = new IntegerProperty(null, name).delegate
    val endValue = 50
    evaluateFromJfx(property, endValue, KeyValue(property, endValue))
  }

  it should "have a convenient apply construction format for longs" in {
    val property = new LongProperty(null, name)
    val endValue = 50l
    evaluateFromSfx(property, endValue, KeyValue(property, endValue))
  }

  it should "have a convenient apply construction format for jfx longs" in {
    val property = new LongProperty(null, name).delegate
    val endValue = 50l
    evaluateFromJfx(property, endValue, KeyValue(property, endValue))
  }

  it should "have a convenient apply construction format for floats" in {
    val property = new FloatProperty(null, name)
    val endValue = 50f
    evaluateFromSfx(property, endValue, KeyValue(property, endValue))
  }

  it should "have a convenient apply construction format for jfx floats" in {
    val property = new FloatProperty(null, name).delegate
    val endValue = 50f
    evaluateFromJfx(property, endValue, KeyValue(property, endValue))
  }

  it should "have a convenient apply construction format for doubles" in {
    val property = new DoubleProperty(null, name)
    val endValue = 50d
    evaluateFromSfx(property, endValue, KeyValue(property, endValue))
  }

  it should "have a convenient apply construction format for jfx doubles" in {
    val property = new DoubleProperty(null, name).delegate
    val endValue = 50d
    evaluateFromJfx(property, endValue, KeyValue(property, endValue))
  }

  it should "have a convenient apply construction format for booleans" in {
    val property = new BooleanProperty(null, name)
    val endValue = true
    evaluateFromSfx(property, endValue, KeyValue(property, endValue))
  }

  it should "have a convenient apply construction format for jfx booleans" in {
    val property = new BooleanProperty(null, name).delegate
    val endValue = true
    evaluateFromJfx(property, endValue, KeyValue(property, endValue))
  }

  it should "have a convenient apply construction format for Objects" in {
    val property = ObjectProperty[Object](null, name)
    val endValue = new Object()
    evaluateFromSfx(property, endValue, KeyValue(property, endValue))
  }

  it should "have a convenient apply construction format for jfx Objects" in {
    val property = ObjectProperty[Object](null, name).delegate
    val endValue = new Object()
    evaluateFromJfx(property, endValue, KeyValue(property, endValue))
  }

  it should "have a convenient creation syntax using the -> operator" in {
    val property = new DoubleProperty(null, name)
    val endValue = 50
    evaluateFromSfx(property, endValue, property -> endValue)
  }

  it should "support interpolators" in {
    val property = new DoubleProperty(null, name)
    val endValue = 50d
    evaluateFromSfx(property, endValue, KeyValue(property, endValue, jfxa.Interpolator.EASE_BOTH), true)
  }

  it should "support interpolators with the ->/tween operator" in {
    val property = new DoubleProperty(null, name)
    val endValue = 50
    evaluateFromSfx(property, endValue, (property -> endValue tween Interpolator.EASE_BOTH), true)
  }
}
