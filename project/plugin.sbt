scalacOptions ++= Seq("-unchecked", "-deprecation")

resolvers += Opts.resolver.sonatypeSnapshots

// addSbtPlugin("com.github.mpeltonen" % "sbt-idea" % "1.3.0")
addSbtPlugin("com.github.mpeltonen" % "sbt-idea" % "1.5.0-SNAPSHOT")

addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "2.2.0")
