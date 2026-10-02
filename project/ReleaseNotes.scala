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

import java.io.File
import java.nio.charset.StandardCharsets.UTF_8
import java.nio.file.Files
import scala.util.matching.Regex

/**
 * Reads release notes, `notes/<version>.md`, used by the release process.
 *
 * Release notes are written manually before the release.
 * Their opening paragraphs state the supported JavaFX version and the minimum Java version, for instance:
 * {{{
 * This release supports [JavaFX 27]. ...
 * Note that [JavaFX 27 requires Java **25 or later**][JavaFX 27]. ...
 * }}}
 */
object ReleaseNotes {

  /** JavaFX major version and the minimum Java version it requires. */
  final case class Info(javaFx: String, minJdk: String)

  private val JavaFx = """This release supports \[JavaFX (\d+)\]""".r
  private val MinJdk = """\[JavaFX (\d+) requires Java \*\*(\d+) or (?:later|newer)\*\*\]""".r

  /** Reads and parses `notes/<version>.md` in `baseDir`. */
  def read(baseDir: File, version: String): Info = {
    val file = new File(new File(baseDir, "notes"), s"$version.md")
    if (!file.exists) sys.error(s"Release notes $file are missing, write and commit them before the release")
    parse(new String(Files.readAllBytes(file.toPath), UTF_8), version)
  }

  /**
   * Extracts JavaFX and minimum Java versions from release notes of ScalaFX `version`.
   * Fails if they are missing or the JavaFX version does not match the JavaFX major version of `version`.
   */
  def parse(text: String, version: String): Info = {
    def find(regex: Regex, expected: String): Regex.Match = regex.findFirstMatchIn(text)
      .getOrElse(sys.error(s"Release notes for $version do not state '$expected'"))
    val javaFx   = find(JavaFx, "This release supports [JavaFX N]").group(1)
    val minJdk   = find(MinJdk, "[JavaFX N requires Java **M or later**]")
    val expected = ReleaseVersions.javaFxMajor(version)
    if (javaFx != expected || minJdk.group(1) != expected)
      sys.error(
        s"Release notes for $version refer to JavaFX $javaFx and ${minJdk.group(1)}, expecting JavaFX $expected"
      )
    Info(javaFx, minJdk.group(2))
  }
}
