# Microservices with Spring Boot
This is a multi-module maven project, demonstrating a typical cloud native micro-service based architechture.

![Screenshot](MicroserviceDiagram.PNG)

## Tech stack/Components used for building the architecture
```bash
1. Spring boot 				- Framework used for developing the applications
2. Spring cloud config		- Spring cloud config server for externalizing the configurations
3. Netflix Eureka server	- To hold the information about all client-service applications 
4. API Gateway			    - A gateway application that handles all the requests and does the dynamic routing of microservice applications.
5. User Microservice	    - A simple micro-service for exposing REST API's pertaining to User datastore
6. Department Microservice  - A simple micro-service for exposing REST API's pertaining to Department datastore
7. MySQL                    - A database for storing data pertaining to Departments
8. MongoDB				    - A database for storing data pertaining to Users
```
## More information
This project contains below modules.

1. **[microservices-config-repo](https://github.com/shabanabd/microservices-config-repo)** : Git repo for storing the configurations of services

2. **config-server** : Custom spring boot based config server, implemented using Spring cloud config server for retrieving the application configuration

3. **service-registry** : Custom spring boot based service registry server, implemented using Netflix Eureka server

4. **api-gateway** : Custom spring boot based zuul api gateway, implemented using Spring Cloud Gateway for routing the requests to respective micro-service based on the path

5. **department-service** : A simple micro-service for exposing REST API's pertaining to department datastore

6. **user-service** : A simple micro-service for exposing REST API's pertaining to User datastore

## Build instructions
```java
mvn clean install
```

