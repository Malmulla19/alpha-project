#Create a docker image for the product service
FROM openjdk:8-jdk-alpine
EXPOSE 8080
COPY target/product-service-0.0.1-SNAPSHOT.jar target/product-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","target/product-service-0.0.1-SNAPSHOT.jar"]