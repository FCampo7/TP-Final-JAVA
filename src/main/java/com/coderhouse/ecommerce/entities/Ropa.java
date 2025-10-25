package com.coderhouse.ecommerce.entities;

import com.coderhouse.ecommerce.abstracts.Producto;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "ropa")
public class Ropa extends Producto {
    private String talle;
    private String color;

    /* Constructores */

    public Ropa() {
    }

    public Ropa(String nombre, double precio, int stock, String talle, String color) {
        super(nombre, precio, stock);
        this.talle=talle;
        this.color=color;
    }

    /* Getters y Setters */

    public String getTalle() {
        return talle;
    }

    public void setTalle(String talle) {
        this.talle = talle;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
