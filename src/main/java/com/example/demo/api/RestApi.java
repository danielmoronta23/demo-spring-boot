package com.example.demo.api;


import com.example.demo.model.entities.Autor;
import com.example.demo.service.AutorService;
import com.example.demo.service.ClaseObejecto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
        //  Autor a = agregar(new Autor("Daniel"));// Simulando datos...
        // Clase ModelAndView
        //  autorService.findAll();
        // autorService.
        return new ResponseEntity<>(crearNuevoResultado(autorService.obtenerTodo()), HttpStatus.OK);
    }

    /**
     * Metodo que permite hacer una paginación de los resultados.
     * Referencia: https://docs.spring.io/spring-data/rest/docs/current/reference/html/#paging-and-sorting
     *
     * @param pageable
     * @return
     */
    @GetMapping(path = "/resultadoPaginado", produces = "application/json")
    public ResponseEntity<ClaseObejecto> obtenerLibroPaginado(Pageable pageable) {
        agregar(new Autor("Daniel"));// Simulando datos...

        // System.out.println("\n Tamano de la pagina: "+pageable.getPageSize());
        // String sort ="id";
        // PageRequest.of(1,2).withSort(Sort.by(sort));
        // return new ResponseEntity<>(crearNuevoResultado(autorService.obtenerAutorPaginado(PageRequest.of((int) pageable.getOffset(),pageable.getPageSize()).withSort(Sort.by(sort).descending()))), HttpStatus.OK);

         // return new ResponseEntity<>(crearNuevoResultado(autorService.obtenerAutorPaginado(pageable)), HttpStatus.OK);

        //Otra forma...
        //Este meto resulta mucho mejor de acuerdo a las pruebas.
        return new ResponseEntity<>(crearNuevoResultado(autorService.obterResultadoPaginado(pageable)), HttpStatus.OK);
    }

}
