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
 * FloatProperty Spec tests.
 *
 *
 */
@RunWith(classOf[JUnitRunner])
class FloatPropertySpec extends FlatSpec with BeforeAndAfterEach {
  val bean = new Object()
  var floatProperty: jfxbp.FloatProperty = null
  var floatProperty2: jfxbp.FloatProperty = null
  var floatProperty3: jfxbp.FloatProperty = null
  var booleanProperty: jfxbp.BooleanProperty = null

  override def beforeEach() {
    floatProperty = new FloatProperty(bean, "Test Float")
    floatProperty2 = new FloatProperty(bean, "Test Float 2")
    floatProperty3 = new FloatProperty(bean, "Test Float 3")
    booleanProperty = new BooleanProperty(bean, "Test Boolean")
  }

  "A Float Property" should "have a default value of 0" in {
    floatProperty.value should equal (0)
  }

  it should "be assignable using update" in {
    floatProperty() = 500
    floatProperty.value should equal (500)
  }

  it should "return its value using apply" in {
    floatProperty() = 500
    floatProperty() should equal (500)
  }

  it should "know its name" in {
    floatProperty.name should equal ("Test Float")
  }

  it should "know its bean" in {
    floatProperty.bean should equal (bean)
  }

  it should "be bindable to another Float Property" in {
    floatProperty <== floatProperty2
    floatProperty2() = 1000
    floatProperty() should equal (1000)
  }

  it should "support unbinding from another Float Property" in {
    floatProperty <== floatProperty2
    floatProperty2() = 2000
    floatProperty.unbind()
    floatProperty2() = 3000
    floatProperty() should equal (2000)
  }

  it should "be bidirectionally bindable to another Float Property" in {
    floatProperty <==> floatProperty2
    floatProperty() = 13
    floatProperty2() should equal (13)
    floatProperty2() = 51
    floatProperty() should equal (51)
    floatProperty unbind floatProperty2
  }

  it should "support bidirectional unbinding from another Float Property" in {
    floatProperty <==> floatProperty2
    floatProperty() = 16
    floatProperty unbind floatProperty2
    floatProperty() = 12
    floatProperty2() should equal (16)
  }

  it should "support bindable infix addition of a property" in {
    floatProperty3 <== floatProperty + floatProperty2
    floatProperty() = 21
    floatProperty2() = 35
    floatProperty3() should equal (56)
    floatProperty3.unbind()
  }

  it should "support bindable infix addition of constants" in {
    floatProperty3 <== floatProperty + 35 + 35l + 35f + 35d
    floatProperty() = 21
    floatProperty3() should equal (161)
    floatProperty3.unbind()
  }

  it should "support bindable infix subtraction of a property" in {
    floatProperty3 <== floatProperty - floatProperty2
    floatProperty() = 40
    floatProperty2() = 12
    floatProperty3() should equal (28)
    floatProperty3.unbind()
  }

  it should "support bindable infix subtraction of constants" in {
    floatProperty3 <== floatProperty - 12 - 12l - 12f - 12d
    floatProperty() = 40
    floatProperty3() should equal (-8)
    floatProperty3.unbind()
  }

  it should "support bindable infix multiplication of a property" in {
    floatProperty3 <== floatProperty * floatProperty2
    floatProperty() = 5
    floatProperty2() = 6
    floatProperty3() should equal (30)
    floatProperty3.unbind()
  }

  it should "support bindable infix multiplication of constants" in {
    floatProperty3 <== floatProperty * 2 * 2l * 2f * 2d
    floatProperty() = 5
    floatProperty3() should equal (80)
    floatProperty3.unbind()
  }

  it should "support bindable infix division of a property" in {
    floatProperty2() = 10
    floatProperty3 <== floatProperty / floatProperty2
    floatProperty() = 100
    floatProperty3() should equal (10)
    floatProperty3.unbind()
  }

  it should "support bindable infix division of constants" in {
    floatProperty3 <== floatProperty / 2 / 2l / 5f / 5d
    floatProperty() = 100
    floatProperty3() should equal (1)
    floatProperty3.unbind()
  }

  it should "support bindable prefix negation" in {
    floatProperty3 <== -floatProperty
    floatProperty() = 32
    floatProperty3() should equal (-32)
    floatProperty3.unbind()
  }

  it should "support bindable infix equality with a property" in {
    booleanProperty <== floatProperty === floatProperty2
    floatProperty() = 532
    floatProperty2() = 321
    booleanProperty() should be (false)
    floatProperty2() = 532
    booleanProperty() should be (true)
    booleanProperty.unbind()
  }

