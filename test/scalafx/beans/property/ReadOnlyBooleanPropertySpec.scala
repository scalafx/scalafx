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

package scalafx.beans.property

import org.scalatest.matchers.ShouldMatchers._
import org.scalatest.{BeforeAndAfterEach, FlatSpec}
import javafx.beans.{property => jfxbp}
import scalafx.Includes._

class ReadOnlyBooleanPropertySpec extends FlatSpec with BeforeAndAfterEach {
  val bean = new Object()
  var readOnlyBooleanProperty: jfxbp.ReadOnlyBooleanProperty = null
  var booleanProperty1: jfxbp.BooleanProperty = null
  var booleanProperty2: jfxbp.BooleanProperty = null

  override def beforeEach() {
    readOnlyBooleanProperty = new ReadOnlyBooleanProperty(bean, "Test Read-only Boolean", true)
    booleanProperty1 = new BooleanProperty(bean, "Test Boolean 2")
    booleanProperty2 = new BooleanProperty(bean, "Test Boolean 3")
  }

  "A Read-only Boolean Property" should "return a fixed value" in {
    readOnlyBooleanProperty.value should be (true)
  }

  it should "return its value using apply" in {
    readOnlyBooleanProperty() should be (true)
  }

  it should "know its name" in {
    readOnlyBooleanProperty.name should equal ("Test Read-only Boolean")
  }

  it should "know its bean" in {
    readOnlyBooleanProperty.bean should equal (bean)
  }

  it should "be bindable to another Boolean Property" in {
    booleanProperty1 <== readOnlyBooleanProperty
    booleanProperty1() should be (true)
  }

  it should "support unbinding from another Boolean Property" in {
    booleanProperty1 <== readOnlyBooleanProperty
    booleanProperty1() should be (true)
    booleanProperty1.unbind()
    booleanProperty1() = false
    booleanProperty1() should be (false)
  }

  it should "support bindable infix equality (===) with a property" in {
    booleanProperty1 <== readOnlyBooleanProperty === booleanProperty2
    booleanProperty2() = false
    booleanProperty1() should be (false)
    booleanProperty2() = true
    booleanProperty1() should be (true)
  }

  it should "support bindable infix inequality (=!=) with a property" in {
    booleanProperty1 <== readOnlyBooleanProperty =!= booleanProperty2
    booleanProperty2() = false
    booleanProperty1() should be (true)
    booleanProperty2() = true
    booleanProperty1() should be (false)
  }

  it should "support bindable infix and (&&) with a property" in {
    booleanProperty1 <== readOnlyBooleanProperty && booleanProperty2
    booleanProperty2() = false
    booleanProperty1() should be (false)
    booleanProperty2() = true
    booleanProperty1() should be (true)
  }

  it should "support bindable infix or (||) with a property" in {
    booleanProperty1 <== readOnlyBooleanProperty || booleanProperty2
    booleanProperty2() = false
    booleanProperty1() should be (true)
    booleanProperty2() = true
    booleanProperty1() should be (true)
  }

  it should "support bindable prefix not (!)" in {
    booleanProperty1 <== !readOnlyBooleanProperty
    booleanProperty1() should be (false)
  }

  it should "support invalidate/change triggers on binding expressions" in {
    var invalidateCount = 0
    var changeCount = 0
    val binding = booleanProperty1 || booleanProperty1
    binding onInvalidate {
      invalidateCount += 1
    }
    binding onChange {
      changeCount += 1
    }
    booleanProperty1() = true
    invalidateCount should equal (1)
    changeCount should equal (1)
    booleanProperty2() = true
    invalidateCount should equal (1)
    changeCount should equal (1)
  }
}