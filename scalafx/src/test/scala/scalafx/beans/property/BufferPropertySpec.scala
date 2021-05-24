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
 * Test for [[scalafx.beans.property.BufferProperty]].
 */
class BufferPropertySpec
    extends SimpleSFXDelegateSpec[jfxbp.ListProperty[Int], BufferProperty[Int]](
      classOf[jfxbp.ListProperty[Int]],
      classOf[BufferProperty[Int]]
    ) {

  val bean = new Object()
  val name = "Bean Name X"

  override protected def getJavaClassInstance: jfxbp.ListProperty[Int] = new jfxbp.SimpleListProperty[Int]()

  it should "create from items apply(items)" in {
    val p = BufferProperty(Seq(1, 2, 3, 5, 11, 13))

    p.size.value should be(6)
    p.value.toArray should be(Array(1, 2, 3, 5, 11, 13))
  }

  it should "create from items apply(bean, name, items)" in {
    val p = BufferProperty(bean, name, Seq(1, 2, 3, 5, 11, 13))

    p.bean should equal(bean)
    p.name should equal(name)

    p.size.value should be(6)
    p.value.toArray should be(Array(1, 2, 3, 5, 11, 13))
  }

  it should "create from items new(items)" in {
    val p = new BufferProperty(Seq(1, 2, 3, 5, 11, 13))

    p.size.value should be(6)
    p.value.toArray should be(Array(1, 2, 3, 5, 11, 13))
  }

  it should "create from items new(items, name, items)" in {
    val p = new BufferProperty(bean, name, Seq(1, 2, 3, 5, 11, 13))

    p.bean should equal(bean)
    p.name should equal(name)

    p.size.value should be(6)
    p.value.toArray should be(Array(1, 2, 3, 5, 11, 13))
  }
}
