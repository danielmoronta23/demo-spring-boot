package com.example.demo.service;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
public abstract class CrudBasico<T, ID> implements ICrud<T, ID> {
    public abstract JpaRepository<T, ID> getDao();

    @Override
    public T crearActualizar(T entity) {

        try {
            entity = getDao().save(entity);
        } catch (Exception e) {
            // Ha ocurrido una error.
        }
        return entity;
    }


    @Override
    public boolean borrarPorId(ID id) {
        getDao().deleteById(id);
        return false;
    }

    @Override
    public boolean borrar(T entity) {
        return false;
    }

    @Override
    public T buscarPorId(ID id) {
        return null;
    }

    @Override
    public List<T> obtenerTodo(T entity) {
        return getDao().findAll();
    }


}
