# Usa la imagen base de OpenJDK 17 en Alpine
FROM openjdk:21-jdk

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el JAR compilado de tu aplicación al contenedor
COPY target/classicmodels-0.1.1-SNAPSHOT.jar /app/classicmodels.jar

# Expone el puerto en el que se ejecutará tu aplicación
EXPOSE 8080

# Comando para ejecutar tu aplicación cuando se inicie el contenedor
CMD ["java", "-jar", "classicmodels.jar"]