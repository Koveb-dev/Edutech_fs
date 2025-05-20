
package com.example.bibliotecaV2.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import java.util.ArrayList;

import com.example.bibliotecaV2.model.Libro;
import com.example.bibliotecaV2.service.LibroService;


@RestController
@RequestMapping("/api/v2/carrito")

public class carritoController {
    private final List<Libro> carrito = new ArrayList<>();


    @Autowired
    private LibroService libroserv;

    @PostMapping("/agregar/{id}")
    public String agregarLibro(@PathVariable int id){
        Libro libro = libroserv.getLibroId(id);
        if(libro!= null){
            carrito.add(libro);
            return "Libro agregado al carrito " + libro.getTitulo();
    }

    



        return "Libro no fue encontrado";
    }
    //Metodo para ver los item del carrito
    @GetMapping()
    public List<Libro> vercarrito() {
        return carrito;
    }
    //Metodo para eliminar items del carrito 
    @DeleteMapping("/eliminar/{id}")
    public String eliminarLibro(@PathVariable int id){
        boolean eliminado = carrito.removeIf(libro -> libro.getId() == id);
        return eliminado ? "Libro eliminado del carrito" : "Libro no estaba en el carrito"; 
    }
    //METODO PARA VACIAR CARRITO 
    @DeleteMapping("/vaciar")
    public String vaciarCarrito() {
        carrito.clear();
        return "Carrito Vaciado";
    }
    //Contar libros en el carrito
    @GetMapping("/total")
    public int totalLibros () {
        return carrito.size();
    }
     

}
