package com.coderhouse.ecommerce.entities;

import com.coderhouse.ecommerce.abstracts.Producto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "accesorios")
public class Accesorio extends Producto {

    private String material;

    /* Constructores */

    public Accesorio() {
    }

    public Accesorio(String nombre, double precio, int stock, String material) {
        super(nombre, precio, stock);
        this.material=material;
    }

    /* Getters y Setters */

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
