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

import java.{util => ju}

import javafx.beans.{property => jfxbp, value => jfxbv}
import javafx.scene.{control => jfxsc}
import org.scalatest.BeforeAndAfterEach
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers._
import scalafx.Includes.{jfxBooleanProperty2sfx, jfxObjectProperty2sfx, sfxObjectPropertyWithSFXDelegate2jfxObjectProperty}
import scalafx.beans.property.BooleanProperty.sfxBooleanProperty2jfx
import scalafx.beans.property.ObjectProperty.sfxObjectProperty2jfx
import scalafx.scene.control.Button
import scalafx.testutil.RunOnApplicationThread

/**
 * ObjectProperty Spec tests.
 */
class ObjectPropertySpec extends AnyFlatSpec with BeforeAndAfterEach with RunOnApplicationThread {
  val bean                                          = new Object()
  var objectProperty: jfxbp.ObjectProperty[String]  = _
  var objectProperty2: jfxbp.ObjectProperty[String] = _
  var sfxObjectProperty: ObjectProperty[String]     = _
  var booleanProperty: jfxbp.BooleanProperty        = _

  override protected def beforeEach(): Unit = {
    objectProperty = ObjectProperty[String](bean, "Test Object")
    objectProperty2 = ObjectProperty[String](bean, "Test Object 2")
    sfxObjectProperty = ObjectProperty[String](bean, "SFX Test Object")
    booleanProperty = new BooleanProperty(bean, "Test Boolean")
  }

  "An Object Property" should "have a default value of null" in {
    objectProperty.value should be(null.asInstanceOf[String])
  }

  it should "be assignable using update" in {
    objectProperty() = "Update"
    objectProperty.value should equal("Update")
  }

  it should "return its value using apply" in {
    objectProperty() = "Update"
    objectProperty() should equal("Update")
  }

  it should "know its name" in {
    objectProperty.name should equal("Test Object")
  }

  it should "know its bean" in {
    objectProperty.bean should equal(bean)
  }

  it should "be bindable to another Object Property" in {
    objectProperty <== objectProperty2
    objectProperty2() = "Other value"
    objectProperty() should equal("Other value")
    objectProperty.unbind()
  }

  it should "be bindable to another SFX Object Property" in {
    objectProperty <== sfxObjectProperty
    sfxObjectProperty() = "Other value"
    objectProperty() should equal("Other value")
    objectProperty.unbind()
  }

  it should "support unbinding from another Object Property" in {
    objectProperty <== objectProperty2
    objectProperty2() = "Yet another value"
    objectProperty.unbind()
    objectProperty2() = "This should not be visible"
    objectProperty() should equal("Yet another value")
  }

  it should "support bindable infix equality with a property" in {
    booleanProperty <== objectProperty === objectProperty2
    objectProperty() = "One"
    objectProperty2() = "Two"
    booleanProperty() should be(false)
    objectProperty2() = "One"
    booleanProperty() should be(true)
    booleanProperty.unbind()
  }

  it should "support bindable infix equality with an sfx property" in {
    booleanProperty <== objectProperty === sfxObjectProperty
    objectProperty() = "One"
    sfxObjectProperty() = "Two"
    booleanProperty() should be(false)
    sfxObjectProperty() = "One"
    booleanProperty() should be(true)
    booleanProperty.unbind()
  }

  it should "support bindable infix equality with a constant" in {
    booleanProperty <== objectProperty === "One"
    objectProperty() = "Two"
    booleanProperty() should be(false)
    objectProperty() = "One"
    booleanProperty() should be(true)
    booleanProperty.unbind()
  }

  it should "support null comparisons for equal to (===)" in {
    booleanProperty <== objectProperty === null
    objectProperty() = "clearly not null"
    booleanProperty() should be(false)
    objectProperty() = null
    booleanProperty() should be(true)
  }

  it should "support bindable infix inequality with a property" in {
    booleanProperty <== objectProperty =!= objectProperty2
    objectProperty() = "One"
    objectProperty2() = "Two"
    booleanProperty() should be(true)
    objectProperty2() = "One"
    booleanProperty() should be(false)
    booleanProperty.unbind()
  }

  it should "support bindable infix inequality with an sfx property" in {
    booleanProperty <== objectProperty =!= sfxObjectProperty
    objectProperty() = "One"
    sfxObjectProperty() = "Two"
    booleanProperty() should be(true)
    sfxObjectProperty() = "One"
    booleanProperty() should be(false)
    booleanProperty.unbind()
  }

