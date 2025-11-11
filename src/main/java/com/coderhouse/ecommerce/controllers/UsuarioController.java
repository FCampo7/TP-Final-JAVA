package com.coderhouse.ecommerce.controllers;

import com.coderhouse.ecommerce.entities.Usuario;
import com.coderhouse.ecommerce.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsers(){
        try {
            List<Usuario> users = usuarioService.findAll();
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{usuarioId}")
    public ResponseEntity<Usuario> getUserById(@PathVariable Long usuarioId){
        try {
            Usuario user = usuarioService.findById(usuarioId);
            return ResponseEntity.ok(user);
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Usuario> createUser(@RequestBody Usuario user) {
        try {
            Usuario uCreado = usuarioService.save(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(uCreado);
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/{userId}")
    public ResponseEntity<Usuario> updateUserById(
            @PathVariable Long userId, @RequestBody Usuario userUpdated) {
        try {
            Usuario user = usuarioService.update(userId, userUpdated);
            return ResponseEntity.ok(user);
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
        catch (Exception e) {
            return  ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long userId) {
        try {
            usuarioService.deleteById(userId);
            return ResponseEntity.noContent().build();
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
        catch (Exception e) {
            return  ResponseEntity.internalServerError().build();
        }
    }
}
