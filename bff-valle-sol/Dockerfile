# =========================================================
# ETAPA 1 — COMPILACIÓN DEL BFF
# =========================================================

FROM maven:3.9-eclipse-temurin-17 AS builder

WORKDIR /app

COPY . .

RUN mvn clean package -DskipTests


# =========================================================
# ETAPA 2 — EJECUCIÓN
# =========================================================

FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]