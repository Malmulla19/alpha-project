# AS <NAME> to name this stage as maven
FROM maven:3.8.3-openjdk-17 AS maven
WORKDIR /usr/src/app
COPY . /usr/src/app
# Compile and package the application to an executable JAR
RUN mvn package 
# For Java 11, 
FROM openjdk:17-jdk-slim
ARG JAR_FILE=*.jar
WORKDIR /opt/app
# Copy the spring-boot-api-tutorial.jar from the maven stage to the /opt/app directory of the current stage.
COPY --from=maven /usr/src/app/target/${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]
EXPOSE 8080
