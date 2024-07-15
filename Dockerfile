FROM amazonlinux:2023 AS builder
ARG APP=board
USER root
RUN dnf update && dnf install -y java-17-amazon-corretto-devel
# RUN dnf install -y libXext libXrender libXtst libXi freetype procps 
COPY $APP /$APP
WORKDIR $APP
RUN sh gradlew clean bootJar

FROM alpine:latest
ARG APP=board
RUN apk --no-cache update && \
    apk --no-cache upgrade && \
    apk --no-cache add openjdk17-jre-headless tzdata bash
ENV JAVA_HOME=/usr/lib/jvm/java-17-openjdk
ENV TZ=Asia/Seoul
EXPOSE 8080
# COPY build/$APP/application.yml .
COPY --from=builder /$APP/build/libs/*.jar .
# COPY build/$APP/output.cert .
# RUN keytool -importcert -cacerts -storepass changeit -file output.cert -alias letsencrypt -noprompt
CMD [ "java", "-Dfile.encoding=utf-8","-jar", "-XX:InitialHeapSize=1M", "-XX:MaxHeapSize=2G", "-XX:MinHeapSize=1M", "/board-0.0.1-SNAPSHOT.jar"]
