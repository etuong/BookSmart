# BookSmart

This is a full stack web application on an E-commerce bookstore.

Frontend uses Thymeleaf and HTML/CSS/JavaScript tech.

Backend bootstraps with Spring framework, H2 for in-memory database, JPA/Hibernate for ORM, and Spring security for authentication and authorization.

* Thymeleaf is a modern server-side Java template engine
* H2 is a in-memory relational database management system
* Spring Data JPA and Hibernate abstracts away the data access layer and provides a friendly mechanism to map relational objects
* Spring Security provides authentication, authorization and other security features for enterprise applications.


## Screenshots

![Login](screenshots/register.png)
![Login](screenshots/books.png)
![Login](screenshots/book.png)

### Development

To run: `./mvnw spring-boot:run` (Make sure your JAVA_HOME env is set)

View on `http://localhost:8080/`

To access the H2 database, go to http://localhost:8080/h2-console/

The username and password by default are both "q". This can be changed in the seeder.

### Data Information

Mock data are seeded in the Seeder.java class

Data source can be configured in application.properties
