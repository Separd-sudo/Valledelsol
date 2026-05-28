# =========================================================
# ETAPA 1 — COMPILACIÓN DEL PROYECTO
# =========================================================
# Esta etapa utiliza Maven + Java 17 para compilar
# el microservicio y generar el archivo .jar.
# =========================================================

FROM maven:3.9-eclipse-temurin-17 AS builder

# Directorio de trabajo dentro del contenedor.
WORKDIR /app

# Copiamos todos los archivos del proyecto.
COPY . .

# Compila el proyecto y genera el .jar.
# Se omiten tests para acelerar el build Docker.
RUN mvn clean package -DskipTests


# =========================================================
# ETAPA 2 — EJECUCIÓN DEL MICROSERVICIO
# =========================================================
# Utilizamos una imagen más liviana solamente
# para ejecutar la aplicación.
# =========================================================

FROM eclipse-temurin:17-jdk

# Directorio interno del contenedor.
WORKDIR /app

# Copiamos el .jar compilado desde la etapa builder.
COPY --from=builder /app/target/*.jar app.jar

# Puerto utilizado por el microservicio.
EXPOSE 8082

# Comando que inicia la aplicación Spring Boot.
ENTRYPOINT ["java", "-jar", "app.jar"]