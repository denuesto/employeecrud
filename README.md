# employeecrud
# 🚀 Employee CRUD API - Spring Boot 3

Este proyecto es una API REST robusta diseñada para la gestión de empleados. Implementa un stack tecnológico moderno centrado en la seguridad, el rendimiento y la trazabilidad.

## 🛠️ Tecnologías y Frameworks
* **Java 17**: Lenguaje base.
* **Spring Boot 3.5**: Framework principal para el desarrollo ágil.
* **Spring Security + JWT**: Autenticación y autorización basada en tokens stateless.
* **Spring Data JPA**: Abstracción de persistencia con Hibernate.
* **MySQL**: Motor de base de datos relacional.
* **Lombok & MapStruct**: Para reducción de código redundante y mapeo eficiente de DTOs.
* **Logback**: Configuración avanzada de logging con rotación por tamaño y tiempo.
* **Spring Boot Actuator**: Monitoreo de salud y métricas del sistema.

## 🔐 Seguridad
La API utiliza **JSON Web Tokens (JWT)**.
1. **Configuración**: Actualmente configurada con **InMemoryUserDetailsManager** (credenciales definidas en `application.properties`).
2. **Formato de Error**: Los errores de autenticación (401 Unauthorized) han sido personalizados para devolver un JSON coherente con el resto de la aplicación.
3. **Persistencia**: Preparado estructuralmente para migrar a una tabla de usuarios en MySQL.

## 📁 Estructura del Proyecto
```text
src/main/java/com/employee/
 ├── controller/   # Endpoints REST (Employee, Auth)
 ├── service/      # Lógica de negocio e interfaces
 ├── repository/   # Repositorios JPA
 ├── entity/       # Entidades de base de datos
 ├── dto/          # Objetos de transferencia (Request/Response)
 ├── jwt/          # Filtros, Utilidades y Configuración de JWT
 └── exception/    # Manejo global de excepciones
```

## 📁 instalación
Base de Datos: Crear esquema evaluacion en MySQL local a partir del archivo **employee_script.sql**

mvn clean install
mvn spring-boot:run