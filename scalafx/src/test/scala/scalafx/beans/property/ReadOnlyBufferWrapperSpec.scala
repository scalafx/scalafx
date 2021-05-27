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
import org.scalatest.matchers.should.Matchers._
import scalafx.Includes._
import scalafx.testutil.SimpleSFXDelegateSpec

import scala.language.implicitConversions

/**
 *
 * Test for [[scalafx.beans.property.ReadOnlyBufferWrapper]].
 */
class ReadOnlyBufferWrapperSpec
  extends SimpleSFXDelegateSpec[jfxbp.ReadOnlyListWrapper[Int], ReadOnlyBufferWrapper[Int]](
    classOf[jfxbp.ReadOnlyListWrapper[Int]], classOf[ReadOnlyBufferWrapper[Int]]) {

  val bean = new Object()
  val name = "Bean Name X"

  // Ignore property comparison, it cannot deal with 'getReadOnlyProperty' correctly
  override def compareProperties(javafxClass: Class[_], scalafxClass: Class[_]): Unit = {}

  it should "create from items apply(items)" in {
    val roWrapper = ReadOnlyBufferWrapper(Seq(1, 2, 3, 5, 11, 13))

    roWrapper.size.value should be(6)
    roWrapper.value.toArray should be(Array(1, 2, 3, 5, 11, 13))
  }

  it should "create from items apply(bean, name, items)" in {
    val roWrapper = ReadOnlyBufferWrapper(bean, name, Seq(1, 2, 3, 5, 11, 13))

    roWrapper.bean should equal(bean)
    roWrapper.name should equal(name)

    roWrapper.size.value should be(6)
    roWrapper.value.toArray should be(Array(1, 2, 3, 5, 11, 13))
  }

  it should "create from items new(items)" in {
    val roWrapper = new ReadOnlyBufferWrapper(Seq(1, 2, 3, 5, 11, 13))

    roWrapper.size.value should be(6)
    roWrapper.value.toArray should be(Array(1, 2, 3, 5, 11, 13))
  }

  it should "create from items new(items, name, items)" in {
    val roWrapper = new ReadOnlyBufferWrapper(bean, name, Seq(1, 2, 3, 5, 11, 13))

    roWrapper.bean should equal(bean)
    roWrapper.name should equal(name)

    roWrapper.size.value should be(6)
    roWrapper.value.toArray should be(Array(1, 2, 3, 5, 11, 13))
  }
}