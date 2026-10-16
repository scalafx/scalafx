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

Releases are made from the `stable` branch with [sbt-release](https://github.com/sbt/sbt-release).
Development happens on `master`. For a release, `master` is merged into `stable`, the release is made on `stable`,
then `stable` is merged back into `master`, where the next development (`-SNAPSHOT`) version is set.

`sbt release` tests, publishes to Maven Central, and updates version numbers in files.
It does not commit, tag, merge, or push, those steps are done manually, `sbt release` prints the commands at the end.

The current version is in `version.sbt`, do not edit it manually.

### Prerequisites

- PGP key for signing artifacts, see [sbt-pgp](https://github.com/sbt/sbt-pgp).
  Check that signing works with `sbt checkSigning`, it signs a temporary file with the same setup as the release.
- Sonatype Central Portal credentials, `SONATYPE_USERNAME` and `SONATYPE_PASSWORD` environment variables,
  or credentials for `central.sonatype.com` in global sbt settings. Note that sbt 2 reads global settings from
  `~/.config/sbt/2/*.sbt`, not from `~/.sbt/1.0`.
- Local `master` and `stable` branches tracking `master` and `stable` on GitHub.

### Release notes

Before the release, write the release notes, `notes/<version>.md`, for instance, `notes/27.0.0-R39.md`,
and commit them to `master`. Use notes of the previous release as a template.
The release aborts if the notes are missing or do not state the JavaFX version and the minimum Java version.
Their opening paragraphs have to include, with the actual versions:

```markdown
This release supports [JavaFX 27]. ...

Note that [JavaFX 27 requires Java **25 or later**][JavaFX 27]. ...
```

The JavaFX version has to match the release version, `27` for `27.0.0-R39`.
The minimum Java version is given in the JavaFX release highlights, for instance https://openjfx.io/highlights/27/.
The release uses these versions to update `README.md`.
The notes are also the description of the GitHub release, see [Complete the release](#complete-the-release).

### For a new JavaFX major version

Before the release, update `javaFXVersion` in `build.sbt` and commit it to `master`.
If the new JavaFX requires a newer Java version, update `javaRelease` in `build.sbt` too; it sets `-release` and
the JDK version of API doc links.
`README.md` is updated by the release, see below. Remove the oldest row from its compatibility table,
if the table gets too long.

### Merge `master` into `stable`

```shell
git checkout master
git pull
git checkout stable
git pull
git merge master
```

Resolve conflicts, if any, and commit the merge.
Do not push `stable` yet, push it after the release is published.

Before starting the release, the working tree has to be clean, `git status` shows "nothing to commit, working tree clean".
The release aborts if there are modified, staged, or untracked files, files ignored by `.gitignore` are fine.

### Make the release

On the `stable` branch, run:

```shell
sbt "release with-defaults"
```

The default release version removes `-SNAPSHOT` and keeps the release number,
the next development version increments the release number, for instance:
`27.0.0-R39-SNAPSHOT` → release `27.0.0-R39` → next `27.0.0-R40-SNAPSHOT`.

If the JavaFX version changed, provide the release version on the command line,
the next version will be derived from it:

```shell
sbt "release release-version 27.0.1-R39"
```

Do not run plain `sbt release`, it asks for the versions interactively, and the sbt 2 client does not pass
the answers to the sbt server, the release waits forever. If that happens, stop it with Ctrl+C and `sbt shutdown`.

Actions performed by the `release` command:

1. Checks that the working tree is clean, that the current branch is `stable`, that `master` is merged into it,
   that local `master` and `stable` are not behind GitHub, and that Central Portal credentials are set.
2. Checks that release notes `notes/<version>.md` exist and reads JavaFX and minimum Java versions from them.
3. Checks that artifacts can be signed (`checkSigning`), before the long test and publish steps.
4. Runs tests for all Scala versions.
5. Sets the release version in `version.sbt`.
6. Publishes signed artifacts for all Scala versions to Maven Central,
   waits until the Central Portal validates and publishes them.
7. Updates `README.md`: the ScalaFX version in snippets, JavaFX and JDK versions in the Mill and Gradle snippets
   and in the Quick Start text, and the compatibility table. For the same JavaFX major version, the table row
   is updated, for a new JavaFX major version, a row is added.
8. Prints git commands that complete the release, with the actual versions, tag, and remote names.

### Complete the release

Run the git commands printed at the end of `sbt release`. Review the changes (`git diff`) before committing.
For instance, for release `27.0.0-R39`:

```shell
# Commit and tag the release on 'stable'
git commit -am "Mark release version 27.0.0-R39"
git tag -a v.27.0.0-R39 -m "Releasing 27.0.0-R39"
git push origin stable v.27.0.0-R39  # the tag push creates the GitHub release

# Merge 'stable' into 'master' and set the next development version
git checkout master
git merge --no-ff --no-edit stable
printf 'ThisBuild / version := "%s"\n' 27.0.0-R40-SNAPSHOT > version.sbt
git commit -am "Mark the next development release 27.0.0-R40-SNAPSHOT"
git push origin master
```

The next development version is the release version with the release number incremented and `-SNAPSHOT` added.

Pushing the release tag starts the "GitHub Release" workflow (`.github/workflows/release.yml`). It creates
a GitHub release `Release v.<version>` with the release notes, `notes/<version>.md`, as the description,
and a discussion for it in the "General" category. If the workflow fails, create the release manually:

```shell
gh release create v.27.0.0-R39 --verify-tag --title "Release v.27.0.0-R39" \
  --notes-file notes/27.0.0-R39.md --discussion-category "General"
```

### If the release fails

When a step fails, the release stops and prints a summary as the last error messages:
which step failed, why, and what has to be done before running the release again, for instance:

```
[error] RELEASE 27.0.0-R39 FAILED at step 11/13, upload to Central (sonaRelease)
[error]   Reason: deployment <deploymentId> failed with validation errors
[error]   Artifacts may be uploaded, check https://central.sonatype.com/publishing/deployments
[error]   and drop a deployment that failed or was not published: sbt "sonaDrop <deploymentId>"
[error]   version.sbt is set to the release version, revert it: git checkout -- version.sbt
[error]   Fix the problem and run the release again.
```

`sbt release` does not change git, a failure leaves only uncommitted changes to `version.sbt` (and `README.md`).

1. If the Central Portal validation failed, the error message contains the deployment ID,
   `deployment <deploymentId> failed with validation errors`. Drop the failed deployment:
   ```shell
   sbt "sonaDrop <deploymentId>"
   ```
2. Revert the uncommitted changes:
   ```shell
   git checkout -- version.sbt README.md
   ```
3. Fix the problem and run `sbt release` again.

### After the release

After the release is available on Maven Central, run the "Hello ScalaFX" example with `scala-cli` to verify it.

## Code of Conduct

We ask everyone to follow the [Typelevel Code of Conduct](https://typelevel.org/code-of-conduct/) in all ScalaFX
community spaces: GitHub Discussions, issues, pull requests, and meetups.

## License

By contributing to ScalaFX, you agree that your contributions will be licensed under the
[BSD 3-Clause License](LICENSE.txt).
