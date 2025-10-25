package com.coderhouse.ecommerce.entities;

import jakarta.persistence.*;

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

    /* Getters y Setters */

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public long getDNI() {
        return DNI;
    }

    public void setDNI(long DNI) {
        this.DNI = DNI;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getRol() {
        return Rol;
    }
}
