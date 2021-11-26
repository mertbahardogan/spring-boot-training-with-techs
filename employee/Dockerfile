#Initiliazes a new build stage, must be start
FROM openjdk:11

#Can’t change ENV directly during the build
ENV APP_HOME=/usr/app/

#ARG values are not available after the image is built  ??
ARG JAR_FILE=/target/employee-0.0.1-SNAPSHOT.jar

#Tells which port it will run on
EXPOSE 8000

#Changes the working directory to APP_HOME
WORKDIR $APP_HOME

#Copy JAR_FILE to APP_HOME/app.jar
COPY ${JAR_FILE} app.jar

#Run the jar file
CMD [ "java", "-jar", "app.jar" ]


#Works resembly with CMD
#ENTRYPOINT

#AFTER DOCKERIZE: second field dependent localhost in docker run ports.
#docker build -t employee .
#docker run -p 8000:8000 employee