/*
 * Copyright (c) 2011-2024, ScalaFX Project
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
import org.scalatest.BeforeAndAfterEach
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers._
import scalafx.Includes._
import scalafx.collections.ObservableSet

/**
 * ReadOnlySetProperty Spec tests.
 */
class ReadOnlySetPropertySpec extends AnyFlatSpec with BeforeAndAfterEach {

  val valueAsSeq = Seq(1, 2, 7)
  val bean       = new Object()

  var readOnlySetProperty: jfxbp.ReadOnlySetProperty[Int] = _
  var setProperty1: jfxbp.SetProperty[Int]                = _
  var setProperty2: jfxbp.SetProperty[Int]                = _

  override def beforeEach(): Unit = {

    val roWrapper = new ReadOnlySetWrapper(bean, "Test Read-only Boolean", ObservableSet.from(valueAsSeq))
    readOnlySetProperty = roWrapper.readOnlyProperty
    setProperty1 = SetProperty[Int](bean, "Test Boolean 2")
    setProperty2 = new SetProperty[Int](bean, "Test Boolean 3")
  }

  "A Read-only Boolean Property" should "return a fixed value" in {
    readOnlySetProperty.value should be(ObservableSet.from(valueAsSeq).delegate)
  }

  it should "return its value using apply" in {
    readOnlySetProperty() should be(ObservableSet.from(valueAsSeq).delegate)
  }

  it should "know its name" in {
    readOnlySetProperty.name should equal("Test Read-only Boolean")
  }

  it should "know its bean" in {
    readOnlySetProperty.bean should equal(bean)
  }

  it should "report not empty property" in {
    readOnlySetProperty.empty.value should equal(false)
  }

  it should "report size property" in {
    readOnlySetProperty.sizeProperty().value should equal(3)
  }

  it should "be bindable to another Boolean Property" in {
    setProperty1 <== readOnlySetProperty
    setProperty1() should be(ObservableSet.from(valueAsSeq).delegate)
  }

  it should "support unbinding from another Boolean Property" in {
    setProperty1 <== readOnlySetProperty
    setProperty1() should be(ObservableSet.from(valueAsSeq).delegate)
    setProperty1.unbind()
    setProperty1() = ObservableSet(0, 0, 7)
    setProperty1() should be(ObservableSet(0, 0, 7).delegate)
  }

  it should "follow changes in element set" in {

    setProperty1 <== setProperty2

    val set = ObservableSet(2, 1, 3)

    setProperty2.value = set
    setProperty1() should be(ObservableSet(2, 1, 3).delegate)
    setProperty2() should be(ObservableSet(2, 1, 3).delegate)

    set += 7
    set += 9
    setProperty1() should be(ObservableSet(2, 1, 3, 7, 9).delegate)
    setProperty2() should be(ObservableSet(2, 1, 3, 7, 9).delegate)
  }

  it should "follow changes in element set <==>" in {

    setProperty1 <==> setProperty2

    val set = ObservableSet(2, 1, 3)

    setProperty2.value = set
    setProperty1() should be(ObservableSet(2, 1, 3).delegate)
    setProperty2() should be(ObservableSet(2, 1, 3).delegate)

    set += 7
    set += 9
    setProperty1() should be(ObservableSet(2, 1, 3, 7, 9).delegate)
    setProperty2() should be(ObservableSet(2, 1, 3, 7, 9).delegate)
  }

  it should "Have working 'empty' property" in {
    val set = ObservableSet(2, 1, 3)

    setProperty1.value = set

    setProperty1.empty.value should be(false)

    set.clear()

    setProperty1.empty.value should be(true)
  }

  it should "Have working 'size' property" in {
    val set         = ObservableSet(2, 1, 3)
    val setProperty = new SetProperty[Int](set)
    setProperty.size.value should be(3)

    set += 7
    set += 9
    setProperty.size.value should be(5)

    setProperty += 13
    setProperty.size.value should be(6)
    set.size should be(6)

    setProperty --= Seq(1, 3, 99)
    setProperty.size.value should be(4)
    set.size should be(4)

    set.clear()
    setProperty.size.value should be(0)
  }

  it should "bindContent and unbindContent" in {
    val set        = ObservableSet(1, 2, 3, 5, 7)
    val roWrapper  = new ReadOnlySetWrapper(ObservableSet(0))
    val roProperty = roWrapper.readOnlyProperty

    set.size should be(5)
    roProperty.size.value should be(1)

    roProperty.bindContent(set)
    set.size should be(5)
    roProperty.size.value should be(5)

    set ++= Seq(11, 13)
    set.size should be(7)
    roProperty.size.value should be(7)

    roProperty.unbindContent(set)
    set.size should be(7)
    roProperty.size.value should be(7)

    set ++= Seq(17, 19)
    set.size should be(9)
    roProperty.size.value should be(7)
  }

  it should "bindContentBidirectional and unbindContentBidirectional" in {
    val set        = ObservableSet(1, 2, 3, 5, 7)
    val roWrapper  = new ReadOnlySetWrapper(ObservableSet(0))
    val roProperty = roWrapper.readOnlyProperty

    set.size should be(5)
    roProperty.size.value should be(1)

    roProperty.bindContentBidirectional(set)
    set.size should be(5)
    roProperty.size.value should be(5)

    set ++= Seq(11, 13)
    set.size should be(7)
    roProperty.size.value should be(7)

    roWrapper -= 7
    set.size should be(6)
    set.toArray should be(Array(1, 2, 3, 5, 11, 13))
    roProperty.size.value should be(6)
    roProperty.value.toArray should be(Array(1, 2, 3, 5, 11, 13))

    roProperty.unbindContentBidirectional(set)
    set.size should be(6)
    roProperty.size.value should be(6)

    set ++= Seq(17, 19)
    set.size should be(8)
    roProperty.size.value should be(6)
  }

}
