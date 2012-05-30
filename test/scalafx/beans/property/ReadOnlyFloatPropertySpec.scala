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
 * ReadOnlyFloatProperty Spec tests.
 *
 *
 */
@RunWith(classOf[JUnitRunner])
class ReadOnlyFloatPropertySpec extends FlatSpec with BeforeAndAfterEach {
  val bean = new Object()
  var readOnlyFloatProperty: jfxbp.ReadOnlyFloatProperty = null
  var floatProperty1: jfxbp.FloatProperty = null
  var floatProperty2: jfxbp.FloatProperty = null
  var booleanProperty: jfxbp.BooleanProperty = null

  override def beforeEach() {
    readOnlyFloatProperty = new ReadOnlyFloatProperty(bean, "Test Read-only Float", 50)
    floatProperty1 = new FloatProperty(bean, "Test Float 1")
    floatProperty2 = new FloatProperty(bean, "Test Float 2")
    booleanProperty = new BooleanProperty(bean, "Test Boolean")
  }

  "A Read-only Float Property" should "start with the value we gave it" in {
    readOnlyFloatProperty.value should equal (50)
  }

  it should "return its value using apply" in {
    readOnlyFloatProperty() should equal (50)
  }

  it should "know its name" in {
    readOnlyFloatProperty.name should equal ("Test Read-only Float")
  }

  it should "know its bean" in {
    readOnlyFloatProperty.bean should equal (bean)
  }

  it should "be bindable to another Float Property" in {
    floatProperty1 <== readOnlyFloatProperty
    floatProperty1() should equal (50)
    floatProperty1.unbind()
  }

  it should "support bindable infix addition of a property" in {
    floatProperty2 <== readOnlyFloatProperty + floatProperty1
    floatProperty1() = 35
    floatProperty2() should equal (85)
    floatProperty2.unbind()
  }

  it should "support bindable infix addition of constants" in {
    floatProperty2 <== readOnlyFloatProperty + 35 + 35l + 35f + 35d
    floatProperty2() should equal (190)
    floatProperty2.unbind()
  }

  it should "support bindable infix subtraction of a property" in {
    floatProperty2 <== readOnlyFloatProperty - floatProperty1
    floatProperty1() = 12
    floatProperty2() should equal (38)
    floatProperty2.unbind()
  }

  it should "support bindable infix subtraction of constants" in {
    floatProperty2 <== readOnlyFloatProperty - 12 - 12l - 12f - 12d
    floatProperty2() should equal (2)
    floatProperty2.unbind()
  }

  it should "support bindable infix multiplication of a property" in {
    floatProperty2 <== readOnlyFloatProperty * floatProperty1
    floatProperty1() = 6
    floatProperty2() should equal (300)
    floatProperty2.unbind()
  }

  it should "support bindable infix multiplication of constants" in {
    floatProperty2 <== readOnlyFloatProperty * 2 * 2l * 2f * 2d
    floatProperty2() should equal (800)
    floatProperty2.unbind()
  }

  it should "support bindable infix division of a property" in {
    floatProperty1() = 10
    floatProperty2 <== readOnlyFloatProperty / floatProperty1
    floatProperty2() should equal (5)
    floatProperty2.unbind()
  }

  it should "support bindable infix division of constants" in {
    floatProperty2 <== readOnlyFloatProperty / 2 / 2l / 5f / 5d
    floatProperty2() should equal (.5)
    floatProperty2.unbind()
  }

  it should "support bindable prefix negation" in {
    floatProperty2 <== -readOnlyFloatProperty
    floatProperty2() should equal (-50)
    floatProperty2.unbind()
  }

  it should "support bindable infix equality with a property" in {
    booleanProperty <== readOnlyFloatProperty === floatProperty1
    floatProperty1() = 23
    booleanProperty() should be (false)
    floatProperty1() = 50
    booleanProperty() should be (true)
  }

  it should "support bindable infix equality with a constant" in {
    booleanProperty <== readOnlyFloatProperty === 532
    booleanProperty() should be (false)
    booleanProperty <== readOnlyFloatProperty === 50
    booleanProperty() should be (true)
  }

