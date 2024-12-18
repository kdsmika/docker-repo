FROM openjdk:17-jdk-alpine
LABEL maintainer="spring_ui"
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} nagarro-0.0.1-SNAPSHOT.jar
EXPOSE 8484
ENTRYPOINT ["java", "-jar", "nagarro-0.0.1-SNAPSHOT.jar"] 