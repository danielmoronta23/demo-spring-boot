package com.example.demo.service;

import com.example.demo.model.entities.Autor;
import com.example.demo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AutorService extends CrudBasico<Autor, Long> {

    @Autowired
    private AutorRepository autorRepository;


    @Override
    public JpaRepository<Autor, Long> getDao() {
        return autorRepository;
    }

    public ArrayList<Autor> findByNombre(String nombre){
        return autorRepository.findByNombre(nombre);

    }


}
