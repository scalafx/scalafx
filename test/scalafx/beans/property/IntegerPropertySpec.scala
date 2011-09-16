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

class IntegerPropertySpec extends FlatSpec {
  val bean = new Object()
  var integerProperty = new IntegerProperty(bean, "Test Integer")
  var integerProperty2 = new IntegerProperty(bean, "Test Integer 2")
  var integerProperty3 = new IntegerProperty(bean, "Test Integer 3")
  var booleanProperty = new BooleanProperty(bean, "Test Boolean")

  "A Integer Property" should "have a default value of 0" in {
    integerProperty.value should equal (0)
  }

  it should "be assignable using update" in {
    integerProperty() = 500
    integerProperty.value should equal (500)
  }

  it should "return its value using apply" in {
    integerProperty() should equal (500)
  }

  it should "know its name" in {
    integerProperty.name should equal ("Test Integer")
  }

  it should "know its bean" in {
    integerProperty.bean should equal (bean)
  }

  it should "be bindable to another Integer Property" in {
    integerProperty <== integerProperty2
    integerProperty2() = 1000
    integerProperty() should equal (1000)
    integerProperty.unbind()
  }

  it should "support unbinding from another Integer Property" in {
    integerProperty <== integerProperty2
    integerProperty2() = 2000
    integerProperty.unbind()
    integerProperty2() = 3000
    integerProperty() should equal (2000)
  }

  it should "be bidirectionally bindable to another Integer Property" in {
    integerProperty <==> integerProperty2
    integerProperty() = 13
    integerProperty2() should equal (13)
    integerProperty2() = 51
    integerProperty() should equal (51)
    integerProperty unbind integerProperty2
  }

  it should "support bidirectional unbinding from another Integer Property" in {
    integerProperty <==> integerProperty2
    integerProperty() = 16
    integerProperty unbind integerProperty2
    integerProperty() = 12
    integerProperty2() should equal (16)
  }

  it should "support bindable infix addition of a property" in {
    integerProperty3 <== integerProperty + integerProperty2
    integerProperty() = 21
    integerProperty2() = 35
    integerProperty3() should equal (56)
    integerProperty3.unbind()
  }

  it should "support bindable infix addition of constants" in {
    integerProperty3 <== integerProperty + 35 + 35l + 35f + 35d
    integerProperty() = 21
    integerProperty3() should equal (161)
    integerProperty3.unbind()
  }

  it should "support bindable infix subtraction of a property" in {
    integerProperty3 <== integerProperty - integerProperty2
    integerProperty() = 40
    integerProperty2() = 12
    integerProperty3() should equal (28)
    integerProperty3.unbind()
  }

  it should "support bindable infix subtraction of constants" in {
    integerProperty3 <== integerProperty - 12 - 12l - 12f - 12d
    integerProperty() = 40
    integerProperty3() should equal (-8)
    integerProperty3.unbind()
  }

  it should "support bindable infix multiplication of a property" in {
    integerProperty3 <== integerProperty * integerProperty2
    integerProperty() = 5
    integerProperty2() = 6
    integerProperty3() should equal (30)
    integerProperty3.unbind()
  }

  it should "support bindable infix multiplication of constants" in {
    integerProperty3 <== integerProperty * 2 * 2l * 2f * 2d
    integerProperty() = 5
    integerProperty3() should equal (80)
    integerProperty3.unbind()
  }

  it should "support bindable infix division of a property" in {
    integerProperty3 <== integerProperty / integerProperty2
    integerProperty() = 100
    integerProperty2() = 10
    integerProperty3() should equal (10)
    integerProperty3.unbind()
  }

  it should "support bindable infix division of constants" in {
    integerProperty3 <== integerProperty / 2 / 2l / 5f / 5d
    integerProperty() = 100
    integerProperty3() should equal (1)
    integerProperty3.unbind()
  }

  it should "support bindable prefix negation" in {
    integerProperty3 <== -integerProperty
    integerProperty() = 32
    integerProperty3() should equal (-32)
    integerProperty3.unbind()
  }

