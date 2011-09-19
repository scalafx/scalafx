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

class ReadOnlyLongPropertySpec extends FlatSpec with BeforeAndAfterEach {
  val bean = new Object()
  var readOnlyLongProperty:ReadOnlyLongProperty = null
  var longProperty1:LongProperty = null
  var longProperty2:LongProperty = null
  var booleanProperty:BooleanProperty = null

  override def beforeEach() {
    readOnlyLongProperty = new ReadOnlyLongProperty(bean, "Test Read-only Long", 50)
    longProperty1 = new LongProperty(bean, "Test Long 1")
    longProperty2 = new LongProperty(bean, "Test Long 2")
    booleanProperty = new BooleanProperty(bean, "Test Boolean")
  }

  "A Read-only Long Property" should "start with the value we gave it" in {
    readOnlyLongProperty.value should equal (50)
  }

  it should "return its value using apply" in {
    readOnlyLongProperty() should equal (50)
  }

  it should "know its name" in {
    readOnlyLongProperty.name should equal ("Test Read-only Long")
  }

  it should "know its bean" in {
    readOnlyLongProperty.bean should equal (bean)
  }

  it should "be bindable to another Long Property" in {
    longProperty1 <== readOnlyLongProperty
    longProperty1() should equal (50)
    longProperty1.unbind()
  }

  it should "support bindable infix addition of a property" in {
    longProperty2 <== readOnlyLongProperty + longProperty1
    longProperty1() = 35
    longProperty2() should equal (85)
    longProperty2.unbind()
  }

  it should "support bindable infix addition of constants" in {
    longProperty2 <== readOnlyLongProperty + 35 + 35l + 35f + 35d
    longProperty2() should equal (190)
    longProperty2.unbind()
  }

  it should "support bindable infix subtraction of a property" in {
    longProperty2 <== readOnlyLongProperty - longProperty1
    longProperty1() = 12
    longProperty2() should equal (38)
    longProperty2.unbind()
  }

  it should "support bindable infix subtraction of constants" in {
    longProperty2 <== readOnlyLongProperty - 12 - 12l - 12f - 12d
    longProperty2() should equal (2)
    longProperty2.unbind()
  }

  it should "support bindable infix multiplication of a property" in {
    longProperty2 <== readOnlyLongProperty * longProperty1
    longProperty1() = 6
    longProperty2() should equal (300)
    longProperty2.unbind()
  }

  it should "support bindable infix multiplication of constants" in {
    longProperty2 <== readOnlyLongProperty * 2 * 2l * 2f * 2d
    longProperty2() should equal (800)
    longProperty2.unbind()
  }

  it should "support bindable infix division of a property" in {
    longProperty1() = 10
    longProperty2 <== readOnlyLongProperty / longProperty1
    longProperty2() should equal (5)
    longProperty2.unbind()
  }

  it should "support bindable infix division of constants" in {
    longProperty2 <== readOnlyLongProperty / 2 / 2l / 5f / 5d
    longProperty2() should equal (0)
    longProperty2.unbind()
  }

  it should "support bindable prefix negation" in {
    longProperty2 <== -readOnlyLongProperty
    longProperty2() should equal (-50)
    longProperty2.unbind()
  }

  it should "support bindable infix equality with a property" in {
    booleanProperty <== readOnlyLongProperty == longProperty1
    longProperty1() = 23
    booleanProperty() should equal (false)
    longProperty1() = 50
    booleanProperty() should equal (true)
  }

  it should "support bindable infix equality with a constant" in {
    booleanProperty <== readOnlyLongProperty == 532
    booleanProperty() should equal (false)
    booleanProperty <== readOnlyLongProperty == 50
    booleanProperty() should equal (true)
  }

  it should "support bindable infix inequality with a property" in {
    booleanProperty <== readOnlyLongProperty != longProperty1
    longProperty1() = 35
    booleanProperty() should equal (true)
    longProperty1() = 50
    booleanProperty() should equal (false)
  }

  it should "support bindable infix inequality with a constant" in {
    booleanProperty <== readOnlyLongProperty != 231
    booleanProperty() should equal (true)
    booleanProperty <== readOnlyLongProperty != 50
    booleanProperty() should equal (false)
  }

  it should "support variable precision equality via +- operator" in {
    booleanProperty <== readOnlyLongProperty == 55+-1.1
    booleanProperty() should equal (false)
    booleanProperty <== readOnlyLongProperty == 51+-1.1
    booleanProperty() should equal (true)
    booleanProperty <== readOnlyLongProperty == 49+-1.1
    booleanProperty() should equal (true)
  }

  it should "support variable precision inequality via +- operator" in {
    booleanProperty <== readOnlyLongProperty != 55+-1.1
    booleanProperty() should equal (true)
    booleanProperty <== readOnlyLongProperty != 51+-1.1
    booleanProperty() should equal (false)
    booleanProperty <== readOnlyLongProperty != 49+-1.1
    booleanProperty() should equal (false)
  }

  it should "support bindable infix less than with a property" in {
    booleanProperty <== readOnlyLongProperty < longProperty1
    longProperty1() = 234
    booleanProperty() should equal (true)
    longProperty1() = 12
    booleanProperty() should equal (false)
  }

  it should "support bindable infix less than with a constant" in {
    booleanProperty <== readOnlyLongProperty < 49
    booleanProperty() should equal (false)
    booleanProperty <== readOnlyLongProperty < 51
    booleanProperty() should equal (true)
  }

  it should "support bindable infix less than or equal to with a property" in {
    booleanProperty <== readOnlyLongProperty <= longProperty1
    longProperty1() = 512
    booleanProperty() should equal (true)
    longProperty1() = 34
    booleanProperty() should equal (false)
  }

  it should "support bindable infix less than or equal to with a constant" in {
    booleanProperty <== readOnlyLongProperty <= 34
    booleanProperty() should equal (false)
    booleanProperty <== readOnlyLongProperty <= 512
    booleanProperty() should equal (true)
  }

  it should "support bindable infix greater than with a property" in {
    booleanProperty <== readOnlyLongProperty > longProperty1
    longProperty1() = 40
    booleanProperty() should equal (true)
    longProperty1() = 60
    booleanProperty() should equal (false)
  }

  it should "support bindable infix greater than with a constant" in {
    booleanProperty <== readOnlyLongProperty > 51
    booleanProperty() should equal (false)
    booleanProperty <== readOnlyLongProperty > 49
    booleanProperty() should equal (true)
  }

  it should "support bindable infix greater than or equal to with a property" in {
    booleanProperty <== readOnlyLongProperty >= longProperty1
    longProperty1() = 49
    booleanProperty() should equal (true)
    longProperty1() = 51
    booleanProperty() should equal (false)
  }

  it should "support bindable infix greater than or equal to with a constant" in {
    booleanProperty <== readOnlyLongProperty >= 18349
    booleanProperty() should equal (false)
    booleanProperty <== readOnlyLongProperty >= 13
    booleanProperty() should equal (true)
  }
}
