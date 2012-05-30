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
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
 * DoubleProperty Spec tests.
 *
 *
 */
@RunWith(classOf[JUnitRunner])
class DoublePropertySpec extends FlatSpec with BeforeAndAfterEach {
  val bean = new Object()
  var doubleProperty: jfxbp.DoubleProperty = null
  var doubleProperty2: jfxbp.DoubleProperty = null
  var doubleProperty3: jfxbp.DoubleProperty = null
  var booleanProperty: jfxbp.BooleanProperty = null

  override def beforeEach() {
    doubleProperty = new DoubleProperty(bean, "Test Double")
    doubleProperty2 = new DoubleProperty(bean, "Test Double 2")
    doubleProperty3 = new DoubleProperty(bean, "Test Double 3")
    booleanProperty = new BooleanProperty(bean, "Test Boolean")
  }

  "A Double Property" should "have a default value of 0" in {
    doubleProperty.value should equal (0)
  }

  it should "be assignable using update" in {
    doubleProperty() = 500
    doubleProperty.value should equal (500)
  }

  it should "return its value using apply" in {
    doubleProperty() = 500
    doubleProperty() should equal (500)
  }

  it should "know its name" in {
    doubleProperty.name should equal ("Test Double")
  }

  it should "know its bean" in {
    doubleProperty.bean should equal (bean)
  }

  it should "be bindable to another Double Property" in {
    doubleProperty <== doubleProperty2
    doubleProperty2() = 1000
    doubleProperty() should equal (1000)
  }

  it should "support unbinding from another Double Property" in {
    doubleProperty <== doubleProperty2
    doubleProperty2() = 2000
    doubleProperty.unbind()
    doubleProperty2() = 3000
    doubleProperty() should equal (2000)
  }

  it should "be bidirectionally bindable to another Double Property" in {
    doubleProperty <==> doubleProperty2
    doubleProperty() = 13
    doubleProperty2() should equal (13)
    doubleProperty2() = 51
    doubleProperty() should equal (51)
  }

  it should "support bidirectional unbinding from another Double Property" in {
    doubleProperty <==> doubleProperty2
    doubleProperty() = 16
    doubleProperty unbind doubleProperty2
    doubleProperty() = 12
    doubleProperty2() should equal (16)
  }

  it should "support bindable infix addition of a property" in {
    doubleProperty3 <== doubleProperty + doubleProperty2
    doubleProperty() = 21
    doubleProperty2() = 35
    doubleProperty3() should equal (56)
  }

  it should "support bindable infix addition of constants" in {
    doubleProperty3 <== doubleProperty + 35 + 35l + 35f + 35d
    doubleProperty() = 21
    doubleProperty3() should equal (161)
  }

  it should "support bindable infix subtraction of a property" in {
    doubleProperty3 <== doubleProperty - doubleProperty2
    doubleProperty() = 40
    doubleProperty2() = 12
    doubleProperty3() should equal (28)
  }

  it should "support bindable infix subtraction of constants" in {
    doubleProperty3 <== doubleProperty - 12 - 12l - 12f - 12d
    doubleProperty() = 40
    doubleProperty3() should equal (-8)
  }

  it should "support bindable infix multiplication of a property" in {
    doubleProperty3 <== doubleProperty * doubleProperty2
    doubleProperty() = 5
    doubleProperty2() = 6
    doubleProperty3() should equal (30)
  }

  it should "support bindable infix multiplication of constants" in {
    doubleProperty3 <== doubleProperty * 2 * 2l * 2f * 2d
    doubleProperty() = 5
    doubleProperty3() should equal (80)
  }

  it should "support bindable infix division of a property" in {
    doubleProperty2() = 10
    doubleProperty3 <== doubleProperty / doubleProperty2
    doubleProperty() = 100
    doubleProperty3() should equal (10)
  }

  it should "support bindable infix division of constants" in {
    doubleProperty3 <== doubleProperty / 2 / 2l / 5f / 5d
    doubleProperty() = 100
    doubleProperty3() should equal (1)
  }

  it should "support bindable prefix negation" in {
    doubleProperty3 <== -doubleProperty
    doubleProperty() = 32
    doubleProperty3() should equal (-32)
  }

