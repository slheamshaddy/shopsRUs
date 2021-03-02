FROM openjdk:11-jdk-slim
ADD target/shopsRUs.jar shopsRUs.jar
EXPOSE 8088
ENTRYPOINT ["java","-jar","shopsRUs.jar"]