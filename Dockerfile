FROM openjdk:22-jdk-slim

WORKDIR /app

COPY build/libs/Web-Service-Lecture-4-0.0.1-SNAPSHOT.jar /app/my-spring-app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/my-spring-app.jar"]