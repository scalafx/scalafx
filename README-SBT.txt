README    README    README    README    README    README    README    README    README    README    



                                                                  
  _|_|_|                      _|            _|_|_|_|  _|      _|  
_|          _|_|_|    _|_|_|  _|    _|_|_|  _|          _|  _|    
  _|_|    _|        _|    _|  _|  _|    _|  _|_|_|        _|      
      _|  _|        _|    _|  _|  _|    _|  _|          _|  _|    
_|_|_|      _|_|_|    _|_|_|  _|    _|_|_|  _|        _|      _|  
                                                                  
                                                                  
Building ScalaFX with Scala SBT
-------------------------------


This is the README-SBT.txt for ScalaFX 


1. Introduction
   ------------
   
For a more general introduction, please refer to `README.txt' for more
information. The documentation explains how to download the required software
for ScalaFX development.

This information was prepared using Scala SBT version 0.12.2, which you can download
from: http://www.scala-sbt.org/


2. Define Environment Variables
   ----------------------------

Define an environment variable `JAVA_HOME' that points to the JDK location.
Define an environment variable `JAVAFX_HOME' that points to the JDK location, if
you want to keep JAVA_HOME separate. `JAVAFX_HOME' takes priority over
`JAVA_HOME' in the Scala SBT build.

For Oracle Java SE JDK 7 builds, which are distributed with JavaFX 2.2.x, the
build checks for the presence of the `jfxrt.jar', which should be found under
`${JAVAFX_HOME}/jre/lib/jfxrt.jar' or `${JAVA_HOME}/jre/lib/jfxrt.jar'

In Unix, Mac OS X or Linux, you can define a environment variable `JAVAFX_HOME'
inside the Bash shell init login file at `~/.bash_profile':

    # for Bash
    export JAVAFX_HOME=/opt/java/jdk1.7.0_11


Alternatively, for the Bourne shell script, you can place this setting in the
shell init login file `~/.profile':

    # for Bourne Shell
    JAVAFX_HOME=/opt/java/jdk1.7.0_11
    export JAVAFX_HOME


For Windows 7 operating systems, you need to define an environment variable in
the Control Panel in the Systems application.

Setting `JAVAFX_HOME' is very useful, if you have more than one JDK installed on
your development workstation. For example, if you have a beta version of JDK 8
and still want to use JDK 7 for ScalaFX, then you have settings like this:

   JAVAFX_HOME=/Library/Java/JavaVirtualMachines/jdk1.7.0_11.jdk/Contents/Home
   JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0.jdk/Contents/Home



3. Checkout Source Code
   ---------------------
   
If you do not have the source code, then use Mercurial to checkout the code
base. Open a command line terminal with a shell, and type:

    % hg clone https://code.google.com/p/scalafx/

( Where % character represents the command line shell prompt for your operating
system.)

Change to the scalafx directory:

    % cd scalafx


Build the software with SBT:

    % sbt clean compile package make-pom package-src


This should build the entire code base; run the tests; package up the JAR files,
source and binary files; and generate a Maven POM.


4. Using SBT Interatively
   ----------------------

Start Scala SBT at the command line:

    % sbt
    
