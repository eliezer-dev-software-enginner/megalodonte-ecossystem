# Megalodonte Hide and Seek

Demonstrates conditional rendering. This desktop example uses the native Megalodonte CLI project structure.

## Run

Install JDK 25 and publish the matching Megalodonte dependencies to Maven Local as described in the [ecosystem guide](../README.md#create-your-first-desktop-application). From this directory:

```sh
./gradlew build
./gradlew run
```

The generated Gradle build resolves JavaFX through its plugin; no `JAVAFX_MODULES_HOME` setup is required. The application needs a graphical environment.

## Package

Install [megalodonte-packaging](https://github.com/eliezer-dev-software-enginner/megalodonte-packaging), then use `python3 scripts/package.py build appimage` on Linux. The shared [packaging workflow](../.github/workflows/package.yml) builds all examples.
