FROM maven:latest
RUN curl -L -o /mysql-connector-java.jar https://repo1.maven.org/maven2/mysql/mysql-connector-java/8.0.25/mysql-connector-java-8.0.25.jar
ENV CLASSPATH=/mysql-connector-java.jar:${CLASSPATH}
RUN mkdir -p /usr/src
COPY app /usr/src/app
WORKDIR /usr/src/app
CMD ["mvn", "spring-boot:run"]
