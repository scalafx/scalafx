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

//
// Environment variables used by the build:
// GRAPHVIZ_DOT_PATH - Full path to Graphviz dot utility. If not defined, Scaladocs will be built without diagrams.
// JAR_BUILT_BY      - Name to be added to the Jar metadata field "Built-By" (defaults to System.getProperty("user.name")
//

val javaFXVersion  = "26"
val scalafxVersion = "26.0.0-R39-SNAPSHOT"

val versionTagDir = if (scalafxVersion.endsWith("SNAPSHOT")) "master" else s"v.$scalafxVersion"

// Common settings, SBT 2 applies bare settings in build.sbt to all subprojects
scalafxSettings
mavenCentralSettings

// Root project
lazy val scalafxProject = (project in file("."))
  .settings(
    name            := "scalafx-project",
    publishArtifact := false,
    publish / skip  := true
  )
  .aggregate(scalafx, scalafxDemos)

// ScalaFX project
lazy val scalafx = (project in file("scalafx")).settings(
  name        := "scalafx",
  description := "The ScalaFX framework",
  libraryDependencies ++= javafxModules,
  run / fork             := true,
  publishArtifact        := true,
  Test / publishArtifact := false
)

// ScalaFX Demos project
lazy val scalafxDemos = (project in file("scalafx-demos")).settings(
  name        := "scalafx-demos",
  description := "The ScalaFX demonstrations",
  libraryDependencies ++= javafxModules,
  run / fork := true,
  javaOptions ++= Seq(
    "-Xmx512M",
    "-Djavafx.verbose"
  ),
  publishArtifact := false,
  publish / skip  := true
).dependsOn(scalafx % "compile;test->test")

val Scala2_12 = "2.12.21"
val Scala2_13 = "2.13.18"
val Scala3_3  = "3.3.8"

// Dependencies
lazy val javafxModules =
  Seq("base", "controls", "fxml", "graphics", "media", "swing", "web")
    .map(m => "org.openjfx" % s"javafx-$m" % javaFXVersion)
lazy val scalaTestLib = "org.scalatest" %% "scalatest" % "3.2.20"

// scala-reflect is only used by Scala 2.12 sources (ObservableBuffer.sort uses runtime reflection)
def scalaReflectLibs(scalaVersion: String): Seq[ModuleID] =
  CrossVersion.partialVersion(scalaVersion) match {
    case Some((2, 12)) => Seq("org.scala-lang" % "scala-reflect" % scalaVersion)
    case _             => Seq.empty[ModuleID]
  }

// Common settings
lazy val scalafxSettings = Seq(
  version            := scalafxVersion,
  crossScalaVersions := Seq(Scala3_3, Scala2_13, Scala2_12),
  scalaVersion       := Scala3_3,
  javaOptions ++= Seq("-Djavafx.enablePreview=true"),
  scalacOptions ++= Seq("-unchecked", "-deprecation", "-encoding", "utf8", "-feature", "-release", "23"),
  scalacOptions ++= {
    CrossVersion.partialVersion(scalaVersion.value) match {
      case Some((2, _)) => Seq("-Xcheckinit", "-Xsource:3", "-Xmigration")
      case Some((3, _)) => Seq("-source:3.3-migration", "-explain", "-explain-types")
      case _            => Seq.empty[String]
    }
  },
  Compile / doc / scalacOptions ++= {
    CrossVersion.partialVersion(scalaVersion.value) match {
      case Some((2, _)) =>
        Opts.doc.title("ScalaFX API") ++
          Opts.doc.version(scalafxVersion) ++
          Seq(
            "-sourcepath",
            baseDirectory.value.toString,
            "-doc-root-content",
            s"${baseDirectory.value}/src/main/scala/root-doc.creole",
            "-doc-source-url",
            s"https://github.com/scalafx/scalafx/tree/$versionTagDir/scalafx/€{FILE_PATH}.scala",
            s"-doc-external-doc:${scalaInstance.value.libraryJar}#https://www.scala-lang.org/api/${scalaVersion.value}/",
            "-doc-footer",
            s"ScalaFX API v.$scalafxVersion"
          ) ++
          (
            Option(System.getenv("GRAPHVIZ_DOT_PATH")) match {
              case Some(path) => Seq(
                  "-diagrams",
                  "-diagrams-dot-path",
                  path,
                  "-diagrams-debug"
                )
              case None => Seq.empty[String]
            }
          )
      case Some((3, _)) =>
        Opts.doc.title("ScalaFX API") ++
          Opts.doc.version(scalafxVersion) ++
          Seq(
            "-sourcepath",
            baseDirectory.value.toString,
            "-doc-root-content",
            s"${baseDirectory.value}/src/main/scala-3/root-doc.md",
            "-doc-source-url",
            s"https://github.com/scalafx/scalafx/tree/$versionTagDir/scalafx/€{FILE_PATH}.scala",
            s"-doc-external-doc:${scalaInstance.value.libraryJar}#https://www.scala-lang.org/api/${scalaVersion.value}/",
            "-doc-footer",
            s"ScalaFX API v.$scalafxVersion"
          )
      case _ => Seq.empty[String]
    }
  },
  // Add other dependencies
  libraryDependencies ++= scalaReflectLibs(scalaVersion.value),
  libraryDependencies += scalaTestLib % Test,
  autoAPIMappings                    := true,
  manifestSetting,
  Test / fork              := true,
  Test / parallelExecution := false,
  // Run JavaFX in headless mode (JavaFX 26+), no xvfb/virtual display needed
  Test / javaOptions += "-Dglass.platform=headless"
)

