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
 * LongProperty Spec tests.
 *
 *
 */
@RunWith(classOf[JUnitRunner])
class LongPropertySpec extends FlatSpec with BeforeAndAfterEach {
  val bean = new Object()
  var longProperty: jfxbp.LongProperty = null
  var longProperty2: jfxbp.LongProperty = null
  var longProperty3: jfxbp.LongProperty = null
  var booleanProperty: jfxbp.BooleanProperty = null

  override def beforeEach() {
    longProperty = new LongProperty(bean, "Test Long")
    longProperty2 = new LongProperty(bean, "Test Long 2")
    longProperty3 = new LongProperty(bean, "Test Long 3")
    booleanProperty = new BooleanProperty(bean, "Test Boolean")
  }

  "A Long Property" should "have a default value of 0" in {
    longProperty.value should equal (0)
  }

  it should "be assignable using update" in {
    longProperty() = 500
    longProperty.value should equal (500)
  }

  it should "return its value using apply" in {
    longProperty() = 500
    longProperty() should equal (500)
  }

  it should "know its name" in {
    longProperty.name should equal ("Test Long")
  }

  it should "know its bean" in {
    longProperty.bean should equal (bean)
  }

  it should "be bindable to another Long Property" in {
    longProperty <== longProperty2
    longProperty2() = 1000
    longProperty() should equal (1000)
  }

  it should "support unbinding from another Long Property" in {
    longProperty <== longProperty2
    longProperty2() = 2000
    longProperty.unbind()
    longProperty2() = 3000
    longProperty() should equal (2000)
  }

  it should "be bidirectionally bindable to another Long Property" in {
    longProperty <==> longProperty2
    longProperty() = 13
    longProperty2() should equal (13)
    longProperty2() = 51
    longProperty() should equal (51)
    longProperty unbind longProperty2
  }

  it should "support bidirectional unbinding from another Long Property" in {
    longProperty <==> longProperty2
    longProperty() = 16
    longProperty unbind longProperty2
    longProperty() = 12
    longProperty2() should equal (16)
  }

  it should "support bindable infix addition of a property" in {
    longProperty3 <== longProperty + longProperty2
    longProperty() = 21
    longProperty2() = 35
    longProperty3() should equal (56)
    longProperty3.unbind()
  }

  it should "support bindable infix addition of constants" in {
    longProperty3 <== longProperty + 35 + 35l + 35f + 35d
    longProperty() = 21
    longProperty3() should equal (161)
    longProperty3.unbind()
  }

  it should "support bindable infix subtraction of a property" in {
    longProperty3 <== longProperty - longProperty2
    longProperty() = 40
    longProperty2() = 12
    longProperty3() should equal (28)
    longProperty3.unbind()
  }

  it should "support bindable infix subtraction of constants" in {
    longProperty3 <== longProperty - 12 - 12l - 12f - 12d
    longProperty() = 40
    longProperty3() should equal (-8)
    longProperty3.unbind()
  }

  it should "support bindable infix multiplication of a property" in {
    longProperty3 <== longProperty * longProperty2
    longProperty() = 5
    longProperty2() = 6
    longProperty3() should equal (30)
    longProperty3.unbind()
  }

  it should "support bindable infix multiplication of constants" in {
    longProperty3 <== longProperty * 2 * 2l * 2f * 2d
    longProperty() = 5
    longProperty3() should equal (80)
    longProperty3.unbind()
  }

  it should "support bindable infix division of a property" in {
    longProperty2() = 10
    longProperty3 <== longProperty / longProperty2
    longProperty() = 100
    longProperty3() should equal (10)
    longProperty3.unbind()
  }

  it should "support bindable infix division of constants" in {
    longProperty3 <== longProperty / 2 / 2l / 5f / 5d
    longProperty() = 100
    longProperty3() should equal (1)
    longProperty3.unbind()
  }

  it should "support bindable prefix negation" in {
    longProperty3 <== -longProperty
    longProperty() = 32
    longProperty3() should equal (-32)
    longProperty3.unbind()
  }

