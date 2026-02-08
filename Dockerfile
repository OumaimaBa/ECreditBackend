FROM eclipse-temurin:17-jre-alpine
# Set working directory
WORKDIR /app
# Copy the jar file into the container
COPY target/credit-0.0.1-SNAPSHOT.jar app.jar
# Expose the Spring Boot port
EXPOSE 8080
# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
