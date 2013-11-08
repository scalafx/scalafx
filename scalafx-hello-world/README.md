scalafx-hello-world
===================

A basic ScalaFX project using [Simple-Build-Tool](http://www.scala-sbt.org/) (SBT).


Content
-------

src/main/scala/hello/ScalaFXHelloWorld.scala - sample ScalaFX application.

build.sbt - the main SBT configuration file.
project/build.properties - version of SBT to use.
project/plugins.sbt - plugins used for creation of IDEA and Eclipse projects.



How to build and Run
--------------------

1. Install [Java 7 JDK](http://www.oracle.com/technetwork/java/javase/downloads/index.html)

2. Create environment variable JAVA_HOME environment variable pointing to your 
   JFK installation

3. Install [SBT](http://www.scala-sbt.org/)

4. Run the example: change o directory containing this example and use SBT to 
   build and run the example:

    %> sbt run

   It will download needed dependencies, including Scala and ScalaFX, and run 
   the example code. 


Crete project for IDEA or Eclipse
--------------------------------- 

If you want to create project that can be used with IntelliJ IDEA, inside
this project directory, at command prompt type:

    %> sbt gen-idea


If you want to create project that can be used with Eclipse, inside
this project directory, at command prompt type:

    %> sbt eclipse


Additional Information
----------------------

Detailed description of similar example can be found in the blog post
["Getting Started with ScalaFX: Compile and Run"](http://codingonthestaircase.wordpress.com/2013/05/17/getting-started-with-scalafx-compile-and-run-2/).
