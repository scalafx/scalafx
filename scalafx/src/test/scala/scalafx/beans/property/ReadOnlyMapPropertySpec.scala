/*
 * Copyright (c) 2011-2020, ScalaFX Project
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

package scalafx.beans.property

import javafx.beans.{property => jfxbp}
import org.scalatest.Matchers._
import org.scalatest.{BeforeAndAfterEach, FlatSpec}
import scalafx.Includes._
import scalafx.collections.ObservableMap

/**
 * ReadOnlyMapProperty Spec tests.
 */
class ReadOnlyMapPropertySpec extends FlatSpec with BeforeAndAfterEach {

  private val valueAsSeq = Seq("one" -> 1, "two" -> 2, "seven" -> 7)
  private val bean = new Object()

  private var readOnlyMapProperty: jfxbp.ReadOnlyMapProperty[String, Int] = _
  private var mapProperty1: jfxbp.MapProperty[String, Int] = _
  private var mapProperty2: jfxbp.MapProperty[String, Int] = _

  override def beforeEach(): Unit = {

    val roWrapper = new ReadOnlyMapWrapper(bean, "Test Read-only Boolean", ObservableMap(valueAsSeq))
    readOnlyMapProperty = roWrapper.readOnlyProperty
    mapProperty1 = MapProperty[String, Int](bean, "Test Boolean 2")
    mapProperty2 = new MapProperty[String, Int](bean, "Test Boolean 3")
  }

  "A Read-only Boolean Property" should "return a fixed value" in {
    readOnlyMapProperty.value should be(ObservableMap(valueAsSeq).delegate)
  }

  it should "return its value using apply" in {
    readOnlyMapProperty() should be(ObservableMap(valueAsSeq).delegate)
  }

  it should "know its name" in {
    readOnlyMapProperty.name should equal("Test Read-only Boolean")
  }

  it should "know its bean" in {
    readOnlyMapProperty.bean should equal(bean)
  }

  it should "report not empty property" in {
    readOnlyMapProperty.empty.value should equal(false)
  }

  it should "report size property" in {
    readOnlyMapProperty.sizeProperty().value should equal(3)
  }

  it should "be bindable to another Boolean Property" in {
    mapProperty1 <== readOnlyMapProperty
    mapProperty1() should be(ObservableMap(valueAsSeq).delegate)
  }

  it should "support unbinding from another Boolean Property" in {
    mapProperty1 <== readOnlyMapProperty
    mapProperty1() should be(ObservableMap(valueAsSeq).delegate)
    mapProperty1.unbind()
    mapProperty1() = ObservableMap("zero" -> 0, "seven" -> 7)
    mapProperty1() should be(ObservableMap("zero" -> 0, "seven" -> 7).delegate)
  }

  it should "follow changes in element map" in {

    mapProperty1 <== mapProperty2

    val map = ObservableMap("two" -> 2, "one" -> 1, "three" -> 3)

    mapProperty2.value = map
    mapProperty1() should be(ObservableMap("two" -> 2, "one" -> 1, "three" -> 3).delegate)
    mapProperty2() should be(ObservableMap("two" -> 2, "one" -> 1, "three" -> 3).delegate)

    map += ("seven" -> 7)
    map += ("nine" -> 9)
    mapProperty1() should be(ObservableMap("two" -> 2, "one" -> 1, "three" -> 3, "seven" -> 7, "nine" -> 9).delegate)
    mapProperty2() should be(ObservableMap("two" -> 2, "one" -> 1, "three" -> 3, "seven" -> 7, "nine" -> 9).delegate)
  }

  it should "follow changes in element map <==>" in {

    mapProperty1 <==> mapProperty2

    val map = ObservableMap("two" -> 2, "one" -> 1, "three" -> 3)

    mapProperty2.value = map
    mapProperty1() should be(ObservableMap("two" -> 2, "one" -> 1, "three" -> 3).delegate)
    mapProperty2() should be(ObservableMap("two" -> 2, "one" -> 1, "three" -> 3).delegate)

    map += ("seven" -> 7)
    map += ("nine" -> 9)
    mapProperty1() should be(ObservableMap("two" -> 2, "one" -> 1, "three" -> 3, "seven" -> 7, "nine" -> 9).delegate)
    mapProperty2() should be(ObservableMap("two" -> 2, "one" -> 1, "three" -> 3, "seven" -> 7, "nine" -> 9).delegate)
  }

  it should "Have working 'empty' property" in {
    val map = ObservableMap("two" -> 2, "one" -> 1, "three" -> 3)

    mapProperty1.value = map

    mapProperty1.empty.value should be(false)

    map.clear()

    mapProperty1.empty.value should be(true)
  }

  it should "Have working 'size' property" in {
    val map = ObservableMap("two" -> 2, "one" -> 1, "three" -> 3)
    val mapProperty = new MapProperty[String, Int](map)
    mapProperty.size.value should be(3)

    map += ("seven" -> 7)
    map += ("nine" -> 9)
    mapProperty.size.value should be(5)

    mapProperty += ("thirteen" -> 13)
    mapProperty.size.value should be(6)
    map.size should be(6)

    mapProperty -= "one"
    mapProperty -= "three"
    mapProperty -= "nn"
    mapProperty.size.value should be(4)
    map.size should be(4)

    map.clear()
    mapProperty.size.value should be(0)
  }

  it should "bindContent and unbindContent" in {
    val map = ObservableMap("two" -> 2, "one" -> 1, "three" -> 3, "seven" -> 7, "nine" -> 9)
    val roWrapper = new ReadOnlyMapWrapper(ObservableMap("zero" -> 0))
    val roProperty = roWrapper.readOnlyProperty

    map.size should be(5)
    roProperty.size.value should be(1)

    roProperty.bindContent(map)
    map.size should be(5)
    roProperty.size.value should be(5)

    map ++= Seq("e" -> 11, "t" -> 13)
    map.size should be(7)
    roProperty.size.value should be(7)

    roProperty.unbindContent(map)
    map.size should be(7)
    roProperty.size.value should be(7)

    map ++= Seq("s" -> 17, "n" -> 19)
    map.size should be(9)
    roProperty.size.value should be(7)
  }

  it should "bindContentBidirectional and unbindContentBidirectional" in {
    val map = ObservableMap("two" -> 2, "one" -> 1, "three" -> 3, "seven" -> 7, "nine" -> 9)
    val roWrapper = new ReadOnlyMapWrapper(ObservableMap("zero" -> 0))
    val roProperty = roWrapper.readOnlyProperty

    map.size should be(5)
    roProperty.size.value should be(1)

    roProperty.bindContentBidirectional(map)
    map.size should be(5)
    roProperty.size.value should be(5)

    map ++= Seq("e" -> 11, "t" -> 13)
    map.size should be(7)
    roProperty.size.value should be(7)

    roWrapper -= "seven"
    map.size should be(6)
    roProperty.size.value should be(6)

    roProperty.unbindContentBidirectional(map)
    map.size should be(6)
    roProperty.size.value should be(6)

    map ++= Seq("s" -> 17, "n" -> 19)
    map.size should be(8)
    roProperty.size.value should be(6)
  }

}