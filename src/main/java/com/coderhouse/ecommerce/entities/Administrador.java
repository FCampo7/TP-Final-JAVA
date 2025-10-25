package com.coderhouse.ecommerce.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "administradores")
public class Administrador extends Usuario {

    public Administrador(String nombre, String apellido, String email, String password, long DNI, String direccion) {
        super(nombre, apellido, email, password, DNI, direccion);
        this.Rol="Administrador";
    }

    public Administrador(Usuario user) {
        this.ID = user.ID;
        this.Nombre = user.Nombre;
        this.Apellido = user.Apellido;
        this.Email = user.Email;
        this.Direccion = user.Direccion;
        this.DNI = user.DNI;
        this.Password = user.Password;
        this.Rol = "Administrador";
    }

    public void cambiarRol(Usuario usuario, String rol){
        if(!"Administrador".equals(this.Rol)){
            throw new SecurityException("Solo un administrador puede cambiar roles");
        }
        usuario.Rol=rol;
    }
}
