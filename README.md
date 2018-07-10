# disruptive-guestbook ( Spring Boot 2.0 with Kotlin demo)


This is a demo application for the *"Application.kt - Spring Boot 2 with Kotlin
"* presentation at the [inovex Meetup](https://www.meetup.com/de-DE/inovex-karlsruhe/events/249381296/).



## Requirements

* Docker with [Docker-Compose](https://docs.docker.com/compose/install/)
* JDK 8 
* Giphy API-Key (can be created [here](https://developers.giphy.com/dashboard/))


## Run the application

1. Set your giphy api key in [application.properties](spring-kotlin-demo/src/main/resources/application.properties)
2. Start the local mongodb by `docker-compose up`
3. Build and run the Application by `./gradlew bootRun`
4. Open the web application in your browser:  [http://localhost:8080](http://localhost:8080)
5. Stop the mongodb by `docker-compose down`

## Usefull Links

* [Kotlin Reference](http://kotlinlang.org/docs/reference/)
* [spring.io blog: Introducing Kotlin support in Spring Framework 5.0](https://spring.io/blog/2017/01/04/introducing-kotlin-support-in-spring-framework-5-0)