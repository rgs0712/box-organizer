FROM openjdk:21
WORKDIR deploy
COPY target/box-organizer-*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]