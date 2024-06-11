# Use AdoptOpenJDK as base image
FROM adoptopenjdk:17-jdk-hotspot as build

# Set working directory
WORKDIR /app

# Copy Maven build files
COPY pom.xml .
COPY src ./src

# Build application
RUN ./mvnw package -DskipTests

# Use lightweight image for runtime
FROM adoptopenjdk:17-jre-hotspot

# Set working directory
WORKDIR /app

# Copy JAR file built in previous stage
COPY --from=build /out/artifacts/assignment_jar/assignment.jar ./app.jar

# Expose port
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "app.jar"]
