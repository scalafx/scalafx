/*
 * Copyright (c) 2011-2025, ScalaFX Project
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
package scalafx.testutil

import javafx.application.Platform
import org.scalatest.{Outcome, TestSuite, TestSuiteMixin}

import java.util.concurrent.CountDownLatch

trait RunOnApplicationThread extends TestSuiteMixin with TestSuite {
  // "with TestSuite" added above to avoid compilation error introduced in Scala 2.13 with ScalaTest 3.0.8
  //    Error:(39, 7) illegal trait super target found for method withFixture required by trait RunOnApplicationThread;
  //      found   : protected def withFixture: ((test: _1.NoArgTest)org.scalatest.Outcome) forSome { val _1: [T]scalafx.scene.chart.AxisSpec[T] } in trait TestSuite;
  //      expected: protected def withFixture: ((test: _1.NoArgTest)org.scalatest.Outcome) forSome { val _1: [T]scalafx.scene.chart.AxisSpec[T] } in trait TestSuiteMixin
  //    class AxisSpec[T]
  this: TestSuite =>
  abstract override def withFixture(test: NoArgTest): Outcome = {
    BootstrapApplication.launch()
    val appThreadLatch = new CountDownLatch(1)
    val superWith =
      super.withFixture _ // required to access to super withFixture method from within runnable for a trait
    var testException: Exception = null
    var outcome: Outcome         = null
    Platform.runLater(new Runnable() {
      override def run(): Unit = {
        try {
          outcome = superWith(test)
        } catch {
          case e: Exception => testException = e
        } finally {
          appThreadLatch.countDown()
        }
      }
    })
    appThreadLatch.await()
    if (testException != null) {
      throw testException
    }
    outcome
  }
}
