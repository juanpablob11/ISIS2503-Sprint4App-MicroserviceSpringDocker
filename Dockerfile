# Usar una imagen base de Java
FROM openjdk:17-jdk-slim

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el JAR construido en el directorio de trabajo
COPY target/arquisoft-spring4-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto en el que tu aplicación correrá
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
