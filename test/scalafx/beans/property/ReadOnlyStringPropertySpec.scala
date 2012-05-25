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
 * ReadOnlyStringProperty Spec tests.
 *
 *
 */
@RunWith(classOf[JUnitRunner])
class ReadOnlyStringPropertySpec extends FlatSpec with BeforeAndAfterEach {
  val bean = new Object()
  var booleanProperty: jfxbp.BooleanProperty = null
  var readOnlyStringProperty: jfxbp.ReadOnlyStringProperty = null
  var stringProperty: jfxbp.StringProperty = null
  var stringProperty2: jfxbp.StringProperty = null
  var sfxStringProperty: StringProperty = null

  override def beforeEach() {
    booleanProperty = new BooleanProperty(bean, "Test Boolean")
    readOnlyStringProperty = new ReadOnlyStringProperty(bean, "Test Read-only String", "read-only")
    stringProperty = new StringProperty(bean, "Test String")
    stringProperty2 = new StringProperty(bean, "Test String 2")
    sfxStringProperty = new StringProperty(bean, "Test SFX String")
  }

  "A Read-only String Property" should "return the constant value set" in {
    readOnlyStringProperty.value should equal ("read-only")
  }

  it should "return its value using apply" in {
    readOnlyStringProperty() should equal ("read-only")
  }

  it should "know its name" in {
    readOnlyStringProperty.name should equal ("Test Read-only String")
  }

  it should "know its bean" in {
    readOnlyStringProperty.bean should equal (bean)
  }

  it should "be bindable to another String Property" in {
    stringProperty <== readOnlyStringProperty
    stringProperty() should equal ("read-only")
  }

  it should "support unbinding from another String Property" in {
    stringProperty <== readOnlyStringProperty
    stringProperty() should equal ("read-only")
    stringProperty.unbind()
    stringProperty() = "other"
    stringProperty() should equal ("other")
  }

  it should "support bindable infix equality (===) with a property" in {
    booleanProperty <== stringProperty === readOnlyStringProperty
    stringProperty() = "something"
    booleanProperty() should be (false)
    stringProperty() = "read-only"
    booleanProperty() should be (true)
  }

  it should "support bindable infix equality (===) with an sfx property" in {
    booleanProperty <== readOnlyStringProperty === sfxStringProperty
    sfxStringProperty() = "something"
    booleanProperty() should be (false)
    sfxStringProperty() = "read-only"
    booleanProperty() should be (true)
  }

  it should "support bindable infix equality (===) with a string" in {
    booleanProperty <== readOnlyStringProperty === "something"
    booleanProperty() should be (false)
    booleanProperty <== readOnlyStringProperty === "read-only"
    booleanProperty() should be (true)
  }

  it should "support null/empty-string comparisons for equals (===)" in {
    booleanProperty <== readOnlyStringProperty === null
    booleanProperty() should be (false)
    booleanProperty <== readOnlyStringProperty === ""
    booleanProperty() should be (false)
  }

  it should "support bindable infix inequality (=!=) with a property" in {
    booleanProperty <== stringProperty =!= readOnlyStringProperty
    stringProperty() = "something"
    booleanProperty() should be (true)
    stringProperty() = "read-only"
    booleanProperty() should be (false)
  }

  it should "support bindable infix inequality (=!=) with an sfx property" in {
    booleanProperty <== readOnlyStringProperty =!= sfxStringProperty
    sfxStringProperty() = "something"
    booleanProperty() should be (true)
    sfxStringProperty() = "read-only"
    booleanProperty() should be (false)
  }

  it should "support bindable infix inequality (=!=) with a string" in {
    booleanProperty <== readOnlyStringProperty =!= "something"
    booleanProperty() should be (true)
    booleanProperty <== readOnlyStringProperty =!= "read-only"
    booleanProperty() should be (false)
  }

  it should "support null/empty-string comparisons for not equals (=!=)" in {
    booleanProperty <== readOnlyStringProperty =!= null
    booleanProperty() should be (true)
    booleanProperty <== readOnlyStringProperty =!= ""
    booleanProperty() should be (true)
  }

  it should "support bindable infix, case-insensitive equality (==~) with a property" in {
    booleanProperty <== stringProperty ==~ readOnlyStringProperty
    stringProperty() = "something"
    booleanProperty() should be (false)
    stringProperty() = "READ-ONLY"
    booleanProperty() should be (true)
  }

  it should "support bindable infix, case-insensitive equality (==~) with an sfx property" in {
    booleanProperty <== readOnlyStringProperty ==~ sfxStringProperty
    sfxStringProperty() = "something"
    booleanProperty() should be (false)
    sfxStringProperty() = "READ-ONLY"
    booleanProperty() should be (true)
  }

  it should "support bindable infix, case-insensitive equality (==~) with a string" in {
    booleanProperty <== readOnlyStringProperty ==~ "something"
    booleanProperty() should be (false)
    booleanProperty <== readOnlyStringProperty ==~ "READ-ONLY"
    booleanProperty() should be (true)
  }

  it should "support null/empty-string comparisons for case-insensitive equals (==~)" in {
    booleanProperty <== readOnlyStringProperty ==~ null
    booleanProperty() should be (false)
    booleanProperty <== readOnlyStringProperty ==~ ""
    booleanProperty() should be (false)
  }

