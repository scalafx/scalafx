# ScalaFX

[![Join the chat at https://gitter.im/scalafx/scalafx](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/scalafx/scalafx?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

[![Scala CI](https://github.com/scalafx/scalafx/actions/workflows/scala.yml/badge.svg)](https://github.com/scalafx/scalafx/actions/workflows/scala.yml)
[![Maven Central Version](https://img.shields.io/maven-central/v/org.scalafx/scalafx_3)](https://central.sonatype.com/artifact/org.scalafx/scalafx_3)
[![Scaladoc](https://javadoc.io/badge2/org.scalafx/scalafx_3/scaladoc.svg)](https://javadoc.io/doc/org.scalafx/scalafx_3)
[![License](https://img.shields.io/badge/license-BSD--3--Clause-blue.svg)](LICENSE.txt)

ScalaFX is a UI DSL written within the Scala Language that sits on top of JavaFX. This means that every ScalaFX
application is also a valid Scala application. By extension, it supports full interoperability with Java and can run
anywhere the Java Virtual Machine (JVM) and JavaFX are supported.

If you have ScalaFX related questions please use [ScalaFX Discussions](https://github.com/scalafx/scalafx/discussions),
or [ScalaFX Users Group](https://groups.google.com/forum/#!forum/scalafx-users),
or [ScalaFX on StackOverflow](https://stackoverflow.com/questions/tagged/scalafx). Please report any problems
using [ScalaFX Issue Tracker](https://github.com/scalafx/scalafx/issues).

## Getting Started

ScalaFX binaries are published in the Maven Central repository:
[org.scalafx:scalafx_3](https://central.sonatype.com/artifact/org.scalafx/scalafx_3)

The official website for ScalaFX is https://scalafx.org.

### ScalaFX Dependencies

__ScalaFX 27__ is the current actively maintained version. It requires __JDK 25 or newer__
(a [JavaFX 27 requirement](https://openjfx.io/highlights/27/)) and is published for Scala 3.3+, 2.13, and 2.12.

#### SBT
Here is how you can add dependency using SBT.

```scala
libraryDependencies += "org.scalafx" %% "scalafx" % "27.0.0-R39"
```

Note that in ScalaFX version prior to `20.0.0-R31` and SBT older than 1.6, you needed to explicitly provide dependency on
JavaFX modules including platform dependent modules. This is no longer needed.

You can find examples of SBT setup in section [Demo Projects and Examples](#demo-projects-and-examples) below.

#### Mill

If you're using [Mill](https://com-lihaoyi.github.io/mill/):

```scala
//| mill-version: 1.1.10

package build
import mill._, scalalib._

object yourProject extends ScalaModule {
  def jvmId = "temurin:25" // JavaFX 27 requires JDK version >= 25
  def scalaVersion = "3.7.3"

  // Add dependency on JavaFX libraries
  val javaFxVersion = "27"
  val scalaFxVersion = "27.0.0-R39"
  val javaFxModules = List("base", "controls", "fxml", "graphics", "media", "swing", "web")

  def mvnDeps = Seq(
    mvn"org.scalafx::scalafx:$scalaFxVersion"
  ) ++ javaFxModules.map(mod => mvn"org.openjfx:javafx-$mod:$javaFxVersion")
}
```

You can find sample ScalaFX Mill project here: [scalafx-millproject](https://github.com/rom1dep/scalafx-millproject)

#### Gradle

Example of `build.gradle`:
```groovy
plugins {
    id 'scala'
    id 'application'
    id 'org.openjfx.javafxplugin' version '0.1.0'
}

repositories {
    mavenCentral()
}

javafx {
    version = "27"
    modules = ['javafx.controls', 'javafx.media']
}

dependencies {
    implementation 'org.scala-lang:scala3-library_3:3.3.8'
    implementation 'org.scalafx:scalafx_3:27.0.0-R39'
}

application {
    mainClass = 'hello.ScalaFXHelloWorld'
}
```

A complete sample Gradle project can ge found in [ScalaFX-Hello-World-Gradle](https://github.com/scalafx/ScalaFX-Hello-World-Gradle).


### What is in the version number

The ScalaFX version number has two parts. The first part corresponds to the latest JavaFX version it was tested with. The
second part is an incremental release number. For instance, version `27.0.0-R39` means that it was tested with JavaFX
version `27` and that it is the 39th release of ScalaFX.

#### Legacy Releases

##### ScalaFX 10

with Java 10 use:
```scala
libraryDependencies += "org.scalafx" %% "scalafx" % "10.0.2-R15"
```

##### ScalaFX 8
To use ScalaFX with SBT and Java 8 add following dependency (to use
the latest scalafx you might need Java version at least 1.8.40):

```scala
libraryDependencies += "org.scalafx" %% "scalafx" % "8.0.192-R14"
```

##### ScalaFX 2

With Java 7 use:

```scala
libraryDependencies += "org.scalafx" %% "scalafx" % "2.2.76-R11"
```


### Demo Projects and Examples

The [ScalaFX Organization page](https://github.com/scalafx) on GitHub contains several sample
project that illustrate use of ScalaFX.
The simplest one, and recommended to start with, is [scalafx-hello-world](https://github.com/scalafx/scalafx-hello-world). There is also a Gradle version here: [ScalaFX-Hello-World-Gradle](https://github.com/scalafx/ScalaFX-Hello-World-Gradle).

### Development Snapshots

Snapshot releases are published to the
[Maven Central snapshots repository](https://central.sonatype.com/repository/maven-snapshots/org/scalafx/).
To use a snapshot build, add the Central snapshots resolver to your SBT configuration:

```scala
resolvers += Resolver.sonatypeCentralSnapshots
```

For other build tools, add `https://central.sonatype.com/repository/maven-snapshots/` as a Maven repository.


## Software License

This software is licensed under the BSD 3-Clause License (BSD-3-Clause).

The License text for this software can be found in [LICENSE.txt](LICENSE.txt) in the root
folder of the project.


## Software Required

The following software is needed to build ScalaFX:

  1. [SBT](https://www.scala-sbt.org/) 2.x (currently 2.0.9). The SBT launcher picks up the version from `project/build.properties` automatically.
  2. [Scala](https://www.scala-lang.org/). ScalaFX 27 is cross-built for Scala 3.3.8 (default), 2.13.18, and 2.12.21.
  3. Java 25 or better is required as of JavaFX 27 / ScalaFX 27.0.0-R39 (this is [JavaFX 27 requirement](https://openjfx.io/highlights/27/))

It works with Windows, macOS, and Linux ports.


## Project Structure

The current project directory structure:

    ./notes
    ./project
    ./scalafx
    ./scalafx-demos

Where `.` is the root folder of the project.

The `notes` folder contains release notes for past releases.

The `scalafx` folder is the sub-project for the ScalaFX Framework.

The `scalafx-demos` is the sub-project for the ScalaFX Framework Demonstrations, some are a bit out of date, help needed here :).

The `project` folder is reserved for SBT build system setup.


## Source Code Branching Policy

Development happens on the `master` branch.
Releases are done on the `stable` branch.
Releases are tagged with version number.
Pull requests are only accepted off a branch created from the `master` branch.
When working on a pull request, create a separate branch for each feature or bug fix.
This way the main development branch is not blocked by a pull request and pull requests are easier to merge individually.

The ScalaFX 8 and 2.2 development is no longer active.
For those who need it, the code is on branches: `SFX-8` and  `SFX-2`. 
Past releases are on `SFX-8-stable` and `SFX-2-stable` branches.


## Authors

ScalaFX was originally created by Stephen Chin, Java Champion, Oracle JavaOne
program chair; and Sven Reimers, a member of the Netbeans Dream Team.


## Credits

The most up to date list of contributors to the project can be found on the [Contributors](https://github.com/scalafx/scalafx/graphs/contributors) page.


## Community
We request all the team members to follow the [Typelevel Code of Conduct](https://typelevel.org/code-of-conduct/) in our mailing list, issue discussion, Gitter room or any of ScalaFX meetups.

For more info on Contribute, check our [Contributing page](https://scalafx.org/docs/contributing/).

