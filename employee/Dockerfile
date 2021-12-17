FROM openjdk:11
ENV APP_HOME=/usr/app/
ARG JAR_FILE=/target/employee-0.0.1-SNAPSHOT.jar
EXPOSE 8000
WORKDIR $APP_HOME
COPY ${JAR_FILE} app.jar
CMD [ "java", "-jar", "app.jar" ]

#AFTER DOCKERIZE: second field dependent localhost in docker run ports.
#docker build -t employee .
#docker run -p 8000:8000 employee