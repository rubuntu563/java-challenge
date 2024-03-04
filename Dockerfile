FROM adoptopenjdk/openjdk11:alpine-jre

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline

#COPY src ./src
COPY target/java-challenge-0.0.1-SNAPSHOT.jar java-challenge-0.0.1-SNAPSHOT.jar

CMD ["./mvnw", "spring-boot:run"]