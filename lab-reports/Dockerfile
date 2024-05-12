# Use an OpenJDK base image
FROM openjdk:17-jdk-slim AS build

# Install Maven and curl
RUN apt-get update && apt-get install -y maven curl

# First part Downloads Lombok JAR and second part install it
RUN curl -L https://projectlombok.org/downloads/lombok.jar -o lombok.jar && java -jar lombok.jar install /usr/local/openjdk-17

# Set the working directory in the container
WORKDIR /app

# Copy the Maven project file to the container
COPY pom.xml .

# Copy the source code into the container /app directory
COPY src ./src

# Resolve the dependencies defined in the Maven project file and store locally within the container
RUN mvn dependency:go-offline

# Build the application using Maven
RUN mvn package -DskipTests

# Use a new stage for the runtime image
FROM openjdk:17-jdk-slim

# Copy the JAR file from the previous stage to the runtime image
COPY --from=build /app/target/lab-reports-0.0.1-SNAPSHOT.jar .

# Specify the command to run your application
CMD ["java", "-jar", "lab-reports-0.0.1-SNAPSHOT.jar"]
#CMD ["mvn", "mvn spring-boot:run"]

#command to create image
# docker build . -t vinodg8073/lab_report:v1

# run the containers
#docker run -d --name laboratoryDB -e POSTGRES_DB=laboratoryDB -e POSTGRES_USER=root  -e POSTGRES_PASSWORD=admin -p 5432:5432 postgres:latest
#docker run -d --name lab-reports -p 8080:8080 vinodg8073/lab_report:v1