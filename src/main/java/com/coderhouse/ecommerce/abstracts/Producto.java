package com.coderhouse.ecommerce.abstracts;

import com.coderhouse.ecommerce.entities.Accesorio;
import com.coderhouse.ecommerce.entities.Ropa;
import com.coderhouse.ecommerce.exceptions.StockInsuficienteException;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import lombok.Data;


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
    protected long id_prod;

    @Column(name = "nombre", nullable = false)
    protected String nombre;

    @Column(name = "precio", nullable = false)
    protected double precio;

    @Column(name = "stock", nullable = false)
    protected int stock;

    /* Constructores */

    public Producto() {}

    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    /* Getters y Setters */

    /* Metodos */

    public void reducirStock(int cantidad) {
        if (cantidad > stock) throw new StockInsuficienteException();
        stock -= cantidad;
    }
}
