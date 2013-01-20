README    README    README    README    README    README    README    README    README    README    


                                                                  
  _|_|_|                      _|            _|_|_|_|  _|      _|  
_|          _|_|_|    _|_|_|  _|    _|_|_|  _|          _|  _|    
  _|_|    _|        _|    _|  _|  _|    _|  _|_|_|        _|      
      _|  _|        _|    _|  _|  _|    _|  _|          _|  _|    
_|_|_|      _|_|_|    _|_|_|  _|    _|_|_|  _|        _|      _|  
                                                                  
                                                                  


This is the `README.txt ' file for ScalaFX 

1. Introduction
   ------------
   
ScalaFX is a UI DSL written within the Scala Language that sits on top of JavaFX
2.x (not to be confused with Ingo Maier's great work on Functional Reactive
Programming for Swing). This means that every ScalaFX application is also a
valid Scala application. By extension it supports full interoperability with
Java and can run anywhere the Java Virtual Machine (JVM) and JavaFX 2.0 are
supported.

ScalaFX was originally created by Stephen Chin, Java Champion, Oracle JavaOne
program chair; and Sven Reimers, a member of the Netbeans Dream Team.

There are two official ways to build ScalaFX: using the SBT, which is the
primary option, and Gradle, the secondary option. For information on building
with SBT see `README-SBT.txt' and the Gradle operation `README-GRADLE.txt'.

Since, Thursday, 17th January 2013, ScalaFX has been refactored into
multi-module project. Peter Pilgrim, Java Champion, was responsible to move
ScalaFX from a single module to a multiple module project on SBT and Gradle.

The official web site for ScalaFX is https://code.google.com/p/scalafx/




2. Software License
   ----------------



3. Software Required
   -----------------

The following software is needed to build ScalaFX:

  1) Mercurial (http://mercurial.selenic.com/) v2.2 or better
  2a) sbt (http://www.scala-sbt.org/) v0.12.2 or better
  2b) gradle (http://gradle.org/)  v1.3 or better
  3) Scala  (http://www.scala.org/) version 2.9.2 works!
  
The ScalaFX software can be Java SE 7 from version jdk1.7.0_09 or better. It
works with Windows, MacOS X and Linux ports.


3. Project Structure
   -----------------

The current project structure looks like this:

./archive
./project
./scalafx-core
./scalafx-core/src
./scalafx-core/src/main
./scalafx-core/src/main/scala
./scalafx-core/src/main/resources
./scalafx-core/src/test
./scalafx-core/src/test/resources
./scalafx-core/src/test/scala
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

The `scalafx-core' folder is the sub project for the ScalaFX Core Framework.

The `scalafx-demos' is the sub project for the ScalaFX Demonstrations Framework.

The `project' folder is reserved for Scala SBT.


4. Miscellanous
   ------------


   

5. Credits
   -------
   
List of committers are:

Stephen Chin; Java Champion; http://www.nighthacking.com/
Sven Reimers; Netbeans Dream Team; http://wiki.netbeans.org/SvenReimers/
Peter Pilgrim; Java Champion, Specialist contractor JavaEE7, JavaFX, Scala; http://www.xenononique.co.uk/blog/ 


This documentation was prepared by:
    Peter Pilgrim
    Friday, 18 January 2013
    http://www.xenonique.co.uk/blog/
