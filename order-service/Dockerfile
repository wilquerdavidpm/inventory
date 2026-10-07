# 1. Imagen base con Java Temurin 25
FROM eclipse-temurin:25-jdk-alpine

# 2. Directorio de trabajo dentro del contenedor
WORKDIR /app

# 3. Copiamos el JAR generado por Maven al contenedor
COPY target/order-service-0.0.1-SNAPSHOT.jar app.jar

# 4. Exponemos el puerto que usa Spring Boot
EXPOSE 8081

# 5. Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]