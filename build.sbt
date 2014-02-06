import scala.xml._
import java.net.URL

val scalafxVersion = "8.0.0-M4-SNAPSHOT"

// ScalaFX project
lazy val scalafx = Project(
  id = "scalafx",
  base = file("scalafx"),
  settings = scalafxSettings ++ Seq(
    description := "The ScalaFX framework",
    scalacOptions in (Compile, doc) ++= Seq (
      "-doc-root-content", baseDirectory.value + "/src/main/scala/root-doc.md"
    )
  )
)

// ScalaFX Demos project
lazy val scalafxDemos = Project(
  id = "scalafx-demos",
  base = file("scalafx-demos"),
  settings = scalafxSettings ++ Seq(
    description := "The ScalaFX demonstrations",
    fork in run := true,
    javaOptions ++= Seq(
      "-Xmx512M",
      "-Djavafx.verbose"
    ),
    publishArtifact := false
  )
) dependsOn (scalafx % "compile;test->test")

// Dependencies
lazy val junit = "junit" % "junit" % "4.11"
lazy val scalatest = "org.scalatest" % "scalatest_2.10" % "2.0"

// Resolvers
lazy val sonatypeNexusSnapshots = "Sonatype Nexus Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
lazy val sonatypeNexusReleases = "Sonatype Nexus Releases" at "https://oss.sonatype.org/content/repositories/releases"
lazy val sonatypeNexusStaging = "Sonatype Nexus Staging" at "https://oss.sonatype.org/service/local/staging/deploy/maven2"
lazy val localMavenRepo = "Local Maven Repository" at "file://" + Path.userHome.absolutePath + "/.m2/repository"

// Common settings
lazy val scalafxSettings = Defaults.defaultSettings ++ Seq(
  organization := "org.scalafx",
  version := scalafxVersion,
  // TODO SFX8: At a moment only ScalaFX 2.10.2+ supports Java 8, due to some InvokeDynamic byte codes
  crossScalaVersions := Seq("2.10.3"/*, "2.9.3"*/),
  scalaVersion <<= crossScalaVersions { versions => versions.head },
  scalacOptions ++= Seq("-unchecked", "-deprecation", "-Xcheckinit", "-encoding", "utf8"),
  scalacOptions in(Compile, doc) ++= Opts.doc.title("ScalaFX API"),
  scalacOptions in(Compile, doc) ++= Opts.doc.version(scalafxVersion),
    javacOptions ++= Seq(
    "-target", "1.8",
    "-source", "1.8",
    "-Xlint:deprecation"),
  libraryDependencies ++= Seq(
    scalatest % "test",
    junit % "test"),
  manifestSetting,
  publishSetting,
  fork in Test := true,
  parallelExecution in Test := false,
  resolvers ++= Seq(localMavenRepo, sonatypeNexusSnapshots),
  // print junit-style XML for CI
  testOptions in Test <+= (target in Test) map {
    t => Tests.Argument(TestFrameworks.ScalaTest, "-u", "%s" format (t / "junitxmldir"))
  },
  shellPrompt in ThisBuild := { state => "sbt:" + Project.extract(state).currentRef.project + "> " }
) ++ mavenCentralSettings

lazy val manifestSetting = packageOptions <+= (name, version, organization) map {
  (title, version, vendor) =>
    Package.ManifestAttributes(
      "Created-By" -> "Simple Build Tool",
      "Built-By" -> Option(System.getenv("JAR_BUILT_BY")).getOrElse(System.getProperty("user.name")),
      "Build-Jdk" -> System.getProperty("java.version"),
      "Specification-Title" -> title,
      "Specification-Version" -> version,
      "Specification-Vendor" -> vendor,
      "Implementation-Title" -> title,
      "Implementation-Version" -> version,
      "Implementation-Vendor-Id" -> vendor,
      "Implementation-Vendor" -> vendor
    )
}

lazy val publishSetting = publishTo <<= version {
  version: String =>
    if (version.trim.endsWith("SNAPSHOT"))
      Some(sonatypeNexusSnapshots)
    else
      Some(sonatypeNexusStaging)
}

// Metadata needed by Maven Central
// See also http://maven.apache.org/pom.html#Developers
lazy val mavenCentralSettings = Seq(
  homepage := Some(new URL("https://code.google.com/p/scalafx/")),
  startYear := Some(2011),
  licenses := Seq(("BSD", new URL("https://code.google.com/p/scalafx/source/browse/LICENSE.txt"))),
  pomExtra <<= (pomExtra, name, description) {
    (pom, name, desc) => pom ++ Group(
      <scm>
        <url>https://code.google.com/p/scalafx</url>
        <connection>scm:hg:https://code.google.com/p/scalafx</connection>
      </scm>
        <developers>
          <developer>
            <id>rafael.afonso</id>
            <name>Rafael Afonso</name>
          </developer>
          <developer>
            <name>Mike Allen</name>
          </developer>
          <developer>
            <id>Alain.Fagot.Bearez</id>
            <name>Alain Béarez</name>
            <url>http://cua.li/TI/</url>
          </developer>
          <developer>
            <id>steveonjava</id>
            <name>Stephen Chin</name>
            <url>http://www.nighthacking.com/</url>
          </developer>
          <developer>
            <id>akauppi</id>
            <name>Asko Kauppi</name>
          </developer>
          <developer>
            <id>rladstaetter</id>
            <name>Robert Ladstätter</name>
          </developer>
          <developer>
            <id>peter.pilgrim</id>
            <name>Peter Pilgrim</name>
            <url>http://www.xenonique.co.uk/blog/</url>
          </developer>
          <developer>
            <name>Matthew Pocock</name>
          </developer>
          <developer>
            <id>sven.reimers</id>
            <name>Sven Reimers</name>
            <url>http://wiki.netbeans.org/SvenReimers/</url>
          </developer>
          <developer>
            <id>jpsacha</id>
            <name>Jarek Sacha</name>
          </developer>
          <developer>
            <name>Curtis Stanford</name>
          </developer>
        </developers>
    )
  }
)
