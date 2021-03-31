# REST API 
##Spring Boot, JPA, Hibernate and PostgreSQL

This is a sample Spring Boot application. 
## Getting Started

*	You need to have **PostgreSQL** installed on your machine. Using the `pgAdmin4` or on any other **PostgreSQL** client/console,
     create a database/schema named `marketdb`. 
     

*   After creating the database/schema, you need to add your **PostgreSQL** username and password in the 
    application.properties file on src/main/resource. The lines that must be modified are as follows:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/marketdb
spring.datasource.username=<your username>
spring.datasource.password=<your password>
```

#### Running the application with Maven
```shell
$ git clone -----
$ cd -----
$ mvn spring-boot:run
```

## Installing
* 	URL to access application Swagger UI: **http://localhost:8080/swagger-ui.html**.
* 	URL to VIEW all products from DB: **http://localhost:8080/market/main**.
     
## Notes
* 	For testing pagination, you have to use endpoint with parameters: **http://localhost:8080/market/products/paginated?page=1&size=2**.


