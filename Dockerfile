FROM adoptopenjdk/openjdk11:alpine-jre
EXPOSE 9190
ADD target/payment-service-1.0.0.jar payment-service-1.0.0.jar
ENTRYPOINT ["java","-jar","/payment-service-1.0.0.jar"]