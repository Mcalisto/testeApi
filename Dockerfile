FROM openjdk

EXPOSE 8081

WORKDIR /app

COPY target/testApi-0.0.1-SNAPSHOT.jar /app/testApi.jar

ENTRYPOINT ["java","-jar","testApi.jar"]