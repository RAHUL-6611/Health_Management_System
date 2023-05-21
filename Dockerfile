FROM openjdk:11
EXPOSE 8080
WORKDIR /usr/src/myapp
COPY target/Health-Manegment-System-0.0.1.jar /usr/src/myapp
CMD ["java","-jar","/usr/src/myapp/Health-Manegment-System-0.0.1.jar"]