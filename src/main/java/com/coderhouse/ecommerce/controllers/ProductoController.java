package com.coderhouse.ecommerce.controllers;

import com.coderhouse.ecommerce.abstracts.Producto;
import com.coderhouse.ecommerce.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ResponseEntity<List<Producto>> getAllProductos() {
        try {
            List<Producto> productos = productoService.findAll();
            return ResponseEntity.ok(productos);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{productoId}")
    public ResponseEntity<Producto> getProductoById(@PathVariable Long productoId) {
        try {
            Producto producto = productoService.findById(productoId);
            return ResponseEntity.ok(producto);
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Producto> createProducto(@RequestBody Producto producto) {
        try {
            Producto creado = productoService.save(producto);
            return ResponseEntity.status(HttpStatus.CREATED).body(creado);
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/{productoId}")
    public ResponseEntity<Producto> updateProductoById(
            @PathVariable Long productoId,
            @RequestBody Producto productoUpdated) {
        try {
            Producto producto = productoService.update(productoId, productoUpdated);
            return ResponseEntity.ok(producto);
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/{productoId}")
    public ResponseEntity<Void> deleteProductoById(@PathVariable Long productoId) {
        try {
            productoService.deleteById(productoId);
            return ResponseEntity.noContent().build();
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
