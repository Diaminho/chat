# Chat

WebSocket chat with STOMP messages and RabbitMQ as Message broker

## Getting Started

Project needed to be imported as gradle project

## Building for production

### Packaging as jar

To build the final jar run:

```
$ ./gradlew clean bootJar
```
## Run
To run the application:

```
$ ./gradlew clean bootRun
```
Chat can accessed via:

```
http://localhost:8080
```

### Login Page

![Login Page](master/images/login.png)

### Chat window

![Chat window](master/images/chat.png)

## Testing

To run tests:

```
$ ./gradlew clean test
```

## Docker

For running sevices chat and rabbit need to build chat using the following command:

```
$ ./gradlew clean build
```
For running docker container with created image the following command can be used:

```
$ docker-compose up --build
```
