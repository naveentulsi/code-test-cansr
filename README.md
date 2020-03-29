# code-test-cansr

## Database configuration 
Create a mysql database and update below properties as in `/resources/application.yml`.  
The default ones are :
```
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/db
    username: user
    password: user_21
    driver-class-name: com.mysql.jdbc.Driver
```
Also add sample data  before start. Schema should be created by hibernate on startup.


## Run 
Run the project through mvn and head out to [http://localhost:8080/cansr](http://localhost:8080/cansr)

run this command in the command line:
```
mvn spring-boot:run
```