  it should "support bindable infix equality with a property" in {
    booleanProperty <== longProperty === longProperty2
    longProperty() = 532
    longProperty2() = 321
    booleanProperty() should be (false)
    longProperty2() = 532
    booleanProperty() should be (true)
  }

  it should "support bindable infix equality with a constant" in {
    booleanProperty <== longProperty === 532
    longProperty() = 321
    booleanProperty() should be (false)
    longProperty() = 532
    booleanProperty() should be (true)
  }

  it should "support bindable infix inequality with a property" in {
    booleanProperty <== longProperty =!= longProperty2
    longProperty() = 231
    longProperty2() = 981
    booleanProperty() should be (true)
    longProperty2() = 231
    booleanProperty() should be (false)
  }

  it should "support bindable infix inequality with a constant" in {
    booleanProperty <== longProperty =!= 231
    longProperty() = 981
    booleanProperty() should be (true)
    longProperty() = 231
    booleanProperty() should be (false)
  }

  it should "support variable precision equality via +- operator" in {
    booleanProperty <== longProperty === 532+-1.1
    longProperty() = 534
    booleanProperty() should be (false)
    longProperty() = 533
    booleanProperty() should be (true)
    longProperty() = 531
    booleanProperty() should be (true)
  }

  it should "support variable precision inequality via +- operator" in {
    booleanProperty <== longProperty =!= 532+-1.1
    longProperty() = 534
    booleanProperty() should be (true)
    longProperty() = 533
    booleanProperty() should be (false)
    longProperty() = 531
    booleanProperty() should be (false)
  }

  it should "support bindable infix less than with a property" in {
    booleanProperty <== longProperty < longProperty2
    longProperty() = 51
    longProperty2() = 234
    booleanProperty() should be (true)
    longProperty2() = 12
    booleanProperty() should be (false)
  }

  it should "support bindable infix less than with a constant" in {
    booleanProperty <== longProperty < 51
    longProperty() = 234
    booleanProperty() should be (false)
    longProperty() = 12
    booleanProperty() should be (true)
  }

  it should "support bindable infix less than or equal to with a property" in {
    booleanProperty <== longProperty <= longProperty2
    longProperty() = 234
    longProperty2() = 512
    booleanProperty() should be (true)
    longProperty2() = 93
    booleanProperty() should be (false)
  }

  it should "support bindable infix less than or equal to with a constant" in {
    booleanProperty <== longProperty <= 234
    longProperty() = 512
    booleanProperty() should be (false)
    longProperty() = 93
    booleanProperty() should be (true)
  }

  it should "support bindable infix greater than with a property" in {
    booleanProperty <== longProperty > longProperty2
    longProperty() = 5000
    longProperty2() = 1000
    booleanProperty() should be (true)
    longProperty2() = 6000
    booleanProperty() should be (false)
  }

  it should "support bindable infix greater than with a constant" in {
    booleanProperty <== longProperty > 5000
    longProperty() = 1000
    booleanProperty() should be (false)
    longProperty() = 6000
    booleanProperty() should be (true)
  }

  it should "support bindable infix greater than or equal to with a property" in {
    booleanProperty <== longProperty >= longProperty2
    longProperty() = 18349
    longProperty2() = 4985
    booleanProperty() should be (true)
    longProperty2() = 234564
    booleanProperty() should be (false)
  }

  it should "support bindable infix greater than or equal to with a constant" in {
    booleanProperty <== longProperty >= 18349
    longProperty() = 4985
    booleanProperty() should be (false)
    longProperty() = 234564
    booleanProperty() should be (true)
  }

  it should "support invalidate/change triggers on binding expressions" in {
    var invalidateCount = 0
    var changeCount = 0
    val binding = longProperty * longProperty2
    binding onInvalidate {
      invalidateCount += 1
    }
    binding onChange {
      changeCount += 1
    }
    longProperty() = 1
    invalidateCount should equal (1)
    changeCount should equal (0)
    longProperty2() = 5
    invalidateCount should equal (2)
    changeCount should equal (1)
  }
}
