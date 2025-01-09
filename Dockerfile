# Use a base image for your application (e.g., OpenJDK for Java)
FROM openjdk:17-jdk-slim

# Install git and maven
RUN apt-get update && apt-get install -y git maven

# Set the working directory
WORKDIR /app

# Copy the JAR file into the container (replace with the actual file name)
COPY target/your-main-app-name.jar /app/target/your-main-app-name.jar

# Run the JAR file (replace 'my-java-project.jar' with your actual JAR file name)
CMD ["java", "-jar", "/app/target/your-main-app-name.jar"]


