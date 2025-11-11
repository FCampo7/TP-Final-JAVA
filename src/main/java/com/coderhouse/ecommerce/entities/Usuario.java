package com.coderhouse.ecommerce.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long ID;

    @Column(name = "nombre", nullable = false)
    protected String Nombre;

    @Column(name = "apellido", nullable = false)
    protected String Apellido;

    @Column(name = "email", nullable = false, unique = true)
    protected String Email;

    @Column(name = "password", nullable = false)
    protected String Password;

    @Column(name = "dni", nullable = false, unique = true)
    protected long DNI;

    @Column(name = "direccion", nullable = false)
    protected String Direccion;

    @Column(name = "rol", nullable = false)
    protected String Rol; //Rol puede ser Cliente o Administrador

    /* Constructores */

    public Usuario() {
        this.Rol="Cliente";
    }

    public Usuario(String nombre, String apellido, String email, String password, long DNI, String direccion) {
        this.Nombre = nombre;
        this.Apellido = apellido;
        this.Email = email;
        this.Password = password;
        this.DNI = DNI;
        this.Direccion = direccion;
        this.Rol="Cliente";
    }

}
