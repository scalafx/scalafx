/*
 * Copyright (c) 2011-2024, ScalaFX Project
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

import javafx.beans.{property => jfxbp}
import org.scalatest.BeforeAndAfterEach
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers._
import scalafx.Includes._

/**
 * BooleanProperty Spec tests.
 */
class BooleanPropertySpec extends AnyFlatSpec with BeforeAndAfterEach {
  val bean                                    = new Object()
  var booleanProperty: jfxbp.BooleanProperty  = null
  var booleanProperty2: jfxbp.BooleanProperty = null
  var booleanProperty3: jfxbp.BooleanProperty = null
  var sfxBooleanProperty: BooleanProperty     = null

  override def beforeEach(): Unit = {
    booleanProperty = new BooleanProperty(bean, "Test Boolean")
    booleanProperty2 = new BooleanProperty(bean, "Test Boolean 2")
    booleanProperty3 = new BooleanProperty(bean, "Test Boolean 3")
    sfxBooleanProperty = new BooleanProperty(bean, "Test SFX Boolean")
  }

  "A Boolean Property" should "have a default value of false" in {
    booleanProperty.value should be(false)
  }

  it should "be assignable using update" in {
    booleanProperty() = true
    booleanProperty.value should be(true)
  }

  it should "return its value using apply" in {
    booleanProperty() = true
    booleanProperty() should be(true)
  }

  it should "know its name" in {
    booleanProperty.name should equal("Test Boolean")
  }

  it should "know its bean" in {
    booleanProperty.bean should equal(bean)
  }

  it should "be bindable to another Boolean Property" in {
    booleanProperty <== booleanProperty2
    booleanProperty2() = true
    booleanProperty() should be(true)
  }

  it should "support unbinding from another Boolean Property" in {
    booleanProperty <== booleanProperty2
    booleanProperty2() = true
    booleanProperty.unbind()
    booleanProperty2() = false
    booleanProperty() should be(true)
  }

  it should "be bidirectionally bindable to another Boolean Property" in {
    booleanProperty <==> booleanProperty2
    booleanProperty() = true
    booleanProperty2() should be(true)
    booleanProperty2() = false
    booleanProperty() should be(false)
  }

  it should "support bidirectional unbinding from another Boolean Property" in {
    booleanProperty <==> booleanProperty2
    booleanProperty() = true
    booleanProperty unbind booleanProperty2
    booleanProperty() = false
    booleanProperty2() should be(true)
  }

  it should "support bindable infix equality (===) with a property" in {
    booleanProperty <== booleanProperty2 === booleanProperty3
    booleanProperty2() = true
    booleanProperty3() = false
    booleanProperty() should be(false)
    booleanProperty3() = true
    booleanProperty() should be(true)
  }

  it should "support bindable infix equality (===) with an sfx property" in {
    booleanProperty <== booleanProperty2 === sfxBooleanProperty
    booleanProperty2() = true
    sfxBooleanProperty() = false
    booleanProperty() should be(false)
    sfxBooleanProperty() = true
    booleanProperty() should be(true)
  }

  it should "support bindable infix inequality (=!=) with a property" in {
    booleanProperty <== booleanProperty2 =!= booleanProperty3
    booleanProperty2() = true
    booleanProperty3() = false
    booleanProperty() should be(true)
    booleanProperty3() = true
    booleanProperty() should be(false)
  }

  it should "support bindable infix inequality (=!=) with an sfx property" in {
    booleanProperty <== booleanProperty2 =!= sfxBooleanProperty
    booleanProperty2() = true
    sfxBooleanProperty() = false
    booleanProperty() should be(true)
    sfxBooleanProperty() = true
    booleanProperty() should be(false)
  }

  it should "support bindable infix and (&&) with a property" in {
    booleanProperty <== booleanProperty2 && booleanProperty3
    booleanProperty2() = true
    booleanProperty3() = false
    booleanProperty() should be(false)
    booleanProperty3() = true
    booleanProperty() should be(true)
  }

  it should "support bindable infix and (&&) with an sfx property" in {
    booleanProperty <== booleanProperty2 && sfxBooleanProperty
    booleanProperty2() = true
    sfxBooleanProperty() = false
    booleanProperty() should be(false)
    sfxBooleanProperty() = true
    booleanProperty() should be(true)
  }

  it should "support bindable infix or (||) with a property" in {
    booleanProperty <== booleanProperty2 || booleanProperty3
    booleanProperty2() = true
    booleanProperty3() = false
    booleanProperty() should be(true)
    booleanProperty2() = false
    booleanProperty() should be(false)
  }

  it should "support bindable infix or (||) with an sfx property" in {
    booleanProperty <== booleanProperty2 || sfxBooleanProperty
    booleanProperty2() = true
    sfxBooleanProperty() = false
    booleanProperty() should be(true)
    booleanProperty2() = false
    booleanProperty() should be(false)
  }

  it should "support bindable prefix not (!)" in {
    booleanProperty <== !booleanProperty2
    booleanProperty2() = true
    booleanProperty() should be(false)
    booleanProperty2() = false
    booleanProperty() should be(true)
  }

  it should "do the right thing with order of operations" in {
    // order of operations should be ! > && > || > ==
    booleanProperty <== !booleanProperty3 === booleanProperty2 || !booleanProperty2 && !booleanProperty3
    booleanProperty2() = false
    booleanProperty3() = false
    booleanProperty() should be(true)
    booleanProperty2() = true
    booleanProperty3() = false
    booleanProperty() should be(true)
    booleanProperty2() = true
    booleanProperty3() = true
    booleanProperty() should be(false)
    booleanProperty2() = false
    booleanProperty3() = true
    booleanProperty() should be(true)
  }

  it should "support invalidate/change triggers on binding expressions" in {
    var invalidateCount = 0
    var changeCount     = 0
    val binding         = booleanProperty2 || booleanProperty3
    binding onInvalidate {
      invalidateCount += 1
    }
    binding onChange {
      changeCount += 1
    }
    booleanProperty2() = true
    invalidateCount should equal(1)
    changeCount should equal(1)
    booleanProperty3() = true
    invalidateCount should equal(1)
    changeCount should equal(1)
  }

  it should "support comparison starting with boolean constants" is (pending)
}
