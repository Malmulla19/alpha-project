#
# Build stage
#
FROM maven:3.6.3 AS maven

WORKDIR /usr/src/app
COPY . /usr/src/app
# Compile and package the application to an executable JAR
RUN mvn package 

# For Java 11, 
FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=target/*.jar
WORKDIR /opt/app
COPY --from=maven /usr/src/app/target/${JAR_FILE} /opt/app/
ENTRYPOINT ["java","-jar","productservice.jar"]
EXPOSE 8080

#Create a docker image for the product service
#FROM adoptopenjdk/openjdk11:alpine-jre
#ARG JAR_FILE=target/*.jar
#COPY ${JAR_FILE} productservice.jar
#ENTRYPOINT ["java","-jar","/productservice.jar"]
#EXPOSE 8080