  it should "support bindable infix inequality with a constant" in {
    booleanProperty <== objectProperty =!= "One"
    objectProperty() = "Two"
    booleanProperty() should be(true)
    objectProperty() = "One"
    booleanProperty() should be(false)
    booleanProperty.unbind()
  }

  it should "support null comparisons for not equal to (=!=)" in {
    booleanProperty <== objectProperty =!= null
    objectProperty() = "clearly not null"
    booleanProperty() should be(true)
    objectProperty() = null
    booleanProperty() should be(false)
  }

  it should "support invalidate/change triggers on binding expressions" in {
    var invalidateCount = 0
    var changeCount     = 0
    val binding         = objectProperty === objectProperty2
    binding onInvalidate {
      invalidateCount += 1
    }
    binding onChange {
      changeCount += 1
    }
    objectProperty() = "new value"
    invalidateCount should equal(1)
    changeCount should equal(1)
    objectProperty2() = "new value"
    invalidateCount should equal(2)
    changeCount should equal(2)
  }

  it should "support implicit conversion to a String Binding" is pending

  it should "support implicit conversion from a ScalaFX ObjectProperty with a SFXDelegate of a type T to a JavaFX ObjectProperty of type T" in {
    val scalaObjProperty: ObjectProperty[Button]            = ObjectProperty[Button](new Button("Test"))
    val javaObjProperty: jfxbp.ObjectProperty[jfxsc.Button] = scalaObjProperty

    javaObjProperty.get should be(scalaObjProperty.value.delegate)
  }

  it should "be able to hold a value type like Double" in {

    val p = new ObjectProperty[Double]
    p.value = 42.1

    assert(42.1 === p.value)
  }

  it should "bind SFX <==> JFX holding a value type like Double" in {
    val sfxProperty = ObjectProperty[Double](null, "sfx", 13.2)
    val jfxProperty = new jfxbp.SimpleObjectProperty[Double](this, "jfx", 224.7)

    sfxProperty <==> jfxProperty
    sfxProperty() = 17.8
    assert(17.8 === sfxProperty())
    assert(17.8 === jfxProperty())

    jfxProperty() = 21.2
    assert(21.2 === sfxProperty())
    assert(21.2 === jfxProperty())
  }

  it should "bind JFX <==> SFX holding a value type like Double" in {
    val sfxProperty = ObjectProperty[Double](null, "sfx", 13.2)
    val jfxProperty = new jfxbp.SimpleObjectProperty[Double](this, "jfx", 224.7)

    jfxProperty <==> sfxProperty
    sfxProperty() = 17.8
    assert(17.8 === sfxProperty())
    assert(17.8 === jfxProperty())

    jfxProperty() = 21.1
    assert(21.1 === sfxProperty())
    assert(21.1 === jfxProperty())
  }

  // Testing fillProperty method from companion.

  private def evaluateFillProperty[T <: Object](property: ObjectProperty[T], newValue: T): Unit = {
    val originalValue: T = property.value
    var oldVal: T        = null.asInstanceOf[T]
    var newVal: T        = null.asInstanceOf[T]
    property.delegate.addListener(new jfxbv.ChangeListener[T] {
      def changed(obs: jfxbv.ObservableValue[_ <: T], oldV: T, newV: T): Unit = {
        oldVal = oldV
        newVal = newV
      }
    })

    ObjectProperty.fillProperty(property, newValue)

    property.value should be(newValue)
    newVal should be(newValue)
    oldVal should be(originalValue)
  }

  "fillProperty" should "fill property with null if receives null" in {
    evaluateFillProperty(ObjectProperty[ju.Date](new ju.Date), null)
  }

  "fillProperty" should "fill property with not null value if receives a not null" in {
    evaluateFillProperty(ObjectProperty[ju.Date](new ju.Date), new ju.Date(123456L))
  }

  "fillProperty" should "supports variance" in {
    evaluateFillProperty(ObjectProperty[ju.Date](new ju.Date), new java.sql.Date(1234678L))
  }

  "fillProperty" should "supports covariance" in {
    evaluateFillProperty(ObjectProperty[ju.Date](new java.sql.Date(1234678L)), new ju.Date)
  }
}
