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

import scala.util.control.NonFatal

/** Release steps for release notes and README.md, and helpers shared by release steps. */
object ReleaseSteps {

  /** Name of the release step that uploads to Central, the release is published when it completes. */
  val UploadToCentral = "upload to Central (sonaRelease)"

  /**
   * Release process steps with names. When a step fails, a summary is logged:
   * which step failed, why, and what has to be done before the release is run again.
   *
   * When a command step fails, sbt-release skips the remaining steps without a message,
   * so the original error message is easy to miss in the output.
   */
  def reportingFailures(steps: (String, ReleaseStep)*): Seq[ReleaseStep] = {
    val uploadIndex = steps.indexWhere(_._1 == UploadToCentral)
    require(uploadIndex >= 0, s"Release process has to contain step '$UploadToCentral'")
    steps.zipWithIndex.map { case ((name, step), index) =>
      val failure = FailureSummary(s"step ${index + 1}/${steps.size}, $name", index, uploadIndex)
      def reporting(f: State => State, isCheck: Boolean)(st: State): State = {
        val result =
          try f(st)
          catch {
            case NonFatal(e) =>
              failure.report(st, isCheck, Option(e.getMessage))
              throw e
          }
        // A failed command leaves `--failure--` as the next command, sbt-release then skips the remaining steps
        if (result.remainingCommands.headOption.exists(_.commandLine == "--failure--"))
          failure.report(st, isCheck, None)
        result
      }
      step.copy(check = reporting(step.check, isCheck = true), action = reporting(step.action, isCheck = false))
    }
  }

  /** Summary of a failed release step, `index` and `uploadIndex` are positions in the release process. */
  final case class FailureSummary(title: String, index: Int, uploadIndex: Int) {

    def report(st: State, isCheck: Boolean, message: Option[String]): Unit = {
      val release     = st.get(ReleaseKeys.versions).map(_._1)
      val versionFile = baseDir(st) / "version.sbt"
      val versionSet  = release.exists(v => versionFile.exists && IO.read(versionFile).contains(s"\"$v\""))
      lines(release, isCheck, message, versionSet).foreach(st.log.error(_))
    }

    /** @param versionSet `true` if the release version is written to `version.sbt` */
    def lines(release: Option[String], isCheck: Boolean, message: Option[String], versionSet: Boolean): Seq[String] = {
      val hints =
        if (isCheck) Seq("Nothing was changed. Fix the problem and run the release again.")
        else if (index > uploadIndex) Seq(
          "The release IS PUBLISHED to Maven Central, do not run the release again.",
          "Complete the remaining steps manually, see \"Releasing (Maintainers)\" in CONTRIBUTING.md."
        )
        else {
          val upload =
            if (index == uploadIndex) Seq(
              "Artifacts may be uploaded, check https://central.sonatype.com/publishing/deployments",
              "and drop a deployment that failed or was not published: sbt \"sonaDrop <deploymentId>\""
            )
            else Seq("Nothing was uploaded to Central.")
          val version =
            if (versionSet) Seq("version.sbt is set to the release version, revert it: git checkout -- version.sbt")
            else Nil
          upload ++ version :+ "Fix the problem and run the release again."
        }
      Seq(
        s"RELEASE ${release.fold("")(_ + " ")}FAILED at $title${if (isCheck) " (check)" else ""}",
        s"  Reason: ${message.getOrElse("see the error messages above")}"
      ) ++ hints.map("  " + _)
    }
  }

  /** Checks that Central Portal credentials are set, the check is executed at the start of the release. */
  val checkCentralCredentials: ReleaseStep = ReleaseStep(
    action = identity,
    check = { st =>
      val (newState, found) = SonaDrop.credentials(st)
      if (found.isEmpty) fail(newState, s"No credentials are found for ${SonaDrop.host}, ${SonaDrop.credentialsHelp}")
      newState.log.info(s"Credentials for ${SonaDrop.host} are set")
      newState
    }
  )

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
