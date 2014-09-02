import scala.xml._
import java.net.URL
import SonatypeKeys._

val scalafxVersion = "2.2.67-R11-SNAPSHOT"

// ScalaFX project
lazy val scalafx = Project(
  id = "scalafx",
  base = file("scalafx"),
  settings = scalafxSettings ++ Seq(
    description := "The ScalaFX framework",
    fork in run := true,
    scalacOptions in (Compile, doc) ++= Seq (
      "-doc-root-content", baseDirectory.value + "/src/main/scala/root-doc.md"
    )
  ) ++ sonatypeSettings
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
lazy val scalatest = "org.scalatest" %% "scalatest" % "2.1.7"

// Resolvers
lazy val sonatypeNexusSnapshots = "Sonatype Nexus Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
lazy val sonatypeNexusStaging = "Sonatype Nexus Staging" at "https://oss.sonatype.org/service/local/staging/deploy/maven2"

// Add snapshots to root project to enable compilation with Scala SNAPSHOT compiler,
// e.g., 2.11.0-SNAPSHOT
resolvers += sonatypeNexusSnapshots

// Common settings
lazy val scalafxSettings = Seq(
  organization := "org.scalafx",
  version := scalafxVersion,
  crossScalaVersions := Seq("2.10.4", "2.11.1", "2.9.3"),
  scalaVersion <<= crossScalaVersions { versions => versions.head },
  scalacOptions ++= Seq("-unchecked", "-deprecation", "-Xcheckinit", "-encoding", "utf8"),
  scalacOptions in(Compile, doc) ++= Opts.doc.title("ScalaFX API"),
  scalacOptions in(Compile, doc) ++= Opts.doc.version(scalafxVersion),
  javacOptions ++= Seq(
    "-target", "1.6",
    "-source", "1.6",
    "-Xlint:deprecation"),
  libraryDependencies ++= Seq(
    // A hack to make compilation and packaging work with Scala 2.9.3. SBT attempts to download
    // test dependencies even when not used. Testing will not work in 2.9.3, but we are more
    // interested right now to testing in 2.10 and 2.11 and only releasing in 2.9.3.
    // scalatest % "test",
    if(scalaVersion.value.startsWith("2.9."))
      "org.scalatest" %% "scalatest" % "1.9.2" % "test"
    else
      scalatest % "test",
    junit % "test"),
  // ScalaTest needs Scala XML, in Scala 2.11 the XML library has been factored out to the `scala-xml` module
  libraryDependencies ++= (
    if (scalaVersion.value.startsWith("2.11."))
      Seq("org.scala-lang.modules" %% "scala-xml" % "1.0.1" % "test")
    else
      Seq.empty[ModuleID]),
  unmanagedLibs,
  manifestSetting,
  publishSetting,
  fork in Test := true,
  parallelExecution in Test := false,
  resolvers += sonatypeNexusSnapshots,
  // print junit-style XML for CI
  testOptions in Test <+= (target in Test) map {
    t => Tests.Argument(TestFrameworks.ScalaTest, "-u", "%s" format (t / "junitxmldir"))
  },
  shellPrompt in ThisBuild := { state => "sbt:" + Project.extract(state).currentRef.project + "> " }
) ++ mavenCentralSettings

// Location of JavaFX jar
val javafxHome: File =
  if (scala.util.Properties.javaVersion.startsWith("1.7."))
    file(scala.util.Properties.javaHome)
  else
    throw new Exception("This branch of ScalaFX requires java 1.7.*,  " +
      "got " + scala.util.Properties.javaVersion + "\n" +
      "Detected Java home as: " + scala.util.Properties.javaHome)

lazy val unmanagedLibs = unmanagedJars in Compile += Attributed.blank(javafxHome / "lib/jfxrt.jar")

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
            <id>KevinCoghlan</id>
            <name>Kevin Coghlan</name>
            <url>http://www.kevincoghlan.com</url>
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
