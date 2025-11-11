package com.coderhouse.ecommerce.controllers;

import com.coderhouse.ecommerce.abstracts.Producto;
import com.coderhouse.ecommerce.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping
    public ResponseEntity<List<Producto>> getAllProducts() {
        try {
            List<Producto> products = productoRepository.findAll();
            return ResponseEntity.ok(products);
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Producto> getProductById(@PathVariable Long productId){
        try {
            if(productoRepository.existsById(productId)) {
                Producto p=productoRepository.findById(productId).get();
                return ResponseEntity.ok(p);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Producto> createProduct(@RequestBody Producto prod) {
        try {
            Producto pCreado = productoRepository.save(prod);
            return ResponseEntity.status(HttpStatus.CREATED).body(pCreado);
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}



