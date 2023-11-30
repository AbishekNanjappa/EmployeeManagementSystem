# Use an official Maven image as a parent image for building
FROM maven:3.8.4-openjdk-17 AS build

# Set the working directory in the container
WORKDIR /src

# Copy the project files into the container
COPY . .

# Build the application
RUN mvn clean package -DskipTests

# Use the official OpenJDK image as a parent image for running the application
FROM openjdk:latest

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from the build stage to the second stage
COPY --from=build /src/target/*.jar app.jar

# Expose the port that your Spring Boot app will run on
EXPOSE 8080

# Define the command to run your application
CMD ["java", "-jar", "app.jar"]