lazy val manifestSetting = packageOptions += {
  Package.ManifestAttributes(
    "Created-By"               -> s"SBT ${sbtVersion.value}",
    "Built-By"                 -> Option(System.getenv("JAR_BUILT_BY")).getOrElse(System.getProperty("user.name")),
    "Build-Jdk"                -> System.getProperty("java.version"),
    "Specification-Title"      -> name.value,
    "Specification-Version"    -> version.value,
    "Specification-Vendor"     -> organization.value,
    "Implementation-Title"     -> name.value,
    "Implementation-Version"   -> version.value,
    "Implementation-Vendor-Id" -> organization.value,
    "Implementation-Vendor"    -> organization.value
  )
}

// Metadata needed by Maven Central
// See also http://maven.apache.org/pom.html#Developers
lazy val mavenCentralSettings = Seq(
  organization         := "org.scalafx",
  organizationName     := "ScalaFX",
  organizationHomepage := Option(uri("https://www.scalafx.org/")),
  homepage             := Option(uri("https://www.scalafx.org/")),
  startYear            := Option(2011),
  licenses := Seq(License("BSD-3-Clause", uri("https://github.com/scalafx/scalafx/blob/master/LICENSE.txt"))),
  scmInfo  := Option(ScmInfo(uri("https://github.com/scalafx/scalafx"), "scm:git@github.com:scalafx/scalafx.git")),
  pomIncludeRepository := { _ => false },
  publishTo            := {
    val centralSnapshots = "https://central.sonatype.com/repository/maven-snapshots/"
    if (isSnapshot.value)
      Option("central-portal-snapshots" at centralSnapshots)
    else
      localStaging.value
  },
  developers := List(
    Developer("rafael.afonso", "Rafael Afonso", "", uri("https://github.com/rafonso")),
    Developer("", "Mike Allen", "", uri("")),
    Developer("Alain.Fagot.Bearez", "Alain Béarez", "", uri("http://cua.li/TI/")),
    Developer("steveonjava", "Stephen Chin", "", uri("http://www.nighthacking.com/")),
    Developer("KevinCoghlan", "Kevin Coghlan", "", uri("http://www.kevincoghlan.com")),
    Developer("akauppi", "Asko Kauppi", "", uri("")),
    Developer("rladstaetter", "Robert Ladstätter", "", uri("")),
    Developer("peter.pilgrim", "Peter Pilgrim", "", uri("http://www.xenonique.co.uk/blog/")),
    Developer("", "Matthew Pocock", "", uri("")),
    Developer("sven.reimers", "Sven Reimers", "", uri("http://wiki.netbeans.org/SvenReimers/")),
    Developer("jpsacha", "Jarek Sacha", "", uri("https://github.com/jpsacha")),
    Developer("", "Curtis Stanford", "", uri("")),
    Developer("", "Facsimiler", "", uri("https://github.com/Facsimiler")),
    Developer("", "Romain DEP.", "", uri("https://github.com/rom1dep")),
    Developer("", "estanislaobosch", "", uri("https://github.com/estanislaobosch")),
    Developer("", "Ken McDonald", "", uri("https://github.com/KenMcDonald")),
    Developer("", "Brian Schlining", "", uri("https://www.mbari.org/schlining-brian/")),
    Developer("", "Yusuke Izawa", "", uri("https://github.com/3tty0n")),
    Developer("", "Roman Hargrave", "", uri("https://github.com/RomanHargrave")),
    Developer("", "Johannes Mockenhaupt", "", uri("https://github.com/jotomo")),
    Developer("", "Piotr Mardziel", "", uri("https://piotr.mardziel.com/")),
    Developer("", "nigredo-tori", "", uri("https://github.com/nigredo-tori")),
    Developer("", "Damian Bronecki", "", uri("https://github.com/dbronecki")),
    Developer("", "SwhGo_oN", "", uri("https://github.com/swhgoon")),
    Developer("", "Rajmahendra", "", uri("https://github.com/rajmahendra")),
    Developer("", "Sam Privett", "", uri("https://github.com/maspe36")),
    Developer("", "Eric Zoerner", "", uri("https://github.com/ezoerner")),
    Developer("", "Edward Samson", "", uri("https://github.com/esamson")),
    Developer("", "Emily Herbert", "", uri("https://github.com/emilyaherbert")),
    Developer("", "Brandon Stilson", "", uri("https://github.com/bbstilson")),
    Developer("", "Anatoly Trosinenko", "", uri("https://github.com/atrosinenko")),
    Developer("", "Mark Lewis", "", uri("https://github.com/MarkCLewis")),
    Developer("", "Jeansen", "", uri("https://github.com/Jeansen"))
  )
)
