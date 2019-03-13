# Robolibj
[![Download](https://api.bintray.com/packages/team4230/maven/RobolibJ/images/download.svg)](https://bintray.com/team4230/maven/RobolibJ/_latestVersion)
[![Build Status](https://travis-ci.com/FRCTeam4230/RobolibJ.svg?branch=master)](https://travis-ci.com/FRCTeam4230/RobolibJ)

A collection of utility classes for FRC robots.

## Installing

There are two main options for using this library. It can either be vendored and
updated manually, or managed through gradle and updated automatically.

### Gradle (Recommended)

1. Add the team4230 maven repo to your `build.gradle` in the `repositories` section:

    ```groovy
    repositories {
        // your other repos 
        // ...
        // Team 4230 Maven repo
        maven {
            url  "https://dl.bintray.com/team4230/maven"
        }
    }
    ```

2. Add the library to your dependencies in `build.gradle` (replace version with
   a proper version identifier):
    ```groovy
    dependencies {
        implementation 'org.team4230:RobolibJ:VERSION'
    }
    ```
3. Rebuild to update dependencies:
    ```bash
    $ ./gradlew build
    ``` 

### Vendored Source

1. Download repo as an [archive](https://github.com/FRCTeam4230/RobolibJ/archive/master.zip)
2. Place `src/main/java/org/team4230/lib` into your project at `$SRCDIR/org/team4230`

### Vendored Jar

1. Download the `RobolibJ` jar from [bintray](https://bintray.com/team4230/maven/RobolibJ/_latestVersion).
  (pick the `RobolibJ-<VERSION>.jar` file)
2. Place jar into the classpath for the project.

## Development

### Getting started

1. Update dependencies and compile the library with
    ```bash
    $ ./gradlew build
    ```
   (This step requires an internet connection.)
2. Generate `source` and `javadoc` jars with
    ```bash
    ./gradlew sourceJar javadocJar
    ```
3. Check `build/lib` directory for generated jar files. Verify that they contain
   the correct classes and metadata.
   
### Project Structure

`src/main/java/org/team4230/lib` is the main project directory.

### Releasing

Team 4230 uses JFrog Bintray for Maven jar management. Thus, releasing new versions
requires access to the team Bintray. To make a release:

1. Set the environment variables `BINTRAY_USER` to your Bintray username and
   `BINTRAY_KEY` to your Bintray api key. Alternately, create a file named 
   `gradle.properties` in the project root (next to the `build.gradle`) with
   the contents:
    ```
    bintrayUser = BINTRAY_USERNAME
    bintrayKey = BINTRAY_API_KEY
    ```
2. Bump the version number in `build.gradle`
3. Run
    ```bash
    ./gradlew bintrayUpload
    ```