# Hello API

Spring Boot Employee Management REST API using:
- Spring Boot 3
- Java 17
- Spring Data JPA
- H2 In-Memory Database
- Spring Boot Actuator

## Features
- CRUD APIs for Employee
- H2 Console
- Actuator health & info endpoints

## Run Application
```bash
mvn spring-boot:run


H2 Console
URL: http://localhost:8080/h2-console

JDBC URL: jdbc:h2:mem:testdb
Username: sa
Password: (empty)

Actuator

Health: http://localhost:8080/actuator/health
Info: http://localhost:8080/actuator/info