  it should "support bindable infix inequality with a property" in {
    booleanProperty <== readOnlyFloatProperty =!= floatProperty1
    floatProperty1() = 35
    booleanProperty() should be (true)
    floatProperty1() = 50
    booleanProperty() should be (false)
  }

  it should "support bindable infix inequality with a constant" in {
    booleanProperty <== readOnlyFloatProperty =!= 231
    booleanProperty() should be (true)
    booleanProperty <== readOnlyFloatProperty =!= 50
    booleanProperty() should be (false)
  }

  it should "support variable precision equality via +- operator" in {
    booleanProperty <== readOnlyFloatProperty === 55+-1.1
    booleanProperty() should be (false)
    booleanProperty <== readOnlyFloatProperty === 51+-1.1
    booleanProperty() should be (true)
    booleanProperty <== readOnlyFloatProperty === 49+-1.1
    booleanProperty() should be (true)
  }

  it should "support variable precision inequality via +- operator" in {
    booleanProperty <== readOnlyFloatProperty =!= 55+-1.1
    booleanProperty() should be (true)
    booleanProperty <== readOnlyFloatProperty =!= 51+-1.1
    booleanProperty() should be (false)
    booleanProperty <== readOnlyFloatProperty =!= 49+-1.1
    booleanProperty() should be (false)
  }

  it should "support bindable infix less than with a property" in {
    booleanProperty <== readOnlyFloatProperty < floatProperty1
    floatProperty1() = 234
    booleanProperty() should be (true)
    floatProperty1() = 12
    booleanProperty() should be (false)
  }

  it should "support bindable infix less than with a constant" in {
    booleanProperty <== readOnlyFloatProperty < 49
    booleanProperty() should be (false)
    booleanProperty <== readOnlyFloatProperty < 51
    booleanProperty() should be (true)
  }

  it should "support bindable infix less than or equal to with a property" in {
    booleanProperty <== readOnlyFloatProperty <= floatProperty1
    floatProperty1() = 512
    booleanProperty() should be (true)
    floatProperty1() = 34
    booleanProperty() should be (false)
  }

  it should "support bindable infix less than or equal to with a constant" in {
    booleanProperty <== readOnlyFloatProperty <= 34
    booleanProperty() should be (false)
    booleanProperty <== readOnlyFloatProperty <= 512
    booleanProperty() should be (true)
  }

  it should "support bindable infix greater than with a property" in {
    booleanProperty <== readOnlyFloatProperty > floatProperty1
    floatProperty1() = 40
    booleanProperty() should be (true)
    floatProperty1() = 60
    booleanProperty() should be (false)
  }

  it should "support bindable infix greater than with a constant" in {
    booleanProperty <== readOnlyFloatProperty > 51
    booleanProperty() should be (false)
    booleanProperty <== readOnlyFloatProperty > 49
    booleanProperty() should be (true)
  }

  it should "support bindable infix greater than or equal to with a property" in {
    booleanProperty <== readOnlyFloatProperty >= floatProperty1
    floatProperty1() = 49
    booleanProperty() should be (true)
    floatProperty1() = 51
    booleanProperty() should be (false)
  }

  it should "support bindable infix greater than or equal to with a constant" in {
    booleanProperty <== readOnlyFloatProperty >= 18349
    booleanProperty() should be (false)
    booleanProperty <== readOnlyFloatProperty >= 13
    booleanProperty() should be (true)
  }

  it should "support invalidate/change triggers on binding expressions" in {
    var invalidateCount = 0
    var changeCount = 0
    val binding = readOnlyFloatProperty * floatProperty2
    binding onInvalidate {
      invalidateCount += 1
    }
    binding onChange {
      changeCount += 1
    }
    floatProperty2() = 1
    invalidateCount should equal (1)
    changeCount should equal (1)
    floatProperty2() = 5
    invalidateCount should equal (2)
    changeCount should equal (2)
  }
}
