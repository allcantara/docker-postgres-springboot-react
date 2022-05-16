FROM openjdk:17

WORKDIR /app/api

COPY target/api-0.0.1-SNAPSHOT.jar /app/api/api.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "api.jar"]