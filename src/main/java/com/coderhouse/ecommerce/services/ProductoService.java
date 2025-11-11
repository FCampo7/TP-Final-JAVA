package com.coderhouse.ecommerce.services;

import com.coderhouse.ecommerce.abstracts.Producto;
import com.coderhouse.ecommerce.entities.Accesorio;
import com.coderhouse.ecommerce.entities.Ropa;
import com.coderhouse.ecommerce.interfaces.CRUDInterface;
import com.coderhouse.ecommerce.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductoService implements CRUDInterface<Producto, Long> {

    @Autowired
    private ProductoRepository repo;

    @Override
    public List<Producto> findAll() {
        return repo.findAll();
    }

    @Override
    public Producto findById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));
    }

    @Override
    public Producto save(Producto newProduct) {
        return repo.save(newProduct);
    }

    @Override
    @Transactional
    public Producto update(Long id, Producto updatedProduct) {
        Producto producto = this.findById(id);

        // Actualiza solo los campos que vienen no nulos o con valor distinto
        if (updatedProduct.getNombre() != null && !updatedProduct.getNombre().isEmpty()) {
            producto.setNombre(updatedProduct.getNombre());
        }
        if (updatedProduct.getPrecio() > 0) {
            producto.setPrecio(updatedProduct.getPrecio());
        }
        if (updatedProduct.getStock() >= 0) {
            producto.setStock(updatedProduct.getStock());
        }

        if (producto instanceof Ropa && updatedProduct instanceof Ropa) {
            Ropa ropa = (Ropa) producto;
            Ropa ropaUpdated = (Ropa) updatedProduct;

            if (ropaUpdated.getTalle() != null && !ropaUpdated.getTalle().isEmpty()) {
                ropa.setTalle(ropaUpdated.getTalle());
            }
            if (ropaUpdated.getColor() != null && !ropaUpdated.getColor().isEmpty()) {
                ropa.setColor(ropaUpdated.getColor());
            }
        }
        else if (producto instanceof Accesorio && updatedProduct instanceof Accesorio) {
            Accesorio acc = (Accesorio) producto;
            Accesorio accUpdated = (Accesorio) updatedProduct;

            if (accUpdated.getMaterial() != null && !accUpdated.getMaterial().isEmpty()) {
                acc.setMaterial(accUpdated.getMaterial());
            }
        }


        return repo.save(producto);
    }

    @Override
    public void deleteById(Long id) {
        if (!repo.existsById(id)) {
            throw new IllegalArgumentException("Producto no encontrado");
        }
        repo.deleteById(id);
    }
}
