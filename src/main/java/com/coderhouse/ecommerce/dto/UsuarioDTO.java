package com.coderhouse.ecommerce.dto;

import com.coderhouse.ecommerce.entities.Usuario;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(
        description = "Objeto de Transferencia de Datos del Usuario",
        example = """
    {
      "id": 1,
      "nombre": "Juan",
      "apellido": "Pérez",
      "email": "juan.perez@example.com",
      "dni": 40123456,
      "direccion": "Calle Falsa 123",
      "rol": "Cliente"
    }
    """
)
public class UsuarioDTO {

    @Schema(
            description = "ID único del usuario",
            example = "1",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private Long id;

    @Schema(
            description = "Nombre del usuario",
            example = "Juan",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String nombre;

    @Schema(
            description = "Apellido del usuario",
            example = "Pérez",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String apellido;

    @Schema(
            description = "Correo electrónico único del usuario",
            example = "juan.perez@example.com",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String email;

    @Schema(
            description = "Documento nacional de identidad",
            example = "40123456",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private long dni;

    @Schema(
            description = "Dirección física del usuario",
            example = "Calle Falsa 123",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String direccion;

    @Schema(
            description = "Rol del usuario en el sistema",
            example = "Cliente",
            requiredMode = Schema.RequiredMode.REQUIRED,
            allowableValues = {"Cliente", "Administrador"}
    )
    private String rol;

    public UsuarioDTO(Usuario usuario) {
        this.id = usuario.getID();
        this.nombre = usuario.getNombre();
        this.apellido = usuario.getApellido();
        this.email = usuario.getEmail();
        this.dni = usuario.getDNI();
        this.direccion = usuario.getDireccion();
        this.rol = usuario.getRol();
    }
}
