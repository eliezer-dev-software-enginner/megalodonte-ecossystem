# Hot Reload (Python)

## Setup

```bash
python3 -m venv .venv
.venv/bin/pip install watchdog
```

## Usage

```bash
.venv/bin/python dev.py
```

Or activate the venv:

```bash
source .venv/bin/activate
python dev.py
```

## How it works

1. Monitors changes in `src/main/java/` using `watchdog`
2. Upon detecting a change, compiles the modified `.java` files using `javac`
3. Copies modified resources to `build/classes/java/main/`
