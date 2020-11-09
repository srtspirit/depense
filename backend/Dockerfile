FROM adoptopenjdk/openjdk11:alpine-jre
RUN mkdir /opt/app
COPY target/depense-1.0-SNAPSHOT.jar /opt/app
CMD ["java", "-jar", "/opt/app/depense-1.0-SNAPSHOT.jar"]
