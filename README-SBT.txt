README    README    README    README    README    README    README    README    README    README    



                                                                  
  _|_|_|                      _|            _|_|_|_|  _|      _|  
_|          _|_|_|    _|_|_|  _|    _|_|_|  _|          _|  _|    
  _|_|    _|        _|    _|  _|  _|    _|  _|_|_|        _|      
      _|  _|        _|    _|  _|  _|    _|  _|          _|  _|    
_|_|_|      _|_|_|    _|_|_|  _|    _|_|_|  _|        _|      _|  
                                                                  
                                                                  
Building ScalaFX with Scala SBT
-------------------------------

1. Introduction
   ------------
   
For a more general introduction, please refer to `README.txt' for more
information. The documentation explains how to download the required software
for ScalaFX development.

There are two branches of ScalaFX: v.2.2.* supporting JavaFX 2.x (Java 7) and 
ScalaFX v.8.0 supporting JavaFX 8 (Java 8).

This information was prepared using Scala SBT version 0.13.5, which you can download
from: http://www.scala-sbt.org/


2. Checkout Source Code
   ---------------------
   
If you do not have the source code, then use Mercurial to checkout the code
base. Open a command line terminal with a shell, and type:

    % hg clone https://code.google.com/p/scalafx/

( Where % character represents the command line shell prompt for your operating
system.)

Change to the scalafx directory:

    % cd scalafx

It is always a good practice to start by cleaning the build directories:

    % sbt clean

To run tests:

    % sbt test

To build jars:

    % sbt package

To publish to a local repository:

    % sbt publish-local

This should build the entire code base; package up the JAR files,
source and binary files; and publish them in local Ivy repository (~/.ivy).


3. Using SBT Interactively
   ----------------------

Start Scala SBT at the command line:

    % sbt
    
List the individual tree of projects and their version number:

    sbt> show version
    [info] scalafx/*:version
    [info] 	2.2.76-R11
    [info] scalafx-demos/*:version
    [info] 	2.2.76-R11
    [info] scalafx-project/*:version
    [info] 	2.2.76-R11
    (Where `sbt>' represents the Scala SBT interactive command line prompt)
    

Clean the build:

    sbt> clean
    

Compile the build:

    sbt> compile
    

Run the unit tests:

    sbt> test
    

Navigate around the Scala SBT multiple modules:

    # show information about the root module project    
    sbt> projects
    sbt> project

    # navigate to the `scalafx' module
    sbt> project scalafx
    sbt> projects

    # navigate to the `scalafx-demos' module
    sbt> project scalafx-demos
    sbt> projects

    # navigate to back to the root module again
    sbt> project /
    sbt> projects


Miscellaneous SBT commands:

    sbt> about
    sbt> show resolvers
    sbt> show unmanged-jars


For more information, on Scala SBT and Multi-Module builds, point your favourite
web browser to:
http://www.scala-sbt.org/release/docs/Getting-Started/Multi-Project.html

4. Using IDEs
   ----------

Both IntelliJ IDEA with Scala plugin and NetBeans with it's Scala plugin can import
project from the build.sbt file.

If you want to use Eclipse you can generate project files using SBT:

    % sbt eclipse
or
    sbt> eclipse

The Eclipse Plugin generates the files: scalafx/.project, scalafx/.classpath
and the files scalafx-demos/.project, scalafx-demos/.classpath

5. Running the Demonstration
   -------------------------
   
The module `scalafx-demos' contains many demonstrations of the ScalaFX Framework.
There is one official standard demonstration, which the committers have used to
test the build. It is called `scalafx.ColorfulCircles'.

Run Scala SBT, interactively. First switch to the `scalafx-demos' project, then
execute the `run' task:

    sbt> project scalafx-demos
    sbt> run

This will list available demos. To start a demo type in the demo number at the "Enter number:"
prompt. To exit the application, simply close the program using your normal window
manager decorations.

What if you want to run the demonstration from the command line? You can do it.
Let's assume you are in the root directory of the scalafx project. Execute the
following command line:

    % sbt scalafx-demos/run
    
This the "Enter number:" prompt, as described above.

6. Publishing SBT Artifacts Locally
   --------------------------------
   
