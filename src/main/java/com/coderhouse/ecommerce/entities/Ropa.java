package com.coderhouse.ecommerce.entities;

import com.coderhouse.ecommerce.abstracts.Producto;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ropa")
public class Ropa extends Producto {
    private String talle;
    private String color;

}
