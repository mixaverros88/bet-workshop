# Use the openjdk:11-jdk-slim base image
FROM openjdk:17-jdk-slim

# Set environment variable for the debug port
ENV JAVA_TOOL_OPTIONS="-agentlib:jdwp=transport=dt_socket,address=*:8001,server=y,suspend=n"

# Copy your application code to the container
COPY /build/libs/place-bet-0.0.1-SNAPSHOT.jar place-bet-0.0.1-SNAPSHOT.jar

# Expose the debug port
EXPOSE 8181

# Start the application
CMD ["java", "-jar", "place-bet-0.0.1-SNAPSHOT.jar"]
