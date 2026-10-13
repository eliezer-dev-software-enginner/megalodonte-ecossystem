# Megalodonte example applications

This repository contains five small native desktop applications that teach the
Megalodonte framework. Framework libraries are independent repositories, checked
out directly under `framework/libraries/` in the local workspace. A clone of this
repository no longer needs Git submodules.

| App | Demonstrates |
| --- | --- |
| [Welcome](megalodonte-app1-welcome/) | Application bootstrap, theme and text |
| [Counter](megalodonte-app2-counter/) | Reactive state and button actions |
| [String length](megalodonte-app3-string-lenght/) | Inputs and computed state |
| [Hide and seek](megalodonte-app4-hide-seek/) | Conditional rendering |
| [Todo list](megalodonte-app5-todo-list/) | Reactive lists |

Each example has its own Gradle build and `packaging.toml`. Run
`bash framework/libraries/install-all.sh` from the Megalodonte workspace root to
publish the library artifacts locally, then run `bash gradlew test shadowJar` in
an example directory. The local launcher additionally needs `JAVAFX_MODULES_HOME`
as described in each example's README.

The [package workflow](.github/workflows/package.yml) builds every example
through the reusable workflow in `megalodonte-packaging`. That workflow clones,
tests and publishes the seven library repositories in dependency order before
building AppImage, DEB and MSI artifacts for each example. Example builds upload
CI artifacts without creating five separate GitHub releases.
