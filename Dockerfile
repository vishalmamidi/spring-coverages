FROM openjdk:17-jdk-alpine

EXPOSE 8080

WORKDIR /app

COPY /build/libs/spring-coverages-0.0.1-SNAPSHOT.jar /app/spring-coverages-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "./spring-coverages-0.0.1-SNAPSHOT.jar"]
