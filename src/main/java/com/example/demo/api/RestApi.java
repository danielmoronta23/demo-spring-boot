package com.example.demo.api;


import com.example.demo.model.entities.Autor;
import com.example.demo.service.AutorService;
import com.example.demo.service.ClaseObejecto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;


import static com.example.demo.service.ClaseObejecto.crearNuevoResultado;

@RestController
@RequestMapping("api")
public class RestApi {
    // Llamando servicio.

    @Autowired//Inyeccion de depencia.
    private AutorService autorService;


    public Autor agregar(Autor autor) {
        return this.autorService.crearActualizar(autor);
    }

    public Autor buscar(Long id) {
        return autorService.buscarPorId(id);
    }

    public ArrayList<Autor> buscarPorNombre(String nombre) {
        return autorService.findByNombre(nombre);
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<ClaseObejecto> obtenerTodosLibros() {
        Autor a = agregar(new Autor("Daniel"));// Simulando datos...
        return new ResponseEntity<>(crearNuevoResultado(this.autorService.getDao().findAll()), HttpStatus.OK);
    }

}
