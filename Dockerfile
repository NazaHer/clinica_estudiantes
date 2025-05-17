#Imagen base
FROM openjdk:17-jdk-slim

#Argumentos
ARG JAR_FILE=target/clinicaestudiantes-0.0.1.jar

#Copia
COPY ${JAR_FILE} app.jar

#Puerto
EXPOSE 8080

#Configuración
ENTRYPOINT ["java", "-jar", "app.jar"]

