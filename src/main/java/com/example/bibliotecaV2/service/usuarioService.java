package com.example.bibliotecaV2.service;
import com.example.bibliotecaV2.model.usuario;
import com.example.bibliotecaV2.repository.usuarioRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class usuarioService {
    @Autowired //Inyectar o sincronizar el repositorio de usuario
    private usuarioRepository repo;

    //Metodo para registarar usuario
    public usuario registrar(usuario u){
        return repo.save(u); //Verificar si el usuario ya existe en la base de datos
    }

    //Metodo que autentica los usuarios
    public Optional<usuario> autenticar(String email, String password){
        return repo.findByEmail(email).filter(u -> u.getPassword().equals(password));
    }
}
