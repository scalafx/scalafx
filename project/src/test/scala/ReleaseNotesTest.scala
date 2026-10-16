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

class ReleaseNotesTest extends AnyFlatSpec with Matchers {

  private val notes =
    """This release supports [JavaFX 27]. It was tested with Java 25, 26, and 27.
      |
      |Note that [JavaFX 27 requires Java **25 or later**][JavaFX 27]. If you need to run on Java earlier than 25...
      |""".stripMargin

  "parse" should "read JavaFX and minimum Java versions" in {
    ReleaseNotes.parse(notes, "27.0.0-R39") shouldBe ReleaseNotes.Info("27", "25")
  }

  it should "accept 'or newer'" in {
    ReleaseNotes.parse(notes.replace("or later", "or newer"), "27.0.0-R39") shouldBe ReleaseNotes.Info("27", "25")
  }

  it should "fail if JavaFX version is not stated" in {
    an[RuntimeException] should be thrownBy
      ReleaseNotes.parse(notes.replace("This release supports", "Supports"), "27.0.0-R39")
  }

  it should "fail if minimum Java version is not stated" in {
    an[RuntimeException] should be thrownBy ReleaseNotes.parse(notes.replace("**25 or later**", "25"), "27.0.0-R39")
  }

  it should "fail if JavaFX version does not match the release version" in {
    an[RuntimeException] should be thrownBy ReleaseNotes.parse(notes, "28.0.0-R40")
  }

  "read" should "read notes of the current version" in {
    ReleaseNotes.read(TestFiles("notes").getAbsoluteFile.getParentFile, "27.0.0-R39") shouldBe
      ReleaseNotes.Info("27", "25")
  }

  it should "fail if notes are missing" in {
    an[RuntimeException] should be thrownBy
      ReleaseNotes.read(TestFiles("notes").getAbsoluteFile.getParentFile, "99.0.0-R99")
  }
}
