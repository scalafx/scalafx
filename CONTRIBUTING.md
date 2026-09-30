# Contributing to ScalaFX

Thank you for your interest in contributing to ScalaFX! Contributions of all kinds are welcome: bug reports, fixes,
new wrappers for JavaFX APIs, demos, and documentation improvements.

## Ways to Contribute

* **Questions and ideas** - use [ScalaFX Discussions](https://github.com/scalafx/scalafx/discussions).
* **Bug reports and feature requests** - use the [ScalaFX Issue Tracker](https://github.com/scalafx/scalafx/issues).
  For bugs, include the ScalaFX, JavaFX, JDK, and Scala versions, your OS, and a minimal code sample that shows the problem.
* **Code** - submit a pull request, see [Pull Requests](#pull-requests) below.
  For larger changes, open an issue or a discussion first, so the approach can be agreed on before you spend time on it.
* **Documentation** - the ScalaFX website source is in the
  [scalafx.github.io](https://github.com/scalafx/scalafx.github.io) repository.
* **Demos** - some demos in [scalafx-demos](scalafx-demos) are a bit out of date, help is welcome there.

## Software Required

The following software is needed to build ScalaFX:

1. [SBT](https://www.scala-sbt.org/) 2.x (currently 2.0.9). The SBT launcher picks up the version from
   `project/build.properties` automatically.
2. [Scala](https://www.scala-lang.org/). ScalaFX 27 is cross-built for Scala 3.3.8 (default), 2.13.18, and 2.12.21.
   SBT downloads the needed Scala versions automatically.
3. JDK 25 or newer, as required by [JavaFX 27](https://openjfx.io/highlights/27/).

The build works on Windows, macOS, and Linux.

## Building from Source

```shell
git clone https://github.com/scalafx/scalafx.git
cd scalafx
sbt compile           # compile with the default Scala version (3.3.8)
sbt test              # run tests
sbt +test             # run tests with all cross-built Scala versions
sbt ++2.13.18 test    # run tests with a specific Scala version
sbt +publishLocal     # publish all cross-built artifacts to the local repository
sbt +publishM2        # publish all cross-built artifacts to the local Maven repository (~/.m2)
sbt scalafxDemos/run  # choose and run one of the demos
```

Tests run JavaFX in headless mode (`-Dglass.platform=headless`), so no display or Xvfb is needed, including on CI.

To include class diagrams in the generated Scaladoc (`sbt doc`), set the `GRAPHVIZ_DOT_PATH` environment variable
to the full path of the [Graphviz](https://graphviz.org/) `dot` executable. Without it, Scaladoc is built without diagrams.

IntelliJ IDEA (with the Scala plugin) and VS Code (with Metals) can import the project directly from `build.sbt`.

## Project Structure

```
.
├── docs            images used in README.md
├── notes           release notes for past releases
├── project         SBT build setup and plugins
├── scalafx         the ScalaFX library
└── scalafx-demos   ScalaFX demo applications
```

In `scalafx` and `scalafx-demos`, code shared by all Scala versions is in `src/*/scala`.
Code specific to one Scala version is in `src/*/scala-2.12`, `src/*/scala-2.13`, or `src/*/scala-3`.

## Coding Guidelines

* **Cross-building** - the code must compile with Scala 3.3, 2.13, and 2.12. Shared sources use syntax accepted by all
  three versions (the Scala 2 compilers are run with `-Xsource:3`).
* **Formatting** - the code is formatted with [scalafmt](https://scalameta.org/scalafmt/) using `.scalafmt.conf`.
  Format the files you change, for instance with `sbt scalafmt` or in your IDE.
* **License header** - every source file starts with the BSD license header. Copy it from an existing file when you
  create a new one.
* **Tests** - add or update tests in `scalafx/src/test` for your changes. Tests use [ScalaTest](https://www.scalatest.org/).
* **Wrappers** - when wrapping a new JavaFX class, follow the patterns of existing wrappers in the same package: the
  `SFXDelegate` trait, implicit conversions in the companion object, and property wrappers.

## Pull Requests

1. Fork the repository and create a branch from `master`. Use a separate branch for each feature or bug fix.
2. Make your changes, with tests.
3. Make sure `sbt +test` passes. CI runs it for all Scala versions on JDK 25, 26, and 27.
4. Open a pull request against `master`. Reference the related issue, for instance `Fixes #123`.

Keep pull requests focused. Small, independent pull requests are easier to review and merge.

## Source Code Branching Policy

* Development happens on the `master` branch.
* Releases are done on the `stable` branch and tagged with the version number.
* Pull requests are only accepted off a branch created from the `master` branch.

The ScalaFX 8 and 2.2 development is no longer active.
For those who need it, the code is on branches `SFX-8` and `SFX-2`.
Past releases are on the `SFX-8-stable` and `SFX-2-stable` branches.

## Releasing (Maintainers)

### Update README.md

`README.md` contains version numbers in copy-paste snippets that need to be updated for each release.

1. Find the version numbers in `README.md`:
   ```shell
   grep -nE '[0-9]+\.[0-9]+\.[0-9]+-R[0-9]+|JDK [0-9]+|temurin:|javaFxVersion|version = "' README.md
   ```
2. Update the ScalaFX version (for instance, `27.0.0-R39`) in the SBT, Scala CLI, Mill, and Gradle snippets.
3. For a new JavaFX major version, also update the JavaFX version (Mill `javaFxVersion`, Gradle `javafx.version`)
   and the minimum JDK version (Quick Start text, Mill `jvmId`).
4. Add a row for the new release to the "Compatibility of Recent Versions" table.
   The minimum JDK version is given in the JavaFX release highlights, for instance https://openjfx.io/highlights/27/.
   Remove the oldest row, if the table gets too long.
5. After the release is available on Maven Central, run the "Hello ScalaFX" example with `scala-cli` to verify it.

## Code of Conduct

We ask everyone to follow the [Typelevel Code of Conduct](https://typelevel.org/code-of-conduct/) in all ScalaFX
community spaces: GitHub Discussions, issues, pull requests, and meetups.

## License

By contributing to ScalaFX, you agree that your contributions will be licensed under the
[BSD 3-Clause License](LICENSE.txt).
