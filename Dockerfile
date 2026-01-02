FROM eclipse-temurin:17-jdk-jammy

LABEL maintainer="marouane"
EXPOSE 7070

WORKDIR /app
COPY target/marouanesupplychains.war /app/marouanesupplychains.war

ENTRYPOINT ["java", "-jar", "marouanesupplychains.war"]