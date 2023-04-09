# Global Manager

Global manager faz o gerenciamento das configurações do projeto, centralizando tudo em um único lugar evitando a duplicação dentro do projeto. 
Temos dois modulos presentes, `plugins` é onde centralizamos todo o codebase responsável pelas plugins compartilhada entre todo projeto `references` planejado para conter referencias globalmente, como constantes.

Utilizamos a versão experimental da biblioteca `easy-logic`, com isso conseguimos extenções de apoio para construção de novas plugins e conseguimos evoluir a lib analisando oque pode faltar em um projeto produtivo.

> easy-logic:``"top.softnepo:easy-logic:0.0.12-experimental"``

Esse modulo trás o build cache para dentro do projeto, dessa forma facilita a limpeza sem impacta o cache de outros projetos, porém depois de 30 dias o cache será renovado seguindo a configuração em `settings.gradle.kts`

```kotlin
buildCache {
    local {
        directory = File(rootDir, "build-cache")
        removeUnusedEntriesAfterDays = 30
    }
}
```

## Plugins existante

| Plugins  | Resumo |
   |---|---|
| brainup.module.build | Configuração de build inicial para modulos do tipo library |
| brainup.build.type | Aplicar algumas configurações básica para o buildType |
| brainup.app.build | Configuração de build do aplicativo (app) |
| brainup.app.compose | Habilita o compose para o aplicativo (app) |

