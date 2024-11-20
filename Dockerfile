FROM amazoncorretto:23-alpine-jdk

COPY target/FoodFacts-0.0.1-SNAPSHOT.jar /api/v1.jar

ENTRYPOINT ["java", "-jar", "/api/v1.jar"]