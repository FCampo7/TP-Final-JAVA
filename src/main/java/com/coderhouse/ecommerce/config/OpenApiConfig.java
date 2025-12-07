package com.coderhouse.ecommerce.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    OpenAPI customOpenAPI() {
        return new OpenAPI().info(new Info()
                .title("API REST Full | Java | CoderHouse | ecommerce")
                .version("1.0.0")
                .description("La API Rest proporciona endpoints para usuarios y productos de una plataforma de ecommerce. " +
                        "Permite realizar operaciones CRUD tanto para usuarios como para productos. " +
                        "Los endpoints permiten listar, agregar, editar y eliminar usuarios y productos. " +
                        "La API está documentada con Swagger.")
                .contact(new Contact()
                        .name("Francisco Luis Campo")
                        .email("fcampo7@hotmail.com")
                        .url("https://fcampo.vercel.app/"))
        )
                .servers(List.of(
                new Server()
                        .url("http://localhost:8080")
                        .description("Servidor Local"))
        )
                .externalDocs(new ExternalDocumentation()
                        .description("Documentación técnica del proyecto")
                        .url(null));
    }
}
