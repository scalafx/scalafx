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

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers._
import scalafx.beans.binding.Bindings._

class ReadOnlyDoublePropertySpec extends FlatSpec {
  val bean = new Object()
  var readOnlyDoubleProperty = new ReadOnlyDoubleProperty(bean, "Test Read-only Double", 50)
  var doubleProperty1 = new DoubleProperty(bean, "Test Double 2")
  var doubleProperty2 = new DoubleProperty(bean, "Test Double 3")
  var booleanProperty = new BooleanProperty(bean, "Test Boolean")

  "A Double Property" should "start with the value we gave it" in {
    readOnlyDoubleProperty.value should equal (50)
  }

  it should "return its value using apply" in {
    readOnlyDoubleProperty() should equal (50)
  }

  it should "know its name" in {
    readOnlyDoubleProperty.name should equal ("Test Read-only Double")
  }

  it should "know its bean" in {
    readOnlyDoubleProperty.bean should equal (bean)
  }

  it should "be bindable to another Double Property" in {
    doubleProperty1 <== readOnlyDoubleProperty
    doubleProperty1() should equal (50)
    doubleProperty1.unbind()
  }

  it should "support bindable infix addition of a property" in {
    doubleProperty2 <== readOnlyDoubleProperty + doubleProperty1
    doubleProperty1() = 35
    doubleProperty2() should equal (85)
    doubleProperty2.unbind()
  }

  it should "support bindable infix addition of constants" in {
    doubleProperty2 <== readOnlyDoubleProperty + 35 + 35l + 35f + 35d
    doubleProperty2() should equal (190)
    doubleProperty2.unbind()
  }

  it should "support bindable infix subtraction of a property" in {
    doubleProperty2 <== readOnlyDoubleProperty - doubleProperty1
    doubleProperty1() = 12
    doubleProperty2() should equal (38)
    doubleProperty2.unbind()
  }

  it should "support bindable infix subtraction of constants" in {
    doubleProperty2 <== readOnlyDoubleProperty - 12 - 12l - 12f - 12d
    doubleProperty2() should equal (2)
    doubleProperty2.unbind()
  }

  it should "support bindable infix multiplication of a property" in {
    doubleProperty2 <== readOnlyDoubleProperty * doubleProperty1
    doubleProperty1() = 6
    doubleProperty2() should equal (300)
    doubleProperty2.unbind()
  }

  it should "support bindable infix multiplication of constants" in {
    doubleProperty2 <== readOnlyDoubleProperty * 2 * 2l * 2f * 2d
    doubleProperty2() should equal (800)
    doubleProperty2.unbind()
  }

  it should "support bindable infix division of a property" in {
    doubleProperty2 <== readOnlyDoubleProperty / doubleProperty1
    doubleProperty1() = 10
    doubleProperty2() should equal (5)
    doubleProperty2.unbind()
  }

  it should "support bindable infix division of constants" in {
    doubleProperty2 <== readOnlyDoubleProperty / 2 / 2l / 5f / 5d
    doubleProperty2() should equal (.5)
    doubleProperty2.unbind()
  }

  it should "support bindable prefix negation" in {
    doubleProperty2 <== -readOnlyDoubleProperty
    doubleProperty2() should equal (-50)
    doubleProperty2.unbind()
  }

  it should "support bindable infix equality with a property" in {
    booleanProperty <== readOnlyDoubleProperty == doubleProperty1
    doubleProperty1() = 23
    booleanProperty() should equal (false)
    doubleProperty1() = 50
    booleanProperty() should equal (true)
    booleanProperty.unbind()
  }

  it should "support bindable infix equality with a constant" in {
    booleanProperty <== readOnlyDoubleProperty == 532
    booleanProperty() should equal (false)
    booleanProperty <== readOnlyDoubleProperty == 50
    booleanProperty() should equal (true)
    booleanProperty.unbind()
  }

