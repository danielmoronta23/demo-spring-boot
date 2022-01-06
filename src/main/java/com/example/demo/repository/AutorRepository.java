package com.example.demo.repository;

import com.example.demo.model.entities.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
    //Optional<Autor> findById(Long id);
    ArrayList<Autor> findByNombre(String nombre);

}
