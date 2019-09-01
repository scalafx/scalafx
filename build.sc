import mill._, scalalib._
import $ivy.`com.lihaoyi::mill-contrib-bloop:0.5.0`

// JavaFX options
val javaFXVersion = "12.0.1"
val scalafxVersion = s"$javaFXVersion-R18-SNAPSHOT"

object scalafx extends mill.Cross[ScalaFXCrossModule]("2.13.0", "2.12.9", "2.11.12")

class ScalaFXCrossModule(val crossScalaVersion: String) extends CrossSbtModule { parent =>
  def suffix = crossScalaVersion
  def millSourcePath = os.pwd / "scalafx"

  def scalacOptions = Seq("-unchecked", "-deprecation", "-Xcheckinit", "-encoding", "utf8", "-feature")
  def ivyDeps =
    Agg(ivy"org.scala-lang:scala-reflect:$crossScalaVersion") ++
      Seq("base", "controls", "fxml", "graphics", "media", "swing", "web").map(m =>
        ivy"org.openjfx:javafx-$m:$javaFXVersion")

  object test extends Tests {
    def ivyDeps = Agg(ivy"org.scalatest::scalatest:3.0.8")
    def testFrameworks = Seq("org.scalatest.tools.Framework")
  }

  object demos extends SbtModule {
    def scalaVersion = crossScalaVersion
    def millSourcePath = os.pwd / "scalafx-demos"
    def moduleDeps = Seq(parent)
  }
}

