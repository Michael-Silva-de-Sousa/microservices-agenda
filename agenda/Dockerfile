# Start with a base image containing Java runtime
FROM openjdk:17-jdk-alpine

# The application´s jar file. Tipo um alias
#ARG JAR_FILE=target/agenda-1.0.0.jar

# Add the application`s jar to the container
#ADD ${JAR_FILE} agenda.jar
WORKDIR /app

COPY target/agenda-1.0.jar /app/agenda.jar
# Make port 8080 available to the world outside this container
EXPOSE 8080
# Run the jar file
ENTRYPOINT ["java","-jar","agenda.jar"]