List the individual tree of projects and their version number:

    sbt> show version
    [info] scalafx-core/*:version
    [info] 	1.0-SNAPSHOT
    [info] scalafx-demos/*:version
    [info] 	1.0-SNAPSHOT
    [info] scalafx/*:version
    [info] 	1.0-SNAPSHOT
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

    # navigate to the `scalafx-core' module
    sbt> project scalafx-core
    sbt> projects

    # navigate to the `scalafx-core' module
    sbt> project scalafx-demos
    sbt> projects

    # navigate to back to the root module again
    sbt> project /
    sbt> projects


Generate IntelliJ IDEA project files:

    % sbt gen-idea
or
    sbt> gen-idea


Generate Eclipse project files:
 
    % sbt eclipse
or
    sbt> eclipse

The Eclipse Plugin generates the files: scalafx-core/.project, scalafx-core/.classpath
and the files scalafx-demos/.project, scalafx-demos/.classpath


Miscellaneous SBT commands:

    sbt> about
    sbt> show resolvers
    sbt> show unmanged-jars


For more information, on Scala SBT and Multi-Module builds, point your favourite
web browser to:
http://www.scala-sbt.org/release/docs/Getting-Started/Multi-Project.html


5. Running the Demonstration
   -------------------------
   
The module `scalafx-demos' contains many demonstrations of the ScalaFX core.
There is one official standard demonstration, which the commiter have used to
test the build. It is called `scalafx.ColorfulCircles'.

Run Scala SBT, interactively. First switch to the `scalafx-demos' project, then
execute the `run' task:

    sbt> project scalafx-demos
    sbt> run
    

This should launch the demonstration ScalaFX program. To exit the application,
simply close the program using your normal window manager decorations.

What if you want to run the demonstration from the command line? You can do it.
Let's assume you are in the root directory of the scalafx project. Execute the
following command line:

    % sbt scalafx-demos/run
    
This should launch the demonstration ScalaFX program.



6. Publishing SBT Artifacts Locally
   --------------------------------
   
SBT can publish artifacts to local repository using the task `publish-local'.
Here is the command line:

    % sbt publish-local
   

This will push the ScalaFX artifacts to your local Ivy Repository under
`${HOME}/.ivy', which is completely fine if your dependent project only ever
relies on Scala SBT.

If you want to generate artifacts for Maven then you need to manually install at
the moment. Sorry about that. Here are the necessaey commands:

    % sbt make-pom
    % mvn install:install-file -DartifactId=scalafx_2.9.2 \
    -DgroupId=org.scalafx \
    -Dpackaging=jar \
    -DpomFile=scalafx-core_2.9.2-1.0-SNAPSHOT.pom \
    -Dfile=scalafx-core_2.9.2-1.0-SNAPSHOT.jar \
    -Dversion=1.0-SNAPSHOT \
    -Dsources=scalafx-core_2.9.2-1.0-SNAPSHOT-sources.jar


Sadly, you will to repeat this for all the modules, until an automated method is
found for Scala SBT. Please note the embedded Scala compiler version in the
artifact name e.g. `scalafx-core_2.9.2'


7. SBT Configuration
   -----------------
   
I found the following SBT launcher bash shell script worked for me under Mac OS
X 10.8. I had to increase the memory of the JVM from -Xss1M to -Xss2M and set
the permanent generation size to 512M. I also force set the JDK home in this
following example of the `sbt' shell script.


    #!/bin/bash 
    # SBT launch file (Peter Pilgrim)
    # http://www.scala-sbt.org/release/docs/Getting-Started/Setup.html#manual-installation
    # based on SBT 0.12.2
    export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.7.0_11.jdk/Contents/Home
    export PATH=${JAVA_HOME}/bin:${JAVA_HOME}/jre/bin:${PATH}
    java -Xms512M -Xmx1536M -Xss2M -XX:+CMSClassUnloadingEnabled -XX:MaxPermSize=512M -jar `dirname $0`/sbt-launch.jar "$@"
    # End.


Of course, your mileage will indeed vary on your own workstation.



8. SBT Build Files
   ----------------

Here is a description of the Scala SBT files for the entire build process.


./project/build.scala              The build file for ScalaFX lives.
./project/build.properties         Specifies the Scala SBT version for the build.
./project/plugin.sbt               Defines additional plug-ins necessary for the build 



9. Cross Versions
   --------------
   
Cross Scala Versions is a feature of the Scala SBT to build against different
versions of the Scala Libraries. This is enabled in the `project/build.scala'
file with settings of `crossScalaVersions', which is set to something like this:

    crossScalaVersions := Seq( "2.9.2", "2.10.0" ),


You can switch between different Scala build version in interactive mode of
Scala SBT, using the `++' command.

Here is how to do this, first look at the current build settings for SBT, invoke
the command:

    sbt> settings
    # Observe the setting for `scala-version'
    

Now show the current value for `scala-version', with the command:

    sbt> show scala-version
    [info] scalafx-core/*:scala-version
    [info] 	2.9.2
    [info] scalafx-demos/*:scala-version
    [info] 	2.9.2
    [info] scalafx/*:scala-version
    [info] 	2.9.2    
    

Now switch to Scala 2.10.0 with the following command:

     sbt> ++ 2.10.0


And then build the software from a clean state for Scala 2.10.0 with the
following commands:

     sbt> clean
     sbt> package
     sbt> javafx-demos/run


You switch back to the original 2.9.2 build as well with the commands:

     sbt> ++ 2.9.2
     sbt> javafx-demos/run


Now, you should have both working 2.9.2 and 2.10.0 versions of ScalaFX. Exit
Scala SBT check the `target' folder:

     % ls ~/IdeaProjects/scalafx/target
     resolution-cache/	   scala-2.10/	   scala-2.9.2/	  streams/
     % ls ~/IdeaProjects/scalafx/target/scala-2.10/
     cache/	           scalafx_2.10-1.0-SNAPSHOT.jar
     % ls ~/Documents/IdeaProjects/scalafx/target/scala-2.9.2/
     cache/                scalafx_2.9.2-1.0-SNAPSHOT.jar


And of course this feature of cross Scala versions scales to more compiler
libraries, when the Lausanne delivers them, and provided the ScalaFX code all
compiles, builds and runs against them!

For more information, about cross scala version, see the official documentation
on Scala SBT:
http://www.scala-sbt.org/release/docs/Detailed-Topics/Cross-Build.html


Have Fun!     
--

This documentation was prepared by:
    The ScalaFX Open Source Developer team,
    Friday, 18 January 2013
