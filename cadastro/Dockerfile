FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/cadastro.jar cadastro.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "cadastro.jar"]