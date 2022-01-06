package com.example.demo.service;

import java.util.List;

public interface ICrud<T, ID> {


    T crearActualizar(T entity);

    T buscarPorId(ID id);

    List<T> obtenerTodo(T entity);

    boolean borrar(T entity);

    boolean borrarPorId(ID id);


}
