# service-persona

Microservicio REST desarrollado con **Spring Boot 4** y **Java 21**, que expone personas mayores de edad consultadas desde una base de datos MySQL. Implementa **Arquitectura Hexagonal (Ports & Adapters)**.

---

## Tecnologías

| Tecnología | Versión |
|---|---|
| Java | 21 |
| Spring Boot | 4.0.6 |
| Spring Data JPA | - |
| MySQL Connector | 9.6.0 |
| SpringDoc OpenAPI (Swagger) | 2.5.0 |
| Lombok | - |
| Docker | - |

---

## Arquitectura Hexagonal

```
com.empresa
├── dominio
│   └── model/dto
│       └── Persona.java              # Modelo de dominio
├── application
│   ├── port/in
│   │   └── PersonaPortIn.java        # Puerto de entrada (caso de uso)
│   ├── port/out
│   │   └── PersonaPortOut.java       # Puerto de salida (acceso a datos)
│   └── usecase
│       └── PersonaUseCase.java       # Lógica de negocio
└── infrastructure
    ├── controller
    │   └── PersonaController.java    # Adaptador REST (entrada)
    ├── mysql/adapter
    │   └── ConsultaMysqlJpaAdapter   # Adaptador JPA MySQL (salida)
    └── persistence
        ├── entity/PersonaEntity.java
        └── repository/PersonaRepository.java
```

---

## API REST

Base URL: `http://localhost:8011/api/persona`

### GET `/mayoredad`

Retorna la lista de personas con edad mayor o igual a 18 años.

**Respuestas:**

| Código | Descripción |
|---|---|
| `200 OK` | Lista de personas mayores de edad |
| `204 No Content` | No existen personas mayores de edad |
| `500 Internal Server Error` | Error interno del servidor |

**Ejemplo de respuesta `200`:**
```json
[
  { "nombre": "Carlos", "apellido": "Perez", "edad": 25 },
  { "nombre": "Ana",    "apellido": "Gomez", "edad": 30 }
]
```

---

## Documentación Swagger

Con la aplicación corriendo, acceder a:

```
http://localhost:8011/swagger-ui/index.html
```

---

## Configuración

`src/main/resources/application.properties`:

```properties
server.port=8011
spring.datasource.url=jdbc:mysql://localhost:3307/personas_db
spring.datasource.username=root
spring.datasource.password=123456
```

### Tabla requerida en MySQL

```sql
CREATE DATABASE IF NOT EXISTS personas_db;

USE personas_db;

CREATE TABLE persona (
  id       BIGINT AUTO_INCREMENT PRIMARY KEY,
  nombre   VARCHAR(100) NOT NULL,
  apellido VARCHAR(100) NOT NULL,
  edad     INT          NOT NULL
);
```

---

## Ejecutar con Docker

> MySQL debe estar corriendo de forma externa en el puerto `3307`.

```bash
docker-compose up --build
```

La aplicación quedará disponible en `http://localhost:8011`.

---

## Ejecutar de forma local

```bash
./mvnw spring-boot:run
```

O compilar y ejecutar el JAR:

```bash
./mvnw clean package -DskipTests
java -jar target/service-persona-0.0.1-SNAPSHOT.jar
```
