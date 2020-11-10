FROM gradle:jdk11-openj9 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle clean assemble 

FROM openjdk:11.0.9-jre-slim

EXPOSE 8080

RUN mkdir /app

COPY --from=build /home/gradle/src/build/libs/*.jar /app/spring-boot-application.jar

ENTRYPOINT ["java","-Dserver.port=$PORT","-Djava.security.egd=file:/dev/./urandom","-jar","/app/spring-boot-application.jar"]