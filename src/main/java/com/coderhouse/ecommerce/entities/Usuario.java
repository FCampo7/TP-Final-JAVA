package com.coderhouse.ecommerce.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Schema(
        description = "Modelo de Usuario del sistema",
        example = """
    {
      "id": 1,
      "nombre": "Juan",
      "apellido": "Pérez",
      "email": "juan.perez@example.com",
      "password": "123456",
      "dni": 40123456,
      "direccion": "Calle Falsa 123",
      "rol": "Cliente"
    }
    """
)
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(
            description = "ID único del usuario",
            example = "1",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    protected long ID;

    @Column(name = "nombre", nullable = false)
    @Schema(
            description = "Nombre del usuario",
            example = "Juan",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    protected String Nombre;

    @Column(name = "apellido", nullable = false)
    @Schema(
            description = "Apellido del usuario",
            example = "Pérez",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    protected String Apellido;

    @Column(name = "email", nullable = false, unique = true)
    @Schema(
            description = "Correo electrónico único del usuario",
            example = "juan.perez@example.com",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    protected String Email;

    @Column(name = "password", nullable = false)
    @Schema(
            description = "Contraseña del usuario (debería enviarse encriptada)",
            example = "hashed_password",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    protected String Password;

    @Column(name = "dni", nullable = false, unique = true)
    @Schema(
            description = "Documento nacional de identidad",
            example = "40123456",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    protected long DNI;

    @Column(name = "direccion", nullable = false)
    @Schema(
            description = "Dirección física del usuario",
            example = "Calle Falsa 123",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    protected String Direccion;

    @Column(name = "rol", nullable = false)
    @Schema(
            description = "Rol del usuario en el sistema",
            example = "Cliente",
            requiredMode = Schema.RequiredMode.REQUIRED,
            allowableValues = {"Cliente", "Administrador"}
    )
    protected String Rol; //Rol puede ser Cliente o Administrador

    /* Constructores */

    public Usuario() {
        this.Rol="Cliente";
    }

    public Usuario(String nombre, String apellido, String email, String password, long DNI, String direccion) {
        this.Nombre = nombre;
        this.Apellido = apellido;
        this.Email = email;
        this.Password = password;
        this.DNI = DNI;
        this.Direccion = direccion;
        this.Rol="Cliente";
    }

}
