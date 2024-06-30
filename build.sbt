import java.net.URI
import scala.xml.transform.{RewriteRule, RuleTransformer}
import scala.xml.{Node => XmlNode, NodeSeq => XmlNodeSeq, _}

//
// Environment variables used by the build:
// GRAPHVIZ_DOT_PATH - Full path to Graphviz dot utility. If not defined Scaladocs will be build without diagrams.
// JAR_BUILT_BY      - Name to be added to Jar metadata field "Built-By" (defaults to System.getProperty("user.name")
//

val javaFXVersion  = "22"
val scalafxVersion = "22.0.0-R34-SNAPSHOT"

val versionTagDir = if (scalafxVersion.endsWith("SNAPSHOT")) "master" else s"v.$scalafxVersion"

// Root project
//lazy val scalafxProject = (project in file("."))
//  .settings(
name            := "scalafx-project"
publishArtifact := false
publish / skip  := true
//  )
//  .aggregate(scalafx, scalafxDemos)

// ScalaFX project
lazy val scalafx = (project in file("scalafx")).settings(
  scalafxSettings,
  name        := "scalafx",
  description := "The ScalaFX framework",
  // Add JavaFX dependencies, mark as "provided", so they can be later removed from published POM
  libraryDependencies ++= javafxModules,
  run / fork             := true,
  publishArtifact        := true,
  Test / publishArtifact := false
)

// ScalaFX Demos project
lazy val scalafxDemos = (project in file("scalafx-demos")).settings(
  scalafxSettings,
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

val Scala2_12 = "2.12.19"
val Scala2_13 = "2.13.14"
val Scala3_3  = "3.3.3"

// Dependencies
lazy val javafxModules =
  Seq("base", "controls", "fxml", "graphics", "media", "swing", "web")
    .map(m => "org.openjfx" % s"javafx-$m" % javaFXVersion)
lazy val scalaTestLib = "org.scalatest" %% "scalatest" % "3.2.19"
def scalaReflectLibs(scalaVersion: String): Seq[ModuleID] =
  CrossVersion.partialVersion(scalaVersion) match {
    case Some((2, _)) => Seq("org.scala-lang" % "scala-reflect" % scalaVersion)
    case _            => Seq.empty[ModuleID]
  }

// Add src/main/scala-2.13+ for Scala 2.13 and newer
//   and src/main/scala-2.12- for Scala versions older than 2.13
def versionSubDir(scalaVersion: String): String =
  CrossVersion.partialVersion(scalaVersion) match {
    case Some((2, n)) if n < 13 => "scala-2.12-"
    case Some((_, _))           => "scala-2.13+"
  }

// Common settings
lazy val scalafxSettings = Seq(
  organization       := "org.scalafx",
  version            := scalafxVersion,
  crossScalaVersions := Seq(Scala3_3, Scala2_13, Scala2_12),
  scalaVersion       := Scala3_3,
  Compile / unmanagedSourceDirectories += (Compile / sourceDirectory).value / versionSubDir(scalaVersion.value),
  Test / unmanagedSourceDirectories += (Test / sourceDirectory).value / versionSubDir(scalaVersion.value),
  scalacOptions ++= Seq("-unchecked", "-deprecation", "-encoding", "utf8", "-feature", "-release", "17"),
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
            s"-doc-external-doc:${scalaInstance.value.libraryJar}#http://www.scala-lang.org/api/${scalaVersion.value}/",
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
      case _ => Seq.empty[String]
    }
  },
  // Add other dependencies
  libraryDependencies ++= scalaReflectLibs(scalaVersion.value),
  libraryDependencies += scalaTestLib % "test",
  // Use `pomPostProcess` to remove dependencies marked as "provided" from publishing in POM
  // This is to avoid dependency on wrong OS version JavaFX libraries [Issue #289]
  // See also [https://stackoverflow.com/questions/27835740/sbt-exclude-certain-dependency-only-during-publish]
  pomPostProcess := { node: XmlNode =>
    new RuleTransformer(new RewriteRule {
      override def transform(node: XmlNode): XmlNodeSeq = node match {
        case e: Elem if e.label == "dependency" && e.child.exists(c => c.label == "scope" && c.text == "provided") =>
          val organization = e.child.filter(_.label == "groupId").flatMap(_.text).mkString
          val artifact     = e.child.filter(_.label == "artifactId").flatMap(_.text).mkString
          val version      = e.child.filter(_.label == "version").flatMap(_.text).mkString
          Comment(s"provided dependency $organization#$artifact;$version has been omitted")
        case _ => node
      }
    }).transform(node).head
  },
  autoAPIMappings := true,
  manifestSetting,
  Test / fork              := true,
  Test / parallelExecution := false,
  // print junit-style XML for CI
  Test / testOptions += {
    val t = (Test / target).value
    Tests.Argument(TestFrameworks.ScalaTest, "-u", s"$t/junitxmldir")
  }
) ++ mavenCentralSettings