  it should "support bindable infix equality with a property" in {
    booleanProperty <== doubleProperty === doubleProperty2
    doubleProperty() = 532
    doubleProperty2() = 321
    booleanProperty() should be (false)
    doubleProperty2() = 532
    booleanProperty() should be (true)
  }

  it should "support bindable infix equality with a constant" in {
    booleanProperty <== doubleProperty === 532
    doubleProperty() = 321
    booleanProperty() should be (false)
    doubleProperty() = 532
    booleanProperty() should be (true)
  }

  it should "support bindable infix inequality with a property" in {
    booleanProperty <== doubleProperty =!= doubleProperty2
    doubleProperty() = 231
    doubleProperty2() = 981
    booleanProperty() should be (true)
    doubleProperty2() = 231
    booleanProperty() should be (false)
  }

  it should "support bindable infix inequality with a constant" in {
    booleanProperty <== doubleProperty =!= 231
    doubleProperty() = 981
    booleanProperty() should be (true)
    doubleProperty() = 231
    booleanProperty() should be (false)
  }

  it should "support variable precision equality via +- operator" in {
    booleanProperty <== doubleProperty === 532+-.1
    doubleProperty() = 533
    booleanProperty() should be (false)
    doubleProperty() = 532.09
    booleanProperty() should be (true)
    doubleProperty() = 531.91
    booleanProperty() should be (true)
  }

  it should "support variable precision inequality via +- operator" in {
    booleanProperty <== doubleProperty =!= 532+-.1
    doubleProperty() = 533
    booleanProperty() should be (true)
    doubleProperty() = 532.09
    booleanProperty() should be (false)
    doubleProperty() = 531.91
    booleanProperty() should be (false)
  }

  it should "support bindable infix less than with a property" in {
    booleanProperty <== doubleProperty < doubleProperty2
    doubleProperty() = 51
    doubleProperty2() = 234
    booleanProperty() should be (true)
    doubleProperty2() = 12
    booleanProperty() should be (false)
  }

  it should "support bindable infix less than with a constant" in {
    booleanProperty <== doubleProperty < 51
    doubleProperty() = 234
    booleanProperty() should be (false)
    doubleProperty() = 12
    booleanProperty() should be (true)
  }

  it should "support bindable infix less than or equal to with a property" in {
    booleanProperty <== doubleProperty <= doubleProperty2
    doubleProperty() = 234
    doubleProperty2() = 512
    booleanProperty() should be (true)
    doubleProperty2() = 93
    booleanProperty() should be (false)
  }

  it should "support bindable infix less than or equal to with a constant" in {
    booleanProperty <== doubleProperty <= 234
    doubleProperty() = 512
    booleanProperty() should be (false)
    doubleProperty() = 93
    booleanProperty() should be (true)
  }

  it should "support bindable infix greater than with a property" in {
    booleanProperty <== doubleProperty > doubleProperty2
    doubleProperty() = 5000
    doubleProperty2() = 1000
    booleanProperty() should be (true)
    doubleProperty2() = 6000
    booleanProperty() should be (false)
  }

  it should "support bindable infix greater than with a constant" in {
    booleanProperty <== doubleProperty > 5000
    doubleProperty() = 1000
    booleanProperty() should be (false)
    doubleProperty() = 6000
    booleanProperty() should be (true)
  }

  it should "support bindable infix greater than or equal to with a property" in {
    booleanProperty <== doubleProperty >= doubleProperty2
    doubleProperty() = 18349
    doubleProperty2() = 4985
    booleanProperty() should be (true)
    doubleProperty2() = 234564
    booleanProperty() should be (false)
  }

  it should "support bindable infix greater than or equal to with a constant" in {
    booleanProperty <== doubleProperty >= 18349
    doubleProperty() = 4985
    booleanProperty() should be (false)
    doubleProperty() = 234564
    booleanProperty() should be (true)
  }

  it should "support invalidate/change triggers on binding expressions" in {
    var invalidateCount = 0
    var changeCount = 0
    val binding = doubleProperty * doubleProperty2
    binding onInvalidate {
      invalidateCount += 1
    }
    binding onChange {
      changeCount += 1
    }
    doubleProperty() = 1
    invalidateCount should equal (1)
    changeCount should equal (0)
    doubleProperty2() = 5
    invalidateCount should equal (2)
    changeCount should equal (1)
  }
}
