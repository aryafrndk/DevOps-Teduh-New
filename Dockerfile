# Use a base image for your application (e.g., OpenJDK for Java)
FROM openjdk:17-jdk-slim

# Install git and maven
RUN apt-get update && apt-get install -y git maven

# Set the working directory
WORKDIR /app

# Clone the repository
RUN git clone https://github.com/aryafrndk/DevOps-Teduh-New.git .

# Build the app (if it's a Java application, this could be maven build)
RUN mvn clean install

# Run the JAR file (replace 'my-java-project.jar' with your actual JAR file name)
CMD ["java", "-jar", "target/my-java-project-1.0-SNAPSHOT.jar"]

