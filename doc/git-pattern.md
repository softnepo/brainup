# Padrões de commit e branch

## Tipos
O projeto não se limite a uma lista fixa de tipos, será listado o mais comuns abaixo:

|Tipo|
|---|
|feat|
|fix|
|doc|
|chore|
|hotfix|

## Conventional Branch 

Padrão do nome das branch foi pensando para facilitar o filtro do
usuário utilizando o próprio github, dessa forma facilita a criação
de script de validação e filtros por usuário.

Pattern:
````xml
  <username>/<type>/<module>/textAbc
````

Exemplo:
````xml
   lnsantos/feat/pet/createComponentText
   lnsantos/doc/pet/createMarkdownText
   lnsantos/fix/pet/textColor
````

## Conventional Commit 

Esse projeto segue o [Conventional Commits](https://www.conventionalcommits.org/en/v1.0.0/) leia mais sobre.

Pattern:
````
  <type>[optional scope]: <description>
  [optional body]
````

Exemplo:

````
  feat: allow provided config object to extend other configs
  feat(api)!: send an email to the customer when a product is shipped
````
