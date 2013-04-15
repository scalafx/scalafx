// ========================================================================================
// ScalaFX 1.0.0 Project Multi-module for Scala Build Tool (SBT)
// Created by Peter Pilgrim, 16 January 2013
// peter dot pilgrim at gmail dot com
// ========================================================================================
// 

import sbt._
import Keys._
import scala.xml._
import java.net.URL

object ScalaFXBuild extends Build {
    import Dependencies._
    import Resolvers._
    
    lazy val scalafxSettings = Defaults.defaultSettings ++ Seq(
        organization := "org.scalafx",
        version := "1.0.0-M3-SNAPSHOT",
        crossScalaVersions := Seq( "2.9.3", "2.9.2",  "2.10.1" ),
        scalaVersion <<= (crossScalaVersions) { versions => versions.head },
        scalacOptions ++= Seq("-unchecked", "-deprecation", "-Xcheckinit", "-encoding", "utf8"),
        javacOptions ++= Seq("-target", "1.6", "-source", "1.6", "-Xlint:deprecation"),
        manifestSetting,
        publishSetting,
        resolvers ++= Seq( localMavenRepo, sonatypeNexusSnapshots )
    ) ++ mavenCentralSettings
    
    lazy val javaHome = {
        var j = System.getenv("JAVAFX_HOME")
        if ( j==null ) {
            j = System.getenv("JAVA_HOME")
            if (j==null) {
              throw new RuntimeException(
                  "SBT Failure: neither JAVAFX_HOME nor JAVA_HOME environment variables have been defined!"
              )
            }
        }
        val dir = new File(j) 
        if ( !dir.exists) {
            throw new RuntimeException("SBT Failure: no such directory found: "+ j)
        }
        println("**** detected Java/JDK Home is set to "+dir+"  ****")
        Some(j)
    }
        
    lazy val unmanagedListing = unmanagedJars in Compile += Attributed.blank(file(javaHome.get + "/jre/lib/jfxrt.jar" ))

    lazy val scalafxProject = Project(
        id = "scalafx-project",
        base = file("."),
        settings = scalafxSettings ++ doNotPublish ++ Seq(
            description := "The ScalaFX framework (root project)"
        ),
        aggregate = Seq( scalafx, scalafxDemos )
    )
    
    lazy val scalafx = Project(
        id = "scalafx",
        base = file("scalafx"),
        settings = scalafxSettings ++ Seq(
            libraryDependencies ++= Seq(
                scalatest % "test",
                junit % "test" ),
            unmanagedListing,
            description := "The ScalaFX framework"
        )
     )
    
    lazy val scalafxDemos = Project(
        id = "scalafx-demos",
        base = file("scalafx-demos"),
        settings = scalafxSettings ++ Seq(
            libraryDependencies ++= Seq(
                scalatest % "test",
                junit % "test" ),
            unmanagedListing,
            description := "The ScalaFX demonstrations",
            // fork a new JVM for 'test:run', but not 'test'
            fork in run := true,
            // add a JVM option to use when forking a JVM for 'run'
            javaOptions ++= Seq(
              "-Xmx512M",
              "-Djavafx.verbose"
            ),
            mainClass in (Compile, run) := Some("scalafx.ColorfulCircles")
        )
    ) dependsOn (
        scalafx % "compile;test->test"
    )
    
    
    object Dependencies {
        // Ordered by `group 'and then by `artifact ID'.
        lazy val junit              = "junit"                   % "junit"               % "4.10" 
        lazy val scalatest          = "org.scalatest"           %% "scalatest"          % "1.9.1" 
        // lazy val scalatest2: MID = sv => "org.scalatest" %% "scalatest" % scalatestVersion(sv)
 
        type MID = String => ModuleID
    }
    
    object Resolvers {
        val sonatypeNexusSnapshots = "Sonatype Nexus Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
        val sonatypeNexusReleases = "Sonatype Nexus Releases" at "https://oss.sonatype.org/content/repositories/releases"
        val sonatypeNexusStaging = "Sonatype Nexus Staging" at "https://oss.sonatype.org/service/local/staging/deploy/maven2"
        val localMavenRepo =  "Local Maven Repository" at "file://"+Path.userHome.absolutePath+"/.m2/repository"
    }

    lazy val manifestSetting = packageOptions <+= (name, version, organization) map {
        (title, version, vendor) =>
            Package.ManifestAttributes(
                "Created-By" -> "Simple Build Tool",
                "Built-By" -> Option(System.getenv("JAR_BUILT_BY")).getOrElse(System.getProperty("user.name")),
                "Build-Jdk" -> System.getProperty("java.version"),
                "Specification-Title" -> title,
                "Specification-Version" -> version,
                "Specification-Vendor" -> vendor,
                "Implementation-Title" -> title,
                "Implementation-Version" -> version,
                "Implementation-Vendor-Id" -> vendor,
                "Implementation-Vendor" -> vendor
            )
    }

    lazy val publishSetting = publishTo <<= (version) { version: String =>
        if (version.trim.endsWith("SNAPSHOT"))
            Some(sonatypeNexusSnapshots)
        else
            Some(sonatypeNexusStaging)
    }

    // Things we care about primarily because Maven Central demands them
    // See also http://maven.apache.org/pom.html#Developers
    lazy val mavenCentralSettings = Seq(
        homepage := Some(new URL("https://code.google.com/p/scalafx/")),
        startYear := Some(2011),
        licenses := Seq(("BSD", new URL("https://code.google.com/p/scalafx/source/browse/LICENSE.txt"))),
        pomExtra <<= (pomExtra, name, description) {(pom, name, desc) => pom ++ Group(
            <scm>
                <url>https://code.google.com/p/scalafx</url>
                <connection>scm:hg:https://code.google.com/p/scalafx</connection>
            </scm>
            <developers>
                <developer>
                    <id>rafael.afonso</id>
                    <name>Rafael Afonso</name>
                </developer>
                <developer>
                    <id>Alain.Fagot.Bearez</id>
                    <name>Alain Béarez</name>
                    <url>http://cua.li/TI/</url>
                </developer>
                <developer>
                    <id>steveonjava</id>
                    <name>Stephen Chin</name>
                    <url>http://www.nighthacking.com/</url>
                </developer>
                <developer>
                    <id>akauppi</id>
                    <name>Asko Kauppi</name>
                </developer>
                <developer>
                    <id>rladstaetter</id>
                    <name>Robert Ladstätter</name>
                </developer>
                <developer>
                    <id>peter.pilgrim</id>
                    <name>Peter Pilgrim</name>
                    <url>http://www.xenonique.co.uk/blog/</url>
                </developer>
                <developer>
                    <name>Matthew Pocock</name>
                </developer>
                <developer>
                    <id>sven.reimers</id>
                    <name>Sven Reimers</name>
                    <url>http://wiki.netbeans.org/SvenReimers/</url>
                </developer>
                <developer>
                    <id>jpsacha</id>
                    <name>Jarek Sacha</name>
                 </developer>
                <developer>
                    <name>Curtis Stanford</name>
                </developer>
            </developers>
        )}
    )

    lazy val doNotPublish = Seq(publish := {}, publishLocal := {})
}
