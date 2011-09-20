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

package scalafx.beans.binding

import org.scalatest.matchers.ShouldMatchers._
import scalafx.beans.binding.Bindings._
import org.scalatest.{BeforeAndAfterEach, FlatSpec}
import scalafx.beans.property._
import java.lang.Object

class BindingsSpec extends FlatSpec with BeforeAndAfterEach {
  def bean = new Object()
  var booleanProperty1:BooleanProperty = null
  var booleanProperty2:BooleanProperty = null
  var booleanProperty3:BooleanProperty = null
  var integerProperty1:IntegerProperty = null
  var longProperty1:LongProperty = null
  var floatProperty1:FloatProperty = null
  var doubleProperty1:DoubleProperty = null
  var doubleProperty2:DoubleProperty = null
  var doubleProperty3:DoubleProperty = null
  var stringProperty1:StringProperty = null
  var stringProperty2:StringProperty = null
  var stringProperty3:StringProperty = null
  var objectProperty1:ObjectProperty[Object] = null
  var objectProperty2:ObjectProperty[Object] = null
  var objectProperty3:ObjectProperty[Object] = null

  override protected def beforeEach() {
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
    objectProperty1 = new ObjectProperty[Object](null, "Object Property 1")
    objectProperty2 = new ObjectProperty[Object](null, "Object Property 2")
    objectProperty3 = new ObjectProperty[Object](null, "Object Property 3")
  }

  "Bindings" should "support min" in {
    doubleProperty1 <== min(doubleProperty2, doubleProperty3, 25, 26l, 27f, 28d)
    doubleProperty1() should equal (0)
    doubleProperty2() = 50
    doubleProperty3() = 43
    doubleProperty1() should equal (25)
  }

  it should "support max" is (pending)

  it should "support when .. then .. otherwise with all numeric property types" in {
    integerProperty1() = 5
    longProperty1() = 10
    floatProperty1() = 15
    doubleProperty1() = 30
    doubleProperty2 <== when(booleanProperty1) then 31 otherwise integerProperty1
    doubleProperty2() should equal (5)
    doubleProperty2 <== when(booleanProperty1) then 31 otherwise longProperty1
    doubleProperty2() should equal (10)
    doubleProperty2 <== when(booleanProperty1) then 31 otherwise floatProperty1
    doubleProperty2() should equal (15)
    doubleProperty2 <== when(booleanProperty1) then 31 otherwise doubleProperty1
    doubleProperty2() should equal (30)
  }

  it should "support when .. then .. otherwise with all number/property combinations" in {
    doubleProperty2() = 15
    doubleProperty3() = 30
    doubleProperty1 <== when(booleanProperty1) then doubleProperty2 otherwise doubleProperty3
    doubleProperty1() should equal (30)
    doubleProperty1 <== when(booleanProperty1) then doubleProperty2 otherwise 15d
    doubleProperty1() should equal (15)
    doubleProperty1 <== when(booleanProperty1) then 25d otherwise doubleProperty3
    doubleProperty1() should equal (30)
  }

  it should "support when .. then .. otherwise with all different number primitives" in {
    doubleProperty1 <== when(booleanProperty1) then 25d otherwise 15d
    doubleProperty1() should equal (15)
    doubleProperty1 <== when(booleanProperty1) then 25 otherwise 16
    doubleProperty1() should equal (16)
    doubleProperty1 <== when(booleanProperty1) then 25l otherwise 17l
    doubleProperty1() should equal (17)
    doubleProperty1 <== when(booleanProperty1) then 25f otherwise 18f
    doubleProperty1() should equal (18)
  }

  it should "support when .. then .. otherwise with boolean types" in {
    booleanProperty3() = true
    booleanProperty1 <== when(booleanProperty2) then booleanProperty2 otherwise booleanProperty3
    booleanProperty1() should be (true)
    booleanProperty1 <== when(booleanProperty2) then booleanProperty2 otherwise false
    booleanProperty1() should be (false)
    booleanProperty1 <== when(booleanProperty2) then true otherwise booleanProperty3
    booleanProperty1() should be (true)
  }

  it should "support when .. then .. otherwise with string types" in {
    stringProperty2() = "Hello"
    stringProperty3() = "World"
    stringProperty1 <== when (booleanProperty1) then stringProperty3 otherwise stringProperty2
    stringProperty1() should equal ("Hello")
    stringProperty1 <== when (booleanProperty1) then "string before" otherwise stringProperty3
    stringProperty1() should equal ("World")
    stringProperty1 <== when (booleanProperty1) then stringProperty2 otherwise "string after"
    stringProperty1() should equal ("string after")
  }

  it should "support when .. then .. otherwise with object types" in {
    val obj1 = new Object()
    val obj2 = new Object()
    val obj3 = new Object()
    objectProperty2() = obj2
    objectProperty3() = obj3
    objectProperty1 <== when(booleanProperty1) then objectProperty2 otherwise objectProperty3
    objectProperty1() should equal (obj3)
    objectProperty1 <== when(booleanProperty1) then obj1 otherwise objectProperty2
    objectProperty1() should equal (obj2)
    objectProperty1 <== when(booleanProperty1) then objectProperty2 otherwise obj1
    objectProperty1() should equal (obj1)
  }

  it should "support that select* funk..." is (pending)

  it should "support string conversions from everything..." is (pending)

  it should "support null checks from everything..." is (pending)

  it should "support raw javafx mixing (make sure all the implicits are in place)" is (pending)
}
