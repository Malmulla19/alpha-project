#Create a docker image for the product service
FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} productservice.jar
ENTRYPOINT ["java","-jar","/productservice.jar"]
EXPOSE 8080
