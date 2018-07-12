import java.net.URL

//
// Environment variables used by the build:
// GRAPHVIZ_DOT_PATH - Full path to Graphviz dot utility. If not defined Scaladocs will be build without diagrams.
// JAR_BUILT_BY      - Name to be added to Jar metadata field "Built-By" (defaults to System.getProperty("user.name")
//

val scalafxVersion = "8.0.144-R13-SNAPSHOT"
val versionTagDir = if (scalafxVersion.endsWith("SNAPSHOT")) "master" else "v" + scalafxVersion

// ScalaFX project
lazy val scalafx = (project in file("scalafx")).settings(
  scalafxSettings,
  description := "The ScalaFX framework",
  fork in run := true,
  scalacOptions in(Compile, doc) ++= Seq(
    "-sourcepath", baseDirectory.value.toString,
    "-doc-root-content", baseDirectory.value + "/src/main/scala/root-doc.creole",
    "-doc-source-url", "https://github.com/scalafx/scalafx/blob/" + versionTagDir + "/scalafx/€{FILE_PATH}.scala"
  ) ++ (Option(System.getenv("GRAPHVIZ_DOT_PATH")) match {
    case Some(path) => Seq("-diagrams", "-diagrams-dot-path", path)
    case None => Seq.empty[String]
  })
)

// ScalaFX Demos project
lazy val scalafxDemos = (project in file("scalafx-demos")).settings(
  scalafxSettings,
  description := "The ScalaFX demonstrations",
  fork in run := true,
  javaOptions ++= Seq(
    "-Xmx512M",
    "-Djavafx.verbose"
  ),
  publishArtifact := false
).dependsOn(scalafx % "compile;test->test")


// Dependencies
lazy val scalatest = "org.scalatest" %% "scalatest" % "3.0.5"

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
  crossScalaVersions := Seq("2.12.6", "2.10.7", "2.11.12"),
  scalaVersion := crossScalaVersions.value.head,
  scalacOptions ++= Seq("-unchecked", "-deprecation", "-Xcheckinit", "-encoding", "utf8", "-feature"),
  scalacOptions in(Compile, doc) ++= Opts.doc.title("ScalaFX API"),
  scalacOptions in(Compile, doc) ++= Opts.doc.version(scalafxVersion),
  scalacOptions in(Compile, doc) += s"-doc-external-doc:${scalaInstance.value.libraryJar}#http://www.scala-lang.org/api/${scalaVersion.value}/",
  scalacOptions in(Compile, doc) ++= Seq("-doc-footer", s"ScalaFX API v.$scalafxVersion"),
  javacOptions ++= Seq(
    "-target", "1.8",
    "-source", "1.8",
    "-Xlint:deprecation"),
  libraryDependencies ++= Seq(
    "org.scala-lang" % "scala-reflect" % scalaVersion.value,
    scalatest % "test"),
  autoAPIMappings := true,
  manifestSetting,
  publishSetting,
  fork in Test := true,
  parallelExecution in Test := false,
  resolvers += sonatypeNexusSnapshots,
  // print junit-style XML for CI
  testOptions in Test += {
    val t = (target in Test).value
    Tests.Argument(TestFrameworks.ScalaTest, "-u", s"$t/junitxmldir")
  },
  shellPrompt in ThisBuild := { state => "sbt:" + Project.extract(state).currentRef.project + "> " }
) ++ mavenCentralSettings


lazy val manifestSetting = packageOptions += {
  Package.ManifestAttributes(
    "Created-By" -> "Simple Build Tool",
    "Built-By" -> Option(System.getenv("JAR_BUILT_BY")).getOrElse(System.getProperty("user.name")),
    "Build-Jdk" -> System.getProperty("java.version"),
    "Specification-Title" -> name.value,
    "Specification-Version" -> version.value,
    "Specification-Vendor" -> organization.value,
    "Implementation-Title" -> name.value,
    "Implementation-Version" -> version.value,
    "Implementation-Vendor-Id" -> organization.value,
    "Implementation-Vendor" -> organization.value
  )
}

lazy val publishSetting = publishTo := {
  val version: String = scalafxVersion
  if (version.trim.endsWith("SNAPSHOT"))
    Some(sonatypeNexusSnapshots)
  else
    Some(sonatypeNexusStaging)
}

// Metadata needed by Maven Central
// See also http://maven.apache.org/pom.html#Developers
lazy val mavenCentralSettings = Seq(
  homepage := Some(new URL("http://www.scalafx.org/")),
  startYear := Some(2011),
  licenses := Seq(("BSD", new URL("https://github.com/scalafx/scalafx/blob/master/LICENSE.txt"))),
  pomExtra :=
    <scm>
      <url>https://github.com/scalafx/scalafx</url>
      <connection>scm:git:https://github.com/scalafx/scalafx.git</connection>
    </scm>
      <developers>
        <developer>
          <id>rafael.afonso</id>
          <name>Rafael Afonso</name>
          <url>https://github.com/rafonso</url>
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
