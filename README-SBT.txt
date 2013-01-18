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

For Oracle Java SE JDK 7 builds, which are distributed with JavaFX 2.x, the
build checks for the presence of the `jfxrt.jar', which should be found under
`${JAVAFX_HOME}/jre/lib/jfxrt.jar' or `${JAVA_HOME}/jre/lib/jfxrt.jar'

In Unix, Mac OS X or Linux, you can define a environment variable like this:

    # for Bash
    export JAVAFX_HOME=/Path/To/javafx-sdk2.1.0-beta

You can place this setting in a `~/.bash_profile'.

For Windows 7 operating systems, you need to define an environment variable in
the Control Panel in the Systems application.

Setting `JAVAFX_HOME' is very useful, if you have more than one JDK installed on
your development workstation. For example, if you have a beta version of JDK 8
and still want to use JDK 7 for ScalaFX, then you have settings like this:

   JAVAFX_HOME=/Library/Java/JavaVirtualMachines/jdk1.7.0_09.jdk/Contents/Home
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


This should build the entire code base.


4. Using SBT Interatively
   ----------------------

Start Scala SBT at the command line:

    % sbt
    
List the projects:

    sbt> versions

(Where `sbt>' represents the Scala SBT interactive command line prompt)
    

Clean the build:

    sbt> clean
    

Compile the build:

    sbt> compile
    

Run the unit tests:

    sbt> test
    

Navigate around the Scala SBT multiple modules:

    # show information about the root module project    
    sbt>projects
    sbt>project

    # navigate to the `scalafx-core' module
    sbt> project scalafx-core
    sbt> projects

    # navigate to the `scalafx-core' module
    sbt> project scalafx-demos
    sbt> projects

    # navigate to back to the root modile again
    sbt> project /
    sbt> projects


Generate Intellij IDEA project files:

    sbt> gen-idea



Miscellanouse SBT commands:

    sbt> about
    sbt> show resolvers
    sbt> show unmanged-jars


For more information, on Scala SBT and Multi-Module builds, point your favourite
web browser to:
http://www.scala-sbt.org/release/docs/Getting-Started/Multi-Project.html

5. Publishing SBT Artifacts Locally
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


6. SBT Configuration
   -----------------
   
I found the following SBT launcher bash shell script worked for me under Mac OS
X 10.8. I had to increase the memory of the JVM from -Xss1M to -Xss2M and set
the permanent generation size to 512M. I also force set the JDK home in this
following example of the `sbt' shell script.


    #!/bin/bash 
    # SBT launch file (Peter Pilgrim)
    # http://www.scala-sbt.org/release/docs/Getting-Started/Setup.html#manual-installation
    # based on SBT 0.12.2
    export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.7.0_09.jdk/Contents/Home
    export PATH=${JAVA_HOME}/bin:${JAVA_HOME}/jre/bin:${PATH}
    java -Xms512M -Xmx1536M -Xss2M -XX:+CMSClassUnloadingEnabled -XX:MaxPermSize=512M -jar `dirname $0`/sbt-launch.jar "$@"
    # End.


Of course, your mileage will indeed vary on your own workstation.



This documentation was prepared by:
    Peter Pilgrim
    Friday, 18 January 2013
    http://www.xenonique.co.uk/blog/
