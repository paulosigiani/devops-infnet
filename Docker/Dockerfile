FROM amazoncorretto:17
LABEL authors="paulopalmuti"
WORKDIR /app
COPY ./Docker/app.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]