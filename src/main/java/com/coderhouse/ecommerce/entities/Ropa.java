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
        description = "Modelo que representa una prenda de ropa",
        example = """
    {
      "tipo": "ropa",
      "id_prod": 21,
      "nombre": "Campera de Jean",
      "precio": 45999.50,
      "stock": 12,
      "talle": "M",
      "color": "Azul"
    }
    """
)
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ropa")
public class Ropa extends Producto {

    @Schema(
            description = "Talle de la prenda",
            example = "M",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String talle;

    @Schema(
            description = "Color de la prenda",
            example = "Azul",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String color;
}
