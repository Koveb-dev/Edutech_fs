package com.example.bibliotecaV2.service;

import com.example.bibliotecaV2.model.Libro;
import com.example.bibliotecaV2.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LibroService {
    @Autowired
    private LibroRepository libroRepository;

    public List<Libro> getLibros() {
        return libroRepository.obtenerLibros();
    }

    public Libro saveLibro(Libro libro) {
        return libroRepository.guardar(libro);
    }

    public Libro getLibroId(int id) {
        return libroRepository.buscarPorId(id);
    }

    public Libro updateLibro(Libro libro) {
        return libroRepository.actualizar(libro);
    }

    public String deleteLibro(int id) {
        libroRepository.eliminar(id);
        return "producto eliminado";
    }

    // LA ACCIÓN LA HACE EL SERVICE
    public int totalLibros() {
        return libroRepository.obtenerLibros().size();
    }

    // LA ACCIÓN LA HACE EL MODELO
    public int totalLibrosV2() {
        return libroRepository.totalLibros();
    }
}
