FROM openjdk:11-slim as build
VOLUME /tmp


ADD target/account-service-0.0.1.jar app.jar
EXPOSE 8082
RUN sh -c 'touch /app.jar'

ENTRYPOINT ["java", "-jar", "/app.jar"]