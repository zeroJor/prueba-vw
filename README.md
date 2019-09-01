# VW-Test
REST API that provides functionality for transferring money and
showing the past transactions in a historical transaction list.

### Demo
You can test the application in [this url](http://45.79.149.154:8080/vw-test). 

### Approach followed

The way this application was created was by following these steps:

* Create the spring boot web base project in IntelliJ IDEA, this IDE was choosed for compatibility with the required language: Kotlin 
* Declare the controller that handle the requests
* Define a way to handle the non-successful responses
* Define a service layer for the business logic
* Define a DAO layer for the data operations
* Implement service layer
* Choose a simple way to manage data: MongoDB was choosed coz there's no need to define a schema
* Implement DAO layer
* Test with Postman, postman tests are exposed [here](https://www.getpostman.com/collections/bd567c9bc5d69efe4121)
* Do some minor changes
* Add Swagger
* And finally, update README.md file
 

### Running the app
You can run the app by cloning this project and importing it with IntelliJ IDEA or just running the Jar.

### Swagger
Swagger definition is in /api uri as required  
Swagger UI is in the root of the app: /

### Build with

* Spring Boot
* Kotlin
* MongoDB

### Author
Jorge Segundo Rojas  
WhatsApp: 2222726987  
Email: jorgesr@live.com.mx    