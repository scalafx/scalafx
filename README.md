ScalaFX is a UI DSL written within the Scala Language that sits on top of JavaFX
2.x and JavaFX 8. This means that every ScalaFX application is also a
valid Scala application. By extension it supports full interoperability with
Java and can run anywhere the Java Virtual Machine (JVM) and JavaFX 2.x or JavaFX 8 
are supported.

[![Build Status](https://travis-ci.org/scalafx/scalafx.svg?branch=SFX-8)](https://travis-ci.org/scalafx/scalafx)

ScalaFX was originally created by Stephen Chin, Java Champion, Oracle JavaOne
program chair; and Sven Reimers, a member of the Netbeans Dream Team.

There are two branches of ScalaFX: v.1.0 supporting JavaFX 2.x (Java 7) and 
v.8.0 supporting JavaFX 8 (Java 8).

ScalaFX binaries are published in the Maven Central repository:
http://search.maven.org/#search%7Cga%7C1%7Cscalafx

To use ScalaFX with SBT and Java 7 add following dependency:

    libraryDependencies += "org.scalafx" %% "scalafx" % "1.0.0-R8"

With Java 8 use:

    libraryDependencies += "org.scalafx" %% "scalafx" % "8.0.0-R4"

You can find a simple project setup in subdirectory `scalafx-hello-world`

Snapshot releases are also regularly published on Sonatype. To use a snapshot
build you may need to add "Sonatype OSS Snapshots" resolver to you SBT 
configuration:

    resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots" 

If you just want to download a recent snapshot build you can also use automated build site
http://jfxtras.com/jenkins/job/scalafx/

ScalaFX source code is using the SBT build system.
For information on building with SBT see `README-SBT.txt`. 

The official web site for ScalaFX is http://scalafx.org, 
currently hosted at https://code.google.com/p/scalafx/


#Software License

This software licensed under BSD Open Source.

The License text for this software can be found in [LICENSE.txt](LICENSE.txt) in the root
folder of the project.


#Software Required

The following software is needed to build ScalaFX:

  1. [SBT](http://www.scala-sbt.org/) v.0.13.5 or better
  2. [Scala](http://www.scala.org/)
    - ScalaFX 1.0 builds with either Scala version 2.9.3+, 2.10.+, or 2.11.+ 
    - ScalaFX 8.0 builds with Scala 2.10.2 or newer. 
  
It works with Windows, MacOS X and Linux ports.


#Project Structure

The current project structure looks like this:

    ./archive
    ./project
    ./scalafx
    ./scalafx-demos
    ./scalafx-hello-world

Where `.` is a the root folder of the project.

The `archive` folder is reserved for remnants of the previous single module
build system.

The `scalafx` folder is the sub project for the ScalaFX Framework.

The `scalafx-demos` is the sub project for the ScalaFX Framework Demonstrations.

The `project` folder is reserved for Scala SBT.

The `scalafx-hello-world` is a simple self contained project using ScalaFX. 
It can be used as a template for creating user projects.


#Source Code Branching Policy

Main development is done on the `master` branch. 
Commits common to JavaFX 2 an JavaFX 8 support are done on this branch. 
Commits that are only applicable to JavaFX 8 are done on the `SFX-8` branch (master branch for ScalaFX 8). 
Pull requests are only accepted on `master` and `SFX-8` or their branches (feature branches). 
Merging `master` and `SFX-8` is done only in one direction (along compatibility) from `master` into `SFX-8`.
Releases are done on `stable` and `stable-SFX-8` branches for ScalaFX 1 and ScalaFX 8, respectively.
Releases are tagged with version number. 
The branching policy is illustrated in the graph below.

![Current branching policy](http://scalafx.github.io/images/scalafx-branching-policy-1.png)

#Credits
   
You can find the full list of committers, developers and contributors in
the file [MAINTAINERS.txt](MAINTAINERS.txt).
