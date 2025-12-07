package com.coderhouse.ecommerce.entities;

import com.coderhouse.ecommerce.abstracts.Producto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Schema(
        description = "Modelo que representa un accesorio dentro del catálogo de productos.",
        example = """
    {
      "tipo": "accesorio",
      "id_prod": 5,
      "nombre": "Collar de Acero Inoxidable",
      "precio": 19999.99,
      "stock": 20,
      "material": "Acero inoxidable"
    }
    """
)
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "accesorios")
public class Accesorio extends Producto {

    @Schema(
            description = "Material principal del accesorio",
            example = "Acero inoxidable",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String material;
}
