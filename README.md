# VW-Test
REST API that provides functionality for transferring money and
showing the past transactions in a historical transaction list.

### Demo
The demo application in hosted [here](http://45.79.149.154:8080). 

### Test
You can test the application directly with [Swagger UI](http://45.79.149.154:8080) or including [this url]([here](https://www.getpostman.com/collections/bd567c9bc5d69efe4121)) in Postman.

### Approach followed

The way this application was created was by following these steps:

* Create the spring boot web base project in IntelliJ IDEA, this IDE was choosed for compatibility with the required language: Kotlin 
* Declare the controller that handle the requests
* Define a way to handle the non-successful responses
* Define a service layer for the business logic
* Define a DAO layer for the data operations
* Implement service layer
* Choose a simple way to manage data: MongoDB was chosen for simplicity, database is hosted in a free MongoDB Atlas account
* Implement DAO layer
* Test with Postman
* Add Swagger
* And finally, update README.md file
 

### Running the app

There are two options:

1.- Using ItelliJ IDEA
* Clone this project 
* Import it with IntelliJ IDEA
* Press Run button

2.- Package and run Jar file
* Package using the commnand `mvn package` 
* Run using the commnand `java -jar bank-0.1.0.jar`
  

### Swagger
Swagger definition is in `/api` uri as required  
Swagger UI is in the root of the app context `/`

### Build with

* Spring Boot
* Kotlin
* MongoDB

### Author
Jorge Segundo Rojas  
WhatsApp: 2222726987  
Email: jorgesr@live.com.mx    