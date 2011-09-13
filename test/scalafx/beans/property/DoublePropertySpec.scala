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

class DoublePropertySpec extends FlatSpec {
  val bean = new Object()
  var doubleProperty = new DoubleProperty(bean, "Test Double")
  var doubleProperty2 = new DoubleProperty(bean, "Test Double 2")
  var doubleProperty3 = new DoubleProperty(bean, "Test Double 3")
  var booleanProperty = new BooleanProperty(bean, "Test Boolean")

  "A Double Property" should "have a default value of 0" in {
    doubleProperty.value should equal (0)
  }

  it should "be assignable using update" in {
    doubleProperty() = 500
    doubleProperty.value should equal (500)
  }

  it should "return its value using apply" in {
    doubleProperty() should equal (500)
  }

  it should "know its name" in {
    doubleProperty.name should equal ("Test Double")
  }

  it should "know its bean" in {
    doubleProperty.bean should equal (bean)
  }

  it should "be bindable to another Double Property" in {
    doubleProperty bind doubleProperty2
    doubleProperty2() = 1000
    doubleProperty() should equal (1000)
    doubleProperty.unbind()
  }

  it should "support unbinding from another Double Property" in {
    doubleProperty bind doubleProperty2
    doubleProperty2() = 2000
    doubleProperty.unbind()
    doubleProperty2() = 3000
    doubleProperty() should equal (2000)
  }

  it should "be bidirectionally bindable to another Double Property" in {
    doubleProperty bibind doubleProperty2
    doubleProperty() = 13
    doubleProperty2() should equal (13)
    doubleProperty2() = 51
    doubleProperty() should equal (51)
    doubleProperty biunbind doubleProperty2
  }

  it should "support bidirectional unbinding from another Double Property" in {
    doubleProperty bibind doubleProperty2
    doubleProperty() = 16
    doubleProperty biunbind doubleProperty2
    doubleProperty() = 12
    doubleProperty2() should equal (16)
  }

  it should "prevent boxing on update/apply" is (pending)

  it should "support int/long/float/double versions of each of these tests" is (pending)

  it should "support raw javafx mixing" is (pending)

  it should "support bindable infix addition" in {
    doubleProperty3 bind doubleProperty + doubleProperty2
    doubleProperty() = 21
    doubleProperty2() = 35
    doubleProperty3() should equal (56)
    doubleProperty3.unbind()
  }

  it should "support bindable infix subtraction" in {
    doubleProperty3 bind doubleProperty - doubleProperty2
    doubleProperty() = 40
    doubleProperty2() = 12
    doubleProperty3() should equal (28)
    doubleProperty3.unbind()
  }

  it should "support bindable infix multiplication" in {
    doubleProperty3 bind doubleProperty * doubleProperty2
    doubleProperty() = 5
    doubleProperty2() = 6
    doubleProperty3() should equal (30)
    doubleProperty3.unbind()
  }

  it should "support bindable infix division" in {
    doubleProperty3 bind doubleProperty / doubleProperty2
    doubleProperty() = 100
    doubleProperty2() = 10
    doubleProperty3() should equal (10)
    doubleProperty3.unbind()
  }

  it should "support bindable prefix negation" in {
    doubleProperty3 bind -doubleProperty
    doubleProperty() = 32
    doubleProperty3() should equal (-32)
    doubleProperty3.unbind()
  }

  it should "support bindable infix equality" in {
    booleanProperty bind doubleProperty == doubleProperty2
    doubleProperty() = 532
    doubleProperty2() = 321
    booleanProperty() should equal (false)
    doubleProperty2() = 532
    booleanProperty() should equal (true)
    booleanProperty.unbind()
  }

  it should "support bindable infix inequality" in {
    booleanProperty bind doubleProperty != doubleProperty2
    doubleProperty() = 231
    doubleProperty2() = 981
    booleanProperty() should equal (true)
    doubleProperty2() = 231
    booleanProperty() should equal (false)
    booleanProperty.unbind()
  }

  it should "support variable precision equality - using a funky syntax like the scala matchers maybe? (10 plusOrMinus .01) -- or maybe 10 within .01" is (pending)

  it should "support variable precision inequality" is (pending)

  it should "support bindable infix less than" in {
    booleanProperty bind doubleProperty < doubleProperty2
    doubleProperty() = 51
    doubleProperty2() = 234
    booleanProperty() should equal (true)
    doubleProperty2() = 12
    booleanProperty() should equal (false)
    booleanProperty.unbind()
  }

  it should "support bindable infix less than or equal to" in {
    booleanProperty bind doubleProperty <= doubleProperty2
    doubleProperty() = 234
    doubleProperty2() = 512
    booleanProperty() should equal (true)
    doubleProperty2() = 93
    booleanProperty() should equal (false)
    booleanProperty.unbind()
  }

  it should "support bindable infix greater than" in {
    booleanProperty bind doubleProperty > doubleProperty2
    doubleProperty() = 5000
    doubleProperty2() = 1000
    booleanProperty() should equal (true)
    doubleProperty2() = 6000
    booleanProperty() should equal (false)
    booleanProperty.unbind()
  }

  it should "support bindable infix greater than or equal to" in {
    booleanProperty bind doubleProperty >= doubleProperty2
    doubleProperty() = 18349
    doubleProperty2() = 4985
    booleanProperty() should equal (true)
    doubleProperty2() = 234564
    booleanProperty() should equal (false)
    booleanProperty.unbind()
  }

  it should "support min, max, etc -- maybe in another test file" is (pending)
}
