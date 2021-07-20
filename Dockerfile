FROM openjdk:11
MAINTAINER Gabriel Pedrico
WORKDIR proposta
EXPOSE 8080
ADD target/*.jar /proposta/proposta.jar
ENTRYPOINT ["java","-jar","proposta.jar"]

