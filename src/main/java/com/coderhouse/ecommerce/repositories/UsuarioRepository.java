package com.coderhouse.ecommerce.repositories;

import com.coderhouse.ecommerce.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
