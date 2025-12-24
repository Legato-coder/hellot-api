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



PostMan curl

to add a new record - http://localhost:8080/employees
to fetch All Employees - http://localhost:8080/employees
to fetch eployees by ID - http://localhost:8080/employees/5
Request Body

{
  "name": "Tippi Reddy",
  "department": "Physics",
  "salary": 3000,
  "city": "Kompally"
}

