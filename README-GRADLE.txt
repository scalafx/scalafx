README    README    README    README    README    README    README    README    README    README    


                                                                  
  _|_|_|                      _|            _|_|_|_|  _|      _|  
_|          _|_|_|    _|_|_|  _|    _|_|_|  _|          _|  _|    
  _|_|    _|        _|    _|  _|  _|    _|  _|_|_|        _|      
      _|  _|        _|    _|  _|  _|    _|  _|          _|  _|    
_|_|_|      _|_|_|    _|_|_|  _|    _|_|_|  _|        _|      _|  
                                                                  
                                                                  

Building ScalaFX with Gradle
-------------------------------

NOTE: The recommended build setup for ScalaFX is using SBT, building with 
Gradle is supported, but may be possible :) 

This is the `README-GRADLE.txt ' file for ScalaFX 


1. Introduction
   ------------
   
For a more general introduction, please refer to `README.txt' for more
information. The documentation explains how to download the required software
for ScalaFX development.

This information was prepared using Gradle v1.3, which you can download from:
http://www.gradle.org/


2. Define Environment Variables
   ----------------------------

Define an environment variable `JAVA_HOME' that points to the JDK location.
Define an environment variable `JAVAFX_HOME' that points to the JDK location, if
you want to keep JAVA_HOME separate. `JAVAFX_HOME' takes priority over
`JAVA_HOME' in the Scala SBT build.

For Oracle Java SE JDK 7 builds, which are distributed with JavaFX 2.x, the
build checks for the presence of the `jfxrt.jar', which should be found under
`${JAVAFX_HOME}/jre/lib/jfxrt.jar' or `${JAVA_HOME}/jre/lib/jfxrt.jar'

In Unix, Mac OS X or Linux, you can define a environment variable `JAVAFX_HOME'
inside the Bash shell init login file at `~/.bash_profile':

    # for Bash
    export JAVAFX_HOME=/opt/java/jdk1.7.0_25


Alternatively, for the Bourne shell script, you can place this setting in the
shell init login file `~/.profile':

    # for Bourne Shell
    JAVAFX_HOME=/opt/java/jdk1.7.0_25
    export JAVAFX_HOME


For Windows 7 operating systems, you need to define an environment variable in
the Control Panel in the Systems application.

Setting `JAVAFX_HOME' is very useful, if you have more than one JDK installed on
your development workstation. For example, if you have a beta version of JDK 8
and still want to use JDK 7 for ScalaFX, then you have settings like this:

   JAVAFX_HOME=/Library/Java/JavaVirtualMachines/jdk1.7.0_25.jdk/Contents/Home
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


Execute the following commands to build ScalaFX with Gradle:

    % gradle clean build



4. Building ScalaFX with Gradle
   ----------------------------
   
To clean the build to its fresh, we execute:

    % gradle clean
    

To build all the ScalaFX projects, execute:

    % gradle build
    
    
To compile the ScalaFX Scala code, execute:

    % gradle compileScala
    

To run the unit tests, execute:
    
    % gradle test


5. Run the ScalaFX Demonstrations
   ------------------------------
   
The module `scalafx-demos' contains many demonstrations of the ScalaFX Framework.
There is one official standard demonstration, which the commiter have used to
test the build. It is called `scalafx.ColorfulCircles'.

Execute the following command line:

    % gradle scalafx-demos:run
    

6. Debugging The ScalaFX Multi-Project Build

The current version of Gradle build has some debug options.

From the root, directory execute the following:

    % gradle printInfo
    

This command will dump the project name, JavaFX runtime JAR location; and the
Maven Group, ArtifactId and Version coordinate.


6. Miscellanuous Gradle Commmands
   ------------------------------
   
The following Gradle command have proven very useful

    % gradle dependencies
    # Show the dependencies for the current Gradle build
    
    % gradle tasks
    # Show the executable tasks for the current Gradle build
    
    % gradle projects
    # Shows the multi-project tree of projects
    
    % gradle install
    # Performs of install of artifacts to a local repository
    

    % gradle :scalafx:clean
    % gradle :scalafx:compileScala
    % gradle :scalafx:build
    % gradle :scalafx:test
    # Project named qualified task only for the `scalafx' project.
    
    
7. Gradle Build Files
   -------------------

Here is a description of the Scala SBT files for the entire build process.


./build.gradle                     The Gradle build file for root ScalaFX project.
./settings.gradle                  Specifies the multi-module/sub projects for the Gradle build


This documentation was prepared by:
    The ScalaFX Open Source Developer team,
    Sunday, 20 January 2013
