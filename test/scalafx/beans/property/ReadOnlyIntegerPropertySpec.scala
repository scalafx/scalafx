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
import scalafx.beans.binding.Bindings._
import org.scalatest.{BeforeAndAfterEach, FlatSpec}

class ReadOnlyIntegerPropertySpec extends FlatSpec with BeforeAndAfterEach {
  val bean = new Object()
  var readOnlyIntegerProperty:ReadOnlyIntegerProperty = null
  var integerProperty1:IntegerProperty = null
  var integerProperty2:IntegerProperty = null
  var booleanProperty:BooleanProperty = null

  override def beforeEach() {
    readOnlyIntegerProperty = new ReadOnlyIntegerProperty(bean, "Test Read-only Integer", 50)
    integerProperty1 = new IntegerProperty(bean, "Test Integer 1")
    integerProperty2 = new IntegerProperty(bean, "Test Integer 2")
    booleanProperty = new BooleanProperty(bean, "Test Boolean")
  }

  "A Read-only Integer Property" should "start with the value we gave it" in {
    readOnlyIntegerProperty.value should equal (50)
  }

  it should "return its value using apply" in {
    readOnlyIntegerProperty() should equal (50)
  }

  it should "know its name" in {
    readOnlyIntegerProperty.name should equal ("Test Read-only Integer")
  }

  it should "know its bean" in {
    readOnlyIntegerProperty.bean should equal (bean)
  }

  it should "be bindable to another Integer Property" in {
    integerProperty1 <== readOnlyIntegerProperty
    integerProperty1() should equal (50)
    integerProperty1.unbind()
  }

  it should "support bindable infix addition of a property" in {
    integerProperty2 <== readOnlyIntegerProperty + integerProperty1
    integerProperty1() = 35
    integerProperty2() should equal (85)
    integerProperty2.unbind()
  }

  it should "support bindable infix addition of constants" in {
    integerProperty2 <== readOnlyIntegerProperty + 35 + 35l + 35f + 35d
    integerProperty2() should equal (190)
    integerProperty2.unbind()
  }

  it should "support bindable infix subtraction of a property" in {
    integerProperty2 <== readOnlyIntegerProperty - integerProperty1
    integerProperty1() = 12
    integerProperty2() should equal (38)
    integerProperty2.unbind()
  }

  it should "support bindable infix subtraction of constants" in {
    integerProperty2 <== readOnlyIntegerProperty - 12 - 12l - 12f - 12d
    integerProperty2() should equal (2)
    integerProperty2.unbind()
  }

  it should "support bindable infix multiplication of a property" in {
    integerProperty2 <== readOnlyIntegerProperty * integerProperty1
    integerProperty1() = 6
    integerProperty2() should equal (300)
    integerProperty2.unbind()
  }

  it should "support bindable infix multiplication of constants" in {
    integerProperty2 <== readOnlyIntegerProperty * 2 * 2l * 2f * 2d
    integerProperty2() should equal (800)
    integerProperty2.unbind()
  }

  it should "support bindable infix division of a property" in {
    integerProperty1() = 10
    integerProperty2 <== readOnlyIntegerProperty / integerProperty1
    integerProperty2() should equal (5)
    integerProperty2.unbind()
  }

  it should "support bindable infix division of constants" in {
    integerProperty2 <== readOnlyIntegerProperty / 2 / 2l / 5f / 5d
    integerProperty2() should equal (0)
    integerProperty2.unbind()
  }

  it should "support bindable prefix negation" in {
    integerProperty2 <== -readOnlyIntegerProperty
    integerProperty2() should equal (-50)
    integerProperty2.unbind()
  }

  it should "support bindable infix equality with a property" in {
    booleanProperty <== readOnlyIntegerProperty == integerProperty1
    integerProperty1() = 23
    booleanProperty() should be (false)
    integerProperty1() = 50
    booleanProperty() should be (true)
  }

  it should "support bindable infix equality with a constant" in {
    booleanProperty <== readOnlyIntegerProperty == 532
    booleanProperty() should be (false)
    booleanProperty <== readOnlyIntegerProperty == 50
    booleanProperty() should be (true)
  }

