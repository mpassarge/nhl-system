FROM arm64v8/openjdk:11-jre
WORKDIR /app

ARG JAR_FILE
COPY ${JAR_FILE} app.jar

EXPOSE 9080

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "app.jar"]
