FROM maven:3.8.4-openjdk-17-slim AS build
WORKDIR /home/app/src
COPY btb-security-service/pom.xml /home/app
COPY btb-security-service/src ./src
RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:17-jdk-slim
COPY --from=build /home/app/target/*.jar /usr/local/lib/security-service.jar
EXPOSE 9005
ENTRYPOINT ["java","-jar","/usr/local/lib/security-service.jar"]