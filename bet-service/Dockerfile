FROM gradle:7.6.3-jdk17-alpine AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

# Use the openjdk:17-jdk-slim base image
FROM openjdk:17-jdk-slim

# Set environment variable for the debug port
ENV JAVA_TOOL_OPTIONS="-agentlib:jdwp=transport=dt_socket,address=*:8001,server=y,suspend=n"

# Copy your application code to the container
COPY --from=build /home/gradle/src/build/libs/bet-service-0.0.1-SNAPSHOT.jar bet-serice.jar

# Expose the debug port
EXPOSE 8181

# Start the application
CMD ["java", "-jar", "bet-serice.jar"]
