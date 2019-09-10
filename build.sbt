import java.net.URL

import scala.xml.transform.{RewriteRule, RuleTransformer}
import scala.xml.{Node => XmlNode, NodeSeq => XmlNodeSeq, _}

//
// Environment variables used by the build:
// GRAPHVIZ_DOT_PATH - Full path to Graphviz dot utility. If not defined Scaladocs will be build without diagrams.
// JAR_BUILT_BY      - Name to be added to Jar metadata field "Built-By" (defaults to System.getProperty("user.name")
//

val javaFXVersion = "12.0.2"
val scalafxVersion = s"$javaFXVersion-R18-SNAPSHOT"

val versionTagDir = if (scalafxVersion.endsWith("SNAPSHOT")) "master" else "v" + scalafxVersion

// ScalaFX project
lazy val scalafx = (project in file("scalafx")).settings(
  scalafxSettings,
  description := "The ScalaFX framework",
  // Add JavaFX dependencies, mark as "provided", so they can be later removed from published POM
  libraryDependencies ++= javafxModules.map(
    m => "org.openjfx" % s"javafx-$m" % javaFXVersion % "provided" classifier osName),
  fork in run := true,
  scalacOptions in(Compile, doc) ++= Seq(
    "-sourcepath", baseDirectory.value.toString,
    "-doc-root-content", baseDirectory.value + "/src/main/scala/root-doc.creole",
    "-doc-source-url", "https://github.com/scalafx/scalafx/blob/" + versionTagDir + "/scalafx/€{FILE_PATH}.scala"
  ) ++ (Option(System.getenv("GRAPHVIZ_DOT_PATH")) match {
    case Some(path) => Seq("-diagrams", "-diagrams-dot-path", path)
    case None => Seq.empty[String]
  }),
  publishArtifact := true
)

// ScalaFX Demos project
lazy val scalafxDemos = (project in file("scalafx-demos")).settings(
  scalafxSettings,
  description := "The ScalaFX demonstrations",
  libraryDependencies ++= javafxModules.map(
    m => "org.openjfx" % s"javafx-$m" % javaFXVersion classifier osName),
  fork in run := true,
  javaOptions ++= Seq(
    "-Xmx512M",
    "-Djavafx.verbose"
  ),
  publishArtifact := false
).dependsOn(scalafx % "compile;test->test")


// Dependencies
val osName = System.getProperty("os.name") match {
  case n if n.startsWith("Linux") => "linux"
  case n if n.startsWith("Mac") => "mac"
  case n if n.startsWith("Windows") => "win"
  case _ => throw new Exception("Unknown platform!")
}
val javafxModules = Seq("base", "controls", "fxml", "graphics", "media", "swing", "web")
lazy val scalatest = "org.scalatest" %% "scalatest" % "3.0.8"

// Add snapshots to root project to enable compilation with Scala SNAPSHOT compiler,
// e.g., 2.11.0-SNAPSHOT
resolvers += Resolver.sonatypeRepo("snapshots")

// Common settings
lazy val scalafxSettings = Seq(
  organization := "org.scalafx",
  version := scalafxVersion,
  crossScalaVersions := Seq("2.13.0", "2.12.9", "2.11.12", "2.10.7"),
  scalaVersion := crossScalaVersions.value.head,
  // Add src/main/scala-2.13+ for Scala 2.13 and newer
  //   and src/main/scala-2.12- for Scala versions older than 2.13
  unmanagedSourceDirectories in Compile += {
    val sourceDir = (sourceDirectory in Compile).value
    CrossVersion.partialVersion(scalaVersion.value) match {
      case Some((2, n)) if n >= 13 => sourceDir / "scala-2.13+"
      case _ => sourceDir / "scala-2.12-"
    }
  },
  unmanagedSourceDirectories in Test += {
    val sourceDir = (sourceDirectory in Test).value
    CrossVersion.partialVersion(scalaVersion.value) match {
      case Some((2, n)) if n >= 13 => sourceDir / "scala-2.13+"
      case _ => sourceDir / "scala-2.12-"
    }
  },
  scalacOptions ++= Seq("-unchecked", "-deprecation", "-Xcheckinit", "-encoding", "utf8", "-feature"),
  scalacOptions in(Compile, doc) ++= Opts.doc.title("ScalaFX API"),
  scalacOptions in(Compile, doc) ++= Opts.doc.version(scalafxVersion),
  scalacOptions in(Compile, doc) += s"-doc-external-doc:${scalaInstance.value.libraryJar}#http://www.scala-lang.org/api/${scalaVersion.value}/",
  scalacOptions in(Compile, doc) ++= Seq("-doc-footer", s"ScalaFX API v.$scalafxVersion"),
  javacOptions ++= Seq(
    "-target", "1.8",
    "-source", "1.8",
    "-Xlint:deprecation"),
  // Add other dependencies
  libraryDependencies ++= Seq(
    "org.scala-lang" % "scala-reflect" % scalaVersion.value,
    scalatest % "test"),
  // Use `pomPostProcess` to remove dependencies marked as "provided" from publishing in POM
  // This is to avoid dependency on wrong OS version JavaFX libraries [Issue #289]
  // See also [https://stackoverflow.com/questions/27835740/sbt-exclude-certain-dependency-only-during-publish]
  pomPostProcess := { node: XmlNode =>
    new RuleTransformer(new RewriteRule {
      override def transform(node: XmlNode): XmlNodeSeq = node match {
        case e: Elem if e.label == "dependency" && e.child.exists(c => c.label == "scope" && c.text == "provided") =>
          val organization = e.child.filter(_.label == "groupId").flatMap(_.text).mkString
          val artifact = e.child.filter(_.label == "artifactId").flatMap(_.text).mkString
          val version = e.child.filter(_.label == "version").flatMap(_.text).mkString
          Comment(s"provided dependency $organization#$artifact;$version has been omitted")
        case _ => node
      }
    }).transform(node).head
  },
  autoAPIMappings := true,
  manifestSetting,
  fork in Test := true,
  parallelExecution in Test := false,
  resolvers += Resolver.sonatypeRepo("snapshots"),
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
