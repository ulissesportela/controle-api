# controle-api
Projeto de estudo em spring rest, com controle de acesso de usuários

# API rest Spring Data JPA com Hibernate, Banco Postgres

## Descrição
Esse projeto inicia como controle de acesso e cadastro de usuários perfis e unidades no banco de dados Postgres. Diferentes operações podem ser realizadas:

### Funcionalidades
- [x] Cadastro de Unidades
- [ ] Cadastro de Clientes
- [ ] Efetuar Login

### Endpoints, 
- `/unidades` - Retorna a lista de unidades na tabela de unidades
- `/unidades/{id}` - Retorna os detalhes da unidade pesquisada por codigo passado na URL
- `/unidades` - Inclui uma unidade
- `/unidades/{id}` - Altera uma unidade passando o codigo na URL


## Swagger
http://localhost:8080/swagger-ui.html

## Bibliotecas usadas
- Spring Boot
- Spring MVC (Spring Web)
- Srping Security
- Spring Data
- Maven
- Lombok
- Spring Data JPA with Hibernate
- Postgres

## Ferramentas usadas
- Git
- Eclipse
- Docker
- Postgres
- DBeaver
- Insomnia

## Comando de compilacao
- `mvn clean install` - Plain maven clean and install


