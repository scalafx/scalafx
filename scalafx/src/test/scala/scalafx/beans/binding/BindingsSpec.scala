/*
 * Copyright (c) 2011-2021, ScalaFX Project
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

package scalafx.beans.binding

import javafx.beans.property as jfxbp
import org.scalactic.TripleEqualsSupport.Spread
import org.scalatest.BeforeAndAfterEach
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.*
import scalafx.Includes.*
import scalafx.beans.property.*
import scalafx.delegate.SFXDelegate

object BindingsSpec {
  // Simulate ScalaFX wrapper
  class DoubleHolderJFX {
    val widthProperty = new jfxbp.SimpleDoubleProperty(this, "width", 7.0)

    def getWidth: Double = widthProperty.getValue

    def setWidth(v: Double): Unit = widthProperty.setValue(v)
  }

  class DoublePropertySFX(val delegate: DoubleHolderJFX = new DoubleHolderJFX())
      extends SFXDelegate[DoubleHolderJFX] {
    val width: DoubleProperty = delegate.widthProperty
  }
}

/**
 * Bindings Spec tests.
 */
class BindingsSpec extends AnyFlatSpec with BeforeAndAfterEach {

  import BindingsSpec.*

  def bean = new Object()

  var booleanProperty1: jfxbp.BooleanProperty       = _
  var booleanProperty2: jfxbp.BooleanProperty       = _
  var booleanProperty3: jfxbp.BooleanProperty       = _
  var integerProperty1: jfxbp.IntegerProperty       = _
  var longProperty1: jfxbp.LongProperty             = _
  var floatProperty1: jfxbp.FloatProperty           = _
  var doubleProperty1: jfxbp.DoubleProperty         = _
  var doubleProperty2: jfxbp.DoubleProperty         = _
  var doubleProperty3: jfxbp.DoubleProperty         = _
  var stringProperty1: jfxbp.StringProperty         = _
  var stringProperty2: jfxbp.StringProperty         = _
  var stringProperty3: jfxbp.StringProperty         = _
  var objectProperty1: jfxbp.ObjectProperty[Object] = _
  var objectProperty2: jfxbp.ObjectProperty[Object] = _
  var objectProperty3: jfxbp.ObjectProperty[Object] = _

  override protected def beforeEach(): Unit = {
    booleanProperty1 = new BooleanProperty(null, "Boolean Property 1")
    booleanProperty2 = new BooleanProperty(null, "Boolean Property 2")
    booleanProperty3 = new BooleanProperty(null, "Boolean Property 3")
    integerProperty1 = new IntegerProperty(null, "Integer Property 1")
    longProperty1 = new LongProperty(null, "Long Property 1")
    floatProperty1 = new FloatProperty(null, "Float Property 1")
    doubleProperty1 = new DoubleProperty(null, "Double Property 1")
    doubleProperty2 = new DoubleProperty(null, "Double Property 2")
    doubleProperty3 = new DoubleProperty(null, "Double Property 3")
    stringProperty1 = new StringProperty(null, "String Property 1")
    stringProperty2 = new StringProperty(null, "String Property 2")
    stringProperty3 = new StringProperty(null, "String Property 3")
    objectProperty1 = ObjectProperty[Object](null, "Object Property 1")
    objectProperty2 = ObjectProperty[Object](null, "Object Property 2")
    objectProperty3 = ObjectProperty[Object](null, "Object Property 3")
  }

  "BindingIncludes" should "support min" in {
    doubleProperty1 <== min(doubleProperty2, doubleProperty3, 25, 26L, 27f, 28d)
    doubleProperty1() should equal(0)
    doubleProperty2() = 50
    doubleProperty3() = 43
    doubleProperty1() should equal(25)
  }

  "BindingIncludes" should "support max" in {
    doubleProperty1 <== max(doubleProperty2, doubleProperty3, 25, 26L, 27f, 28d)
    doubleProperty1() should equal(28)
    doubleProperty2() = 50
    doubleProperty3() = 43
    doubleProperty1() should equal(50)
  }

  it should "support `when ..choose .. otherwise` with all numeric property types" in {
    integerProperty1() = 5
    longProperty1() = 10
    floatProperty1() = 15
    doubleProperty1() = 30
    doubleProperty2 <== when(booleanProperty1) choose 31 otherwise integerProperty1
    doubleProperty2() should equal(5)
    doubleProperty2 <== when(booleanProperty1) choose 31 otherwise longProperty1
    doubleProperty2() should equal(10)
    doubleProperty2 <== when(booleanProperty1) choose 31 otherwise floatProperty1
    doubleProperty2() should equal(15)
    doubleProperty2 <== when(booleanProperty1) choose 31 otherwise doubleProperty1
    doubleProperty2() should equal(30)
  }

  it should "support `when .. choose .. otherwise with all number/property combinations" in {
    doubleProperty2() = 15
    doubleProperty3() = 30
    doubleProperty1 <== when(booleanProperty1) choose doubleProperty2 otherwise doubleProperty3
    doubleProperty1() should equal(30)
    doubleProperty1 <== when(booleanProperty1) choose doubleProperty2 otherwise 15d
    doubleProperty1() should equal(15)
    doubleProperty1 <== when(booleanProperty1) choose 25d otherwise doubleProperty3
    doubleProperty1() should equal(30)
  }

