import sbt._

object MyPlugins extends Build {
  lazy val root = Project("root", file(".")) dependsOn (junitXmlListener)
  lazy val junitXmlListener = uri("https://github.com/ijuma/junit_xml_listener.git#fe434773255b451a38e8d889536ebc260f4225ce")
}
