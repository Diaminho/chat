FROM adoptopenjdk/openjdk11:alpine-jre

RUN apk add curl

WORKDIR /opt/app
COPY build/libs/*.jar app.jar