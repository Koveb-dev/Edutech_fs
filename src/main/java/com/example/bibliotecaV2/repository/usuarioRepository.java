package com.example.bibliotecaV2.repository;
import com.example.bibliotecaV2.model.usuario ;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


//Repositorio para la entidad modelo usuario (Tabla) y se extiende con JpaRepository
public interface usuarioRepository extends JpaRepository<usuario, Long> { 
    //Metodo para buscar un usuario por el email
    Optional<usuario> findByEmail(String email);

}
