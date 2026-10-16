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

class ReadmeVersionsTest extends AnyFlatSpec with Matchers {

  private val prose = "For instance, version `27.0.0-R39` means that it was tested with JavaFX"

  private val requirement =
    "ScalaFX 27 requires __JDK 25 or newer__ (a [JavaFX 27 requirement](https://openjfx.io/highlights/27/))."

  private val readme =
    s"""```scala
      |libraryDependencies += "org.scalafx" %% "scalafx" % "27.0.0-R39"
      |```
      |$requirement
      |```scala
      |//> using dep org.scalafx::scalafx:27.0.0-R39
      |  def jvmId = "temurin:25" // JavaFX 27 requires JDK version >= 25
      |  val javaFxVersion = "27"
      |  val scalaFxVersion = "27.0.0-R39"
      |```
      |```groovy
      |    id 'org.openjfx.javafxplugin' version '0.1.0'
      |    version = "27"
      |    implementation 'org.scalafx:scalafx_3:27.0.0-R39'
      |```
      || ScalaFX                   | JavaFX  | Minimum JDK | Scala               |
      ||---------------------------|---------|-------------|---------------------|
      || `27.0.0-R39`              | 27      | 25          | 3.3+, 2.13, 2.12    |
      || `26.0.0-R38`              | 26      | 24          | 3.3+, 2.13, 2.12    |
      |
      |$prose
      |""".stripMargin

  private val javaFx27 = ReleaseNotes.Info("27", "25")
  private val javaFx28 = ReleaseNotes.Info("28", "26")

  "update" should "replace version in snippets and table for the same JavaFX major" in {
    val (updated, previous) = ReadmeVersions.update(readme, "27.0.1-R40", javaFx27)
    previous shouldBe "27.0.0-R39"
    updated shouldBe readme.replace("27.0.0-R39", "27.0.1-R40").replace(
      prose.replace("27.0.0-R39", "27.0.1-R40"),
      prose
    )
  }

  it should "not change prose outside of code blocks and the table" in {
    val (updated, _) = ReadmeVersions.update(readme, "27.0.1-R40", javaFx27)
    updated should include(prose)
  }

  it should "add a compatibility table row for a new JavaFX major" in {
    val (updated, _) = ReadmeVersions.update(readme, "28.0.0-R40", javaFx28)
    updated should include(
      """|| `28.0.0-R40`              | 28      | 26          | 3.3+, 2.13, 2.12    |
         || `27.0.0-R39`              | 27      | 25          | 3.3+, 2.13, 2.12    |
         || `26.0.0-R38`              | 26      | 24          | 3.3+, 2.13, 2.12    |""".stripMargin
    )
  }

  it should "update JavaFX and JDK versions for a new JavaFX major" in {
    val (updated, _) = ReadmeVersions.update(readme, "28.0.0-R40", javaFx28)
    updated should include(
      "ScalaFX 28 requires __JDK 26 or newer__ (a [JavaFX 28 requirement](https://openjfx.io/highlights/28/))."
    )
    updated should include("""def jvmId = "temurin:26" // JavaFX 28 requires JDK version >= 26""")
    updated should include("""val javaFxVersion = "28"""")
    updated should include("""    version = "28"""")
    updated should include("javafxplugin' version '0.1.0'")
    updated should include("org.scalafx::scalafx:28.0.0-R40")
    updated should include("scalafx_3:28.0.0-R40'")
    updated should include(prose)
  }

  it should "preserve other text exactly" in {
    val (updated, _) = ReadmeVersions.update(readme, "27.0.0-R39", javaFx27)
    updated shouldBe readme
  }

  it should "fail if the current version cannot be found" in {
    an[RuntimeException] should be thrownBy ReadmeVersions.update("No versions here\n", "27.0.0-R40", javaFx27)
  }

  it should "fail if the compatibility table row cannot be found" in {
    an[RuntimeException] should be thrownBy ReadmeVersions.update(
      readme.replace("| `27.0.0-R39`  ", "| `27.0.0-R38`  "),
      "27.0.1-R40",
      javaFx27
    )
  }

  "the actual README.md" should "be updated for a new JavaFX major" in {
    val text         = scala.io.Source.fromFile(TestFiles("README.md"), "UTF-8").mkString
    val (updated, _) = ReadmeVersions.update(text, "28.0.0-R40", javaFx28)
    updated should include("ScalaFX 28 requires __JDK 26 or newer__")
    updated should include("""def jvmId = "temurin:26"""")
    updated should include("""val javaFxVersion = "28"""")
    updated should include("""    version = "28"""")
    updated should include("| `28.0.0-R40`              | 28      | 26          |")
  }
}