  it should "support bindable infix, case-insensitive inequality (!=~) with a property" in {
    booleanProperty <== stringProperty !=~ readOnlyStringProperty
    stringProperty() = "something"
    booleanProperty() should be (true)
    stringProperty() = "READ-ONLY"
    booleanProperty() should be (false)
  }

  it should "support bindable infix, case-insensitive inequality (!=~) with an sfx property" in {
    booleanProperty <== readOnlyStringProperty !=~ sfxStringProperty
    sfxStringProperty() = "something"
    booleanProperty() should be (true)
    sfxStringProperty() = "READ-ONLY"
    booleanProperty() should be (false)
  }

  it should "support bindable infix, case-insensitive inequality (!=~) with a string" in {
    booleanProperty <== readOnlyStringProperty !=~ "something"
    booleanProperty() should be (true)
    booleanProperty <== readOnlyStringProperty !=~ "READ-ONLY"
    booleanProperty() should be (false)
  }

  it should "support null/empty-string comparisons for case-insensitive not equals (!=~)" in {
    booleanProperty <== readOnlyStringProperty !=~ null
    booleanProperty() should be (true)
    booleanProperty <== readOnlyStringProperty !=~ ""
    booleanProperty() should be (true)
  }

  it should "support bindable infix less than (<) with a property" in {
    booleanProperty <== stringProperty < readOnlyStringProperty
    stringProperty() = "alpha"
    booleanProperty() should be (true)
    stringProperty() = "zed"
    booleanProperty() should be (false)
  }

  it should "support bindable infix less than (<) with a string" in {
    booleanProperty <== readOnlyStringProperty < "alpha"
    booleanProperty() should be (false)
    booleanProperty <== readOnlyStringProperty < "zed"
    booleanProperty() should be (true)
  }

  it should "support null/empty-string comparisons for less than (<)" in {
    booleanProperty <== readOnlyStringProperty < null
    booleanProperty() should be (false)
    booleanProperty <== readOnlyStringProperty < ""
    booleanProperty() should be (false)
  }

  it should "support bindable infix less than or equal to (<=) with a property" in {
    booleanProperty <== stringProperty <= readOnlyStringProperty
    stringProperty() = "alpha"
    booleanProperty() should be (true)
    stringProperty() = "read-only"
    booleanProperty() should be (true)
    stringProperty() = "zed"
    booleanProperty() should be (false)
  }

  it should "support bindable infix less than or equal to (<=) with a string" in {
    booleanProperty <== readOnlyStringProperty <= "alpha"
    booleanProperty() should be (false)
    booleanProperty <== readOnlyStringProperty <= "read-only"
    booleanProperty() should be (true)
    booleanProperty <== readOnlyStringProperty <= "zed"
    booleanProperty() should be (true)
  }

  it should "support null/empty-string comparisons for less than or equal to (<=)" in {
    booleanProperty <== readOnlyStringProperty <= null
    booleanProperty() should be (false)
    booleanProperty <== readOnlyStringProperty <= ""
    booleanProperty() should be (false)
  }

  it should "support bindable infix greater than (>) with a property" in {
    booleanProperty <== stringProperty > readOnlyStringProperty
    stringProperty() = "alpha"
    booleanProperty() should be (false)
    stringProperty() = "zed"
    booleanProperty() should be (true)
  }

  it should "support bindable infix greater than (>) with a string" in {
    booleanProperty <== readOnlyStringProperty > "alpha"
    booleanProperty() should be (true)
    booleanProperty <== readOnlyStringProperty > "zed"
    booleanProperty() should be (false)
  }

  it should "support null/empty-string comparisons for greater than (>)" in {
    booleanProperty <== readOnlyStringProperty > null
    booleanProperty() should be (true)
    booleanProperty <== readOnlyStringProperty > ""
    booleanProperty() should be (true)
  }

  it should "support bindable infix greater than or equal to (>=) with a property" in {
    booleanProperty <== stringProperty >= readOnlyStringProperty
    stringProperty() = "alpha"
    booleanProperty() should be (false)
    stringProperty() = "read-only"
    booleanProperty() should be (true)
    stringProperty() = "zed"
    booleanProperty() should be (true)
  }

  it should "support bindable infix greater than or equal to (>=) with a string" in {
    booleanProperty <== readOnlyStringProperty >= "alpha"
    booleanProperty() should be (true)
    booleanProperty <== readOnlyStringProperty >= "read-only"
    booleanProperty() should be (true)
    booleanProperty <== readOnlyStringProperty >= "zed"
    booleanProperty() should be (false)
  }

  it should "support null/empty-string comparisons for greater than or equal to (>=)" in {
    booleanProperty <== readOnlyStringProperty >= null
    booleanProperty() should be (true)
    booleanProperty <== readOnlyStringProperty >= ""
    booleanProperty() should be (true)
  }

  it should "support concatenation" in {
    stringProperty <== readOnlyStringProperty + " " + stringProperty2
    stringProperty2() = "World"
    stringProperty() should equal ("read-only World")
  }

  it should "support concatenation of nulls/primitives" in {
    stringProperty <== readOnlyStringProperty + null + stringProperty2 + 15
    stringProperty2() = "World"
    stringProperty() should equal ("read-onlynullWorld15")
  }
}