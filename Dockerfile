FROM openjdk:23-slim-bullseye
COPY target/demo-0.0.1.jar /app/demo.jar

WORKDIR /app

EXPOSE 8080

ENTRYPOINT java -jar demo.jar
