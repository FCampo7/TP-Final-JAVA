package com.coderhouse.ecommerce.dao;

import com.coderhouse.ecommerce.abstracts.Producto;
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
    public void persistirProducto(Producto prod) {
        em.persist(prod);
    }

    @Transactional
    public void actualizarUsuario(Usuario user) {
        em.merge(user);
    }

}
