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

import sbt.*
import sbtrelease.ReleasePlugin.autoImport.*

/** Release steps for release notes and README.md, and helpers shared by release steps. */
object ReleaseSteps {

  /** Checks that release notes, `notes/<version>.md`, are written and state JavaFX and minimum Java versions. */
  val checkReleaseNotes: ReleaseStep = ReleaseStep { st =>
    val notes = logErrors(st)(ReleaseNotes.read(baseDir(st), versions(st)._1))
    st.log.info(s"Release notes: JavaFX ${notes.javaFx}, minimum JDK ${notes.minJdk}")
    st
  }

  /** Updates ScalaFX, JavaFX, and JDK versions in README.md, the change is committed manually. */
  val updateReadme: ReleaseStep = ReleaseStep { st =>
    val releaseVersion = versions(st)._1
    val readme         = baseDir(st) / "README.md"
    logErrors(st) {
      val notes               = ReleaseNotes.read(baseDir(st), releaseVersion)
      val (updated, previous) = ReadmeVersions.update(IO.read(readme), releaseVersion, notes)
      IO.write(readme, updated)
      st.log.info(
        s"README.md: ScalaFX $previous -> $releaseVersion, JavaFX ${notes.javaFx}, minimum JDK ${notes.minJdk}"
      )
    }
    st
  }

  /** Release and next versions, set by `inquireVersions`. */
  def versions(st: State): (String, String) =
    st.get(ReleaseKeys.versions).getOrElse(fail(st, "Release versions are not set"))

  def baseDir(st: State): File = Project.extract(st).get(LocalRootProject / Keys.baseDirectory)

  /** Logs the message before failing, sbt client does not show messages of exceptions thrown by commands. */
  def fail(st: State, message: String): Nothing = {
    st.log.error(message)
    sys.error(message)
  }

  private def logErrors[T](st: State)(body: => T): T =
    try body
    catch { case e: RuntimeException => fail(st, e.getMessage) }
}
