# yoh-codingexercise

This is a spring boot project for the coding excercise which uses the following technologies:

* Java 1.8
* Spring MVC with Spring Boot
* Maven

### Clone
You can simply clone this repository using git:
```
git clone https://github.com/marqJava/yoh-codingexercise.git
cd yoh-codingexercise
```
### Build an executable JAR
You can run the application from the command line using:
```
mvn spring-boot:run
```
Or you can build a single executable JAR file that contains all the necessary dependencies, classes, and resources with:
```
mvn clean package
```
Then you can run the JAR file with:
```
java -jar target/*.jar
```
Then visit http://localhost:8080/coding/exercise/quiz to chech the rest web service response.


The architecture of the project is built with the following components: 
 * Controller: Provides the entry point for the project rest service.
 * Service: Implements the business logic and handles the logic beetween the transformers and the rest client.
 * Transformer: Clases to map the data from the opentdb to the response service.
 * Rest: Layer to provide the rest client and dto for the web services.




