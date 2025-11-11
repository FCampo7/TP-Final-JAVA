package com.coderhouse.ecommerce.dto;

import com.coderhouse.ecommerce.abstracts.Producto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoDTO {
    private Long id;
    private String nombre;
    private Double precio;
    private Integer stock;

    public ProductoDTO(Producto producto) {
        this.id = producto.getId_prod();
        this.nombre = producto.getNombre();
        this.precio = producto.getPrecio();
        this.stock = producto.getStock();
    }
}
