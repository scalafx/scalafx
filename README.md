# ScalaFX

[![Join the chat at https://gitter.im/scalafx/scalafx](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/scalafx/scalafx?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

[![Scala CI](https://github.com/scalafx/scalafx/actions/workflows/scala.yml/badge.svg)](https://github.com/scalafx/scalafx/actions/workflows/scala.yml)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/org.scalafx/scalafx_2.13/badge.svg)](https://maven-badges.herokuapp.com/maven-central/org.scalafx/scalafx_2.13)
[![Scaladoc](https://javadoc.io/badge2/org.scalafx/scalafx_2.13/scaladoc.svg)](https://javadoc.io/doc/org.scalafx/scalafx_2.13)

ScalaFX is a UI DSL written within the Scala Language that sits on top of JavaFX. This means that every ScalaFX
application is also a valid Scala application. By extension, it supports full interoperability with Java and can run
anywhere the Java Virtual Machine (JVM) and JavaFX are supported.

If you have ScalaFX related questions please use [ScalaFX Discussions](https://github.com/scalafx/scalafx/discussions),
or [ScalaFX Users Group](https://groups.google.com/forum/#!forum/scalafx-users),
or [ScalaFX on StackOverflow](https://stackoverflow.com/questions/tagged/scalafx). Please report any problems
using [ScalaFX Issue Tracker](https://github.com/scalafx/scalafx/issues).

## Getting Started

ScalaFX binaries are published in the Maven Central repository:
[http://search.maven.org/#search|ga|1|scalafx](http://search.maven.org/#search%7Cga%7C1%7Cscalafx)

The official website for ScalaFX is http://scalafx.org.

### ScalaFX Dependencies

__ScalaFX 11+__ is the current actively maintained version. ScalaFX 11+ is intended to support __Java 11 and newer__.

#### SBT
Here is how you can add dependency using SBT.

```scala
libraryDependencies += "org.scalafx" %% "scalafx" % "18.0.1-R28"
```

Note that in ScalaFX version prior to `18.0.1-R28` and SBT older than 1.6, you needed to explicitly provide dependency on
JavaFX modules including platform dependent modules. This is no longer needed.

You can find examples of SBT setup in section [Demo Projects and Examples](#demo-projects-and-examples) below.

#### Mill

If you're using [Mill](https://com-lihaoyi.github.io/mill/):

```scala
object yourProject extends ScalaModule {
  def scalaVersion = "3.0.0"

  // Customize coursier resolution to discover the OS-specific artifacts required by JavaFX
  // Note: this requires mill >= 0.9.7 (with pr/775 merged)
  def resolutionCustomizer = T.task {
    Some((r: coursier.core.Resolution) =>
      r.withOsInfo(coursier.core.Activation.Os.fromProperties(sys.props.toMap))
    )
  }

  // Add dependency on JavaFX libraries
  val javaFXVersion = "16"
  val scalaFXVersion = "16.0.0-R25"
  val javaFXModules = List("base", "controls", "fxml", "graphics", "media", "swing", "web")
    .map(m => ivy"org.openjfx:javafx-$m:$javaFXVersion")

  def ivyDeps = {
    Agg(
      ivy"org.scalafx::scalafx:$scalaFXVersion",
      //...
    ) ++ javaFXModules
  }
}
```

You can find sample ScalaFX Mill project here: [scalafx-millproject](https://github.com/rom1dep/scalafx-millproject)

### What is in the version number

ScalaFX version number has two part. The first part corresponds to the latest JavaFX version it was tested with. The
second part is an incremental release number. For instance, version `15.0.1-R20` means that it was tested with JavaFX
version `15.0.1` and that is the 20th release of ScalaFX.

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
The simplest one, and recommended to start with, is [`scalafx-hello-world`](https://github.com/scalafx/scalafx-hello-world).

### Development Snapshots

Snapshot releases are also regularly published on [Sonatype Snapshots](https://oss.sonatype.org/content/repositories/snapshots/org/scalafx/). To use a snapshot
build you may need to add "Sonatype OSS Snapshots" resolver to you SBT
configuration:

```scala
resolvers += Opts.resolver.sonatypeSnapshots
```

If you just want to download a recent snapshot build you can also use Travis CI build site
https://travis-ci.org/scalafx/scalafx


## Software License

This software licensed under BSD Open Source.

The License text for this software can be found in [LICENSE.txt](LICENSE.txt) in the root
folder of the project.


## Software Required

The following software is needed to build ScalaFX:

  1. [SBT](http://www.scala-sbt.org/) v.1.6.0 or better
  2. [Scala](http://www.scala.org/). ScalaFX 12 builds with Scala 2.10.2 or newer.

It works with Windows, Mac OS X, and Linux ports.


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

The current development is for ScalaFX 12.
The development is done on the `master` branch.
Releases are done on the `stable` branch.
Releases are tagged with version number.
Pull requests are only accepted off a brunch created from the `master` branch.
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
We request all the team members to follow the [Typelevel Code of Conduct](http://typelevel.org/conduct.html) in our mailing list, issue discussion, Gitter room or any of ScalaFX meetups.

For more info on Contribute, check our [Contributing page](http://http://www.scalafx.org/docs/contributing/).

