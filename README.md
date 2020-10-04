# controle-api
Projeto de estudo em spring rest, com controle de acesso de usuários

# API rest Spring Data JPA com Hibernate, Banco H2 em memória

## Description
Esse projeto inicia como controle de acesso e cadastro de usuários perfis e unidades no banco de dados H2 executado em memória. Usando os seguintes endpoints, diferentes operações podem ser realizadas:
- `/usuarios` - This returns the list of Users in the Users table which is created in H2 Table (users)
- `/rest/users/{name}` - This returns the details of the Users passed in URL
- `/rest/id/{id}` - This returns the details of the Users for the user Id passed in URL
- `/rest/update/{id}/{name}` - This updates the name of the user for the userId passed in the URL

## Libraries used
- Spring Boot
- Spring MVC (Spring Web)
- Lombok
- Spring Data JPA with Hibernate
- H2

## Tools used
- Git
- Eclipse
- H2 running locally

## Compilation Command
- `mvn clean install` - Plain maven clean and install
