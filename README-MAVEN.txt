README    README    README    README    README    README    README    README    README    README




  _|_|_|                      _|            _|_|_|_|  _|      _|
_|          _|_|_|    _|_|_|  _|    _|_|_|  _|          _|  _|
  _|_|    _|        _|    _|  _|  _|    _|  _|_|_|        _|
      _|  _|        _|    _|  _|  _|    _|  _|          _|  _|
_|_|_|      _|_|_|    _|_|_|  _|    _|_|_|  _|        _|      _|



This project build relies on SBT, but you can get the scalafx-core libraries like this in
your local repository:

# execute this commands on the command line
sbt clean compile package make-pom package-src make-pom

# if you work with scala 2.10 (at your own risk)
mvn install:install-file -DartifactId=scalafx_2.10 \
    -DgroupId=org.scalafx \
    -Dpackaging=jar \
    -DpomFile=scalafx-core/target/scala-2.10/scalafx-core_2.10-1.0-SNAPSHOT.pom \
    -Dfile=scalafx-core/target/scala-2.10/scalafx-core_2.10-1.0-SNAPSHOT.jar \
    -Dversion=1.0-SNAPSHOT \
    -Dsources=scalafx-core/target/scala-2.10/scalafx-core_2.10-1.0-SNAPSHOT-sources.jar

# or, if you work with scala 2.9.2 (officially supported)
mvn install:install-file -DartifactId=scalafx_2.9.2 \
    -DgroupId=org.scalafx \
    -Dpackaging=jar \
    -DpomFile=scalafx-core/target/scala-2.9.2/scalafx-core_2.9.2-1.0-SNAPSHOT.pom \
    -Dfile=scalafx-core/target/scala-2.9.2/scalafx-core_2.9.2-1.0-SNAPSHOT.jar \
    -Dversion=1.0-SNAPSHOT \
    -Dsources=scalafx-core/target/scala-2.9.2/scalafx-core_2.9.2-1.0-SNAPSHOT-sources.jar

You can change the scala version in project/build.scala, search for scalaversion variable.

You'll want to reference the artifacts like this:

for scala 2.9.2:

		<dependency>
			<groupId>org.scalafx</groupId>
			<artifactId>scalafx_2.9.2</artifactId>
			<version>1.0-SNAPSHOT</version>
		</dependency>

and for scala 2.10:

		<dependency>
			<groupId>org.scalafx</groupId>
			<artifactId>scalafx_2.10</artifactId>
			<version>1.0-SNAPSHOT</version>
		</dependency>

# generate eclipse project files via

sbt eclipse

happy coding!

