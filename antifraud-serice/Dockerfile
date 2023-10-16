FROM gradle:7.6.3-jdk17-alpine AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

# Use the openjdk:17-jdk-slim base image
FROM openjdk:17-jdk-slim

# Set environment variable for the debug port
ENV JAVA_TOOL_OPTIONS="-agentlib:jdwp=transport=dt_socket,address=*:8002,server=y,suspend=n"

# Copy your application code to the container
COPY --from=build /home/gradle/src/build/libs/retrieve-bet-0.0.1-SNAPSHOT.jar retrieve-bet-0.0.1-SNAPSHOT.jar

# Expose the debug port
EXPOSE 8182

# Start the application
CMD ["java", "-jar", "retrieve-bet-0.0.1-SNAPSHOT.jar"]
