package com.coderhouse.ecommerce.services;

import com.coderhouse.ecommerce.interfaces.CRUDInterface;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;

@Transactional
public abstract class CRUDService<T, ID> implements CRUDInterface<T, ID> {

    @PersistenceContext
    protected EntityManager em;

    private final Class<T> entityClass;

    protected CRUDService(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public List<T> findAll() {
        return em.createQuery("FROM " + entityClass.getSimpleName(), entityClass).getResultList();
    }

    @Override
    public T findById(ID id) {
        return em.find(entityClass, id);
    }

    @Override
    public T save(T entity) {
        em.persist(entity);
        return entity;
    }

    @Override
    public T update(ID id, T entity) {
        // En un proyecto real podrías validar si existe antes de hacer merge
        return em.merge(entity);
    }

    @Override
    public void deleteById(ID id) {
        T entity = em.find(entityClass, id);
        if (entity != null) em.remove(entity);
    }
}
