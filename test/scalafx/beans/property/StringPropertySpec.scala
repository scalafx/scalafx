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

class StringPropertySpec extends FlatSpec with BeforeAndAfterEach {
  val bean = new Object()
  var booleanProperty: jfxbp.BooleanProperty = null
  var stringProperty: jfxbp.StringProperty = null
  var stringProperty2: jfxbp.StringProperty = null
  var stringProperty3: jfxbp.StringProperty = null
  var sfxStringProperty: StringProperty = null

  override def beforeEach() {
    booleanProperty = new BooleanProperty(bean, "Test Boolean")
    stringProperty = new StringProperty(bean, "Test String")
    stringProperty2 = new StringProperty(bean, "Test String 2")
    stringProperty3 = new StringProperty(bean, "Test String 3")
    sfxStringProperty = new StringProperty(bean, "Test SFX String")
  }

  "A String Property" should "have a default value of null" in {
    stringProperty.value should be (null)
  }

  it should "be assignable using update" in {
    stringProperty() = "hello"
    stringProperty.value should equal ("hello")
  }

  it should "return its value using apply" in {
    stringProperty() = "apply"
    stringProperty() should equal ("apply")
  }

  it should "know its name" in {
    stringProperty.name should equal ("Test String")
  }

  it should "know its bean" in {
    stringProperty.bean should equal (bean)
  }

  it should "be bindable to another String Property" in {
    stringProperty <== stringProperty2
    stringProperty2() = "binding"
    stringProperty() should equal ("binding")
  }

  it should "support unbinding from another String Property" in {
    stringProperty <== stringProperty2
    stringProperty2() = "unbound"
    stringProperty.unbind()
    stringProperty2() = "fail"
    stringProperty() should equal ("unbound")
  }

  it should "be bidirectionally bindable to another String Property" in {
    stringProperty <==> stringProperty2
    stringProperty() = "bi=binding"
    stringProperty2() should equal ("bi=binding")
    stringProperty2() = "bi-binding2"
    stringProperty() should equal ("bi-binding2")
  }

  it should "support bidirectional unbinding from another String Property" in {
    stringProperty <==> stringProperty2
    stringProperty() = "bi-unbound"
    stringProperty unbind stringProperty2
    stringProperty() = "fail"
    stringProperty2() should equal ("bi-unbound")
  }

  it should "support bindable infix equality (===) with a property" in {
    booleanProperty <== stringProperty === stringProperty2
    stringProperty() = "something"
    stringProperty2() = "something else"
    booleanProperty() should be (false)
    stringProperty2() = "something"
    booleanProperty() should be (true)
  }

  it should "support bindable infix equality (===) with an sfx property" in {
    booleanProperty <== stringProperty === sfxStringProperty
    stringProperty() = "something"
    sfxStringProperty() = "something else"
    booleanProperty() should be (false)
    sfxStringProperty() = "something"
    booleanProperty() should be (true)
  }

  it should "support bindable infix equality (===) with a string" in {
    booleanProperty <== stringProperty === "something"
    stringProperty() = "something else"
    booleanProperty() should be (false)
    stringProperty() = "something"
    booleanProperty() should be (true)
  }

  it should "support null/empty-string comparisons for equals (===)" in {
    booleanProperty <== stringProperty === null
    stringProperty() = "clearly not null"
    booleanProperty() should be (false)
    stringProperty() = null
    booleanProperty() should be (true)
    stringProperty() = ""
    booleanProperty() should be (false)
    booleanProperty <== stringProperty === ""
    stringProperty() = "clearly not empty"
    booleanProperty() should be (false)
    stringProperty() = null
    booleanProperty() should be (true)
    stringProperty() = ""
    booleanProperty() should be (true)
  }

  it should "support bindable infix inequality (=!=) with a property" in {
    booleanProperty <== stringProperty =!= stringProperty2
    stringProperty() = "something"
    stringProperty2() = "something else"
    booleanProperty() should be (true)
    stringProperty2() = "something"
    booleanProperty() should be (false)
  }

  it should "support bindable infix inequality (=!=) with an sfx property" in {
    booleanProperty <== stringProperty =!= sfxStringProperty
    stringProperty() = "something"
    sfxStringProperty() = "something else"
    booleanProperty() should be (true)
    sfxStringProperty() = "something"
    booleanProperty() should be (false)
  }

  it should "support bindable infix inequality (=!=) with a string" in {
    booleanProperty <== stringProperty =!= "something"
    stringProperty() = "something else"
    booleanProperty() should be (true)
    stringProperty() = "something"
    booleanProperty() should be (false)
  }

  it should "support null/empty-string comparisons for not equals (=!=)" in {
    booleanProperty <== stringProperty =!= null
    stringProperty() = "clearly not null"
    booleanProperty() should be (true)
    stringProperty() = null
    booleanProperty() should be (false)
    stringProperty() = ""
    booleanProperty() should be (true)
    booleanProperty <== stringProperty =!= ""
    stringProperty() = "clearly not empty"
    booleanProperty() should be (true)
    stringProperty() = null
    booleanProperty() should be (false)
    stringProperty() = ""
    booleanProperty() should be (false)
  }

