package com.coderhouse.ecommerce.controllers;

import com.coderhouse.ecommerce.abstracts.Producto;
import com.coderhouse.ecommerce.entities.Usuario;
import com.coderhouse.ecommerce.services.ProductoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Listar todos los productos")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Productos Listados correctamente", content = {
                            @Content(mediaType = "Aplication/json", schema = @Schema(implementation = Producto.class))
                    }),
                    @ApiResponse(responseCode = "500", description = "Error Interno de Servidor", content = @Content)
            }
    )
    @GetMapping
    public ResponseEntity<List<Producto>> getAllProductos() {
        try {
            List<Producto> productos = productoService.findAll();
            return ResponseEntity.ok(productos);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @Operation(summary = "Obtener un producto por su ID")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Producto Listado correctamente", content = {
                            @Content(mediaType = "Aplication/json", schema = @Schema(implementation = Producto.class))
                    }),
                    @ApiResponse(responseCode = "404", description = "Producto no encontrado", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Error Interno de Servidor", content = @Content)
            }
    )
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

    @Operation(summary = "Crear un producto")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Producto creado correctamente", content = {
                            @Content(mediaType = "Aplication/json", schema = @Schema(implementation = Producto.class))
                    }),
                    @ApiResponse(responseCode = "500", description = "Error Interno de Servidor", content = @Content)
            }
    )
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

    @Operation(summary = "Actualizar un producto por su ID")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Producto actualizado correctamente", content = {
                            @Content(mediaType = "Aplication/json", schema = @Schema(implementation = Producto.class))
                    }),
                    @ApiResponse(responseCode = "404", description = "Producto no encontrado", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Error Interno de Servidor", content = @Content)
            }
    )
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

    @Operation(summary = "Eliminar un producto por su ID")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Producto Listado correctamente", content = {
                            @Content(mediaType = "Aplication/json", schema = @Schema(implementation = Producto.class))
                    }),
                    @ApiResponse(responseCode = "404", description = "Producto no encontrado", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Error Interno de Servidor", content = @Content)
            }
    )
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
