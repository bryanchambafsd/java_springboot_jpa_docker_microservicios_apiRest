# Java Spring Boot + JPA + Docker + Microservicios + API REST

## Descripción
Este proyecto es una aplicación basada en microservicios desarrollada con Java Spring Boot, utilizando JPA para la gestión de base de datos y Docker para la contenerización. Expone una API REST para gestionar clientes y sus movimientos financieros.

## Tecnologías Utilizadas
- **Java 17**
- **Spring Boot 3**
- **Spring Data JPA**
- **PostgreSQL**
- **Docker & Docker Compose**
- **Arquitectura de Microservicios**
- **JUnit & Mockito** (para pruebas unitarias e integración)

## Requisitos Previos
Antes de ejecutar el proyecto, asegúrate de tener instalados:

- [Java 21](https://adoptium.net/)
- [Maven 3+](https://maven.apache.org/)
- [Docker & Docker Compose](https://www.docker.com/)
- [Git](https://git-scm.com/)

## Instalación y Ejecución

### 1. Clonar el repositorio
```sh
 git clone https://github.com/bryanchambafsd/java_springboot_jpa_docker_microservicios_apiRest.git
 cd java_springboot_jpa_docker_microservicios_apiRest
```

### 2. Configurar Base de Datos
Este proyecto usa PostgreSQL. Puedes iniciar el servicio con Docker usando el siguiente comando:
```sh
 docker-compose up -d
```

Esto iniciará:
- Un contenedor con PostgreSQL
- Los microservicios de clientes y movimientos

### 3. Construir y Ejecutar los Microservicios
Para construir y ejecutar cada microservicio manualmente:
```sh
 cd microservice1
 mvn clean install
 mvn spring-boot:run
```
```sh
 cd ../microservice2
 mvn clean install
 mvn spring-boot:run
```

También puedes usar Docker Compose para levantar todo el sistema:
```sh
 docker-compose up --build
```