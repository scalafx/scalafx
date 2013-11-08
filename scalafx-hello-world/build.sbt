// Name of the project
name := "ScalaFX Hello World"

// Project version
version := "1.0.0"

// Version of Scala used by the project
scalaVersion := "2.10.3"

// Add dependency on ScalaFX library, for use with JavaFX 2.2/Java 7
libraryDependencies += "org.scalafx" %% "scalafx" % "1.0.0-M6"

// Add dependency on ScalaFX library, for use with JavaFX 8/Java 8
// libraryDependencies += "org.scalafx" %% "scalafx" % "8.0.0-M2"

// Add dependency on JavaFX library based on JAVA_HOME variable
unmanagedJars in Compile += Attributed.blank(file(System.getenv("JAVA_HOME") + "/jre/lib/jfxrt.jar"))

// Fork a new JVM for 'run' and 'test:run', to avoid JavaFX double initialization problems
fork := true
