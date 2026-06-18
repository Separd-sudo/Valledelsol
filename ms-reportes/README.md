# 👥 Microservicio de Usuarios y Roles (`ms-usuarios`)

Componente central del ecosistema **Valle del Sol** encargado de la administración, control de acceso y gestión de perfiles institucionales para la Municipalidad.

## 🚀 Requisitos e Infraestructura
* **Java 17** y **Spring Boot 3.x**
* **Base de datos:** PostgreSQL (`usuarios_db`) corriendo en puerto `5432` vía Docker.

## 🛠️ Arquitectura y Patrones
* **Domain-Driven Design (DDD):** Implementado como un Contexto Delimitado autónomo con persistencia independiente para asegurar alta cohesión y bajo acoplamiento.
* **Separación por Capas:** Estructura organizada estrictamente en `controller`, `service`, `repository`, `model` y `dto`.

## 📋 Contrato de Integración REST
* **POST `/api/v1/usuarios`** - Registro de nuevos usuarios (Ciudadano, Brigadista, Funcionario).
* **GET `/api/v1/usuarios/{id}`** - Consulta de perfil.

### Ejemplo de Payload (Request JSON)
```json
{
  "nombre": "Brandon",
  "apellido": "González",
  "correo": "brandon.ingeniero@valle.cl",
  "password": "PasswordSegura123",
  "telefono": "+56912345678",
  "rut": "12345678-9",
  "rol": "CIUDADANO",
  "institucion": "CONAF",
  "region": "Valparaíso"
}