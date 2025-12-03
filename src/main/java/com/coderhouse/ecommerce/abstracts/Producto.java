package com.coderhouse.ecommerce.abstracts;

import com.coderhouse.ecommerce.entities.Accesorio;
import com.coderhouse.ecommerce.entities.Ropa;
import com.coderhouse.ecommerce.exceptions.StockInsuficienteException;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

@Schema(
        description = "Modelo abstracto de Producto. Puede representar una prenda de ropa o un accesorio.",
        discriminatorProperty = "tipo",
        oneOf = {Ropa.class, Accesorio.class},
        example = """
    {
      "tipo": "ropa",
      "id_prod": 10,
      "nombre": "Remera Oversize",
      "precio": 15999.99,
      "stock": 35
    }
    """
)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "tipo"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Ropa.class, name = "ropa"),
        @JsonSubTypes.Type(value = Accesorio.class, name = "accesorio")
})
@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "productos")
public abstract class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(
            description = "ID único del producto",
            example = "10",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    protected long id_prod;

    @Column(name = "nombre", nullable = false)
    @Schema(
            description = "Nombre del producto",
            example = "Remera Oversize",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    protected String nombre;

    @Column(name = "precio", nullable = false)
    @Schema(
            description = "Precio del producto",
            example = "15999.99",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    protected double precio;

    @Column(name = "stock", nullable = false)
    @Schema(
            description = "Cantidad disponible en stock",
            example = "35",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    protected int stock;

    public Producto() {}

    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    /**
     * Reduce el stock disponible del producto.
     * Este método lanza StockInsuficienteException si se intenta
     * extraer más unidades de las disponibles.
     */
    @Schema(
            description = "Reduce el stock del producto. Lanza excepción si no hay suficiente stock.",
            example = "reducirStock(2)"
    )
    public void reducirStock(int cantidad) {
        if (cantidad > stock) throw new StockInsuficienteException();
        stock -= cantidad;
    }
}
