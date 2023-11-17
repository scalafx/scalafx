/*
 * Copyright (c) 2011-2023, ScalaFX Project
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

import javafx.beans.value.{ChangeListener, ObservableValue as JFXObservableValue}
import org.scalatest.BeforeAndAfterEach
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.*
import scalafx.Includes.*
import scalafx.beans.property.IntegerProperty
import scalafx.util.Subscription

/**
 * ObservableValue Spec tests.
 */
class ObservableValueSpec extends AnyFlatSpec with BeforeAndAfterEach {
  var property: IntegerProperty = null

  override def beforeEach(): Unit = {
    property = new IntegerProperty(null, "observable value test")
    property = IntegerProperty(0)
  }

  "ObservableValue" should "support anonymous change listeners" in {
    var invalidateCalled = false
    property onChange {
      invalidateCalled = true
    }
    invalidateCalled should be(false)
    property() = 100
    invalidateCalled should be(true)
  }

  it should "support anonymous change listeners with parameters" in {
    var invalidateCalled = false
    property onChange {
      (obs, oldV, newV) =>
        invalidateCalled = true
        obs should equal(property)
    }
    invalidateCalled should be(false)
    property() = 100
    invalidateCalled should be(true)
  }

  it should "support adding explicit listeners as a clojure" in {
    var invalidateCalled = false
    property.addListener {
      (obs, oldV, newV) =>
        invalidateCalled = true
        obs should equal(property.delegate)
        oldV should equal(0)
        newV should equal(100)
    }
    invalidateCalled should be(false)
    property() = 100
    invalidateCalled should be(true)
  }

  it should "support removing explicit listeners" in {
    var invalidateCalled = false
    // We are forcing implicit conversion of a Function3 to ChangeListener[Number],
    // so we have a handle to actual listener object.
    // Without it we will not be able to remove the listener, since will not have proper handle
    // (a ChangeListener wrapper would be created while adding listener by implicit conversion ).
    // A recommended way to add/remove listeners created from a closure is to use Subscription:
    // val subscription = property.onChange ...
    // ...
    // subscription.cancel()
    val listener: ChangeListener[Number] =
      (obs: JFXObservableValue[_ <: Number], oldV: Number, newV: Number) => invalidateCalled = true
    property addListener listener
    invalidateCalled should be(false)
    property() = 100
    invalidateCalled should be(true)
    property removeListener listener
    invalidateCalled = false
    property() = 200
    invalidateCalled should be(false)
  }

  it should "support subscribe 1 argument" in {
    property() = 310
    var updated = 0

    // Subscribe to property changes
    val s: Subscription = property.subscribe { (x) =>
      println(x)
      updated = x.intValue()
    }
    // Listener is called during call to `subscribe` so we get current value of the property
    updated should be(310)

    property() = 311
    // We should see new updated value
    updated should be(311)

    // Cancel subscription
    s.unsubscribe()

    property() = 312
    // No updates should be posted since we unsubscribed
    updated should be(311)
  }

  it should "support subscribe 2 arguments" in {
    property() = 310
    var updatedOld = 0
    var updatedNew = 0
    val s: Subscription = property.subscribe { (x, y) =>
      updatedOld = x.intValue()
      updatedNew = y.intValue()
    }
    // Listener is NOT called during call to `subscribe`, unlike the 1 argument version
    updatedOld should be(0)
    updatedNew should be(0)

    property() = 311
    updatedOld should be(310)
    updatedNew should be(311)

    s.unsubscribe()

    property() = 312
    updatedOld should be(310)
    updatedNew should be(311)
  }
}
