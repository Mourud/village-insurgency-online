# Start with a Java runtime environment
FROM openjdk:17-jdk-alpine

# Set the working directory
WORKDIR /app

# Copy the jar file into the container
COPY target/*.jar app.jar

# Expose the single port for the application
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]