  it should "support bindable infix inequality with a property" in {
    booleanProperty <== readOnlyDoubleProperty != doubleProperty1
    doubleProperty1() = 35
    booleanProperty() should equal (true)
    doubleProperty1() = 50
    booleanProperty() should equal (false)
    booleanProperty.unbind()
  }

  it should "support bindable infix inequality with a constant" in {
    booleanProperty <== readOnlyDoubleProperty != 231
    booleanProperty() should equal (true)
    booleanProperty <== readOnlyDoubleProperty != 50
    booleanProperty() should equal (false)
    booleanProperty.unbind()
  }

  it should "support variable precision equality via +- operator" in {
    booleanProperty <== readOnlyDoubleProperty == 55+-1.1
    booleanProperty() should equal (false)
    booleanProperty <== readOnlyDoubleProperty == 51+-1.1
    booleanProperty() should equal (true)
    booleanProperty <== readOnlyDoubleProperty == 49+-1.1
    booleanProperty() should equal (true)
    booleanProperty.unbind()
  }

  it should "support variable precision inequality via +- operator" in {
    booleanProperty <== readOnlyDoubleProperty != 55+-1.1
    booleanProperty() should equal (true)
    booleanProperty <== readOnlyDoubleProperty != 51+-1.1
    booleanProperty() should equal (false)
    booleanProperty <== readOnlyDoubleProperty != 49+-1.1
    booleanProperty() should equal (false)
    booleanProperty.unbind()
  }

  it should "support bindable infix less than with a property" in {
    booleanProperty <== readOnlyDoubleProperty < doubleProperty1
    doubleProperty1() = 234
    booleanProperty() should equal (true)
    doubleProperty1() = 12
    booleanProperty() should equal (false)
    booleanProperty.unbind()
  }

  it should "support bindable infix less than with a constant" in {
    booleanProperty <== readOnlyDoubleProperty < 49
    booleanProperty() should equal (false)
    booleanProperty <== readOnlyDoubleProperty < 51
    booleanProperty() should equal (true)
    booleanProperty.unbind()
  }

  it should "support bindable infix less than or equal to with a property" in {
    booleanProperty <== readOnlyDoubleProperty <= doubleProperty1
    doubleProperty1() = 512
    booleanProperty() should equal (true)
    doubleProperty1() = 34
    booleanProperty() should equal (false)
    booleanProperty.unbind()
  }

  it should "support bindable infix less than or equal to with a constant" in {
    booleanProperty <== readOnlyDoubleProperty <= 34
    booleanProperty() should equal (false)
    booleanProperty <== readOnlyDoubleProperty <= 512
    booleanProperty() should equal (true)
    booleanProperty.unbind()
  }

  it should "support bindable infix greater than with a property" in {
    booleanProperty <== readOnlyDoubleProperty > doubleProperty1
    doubleProperty1() = 40
    booleanProperty() should equal (true)
    doubleProperty1() = 60
    booleanProperty() should equal (false)
    booleanProperty.unbind()
  }

  it should "support bindable infix greater than with a constant" in {
    booleanProperty <== readOnlyDoubleProperty > 51
    booleanProperty() should equal (false)
    booleanProperty <== readOnlyDoubleProperty > 49
    booleanProperty() should equal (true)
    booleanProperty.unbind()
  }

  it should "support bindable infix greater than or equal to with a property" in {
    booleanProperty <== readOnlyDoubleProperty >= doubleProperty1
    doubleProperty1() = 49
    booleanProperty() should equal (true)
    doubleProperty1() = 51
    booleanProperty() should equal (false)
    booleanProperty.unbind()
  }

  it should "support bindable infix greater than or equal to with a constant" in {
    booleanProperty <== readOnlyDoubleProperty >= 18349
    booleanProperty() should equal (false)
    booleanProperty <== readOnlyDoubleProperty >= 13
    booleanProperty() should equal (true)
    booleanProperty.unbind()
  }
}
