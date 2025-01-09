# Spring Boot Project for personal use
The main goal of this project is to get familiar with the spring boot framework and develop a meaningful project for fun.

## Necessary files
An application.properties file must be inserted inside the resources folder. The layout should look like the example below:

```
spring.application.name=SpringBootProject
spring.datasource.driver-class-name=org.postgresql.Driver //if you are using postgres
spring.datasource.url=jdbc:postgresql://localhost:____/postgres //fill the ___ with the port postgres is publishing to
spring.datasource.username= ____ //your own username for the postgres login
spring.datasource.password= ____ //your own password for the postgres login
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
server.port=___ //self-defined port number (Eg. 8080,8090)
```
