package com.coderhouse.ecommerce.controllers;

import com.coderhouse.ecommerce.dto.UsuarioDTO;
import com.coderhouse.ecommerce.entities.Usuario;
import com.coderhouse.ecommerce.services.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/usuarios")
@Tag(name = "Gestión de Usuarios", description = "Endpoints para gestionar usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Operation(summary = "Obtener la lista de todos los usuarios")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Lista de Usuarios obtenida correctamente", content = {@Content(mediaType = "Aplication/json", schema = @Schema(implementation = UsuarioDTO.class))}),
                    @ApiResponse(responseCode = "500", description = "Error Interno de Servidor", content = @Content)
            }
    )
    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> getAllUsers(){
        try {
            List<Usuario> users = usuarioService.findAll();
            List<UsuarioDTO> usersDTO = users.stream()
                    .map(UsuarioDTO::new)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(usersDTO);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @Operation(summary = "Obtener un Usuario por su ID")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorno correcto de Usuario con ID especificado", content = {
                            @Content(mediaType = "Aplication/json", schema = @Schema(implementation = UsuarioDTO.class))
                    }),
                    @ApiResponse(responseCode = "404", description = "Usuario no encontrado", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Error Interno de Servidor", content = @Content)
            }
    )
    @GetMapping("/{usuarioId}")
    public ResponseEntity<UsuarioDTO> getUserById(@PathVariable Long usuarioId){
        try {
            Usuario user = usuarioService.findById(usuarioId);
            return ResponseEntity.ok(new UsuarioDTO(user));
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @Operation(summary = "Crear un Usuario")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "Usuario creado correctamente", content = {
                            @Content(mediaType = "Aplication/json", schema = @Schema(implementation = UsuarioDTO.class))
                    }),
                    @ApiResponse(responseCode = "500", description = "Error Interno de Servidor", content = @Content)
            }
    )
    @PostMapping("/create")
    public ResponseEntity<UsuarioDTO> createUser(@RequestBody Usuario user) {
        try {
            Usuario uCreado = usuarioService.save(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(new UsuarioDTO(uCreado));
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @Operation(summary = "Actualizar un Usuario por su ID")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Usuario actualizado correctamente", content = {
                            @Content(mediaType = "Aplication/json", schema = @Schema(implementation = UsuarioDTO.class))
                    }),
                    @ApiResponse(responseCode = "404", description = "Usuario no encontrado", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Error Interno de Servidor", content = @Content)
            }
    )
    @PutMapping("/{userId}")
    public ResponseEntity<UsuarioDTO> updateUserById(
            @PathVariable Long userId, @RequestBody Usuario userUpdated) {
        try {
            Usuario user = usuarioService.update(userId, userUpdated);
            return ResponseEntity.ok(new UsuarioDTO(user));
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
        catch (Exception e) {
            return  ResponseEntity.internalServerError().build();
        }
    }

    @Operation(summary = "Eliminar un Usuario por su ID")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Usuario eliminado correctamente", content = {
                            @Content(mediaType = "Aplication/json", schema = @Schema(implementation = UsuarioDTO.class))
                    }),
                    @ApiResponse(responseCode = "404", description = "Usuario no encontrado", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Error Interno de Servidor", content = @Content)
            }
    )
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
