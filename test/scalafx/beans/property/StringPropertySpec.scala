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

class StringPropertySpec extends FlatSpec with BeforeAndAfterEach {
  val bean = new Object()
  var booleanProperty: BooleanProperty = null
  var stringProperty: StringProperty = null
  var stringProperty2: StringProperty = null
  var stringProperty3: StringProperty = null

  override def beforeEach() {
    booleanProperty = new BooleanProperty(bean, "Test Boolean")
    stringProperty = new StringProperty(bean, "Test String")
    stringProperty2 = new StringProperty(bean, "Test String 2")
    stringProperty3 = new StringProperty(bean, "Test String 3")
  }

  "A String Property" should "have a default value of null" in {
    stringProperty.value should equal(null)
  }

  it should "be assignable using update" in {
    stringProperty() = "hello"
    stringProperty.value should equal("hello")
  }

  it should "return its value using apply" in {
    stringProperty() = "apply"
    stringProperty() should equal("apply")
  }

  it should "know its name" in {
    stringProperty.name should equal("Test String")
  }

  it should "know its bean" in {
    stringProperty.bean should equal(bean)
  }

  it should "be bindable to another String Property" in {
    stringProperty <== stringProperty2
    stringProperty2() = "binding"
    stringProperty() should equal("binding")
  }

  it should "support unbinding from another String Property" in {
    stringProperty <== stringProperty2
    stringProperty2() = "unbound"
    stringProperty.unbind()
    stringProperty2() = "fail"
    stringProperty() should equal("unbound")
  }

  it should "be bidirectionally bindable to another String Property" in {
    stringProperty <==> stringProperty2
    stringProperty() = "bi=binding"
    stringProperty2() should equal("bi=binding")
    stringProperty2() = "bi-binding2"
    stringProperty() should equal("bi-binding2")
  }

  it should "support bidirectional unbinding from another String Property" in {
    stringProperty <==> stringProperty2
    stringProperty() = "bi-unbound"
    stringProperty unbind stringProperty2
    stringProperty() = "fail"
    stringProperty2() should equal("bi-unbound")
  }

  it should "support bindable infix equality (==) with a property" in {
    booleanProperty <== stringProperty == stringProperty2
    stringProperty() = "something"
    stringProperty2() = "something else"
    booleanProperty() should equal(false)
    stringProperty2() = "something"
    booleanProperty() should equal(true)
  }

  it should "support bindable infix equality (==) with a jfx property" in {
    booleanProperty <== stringProperty == stringProperty2.delegate
    stringProperty() = "something"
    stringProperty2() = "something else"
    booleanProperty() should equal(false)
    stringProperty2() = "something"
    booleanProperty() should equal(true)
  }

  it should "support bindable infix equality (==) with a string" in {
    booleanProperty <== stringProperty == "something"
    stringProperty() = "something else"
    booleanProperty() should equal(false)
    stringProperty() = "something"
    booleanProperty() should equal(true)
  }

  it should "support bindable infix inequality (!=) with a property" in {
    booleanProperty <== stringProperty != stringProperty2
    stringProperty() = "something"
    stringProperty2() = "something else"
    booleanProperty() should equal(true)
    stringProperty2() = "something"
    booleanProperty() should equal(false)
  }

  it should "support bindable infix inequality (!=) with a jfx property" in {
    booleanProperty <== stringProperty != stringProperty2.delegate
    stringProperty() = "something"
    stringProperty2() = "something else"
    booleanProperty() should equal(true)
    stringProperty2() = "something"
    booleanProperty() should equal(false)
  }

  it should "support bindable infix inequality (!=) with a string" in {
    booleanProperty <== stringProperty != "something"
    stringProperty() = "something else"
    booleanProperty() should equal(true)
    stringProperty() = "something"
    booleanProperty() should equal(false)
  }

  it should "support bindable infix, case-insensitive equality (==~) with a property" in {
    booleanProperty <== stringProperty ==~ stringProperty2
    stringProperty() = "something"
    stringProperty2() = "something else"
    booleanProperty() should equal(false)
    stringProperty2() = "SOMETHING"
    booleanProperty() should equal(true)
  }

  it should "support bindable infix, case-insensitive equality (==~) with a jfx property" in {
    booleanProperty <== stringProperty ==~ stringProperty2.delegate
    stringProperty() = "something"
    stringProperty2() = "something else"
    booleanProperty() should equal(false)
    stringProperty2() = "SOMETHING"
    booleanProperty() should equal(true)
  }

  it should "support bindable infix, case-insensitive equality (==~) with a string" in {
    booleanProperty <== stringProperty ==~ "something"
    stringProperty() = "something"
    booleanProperty() should equal(true)
    stringProperty() = "SOMETHING"
    booleanProperty() should equal(true)
  }

  it should "support bindable infix, case-insensitive inequality (!=~) with a property" in {
    booleanProperty <== stringProperty !=~ stringProperty2
    stringProperty() = "something"
    stringProperty2() = "something else"
    booleanProperty() should equal(true)
    stringProperty2() = "SOMETHING"
    booleanProperty() should equal(false)
  }

  it should "support bindable infix, case-insensitive inequality (!=~) with a jfx property" in {
    booleanProperty <== stringProperty !=~ stringProperty2.delegate
    stringProperty() = "something"
    stringProperty2() = "something else"
    booleanProperty() should equal(true)
    stringProperty2() = "SOMETHING"
    booleanProperty() should equal(false)
  }

  it should "support bindable infix, case-insensitive inequality (!=~) with a string" in {
    booleanProperty <== stringProperty !=~ "something"
    stringProperty() = "something"
    booleanProperty() should equal(false)
    stringProperty() = "SOMETHING"
    booleanProperty() should equal(false)
  }

  it should "support concatenation" in {
    stringProperty <== stringProperty2 + " " + stringProperty3
    stringProperty2() = "Hello"
    stringProperty3() = "World"
    stringProperty() should equal("Hello World")
  }
}