# TP Fnal JAVA de la diplomatura en desarrollo full stack web de CoderHouse

## 📦 Qué es este proyecto
**TP-Final-JAVA** es un backend para una tienda online (e-commerce) desarrollado en **Java + Spring Boot**.  
Permite gestionar **usuarios** y **productos** (con subtipos: *Ropa* y *Accesorios*) utilizando herencia JPA, DTOs, servicios, repositorios y controladores REST.

Es el proyecto final de la diplomatura Full-Stack Web de CoderHouse.

---

## 🧩 Funcionalidades principales

- CRUD completo de **Productos**
    - Producto base `Producto`
    - Subclases `Ropa` y `Accesorio` usando *Herencia JOINED*
- CRUD de **Usuarios**
- API REST organizada y extensible
- Manejo de excepciones básicas
- Serialización polimórfica mediante `@JsonTypeInfo`
- Arquitectura en capas: Controller → Service → Repository → Entity

---

## 📁 Estructura del proyecto
```bash
./src
└── main
    ├── java
    │   └── com
    │       └── coderhouse
    │           └── ecommerce
    │               ├── abstracts
    │               │   └── Producto.java
    │               ├── config
    │               │   └── OpenApiConfig.java
    │               ├── controllers
    │               │   ├── ProductoController.java
    │               │   └── UsuarioController.java
    │               ├── dao
    │               │   └── DaoFactory.java
    │               ├── dto
    │               │   ├── AccesorioDTO.java
    │               │   ├── ProductoDTO.java
    │               │   └── RopaDTO.java
    │               │   └── UsuarioDTO.java
    │               ├── EcommerceApplication.java
    │               ├── entities
    │               │   ├── Accesorio.java
    │               │   ├── Ropa.java
    │               │   └── Usuario.java
    │               ├── exceptions
    │               │   └── StockInsuficienteException.java
    │               ├── interfaces
    │               │   └── CRUDInterface.java
    │               ├── repositories
    │               │   ├── ProductoRepository.java
    │               │   └── UsuarioRepository.java
    │               └── services
    │                   ├── ProductoService.java
    │                   └── UsuarioService.java
    └── resources
        ├── application.properties
        └── Entrega Java.postman_collection.json

```

---

## 🛠 Tecnologías utilizadas

* Java 
* Spring Boot 
* Spring Data JPA / Hibernate 
* Maven

---

## 🙋 Autor

 ### Francisco Campo — desarrollador / autor original

---

## 📝 Licencia

Este proyecto está bajo MIT License