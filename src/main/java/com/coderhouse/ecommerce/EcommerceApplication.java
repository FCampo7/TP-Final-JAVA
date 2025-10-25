package com.coderhouse.ecommerce;

import com.coderhouse.ecommerce.dao.DaoFactory;
import com.coderhouse.ecommerce.entities.Accesorio;
import com.coderhouse.ecommerce.entities.Administrador;
import com.coderhouse.ecommerce.entities.Ropa;
import com.coderhouse.ecommerce.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
public class EcommerceApplication implements CommandLineRunner {

    @Autowired // Inyecta Dependencias
    private DaoFactory dao;

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        try {
            Ropa camisa = new Ropa("Camisa", 12.55, 10, "L", "Blanco");
            Accesorio reloj = new Accesorio("Reloj", 100.50, 5, "Metalico");

            Usuario user = new Usuario("Julio", "Perez", "julitoPerez10@gmail.com", passwordEncoder.encode("pass123"), 123425232, "Av. Siempre viva 742");
            Administrador admin = new Administrador("Francisco", "Campo", "fcampo7@hotmail.com", passwordEncoder.encode("mipass12342"), 123124213, "Calle falsa 123");

            dao.persistirUsuario(user);
            dao.persistirAdministrador(admin);
            dao.persistirProducto(camisa);
            dao.persistirProducto(reloj);

            admin.cambiarRol(admin, "Cliente");
            dao.actualizarUsuario(admin);
            dao.eliminarAdmin(admin);
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
