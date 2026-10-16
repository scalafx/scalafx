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
import ReleaseSteps.{baseDir, fail, versions}

import scala.sys.process.*

/**
 * Release steps for ScalaFX branches.
 *
 * Releases are made from the `stable` branch, after `master` is merged into it.
 * After the release, `stable` is merged back into `master`, and the next development version is set on `master`.
 *
 * For now, the release does not commit, tag, merge, or push, those steps are printed at the end of the release,
 * to be done manually. When automating them, note that sbt-release `Vcs` caches the tracking branch
 * of the branch that was current when the release started, its `pushChanges` cannot be used after switching branches.
 */
object ReleaseGit {

  val releaseBranch     = "stable"
  val developmentBranch = "master"

  /**
   * Checks the working tree and branches before anything else is done, the check is executed at the start of the release.
   * The working tree has to be clean, without modified, staged, or untracked files, files ignored by git are fine.
   * The sbt-release clean working tree check is a part of `commitReleaseVersion`, which is not used here.
   */
  val checkGit: ReleaseStep = ReleaseStep(
    action = identity,
    check = { st =>
      val changes = git(st, "status", "--porcelain").trim
      if (changes.nonEmpty)
        fail(st, s"The working tree is not clean, commit or remove the changes first:\n$changes")
      val current = git(st, "symbolic-ref", "--short", "HEAD").trim
      if (current != releaseBranch)
        fail(st, s"Releases are made from the '$releaseBranch' branch, current branch is '$current'.")
      Seq(releaseBranch, developmentBranch).foreach { branch =>
        val remote = upstreamRemote(st, branch)
        git(st, "fetch", remote)
        val behind = git(st, "rev-list", s"$branch..$remote/$branch").trim
        if (behind.nonEmpty)
          fail(st, s"Local '$branch' is behind '$remote/$branch', update it first.")
      }
      if (exitCode(st, "merge-base", "--is-ancestor", developmentBranch, "HEAD") != 0)
        fail(st, s"'$developmentBranch' is not merged into '$releaseBranch', merge it first.")
      st
    }
  )

  /** Prints git commands that complete the release, they are executed manually. */
  val printManualSteps: ReleaseStep = ReleaseStep { (st: State) =>
    val (releaseVersion, nextVersion) = versions(st)
    val (newState, tag)               = Project.extract(st).runTask(releaseTagName, st)
    val releaseRemote                 = upstreamRemote(st, releaseBranch)
    val devRemote                     = upstreamRemote(st, developmentBranch)
    val steps                         =
      s"""Release $releaseVersion is published. Complete the release manually:
         |
         |  # Commit and tag the release on '$releaseBranch'
         |  git commit -am "Mark release version $releaseVersion"
         |  git tag -a $tag -m "Releasing $releaseVersion"
         |  git push $releaseRemote $releaseBranch $tag  # the tag push creates the GitHub release
         |
         |  # Merge '$releaseBranch' into '$developmentBranch' and set the next development version
         |  git checkout $developmentBranch
         |  git merge --no-ff --no-edit $releaseBranch
         |  printf 'ThisBuild / version := "%s"\\n' $nextVersion > version.sbt
         |  git commit -am "Mark the next development release $nextVersion"
         |  git push $devRemote $developmentBranch
         |""".stripMargin
    newState.log.info(steps)
    newState
  }

  private def upstreamRemote(st: State, branch: String): String = {
    val (exitCode, out, _) = run(st, "config", s"branch.$branch.remote")
    if (exitCode != 0) fail(st, s"Branch '$branch' has no upstream remote configured.")
    out.trim
  }

  /** Runs git command, output is logged through sbt, so it is visible in sbt client. */
  private def git(st: State, args: String*): String = {
    val (exitCode, out, err) = run(st, args*)
    if (exitCode != 0) fail(st, s"git ${args.mkString(" ")} failed:\n${(out + err).trim}")
    if (err.trim.nonEmpty) st.log.info(err.trim)
    out
  }

  private def exitCode(st: State, args: String*): Int = run(st, args*)._1

  private def run(st: State, args: String*): (Int, String, String) = {
    st.log.debug(s"git ${args.mkString(" ")}")
    val out      = new StringBuilder
    val err      = new StringBuilder
    val exitCode = Process("git" +: args, baseDir(st)).!(ProcessLogger(
      line => out.append(line).append('\n'),
      line => err.append(line).append('\n')
    ))
    (exitCode, out.toString, err.toString)
  }
}
