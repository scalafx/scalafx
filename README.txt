
                                                                  
  _|_|_|                      _|            _|_|_|_|  _|      _|  
_|          _|_|_|    _|_|_|  _|    _|_|_|  _|          _|  _|    
  _|_|    _|        _|    _|  _|  _|    _|  _|_|_|        _|      
      _|  _|        _|    _|  _|  _|    _|  _|          _|  _|    
_|_|_|      _|_|_|    _|_|_|  _|    _|_|_|  _|        _|      _|  
                                                                


This is the `README.txt ' file for ScalaFX 

1. Introduction
   ------------
   
ScalaFX is a UI DSL written within the Scala Language that sits on top of JavaFX
2.x and and JavaFX 8. This means that every ScalaFX application is also a
valid Scala application. By extension it supports full interoperability with
Java and can run anywhere the Java Virtual Machine (JVM) and JavaFX 2.0 orJavaFX 8 
are supported.

ScalaFX was originally created by Stephen Chin, Java Champion, Oracle JavaOne
program chair; and Sven Reimers, a member of the Netbeans Dream Team.

There are two branches of ScalaFX: v.1.0 supporting JavaFX 2.x (Java 7) and 
v.8.0 supporting JavaFX 8 (Java 8)

The recommended way to build ScalaFX is using the SBT. Building with other 
tools like Gradle and Maven may be possible but is not officially supported. 
For information on building with SBT see 'README-SBT.txt'. 
Instructions for Gradle and Maven, somewhat outdated, can be found in 
'README-GRADLE.txt' and 'README-MAVEN.txt', respectively.


The official web site for ScalaFX is http://scalafx.org, 
currently hosted at https://code.google.com/p/scalafx/


2. Software License
   ----------------

This software licensed under BSD Open Source.

The License text for this software can be found in `LICENSE.txt' in the root
folder of the project.


3. Software Required
   -----------------

The following software is needed to build ScalaFX:

  1) Mercurial (http://mercurial.selenic.com/) v2.2 or better
  2) sbt (http://www.scala-sbt.org/) v0.13.0 or better
  3) Scala (http://www.scala.org/)
    - ScalaFX 1.0 builds with either Scala version 2.9.3+ or 2.10.+ 
    - ScalaFX 8.0 builds only with Scala 2.10.2 or newer. 
  
It works with Windows, MacOS X and Linux ports.


3. Project Structure
   -----------------

The current project structure looks like this:

./archive
./project
./scalafx
./scalafx/src
./scalafx/src/main
./scalafx/src/main/scala
./scalafx/src/main/resources
./scalafx/src/test
./scalafx/src/test/resources
./scalafx/src/test/scala
./scalafx-demos
./scalafx-demos/src
./scalafx-demos/src/main
./scalafx-demos/src/main/scala
./scalafx-demos/src/main/resources
./scalafx-demos/src/test
./scalafx-demos/src/test/scala
./scalafx-demos/src/test/resources

Where `.' is a the root folder of the project.

The `archive' folder is reserved for remnants of the previous single module
build system.

The `scalafx' folder is the sub project for the ScalaFX Framework.

The `scalafx-demos' is the sub project for the ScalaFX Framework Demonstrations.

The `project' folder is reserved for Scala SBT.


4. Credits
   -------
   
You can find the full list of committers, developers and contributors in
the file `MAINTAINERS.txt'.
