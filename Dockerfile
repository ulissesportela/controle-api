FROM openjdk

WORKDIR /app

COPY target/controle-api-0.0.1-SNAPSHOT.jar /app/controle-api.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "controle-api.jar"]