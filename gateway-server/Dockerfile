FROM openjdk:17-jdk-slim AS build

RUN apt-get update && apt-get install -y maven 

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline

COPY . .

RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim

COPY --from=build /app/target/*.jar gateway-server.jar

ENTRYPOINT ["java", "-jar", "gateway-server.jar"]