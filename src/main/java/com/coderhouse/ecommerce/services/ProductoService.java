package com.coderhouse.ecommerce.services;

import com.coderhouse.ecommerce.abstracts.Producto;
import com.coderhouse.ecommerce.dto.ProductoDTO;
import com.coderhouse.ecommerce.entities.Ropa;
import com.coderhouse.ecommerce.interfaces.CRUDInterface;
import com.coderhouse.ecommerce.repositories.ProductoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoService implements CRUDInterface<ProductoDTO, Long> {

    private final ProductoRepository productoRepository;

    @Override
    public List<ProductoDTO> findAll() {
        return productoRepository.findAll()
                .stream()
                .map(ProductoDTO::new)
                .toList();
    }

    @Override
    public ProductoDTO findById(Long id) {
        return productoRepository.findById(id)
                .map(ProductoDTO::new)
                .orElse(null);
    }

    @Override
    public ProductoDTO save(ProductoDTO dto) {
        Producto producto = new Ropa(); // o según tipo
        producto.setNombre(dto.getNombre());
        producto.setPrecio(dto.getPrecio());
        producto.setStock(dto.getStock());
        Producto saved = productoRepository.save(producto);
        return new ProductoDTO(saved);
    }

    @Override
    public ProductoDTO update(Long id, ProductoDTO dto) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        producto.setNombre(dto.getNombre());
        producto.setPrecio(dto.getPrecio());
        producto.setStock(dto.getStock());
        Producto updated = productoRepository.save(producto);
        return new ProductoDTO(updated);
    }

    @Override
    public void deleteById(Long id) {
        productoRepository.deleteById(id);
    }
}
