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
import scalafx.collections.ObservableBuffer

/**
 * ReadOnlyBufferProperty Spec tests.
 */
class ReadOnlyBufferPropertySpec extends AnyFlatSpec with BeforeAndAfterEach {

  val valueAsSeq = Seq(1, 2, 7)
  val bean       = new Object()

  var readOnlyListProperty: jfxbp.ReadOnlyListProperty[Int] = _
  var listProperty1: jfxbp.ListProperty[Int]                = _
  var listProperty2: jfxbp.ListProperty[Int]                = _

  override def beforeEach(): Unit = {

    val roWrapper = new ReadOnlyBufferWrapper(bean, "Test Read-only Boolean", ObservableBuffer.from(valueAsSeq))
    readOnlyListProperty = roWrapper.readOnlyProperty
    listProperty1 = BufferProperty[Int](bean, "Test Boolean 2")
    listProperty2 = new BufferProperty[Int](bean, "Test Boolean 3")
  }

  "A Read-only Boolean Property" should "return a fixed value" in {
    readOnlyListProperty.value should be(ObservableBuffer.from(valueAsSeq).delegate)
  }

  it should "return its value using from" in {
    readOnlyListProperty() should be(ObservableBuffer.from(valueAsSeq).delegate)
  }

  it should "know its name" in {
    readOnlyListProperty.name should equal("Test Read-only Boolean")
  }

  it should "know its bean" in {
    readOnlyListProperty.bean should equal(bean)
  }

  it should "report not empty property" in {
    readOnlyListProperty.empty.value should equal(false)
  }

  it should "report size property" in {
    readOnlyListProperty.sizeProperty().value should equal(3)
  }

  it should "be bindable to another Boolean Property" in {
    listProperty1 <== readOnlyListProperty
    listProperty1() should be(ObservableBuffer.from(valueAsSeq).delegate)
  }

  it should "support unbinding from another Boolean Property" in {
    listProperty1 <== readOnlyListProperty
    listProperty1() should be(ObservableBuffer.from(valueAsSeq).delegate)
    listProperty1.unbind()
    listProperty1() = ObservableBuffer(0, 0, 7)
    listProperty1() should be(ObservableBuffer(0, 0, 7).delegate)
  }

  it should "follow changes in element buffer" in {

    listProperty1 <== listProperty2

    val buffer = ObservableBuffer(2, 1, 3)

    listProperty2.value = buffer
    listProperty1() should be(ObservableBuffer(2, 1, 3).delegate)
    listProperty2() should be(ObservableBuffer(2, 1, 3).delegate)

    buffer += 7
    buffer += 9
    listProperty1() should be(ObservableBuffer(2, 1, 3, 7, 9).delegate)
    listProperty2() should be(ObservableBuffer(2, 1, 3, 7, 9).delegate)
  }

  it should "follow changes in element buffer <==>" in {

    listProperty1 <==> listProperty2

    val buffer = ObservableBuffer(2, 1, 3)

    listProperty2.value = buffer
    listProperty1() should be(ObservableBuffer(2, 1, 3).delegate)
    listProperty2() should be(ObservableBuffer(2, 1, 3).delegate)

    buffer += 7
    buffer += 9
    listProperty1() should be(ObservableBuffer(2, 1, 3, 7, 9).delegate)
    listProperty2() should be(ObservableBuffer(2, 1, 3, 7, 9).delegate)
  }

  it should "Have working 'empty' property" in {
    val buffer = ObservableBuffer(2, 1, 3)

    listProperty1.value = buffer

    listProperty1.empty.value should be(false)

    buffer.clear()

    listProperty1.empty.value should be(true)
  }

  it should "Have working 'size' property" in {
    val buffer         = ObservableBuffer(2, 1, 3)
    val bufferProperty = new BufferProperty[Int](buffer)
    bufferProperty.size.value should be(3)

    buffer += 7
    buffer += 9
    bufferProperty.size.value should be(5)

    bufferProperty += 13
    bufferProperty.size.value should be(6)
    buffer.size should be(6)

    bufferProperty --= Seq(1, 3, 99)
    bufferProperty.size.value should be(4)
    buffer.size should be(4)

    buffer.clear()
    bufferProperty.size.value should be(0)
  }

  it should "bindContent and unbindContent" in {
    val buffer     = ObservableBuffer(1, 2, 3, 5, 7)
    val roWrapper  = new ReadOnlyBufferWrapper(ObservableBuffer(0))
    val roProperty = roWrapper.readOnlyProperty

    buffer.size should be(5)
    roProperty.size.value should be(1)

    roProperty.bindContent(buffer)
    buffer.size should be(5)
    roProperty.size.value should be(5)

    buffer ++= Seq(11, 13)
    buffer.size should be(7)
    roProperty.size.value should be(7)

    roProperty.unbindContent(buffer)
    buffer.size should be(7)
    roProperty.size.value should be(7)

    buffer ++= Seq(17, 19)
    buffer.size should be(9)
    roProperty.size.value should be(7)
  }

  it should "bindContentBidirectional and unbindContentBidirectional" in {
    val buffer     = ObservableBuffer(1, 2, 3, 5, 7)
    val roWrapper  = new ReadOnlyBufferWrapper(ObservableBuffer(0))
    val roProperty = roWrapper.readOnlyProperty

    buffer.size should be(5)
    roProperty.size.value should be(1)

    roProperty.bindContentBidirectional(buffer)
    buffer.size should be(5)
    roProperty.size.value should be(5)

    buffer ++= Seq(11, 13)
    buffer.size should be(7)
    roProperty.size.value should be(7)

    roWrapper -= 7
    buffer.size should be(6)
    buffer.toArray should be(Array(1, 2, 3, 5, 11, 13))
    roProperty.size.value should be(6)
    roProperty.value.toArray should be(Array(1, 2, 3, 5, 11, 13))

    roProperty.unbindContentBidirectional(buffer)
    buffer.size should be(6)
    roProperty.size.value should be(6)

    buffer ++= Seq(17, 19)
    buffer.size should be(8)
    roProperty.size.value should be(6)
  }

}
