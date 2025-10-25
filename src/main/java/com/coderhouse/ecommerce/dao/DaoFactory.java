package com.coderhouse.ecommerce.dao;

import com.coderhouse.ecommerce.abstracts.Producto;
import com.coderhouse.ecommerce.entities.Administrador;
import com.coderhouse.ecommerce.entities.Usuario;
import jakarta.persistence.EntityManager; // -> Hibernate
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class DaoFactory { //DAO -> DATA ACCESS OBJECT

    @PersistenceContext
    private EntityManager em;


    @Transactional
    public void persistirUsuario(Usuario user) {
        em.persist(user);
    }

    @Transactional
    public void persistirAdministrador(Administrador admin) {
        em.persist(admin);
    }

    @Transactional
    public void persistirProducto(Producto prod) {
        em.persist(prod);
    }

    @Transactional
    public void eliminarAdmin(Administrador admin) {
        em.remove(admin);
    }

    @Transactional
    public void actualizarUsuario(Usuario user) {
        em.merge(user);
    }

//
//    @Transactional
//    public void persistirAlumno(Alumno alumno){
//        em.persist(alumno);
//    }
//
//    @Transactional
//    public void persistirCurso(Curso curso){
//        em.persist(curso);
//    }

}
