/*
 * Copyright (c) 2011-2013, ScalaFX Project
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
package issues.issue070

import javafx.{concurrent => jfxc}
import org.junit.runner.RunWith
import org.scalatest.{Ignore, FlatSpec}
import org.scalatest.junit.JUnitRunner
import scalafx.concurrent.Task
import scalafx.testutil.RunOnApplicationThread

/** Verify that code causing Issue 70 behaves correctly after fix. */
@RunWith(classOf[JUnitRunner])
@Ignore
class Issue070Spec extends FlatSpec with RunOnApplicationThread {

  ignore  should "Issue 70 - code using handleEvent() should compile" in {

    val expectedResult = "Hello"

    // Setup a simple task that returns a string
    val task = Task[String] {expectedResult}

    // Add simple event handler that ignores event value
    // Issue 70 prevent following code from compiling with "error: ambiguous reference to overloaded definition"
    // Uncomment following line after the fix
//    task.handleEvent(jfxc.WorkerStateEvent.ANY) {println("Some event happened")}

    // Add simple event handler that accesses event value
    // Issue 70 prevent following code from compiling with "error: ambiguous reference to overloaded definition"
    // Uncomment following line after the fix
//    task.handleEvent(jfxc.WorkerStateEvent.ANY) {(e: jfxc.WorkerStateEvent) => println(e.getEventType.toString)}

    task.run()
    val actualResult = task.get()

    assert(actualResult === expectedResult)
  }

}
