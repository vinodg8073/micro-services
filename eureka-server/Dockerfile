FROM openjdk:17-jdk-slim AS build

RUN apt-get update && apt-get install -y maven curl

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline

COPY . .

RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim

RUN apt-get update && apt-get install -y curl

COPY --from=build /app/target/*.jar eureka-server.jar

COPY --from=build /root/.m2/repository/io/opentelemetry/javaagent/opentelemetry-javaagent/*/opentelemetry-javaagent-*.jar /app/libs/

ENTRYPOINT ["java", "-jar", "eureka-server.jar"]