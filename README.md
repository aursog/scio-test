# Technical Test ![Technology Java](https://img.shields.io/badge/Java-11-green) ![Framework](https://img.shields.io/badge/SpringBoot-2.7.0_SNAPSHOT-blue)

The present test was developed for a Senior Software Developer Java position. In the next lines will describe
the full process to execute and run the software solution.

## Requirements

 - Java 11
 - Spring Boot
 - Maven
 - Lombok library (if would use intellij IDE)
 - Memcached

## Instalation process

To install Java 11 in your computer, is suggested the use of [SDKMAN](https://sdkman.io) to install correct java version.

```bash
skd install java 11.0.2-open
```

### For approach without Memcached

Go to the [mvc-approach](https://github.com/aursog/scio-test/tree/mvc-approach) branch and execute:

```bash
mvn spring-boot:run
```

### For approach with Memcached

Go to the [master](https://github.com/aursog/scio-test/tree/master) branch, and then execute:

```bash
docker-compose up
```

In both cases, this start a web server listen over <code>:8080</code> port. Later you can access through [Postman](https://postman.com)
or your navigator accessing to: <code>http://localhost:8080 </code>.


## End-points details

To details about the implementation. The solution considered have two endpoints.

 - **First End-point**
    - **uri**: http://localhost:8080/cms
    - **Parameters**: No parameters
    - **Expected result**: All the results of the [API](https://www.healthit.gov/data/open-api?source=Meaningful-Use-Acceleration-Scorecard.csv)

 - **Second End-Point**
    - **uri**: http://localhost:8080/cms/filter
    - **Paramenters**: ?year=\<Integer\> 
    - **Expected result**: All the results of the [API](https://www.healthit.gov/data/open-api?source=Meaningful-Use-Acceleration-Scorecard.csv) filtered by the year
    in the parameters, if the year is not added the endpoint considerer the 2014 like the default year.
      
## Architectural decisions

This project contains two different approach in a way to resolve the problem.

The first one can be observed in the **master** branch, this architecture considerer an approach using SOLID principles.

The packages structure is the following:

 - **application**:  All the business rules, like services, use cases, interfaces.
 - **entity**: All domain object in the business rules.
 - **framework**: All external layer, like: configurations, controllers, RestClients, and all the Framework infrastructure.

The second architecture you can observe in the [mvc-approach](https://github.com/aursog/scio-test/tree/mvc-approach) branch.
In this branch, we define a simple structure following the MVC principles, having some packages like:

 - **config**: all the configurations
 - **controller**: all the application controllers
 - **domain**: all the domains objects
 - **entity**: DTO's
 - **restclient**: Restclient classes
 - **services**: All the services classes

In this approach we used a colaboration approach insted of inheritance and implementation approach.

## Additional Considerations

- The use of GitFlow was not used, because the problem was really simple. 
  However they were created some ad-hoc branches to add more characteristic to the test.
  
- I wrote this README file in english, assuming the person can review this code is a english spoken.

## Next steps
 
 * Adding Swagger documentation (for the scope and time of the test we don't considerer necessary to add).
 * Adding Mutation Test over the Unit Test adding in this project.
 * Add Memcached to the other architecture definition.
 * Add Readme in MVC Branch.

## Author

[Anggelo Urso G.](mailto:anggelo.urso@gmail.com)