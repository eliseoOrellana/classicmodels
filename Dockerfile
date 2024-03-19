# Use an official Maven image as the base image
FROM maven:3.9-amazoncorretto-21 AS build
# Set the working directory in the container
WORKDIR /app
# Copy the pom.xml and the project files to the container
COPY pom.xml .
COPY src ./src
# Build the application using Maven
RUN mvn clean package -DskipTests

# Usa la imagen base de OpenJDK 17 en Alpine
FROM openjdk:21-jdk

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el JAR compilado de tu aplicación al contenedor
COPY --from=build /app/target/classicmodels-0.1.1-SNAPSHOT.jar .


# Expone el puerto en el que se ejecutará tu aplicación
EXPOSE 8080

# Comando para ejecutar tu aplicación cuando se inicie el contenedor
CMD ["java", "-jar", "classicmodels-0.1.1-SNAPSHOT.jar"]