package com.coderhouse.ecommerce.repositories;

import com.coderhouse.ecommerce.abstracts.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
