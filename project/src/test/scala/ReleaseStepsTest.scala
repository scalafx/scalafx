/*
 * Copyright (c) 2011-2026, ScalaFX Project
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
import org.scalatest.matchers.should.Matchers

class ReleaseStepsTest extends AnyFlatSpec with Matchers {

  // Steps 0-9 before upload, 10 uploads to Central, 11-12 after
  private def summary(index: Int) = ReleaseSteps.FailureSummary(s"step ${index + 1}/13, name", index, uploadIndex = 10)

  "FailureSummary" should "name the release, the step, and the reason" in {
    val lines = summary(7).lines(Some("27.0.0-R39"), isCheck = false, Some("tests failed"), versionSet = false)
    lines.head shouldBe "RELEASE 27.0.0-R39 FAILED at step 8/13, name"
    lines(1) shouldBe "  Reason: tests failed"
  }

  it should "refer to messages above when there is no reason" in {
    summary(7).lines(None, isCheck = false, None, versionSet = false)(1) should include("see the error messages above")
  }

  it should "say that nothing was changed when a check fails" in {
    val lines = summary(0).lines(None, isCheck = true, Some("dirty"), versionSet = false)
    lines.head should endWith("(check)")
    lines.mkString should include("Nothing was changed")
  }

  it should "ask to revert version.sbt when it was set" in {
    val text = summary(9).lines(Some("27.0.0-R39"), isCheck = false, None, versionSet = true).mkString("\n")
    text should include("git checkout -- version.sbt")
    text should include("Nothing was uploaded")
    text should include("run the release again")
  }

  it should "point to Central deployments when the upload fails" in {
    val text = summary(10).lines(Some("27.0.0-R39"), isCheck = false, None, versionSet = true).mkString("\n")
    text should include("sonaDrop")
    text should include("git checkout -- version.sbt")
    text should not include ("Nothing was uploaded")
  }

  it should "warn that the release is published when a step after the upload fails" in {
    val text = summary(11).lines(Some("27.0.0-R39"), isCheck = false, None, versionSet = true).mkString("\n")
    text should include("IS PUBLISHED")
    text should include("do not run the release again")
    text should not include ("git checkout")
  }
}
