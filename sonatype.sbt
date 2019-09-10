//
// Publishing setup for sbt-sonatype plugin
// [[]]
//
import xerial.sbt.Sonatype._

sonatypeProjectHosting := Some(GitHubHosting("scalafx", "scalafx", "scalafx-dev@googlegroups.com"))
homepage := Some(new URL("http://www.scalafx.org/"))
startYear := Some(2011)

//
// Customize Java style publishing
//
// Enables publishing to maven repo
publishMavenStyle := true

//publishTo := sonatypePublishTo.value