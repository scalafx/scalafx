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

class ObjectPropertySpec extends FlatSpec {
  val bean = new Object()
  var objectProperty = new ObjectProperty[String](bean, "Test Object")
  var objectProperty2 = new ObjectProperty[String](bean, "Test Object 2")
  var booleanProperty = new BooleanProperty(bean, "Test Boolean")

  "An Object Property" should "have a default value of null" in {
    objectProperty.value should equal (null)
  }

  it should "be assignable using update" in {
    objectProperty() = "Update"
    objectProperty.value should equal ("Update")
  }

  it should "return its value using apply" in {
    objectProperty() should equal ("Update")
  }

  it should "know its name" in {
    objectProperty.name should equal ("Test Object")
  }

  it should "know its bean" in {
    objectProperty.bean should equal (bean)
  }

  it should "be bindable to another Object Property" in {
    objectProperty <== objectProperty2
    objectProperty2() = "Other value"
    objectProperty() should equal ("Other value")
    objectProperty.unbind()
  }

  it should "support unbinding from another Object Property" in {
    objectProperty <== objectProperty2
    objectProperty2() = "Yet another value"
    objectProperty.unbind()
    objectProperty2() = "This should not be visible"
    objectProperty() should equal ("Yet another value")
  }
  
  it should "support bindable infix equality with a property" in {
    booleanProperty <== objectProperty == objectProperty2
    objectProperty() = "One"
    objectProperty2() = "Two"
    booleanProperty() should equal (false)
    objectProperty2() = "One"
    booleanProperty() should equal (true)
    booleanProperty.unbind()
  }

  it should "support bindable infix equality with a constant" in {
    booleanProperty <== objectProperty == "One"
    objectProperty() = "Two"
    booleanProperty() should equal (false)
    objectProperty() = "One"
    booleanProperty() should equal (true)
    booleanProperty.unbind()
  }

  it should "support bindable infix inequality with a property" in {
    booleanProperty <== objectProperty != objectProperty2
    objectProperty() = "One"
    objectProperty2() = "Two"
    booleanProperty() should equal (true)
    objectProperty2() = "One"
    booleanProperty() should equal (false)
    booleanProperty.unbind()
  }

  it should "support bindable infix inequality with a constant" in {
    booleanProperty <== objectProperty != "One"
    objectProperty() = "Two"
    booleanProperty() should equal (true)
    objectProperty() = "One"
    booleanProperty() should equal (false)
    booleanProperty.unbind()
  }
  

}
