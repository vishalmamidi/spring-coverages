FROM openjdk:18-jdk-alpine

EXPOSE 8080

WORKDIR /app

COPY /build/libs/spring-coverage-0.0.1-SNAPSHOT.jar /app/spring-coverage-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "./spring-coverage-0.0.1-SNAPSHOT.jar"]