  it should "support bindable infix equality with a property" in {
    booleanProperty <== integerProperty == integerProperty2
    integerProperty() = 532
    integerProperty2() = 321
    booleanProperty() should equal (false)
    integerProperty2() = 532
    booleanProperty() should equal (true)
    booleanProperty.unbind()
  }

  it should "support bindable infix equality with a constant" in {
    booleanProperty <== integerProperty == 532
    integerProperty() = 321
    booleanProperty() should equal (false)
    integerProperty() = 532
    booleanProperty() should equal (true)
    booleanProperty.unbind()
  }

  it should "support bindable infix inequality with a property" in {
    booleanProperty <== integerProperty != integerProperty2
    integerProperty() = 231
    integerProperty2() = 981
    booleanProperty() should equal (true)
    integerProperty2() = 231
    booleanProperty() should equal (false)
    booleanProperty.unbind()
  }

  it should "support bindable infix inequality with a constant" in {
    booleanProperty <== integerProperty != 231
    integerProperty() = 981
    booleanProperty() should equal (true)
    integerProperty() = 231
    booleanProperty() should equal (false)
    booleanProperty.unbind()
  }

  it should "support variable precision equality via +- operator" in {
    booleanProperty <== integerProperty == 532+-1.1
    integerProperty() = 534
    booleanProperty() should equal (false)
    integerProperty() = 533
    booleanProperty() should equal (true)
    integerProperty() = 531
    booleanProperty() should equal (true)
    booleanProperty.unbind()
  }

  it should "support variable precision inequality via +- operator" in {
    booleanProperty <== integerProperty != 532+-1.1
    integerProperty() = 534
    booleanProperty() should equal (true)
    integerProperty() = 533
    booleanProperty() should equal (false)
    integerProperty() = 531
    booleanProperty() should equal (false)
    booleanProperty.unbind()
  }

  it should "support bindable infix less than with a property" in {
    booleanProperty <== integerProperty < integerProperty2
    integerProperty() = 51
    integerProperty2() = 234
    booleanProperty() should equal (true)
    integerProperty2() = 12
    booleanProperty() should equal (false)
    booleanProperty.unbind()
  }

  it should "support bindable infix less than with a constant" in {
    booleanProperty <== integerProperty < 51
    integerProperty() = 234
    booleanProperty() should equal (false)
    integerProperty() = 12
    booleanProperty() should equal (true)
    booleanProperty.unbind()
  }

  it should "support bindable infix less than or equal to with a property" in {
    booleanProperty <== integerProperty <= integerProperty2
    integerProperty() = 234
    integerProperty2() = 512
    booleanProperty() should equal (true)
    integerProperty2() = 93
    booleanProperty() should equal (false)
    booleanProperty.unbind()
  }

  it should "support bindable infix less than or equal to with a constant" in {
    booleanProperty <== integerProperty <= 234
    integerProperty() = 512
    booleanProperty() should equal (false)
    integerProperty() = 93
    booleanProperty() should equal (true)
    booleanProperty.unbind()
  }

  it should "support bindable infix greater than with a property" in {
    booleanProperty <== integerProperty > integerProperty2
    integerProperty() = 5000
    integerProperty2() = 1000
    booleanProperty() should equal (true)
    integerProperty2() = 6000
    booleanProperty() should equal (false)
    booleanProperty.unbind()
  }

  it should "support bindable infix greater than with a constant" in {
    booleanProperty <== integerProperty > 5000
    integerProperty() = 1000
    booleanProperty() should equal (false)
    integerProperty() = 6000
    booleanProperty() should equal (true)
    booleanProperty.unbind()
  }

  it should "support bindable infix greater than or equal to with a property" in {
    booleanProperty <== integerProperty >= integerProperty2
    integerProperty() = 18349
    integerProperty2() = 4985
    booleanProperty() should equal (true)
    integerProperty2() = 234564
    booleanProperty() should equal (false)
    booleanProperty.unbind()
  }

  it should "support bindable infix greater than or equal to with a constant" in {
    booleanProperty <== integerProperty >= 18349
    integerProperty() = 4985
    booleanProperty() should equal (false)
    integerProperty() = 234564
    booleanProperty() should equal (true)
    booleanProperty.unbind()
  }
}
