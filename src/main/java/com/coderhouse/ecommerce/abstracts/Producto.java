package com.coderhouse.ecommerce.abstracts;

import com.coderhouse.ecommerce.exceptions.StockInsuficienteException;
import jakarta.persistence.*;

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

    public long getId_prod() {
        return id_prod;
    }

    public void setId_prod(long id_prod) {
        this.id_prod = id_prod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    /* Metodos */

    public void reducirStock(int cantidad) {
        if (cantidad > stock) throw new StockInsuficienteException();
        stock -= cantidad;
    }
}
