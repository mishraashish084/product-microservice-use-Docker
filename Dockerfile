FROM openjdk:11
LABEL maintainer="mini.net"
ADD target/demo.first.microproject-0.0.1-SNAPSHOT.jar docker-spring-boot.jar
EXPOSE:8085
ENTRYPOINT ["java", "-jar", "docker-spring-boot.jar"]
