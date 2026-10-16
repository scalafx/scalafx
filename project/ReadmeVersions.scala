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

import scala.util.matching.Regex

/** Updates ScalaFX, JavaFX, and JDK version numbers shown in README.md, used by the release process. */
object ReadmeVersions {

  private val CurrentVersion = """%% "scalafx" % "(\d+\.\d+\.\d+-R\d+)"""".r

  private val Requirement =
    """ScalaFX \d+ requires __JDK \d+ or newer__ \(a \[JavaFX \d+ requirement\]\(https://openjfx\.io/highlights/\d+/\)\)""".r

  /**
   * Replaces the ScalaFX version currently shown in README with `newVersion`,
   * and sets JavaFX and minimum JDK versions given in the release notes.
   *
   * Prose is left unchanged, except for the Quick Start JDK requirement. Updated are:
   *  - the ScalaFX version in code snippets (fenced code blocks),
   *  - JavaFX and JDK versions in the Mill and Gradle snippets,
   *  - the Quick Start JDK requirement,
   *  - the compatibility table, it keeps one row per JavaFX major version.
   *    The row of the current version is replaced if `newVersion` has the same JavaFX major version,
   *    otherwise a new row is added above it.
   *
   * @return updated text and the version that was replaced.
   */
  def update(text: String, newVersion: String, notes: ReleaseNotes.Info): (String, String) = {
    val current = CurrentVersion.findFirstMatchIn(text).map(_.group(1))
      .getOrElse(sys.error("Cannot find the current ScalaFX version in README.md"))
    val sameMajor   = ReleaseVersions.javaFxMajor(current) == ReleaseVersions.javaFxMajor(newVersion)
    var inCodeBlock = false
    var tableRow    = false
    val updated     = text.split("\n", -1).toSeq.flatMap { line =>
      if (line.trim.startsWith("```")) {
        inCodeBlock = !inCodeBlock
        Seq(line)
      } else if (inCodeBlock) Seq(updateSnippet(line.replace(current, newVersion), notes))
      else if (line.startsWith(s"| `$current`")) {
        tableRow = true
        val row = updateTableRow(line, newVersion, notes)
        if (sameMajor) Seq(row) else Seq(row, line)
      } else Seq(
        Requirement.replaceAllIn(
          line,
          Regex.quoteReplacement(
            s"ScalaFX ${notes.javaFx} requires __JDK ${notes.minJdk} or newer__ " +
              s"(a [JavaFX ${notes.javaFx} requirement](https://openjfx.io/highlights/${notes.javaFx}/))"
          )
        )
      )
    }.mkString("\n")
    if (!tableRow) sys.error(s"Cannot find the compatibility table row for ScalaFX $current in README.md")
    (updated, current)
  }

  // JavaFX and JDK versions in Mill and Gradle snippets, the first group is the text before the version number
  private def updateSnippet(line: String, notes: ReleaseNotes.Info): String = Seq(
    """(def jvmId = "[^:"]+:)\d+""".r                 -> notes.minJdk,
    """(JavaFX )\d+(?= requires JDK version >= )""".r -> notes.javaFx,
    """(JDK version >= )\d+""".r                      -> notes.minJdk,
    """(val javaFxVersion = ")\d+""".r                -> notes.javaFx,
    """^(\s+version = ")\d+(?="$)""".r                -> notes.javaFx
  ).foldLeft(line) { case (l, (regex, value)) =>
    regex.replaceAllIn(l, m => Regex.quoteReplacement(m.group(1) + value))
  }

  // Keeps column widths and the Scala column
  private def updateTableRow(row: String, newVersion: String, notes: ReleaseNotes.Info): String = {
    val cells  = row.split("\\|", -1)
    val values = Seq(s"`$newVersion`", notes.javaFx, notes.minJdk)
    values.zipWithIndex.foreach { case (value, i) => cells(i + 1) = s" $value ".padTo(cells(i + 1).length, ' ') }
    cells.mkString("|")
  }
}