  it should "support bindable infix, case-insensitive equality (==~) with a property" in {
    booleanProperty <== stringProperty ==~ stringProperty2
    stringProperty() = "something"
    stringProperty2() = "something else"
    booleanProperty() should be (false)
    stringProperty2() = "SOMETHING"
    booleanProperty() should be (true)
  }

  it should "support bindable infix, case-insensitive equality (==~) with an sfx property" in {
    booleanProperty <== stringProperty ==~ sfxStringProperty
    stringProperty() = "something"
    sfxStringProperty() = "something else"
    booleanProperty() should be (false)
    sfxStringProperty() = "SOMETHING"
    booleanProperty() should be (true)
  }

  it should "support bindable infix, case-insensitive equality (==~) with a string" in {
    booleanProperty <== stringProperty ==~ "something"
    stringProperty() = "something"
    booleanProperty() should be (true)
    stringProperty() = "SOMETHING"
    booleanProperty() should be (true)
  }

  it should "support null/empty-string comparisons for case-insensitive equals (==~)" in {
    booleanProperty <== stringProperty ==~ null
    stringProperty() = "clearly not null"
    booleanProperty() should be (false)
    stringProperty() = null
    booleanProperty() should be (true)
    stringProperty() = ""
    booleanProperty() should be (false)
    booleanProperty <== stringProperty ==~ ""
    stringProperty() = "clearly not empty"
    booleanProperty() should be (false)
    stringProperty() = null
    booleanProperty() should be (true)
    stringProperty() = ""
    booleanProperty() should be (true)
  }

  it should "support bindable infix, case-insensitive inequality (!=~) with a property" in {
    booleanProperty <== stringProperty !=~ stringProperty2
    stringProperty() = "something"
    stringProperty2() = "something else"
    booleanProperty() should be (true)
    stringProperty2() = "SOMETHING"
    booleanProperty() should be (false)
  }

  it should "support bindable infix, case-insensitive inequality (!=~) with an sfx property" in {
    booleanProperty <== stringProperty !=~ sfxStringProperty
    stringProperty() = "something"
    sfxStringProperty() = "something else"
    booleanProperty() should be (true)
    sfxStringProperty() = "SOMETHING"
    booleanProperty() should be (false)
  }

  it should "support bindable infix, case-insensitive inequality (!=~) with a string" in {
    booleanProperty <== stringProperty !=~ "something"
    stringProperty() = "something"
    booleanProperty() should be (false)
    stringProperty() = "SOMETHING"
    booleanProperty() should be (false)
  }

  it should "support null/empty-string comparisons for case-insensitive not equals (=!=)" in {
    booleanProperty <== stringProperty !=~ null
    stringProperty() = "clearly not null"
    booleanProperty() should be (true)
    stringProperty() = null
    booleanProperty() should be (false)
    stringProperty() = ""
    booleanProperty() should be (true)
    booleanProperty <== stringProperty !=~ ""
    stringProperty() = "clearly not empty"
    booleanProperty() should be (true)
    stringProperty() = null
    booleanProperty() should be (false)
    stringProperty() = ""
    booleanProperty() should be (false)
  }

  it should "support bindable infix less than (<) with a property" in {
    booleanProperty <== stringProperty < stringProperty2
    stringProperty() = "beta"
    stringProperty2() = "cappa"
    booleanProperty() should be (true)
    stringProperty2() = "alpha"
    booleanProperty() should be (false)
  }

  it should "support bindable infix less than (<) with an sfx property" in {
    booleanProperty <== stringProperty < sfxStringProperty
    stringProperty() = "beta"
    sfxStringProperty() = "cappa"
    booleanProperty() should be (true)
    sfxStringProperty() = "alpha"
    booleanProperty() should be (false)
  }

  it should "support bindable infix less than (<) with a string" in {
    booleanProperty <== stringProperty < "beta"
    stringProperty() = "alpha"
    booleanProperty() should be (true)
    stringProperty() = "cappa"
    booleanProperty() should be (false)
  }

  it should "support null/empty-string comparisons for less than (<)" in {
    booleanProperty <== stringProperty < null
    stringProperty() = "clearly not null"
    booleanProperty() should be (false)
    stringProperty() = null
    booleanProperty() should be (false)
    stringProperty() = ""
    booleanProperty() should be (false)
    booleanProperty <== stringProperty < ""
    stringProperty() = "clearly not empty"
    booleanProperty() should be (false)
    stringProperty() = null
    booleanProperty() should be (false)
    stringProperty() = ""
    booleanProperty() should be (false)
  }

  it should "support bindable infix less than or equal to (<=) with a property" in {
    booleanProperty <== stringProperty <= stringProperty2
    stringProperty() = "beta"
    stringProperty2() = "cappa"
    booleanProperty() should be (true)
    stringProperty2() = "beta"
    booleanProperty() should be (true)
    stringProperty2() = "alpha"
    booleanProperty() should be (false)
  }

