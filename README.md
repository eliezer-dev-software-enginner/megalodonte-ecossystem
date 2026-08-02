# megalodonte-ecossystem

Umbrella repo for the Megalodonte framework: a set of small example apps plus the
[`megalodonte-libs`](megalodonte-libs) submodule (the actual framework libraries —
`megalodonte-base`, `megalodonte-components`, `megalodonte-reactivity`,
`megalodonte-router`, `megalodonte-theme` — each its own submodule inside it).

## Example apps

Each app is a minimal, focused demo of one part of the framework:

| App | Demonstrates |
|---|---|
| [`megalodonte-app1-welcome`](megalodonte-app1-welcome) | Bootstrapping a Megalodonte app — `ThemeManager.setTheme(...)`, `MegalodonteApp.run(...)`, a single `Text` |
| [`megalodonte-app2-counter`](megalodonte-app2-counter) | `State<Integer>` + `ReadableState.map(...)`, `Button.onClick(...)` |
| [`megalodonte-app3-string-lenght`](megalodonte-app3-string-lenght) | `State<String>` bound to an `Input`, derived via `ComputedState` |
| [`megalodonte-app4-hide-seek`](megalodonte-app4-hide-seek) | `State<Boolean>` + conditional rendering via `Show.when(...)` |

## Getting started

Clone with submodules (`megalodonte-libs`, and everything inside it):

```bash
git clone --recurse-submodules git@github.com:eliezer-dev-software-enginner/megalodonte-ecossystem.git
```

Already cloned without `--recurse-submodules`? Pull them in after the fact:

```bash
git submodule update --init --recursive
```

Publish every framework library to Maven local (see
[`megalodonte-libs/README.md`](megalodonte-libs/README.md) for details):

```bash
cd megalodonte-libs && ./install-all.sh
```

Then run any app:

```bash
cd megalodonte-app1-welcome
./gradlew run
```

Each app also needs the JavaFX SDK modules available locally — see the
"JavaFX Modules Setup" section in [`megalodonte-app1-welcome/README.md`](megalodonte-app1-welcome/README.md).

## Repos

- Ecosystem (this repo): https://github.com/eliezer-dev-software-enginner/megalodonte-ecossystem
- Libraries monorepo: https://github.com/eliezer-dev-software-enginner/megalodonte-libs
- Components: https://github.com/eliezer-dev-software-enginner/megalodonte-components
- Base: https://github.com/eliezer-dev-software-enginner/megalodonte-base
- Reactivity: https://github.com/eliezer-dev-software-enginner/megalodonte-reactivity
- Theme: https://github.com/eliezer-dev-software-enginner/megalodonte-theme
