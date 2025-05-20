package com.example.bibliotecaV2.model;
import java.util.Optional;
import jakarta.persistence.*;
import lombok.Data;

@Entity //Indica que la clase que estamos creando (usuario) es una entidad u objeto JPA
@Data
public class usuario { //Esta clase se transformará en una tabla en nuestra BBDD MySQL
    @Id //Generar el campo clave primaria en la tabla
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Genera el ID de manera automática
    private Long id;

    private String nombre;
    private String email;
    private String password;

    public static Optional<usuario> map(Object o){ //Metodo automatico para enviar el objeto usuario a la BBDD
        throw new UnsupportedOperationException("Unimplemented method 'map'"); 
    }
}