  it should "support bindable infix less than or equal to (<=) with an sfx property" in {
    booleanProperty <== stringProperty <= sfxStringProperty
    stringProperty() = "beta"
    sfxStringProperty() = "cappa"
    booleanProperty() should be (true)
    sfxStringProperty() = "beta"
    booleanProperty() should be (true)
    sfxStringProperty() = "alpha"
    booleanProperty() should be (false)
  }

  it should "support bindable infix less than or equal to (<=) with a string" in {
    booleanProperty <== stringProperty <= "beta"
    stringProperty() = "alpha"
    booleanProperty() should be (true)
    stringProperty() = "beta"
    booleanProperty() should be (true)
    stringProperty() = "cappa"
    booleanProperty() should be (false)
  }

  it should "support null/empty-string comparisons for less than or equal to (<=)" in {
    booleanProperty <== stringProperty <= null
    stringProperty() = "clearly not null"
    booleanProperty() should be (false)
    stringProperty() = null
    booleanProperty() should be (true)
    stringProperty() = ""
    booleanProperty() should be (true)
    booleanProperty <== stringProperty <= ""
    stringProperty() = "clearly not empty"
    booleanProperty() should be (false)
    stringProperty() = null
    booleanProperty() should be (true)
    stringProperty() = ""
    booleanProperty() should be (true)
  }

  it should "support bindable infix greater than (>) with a property" in {
    booleanProperty <== stringProperty > stringProperty2
    stringProperty() = "beta"
    stringProperty2() = "cappa"
    booleanProperty() should be (false)
    stringProperty2() = "alpha"
    booleanProperty() should be (true)
  }

  it should "support bindable infix greater than (>) with an sfx property" in {
    booleanProperty <== stringProperty > sfxStringProperty
    stringProperty() = "beta"
    sfxStringProperty() = "cappa"
    booleanProperty() should be (false)
    sfxStringProperty() = "alpha"
    booleanProperty() should be (true)
  }

  it should "support bindable infix greater than (>) with a string" in {
    booleanProperty <== stringProperty > "beta"
    stringProperty() = "alpha"
    booleanProperty() should be (false)
    stringProperty() = "cappa"
    booleanProperty() should be (true)
  }

  it should "support null/empty-string comparisons for greater than (>)" in {
    booleanProperty <== stringProperty > null
    stringProperty() = "clearly not null"
    booleanProperty() should be (true)
    stringProperty() = null
    booleanProperty() should be (false)
    stringProperty() = ""
    booleanProperty() should be (false)
    booleanProperty <== stringProperty > ""
    stringProperty() = "clearly not empty"
    booleanProperty() should be (true)
    stringProperty() = null
    booleanProperty() should be (false)
    stringProperty() = ""
    booleanProperty() should be (false)
  }

  it should "support bindable infix greater than or equal to (>=) with a property" in {
    booleanProperty <== stringProperty >= stringProperty2
    stringProperty() = "beta"
    stringProperty2() = "cappa"
    booleanProperty() should be (false)
    stringProperty2() = "beta"
    booleanProperty() should be (true)
    stringProperty2() = "alpha"
    booleanProperty() should be (true)
  }

  it should "support bindable infix greater than or equal to (>=) with an sfx property" in {
    booleanProperty <== stringProperty >= sfxStringProperty
    stringProperty() = "beta"
    sfxStringProperty() = "cappa"
    booleanProperty() should be (false)
    sfxStringProperty() = "beta"
    booleanProperty() should be (true)
    sfxStringProperty() = "alpha"
    booleanProperty() should be (true)
  }

  it should "support bindable infix greater than or equal to (>=) with a string" in {
    booleanProperty <== stringProperty >= "beta"
    stringProperty() = "alpha"
    booleanProperty() should be (false)
    stringProperty() = "beta"
    booleanProperty() should be (true)
    stringProperty() = "cappa"
    booleanProperty() should be (true)
  }

  it should "support null/empty-string comparisons for greater than or equal to (>=)" in {
    booleanProperty <== stringProperty >= null
    stringProperty() = "clearly not null"
    booleanProperty() should be (true)
    stringProperty() = null
    booleanProperty() should be (true)
    stringProperty() = ""
    booleanProperty() should be (true)
    booleanProperty <== stringProperty >= ""
    stringProperty() = "clearly not empty"
    booleanProperty() should be (true)
    stringProperty() = null
    booleanProperty() should be (true)
    stringProperty() = ""
    booleanProperty() should be (true)
  }

  it should "support concatenation" in {
    stringProperty <== stringProperty2 + " " + stringProperty3
    stringProperty2() = "Hello"
    stringProperty3() = "World"
    stringProperty() should equal ("Hello World")
  }

  it should "support concatenation of nulls/primitives" in {
    stringProperty <== stringProperty2 + null + stringProperty3 + 15
    stringProperty2() = "Hello"
    stringProperty3() = "World"
    stringProperty() should equal ("HellonullWorld15")
  }

  it should "support concatenation starting with nulls/primitives/strings" is (pending)
}