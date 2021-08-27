Base API
===========

**Dependencies**

* JDK 1.8

**Project configuration**

Build project:
````
./mvnw clean package
````

Start API server:
````
Run src/main/java/com/diversius/acciona/AccionaApplication as Java Application.
````

Bundle up application:
````
./mvnw clean install
````

**H2 console**
* url: http://localhost:8080/h2-console
* Driver Class: org.h2.Driver
* JDBC URL: jdbc:h2:mem:acciona
* user: sa
* password:

**Endponits**

* Check tweets: http://localhost:8080/tweets
* Mark tweet as approved: http://localhost:8080/tweets/{hash}/approve
* Get user approved tweets: http://localhost:8080/tweets/approved/user/{userHash}
* Top 10 most used hashtags: http://localhost:8080/hashtag/ranking