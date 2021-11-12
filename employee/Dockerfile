FROM openjdk:11
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
EXPOSE 8080
COPY "/target/employee-0.0.1-SNAPSHOT.jar" app.jar
CMD [ "java", "-jar", "app.jar" ]