  it should "support bindable infix equality with a constant" in {
    booleanProperty <== floatProperty === 532
    floatProperty() = 321
    booleanProperty() should be (false)
    floatProperty() = 532
    booleanProperty() should be (true)
    booleanProperty.unbind()
  }

  it should "support bindable infix inequality with a property" in {
    booleanProperty <== floatProperty =!= floatProperty2
    floatProperty() = 231
    floatProperty2() = 981
    booleanProperty() should be (true)
    floatProperty2() = 231
    booleanProperty() should be (false)
    booleanProperty.unbind()
  }

  it should "support bindable infix inequality with a constant" in {
    booleanProperty <== floatProperty =!= 231
    floatProperty() = 981
    booleanProperty() should be (true)
    floatProperty() = 231
    booleanProperty() should be (false)
    booleanProperty.unbind()
  }

  it should "support variable precision equality via +- operator" in {
    booleanProperty <== floatProperty === 532+-.1
    floatProperty() = 533
    booleanProperty() should be (false)
    floatProperty() = 532.09f
    booleanProperty() should be (true)
    floatProperty() = 531.91f
    booleanProperty() should be (true)
    booleanProperty.unbind()
  }

  it should "support variable precision inequality via +- operator" in {
    booleanProperty <== floatProperty =!= 532+-.1
    floatProperty() = 533
    booleanProperty() should be (true)
    floatProperty() = 532.09f
    booleanProperty() should be (false)
    floatProperty() = 531.91f
    booleanProperty() should be (false)
    booleanProperty.unbind()
  }

  it should "support bindable infix less than with a property" in {
    booleanProperty <== floatProperty < floatProperty2
    floatProperty() = 51
    floatProperty2() = 234
    booleanProperty() should be (true)
    floatProperty2() = 12
    booleanProperty() should be (false)
    booleanProperty.unbind()
  }

  it should "support bindable infix less than with a constant" in {
    booleanProperty <== floatProperty < 51
    floatProperty() = 234
    booleanProperty() should be (false)
    floatProperty() = 12
    booleanProperty() should be (true)
    booleanProperty.unbind()
  }

  it should "support bindable infix less than or equal to with a property" in {
    booleanProperty <== floatProperty <= floatProperty2
    floatProperty() = 234
    floatProperty2() = 512
    booleanProperty() should be (true)
    floatProperty2() = 93
    booleanProperty() should be (false)
    booleanProperty.unbind()
  }

  it should "support bindable infix less than or equal to with a constant" in {
    booleanProperty <== floatProperty <= 234
    floatProperty() = 512
    booleanProperty() should be (false)
    floatProperty() = 93
    booleanProperty() should be (true)
    booleanProperty.unbind()
  }

  it should "support bindable infix greater than with a property" in {
    booleanProperty <== floatProperty > floatProperty2
    floatProperty() = 5000
    floatProperty2() = 1000
    booleanProperty() should be (true)
    floatProperty2() = 6000
    booleanProperty() should be (false)
    booleanProperty.unbind()
  }

  it should "support bindable infix greater than with a constant" in {
    booleanProperty <== floatProperty > 5000
    floatProperty() = 1000
    booleanProperty() should be (false)
    floatProperty() = 6000
    booleanProperty() should be (true)
    booleanProperty.unbind()
  }

  it should "support bindable infix greater than or equal to with a property" in {
    booleanProperty <== floatProperty >= floatProperty2
    floatProperty() = 18349
    floatProperty2() = 4985
    booleanProperty() should be (true)
    floatProperty2() = 234564
    booleanProperty() should be (false)
    booleanProperty.unbind()
  }

  it should "support bindable infix greater than or equal to with a constant" in {
    booleanProperty <== floatProperty >= 18349
    floatProperty() = 4985
    booleanProperty() should be (false)
    floatProperty() = 234564
    booleanProperty() should be (true)
    booleanProperty.unbind()
  }

  it should "support invalidate/change triggers on binding expressions" in {
    var invalidateCount = 0
    var changeCount = 0
    val binding = floatProperty * floatProperty2
    binding onInvalidate {
      invalidateCount += 1
    }
    binding onChange {
      changeCount += 1
    }
    floatProperty() = 1
    invalidateCount should equal (1)
    changeCount should equal (0)
    floatProperty2() = 5
    invalidateCount should equal (2)
    changeCount should equal (1)
  }
}
