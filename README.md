# controle-api
Projeto de estudo em spring rest, com controle de acesso de usuários

# Spring Data JPA with Hibernate using H2 Example
This project depicts the Spring Boot Example with Spring Data JPA with Hibernate using H2 Example.

## Description
This Project shows the list of Users which are stored in the H2 Database. Using the following endpoints, different operations can be achieved:
- `/rest/users/all` - This returns the list of Users in the Users table which is created in H2 Table (users)
- `/rest/users/{name}` - This returns the details of the Users passed in URL
- `/rest/id/{id}` - This returns the details of the Users for the user Id passed in URL
- `/rest/update/{id}/{name}` - This updates the name of the user for the userId passed in the URL

## Libraries used
- Spring Boot
- Spring MVC (Spring Web)
- Spring Data JPA with Hibernate
- H2

## Tools used
- Git
- Eclipse
- H2 running locally

## Compilation Command
- `mvn clean install` - Plain maven clean and install
