=== Building ScalaFX ===

The following software is needed to build ScalaFX:
  1) Mercurial (http://mercurial.selenic.com/)
  2) sbt (https://github.com/harrah/xsbt/wiki)

The steps to build ScalaFX at the command line are:

  1) Set the JAVAFX_HOME environment variable. 

    # for Bash
    export JAVAFX_HOME=/Path/To/javafx-sdk2.1.0-beta

  2) Check out the source code
    
    hg clone https://code.google.com/p/scalafx/

  3) Change to the scalafx directory

    cd scalafx

  4) Build using sbt

    sbt clean compile package make-pom package-src


=== Installing ScalaFX into your local Maven repository ===

If you use Maven and would like install ScalaFX into your local Maven
repository, run the following commands:

  cd scalafx/target

  mvn install:install-file -DartifactId=scalafx \
  -DgroupId=org.scalafx \
  -Dpackaging=jar \
  -DpomFile=scalafx-1.0-SNAPSHOT.pom \
  -Dfile=scalafx-1.0-SNAPSHOT.jar \
  -Dversion=1.0-SNAPSHOT \
  -Dsources=scalafx-1.0-SNAPSHOT-sources.jar

Once you've run this command you can include ScalaFX in your Maven projects
using:

    <dependency>
        <groupId>org.scalafx</groupId>
        <artifactId>scalafx</artifactId>
        <version>1.0-SNAPSHOT</version>
    </dependency>