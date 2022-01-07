package com.example.demo.repository;

import com.example.demo.model.entities.Autor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long>, PagingAndSortingRepository<Autor, Long> {
    //Optional<Autor> findById(Long id);
    ArrayList<Autor> findByNombre(String nombre);

    Page<Autor> findAll(Pageable pageable);

}
