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

/**
 * ScalaFX version numbering used by the release process.
 *
 * The release version drops the `-SNAPSHOT` suffix and keeps the release number,
 * the next development version increments the release number:
 * `27.0.0-R39-SNAPSHOT` -> release `27.0.0-R39` -> next `27.0.0-R40-SNAPSHOT`.
 */
object ReleaseVersions {

  private val Release = """(\d+\.\d+\.\d+)-R(\d+)""".r

  /** JavaFX major version a ScalaFX version was tested with, `27` for `27.0.0-R39`. */
  def javaFxMajor(version: String): String = version.takeWhile(_ != '.')

  def releaseVersion(snapshotVersion: String): String = {
    val version = snapshotVersion.stripSuffix("-SNAPSHOT")
    require(Release.matches(version), s"Unexpected ScalaFX version '$snapshotVersion', expecting 'X.Y.Z-RN-SNAPSHOT'")
    version
  }

  def nextVersion(releaseVersion: String): String = releaseVersion match {
    case Release(javaFxVersion, releaseNumber) => s"$javaFxVersion-R${releaseNumber.toInt + 1}-SNAPSHOT"
    case _                                     => throw new IllegalArgumentException(
        s"Unexpected ScalaFX release version '$releaseVersion', expecting 'X.Y.Z-RN'"
      )
  }
}
