// Important - Set the JAVAFX_HOME environment variable to the root of your JavaFX installation for this script to work
//
// You can also set your scala or java home if necessary like this:
// javaHome := Some(file("/Library/Java/JavaVirtualMachines/1.6.0_24-b07-330.jdk/Contents/Home"))
// scalaHome := Some(file("/Users/Sven/scala-2.9.1/"))

name := "ScalaFX"

version := "1.0-SNAPSHOT"

organization := "org.scalafx"

scalaVersion := "2.9.1"

resolvers += "Local Maven Repository" at "file://"+Path.userHome.absolutePath+"/.m2/repository"

unmanagedSourceDirectories in Compile <++= baseDirectory { base =>
  Seq(
    base / "src",
    base / "demo"
  )
}

// set the Scala test source directory to be <base>/test
scalaSource in Test <<= baseDirectory(_ / "test")

testListeners <<= target.map(t => Seq(new eu.henkelmann.sbt.JUnitXmlTestsListener(t.getAbsolutePath)))

// append several options to the list of options passed to the Java compiler
javacOptions ++= Seq("-source", "1.5", "-target", "1.5")

// append -deprecation to the options passed to the Scala compiler
scalacOptions += "-deprecation"

// define the statements initially evaluated when entering 'console', 'console-quick', or 'console-project'
initialCommands := """
  import System.{currentTimeMillis => now}
  def time[T](f: => T): T = {
    val start = now
    try { f } finally { println("Elapsed: " + (now - start)/1000.0 + " s") }
  }
"""

// set the main class for the main 'run' task
// change Compile to Test to set it for 'test:run'
mainClass in (Compile, run) := Some("scalafx.ColorfulCircles")

// add <base>/input to the files that '~' triggers on
watchSources <+= baseDirectory map { _ / "input" }

// define the repository to publish to
// publishTo := Some("name" at "url")

// disable updating dynamic revisions (including -SNAPSHOT versions)
offline := true

// set the prompt (for this build) to include the project id.
shellPrompt in ThisBuild := { state => Project.extract(state).currentRef.project + "> " }

// set the prompt (for the current project) to include the username
shellPrompt := { state => System.getProperty("user.name") + "> " }

// disable printing timing information, but still print [success]
showTiming := false

// disable printing a message indicating the success or failure of running a task
showSuccess := false

// change the format used for printing task completion time
timingFormat := {
    import java.text.DateFormat
    DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT)
}

// disable using the Scala version in output paths and artifacts
crossPaths := false

// fork a new JVM for 'run' and 'test:run'
fork := true

// fork a new JVM for 'test:run', but not 'run'
fork in Test := true

// add a JVM option to use when forking a JVM for 'run'
javaOptions += "-Xmx2G"

// only use a single thread for building
parallelExecution := false

// Execute tests in the current project serially
//   Tests from other projects may still run concurrently.
parallelExecution in Test := false

// add JavaFX 2.0 to the unmanaged classpath
unmanagedJars in Compile += Attributed.blank(file(System.getenv("JAVAFX_HOME") + "/rt/lib/jfxrt.jar"))

// publish test jar, sources, and docs
publishArtifact in Test := false

// disable publishing of main docs
publishArtifact in (Compile, packageDoc) := false

// change the classifier for the docs artifact
artifactClassifier in packageDoc := Some("doc")

// Copy all managed dependencies to <build-root>/lib_managed/
//   This is essentially a project-local cache and is different
//   from the lib_managed/ in sbt 0.7.x.  There is only one
//   lib_managed/ in the build root (not per-project).
retrieveManaged := true

/* Specify a file containing credentials for publishing. The format is:
realm=Sonatype Nexus Repository Manager
host=nexus.scala-tools.org
user=admin
password=admin123
*/
credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")

// Directly specify credentials for publishing.
credentials += Credentials("Sonatype Nexus Repository Manager", "nexus.scala-tools.org", "admin", "admin123")