  it should "support bindable infix inequality with a property" in {
    booleanProperty <== readOnlyIntegerProperty != integerProperty1
    integerProperty1() = 35
    booleanProperty() should be (true)
    integerProperty1() = 50
    booleanProperty() should be (false)
  }

  it should "support bindable infix inequality with a constant" in {
    booleanProperty <== readOnlyIntegerProperty != 231
    booleanProperty() should be (true)
    booleanProperty <== readOnlyIntegerProperty != 50
    booleanProperty() should be (false)
  }

  it should "support variable precision equality via +- operator" in {
    booleanProperty <== readOnlyIntegerProperty == 55+-1.1
    booleanProperty() should be (false)
    booleanProperty <== readOnlyIntegerProperty == 51+-1.1
    booleanProperty() should be (true)
    booleanProperty <== readOnlyIntegerProperty == 49+-1.1
    booleanProperty() should be (true)
  }

  it should "support variable precision inequality via +- operator" in {
    booleanProperty <== readOnlyIntegerProperty != 55+-1.1
    booleanProperty() should be (true)
    booleanProperty <== readOnlyIntegerProperty != 51+-1.1
    booleanProperty() should be (false)
    booleanProperty <== readOnlyIntegerProperty != 49+-1.1
    booleanProperty() should be (false)
  }

  it should "support bindable infix less than with a property" in {
    booleanProperty <== readOnlyIntegerProperty < integerProperty1
    integerProperty1() = 234
    booleanProperty() should be (true)
    integerProperty1() = 12
    booleanProperty() should be (false)
  }

  it should "support bindable infix less than with a constant" in {
    booleanProperty <== readOnlyIntegerProperty < 49
    booleanProperty() should be (false)
    booleanProperty <== readOnlyIntegerProperty < 51
    booleanProperty() should be (true)
  }

  it should "support bindable infix less than or equal to with a property" in {
    booleanProperty <== readOnlyIntegerProperty <= integerProperty1
    integerProperty1() = 512
    booleanProperty() should be (true)
    integerProperty1() = 34
    booleanProperty() should be (false)
  }

  it should "support bindable infix less than or equal to with a constant" in {
    booleanProperty <== readOnlyIntegerProperty <= 34
    booleanProperty() should be (false)
    booleanProperty <== readOnlyIntegerProperty <= 512
    booleanProperty() should be (true)
  }

  it should "support bindable infix greater than with a property" in {
    booleanProperty <== readOnlyIntegerProperty > integerProperty1
    integerProperty1() = 40
    booleanProperty() should be (true)
    integerProperty1() = 60
    booleanProperty() should be (false)
  }

  it should "support bindable infix greater than with a constant" in {
    booleanProperty <== readOnlyIntegerProperty > 51
    booleanProperty() should be (false)
    booleanProperty <== readOnlyIntegerProperty > 49
    booleanProperty() should be (true)
  }

  it should "support bindable infix greater than or equal to with a property" in {
    booleanProperty <== readOnlyIntegerProperty >= integerProperty1
    integerProperty1() = 49
    booleanProperty() should be (true)
    integerProperty1() = 51
    booleanProperty() should be (false)
  }

  it should "support bindable infix greater than or equal to with a constant" in {
    booleanProperty <== readOnlyIntegerProperty >= 18349
    booleanProperty() should be (false)
    booleanProperty <== readOnlyIntegerProperty >= 13
    booleanProperty() should be (true)
  }

  it should "support invalidate/change triggers on binding expressions" in {
    var invalidateCount = 0
    var changeCount = 0
    val binding = readOnlyIntegerProperty * integerProperty2
    binding onInvalidate {
      invalidateCount += 1
    }
    binding onChange {
      changeCount += 1
    }
    integerProperty2() = 1
    invalidateCount should equal (1)
    changeCount should equal (1)
    integerProperty2() = 5
    invalidateCount should equal (2)
    changeCount should equal (2)
  }
}
