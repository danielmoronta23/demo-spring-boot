package com.example.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICrud<T, ID> {


    T crearActualizar(T entity);

    T buscarPorId(ID id);

    List<T> obtenerTodo();

    boolean borrar(T entity);

    boolean borrarPorId(ID id);

    Page<T> obterResultadoPaginado(Pageable pageable);



}
