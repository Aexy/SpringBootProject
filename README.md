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

## Usage
To use the spring app make sure to have your own database that contains the following columns:
<ul>
    <li><strong>Primary Key:</strong> id </li>
    <li>question_title</li>
    <li>option1</li>
    <li>option2</li>
    <li>option3</li>
    <li>option4</li>
    <li>right_answer</li>
    <li>difficulty</li>
    <li>category</li>
</ul>

Afterward you can navigate to your desired URL next to the method you would like to test out. Since I use the port 8090 for my project, the URL's look like:
```
http://localhost:8090/questions/all
```