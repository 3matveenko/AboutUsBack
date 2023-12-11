FROM openjdk:17-oracle

LABEL maintainer="ivan"

RUN mkdir /app

COPY build/libs/aboutUs-0.0.1-SNAPSHOT.jar /app/aboutUs.jar

WORKDIR /app

ENTRYPOINT ["java", "-jar", "aboutUs.jar"]