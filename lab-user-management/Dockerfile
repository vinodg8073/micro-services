FROM openjdk:17-jdk-slim AS build

RUN apt-get update && apt-get install -y maven curl

RUN curl -L https://projectlombok.org/downloads/lombok.jar -o lombok.jar && java -jar lombok.jar install /usr/local/openjdk-17

WORKDIR /app

COPY pom.xml .

COPY src ./src

RUN mvn dependency:go-offline

RUN mvn package -DskipTests

FROM openjdk:17-jdk-slim

RUN apt-get update && apt-get install -y curl

COPY --from=build /app/target/*.jar lab-user-managemnt.jar

COPY --from=build /root/.m2/repository/io/opentelemetry/javaagent/opentelemetry-javaagent/*/opentelemetry-javaagent-*.jar /app/libs/

CMD ["java", "-jar", "lab-user-managemnt.jar"]