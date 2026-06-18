# Valledelsol

# Municipalidad Valle del Sol 

Proyecto académico desarrollado para la asignatura Desarrollo Fullstack III.

El sistema busca apoyar a la Municipalidad Valle del Sol en la gestión de reportes de incendios, usuarios, roles y alertas, aplicando componentes frontend y backend, patrones de diseño, arquitectura por capas, microservicios, BFF y estrategia de branching.

## Arquitectura general

Frontend → BFF → API Gateway → Microservicios → Bases de datos

## Componentes

- Frontend Valle del Sol
- Patrón BFF (Backend-for-Frontend): Actúa como el único punto de contacto para la interfaz de React. Se  encarga de agregar datos de múltiples microservicios, formatear respuestas ligeras y mitigar la         sobre-comunicación por red desde el cliente.
- Kong API Gateway DB Less
- Aislamiento Perimetral: Los microservicios de negocio (ms-usuarios, ms-reportes, ms-auth, ms-alertas, ms-geografico, ms-analitica) no exponen puertos al internet público. Operan dentro de la red aislada valle-network y solo atienden peticiones autenticadas provenientes de Kong.


- 🛠️ Tecnologías y Patrones Aplicados
- Backend (Capas de Diseño)
En cada microservicio se implementó una arquitectura limpia segregada en capas de responsabilidad única:
- Controller: Endpoints REST que interceptan el tráfico HTTP. No procesan lógica (@RestController).
- Service: Orquestador de lógica de negocios, reglas operativas y transformaciones lógicas (@Service).
- DTO (Data Transfer Object): Estructuras que viajan por la red para evitar la exposición directa de Entidades de Base de Datos.
- Repository (JPA): Abstracción de acceso a datos conectada a dialectos PostgreSQL nativos (@Repository).
- Listener (Kafka):

- Infraestructura Automatizada (Docker)
- El archivo docker-compose.yml gestiona un despliegue de contenedores concurrentes:
- postgres-usuarios: Motor de datos relacional para usuarios en el puerto mapeado 5434.
- postgres-reportes: Motor de datos relacional para reportes en el puerto mapeado 5433.
- kong-database: PostgreSQL dedicado en el puerto 5435 que almacena el catálogo dinámico de rutas de Kong.
- kong-migrations: Tarea efímera de Bootstrap que inicializa el esquema relacional del Gateway.
- kong-gateway: Motor del API Gateway escuchando tráfico público en el puerto 8000 y administración en el 8001.
- Microservicios y BFF compilados en entornos portables basados en contenedores Linux Alpine.

- 🚀 Despliegue Rápido del Ecosistema

- Requisitos Previos
- Docker Desktop instalado y corriendo.
- Terminal Git Bash.

- Inicialización de Variables
Asegurarse de poseer el archivo .env configurado en la raíz del proyecto. Estructura base utilizada:

- Orquestación de Contenedores
Ejecutar desde la raíz para limpiar la caché de datos e inicializar la infraestructura limpia:
- docker compose down -d
- docker compose up -d

- Inyección Dinámica de Rutas en Kong
- Ejecutar las siguientes llamadas REST estructuradas en la consola Git Bash para mapear los Upstreams perimetrales manteniendo los prefijos de rutas nativos: (consultar por rutas)

- 🧪 Verificación y Testeo del Entorno

- Verificación de Enrutamiento: Consumir mediante navegador o Postman el endpoint expuesto por la aduana: http://localhost:8000/api/usuarios. Debe retornar el payload JSON nativo con estado 200 OK.

- Pruebas Unitarias

- 🌿 Estrategia de Branching (GitFlow Simplificado)

- main / master: Código certificado listo para despliegue productivo.
- develop: Eje de integración continua donde se consolidan las funcionalidades técnicas estables del laboratorio.
- Mensajes de confirmación bajo el estándar de Conventional Commits (feat:, fix:, infra:, test:).