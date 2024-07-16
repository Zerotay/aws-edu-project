FROM amazonlinux:2023 AS builder
ARG APP=board
USER root
RUN dnf update && dnf install -y java-17-amazon-corretto-devel findutils
# RUN dnf install -y libXext libXrender libXtst libXi freetype procps 
COPY $APP /$APP
WORKDIR $APP
CMD [ "/usr/bin/sh" ]
# RUN sh gradlew clean bootJar