lazy val manifestSetting = packageOptions += {
  Package.ManifestAttributes(
    "Created-By"               -> "Simple Build Tool",
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
  homepage            := Option(new URI("http://www.scalafx.org/").toURL),
  startYear           := Option(2011),
  licenses            := Seq(("BSD", new URI("https://github.com/scalafx/scalafx/blob/master/LICENSE.txt").toURL)),
  sonatypeProfileName := "org.scalafx",
  scmInfo := Option(ScmInfo(url("https://github.com/scalafx/scalafx"), "scm:git@github.com:scalafx/scalafx.git")),
  publishMavenStyle := true,
  publishTo         := sonatypePublishToBundle.value,
  pomExtra :=
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
        <url>https://github.com/jpsacha</url>
      </developer>
      <developer>
        <name>Curtis Stanford</name>
      </developer>
      <developer>
        <name>Facsimiler</name>
        <url>https://github.com/Facsimiler</url>
      </developer>
      <developer>
        <name>Romain DEP.</name>
        <url>https://github.com/rom1dep</url>
      </developer>
      <developer>
        <name>estanislaobosch</name>
        <url>https://github.com/estanislaobosch</url>
      </developer>
      <developer>
        <name>Ken McDonald</name>
        <url>https://github.com/KenMcDonald</url>
      </developer>
      <developer>
        <name>Brian Schlining</name>
        <url>https://www.mbari.org/schlining-brian/</url>
      </developer>
      <developer>
        <name>Yusuke Izawa</name>
        <url>https://github.com/3tty0n</url>
      </developer>
      <developer>
        <name>Roman Hargrave</name>
        <url>https://github.com/RomanHargrave</url>
      </developer>
      <developer>
        <name>Johannes Mockenhaupt</name>
        <url>https://github.com/jotomo</url>
      </developer>
      <developer>
        <name>Piotr Mardziel</name>
        <url>https://piotr.mardziel.com/</url>
      </developer>
      <developer>
        <name>nigredo-tori</name>
        <url>https://github.com/nigredo-tori</url>
      </developer>
      <developer>
        <name>Damian Bronecki</name>
        <url>https://github.com/dbronecki</url>
      </developer>
      <developer>
        <name>SwhGo_oN</name>
        <url>https://github.com/swhgoon</url>
      </developer>
      <developer>
        <name>Rajmahendra</name>
        <url>https://github.com/rajmahendra</url>
      </developer>
      <developer>
        <name>Sam Privett</name>
        <url>https://github.com/maspe36</url>
      </developer>
      <developer>
        <name>Eric Zoerner</name>
        <url>https://github.com/ezoerner</url>
      </developer>
      <developer>
        <name>Edward Samson</name>
        <url>https://github.com/esamson</url>
      </developer>
      <developer>
        <name>Emily Herbert</name>
        <url>https://github.com/emilyaherbert</url>
      </developer>
      <developer>
        <name>Brandon Stilson</name>
        <url>https://github.com/bbstilson</url>
      </developer>
      <developer>
        <name>Anatoly Trosinenko</name>
        <url>https://github.com/atrosinenko</url>
      </developer>
      <developer>
        <name>Mark Lewis</name>
        <url>https://github.com/MarkCLewis</url>
      </developer>
      <developer>
        <name>Jeansen</name>
        <url>https://github.com/Jeansen</url>
      </developer>
    </developers>
)
