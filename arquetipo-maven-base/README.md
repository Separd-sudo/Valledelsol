# Arquetipo Maven Base - Valle del Sol 🏗️

Este módulo contiene la estructura y configuración estandarizada de Maven para la creación de nuevos componentes backend en el ecosistema del proyecto.

## 📋 Propósito
Garantizar la coherencia arquitectónica, la escalabilidad y el rendimiento del sistema, forzando a que cualquier microservicio cuente con las mismas dependencias base (Spring Boot, JPA, PostgreSQL y herramientas de pruebas unitarias).

## 🚀 Cómo usar este Arquetipo para un nuevo Microservicio

Para generar un nuevo microservicio utilizando esta base estructurada, el equipo de desarrollo debe seguir estos pasos:

1. Copiar la estructura base de este directorio.
2. Definir el nuevo nombre del servicio en las etiquetas `<artifactId>` y `<name>` dentro del archivo `pom.xml`.
3. Crear la estructura de paquetes estándar bajo el dominio: `cl.duoc.valledelsol.ms.[nombre_servicio]`.
4. Añadir el nuevo servicio al archivo `docker-compose.yml` de la raíz para su orquestación y despliegue automatizado.