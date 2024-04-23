# Use the official Maven image with a tag that includes JDK 17 to build your application
FROM maven:3.8.6-openjdk-17-slim AS build

# Copy the project files to the container image
COPY src /home/app/src
COPY pom.xml /home/app

# Package your application
RUN mvn -f /home/app/pom.xml clean package -DskipTests

# Use the official OpenJDK image to create the runtime container
FROM openjdk:17-slim

# Copy the built artifact from the build stage to the application directory
COPY --from=build /home/app/target/*.jar /usr/local/lib/app.jar

# Expose the port the application runs on
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "/usr/local/lib/app.jar"]
