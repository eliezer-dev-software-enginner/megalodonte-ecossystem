# Decisões Arquiteturais

## 2026-06-04 — megalodonte-libs como submódulo
- megalodonte-libs foi transformado em submódulo git de megalodonte-ecossystem
- URL: git@github.com:eliezer-dev-software-enginner/megalodonte-libs.git
- Contém base, reactivity, router, theme, components e scripts de instalação

## 2026-06-04 — applyImmediate para estilos explícitos
- Props.apply() agora chama applyImmediate(node) antes da subscription ao ThemeManager
- Valores explícitos (fontSize, fontWeight) são aplicados sem depender do tema
- Theme continua sendo necessário para valores temáticos (cores via tone, etc.)

