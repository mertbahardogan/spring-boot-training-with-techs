FROM openjdk:11
ENV APP_HOME=/usr/app/
EXPOSE 8000
WORKDIR $APP_HOME
COPY "/target/employee-0.0.1-SNAPSHOT.jar" app.jar
CMD [ "java", "-jar", "app.jar" ]