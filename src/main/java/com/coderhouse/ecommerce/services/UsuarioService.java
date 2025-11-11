package com.coderhouse.ecommerce.services;

import com.coderhouse.ecommerce.entities.Usuario;
import com.coderhouse.ecommerce.interfaces.CRUDInterface;
import com.coderhouse.ecommerce.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioService implements CRUDInterface<Usuario, Long> {

    @Autowired
    private UsuarioRepository repo;

    @Override
    public List<Usuario> findAll() {
        return repo.findAll();
    }

    @Override
    public Usuario findById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
    }

    @Override
    public Usuario save(Usuario newUser) {
        return repo.save(newUser);
    }

    @Override
    @Transactional
    public Usuario update(Long id, Usuario userUpdated) {
        Usuario user = this.findById(id);

        if(userUpdated.getNombre() != null && !userUpdated.getNombre().isEmpty()) {
            user.setNombre(userUpdated.getNombre());
        }
        if(userUpdated.getApellido() != null && !userUpdated.getApellido().isEmpty()) {
            user.setApellido(userUpdated.getApellido());
        }
        if(userUpdated.getDNI() != 0) {
            user.setDNI(userUpdated.getDNI());
        }
        if(userUpdated.getDireccion() != null && !userUpdated.getDireccion().isEmpty()) {
            user.setDireccion(userUpdated.getDireccion());
        }
        if(userUpdated.getEmail() != null && !userUpdated.getEmail().isEmpty()) {
            user.setEmail(userUpdated.getEmail());
        }
        if(userUpdated.getPassword() != null && !userUpdated.getPassword().isEmpty()) {
            user.setPassword(userUpdated.getPassword());
        }
        if(userUpdated.getRol() != null && !userUpdated.getRol().isEmpty()) {
            user.setRol(userUpdated.getRol());
        }

        return repo.save(user);
    }

    @Override
    public void deleteById(Long id) {
        if(!repo.existsById(id)) {
            throw new IllegalArgumentException("Usuario no encontrado");
        }
        repo.deleteById(id);
    }
}
