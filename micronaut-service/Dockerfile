FROM openjdk:8-jre-alpine
ARG APP_NAME
ARG APP_VERSION
ARG TARGET_DIR=/opt/application
ARG TARGET_CONFIG_DIR=$TARGET_DIR/config
ARG TARGET_AGENT_DIR=$TARGET_DIR/agent

ARG SOURCE_DIR=build
ARG PROFILER_DIR=profiler
ARG SOURCE_CONFIG_DIR=$SOURCE_DIR/resources/main
ARG SOURCE=$SOURCE_DIR/libs/$APP_NAME-$APP_VERSION.jar

EXPOSE 8080/tcp

RUN mkdir -p "$TARGET_DIR"
RUN mkdir -p "$TARGET_CONFIG_DIR"
RUN mkdir -p "$TARGET_AGENT_DIR"

ADD $SOURCE $TARGET_DIR/server.jar
ADD $SOURCE_CONFIG_DIR/application.yml $TARGET_CONFIG_DIR/application.yml
ADD $SOURCE_CONFIG_DIR/logback.xml $TARGET_CONFIG_DIR/logback.xml

CMD ["/bin/sh","-c","java -Dlogback.configurationFile=/config/logback.xml -jar /opt/application/server.jar"]
