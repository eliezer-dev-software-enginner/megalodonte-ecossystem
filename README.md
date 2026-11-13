<p align="center">
  <img src="docs/images/megalodonte-logo.png" width="180" alt="Megalodonte logo">
</p>

# Megalodonte example applications

This repository contains five small JavaFX desktop applications that demonstrate
the Megalodonte framework. Each example is a separate Gradle project. The
framework libraries are maintained outside this repository; they are not Git
submodules or included in a clone.

## Explore the framework

| Repository | Purpose |
| --- | --- |
| [CLI](https://github.com/eliezer-dev-software-enginner/megalodonte-cli) | Generate desktop, Android and Roku applications. |
| [Core](https://github.com/eliezer-dev-software-enginner/megalodonte-core) | Shared state, theme contracts and platform-independent primitives. |
| [Base](https://github.com/eliezer-dev-software-enginner/megalodonte-base) | Desktop application bootstrap, component contracts, lifecycle and JavaFX integration. |
| [Components](https://github.com/eliezer-dev-software-enginner/megalodonte-components) | Reusable desktop controls and layouts. |
| [Theme](https://github.com/eliezer-dev-software-enginner/megalodonte-theme) | Default theme and a starting point for custom themes. |
| [Reactivity](https://github.com/eliezer-dev-software-enginner/megalodonte-reactivity) and [portable reactivity](https://github.com/eliezer-dev-software-enginner/megalodonte-reactivity-portable) | Desktop bindings and platform-independent reactive primitives. |
| [Router](https://github.com/eliezer-dev-software-enginner/megalodonte-router) | Navigation between desktop screens. |
| [JSONC UI](https://github.com/eliezer-dev-software-enginner/megalodonte-jsonc-ui) and [Script App](https://github.com/eliezer-dev-software-enginner/megalodonte-script-app) | Declarative desktop views and their application launcher. |
| [Android](https://github.com/eliezer-dev-software-enginner/megalodonte-android) and [Roku](https://github.com/eliezer-dev-software-enginner/megalodonte-roku) | Platform-specific application support. |
| [Packaging](https://github.com/eliezer-dev-software-enginner/megalodonte-packaging) | Packaging tools and reusable workflows for desktop distribution. |

## Create your first desktop application

The CLI is a convenient starting point for a new project; the applications in
this repository are examples to explore independently. Install Python 3.11+, Git,
`pipx` and a JDK 25. Install the CLI from its public repository:

```sh
git clone https://github.com/eliezer-dev-software-enginner/megalodonte-cli.git
cd megalodonte-cli
pipx install .
cd ..
megalodonte my-app --platform desktop --mode native --display-name "My App"
```

This creates `my-app` with a Java screen, Gradle wrapper, icon, packaging
configuration and local Git repository. For a declarative desktop view, use
`--mode jsonc` instead; see the [CLI guide](https://github.com/eliezer-dev-software-enginner/megalodonte-cli#readme)
for its additional dependencies and Android and Roku options.

The generated native build resolves Megalodonte artifacts from Maven Local or
Maven Central. If the matching artifacts are not available, publish the public
repositories to Maven Local in dependency order:

```sh
for repo in megalodonte-core megalodonte-theme megalodonte-base megalodonte-reactivity megalodonte-components; do
  git clone "https://github.com/eliezer-dev-software-enginner/${repo}.git" || break
  (cd "$repo" && ./gradlew publishToMavenLocal) || break
done
```

Then build and launch the generated project:

```sh
cd my-app
./gradlew build
./gradlew run
```

Gradle may download its distribution, JavaFX and other dependencies; launching
the desktop application requires a graphical environment. The reactivity library
is additionally needed by the interactive examples below.

## Example applications

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
./gradlew build
./gradlew run
```

The JavaFX Gradle plugin resolves the required modules; the examples no longer
require `JAVAFX_MODULES_HOME`. Each example has a `packaging.toml` and follows
the CLI's distribution layout. The example screen implementations and their
close-event handling remain specific to each application. Use the CLI-style
`scripts/package.py` and `packaging.toml` for packaging.

The [package workflow](.github/workflows/package.yml) invokes a reusable
workflow in `megalodonte-packaging` for each of the five examples when triggered
manually or by a `v*` tag. Packaging behavior is defined in that external
workflow. Each example also retains the CLI-generated workflow for use if it is
copied into its own repository; GitHub Actions in this monorepo runs the workflow
at the repository root.

## License

No license file is included in this repository. Licensing terms require review
by the project owner.
