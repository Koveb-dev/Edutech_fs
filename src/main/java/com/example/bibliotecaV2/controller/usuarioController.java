package com.example.bibliotecaV2.controller;
import com.example.bibliotecaV2.model.usuario;
import com.example.bibliotecaV2.service.usuarioService;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/usuarios") //URL base para las peticiones HTTP
@CrossOrigin //Permite peticiones de cualquier origen
public class usuarioController {
    @Autowired
    private usuarioService serv;

    //Metodo que permite registrar un usuario en la tabla usuario
    @PostMapping("/registrar") 
    public usuario registrar(@RequestBody usuario u){
        return serv.registrar(u);
    }

    //Metodo para autenticar usuario
    @PostMapping("/login")
    public Map<String, String> login (@RequestBody usuario u){
        Optional<usuario> user = serv.autenticar(u.getEmail(), u.getPassword());
        Map<String, String> response = new HashMap<>();
        if (user.isPresent()){
            response.put("result", "OK");
            response.put("nombre", user.get().getNombre());
        } else {
            response.put("result", "ERROR");
        }
        return response;
    }
}
