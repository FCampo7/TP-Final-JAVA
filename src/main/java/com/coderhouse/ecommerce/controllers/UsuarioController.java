package com.coderhouse.ecommerce.controllers;

import com.coderhouse.ecommerce.entities.Usuario;
import com.coderhouse.ecommerce.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsers(){
        try {
            List<Usuario> users = usuarioRepository.findAll();
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{usuarioId}")
    public ResponseEntity<Usuario> getUserById(@PathVariable Long usuarioId){
        try {
            if(usuarioRepository.existsById(usuarioId)) {
                Usuario user=usuarioRepository.findById(usuarioId).get();
                return ResponseEntity.ok(user);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Usuario> createUser(@RequestBody Usuario user) {
        try {
            Usuario uCreado = usuarioRepository.save(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(uCreado);
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
