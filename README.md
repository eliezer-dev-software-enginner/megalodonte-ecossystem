# Megalodonte example applications

This repository contains five small JavaFX desktop applications that demonstrate
the Megalodonte framework. Each example is a separate Gradle project. The
framework libraries are maintained outside this repository; they are not Git
submodules or included in a clone.

| App | Demonstrates |
| --- | --- |
| [Welcome](megalodonte-app1-welcome/) | Application bootstrap, theme and text |
| [Counter](megalodonte-app2-counter/) | Reactive state and button actions |
| [String length](megalodonte-app3-string-lenght/) | Inputs and computed state |
| [Hide and seek](megalodonte-app4-hide-seek/) | Conditional rendering |
| [Todo list](megalodonte-app5-todo-list/) | Reactive lists |

## Build and run

Install a Java 25 JDK. The example builds resolve Megalodonte dependencies from
the local Maven repository, so publish the required framework libraries there
before building an example. Those libraries and their installation scripts are
not part of this repository. The required dependency coordinates are listed in
each example's `build.gradle.kts`.

From an example directory, use its included Gradle wrapper:

```bash
./gradlew test shadowJar
./gradlew run
```

The `run` task additionally requires `JAVAFX_MODULES_HOME` to point to the
JavaFX modules described in the example's README. The build scripts select
Linux or Windows module paths; other operating systems are not configured for
this task. Each example also has a `packaging.toml`.

The [package workflow](.github/workflows/package.yml) invokes a reusable
workflow in `megalodonte-packaging` for each of the five examples when triggered
manually or by a `v*` tag. Packaging behavior is defined in that external
workflow.

## License

No license file is included in this repository. Licensing terms require review
by the project owner.
