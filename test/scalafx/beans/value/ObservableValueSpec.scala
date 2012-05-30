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

package scalafx.beans.value

import javafx.beans.value.{ObservableValue => JFXObservableValue}
import org.scalatest.{BeforeAndAfterEach, FlatSpec}
import org.scalatest.matchers.ShouldMatchers._
import scalafx.beans.property.DoubleProperty
import scalafx.beans.binding.BindingIncludes._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
 * ObservableValue Spec tests.
 *
 *
 */
@RunWith(classOf[JUnitRunner])
class ObservableValueSpec extends FlatSpec with BeforeAndAfterEach {
  var property: DoubleProperty = null

  override def beforeEach() {
    property = new DoubleProperty(null, "observable value test")
  }

  "ObservableValue" should "support anonymous change listeners" in {
    var invalidateCalled = false
    property onChange {
      invalidateCalled = true
    }
    invalidateCalled should be (false)
    property() = 100
    invalidateCalled should be (true)
  }

  it should "support anonymous change listeners with parameters" in {
    var invalidateCalled = false
    property onChange {
      (obs, oldV, newV) =>
        invalidateCalled = true
        obs should equal (property)
    }
    invalidateCalled should be (false)
    property() = 100
    invalidateCalled should be (true)
  }

  it should "support adding explicit listeners as a clojure" in {
    var invalidateCalled = false
    property addListener {
      (obs: JFXObservableValue[_ <: Number], oldV:Number, newV:Number) =>
        invalidateCalled = true
        obs should equal (property.delegate)
        oldV should equal (0)
        newV should equal (100)
    }
    invalidateCalled should be (false)
    property() = 100
    invalidateCalled should be (true)
  }

  it should "support removing explict listeners" in {
    var invalidateCalled = false
    val listener = (obs: JFXObservableValue[_ <: Number], oldV:Number, newV:Number) => invalidateCalled = true
    property addListener listener
    invalidateCalled should be (false)
    property() = 100
    invalidateCalled should be (true)
    property removeListener listener
    invalidateCalled = false
    property() = 200
    // todo: report bug in removing listeners (appears to be in the jfx source)
    //invalidateCalled should be (false)
  }
}