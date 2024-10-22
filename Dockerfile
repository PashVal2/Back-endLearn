FROM openjdk:11-jre-slim

VOLUME /tmp

COPY build/libs/Backend-1.0-SNAPSHOT-plain.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
