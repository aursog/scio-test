FROM openjdk:11
RUN mvn clean package spring-boot:repackage
ARG JARFILE=test-0.0.1-SNAPSHOT.jar
COPY target/${JARFILE} /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]