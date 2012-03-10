#!/bin/bash
export JFX_HOME=$1
export OS=$2
mvn install:install-file -Dfile=$JFX_HOME/rt/lib/jfxrt.jar -DgroupId=com.oracle -DartifactId=javafx-runtime -Dversion=2.0-beta -Dpackaging=jar
cd $JFX_HOME/rt/bin
jar -cf bin.jar *.*lib i386
mvn install:install-file -Dfile=bin.jar -DgroupId=com.oracle -DartifactId=javafx-runtime -Dversion=2.0-beta -Dpackaging=jar -Dclassifier=$2