  it should "support `when .. choose .. otherwise` with all different number primitives" in {
    doubleProperty1 <== when(booleanProperty1) choose 25d otherwise 15d
    doubleProperty1() should equal(15)
    doubleProperty1 <== when(booleanProperty1) choose 25 otherwise 16
    doubleProperty1() should equal(16)
    doubleProperty1 <== when(booleanProperty1) choose 25L otherwise 17L
    doubleProperty1() should equal(17)
    doubleProperty1 <== when(booleanProperty1) choose 25f otherwise 18f
    doubleProperty1() should equal(18)
  }

  it should "support `when .. choose .. otherwise` with boolean types" in {
    booleanProperty3() = true
    booleanProperty1 <== when(booleanProperty2) choose booleanProperty2 otherwise booleanProperty3
    booleanProperty1() should be(true)
    booleanProperty1 <== when(booleanProperty2) choose booleanProperty2 otherwise false
    booleanProperty1() should be(false)
    booleanProperty1 <== when(booleanProperty2) choose true otherwise booleanProperty3
    booleanProperty1() should be(true)
  }

  it should "support `when .. choose .. otherwise` with string types" in {
    stringProperty2() = "Hello"
    stringProperty3() = "World"
    stringProperty1 <== when(booleanProperty1) choose stringProperty3 otherwise stringProperty2
    stringProperty1() should equal("Hello")
    stringProperty1 <== when(booleanProperty1) choose "string before" otherwise stringProperty3
    stringProperty1() should equal("World")
    stringProperty1 <== when(booleanProperty1) choose stringProperty2 otherwise "string after"
    stringProperty1() should equal("string after")
  }

  it should "support `when .. choose .. otherwise` with object types" in {
    val obj1 = new Object()
    val obj2 = new Object()
    val obj3 = new Object()
    objectProperty2() = obj2
    objectProperty3() = obj3
    objectProperty1 <== when(booleanProperty1) choose objectProperty2 otherwise objectProperty3
    objectProperty1() should equal(obj3)
    // TODO Scala 3: Original two lines of code do not compile with Scala 3.0.0-RC2
    //    objectProperty1 <== when(booleanProperty1) choose obj1 otherwise objectProperty2
    //    objectProperty1() should equal(obj2)
    objectProperty1 <== when(booleanProperty1) choose objectProperty2 otherwise obj1
    objectProperty1() should equal(obj1)
  }

  it should "support selectDouble" in {
    // Test for other select* variants should be similar
    val dp1   = new ObjectProperty[DoubleHolderJFX](this, "level 2 property", new DoubleHolderJFX())
    val prop2 = new DoubleProperty(this, "prop2", 0.0)
    prop2() should equal(0.0)

    prop2 <== dp1.selectDouble("width")
    prop2() should equal(7.0)

    dp1().setWidth(3.0)
    prop2() should equal(3.0)
  }

  it should "support createBooleanBinding" in {
    val a   = new BooleanProperty()
    val b   = new BooleanProperty()
    val xor = Bindings.createBooleanBinding(() => (a() || b()) && !(a() && b()), a, b)

    a() = true
    b() = true
    xor() should be(false)

    a() = false
    b() = true
    xor() should be(true)

    a() = true
    b() = false
    xor() should be(true)

    a() = false
    b() = false
    xor() should be(false)
  }

  it should "support createDoubleBinding" in {
    val a = new DoubleProperty()
    val b = Bindings.createDoubleBinding(() => a.value * a.value, a)

    // NOTE: using `Spread` instead `+-` to avoid operator clash between ScalaFX and ScalaTest
    a.value = 1.0
    b.doubleValue should be(Spread(1.0, 0.1))

    a.value = 2d
    b.doubleValue should be(Spread(4d, 0.1))
  }

  it should "support createFloatBinding" in {
    val a = new FloatProperty()
    val b = Bindings.createFloatBinding(() => a.value * a.value, a)

    // NOTE: using `plusOrMinus` instead `+-` to avoid operator clash between ScalaFX and ScalaTest
    a.value = 1.0f
    b.floatValue should be(Spread(1.0f, 0.1f))

    a.value = 2d
    b.floatValue should be(Spread(4.0f, 0.1f))
  }

  it should "support createIntegerBinding" in {
    val a = new IntegerProperty()
    val b = Bindings.createIntegerBinding(() => a.value * a.value, a)

    a.value = 1
    a() should be(1)

    a.value = 2
    b() should be(4)
  }

  it should "support createLongBinding" in {
    val a = new LongProperty()
    val b = Bindings.createLongBinding(() => a.value * a.value, a)

    a.value = 1L
    a() should be(1L)

    a.value = 2L
    b() should be(4L)
  }

  it should "support createObjectBinding" in {
    val a = new ObjectProperty[String]()
    val b = Bindings.createObjectBinding(() => Option(a.value).getOrElse("").toLowerCase(), a)

    a.value = "HEllO"
    b() should be("hello")
  }

  it should "support createStringBinding" in {
    val a = new StringProperty()
    val b = Bindings.createStringBinding(() => Option(a.value).getOrElse("").toLowerCase(), a)

    a.value = "HEllO"
    b() should be("hello")
  }

  it should "support that select* funk..." is pending

  it should "support string conversions from everything..." is pending

  it should "support implicit upconversions to expressions..." is pending

  it should "support raw javafx mixing (make sure all the implicits are in place)" is pending

  it should "test the SFX 'any' special cases" is pending
}
