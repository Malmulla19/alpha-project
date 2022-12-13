#
# Build stage
#
FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
FROM openjdk:11-jre-slim
COPY --from=build /home/app/target/demo-0.0.1-SNAPSHOT.jar /usr/local/lib/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/app.jar"]



#Create a docker image for the product service
#FROM adoptopenjdk/openjdk11:alpine-jre
#ARG JAR_FILE=target/*.jar
#COPY ${JAR_FILE} productservice.jar
#ENTRYPOINT ["java","-jar","/productservice.jar"]
#EXPOSE 8080
