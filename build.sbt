// Important - Set the JAVAFX_HOME environment variable to the root of your JavaFX installation for this script to work

// set the name of the project
name := "ScalaFX"

version := "1.0"

organization := "org.scalafx"

// set the Scala version used for the project
scalaVersion := "2.9.0-1"

resolvers += "Local Maven Repository" at "file://"+Path.userHome.absolutePath+"/.m2/repository"

// set the main Scala source directory to be <base>/src
//scalaSource in Compile <<= baseDirectory(_ / "src")

unmanagedSourceDirectories in Compile <++= baseDirectory { base =>
  Seq(
    base / "src",
    base / "demo"
  )
}

// set the Scala test source directory to be <base>/test
scalaSource in Test <<= baseDirectory(_ / "test")

// add a test dependency on ScalaCheck
//libraryDependencies += "org.scala-tools.testing" %% "scalacheck" % "1.8" % "test"

// Set a dependency based partially on a val.
//{
//  val libosmVersion = "2.5.2-RC1"
//  libraryDependencies += "net.sf.travelingsales" % "osmlib" % libosmVersion from "http://downloads.sourceforge.net/project/travelingsales/libosm/"+libosmVersion+"/libosm-"+libosmVersion+".jar"
//}

// reduce the maximum number of errors shown by the Scala compiler
maxErrors := 20

// increase the time between polling for file changes when using continuous execution
pollInterval := 1000

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

// set the initial commands when entering 'console' only
// initialCommands in console := "import myproject._"

// set the main class for packaging the main jar
// 'run' will still auto-detect and prompt
// change Compile to Test to set it for the test jar
//mainClass in (Compile, packageBin) := Some("myproject.MyMain")

// set the main class for the main 'run' task
// change Compile to Test to set it for 'test:run'
mainClass in (Compile, run) := Some("scalafx.ColorfulCircles")

// add <base>/input to the files that '~' triggers on
watchSources <+= baseDirectory map { _ / "input" }

// add a maven-style repository
// resolvers += "name" at "url"

// add a sequence of maven-style repositories
// resolvers ++= Seq("name" at "url")

// define the repository to publish to
// publishTo := Some("name" at "url")

// set Ivy logging to be at the highest level
ivyLoggingLevel := UpdateLogging.Full

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

// set the location of the JDK to use for compiling Java code.
// if 'fork' is true, this is used for 'run' as well
// javaHome := Some(file("/Library/Java/JavaVirtualMachines/1.6.0_24-b07-330.jdk/Contents/Home"))

// Use Scala from a directory on the filesystem instead of retrieving from a repository
// scalaHome := Some(file("/Users/Sven/scala-2.9.0.1/"))

// don't aggregate clean (See FullConfiguration for aggregation details)
aggregate in clean := false

// only show warnings and errors on the screen for compilations.
//  this applies to both test:compile and compile and is Info by default
logLevel in compile := Level.Debug

// only show warnings and errors on the screen for all tasks (the default is Info)
//  individual tasks can then be more verbose using the previous setting
logLevel := Level.Debug

// only store messages at info and above (the default is Debug)
//   this is the logging level for replaying logging with 'last'
persistLogLevel := Level.Debug

// only show 10 lines of stack traces
traceLevel := 10

// only show stack traces up to the first sbt stack frame
traceLevel := 0

// add JavaFX 2.0 to the unmanaged classpath
unmanagedJars in Compile += Attributed.blank(file(System.getenv("$JAVAFX_HOME") + "/rt/lib/jfxrt.jar"))

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

