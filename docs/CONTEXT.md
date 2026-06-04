# Contexto do Projeto

## Estrutura
- JavaFX + Megalodonte (UI framework)
- modular: cada módulo (megalodonte-base, megalodonte-reactivity, megalodonte-router, megalodonte-theme, megalodonte-components) é um submodulo git independente, publicado no Maven Local via `gradlew build publishToMavenLocal`
- megalodonte-libs: meta-repo que agrupa os 5 módulos (base, reactivity, router, theme, components) + scripts de instalação
- dependências compiladas sequencialmente na ordem: base → reactivity → router → theme → components

## Dependências entre módulos
- megalodonte-base: módulo raiz — contém interfaces de reatividade (ReadableState, State, ForEachState) e Component
- megalodonte-reactivity: depende de base, fornece ComputedState, ListState, ListenerManager, Show
- megalodonte-components: depende APENAS de base (não depende mais de reactivity)
- megalodonte-theme: depende de base
- megalodonte-router: depende de base

## Última alteração
- Adicionado megalodonte-libs como submódulo git do ecossistema
- Corrigido fontSize não sendo aplicado em TextProps (Props.apply agora chama applyImmediate)

