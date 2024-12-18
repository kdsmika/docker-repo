FROM openjdk:11
LABEL maintainer="spring_rest_backend"
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} application_rest-0.0.1-SNAPSHOT.jar
EXPOSE 8383
ENTRYPOINT ["java", "-jar", "application_rest-0.0.1-SNAPSHOT.jar"]
