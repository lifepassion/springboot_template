FROM openjdk:8-jdk-alpine
EXPOSE 8160
ADD target/appName-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar","-Duser.timezone=GMT+08","-Dspring.profiles.active=prod","/app.jar"]
