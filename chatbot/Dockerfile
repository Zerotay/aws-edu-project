FROM amazonlinux:2023
USER root
# WORKDIR /
RUN dnf update && dnf install -y java-17-amazon-corretto-devel
RUN dnf install -y libXext libXrender libXtst libXi freetype procps 
RUN dnf install -y git
#gcompat
CMD ["bash"]
# COPY main-0.0.1-SNAPSHOT.jar .
# COPY application.yml .
# EXPOSE 8080
# HEALTHCHECK CMD curl -f http://localhost:8080/actuator/health || exit 1
# CMD ["java", "-jar", "/main-0.0.1-SNAPSHOT.jar"]
