# Use an OpenJDK base image
FROM openjdk:17-jdk-slim AS build

# Install Maven and curl - Using curl command to execute health check for depends_on while starting container + download lombok jar
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

RUN apt-get update && apt-get install -y curl

# Copy the JAR file from the previous stage to the runtime image
COPY --from=build /app/target/*.jar lab-reports.jar

#since the file is not accessible in .m2 path @ conatiner
COPY --from=build /root/.m2/repository/io/opentelemetry/javaagent/opentelemetry-javaagent/*/opentelemetry-javaagent-*.jar /app/libs/

# Specify the command to run your application
CMD ["java", "-jar", "lab-reports.jar"]
#CMD ["mvn", "mvn spring-boot:run"]

# command to create image
# docker build . -t vinodg8073/lab_report:v1
# mvn spring-boot:build-image
# mvn compile jib:dockerBuild

# run the containers
# docker run -d --name laboratoryDB -e POSTGRES_DB=laboratoryDB -e POSTGRES_USER=root  -e POSTGRES_PASSWORD=admin -p 5432:5432 postgres:latest
# docker run -d --name lab-reports -p 8080:8080 vinodg8073/lab_report:v1
# docker run -d --name lab-user-management -p 8081:8081 lab-user-management:0.0.1-SNAPSHOT
# docker run -it --rm --name rabbitmq -d -p 5672:5672 -p 15672:15672 rabbitmq:3.13-management
# docker run --name laboratory -d -p 6379:6379 redis