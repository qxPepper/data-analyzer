FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

COPY target/data-analyzer-1.0-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
