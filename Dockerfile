FROM eclipse-temurin:17-jdk-jammy

LABEL maintainer="foullane"
EXPOSE 7070

WORKDIR /app
COPY target/marouanesupplychains.war /app/marouanesupplychains.war

ENTRYPOINT ["java", "-jar", "marouanesupplychains.war"]