SBT can publish artifacts to local repository using the task `publish-local'.
Here is the command line:

    % sbt publish-local
   

This will push the ScalaFX artifacts to your local Ivy Repository under
`${HOME}/.ivy', which is completely fine if your dependent project only ever
relies on Scala SBT.

If you want to generate artifacts for Maven then you need to manually install at
the moment. Here are the necessary commands:

    % sbt make-pom
    % mvn install:install-file -DartifactId=scalafx_2.9.3 \
    -DgroupId=org.scalafx \
    -Dpackaging=jar \
    -DpomFile=scalafx_2.9.3-2.2.76-R11.pom \
    -Dfile=scalafx_2.9.3-2.2.76-R11.jar \
    -Dversion=1.0-SNAPSHOT \
    -Dsources=scalafx_2.9.3-2.2.76-R11-sources.jar


You will to repeat this for all the modules. Please note the embedded Scala
compiler version in the artifact name e.g. `scalafx_2.9.3'


7. SBT Configuration on Mac
   ------------------------
   
The following SBT launcher bash shell script worked under Mac OS
X 10.8. Had to increase the memory of the JVM from -Xss1M to -Xss2M and set
the permanent generation size to 512M. Force set the JDK home in this
following example of the `sbt' shell script.


    #!/bin/bash 
    # SBT launch file (Peter Pilgrim)
    # http://www.scala-sbt.org/release/docs/Getting-Started/Setup.html#manual-installation
    # based on SBT 0.13.5
    export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.7.0_67.jdk/Contents/Home
    export PATH=${JAVA_HOME}/bin:${JAVA_HOME}/jre/bin:${PATH}
    java -Xms512M -Xmx1536M -Xss2M -XX:+CMSClassUnloadingEnabled -XX:MaxPermSize=512M -jar `dirname $0`/sbt-launch.jar "$@"
    # End.

Of course, your mileage will indeed vary on your own workstation.

8. SBT Build Files
   ----------------

Here is a description of the Scala SBT files for the entire build process.


./build.sbt                   The build file for ScalaFX lives.
./project/build.properties    Specifies the Scala SBT version for the build.
./project/plugin.sbt          Defines additional plug-ins necessary for the build


9. Cross Versions
   --------------
   
Cross Scala Versions is a feature of the Scala SBT to build against different
versions of the Scala Libraries. This is enabled in the `project/build.scala'
file with settings of `crossScalaVersions', which is set to something like this:

    crossScalaVersions := Seq( "2.10.4",  "2.11.5"),


You can switch between different Scala build version in interactive mode of
Scala SBT, using the `++' command.

Here is how to do this, first look at the current build settings for SBT, invoke
the command:

    sbt> settings
    # Observe the setting for `scala-version'
    

Now show the current value for `scala-version', with the command:

    sbt> show scala-version
    [info] scalafx/*:scala-version
    [info] 	2.10.4
    [info] scalafx-demos/*:scala-version
    [info] 	2.10.4
    [info] scalafx-project/*:scala-version
    [info] 	2.10.4
    

Now switch to Scala 2.11.5 with the following command:

     sbt> ++ 2.11.5


And then build the software from a clean state for Scala 2.10.3 with the
following commands:

     sbt> clean
     sbt> package
     sbt> scalafx-demos/run


You switch back to the original 2.10.4 build as well with the commands:

     sbt> ++ 2.10.4
     sbt> scalafx-demos/run


Now, you should have both working 2.9.3 and 2.10.3 versions of ScalaFX. Exit
Scala SBT check the `target' folder:

     % ls scalafx/target
     resolution-cache/	   scala-2.10/	   scala-2.11/	  streams/
     % ls scalafx/target/scala-2.10/
     cache/	           scalafx_2.10-2.2.76-R11.jar
     % ls scalafx/target/scala-2.11/
     cache/            scalafx_2.11-2.2.76-R11.jar


And of course this feature of cross Scala versions scales to more compiler
libraries, when the Lausanne delivers them, and provided the ScalaFX code all
compiles, builds and runs against them!

For more information, about cross scala version, see the official documentation
on Scala SBT:
http://www.scala-sbt.org/release/docs/Detailed-Topics/Cross-Build.html


Have Fun!
