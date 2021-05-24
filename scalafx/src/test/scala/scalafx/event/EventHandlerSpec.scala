/*
 * Copyright (c) 2011-2020, ScalaFX Project
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

import org.scalatest.flatspec.AnyFlatSpec
import scalafx.Includes._
import scalafx.event.{ActionEvent, Event}
import scalafx.scene.Group
import scalafx.scene.control.Button
import scalafx.testutil.RunOnApplicationThread

class EventHandlerSpec extends AnyFlatSpec with RunOnApplicationThread {

  "`handleEvent`" should "create subscription and cancel for Event Handlers" in {

    val group = new Group()

    var counter = 0
    val subscription = group.handleEvent(Event.ANY) { () =>
      // Counter is incremented twice to make sure that both instructions are executed, similar to Issue 102
      counter += 1
      counter += 1
    }

    assert(counter === 0)

    val actionEvent = new ActionEvent(this, group)

    group.fireEvent(actionEvent)
    assert(counter === 2)

    group.fireEvent(actionEvent)
    assert(counter === 4)

    subscription.cancel()
    group.fireEvent(actionEvent)
    assert(counter === 4)
  }

  "`filterEvent`" should "create subscription and cancel for Event Filters" in {

    val button = new Button()
    val group = new Group {
      children = button
    }

    var groupCounter = 0
    val groupSubscription = group.filterEvent(ActionEvent.Action) { () =>
      // Counter is incremented twice to make sure that both instructions are executed, similar to Issue 102
      groupCounter += 1
      groupCounter += 1
    }
    var buttonCounter = 0
    button.handleEvent(ActionEvent.Action) { () =>
      // Counter is incremented twice to make sure that both instructions are executed, similar to Issue 102
      buttonCounter += 3
      buttonCounter += 3
    }

    assert(groupCounter === 0)
    assert(buttonCounter === 0)

    val actionEvent = new ActionEvent(this, button)

    button.fireEvent(actionEvent)
    assert(groupCounter === 2)
    assert(buttonCounter === 6)

    button.fireEvent(actionEvent)
    assert(groupCounter === 4)
    assert(buttonCounter === 12)

    groupSubscription.cancel()
    button.fireEvent(actionEvent)
    assert(groupCounter === 4)
    assert(buttonCounter === 18)
  }

  "`filterEvent`" should "not consume events when not cancelled/active" in {

    val button = new Button()
    val group = new Group {
      children = button
    }

    var groupCounter  = 0
    var buttonCounter = 0
    button.handleEvent(ActionEvent.Action) { () =>
      // Counter is incremented twice to make sure that both instructions are executed, similar to Issue 102
      buttonCounter += 3
      buttonCounter += 3
    }

    assert(groupCounter === 0)
    assert(buttonCounter === 0)

    val actionEvent = new ActionEvent(this, button)

    button.fireEvent(actionEvent)
    assert(groupCounter === 0)
    assert(buttonCounter === 6)

    val groupSubscription = group.filterEvent(ActionEvent.Action) { (ae: ActionEvent) =>
      // Counter is incremented twice to make sure that both instructions are executed, similar to Issue 102
      groupCounter += 1
      groupCounter += 1
      ae.consume()
    }

    button.fireEvent(actionEvent)
    assert(groupCounter === 2)
    assert(buttonCounter === 6)

    button.fireEvent(actionEvent)
    assert(groupCounter === 4)
    assert(buttonCounter === 6)

    // After event filter is cancelled, event should be sent to the button
    groupSubscription.cancel()
    button.fireEvent(actionEvent)
    assert(groupCounter === 4)
    assert(buttonCounter === 12)
  }
}
