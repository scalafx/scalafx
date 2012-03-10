#!/bin/bash
export JFX_HOME=$1
export OS=$2
mvn install:install-file -Dfile=$JFX_HOME/rt/lib/jfxrt.jar -DgroupId=com.oracle -DartifactId=javafx-runtime -Dversion=2.0-beta -Dpackaging=jar
jar -cf lib.jar $JFX_HOME/rt/lib/*.*lib $JFX_HOME/rt/lib/i386
mvn install:install-file -Dfile=lib.jar -DgroupId=com.oracle -DartifactId=javafx-runtime -Dversion=2.0-beta -Dpackaging=jar -Dclassifier=$2
