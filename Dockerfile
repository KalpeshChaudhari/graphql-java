FROM alpine/git as clone
WORKDIR /app
RUN git clone https://github.com/amitmindstix/graphql-java.git
WORKDIR /app/graphql-java
RUN git checkout springboot-graphql

FROM maven:3.5-jdk-8-alpine as build
WORKDIR /app
COPY --from=clone /app/graphql-java /app
RUN mvn install

FROM openjdk:8-jre-alpine
MAINTAINER Amit Mujawar <amit.mujawar@mindstix.com>
WORKDIR /app
COPY --from=build /app/target/graphql-example-1.0.jar /app
ENTRYPOINT ["java", "-jar", "graphql-example-1.0.jar"]

EXPOSE 8090
